package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopSchoolPart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/a;", "", "eventId", "", "V9", "S9", "Landroid/content/Intent;", "data", "R9", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "f", "Lkotlin/Lazy;", "Q9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "troopSchoolConfig", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopSchoolPart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopSchoolConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopSchoolPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopSchoolPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopSchoolPart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new EditTroopSchoolPart$troopSchoolConfig$2(this));
        this.troopSchoolConfig = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Q9() {
        return (com.tencent.mobileqq.widget.listitem.x) this.troopSchoolConfig.getValue();
    }

    private final void R9(Intent data) {
        String str;
        if (data != null) {
            str = data.getStringExtra("SchoolJsonObject");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment-SchoolPart", 1, "[onChooseSchoolInfo] json:" + str);
        }
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String jSONObject2 = jSONObject.getJSONObject("location").toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(\"location\").toString()");
            int optInt = jSONObject.optInt("grade");
            String school = jSONObject.getString("school");
            TroopEditInfoViewModel C9 = C9();
            Intrinsics.checkNotNullExpressionValue(school, "school");
            C9.v2(jSONObject2, optInt, school, this.lifecycleOwner);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        boolean z16;
        TroopInfo g26 = C9().g2();
        if (g26 != null && g26.isOwnerOrAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("EditTroopInfoFragment-SchoolPart", 1, "[onClickSchoolInfo] not owner or admin");
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), RouterConstants.UI_ROUTE_BROWSER);
        Intent intent = new Intent();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(IHWTroopUtilsApi.HOMEWORK_TROOP_SCHOOL_MODIFY_URL, Arrays.copyOf(new Object[]{C9().m2(), IHWTroopUtilsApi.HOMEWORK_SCHOOL_EDIT_FROM}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        intent.putExtra("url", format);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setRequestCode(19);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(String eventId) {
        boolean z16;
        String value = C9().k2().getValue();
        if (value != null && !Intrinsics.areEqual(value, HardCodeUtil.qqStr(R.string.f172823ui2))) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this, Q9().i(), z16, null, eventId, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void W9(EditTroopSchoolPart editTroopSchoolPart, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "dt_clck";
        }
        editTroopSchoolPart.V9(str);
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.a
    @NotNull
    /* renamed from: P9, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> I9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (-1 == resultCode && requestCode == 19) {
            R9(data);
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
        LiveData<String> k26 = C9().k2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopSchoolPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopSchoolPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                com.tencent.mobileqq.widget.listitem.x Q9;
                com.tencent.mobileqq.widget.listitem.x Q92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Q9 = EditTroopSchoolPart.this.Q9();
                x.c.g gVar = (x.c.g) Q9.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                gVar.h(it);
                EditTroopSchoolPart editTroopSchoolPart = EditTroopSchoolPart.this;
                Q92 = editTroopSchoolPart.Q9();
                editTroopSchoolPart.D9(Q92);
            }
        };
        k26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopSchoolPart.T9(Function1.this, obj);
            }
        });
        LiveData<String> e26 = C9().e2();
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopSchoolPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopSchoolPart.this);
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
                com.tencent.mobileqq.widget.listitem.x Q9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                C9 = EditTroopSchoolPart.this.C9();
                TroopInfo g26 = C9.g2();
                boolean isHomeworkTroop = g26 != null ? g26.isHomeworkTroop() : false;
                EditTroopSchoolPart editTroopSchoolPart = EditTroopSchoolPart.this;
                Q9 = editTroopSchoolPart.Q9();
                editTroopSchoolPart.E9(Q9, isHomeworkTroop);
            }
        };
        e26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopSchoolPart.U9(Function1.this, obj);
            }
        });
    }
}
