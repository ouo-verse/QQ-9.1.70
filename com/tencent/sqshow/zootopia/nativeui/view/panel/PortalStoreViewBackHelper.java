package com.tencent.sqshow.zootopia.nativeui.view.panel;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeRetainStyle;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J,\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J*\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J,\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewBackHelper;", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView$Companion$a;", "", "showDialog", "enableFinishActivity", "Lkotlin/Function0;", "", "exitPanelCallback", "e", "k", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "retainStyle", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb94/c;", "backHandler", "l", "", "style", "a", "i", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "mNativeUI", "Lga4/i;", "b", "Lga4/i;", "mDialogController", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeRetainStyle;", "mRetainStyle", "Lb94/c;", "mBackHandler", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;Lga4/i;Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreViewBackHelper implements PortalStoreTitleView.Companion.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final a mNativeUI;

    /* renamed from: b, reason: from kotlin metadata */
    private final ga4.i mDialogController;

    /* renamed from: c, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: d, reason: from kotlin metadata */
    private AvatarNativeRetainStyle mRetainStyle;

    /* renamed from: e, reason: from kotlin metadata */
    private b94.c mBackHandler;

    public PortalStoreViewBackHelper(a mNativeUI, ga4.i mDialogController, com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        Intrinsics.checkNotNullParameter(mNativeUI, "mNativeUI");
        Intrinsics.checkNotNullParameter(mDialogController, "mDialogController");
        Intrinsics.checkNotNullParameter(mChannel, "mChannel");
        this.mNativeUI = mNativeUI;
        this.mDialogController = mDialogController;
        this.mChannel = mChannel;
        this.mRetainStyle = AvatarNativeRetainStyle.MENU;
    }

    private final boolean g(AvatarNativeRetainStyle retainStyle, final boolean enableFinishActivity, final Function0<Unit> exitPanelCallback) {
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        if (!cVar.t(this.mChannel.getStoreItemPool()).isEmpty()) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            NativeUiDialogUtils nativeUiDialogUtils = NativeUiDialogUtils.f371177a;
            Context context = this.mNativeUI.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mNativeUI.getRoot().context");
            nativeUiDialogUtils.q(retainStyle, jVar, context, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewBackHelper$handleBackClickOnNormalStyle$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PortalStoreViewBackHelper.this.m(enableFinishActivity, exitPanelCallback);
                }
            });
            return true;
        }
        if (cVar.B()) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            NativeUiDialogUtils nativeUiDialogUtils2 = NativeUiDialogUtils.f371177a;
            Context context2 = this.mNativeUI.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "mNativeUI.getRoot().context");
            nativeUiDialogUtils2.u(retainStyle, jVar2, context2, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewBackHelper$handleBackClickOnNormalStyle$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PortalStoreViewBackHelper.this.m(enableFinishActivity, exitPanelCallback);
                }
            });
            return true;
        }
        return m(enableFinishActivity, exitPanelCallback);
    }

    private final boolean h() {
        this.mChannel.getAvatarColorController().c(this.mChannel);
        this.mChannel.getDialogController().d();
        return true;
    }

    public final void k() {
        t avatarFaceController = this.mChannel.getAvatarFaceController();
        if (avatarFaceController != null) {
            avatarFaceController.j1();
        }
        this.mChannel.getDialogController().d();
        PortalStoreTitleView mTopTitileView = this.mNativeUI.getMTopTitileView();
        if (mTopTitileView != null) {
            mTopTitileView.setStyle(0);
        }
    }

    public final boolean m(boolean z16, Function0<Unit> function0) {
        Activity attachedActivity;
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.j1();
        }
        if (function0 != null) {
            function0.invoke();
        }
        b94.c cVar = this.mBackHandler;
        if (cVar != null && cVar.a()) {
            return true;
        }
        if (z16 && (attachedActivity = this.mChannel.getAttachedActivity()) != null) {
            attachedActivity.finish();
        }
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView.Companion.a
    public boolean a(int style) {
        QLog.i("PortalStoreViewBackHelper", 1, "handle back btn " + style);
        return j(this, false, null, style, 3, null);
    }

    public final boolean i(boolean enableFinishActivity, Function0<Unit> exitPanelCallback, int style) {
        if (this.mDialogController.a()) {
            return true;
        }
        if (style == 0) {
            return g(this.mRetainStyle, enableFinishActivity, exitPanelCallback);
        }
        if (style == 1) {
            return f(this, false, enableFinishActivity, exitPanelCallback, 1, null);
        }
        if (style != 2) {
            return false;
        }
        return h();
    }

    public final void l(b94.c backHandler, AvatarNativeRetainStyle retainStyle) {
        Intrinsics.checkNotNullParameter(retainStyle, "retainStyle");
        this.mBackHandler = backHandler;
        this.mRetainStyle = retainStyle;
    }

    private final boolean e(boolean showDialog, final boolean enableFinishActivity, final Function0<Unit> exitPanelCallback) {
        Activity attachedActivity;
        if (showDialog) {
            t avatarFaceController = this.mChannel.getAvatarFaceController();
            if (avatarFaceController != null && avatarFaceController.f()) {
                MakeFaceExitHelper makeFaceExitHelper = MakeFaceExitHelper.f371595a;
                com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
                Context context = this.mNativeUI.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mNativeUI.getRoot().context");
                makeFaceExitHelper.c(jVar, context, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewBackHelper$handleBackClickOnMakeFaceStyle$1
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
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar2;
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar3;
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar4;
                        jVar2 = PortalStoreViewBackHelper.this.mChannel;
                        if (jVar2.getNativeViewMode() == AvatarNativeViewMode.ONLY_MAKE_FACE) {
                            jVar3 = PortalStoreViewBackHelper.this.mChannel;
                            jVar3.getDialogController().d();
                            Function0<Unit> function0 = exitPanelCallback;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            if (enableFinishActivity) {
                                jVar4 = PortalStoreViewBackHelper.this.mChannel;
                                Activity attachedActivity2 = jVar4.getAttachedActivity();
                                if (attachedActivity2 != null) {
                                    attachedActivity2.finish();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        PortalStoreViewBackHelper.this.k();
                    }
                });
                return true;
            }
        }
        this.mChannel.getDialogController().d();
        if (this.mChannel.getNativeViewMode() != AvatarNativeViewMode.ONLY_MAKE_FACE) {
            PortalStoreTitleView mTopTitileView = this.mNativeUI.getMTopTitileView();
            if (mTopTitileView != null) {
                mTopTitileView.setStyle(0);
            }
            return true;
        }
        if (exitPanelCallback != null) {
            exitPanelCallback.invoke();
        }
        if (enableFinishActivity && (attachedActivity = this.mChannel.getAttachedActivity()) != null) {
            attachedActivity.finish();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean f(PortalStoreViewBackHelper portalStoreViewBackHelper, boolean z16, boolean z17, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        return portalStoreViewBackHelper.e(z16, z17, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean j(PortalStoreViewBackHelper portalStoreViewBackHelper, boolean z16, Function0 function0, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        if ((i16 & 2) != 0) {
            function0 = null;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return portalStoreViewBackHelper.i(z16, function0, i3);
    }
}
