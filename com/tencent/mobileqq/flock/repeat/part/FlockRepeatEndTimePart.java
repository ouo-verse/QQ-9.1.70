package com.tencent.mobileqq.flock.repeat.part;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.flock.publish.viewmodel.n;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart$pickerSheetBottomConfig$2;
import com.tencent.mobileqq.flock.widget.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001'\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/ViewGroup;", VipFunCallConstants.KEY_GROUP, "", "D9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/repeat/b;", "d", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/flock/repeat/b;", "viewModel", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "e", "F9", "()Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "leftConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "f", "H9", "()Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "rightConfig", "", h.F, "E9", "()I", "itemDividerHeight", "Lcom/tencent/mobileqq/flock/publish/viewmodel/n;", "i", "Lcom/tencent/mobileqq/flock/publish/viewmodel/n;", "timeRepository", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "endTimeItem", "com/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart$pickerSheetBottomConfig$2$a", BdhLogUtil.LogTag.Tag_Conn, "G9", "()Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart$pickerSheetBottomConfig$2$a;", "pickerSheetBottomConfig", "<init>", "()V", "D", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockRepeatEndTimePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy pickerSheetBottomConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy leftConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rightConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy itemDividerHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private n timeRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineListItem endTimeItem;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart$b", "Lcom/tencent/mobileqq/flock/widget/g$c;", "", "onDismiss", "", "", "selectItems", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements g.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockRepeatEndTimePart.this);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void a(@NotNull List<Integer> selectItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
                return;
            }
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            n nVar = FlockRepeatEndTimePart.this.timeRepository;
            n nVar2 = null;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
                nVar = null;
            }
            FlockRepeatEndTimePart.this.I9().U1(nVar.a(selectItems));
            n nVar3 = FlockRepeatEndTimePart.this.timeRepository;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            } else {
                nVar2 = nVar3;
            }
            nVar2.f(selectItems);
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48956);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockRepeatEndTimePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.repeat.b>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockRepeatEndTimePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.repeat.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.repeat.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockRepeatEndTimePart flockRepeatEndTimePart = FlockRepeatEndTimePart.this;
                    Intent intent = flockRepeatEndTimePart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.d(flockRepeatEndTimePart, intent);
                }
            });
            this.viewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(FlockRepeatEndTimePart$leftConfig$2.INSTANCE);
            this.leftConfig = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(FlockRepeatEndTimePart$rightConfig$2.INSTANCE);
            this.rightConfig = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(FlockRepeatEndTimePart$itemDividerHeight$2.INSTANCE);
            this.itemDividerHeight = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FlockRepeatEndTimePart$pickerSheetBottomConfig$2.a>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart$pickerSheetBottomConfig$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/repeat/part/FlockRepeatEndTimePart$pickerSheetBottomConfig$2$a", "Lcom/tencent/mobileqq/flock/widget/g$a;", "", "a", "", "b", "", "c", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes12.dex */
                public static final class a implements g.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlockRepeatEndTimePart f210392a;

                    a(FlockRepeatEndTimePart flockRepeatEndTimePart) {
                        this.f210392a = flockRepeatEndTimePart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) flockRepeatEndTimePart);
                        }
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public boolean a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                        }
                        return true;
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public int b() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                        }
                        return R.string.f199184oq;
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public void c() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this);
                        } else {
                            this.f210392a.I9().U1(null);
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockRepeatEndTimePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(FlockRepeatEndTimePart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pickerSheetBottomConfig = lazy5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void D9(ViewGroup group) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View view = null;
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null, 2, null);
        qUISingleLineListItem.setStyle(QUIListItemStyle.FullWidth);
        qUISingleLineListItem.setConfig(F9(), H9());
        i.d(qUISingleLineListItem, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart$addRepeatEndTimeUi$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockRepeatEndTimePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FlockRepeatEndTimePart.this.L9();
                }
            }
        }, 1, null);
        this.endTimeItem = qUISingleLineListItem;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.setMargins(0, E9(), 0, 0);
        QUISingleLineListItem qUISingleLineListItem2 = this.endTimeItem;
        if (qUISingleLineListItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeItem");
            qUISingleLineListItem2 = null;
        }
        qUISingleLineListItem2.setVisibility(8);
        View view2 = this.endTimeItem;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeItem");
        } else {
            view = view2;
        }
        group.addView(view, marginLayoutParams);
    }

    private final int E9() {
        return ((Number) this.itemDividerHeight.getValue()).intValue();
    }

    private final x.b.d F9() {
        return (x.b.d) this.leftConfig.getValue();
    }

    private final FlockRepeatEndTimePart$pickerSheetBottomConfig$2.a G9() {
        return (FlockRepeatEndTimePart$pickerSheetBottomConfig$2.a) this.pickerSheetBottomConfig.getValue();
    }

    private final x.c.g H9() {
        return (x.c.g) this.rightConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.flock.repeat.b I9() {
        return (com.tencent.mobileqq.flock.repeat.b) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(FlockRepeatEndTimePart this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x.c.g H9 = this$0.H9();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        H9.h(it);
        QUISingleLineListItem qUISingleLineListItem = this$0.endTimeItem;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeItem");
            qUISingleLineListItem = null;
        }
        qUISingleLineListItem.setConfig(this$0.F9(), this$0.H9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(FlockRepeatEndTimePart this$0, FlockRepeatType flockRepeatType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineListItem qUISingleLineListItem = this$0.endTimeItem;
        QUISingleLineListItem qUISingleLineListItem2 = null;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeItem");
            qUISingleLineListItem = null;
        }
        FlockRepeatType flockRepeatType2 = FlockRepeatType.NONE;
        int i3 = 0;
        if (flockRepeatType != flockRepeatType2) {
            z16 = true;
        } else {
            z16 = false;
        }
        qUISingleLineListItem.setEnabled(z16);
        QUISingleLineListItem qUISingleLineListItem3 = this$0.endTimeItem;
        if (qUISingleLineListItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endTimeItem");
        } else {
            qUISingleLineListItem2 = qUISingleLineListItem3;
        }
        if (flockRepeatType == flockRepeatType2) {
            i3 = 8;
        }
        qUISingleLineListItem2.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        n nVar = this.timeRepository;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            nVar = null;
        }
        new g(context, nVar.b(), new b(), G9()).m();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        D9((ViewGroup) rootView);
        Date M1 = I9().M1();
        long j16 = 0;
        if (M1 != null) {
            j3 = M1.getTime();
        } else {
            j3 = 0;
        }
        Date Q1 = I9().Q1();
        if (Q1 != null) {
            j16 = Q1.getTime();
        }
        this.timeRepository = new n(j3, j16);
        I9().P1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.repeat.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockRepeatEndTimePart.J9(FlockRepeatEndTimePart.this, (String) obj);
            }
        });
        I9().R1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.repeat.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockRepeatEndTimePart.K9(FlockRepeatEndTimePart.this, (FlockRepeatType) obj);
            }
        });
    }
}
