package com.tenpay.idverify.hint;

import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.idverify.EnumIdVerifyState;
import com.tenpay.idverify.EnumIdVerifyStateRole;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyHintFragment;
import com.tenpay.idverify.model.IdInfoBean;
import com.tenpay.idverify.model.IdVerifyStateBean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyStateProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "idVerifyStateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;Lcom/tenpay/idverify/model/IdVerifyStateBean;)V", "getFragment$qwallet_impl_release", "()Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "idInfoBean", "Lcom/tenpay/idverify/model/IdInfoBean;", "getIdInfoBean$qwallet_impl_release", "()Lcom/tenpay/idverify/model/IdInfoBean;", "setIdInfoBean$qwallet_impl_release", "(Lcom/tenpay/idverify/model/IdInfoBean;)V", "getIdVerifyStateBean$qwallet_impl_release", "()Lcom/tenpay/idverify/model/IdVerifyStateBean;", "listId", "", "getListId$qwallet_impl_release", "()Ljava/lang/String;", "setListId$qwallet_impl_release", "(Ljava/lang/String;)V", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "Companion", "Factory", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class IdVerifyStateProcessor implements IdVerifyHintFragment.IdVerifyHintProcessor {

    @NotNull
    public static final String KEY_ID_INFO_BEAN = "KEY_ID_INFO_BEAN";

    @NotNull
    public static final String KEY_ID_VERIFY_STATE_BEAN = "KEY_ID_VERIFY_STATE_BEAN";

    @NotNull
    public static final String KEY_LIST_ID = "KEY_LIST_ID";

    @NotNull
    private static final String TAG = "IdVerifyStateProcessor";

    @NotNull
    private final IdVerifyHintFragment fragment;

    @Nullable
    private IdInfoBean idInfoBean;

    @NotNull
    private final IdVerifyStateBean idVerifyStateBean;

    @Nullable
    private String listId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyStateProcessor$Factory;", "", "()V", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Factory {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyStateProcessor$Factory$Companion;", "", "()V", "build", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes27.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[EnumIdVerifyStateRole.values().length];
                    try {
                        iArr[EnumIdVerifyStateRole.INVITER.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumIdVerifyStateRole.INVITEES.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[EnumIdVerifyState.values().length];
                    try {
                        iArr2[EnumIdVerifyState.NONE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[EnumIdVerifyState.GUARDIAN_ENSURING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[EnumIdVerifyState.GUARDIAN_ENSURED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr2[EnumIdVerifyState.HAS_REAL_NAME.ordinal()] = 4;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr2[EnumIdVerifyState.INVALID.ordinal()] = 5;
                    } catch (NoSuchFieldError unused7) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final IdVerifyHintFragment.IdVerifyHintProcessor build(@NotNull IdVerifyHintFragment fragment) {
                String str;
                IdVerifyHintFragment.IdVerifyHintProcessor idVerifyUnknownProcessor;
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                Gson create = new GsonBuilder().create();
                Bundle arguments = fragment.getArguments();
                if (arguments != null) {
                    str = arguments.getString(IdVerifyStateProcessor.KEY_ID_VERIFY_STATE_BEAN);
                } else {
                    str = null;
                }
                IdVerifyStateBean stateBean = (IdVerifyStateBean) create.fromJson(str, IdVerifyStateBean.class);
                int i3 = WhenMappings.$EnumSwitchMapping$1[stateBean.getStateEnum().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
                                    idVerifyUnknownProcessor = new IdVerifyWarningProcessor(fragment, stateBean);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                idVerifyUnknownProcessor = new IdVerifyHasSucceedProcessor(fragment, stateBean);
                            }
                        } else {
                            int i16 = WhenMappings.$EnumSwitchMapping$0[stateBean.getRoleEnum().ordinal()];
                            if (i16 != 1) {
                                if (i16 == 2) {
                                    Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
                                    idVerifyUnknownProcessor = new IdVerifyGuardianFinishProcessor(fragment, stateBean);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
                                idVerifyUnknownProcessor = new IdVerifyAfterCommitProcessor(fragment, stateBean);
                            }
                        }
                    } else {
                        int i17 = WhenMappings.$EnumSwitchMapping$0[stateBean.getRoleEnum().ordinal()];
                        if (i17 != 1) {
                            if (i17 == 2) {
                                Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
                                idVerifyUnknownProcessor = new IdVerifyGuardianProcessor(fragment, stateBean);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            Intrinsics.checkNotNullExpressionValue(stateBean, "stateBean");
                            idVerifyUnknownProcessor = new IdVerifyWaitingGuardianProcessor(fragment, stateBean);
                        }
                    }
                } else {
                    idVerifyUnknownProcessor = new IdVerifyUnknownProcessor(fragment, stateBean);
                }
                QLog.i(IdVerifyStateProcessor.TAG, 1, "build " + idVerifyUnknownProcessor);
                return idVerifyUnknownProcessor;
            }

            Companion() {
            }
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumIdVerifyState.values().length];
            try {
                iArr[EnumIdVerifyState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumIdVerifyState.GUARDIAN_ENSURING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumIdVerifyState.GUARDIAN_ENSURED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumIdVerifyState.HAS_REAL_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumIdVerifyState.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public IdVerifyStateProcessor(@NotNull IdVerifyHintFragment fragment, @NotNull IdVerifyStateBean idVerifyStateBean) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(idVerifyStateBean, "idVerifyStateBean");
        this.fragment = fragment;
        this.idVerifyStateBean = idVerifyStateBean;
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            try {
                this.idInfoBean = (IdInfoBean) new GsonBuilder().create().fromJson(arguments.getString(KEY_ID_INFO_BEAN), IdInfoBean.class);
                this.listId = arguments.getString("KEY_LIST_ID");
            } catch (Exception e16) {
                QLog.w(TAG, 1, "create idVerifyStateBean error: ", e16);
            }
        }
    }

    @NotNull
    /* renamed from: getFragment$qwallet_impl_release, reason: from getter */
    public final IdVerifyHintFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    /* renamed from: getIdInfoBean$qwallet_impl_release, reason: from getter */
    public final IdInfoBean getIdInfoBean() {
        return this.idInfoBean;
    }

    @NotNull
    /* renamed from: getIdVerifyStateBean$qwallet_impl_release, reason: from getter */
    public final IdVerifyStateBean getIdVerifyStateBean() {
        return this.idVerifyStateBean;
    }

    @Nullable
    /* renamed from: getListId$qwallet_impl_release, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    public final void setIdInfoBean$qwallet_impl_release(@Nullable IdInfoBean idInfoBean) {
        this.idInfoBean = idInfoBean;
    }

    public final void setListId$qwallet_impl_release(@Nullable String str) {
        this.listId = str;
    }

    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        int i3;
        Intrinsics.checkNotNullParameter(vc5, "vc");
        int i16 = WhenMappings.$EnumSwitchMapping$0[this.idVerifyStateBean.getStateEnum().ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                i3 = R.drawable.olc;
                if (i16 != 3 && i16 != 4) {
                    if (i16 == 5) {
                        i3 = R.drawable.olf;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                i3 = R.drawable.ole;
            }
        } else {
            i3 = R.drawable.olb;
        }
        IdVerifyCommonHintVC.setData$default(vc5, ResourcesCompat.getDrawable(vc5.resources(), i3, null), this.idVerifyStateBean.getStateTitle(), this.idVerifyStateBean.getStateTip(), null, null, null, null, 120, null);
    }
}
