package com.tencent.state.template.dialog;

import android.content.Context;
import as4.g;
import com.tencent.rapier.b;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import ft4.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/template/dialog/SceneCommonDialogs$checkSceneConflictDialog$1", "Lcom/tencent/rapier/b;", "Lft4/f;", "", "errorCode", "", "errorMessage", "", "onFailure", "response", "onSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SceneCommonDialogs$checkSceneConflictDialog$1 implements b<f> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0 $onCancel;
    final /* synthetic */ Function0 $onContinue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SceneCommonDialogs$checkSceneConflictDialog$1(Context context, Function0 function0, Function0 function02) {
        this.$context = context;
        this.$onCancel = function0;
        this.$onContinue = function02;
    }

    @Override // com.tencent.rapier.b
    public void onFailure(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SceneCommonDialogs", "checkSceneConflictDialog: getSceneInfo failed: [" + errorCode + "] " + errorMessage, null, 4, null);
        SquareBaseKt.getSquareCommon().showToast(this.$context, errorMessage, 1);
        Function0 function0 = this.$onCancel;
        if (function0 != null) {
        }
    }

    @Override // com.tencent.rapier.b
    public void onSuccess(f response) {
        Map map;
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().d("SceneCommonDialogs", "checkSceneConflictDialog: getSceneInfo success " + response.f400617a);
        g gVar = response.f400617a;
        if (gVar == null) {
            this.$onContinue.invoke();
            return;
        }
        Context context = this.$context;
        SceneCommonDialogs sceneCommonDialogs = SceneCommonDialogs.INSTANCE;
        map = SceneCommonDialogs.SCENE_DIALOG_BACKGROUND_ID_MAP;
        ResStyle resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, (Integer) map.get(Integer.valueOf(gVar.f26898a)), 254, null);
        String str = gVar.f26900c;
        if (str == null) {
            str = "\u662f\u5426\u7ed3\u675f\u5f53\u524d\u573a\u666f\uff1f";
        }
        String str2 = str;
        String str3 = gVar.f26902e;
        if (str3 == null) {
            str3 = "\u7ed3\u675f\u5e76\u5165\u5ea7";
        }
        String str4 = str3;
        String str5 = gVar.f26903f;
        if (str5 == null) {
            str5 = "\u6682\u4e0d\u7ed3\u675f";
        }
        String str6 = str5;
        String str7 = gVar.f26901d;
        if (str7 == null) {
            str7 = "\u4f60\u6709\u5176\u4ed6\u573a\u666f\u6d3b\u52a8\u5c1a\u672a\u7ed3\u675f\uff0c\u8981\u7ed3\u675f\u540e\u624d\u80fd\u5165\u5ea7\u54e6~";
        }
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, str2, str4, str6, null, new ContentStyle(str7, 0.0f, 0, false, 8388611, null, null, 102, null), null, false, null, false, 960, null));
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.template.dialog.SceneCommonDialogs$checkSceneConflictDialog$1$onSuccess$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Function0 function0;
                if (i3 == 1) {
                    SceneCommonDialogs$checkSceneConflictDialog$1.this.$onContinue.invoke();
                } else if (i3 == 2 && (function0 = SceneCommonDialogs$checkSceneConflictDialog$1.this.$onCancel) != null) {
                }
            }
        });
        commonDialog.show();
    }
}
