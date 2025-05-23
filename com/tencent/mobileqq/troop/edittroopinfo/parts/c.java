package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R.\u0010\u0017\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/c;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/b;", "", "M9", "N9", "L9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "f", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/b;", "avatarConfig", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", tl.h.F, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "i", "Landroid/view/View;", "avatarEditText", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> avatarConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView avatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View avatarEditText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.edittroopinfo.parts.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configList = new ArrayList<>();
        }
    }

    private final void L9() {
        TroopInfo g26 = C9().g2();
        if (g26 == null) {
            return;
        }
        if (QVipBigTroopExpiredProcessor.getConfig().mIsEnable && g26.mIsFreezed == 1 && g26.isOwnerOrAdmin()) {
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).handleModifyTroopHeadFreezedByTroopInfo(g26, getContext());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_EDIT", true);
        bundle.putBoolean("IS_COVER", false);
        getPartHost().Z9(bundle);
    }

    private final void M9() {
        QQProAvatarView qQProAvatarView = this.avatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(4, C9().m2(), new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(640).a());
    }

    private final void N9() {
        TroopInfo g26 = C9().g2();
        if (g26 == null) {
            return;
        }
        QLog.i("EditTroopInfoFragment-AvatarPart", 1, "[onClickAvatar] hasSet:" + g26.hasSetNewTroopHead);
        if (g26.hasSetNewTroopHead) {
            L9();
        } else {
            getPartHost().Dh(false);
        }
        View view = this.avatarEditText;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarEditText");
            view = null;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this, view, g26.hasSetNewTroopHead, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 260) {
            M9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        QQProAvatarView qQProAvatarView;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hz5, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f101585vl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id.troop_edit_avatar)");
        this.avatar = (QQProAvatarView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f101595vm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layout.findViewById(R.id\u2026op_edit_avatar_edit_text)");
        this.avatarEditText = findViewById2;
        M9();
        View view3 = this.avatarEditText;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarEditText");
            view = null;
        } else {
            view = view3;
        }
        TriggerRunnerKt.c(view, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                c.O9(c.this, view4);
            }
        }, 1, null);
        QQProAvatarView qQProAvatarView2 = this.avatar;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            qQProAvatarView = null;
        } else {
            qQProAvatarView = qQProAvatarView2;
        }
        TriggerRunnerKt.c(qQProAvatarView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                c.P9(c.this, view4);
            }
        }, 1, null);
        com.tencent.mobileqq.troop.troopsetting.customconfig.b<View> bVar = new com.tencent.mobileqq.troop.troopsetting.customconfig.b<>(inflate);
        bVar.M(true);
        this.avatarConfig = bVar;
        this.configList.add(bVar);
        View view4 = this.avatarEditText;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarEditText");
            view2 = null;
        } else {
            view2 = view4;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this, view2, "em_group_head", null, null, null, 28, null);
    }
}
