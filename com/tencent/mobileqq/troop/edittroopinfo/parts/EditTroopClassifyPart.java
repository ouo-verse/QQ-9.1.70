package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R'\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopClassifyPart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "", "Q9", "Landroid/content/Intent;", "data", "P9", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "f", "Lkotlin/Lazy;", "O9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "troopClassifyConfig", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopClassifyPart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopClassifyConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopClassifyPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopClassifyPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32533);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopClassifyPart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new EditTroopClassifyPart$troopClassifyConfig$2(this));
        this.troopClassifyConfig = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> O9() {
        return (com.tencent.mobileqq.widget.listitem.x) this.troopClassifyConfig.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void P9(Intent data) {
        long j3;
        Long l3;
        String classText;
        Long longOrNull;
        if (data != null && (r8 = data.getStringExtra("id")) != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = Long.MAX_VALUE;
        }
        TroopInfo g26 = C9().g2();
        if (g26 != null) {
            l3 = Long.valueOf(g26.dwGroupClassExt);
        } else {
            l3 = null;
        }
        QLog.i("EditTroopInfoFragment-ClassifyPart", 1, "[onChooseTroopClassify] classifyId:" + j3 + ", dwGroupClassExt:" + l3);
        if ((l3 == null || l3.longValue() != j3) && j3 != Long.MAX_VALUE) {
            com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(String.valueOf(j3));
            if (c16 == null) {
                classText = "";
            } else {
                classText = c16.f299960b;
            }
            TroopEditInfoViewModel C9 = C9();
            Intrinsics.checkNotNullExpressionValue(classText, "classText");
            C9.p2(j3, classText, this.lifecycleOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        Long l3;
        TroopBindGameItemHelper A9 = A9();
        boolean z16 = false;
        if (A9 != null && A9.k() == 1) {
            z16 = true;
        }
        if (z16) {
            String qqStr = HardCodeUtil.qqStr(R.string.f172825ui4);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopinf_547dae78)");
            com.tencent.qqnt.e.k(null, 1, qqStr, 0, null, 25, null);
            return;
        }
        TroopInfo g26 = C9().g2();
        if (g26 != null) {
            l3 = Long.valueOf(g26.dwGroupClassExt);
        } else {
            l3 = null;
        }
        String valueOf = String.valueOf(l3);
        if (((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).getExperimentResultAndReport()) {
            ITroopCreatePage iTroopCreatePage = (ITroopCreatePage) QRoute.api(ITroopCreatePage.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            iTroopCreatePage.openCreateTroopByCategoryPageFromSetting(activity, valueOf);
            return;
        }
        Intent intent = new Intent(getActivity(), ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).getTroopClassChoiceActivtiyClass());
        intent.putExtra("troopGroupClassExt", valueOf);
        getActivity().startActivityForResult(intent, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.a
    @NotNull
    /* renamed from: N9, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return O9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (-1 == resultCode && requestCode == 11) {
            P9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        LiveData<String> e26 = C9().e2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopClassifyPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopClassifyPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                com.tencent.mobileqq.widget.listitem.x O9;
                com.tencent.mobileqq.widget.listitem.x O92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                O9 = EditTroopClassifyPart.this.O9();
                x.c.g gVar = (x.c.g) O9.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                gVar.h(it);
                EditTroopClassifyPart editTroopClassifyPart = EditTroopClassifyPart.this;
                O92 = editTroopClassifyPart.O9();
                editTroopClassifyPart.D9(O92);
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopClassifyPart.R9(Function1.this, obj);
            }
        });
    }
}
