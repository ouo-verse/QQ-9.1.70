package com.tencent.qqnt.aio.helper;

import android.text.Spanned;
import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.AIOInputMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.robot.aio.input.styleconfig.InputStyleConfigMsgIntent;
import com.tencent.robot.aio.input.styleconfig.b;
import com.tencent.robot.slash.api.IRobotSlashApi;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b*\u0001\"\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R(\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\"0'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ad;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "b", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$DispatchKeyBackEventInPreIme;", "c", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", "e", "Landroid/text/Spanned;", "spannedChars", "", "selectionStart", "", "g", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/robot/slash/manager/d;", "Lcom/tencent/robot/slash/manager/d;", "mSlashDialogManagerApi", "com/tencent/qqnt/aio/helper/ad$b", "f", "Lcom/tencent/qqnt/aio/helper/ad$b;", "mAction", "", "Lkotlin/Pair;", tl.h.F, "Ljava/util/List;", "mMessageList", "<init>", "()V", "i", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ad implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.robot.slash.manager.d mSlashDialogManagerApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<Pair<String, b>> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ad$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            ad.this.b(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public ad() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.DispatchKeyBackEventInPreIme.class).getQualifiedName(), bVar)});
        this.mMessageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(MsgIntent msgIntent) {
        if (msgIntent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            e((InputEditTextMsgIntent.EditTextChangedMsgIntent) msgIntent);
        } else if (msgIntent instanceof InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) {
            c((InputEditTextMsgIntent.DispatchKeyBackEventInPreIme) msgIntent);
        }
    }

    private final void c(InputEditTextMsgIntent.DispatchKeyBackEventInPreIme msgIntent) {
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        com.tencent.robot.slash.manager.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
            dVar = null;
        }
        if (dVar.r()) {
            com.tencent.robot.slash.manager.d dVar3 = this.mSlashDialogManagerApi;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
                dVar3 = null;
            }
            dVar3.e();
            com.tencent.robot.slash.manager.d dVar4 = this.mSlashDialogManagerApi;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
            } else {
                dVar2 = dVar4;
            }
            dVar2.b(true);
            msgIntent.b(true);
        }
    }

    private final void e(InputEditTextMsgIntent.EditTextChangedMsgIntent msgIntent) {
        String replaceFirst$default;
        com.tencent.robot.slash.manager.d dVar = null;
        if (g(msgIntent.c(), msgIntent.b())) {
            com.tencent.robot.slash.manager.d dVar2 = this.mSlashDialogManagerApi;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
                dVar2 = null;
            }
            dVar2.e();
            com.tencent.robot.slash.manager.d dVar3 = this.mSlashDialogManagerApi;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
            } else {
                dVar = dVar3;
            }
            dVar.b(true);
            return;
        }
        String substring = msgIntent.c().toString().substring(0, msgIntent.b());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(substring, "/", "", false, 4, (Object) null);
        com.tencent.robot.slash.manager.d dVar4 = this.mSlashDialogManagerApi;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
        } else {
            dVar = dVar4;
        }
        dVar.g(replaceFirst$default);
    }

    private final boolean g(Spanned spannedChars, int selectionStart) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.k k3 = aVar.e().k(InputStyleConfigMsgIntent.GetIsSupportSlashAbility.f367236d);
        b.IsSupportSlashAbility isSupportSlashAbility = k3 instanceof b.IsSupportSlashAbility ? (b.IsSupportSlashAbility) k3 : null;
        if (!(isSupportSlashAbility != null ? isSupportSlashAbility.getIsSupportSlashAbility() : false)) {
            return true;
        }
        startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) spannedChars, (CharSequence) "/", false, 2, (Object) null);
        if (startsWith$default) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) spannedChars, (CharSequence) "\n", false, 2, (Object) null);
            if (!contains$default && selectionStart >= spannedChars.length()) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) spannedChars, (CharSequence) " ", false, 2, (Object) null);
                if (!contains$default2) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350621b1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "C2CInputSlashHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        com.tencent.mvi.base.route.k k3 = a16.e().k(AIOInputMsgIntent.GetInputDialogAnchor.f189144d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputDialogAnchor");
        View a17 = ((d.e) k3).a();
        IRobotSlashApi iRobotSlashApi = (IRobotSlashApi) QRoute.api(IRobotSlashApi.class);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        this.mSlashDialogManagerApi = iRobotSlashApi.createSlashManagerFromAIO(aVar, a17);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            aVar2.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.robot.slash.manager.d dVar = this.mSlashDialogManagerApi;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlashDialogManagerApi");
            dVar = null;
        }
        dVar.onDestroy();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
