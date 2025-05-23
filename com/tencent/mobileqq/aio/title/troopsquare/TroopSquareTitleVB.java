package com.tencent.mobileqq.aio.title.troopsquare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.troopsquare.TroopSquareUIState;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00017B3\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020\n\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050'\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010%\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopsquare/TroopSquareTitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/mobileqq/aio/title/troopsquare/TroopSquareUIState;", "Ln81/a;", "", NodeProps.VISIBLE, "", "g1", "isShowRedpoint", "", "entryContent", "ext", "i1", "elementId", "entryContext", "e1", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "d1", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", "d", "Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewStub;", "e", "Landroid/view/ViewStub;", "viewStub", "f", "Ljava/lang/String;", "vbStr", "Lkotlin/Function1;", h.F, "Lkotlin/jvm/functions/Function1;", "requestShow", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "extInfo", BdhLogUtil.LogTag.Tag_Conn, "Z", "D", "<init>", "(Lcom/tencent/mobileqq/aio/widget/AIOTitleRelativeLayout;Landroid/view/ViewStub;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TroopSquareTitleVB extends com.tencent.aio.base.mvvm.a<Object, TroopSquareUIState> implements n81.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isShowRedpoint;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String entryContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOTitleRelativeLayout parent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewStub viewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String vbStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Boolean> requestShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String extInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopsquare/TroopSquareTitleVB$a;", "", "", "DIFF_WORD", "Ljava/lang/String;", "ELEMENT_ID", "IS_RED", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.title.troopsquare.TroopSquareTitleVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTitleVB(@NotNull AIOTitleRelativeLayout parent, @NotNull ViewStub viewStub, @NotNull String vbStr, @NotNull Function1<? super String, Boolean> requestShow) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        Intrinsics.checkNotNullParameter(vbStr, "vbStr");
        Intrinsics.checkNotNullParameter(requestShow, "requestShow");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, parent, viewStub, vbStr, requestShow);
            return;
        }
        this.parent = parent;
        this.viewStub = viewStub;
        this.vbStr = vbStr;
        this.requestShow = requestShow;
        this.extInfo = "";
        this.entryContent = "";
    }

    private final void e1(String elementId, boolean isShowRedpoint, String entryContext) {
        Map mapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("is_red", Integer.valueOf(isShowRedpoint ? 1 : 0));
        if (Intrinsics.areEqual(entryContext, "")) {
            entryContext = "\u7fa4\u5e7f\u573a";
        }
        pairArr[1] = TuplesKt.to("diff_word", entryContext);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.aio.utils.b.l(elementId, mapOf);
    }

    private final void f1(String elementId, boolean isShowRedpoint, String entryContext) {
        HashMap hashMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("is_red", Integer.valueOf(isShowRedpoint ? 1 : 0));
        if (Intrinsics.areEqual(entryContext, "")) {
            entryContext = "\u7fa4\u5e7f\u573a";
        }
        pairArr[1] = TuplesKt.to("diff_word", entryContext);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        com.tencent.mobileqq.aio.utils.b.q(elementId, hashMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View] */
    private final void g1(boolean visible) {
        boolean z16;
        ViewGroup viewGroup;
        if (visible && this.requestShow.invoke(this.vbStr).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewGroup viewGroup2 = this.container;
        if (viewGroup2 != null) {
            Boolean valueOf = Boolean.valueOf(z16);
            viewGroup2.setVisibility(0);
            ?? r06 = (View) au.a(valueOf, viewGroup2);
            if (r06 == 0) {
                viewGroup2.setVisibility(8);
            } else {
                viewGroup2 = r06;
            }
        }
        if (z16) {
            f1("em_group_square", this.isShowRedpoint, this.entryContent);
        }
        if (visible && this.container == null) {
            this.viewStub.setLayoutInflater(LayoutInflater.from(this.parent.getContext()));
            View inflate = this.viewStub.inflate();
            if (inflate instanceof ViewGroup) {
                viewGroup = (ViewGroup) inflate;
            } else {
                viewGroup = null;
            }
            this.container = viewGroup;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.troopsquare.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopSquareTitleVB.h1(TroopSquareTitleVB.this, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(TroopSquareTitleVB this$0, View view) {
        FrameworkVM mUIModel;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("TroopSquareTitleEntry") && (mUIModel = this$0.getMUIModel()) != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j3 = c16.j()) != null) {
            ((ITroopApi) QRoute.api(ITroopApi.class)).openTroopSquarePage(j3, this$0.extInfo);
            this$0.e1("em_group_square", this$0.isShowRedpoint, this$0.entryContent);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TroopSquareTitleVB$updateEntryVisible$1$1(this$0, null), 3, null);
            ((ITroopApi) QRoute.api(ITroopApi.class)).clearGroupSquareRedpointCache(Long.parseLong(j3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(boolean isShowRedpoint, String entryContent, String ext) {
        this.isShowRedpoint = isShowRedpoint;
        this.entryContent = entryContent;
        this.extInfo = ext;
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.f1036961a);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.troop_square_red_dot)");
            QUIBadge qUIBadge = (QUIBadge) findViewById;
            View findViewById2 = viewGroup.findViewById(R.id.f1037061b);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.troop_square_text)");
            SingleLineTextView singleLineTextView = (SingleLineTextView) findViewById2;
            boolean z16 = false;
            if (isShowRedpoint) {
                qUIBadge.setVisibility(0);
            } else {
                qUIBadge.setVisibility(8);
            }
            if (entryContent.length() > 0) {
                z16 = true;
            }
            if (z16) {
                singleLineTextView.setText(entryContent);
            } else {
                singleLineTextView.setText("\u7fa4\u5e7f\u573a");
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<Object, TroopSquareUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TroopSquareUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof TroopSquareUIState.EntryVisible) {
            g1(((TroopSquareUIState.EntryVisible) state).a());
        } else if (state instanceof TroopSquareUIState.GroupSquareRedpointUIState) {
            TroopSquareUIState.GroupSquareRedpointUIState groupSquareRedpointUIState = (TroopSquareUIState.GroupSquareRedpointUIState) state;
            i1(groupSquareRedpointUIState.c(), groupSquareRedpointUIState.a(), groupSquareRedpointUIState.b());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.viewStub;
    }

    @Override // n81.a
    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
