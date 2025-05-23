package com.tencent.mobileqq.minigame.va.util;

import android.R;
import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ/\u0010\u0015\u001a\u00020\u000f2%\u0010\u0016\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\t\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\u0013\u001a%\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nj\u0004\u0018\u0001`\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/va/util/MiniGameVAColorNote;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAColorNote;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "initCallback", "Lcom/tencent/mobileqq/minigame/va/util/InitColorNoteCallback;", "(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/mobileqq/minigame/va/util/InitColorNoteCallback;)V", "addCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "Lcom/tencent/mobileqq/minigame/api/AddColorNoteCallback;", "colorNoteController", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "updateCallback", "Lcom/tencent/mobileqq/minigame/va/util/UpdateColorNoteCallback;", "addToColorNote", "callback", "initColorNoteController", "isExistColorNote", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "removeColorNote", "setInitCallback", "updateColorNote", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAColorNote implements IMiniGameVAColorNote {
    private static final String TAG = "MiniGameVAColorNote";
    private final Activity activity;
    private Function1<? super Boolean, Unit> addCallback;
    private IColorNoteController colorNoteController;
    private InitColorNoteCallback initCallback;
    private final MiniAppInfo miniAppInfo;
    private Function1<? super Boolean, Unit> updateCallback;

    public MiniGameVAColorNote(Activity activity, MiniAppInfo miniAppInfo, InitColorNoteCallback initColorNoteCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        this.activity = activity;
        this.miniAppInfo = miniAppInfo;
        this.initCallback = initColorNoteCallback;
        initColorNoteController();
    }

    private final void initColorNoteController() {
        QLog.i(TAG, 1, "initColorNoteController");
        QRouteApi api = QRoute.api(IColorNoteController.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IColorNoteController::class.java)");
        IColorNoteController iColorNoteController = (IColorNoteController) api;
        this.colorNoteController = iColorNoteController;
        IColorNoteController iColorNoteController2 = null;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        iColorNoteController.init(this.activity, false, true);
        IColorNoteController iColorNoteController3 = this.colorNoteController;
        if (iColorNoteController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController3 = null;
        }
        iColorNoteController3.attachToActivity(this.activity);
        IColorNoteController iColorNoteController4 = this.colorNoteController;
        if (iColorNoteController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController4 = null;
        }
        iColorNoteController4.setServiceInfo(new com.tencent.mobileqq.colornote.f() { // from class: com.tencent.mobileqq.minigame.va.util.MiniGameVAColorNote$initColorNoteController$1
            @Override // com.tencent.mobileqq.colornote.f
            public ColorNote getColorNote() {
                MiniAppInfo miniAppInfo;
                MiniAppInfo miniAppInfo2;
                MiniAppInfo miniAppInfo3;
                MiniAppInfo miniAppInfo4;
                MiniAppInfo miniAppInfo5;
                ColorNote.a g16 = new ColorNote.a().g(R.attr.theme);
                miniAppInfo = MiniGameVAColorNote.this.miniAppInfo;
                String str = miniAppInfo.appId;
                miniAppInfo2 = MiniGameVAColorNote.this.miniAppInfo;
                ColorNote.a i3 = g16.i(str + "#@#" + miniAppInfo2.verType);
                miniAppInfo3 = MiniGameVAColorNote.this.miniAppInfo;
                ColorNote.a d16 = i3.d(miniAppInfo3.name);
                miniAppInfo4 = MiniGameVAColorNote.this.miniAppInfo;
                ColorNote.a h16 = d16.h(miniAppInfo4.desc);
                miniAppInfo5 = MiniGameVAColorNote.this.miniAppInfo;
                ColorNote a16 = h16.e(miniAppInfo5.iconUrl).a();
                Intrinsics.checkNotNullExpressionValue(a16, "Builder().setServiceType\u2026                .create()");
                return a16;
            }
        });
        IColorNoteController iColorNoteController5 = this.colorNoteController;
        if (iColorNoteController5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController5 = null;
        }
        iColorNoteController5.setOnColorNoteAnimFinishListener(new ha1.a() { // from class: com.tencent.mobileqq.minigame.va.util.a
            @Override // ha1.a
            public final void onColorNoteAnimFinish() {
                MiniGameVAColorNote.initColorNoteController$lambda$0(MiniGameVAColorNote.this);
            }
        });
        IColorNoteController iColorNoteController6 = this.colorNoteController;
        if (iColorNoteController6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
        } else {
            iColorNoteController2 = iColorNoteController6;
        }
        iColorNoteController2.setOnColorNoteCurdListener(new MiniGameVAColorNote$initColorNoteController$3(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initColorNoteController$lambda$0(MiniGameVAColorNote this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activity.finish();
        this$0.activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote
    public void addToColorNote(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IColorNoteController iColorNoteController = this.colorNoteController;
        IColorNoteController iColorNoteController2 = null;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        boolean isColorNoteExist = iColorNoteController.isColorNoteExist();
        QLog.i(TAG, 1, "addToColorNote:" + isColorNoteExist);
        if (isColorNoteExist) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        IColorNoteController iColorNoteController3 = this.colorNoteController;
        if (iColorNoteController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController3 = null;
        }
        if (!iColorNoteController3.canAddColorNote()) {
            QLog.i(TAG, 1, "addToColorNote canAddColorNote: false");
            IColorNoteController iColorNoteController4 = this.colorNoteController;
            if (iColorNoteController4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            } else {
                iColorNoteController2 = iColorNoteController4;
            }
            iColorNoteController2.onCannotAdd();
            callback.invoke(Boolean.FALSE);
            return;
        }
        this.addCallback = callback;
        IColorNoteController iColorNoteController5 = this.colorNoteController;
        if (iColorNoteController5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
        } else {
            iColorNoteController2 = iColorNoteController5;
        }
        iColorNoteController2.insertColorNote();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote
    public boolean isExistColorNote() {
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        return iColorNoteController.isColorNoteExist();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote
    public void onDestroy() {
        IColorNoteController iColorNoteController = this.colorNoteController;
        IColorNoteController iColorNoteController2 = null;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        iColorNoteController.setOnColorNoteCurdListener(null);
        IColorNoteController iColorNoteController3 = this.colorNoteController;
        if (iColorNoteController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
        } else {
            iColorNoteController2 = iColorNoteController3;
        }
        iColorNoteController2.onDestroy();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote
    public void onPause() {
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        iColorNoteController.onPause();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAColorNote
    public void onResume() {
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        iColorNoteController.onResume();
    }

    public final void removeColorNote() {
        IColorNoteController iColorNoteController = this.colorNoteController;
        IColorNoteController iColorNoteController2 = null;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        if (iColorNoteController.isColorNoteExist()) {
            IColorNoteController iColorNoteController3 = this.colorNoteController;
            if (iColorNoteController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            } else {
                iColorNoteController2 = iColorNoteController3;
            }
            iColorNoteController2.deleteColorNote();
        }
    }

    public final void setInitCallback(InitColorNoteCallback initCallback) {
        this.initCallback = initCallback;
    }

    public final void updateColorNote(final MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        IColorNoteController iColorNoteController = this.colorNoteController;
        if (iColorNoteController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorNoteController");
            iColorNoteController = null;
        }
        iColorNoteController.setServiceInfo(new com.tencent.mobileqq.colornote.f() { // from class: com.tencent.mobileqq.minigame.va.util.MiniGameVAColorNote$updateColorNote$1
            @Override // com.tencent.mobileqq.colornote.f
            public ColorNote getColorNote() {
                ColorNote.a g16 = new ColorNote.a().g(R.attr.theme);
                MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                ColorNote a16 = g16.i(miniAppInfo2.appId + "#@#" + miniAppInfo2.verType).d(MiniAppInfo.this.name).h(MiniAppInfo.this.desc).e(MiniAppInfo.this.iconUrl).a();
                Intrinsics.checkNotNullExpressionValue(a16, "Builder().setServiceType\u2026                .create()");
                return a16;
            }
        });
    }

    public /* synthetic */ MiniGameVAColorNote(Activity activity, MiniAppInfo miniAppInfo, InitColorNoteCallback initColorNoteCallback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, miniAppInfo, (i3 & 4) != 0 ? null : initColorNoteCallback);
    }
}
