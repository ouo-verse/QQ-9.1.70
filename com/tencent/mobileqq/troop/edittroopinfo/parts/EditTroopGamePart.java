package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R'\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopGamePart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "", "eventId", "", "X9", "Z9", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "T9", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper;", "U9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "f", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper;", "troopBindGameItemHelper", "Landroid/view/View$OnClickListener;", tl.h.F, "Landroid/view/View$OnClickListener;", "gameClickListener", "", "i", "Ljava/lang/Boolean;", "isItemVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "needDoDtImpReport", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "V9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "troopGameConfig", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopGamePart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopGameConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopBindGameItemHelper troopBindGameItemHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener gameClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isItemVisible;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean needDoDtImpReport;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopGamePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopGamePart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32558);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopGamePart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new EditTroopGamePart$troopGameConfig$2(this));
        this.troopGameConfig = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> V9() {
        return (com.tencent.mobileqq.widget.listitem.x) this.troopGameConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(String eventId) {
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this, V9().i(), !Intrinsics.areEqual(V9().K().getText(), HardCodeUtil.qqStr(R.string.i7k)), null, eventId, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Y9(EditTroopGamePart editTroopGamePart, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "dt_clck";
        }
        editTroopGamePart.X9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        View.OnClickListener onClickListener;
        if (this.troopBindGameItemHelper == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopBindGameItemHelper troopBindGameItemHelper = new TroopBindGameItemHelper(context, C9().m2());
            this.troopBindGameItemHelper = troopBindGameItemHelper;
            troopBindGameItemHelper.r(new EditTroopGamePart$tryInitGameHelper$1(this));
            TroopBindGameItemHelper troopBindGameItemHelper2 = this.troopBindGameItemHelper;
            if (troopBindGameItemHelper2 != null) {
                onClickListener = troopBindGameItemHelper2.h();
            } else {
                onClickListener = null;
            }
            this.gameClickListener = onClickListener;
            TroopBindGameItemHelper troopBindGameItemHelper3 = this.troopBindGameItemHelper;
            if (troopBindGameItemHelper3 != null) {
                troopBindGameItemHelper3.j();
            }
        }
        TroopBindGameItemHelper troopBindGameItemHelper4 = this.troopBindGameItemHelper;
        if (troopBindGameItemHelper4 != null) {
            troopBindGameItemHelper4.o();
        }
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.a
    @NotNull
    /* renamed from: T9, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return V9();
    }

    @Nullable
    public final TroopBindGameItemHelper U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopBindGameItemHelper) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopBindGameItemHelper;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LiveData<String> e26 = C9().e2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopGamePart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopGamePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TroopEditInfoViewModel C9;
                Boolean bool;
                com.tencent.mobileqq.widget.listitem.x V9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                C9 = EditTroopGamePart.this.C9();
                TroopInfo g26 = C9.g2();
                boolean isGameTroop = g26 != null ? g26.isGameTroop() : false;
                bool = EditTroopGamePart.this.isItemVisible;
                if (!Intrinsics.areEqual(bool, Boolean.valueOf(isGameTroop))) {
                    EditTroopGamePart.this.isItemVisible = Boolean.valueOf(isGameTroop);
                    EditTroopGamePart.this.needDoDtImpReport = true;
                }
                EditTroopGamePart editTroopGamePart = EditTroopGamePart.this;
                V9 = editTroopGamePart.V9();
                editTroopGamePart.E9(V9, isGameTroop);
                if (isGameTroop) {
                    EditTroopGamePart.this.Z9();
                }
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopGamePart.W9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        TroopBindGameItemHelper troopBindGameItemHelper = this.troopBindGameItemHelper;
        if (troopBindGameItemHelper != null) {
            troopBindGameItemHelper.p();
        }
    }
}
