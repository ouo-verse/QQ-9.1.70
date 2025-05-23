package com.tencent.state.template.dialog;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.state.SquareRuntime;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.service.IVasSquareFocusService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.template.data.FloatingLeveTip;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import ft4.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/dialog/SceneCommonDialogs;", "", "()V", "SCENE_DIALOG_BACKGROUND_ID_MAP", "", "", "TAG", "", "focusService", "Lcom/tencent/state/service/IVasSquareFocusService;", "checkSceneConflictDialog", "", "context", "Landroid/content/Context;", "onContinue", "Lkotlin/Function0;", "onCancel", "showKeepSceneTimeTipsDialog", "", "tips", "Lcom/tencent/state/template/data/FloatingLeveTip;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SceneCommonDialogs {
    private static final Map<Integer, Integer> SCENE_DIALOG_BACKGROUND_ID_MAP;
    private static final String TAG = "SceneCommonDialogs";
    public static final SceneCommonDialogs INSTANCE = new SceneCommonDialogs();
    private static final IVasSquareFocusService focusService = (IVasSquareFocusService) Square.INSTANCE.getConfig().getRapier().b(IVasSquareFocusService.class);

    static {
        Map<Integer, Integer> mapOf;
        Integer valueOf = Integer.valueOf(Scene.SQUARE_CHAT_BLOCK.getValue());
        Integer valueOf2 = Integer.valueOf(R.drawable.grz);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(Scene.LIB.getValue()), null), TuplesKt.to(valueOf, valueOf2), TuplesKt.to(Integer.valueOf(Scene.SQUARE_CHAT_WUJI_BLOCK_1.getValue()), valueOf2), TuplesKt.to(Integer.valueOf(Scene.SQUARE_CHAT_WUJI_BLOCK_2.getValue()), valueOf2));
        SCENE_DIALOG_BACKGROUND_ID_MAP = mapOf;
    }

    SceneCommonDialogs() {
    }

    public final void checkSceneConflictDialog(Context context, Function0<Unit> onContinue, Function0<Unit> onCancel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onContinue, "onContinue");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            SquareBaseKt.getSquareLog().d(TAG, "checkSceneConflictDialog: no need request SceneInfo in nearby scene");
            onContinue.invoke();
        } else {
            focusService.getSceneInfo(new e()).a(new SceneCommonDialogs$checkSceneConflictDialog$1(context, onCancel, onContinue));
        }
    }

    public final boolean showKeepSceneTimeTipsDialog(Context context, FloatingLeveTip tips) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tips, "tips");
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Common.HAS_SHOW_KEEP_SCENE_TIME_TIPS_DIALOG, false, String.valueOf(tips.getScene()), false, 8, null)) {
            return false;
        }
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Common.HAS_SHOW_KEEP_SCENE_TIME_TIPS_DIALOG, true, String.valueOf(tips.getScene()), false, 8, null);
        new CommonDialog(context, new CommonDialogData(new ResStyle(null, null, null, 0, 0, null, null, null, SCENE_DIALOG_BACKGROUND_ID_MAP.get(Integer.valueOf(tips.getScene())), 254, null), tips.getTip(), null, null, tips.getBtnOk(), new ContentStyle(tips.getDetail(), 0.0f, 0, false, 8388611, null, null, 102, null), null, false, null, false, 960, null)).show();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkSceneConflictDialog$default(SceneCommonDialogs sceneCommonDialogs, Context context, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function02 = null;
        }
        sceneCommonDialogs.checkSceneConflictDialog(context, function0, function02);
    }
}
