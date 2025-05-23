package com.tencent.mobileqq.aio.input.at.common;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001;\u0018\u0000 E*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001FB\u0015\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\"\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J.\u0010\u001b\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u0014J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 0\u001fH\u0016R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00106R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/i;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Landroid/widget/PopupWindow;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "i", "g", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "e", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "itemData", "f", "d", "k", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "l", "", VideoTemplateParser.ITEM_LIST, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Pair;", "", "", "index", DomainData.DOMAIN_NAME, "dismiss", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "c", "()Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Lcom/tencent/mobileqq/aio/input/at/common/ListDialogGestureLayout;", "Lcom/tencent/mobileqq/aio/input/at/common/ListDialogGestureLayout;", "mGestureLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mScrollLayout", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "mContentLayout", "", "Lcom/tencent/mobileqq/aio/input/at/common/component/a;", "Ljava/util/List;", "mComponentList", "", "Z", "mIsShow", BdhLogUtil.LogTag.Tag_Conn, "I", "windowXLocationOffset", "com/tencent/mobileqq/aio/input/at/common/i$b", "D", "Lcom/tencent/mobileqq/aio/input/at/common/i$b;", "mGestureListener", "Landroid/view/View$OnLayoutChangeListener;", "E", "Landroid/view/View$OnLayoutChangeListener;", "mOnLayoutListener", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", UserInfo.SEX_FEMALE, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i<T extends c> extends PopupWindow implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int G;

    /* renamed from: C, reason: from kotlin metadata */
    private int windowXLocationOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mGestureListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mOnLayoutListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ListDialogGestureLayout<T> mGestureLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mScrollLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContentLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.aio.input.at.common.component.a> mComponentList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/i$a;", "", "", "TAG", "Ljava/lang/String;", "", "WINDOW_BACKGROUND_MASK_COLOR", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.i$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/input/at/common/i$b", "Lcom/tencent/mobileqq/aio/input/at/common/d;", "", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f189290a;

        b(i<T> iVar) {
            this.f189290a = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.at.common.d
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f189290a.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53376);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            G = Color.argb(104, 0, 0, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull j<T> mDialogContext) {
        super(new ListDialogGestureLayout(mDialogContext), -1, -1);
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mComponentList = new ArrayList();
        this.mGestureListener = new b(this);
        this.mOnLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.input.at.common.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                i.j(i.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }

    private final void d(com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        this.mDialogContext.d().b(itemData);
    }

    private final void e() {
        dismiss();
    }

    private final void f(com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        this.mDialogContext.d().a(itemData);
        if (!this.mDialogContext.g()) {
            dismiss();
        }
    }

    private final void g() {
        View contentView = getContentView();
        Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.at.common.ListDialogGestureLayout<T of com.tencent.mobileqq.aio.input.at.common.ListDialog>");
        ListDialogGestureLayout<T> listDialogGestureLayout = (ListDialogGestureLayout) contentView;
        listDialogGestureLayout.setOrientation(1);
        listDialogGestureLayout.setGestureListener(this.mGestureListener);
        listDialogGestureLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.at.common.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.h(i.this, view);
            }
        });
        this.mGestureLayout = listDialogGestureLayout;
        int i3 = x.f(BaseApplication.getContext()).f185861b;
        LinearLayout linearLayout = new LinearLayout(this.mDialogContext.c());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(this.mDialogContext.a().getWidth(), i3));
        o81.b.c(linearLayout, this.mDialogContext.b().c());
        linearLayout.setBackgroundResource(R.drawable.jv6);
        ListDialogGestureLayout<T> listDialogGestureLayout2 = this.mGestureLayout;
        RelativeLayout relativeLayout = null;
        if (listDialogGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
            listDialogGestureLayout2 = null;
        }
        listDialogGestureLayout2.addView(linearLayout);
        this.mScrollLayout = linearLayout;
        com.tencent.mobileqq.aio.input.at.common.component.e eVar = new com.tencent.mobileqq.aio.input.at.common.component.e(this.mDialogContext);
        this.mComponentList.add(eVar);
        LinearLayout linearLayout2 = this.mScrollLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollLayout");
            linearLayout2 = null;
        }
        LinearLayout linearLayout3 = this.mScrollLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollLayout");
            linearLayout3 = null;
        }
        linearLayout2.addView(eVar.e(linearLayout3));
        eVar.d();
        RelativeLayout relativeLayout2 = new RelativeLayout(this.mDialogContext.c());
        relativeLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinearLayout linearLayout4 = this.mScrollLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollLayout");
            linearLayout4 = null;
        }
        linearLayout4.addView(relativeLayout2);
        this.mContentLayout = relativeLayout2;
        com.tencent.mobileqq.aio.input.at.common.component.c cVar = new com.tencent.mobileqq.aio.input.at.common.component.c(this.mDialogContext);
        this.mComponentList.add(cVar);
        RelativeLayout relativeLayout3 = this.mContentLayout;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
            relativeLayout3 = null;
        }
        RelativeLayout relativeLayout4 = this.mContentLayout;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
            relativeLayout4 = null;
        }
        relativeLayout3.addView(cVar.k(relativeLayout4));
        cVar.j();
        com.tencent.mobileqq.aio.input.at.common.component.b bVar = new com.tencent.mobileqq.aio.input.at.common.component.b(this.mDialogContext);
        this.mComponentList.add(bVar);
        RelativeLayout relativeLayout5 = this.mContentLayout;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
            relativeLayout5 = null;
        }
        View f16 = bVar.f(relativeLayout5);
        if (f16.getParent() == null) {
            RelativeLayout relativeLayout6 = this.mContentLayout;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
            } else {
                relativeLayout = relativeLayout6;
            }
            relativeLayout.addView(f16);
        }
        bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setFocusable(this.mDialogContext.b().g());
        setInputMethodMode(this.mDialogContext.b().e());
        setBackgroundDrawable(new ColorDrawable(G));
        int[] iArr = new int[2];
        this.mDialogContext.a().getLocationInWindow(iArr);
        this.windowXLocationOffset = iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(i this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(view, this$0.mDialogContext.a())) {
            int[] iArr = new int[2];
            this$0.mDialogContext.a().getLocationInWindow(iArr);
            if (iArr[0] != this$0.windowXLocationOffset) {
                this$0.dismiss();
            } else if (iArr[1] != this$0.getHeight()) {
                this$0.p();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o() {
        int a16;
        int i3;
        ListDialogGestureLayout<T> listDialogGestureLayout;
        if (this.mDialogContext.f()) {
            Iterator<T> it = this.mComponentList.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                i16 += ((com.tencent.mobileqq.aio.input.at.common.component.a) it.next()).a();
            }
            if (i16 - getHeight() > (-this.mDialogContext.b().a())) {
                a16 = this.mDialogContext.b().a();
            } else {
                i3 = i16 - getHeight();
                ListDialogGestureLayout<T> listDialogGestureLayout2 = null;
                if (this.mDialogContext.f()) {
                    ListDialogGestureLayout<T> listDialogGestureLayout3 = this.mGestureLayout;
                    if (listDialogGestureLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
                        listDialogGestureLayout3 = null;
                    }
                    listDialogGestureLayout3.setCommonScrollYInHalfMode(i3);
                }
                listDialogGestureLayout = this.mGestureLayout;
                if (listDialogGestureLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
                    listDialogGestureLayout = null;
                }
                if (listDialogGestureLayout.getScrollY() == i3) {
                    ListDialogGestureLayout<T> listDialogGestureLayout4 = this.mGestureLayout;
                    if (listDialogGestureLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
                    } else {
                        listDialogGestureLayout2 = listDialogGestureLayout4;
                    }
                    listDialogGestureLayout2.p(i3, false);
                    return;
                }
                return;
            }
        } else {
            a16 = this.mDialogContext.b().a();
        }
        i3 = -a16;
        ListDialogGestureLayout<T> listDialogGestureLayout22 = null;
        if (this.mDialogContext.f()) {
        }
        listDialogGestureLayout = this.mGestureLayout;
        if (listDialogGestureLayout == null) {
        }
        if (listDialogGestureLayout.getScrollY() == i3) {
        }
    }

    private final void p() {
        q();
        o();
    }

    private final void q() {
        boolean z16;
        int[] iArr = new int[2];
        this.mDialogContext.a().getLocationInWindow(iArr);
        int height = this.mDialogContext.a().getRootView().getHeight();
        if (iArr[1] < height * 0.5625f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mDialogContext.f() != z16) {
            QLog.i("ListDialog", 1, "[updateWindow] setDisplayMode. isHalf:" + z16 + ", locations_y:" + iArr[1] + ", windowHeight:" + height);
            this.mDialogContext.h(z16);
            Iterator<T> it = this.mComponentList.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.aio.input.at.common.component.a) it.next()).b(z16);
            }
        }
        if (iArr[1] != getHeight()) {
            update(this.windowXLocationOffset, 0, getWidth(), iArr[1], true);
            RelativeLayout relativeLayout = this.mContentLayout;
            RelativeLayout relativeLayout2 = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
                relativeLayout = null;
            }
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = ((iArr[1] - ViewUtils.dpToPx(57.0f)) - this.mDialogContext.b().a()) - this.mDialogContext.b().c();
            RelativeLayout relativeLayout3 = this.mContentLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentLayout");
            } else {
                relativeLayout2 = relativeLayout3;
            }
            relativeLayout2.setLayoutParams(layoutParams);
        }
    }

    @NotNull
    public final j<T> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mDialogContext;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.dismiss();
        this.mDialogContext.a().removeOnLayoutChangeListener(this.mOnLayoutListener);
        this.mIsShow = false;
        this.mDialogContext.d().onDismiss();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(MultiSelectCompleteEvent.class);
        arrayList.add(SelectItemEvent.class);
        arrayList.add(CancelSelectItemEvent.class);
        return arrayList;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        i();
        g();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mDialogContext.a().getWindowToken() == null) {
            QLog.e("ListDialog", 1, "anchor windowToken is null");
            return;
        }
        this.mDialogContext.a().addOnLayoutChangeListener(this.mOnLayoutListener);
        ListDialogGestureLayout<T> listDialogGestureLayout = null;
        if (getHeight() > 0) {
            ListDialogGestureLayout<T> listDialogGestureLayout2 = this.mGestureLayout;
            if (listDialogGestureLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
            } else {
                listDialogGestureLayout = listDialogGestureLayout2;
            }
            listDialogGestureLayout.scrollTo(0, -getHeight());
        } else {
            int[] iArr = new int[2];
            this.mDialogContext.a().getLocationInWindow(iArr);
            ListDialogGestureLayout<T> listDialogGestureLayout3 = this.mGestureLayout;
            if (listDialogGestureLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureLayout");
            } else {
                listDialogGestureLayout = listDialogGestureLayout3;
            }
            listDialogGestureLayout.scrollTo(0, -iArr[1]);
        }
        p();
        this.mDialogContext.d().onShow();
        showAtLocation(this.mDialogContext.a(), 0, this.windowXLocationOffset, 0);
        this.mIsShow = true;
    }

    public final void m(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) itemList);
            return;
        }
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        SimpleEventBus.getInstance().dispatchEvent(new SubmitListEvent(itemList));
        if (!this.mIsShow) {
            l();
        } else {
            o();
        }
    }

    public final void n(@NotNull List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList, @NotNull List<Pair<String, Integer>> index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) itemList, (Object) index);
            return;
        }
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(index, "index");
        m(itemList);
        SimpleEventBus.getInstance().dispatchEvent(new InitIndexEvent(index));
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<T> it = this.mComponentList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.input.at.common.component.a) it.next()).onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
            return;
        }
        if (event instanceof MultiSelectCompleteEvent) {
            e();
        } else if (event instanceof SelectItemEvent) {
            f(((SelectItemEvent) event).getItemData());
        } else if (event instanceof CancelSelectItemEvent) {
            d(((CancelSelectItemEvent) event).getItemData());
        }
    }
}
