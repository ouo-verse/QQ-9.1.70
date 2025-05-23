package com.tenpay.idverify.hint;

import android.content.Intent;
import com.google.gson.GsonBuilder;
import com.tenpay.idverify.EnumIdResultScene;
import com.tenpay.idverify.model.IdInfoBean;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.sdk.activity.TenpayUtilActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u00a2\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J@\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyHintModule;", "", "()V", "startCommonSuccessHint", "", "fragment", "Lcom/tenpay/sdk/activity/TenpayUtilActivity;", "title", "", "tip", "button", "finishKillAll", "", "(Lcom/tenpay/sdk/activity/TenpayUtilActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "startSceneForResult", "scene", "Lcom/tenpay/idverify/EnumIdResultScene;", "requestCode", "", "startStateBeanHint", "idVerifyStateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "idInfoBean", "Lcom/tenpay/idverify/model/IdInfoBean;", "listId", "extInfo", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyHintModule {

    @NotNull
    public static final IdVerifyHintModule INSTANCE = new IdVerifyHintModule();

    IdVerifyHintModule() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void startCommonSuccessHint(@NotNull TenpayUtilActivity fragment, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        startCommonSuccessHint$default(fragment, str, null, null, null, 28, null);
    }

    public static /* synthetic */ void startCommonSuccessHint$default(TenpayUtilActivity tenpayUtilActivity, String str, String str2, String str3, Boolean bool, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        if ((i3 & 16) != 0) {
            bool = null;
        }
        startCommonSuccessHint(tenpayUtilActivity, str, str2, str3, bool);
    }

    @JvmStatic
    public static final void startSceneForResult(@NotNull TenpayUtilActivity fragment, @NotNull EnumIdResultScene scene, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intent intent = new Intent();
        intent.putExtra(IdVerifyHintFragment.KEY_RESULT_SCENE, scene);
        fragment.launchFragmentForResult(intent, IdVerifyHintFragment.class, requestCode);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startStateBeanHint(@NotNull TenpayUtilActivity fragment, @Nullable IdVerifyStateBean idVerifyStateBean) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        startStateBeanHint$default(fragment, idVerifyStateBean, 0, 4, null);
    }

    public static /* synthetic */ void startStateBeanHint$default(TenpayUtilActivity tenpayUtilActivity, IdVerifyStateBean idVerifyStateBean, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        startStateBeanHint(tenpayUtilActivity, idVerifyStateBean, i3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startCommonSuccessHint(@NotNull TenpayUtilActivity fragment, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        startCommonSuccessHint$default(fragment, str, str2, null, null, 24, null);
    }

    @JvmStatic
    public static final void startStateBeanHint(@NotNull TenpayUtilActivity fragment, @Nullable IdVerifyStateBean idVerifyStateBean, @Nullable IdInfoBean idInfoBean, @Nullable String listId, @Nullable String extInfo, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = new Intent();
        if (idVerifyStateBean != null) {
            intent.putExtra(IdVerifyStateProcessor.KEY_ID_VERIFY_STATE_BEAN, new GsonBuilder().create().toJson(idVerifyStateBean));
        }
        if (idInfoBean != null) {
            intent.putExtra(IdVerifyStateProcessor.KEY_ID_INFO_BEAN, new GsonBuilder().create().toJson(idInfoBean));
        }
        if (listId != null) {
            intent.putExtra("KEY_LIST_ID", listId);
        }
        if (extInfo != null) {
            intent.putExtra("KEY_EXT_INFO", extInfo);
        }
        intent.putExtra(IdVerifyHintFragment.KEY_RESULT_SCENE, EnumIdResultScene.SCENE_STATE_INFO);
        if (requestCode != -1) {
            fragment.launchFragmentForResult(intent, IdVerifyHintFragment.class, requestCode);
        } else {
            fragment.launchFragment(intent, IdVerifyHintFragment.class);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void startCommonSuccessHint(@NotNull TenpayUtilActivity fragment, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        startCommonSuccessHint$default(fragment, str, str2, str3, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startCommonSuccessHint(@NotNull TenpayUtilActivity fragment, @Nullable String title, @Nullable String tip, @Nullable String button, @Nullable Boolean finishKillAll) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = new Intent();
        intent.putExtra(IdVerifyFinishProcessor.KEY_AUTH_COMMENT, title);
        intent.putExtra(IdVerifyFinishProcessor.KEY_AUTH_TIP, tip);
        intent.putExtra(IdVerifyFinishProcessor.KEY_AUTH_BUTTON, button);
        if (finishKillAll != null) {
            intent.putExtra(IdVerifyFinishProcessor.KEY_EXIT_AFTER_CONFIRM, finishKillAll.booleanValue());
        }
        intent.putExtra(IdVerifyHintFragment.KEY_RESULT_SCENE, EnumIdResultScene.SCENE_VERIFY_FINISH);
        fragment.launchFragment(intent, IdVerifyHintFragment.class);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startStateBeanHint(@NotNull TenpayUtilActivity fragment, @Nullable IdVerifyStateBean idVerifyStateBean, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent intent = new Intent();
        if (idVerifyStateBean != null) {
            intent.putExtra(IdVerifyStateProcessor.KEY_ID_VERIFY_STATE_BEAN, new GsonBuilder().create().toJson(idVerifyStateBean));
        }
        intent.putExtra(IdVerifyHintFragment.KEY_RESULT_SCENE, EnumIdResultScene.SCENE_STATE_INFO);
        if (requestCode != -1) {
            fragment.launchFragmentForResult(intent, IdVerifyHintFragment.class, requestCode);
        } else {
            fragment.launchFragment(intent, IdVerifyHintFragment.class);
        }
    }
}
