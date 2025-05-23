package com.tencent.sqshow.zootopia.nativeui.dialog;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import b94.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeRetainStyle;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogMenuItem;
import l94.e;
import m94.DressErrorMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JP\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\b\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rH\u0002J&\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JP\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\b\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rH\u0002J&\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002JD\u0010\"\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070 J4\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070 J>\u0010'\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010$2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070 J\u001e\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J.\u0010.\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006JN\u0010/\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\b\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\rJ.\u00100\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u00105\u001a\u0002018\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "avatarPanelChannel", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "backHandler", "t", ReportConstant.COSTREPORT_PREFIX, "p", "o", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "type", "Ll94/c;", "i", "j", "f", "l", tl.h.F, "g", WadlProxyConsts.CHANNEL, "currentGoldCoin", "diffGoldCoin", "", "showDialog", "Lkotlin/Function1;", "callback", "b", "d", "", "", "reportMap", "e", "Ll94/a;", "dialogBuilder", "Lga4/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "retainStyle", "u", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", UserInfo.SEX_FEMALE, "k", "()F", "DIALOG_TEXIT_SIZE", "<init>", "()V", "ItemActionType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NativeUiDialogUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final NativeUiDialogUtils f371177a = new NativeUiDialogUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float DIALOG_TEXIT_SIZE = 17.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$ItemActionType;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes34.dex */
    public @interface ItemActionType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f371179a;
        public static final int TYPE_CANCEL_SAVE_ITEM_CLICK = 4;
        public static final int TYPE_CANCEL_SAVE_ITEM_SHOW = 2;
        public static final int TYPE_SAVE_ITEM_CLICK = 3;
        public static final int TYPE_SAVE_ITEM_SHOW = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$ItemActionType$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils$ItemActionType$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f371179a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$a", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements l94.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371180a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f371181b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f371182c;

        a(com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context, Function0<Unit> function0) {
            this.f371180a = jVar;
            this.f371181b = context;
            this.f371182c = function0;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZplanViewReportHelper.f(this.f371180a.getReporter().getMReporter(), view, "em_zplan_exit_notice_exit", null, 4, null);
            NativeUiDialogUtils.f371177a.l(this.f371180a, this.f371181b, this.f371182c);
        }

        @Override // l94.e
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371180a.getReporter().getMReporter().g(view, "em_zplan_exit_notice_exit", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$b", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements l94.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371183a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f371184b;

        b(com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context) {
            this.f371183a = jVar;
            this.f371184b = context;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            ga4.g a16;
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371183a.getReporter().getMReporter().e(view, "em_zplan_exit_notice_purchase", com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.c(this.f371183a.getStoreItemPool()));
            a16 = ga4.j.f401682a.a(22, this.f371183a, this.f371184b, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
            a16.show();
        }

        @Override // l94.e
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371183a.getReporter().getMReporter().g(view, "em_zplan_exit_notice_purchase", (r16 & 4) != 0 ? null : com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.c(this.f371183a.getStoreItemPool()), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$c", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements l94.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371187a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<View, Integer, Unit> f371188b;

        /* JADX WARN: Multi-variable type inference failed */
        c(com.tencent.sqshow.zootopia.nativeui.data.j jVar, Function2<? super View, ? super Integer, Unit> function2) {
            this.f371187a = jVar;
            this.f371188b = function2;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            b94.d avatarDressController;
            Intrinsics.checkNotNullParameter(view, "view");
            t avatarFaceController = this.f371187a.getAvatarFaceController();
            qu4.j h16 = avatarFaceController != null ? avatarFaceController.h() : null;
            if (h16 != null && (avatarDressController = this.f371187a.getAvatarDressController()) != null) {
                d.a.g(avatarDressController, h16, false, null, 6, null);
            }
            this.f371188b.invoke(view, 4);
            QLog.d("NativeUiDialogUtils_", 1, "cancel to save change");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$d", "Ll94/d;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements l94.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<View, Integer, Unit> f371189a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super View, ? super Integer, Unit> function2) {
            this.f371189a = function2;
        }

        @Override // l94.d
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371189a.invoke(view, 2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$e", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements l94.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371190a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<View, Integer, Unit> f371191b;

        /* JADX WARN: Multi-variable type inference failed */
        e(com.tencent.sqshow.zootopia.nativeui.data.j jVar, Function2<? super View, ? super Integer, Unit> function2) {
            this.f371190a = jVar;
            this.f371191b = function2;
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            b94.d avatarDressController;
            Intrinsics.checkNotNullParameter(view, "view");
            t avatarFaceController = this.f371190a.getAvatarFaceController();
            qu4.j d16 = avatarFaceController != null ? avatarFaceController.d() : null;
            if (d16 != null && (avatarDressController = this.f371190a.getAvatarDressController()) != null) {
                d.a.g(avatarDressController, d16, false, null, 6, null);
            }
            this.f371191b.invoke(view, 3);
            QLog.d("NativeUiDialogUtils_", 1, "save success it");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$f", "Ll94/d;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements l94.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<View, Integer, Unit> f371192a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super View, ? super Integer, Unit> function2) {
            this.f371192a = function2;
        }

        @Override // l94.d
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f371192a.invoke(view, 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$g", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements m94.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f371193a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371194b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f371195c;

        g(Function0<Unit> function0, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context) {
            this.f371193a = function0;
            this.f371194b = jVar;
            this.f371195c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Context context) {
            Intrinsics.checkNotNullParameter(context, "$context");
            QQToast.makeText(context, 1, "\u653e\u5f03\u4fdd\u5b58\u5931\u8d25", 0).show();
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.d("NativeUiDialogUtils_", 1, "resetDressToSaved failed " + task + " => " + errorMsg.getErrorCode() + " , " + errorMsg.getErrorMsg());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Context context = this.f371195c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.j
                @Override // java.lang.Runnable
                public final void run() {
                    NativeUiDialogUtils.g.d(context);
                }
            });
            this.f371193a.invoke();
            b94.e O = this.f371194b.O();
            if (O != null) {
                O.S2();
            }
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.d("NativeUiDialogUtils_", 1, "resetDressToSaved success");
            b94.e O = this.f371194b.O();
            if (O != null) {
                O.S2();
            }
            this.f371193a.invoke();
            b94.d avatarDressController = this.f371194b.getAvatarDressController();
            if (avatarDressController != null) {
                avatarDressController.j1();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$h", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements l94.e {
        h() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$i", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements l94.e {
        i() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/dialog/NativeUiDialogUtils$j", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j implements l94.e {
        j() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    NativeUiDialogUtils() {
    }

    private final AvatarActionSheetDialogMenuItem f(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        String string = context.getResources().getString(R.string.xpf);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026tring.zplan_give_up_save)");
        return new AvatarActionSheetDialogMenuItem(3, 1, string, new a(avatarPanelChannel, context, backHandler), null, 16, null);
    }

    private final AvatarActionSheetDialogMenuItem g(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        String string = context.getResources().getString(R.string.xpi);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026R.string.zplan_go_to_bug)");
        return new AvatarActionSheetDialogMenuItem(2, 2, string, new b(avatarPanelChannel, context), null, 16, null);
    }

    private final AvatarActionSheetDialogMenuItem h(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function2<? super View, ? super Integer, Unit> backHandler) {
        String string = context.getResources().getString(R.string.xpf);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026tring.zplan_give_up_save)");
        return new AvatarActionSheetDialogMenuItem(3, 1, string, new c(avatarPanelChannel, backHandler), new d(backHandler));
    }

    private final AvatarActionSheetDialogMenuItem i(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function2<? super View, ? super Integer, Unit> backHandler) {
        String string = context.getResources().getString(R.string.xt9);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ring.zplan_save_and_back)");
        return new AvatarActionSheetDialogMenuItem(2, 0, string, new e(avatarPanelChannel, backHandler), new f(backHandler));
    }

    private final AvatarActionSheetDialogMenuItem j(final com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, final Function0<Unit> backHandler) {
        String string = context.getResources().getString(R.string.xt9);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ring.zplan_save_and_back)");
        return new AvatarActionSheetDialogMenuItem(2, 0, string, new l94.e() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils$buildSaveMenuItem$1
            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                ZplanViewReportHelper.f(com.tencent.sqshow.zootopia.nativeui.data.j.this.getReporter().getMReporter(), view, "em_zplan_exit_notice_save", null, 4, null);
                AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                com.tencent.sqshow.zootopia.nativeui.data.j jVar = com.tencent.sqshow.zootopia.nativeui.data.j.this;
                final Function0<Unit> function0 = backHandler;
                avatarCommonOperateHelper.t(jVar, null, false, 3, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils$buildSaveMenuItem$1$onItemClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        QLog.d("NativeUiDialogUtils_", 1, "save success it");
                        if (z16) {
                            function0.invoke();
                        }
                    }
                });
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                com.tencent.sqshow.zootopia.nativeui.data.j.this.getReporter().getMReporter().g(view, "em_zplan_exit_notice_save", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        b94.e O;
        UEAvatarGender b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b();
        b94.e O2 = avatarPanelChannel.O();
        if (O2 != null) {
            O2.hh(b16);
        }
        Boolean value = avatarPanelChannel.getUeStatusController().a().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        if (avatarPanelChannel.getEngineApi().getType() == AvatarEngineType.FILAMENT && (O = avatarPanelChannel.O()) != null) {
            O.P1(0L);
        }
        b94.d avatarDressController = avatarPanelChannel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.O6(new g(backHandler, avatarPanelChannel, context), booleanValue);
        }
        avatarPanelChannel.k().setValue(null);
    }

    private final void o(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        t74.l.f435563a.d(new NativeUiDialogUtils$showPurchaseConfirmDialog$1(context, avatarPanelChannel, backHandler));
    }

    private final void p(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        l94.a d16 = new l94.a().b(g(avatarPanelChannel, context, backHandler)).b(f(avatarPanelChannel, context, backHandler)).d(new i());
        String string = context.getResources().getString(R.string.xpd);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026string.zplan_give_up_bug)");
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, d16.e(string).c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    private final void s(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        t74.l.f435563a.d(new NativeUiDialogUtils$showSaveConfirmDialog$1(context, avatarPanelChannel, backHandler));
    }

    private final void t(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        l94.a d16 = new l94.a().b(j(avatarPanelChannel, context, backHandler)).b(f(avatarPanelChannel, context, backHandler)).d(new j());
        String string = context.getResources().getString(R.string.xph);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.zplan_give_up_save_tips)");
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, d16.e(string).c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    public final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, int currentGoldCoin, int diffGoldCoin, boolean showDialog, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!showDialog) {
            callback.invoke(Boolean.TRUE);
        } else {
            t74.l.f435563a.d(new NativeUiDialogUtils$askNeedPayDiff$1(context, currentGoldCoin, diffGoldCoin, callback, channel));
        }
    }

    public final void d(com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, boolean showDialog, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!showDialog) {
            callback.invoke(Boolean.TRUE);
        } else {
            t74.l.f435563a.d(new NativeUiDialogUtils$askNeedRecharge$1(context, callback, channel));
        }
    }

    public final void e(com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, Map<String, ? extends Object> reportMap, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t74.l.f435563a.d(new NativeUiDialogUtils$askNeedSave$1(context, callback, channel, reportMap));
    }

    public final float k() {
        return DIALOG_TEXIT_SIZE;
    }

    public final ga4.g m(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, l94.a dialogBuilder) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogBuilder, "dialogBuilder");
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, dialogBuilder.c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
        return a16;
    }

    public final void n(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function2<? super View, ? super Integer, Unit> backHandler) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        l94.a d16 = new l94.a().b(i(avatarPanelChannel, context, backHandler)).b(h(avatarPanelChannel, context, backHandler)).d(new h());
        String string = context.getResources().getString(R.string.xpg);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026e_up_save_make_face_tips)");
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, d16.e(string).c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        avatarPanelChannel.getReporter().getMReporter().a(context, a16, "pg_zplan_avatar_sculpt", avatarPanelChannel.getReporter().b());
        a16.show();
    }

    public final void q(AvatarNativeRetainStyle retainStyle, com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        Intrinsics.checkNotNullParameter(retainStyle, "retainStyle");
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        if (retainStyle == AvatarNativeRetainStyle.MENU) {
            p(avatarPanelChannel, context, backHandler);
        } else {
            o(avatarPanelChannel, context, backHandler);
        }
    }

    public final void u(AvatarNativeRetainStyle retainStyle, com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        Intrinsics.checkNotNullParameter(retainStyle, "retainStyle");
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        if (retainStyle == AvatarNativeRetainStyle.MENU) {
            t(avatarPanelChannel, context, backHandler);
        } else {
            s(avatarPanelChannel, context, backHandler);
        }
    }

    public static /* synthetic */ void r(NativeUiDialogUtils nativeUiDialogUtils, AvatarNativeRetainStyle avatarNativeRetainStyle, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            avatarNativeRetainStyle = AvatarNativeRetainStyle.MENU;
        }
        nativeUiDialogUtils.q(avatarNativeRetainStyle, jVar, context, function0);
    }

    public static /* synthetic */ void v(NativeUiDialogUtils nativeUiDialogUtils, AvatarNativeRetainStyle avatarNativeRetainStyle, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            avatarNativeRetainStyle = AvatarNativeRetainStyle.MENU;
        }
        nativeUiDialogUtils.u(avatarNativeRetainStyle, jVar, context, function0);
    }

    public static /* synthetic */ void c(NativeUiDialogUtils nativeUiDialogUtils, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Context context, int i3, int i16, boolean z16, Function1 function1, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z16 = true;
        }
        nativeUiDialogUtils.b(jVar, context, i3, i16, z16, function1);
    }
}
