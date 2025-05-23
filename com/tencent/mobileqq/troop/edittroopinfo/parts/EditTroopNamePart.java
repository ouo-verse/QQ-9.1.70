package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR.\u0010!\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001cj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R'\u0010)\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020*0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopNamePart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/b;", "", "isChecked", "", "aa", "X9", "isSuccess", "", "newName", "errorMsg", "U9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "Lkotlin/Lazy;", "T9", "()Lcom/tencent/mobileqq/widget/listitem/x;", "troopNameConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "i", "S9", "allowMemberModifyTroopNameConfig", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopNamePart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopNameConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy allowMemberModifyTroopNameConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopNamePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopNamePart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EditTroopNamePart(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.lifecycleOwner = lifecycleOwner;
        this.configList = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(new EditTroopNamePart$troopNameConfig$2(this));
        this.troopNameConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new EditTroopNamePart$allowMemberModifyTroopNameConfig$2(this));
        this.allowMemberModifyTroopNameConfig = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> S9() {
        return (com.tencent.mobileqq.widget.listitem.x) this.allowMemberModifyTroopNameConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> T9() {
        return (com.tencent.mobileqq.widget.listitem.x) this.troopNameConfig.getValue();
    }

    private final void U9(boolean isSuccess, String newName, String errorMsg) {
        boolean z16;
        if (isSuccess) {
            C9().x2(newName);
            return;
        }
        if (errorMsg == null) {
            errorMsg = "";
        }
        if (errorMsg.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            errorMsg = HardCodeUtil.qqStr(R.string.khc);
        }
        String msg2 = errorMsg;
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        com.tencent.qqnt.e.k(null, 1, msg2, 0, null, 25, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(final EditTroopNamePart this$0, final String newName, final boolean z16, int i3, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newName, "$newName");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.w
            @Override // java.lang.Runnable
            public final void run() {
                EditTroopNamePart.W9(EditTroopNamePart.this, z16, newName, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(EditTroopNamePart this$0, boolean z16, String newName, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newName, "$newName");
        this$0.U9(z16, newName, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9() {
        String str;
        TroopInfo g26 = C9().g2();
        if (g26 == null) {
            return;
        }
        boolean canModifyTroopName = g26.canModifyTroopName();
        boolean z16 = true;
        QLog.i("EditTroopInfoFragment-NamePart", 1, "[onClickTroopName] canChangeTroopName:" + canModifyTroopName + ", set:" + g26.hasSetNewTroopName);
        if (!canModifyTroopName) {
            return;
        }
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && g26.mIsFreezed == 1 && g26.isOwnerOrAdmin()) {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModifyNameFreezedByTroopInfo(g26, getContext());
            return;
        }
        String str2 = "";
        if (!g26.hasSetNewTroopName || (str = g26.troopNameFromNT) == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneContant.KEY_EDIT_TYPE, 1);
        intent.putExtra("edit_mode", 2);
        intent.putExtra("max_limit_mode", 1);
        intent.putExtra("title", HardCodeUtil.qqStr(R.string.kh6));
        intent.putExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT, str);
        intent.putExtra("max_num", 96);
        intent.putExtra("canPostNull", false);
        intent.putExtra("right_btn", HardCodeUtil.qqStr(R.string.kgq));
        intent.putExtra("edit_mode", true);
        if (g26.isQidianPrivateTroop() || g26.isNewTroop) {
            z16 = false;
        }
        if (z16) {
            str2 = g26.getTroopUin();
        }
        intent.putExtra("troopUin", str2);
        intent.putExtra("default_hint", HardCodeUtil.qqStr(R.string.f235047al));
        RouteUtils.startActivityForResult(getContext(), intent, RouterConstants.UI_ROUTE_EDITINFO_ACTIVITY, 18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(boolean isChecked) {
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this, S9().i(), isChecked, "group_switch_status", null, 8, null);
    }

    @Override // com.tencent.mobileqq.troop.edittroopinfo.parts.base.b
    @NotNull
    public List<Group> I9() {
        List<Group> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        return listOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (QLog.isDebugVersion()) {
            QLog.d("EditTroopInfoFragment-NamePart", 4, "[onActivityResult] requestCode:" + requestCode + " resultCode:" + resultCode + ", data:" + data);
        }
        if (-1 == resultCode && requestCode == 18 && data != null) {
            if (!NetworkUtil.isNetworkAvailable()) {
                String qqStr = HardCodeUtil.qqStr(R.string.ci5);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.net_disabled)");
                com.tencent.qqnt.e.k(null, 1, qqStr, 0, null, 25, null);
                return;
            }
            final String stringExtra = data.getStringExtra("result");
            if (stringExtra == null) {
                return;
            }
            TroopInfo g26 = C9().g2();
            if (g26 != null) {
                str = g26.troopNameFromNT;
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, stringExtra)) {
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupName(C9().m2(), stringExtra, this.lifecycleOwner, "EditTroopInfoFragment-NamePart", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.v
                    @Override // com.tencent.qqnt.troop.i
                    public final void onResult(boolean z16, int i3, String str2) {
                        EditTroopNamePart.V9(EditTroopNamePart.this, stringExtra, z16, i3, str2);
                    }
                });
            }
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
        this.configList.add(T9());
        this.configList.add(S9());
        LiveData<CharSequence> j26 = C9().j2();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<CharSequence, Unit> function1 = new Function1<CharSequence, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopNamePart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopNamePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence it) {
                com.tencent.mobileqq.widget.listitem.x T9;
                com.tencent.mobileqq.widget.listitem.x T92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                T9 = EditTroopNamePart.this.T9();
                x.c.g gVar = (x.c.g) T9.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                gVar.h(it);
                EditTroopNamePart editTroopNamePart = EditTroopNamePart.this;
                T92 = editTroopNamePart.T9();
                editTroopNamePart.D9(T92);
            }
        };
        j26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopNamePart.Y9(Function1.this, obj);
            }
        });
        LiveData<Boolean> W1 = C9().W1();
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopNamePart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopNamePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                com.tencent.mobileqq.widget.listitem.x S9;
                com.tencent.mobileqq.widget.listitem.x S92;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                S9 = EditTroopNamePart.this.S9();
                x.c.f fVar = (x.c.f) S9.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                fVar.f(it.booleanValue());
                EditTroopNamePart editTroopNamePart = EditTroopNamePart.this;
                S92 = editTroopNamePart.S9();
                editTroopNamePart.D9(S92);
            }
        };
        W1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditTroopNamePart.Z9(Function1.this, obj);
            }
        });
    }
}
