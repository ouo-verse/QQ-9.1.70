package com.tenpay.bank;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tenpay/bank/BankConstants;", "", "()V", "BANK_FINISH_FRAGMENT_INPUT_TAG", "", "BANK_FINISH_FRAGMENT_QUICK_TAG", "BANK_INPUT_VERIFY_FRAGMENT_TAG", "BIND_BANK_MAIN_FRAGMENT_TAG", "EXTRA_KEY_BIND_SCENE_TYPE", "QWALLET_BANK_TYPE_FRAGMENT_TAG", "REQUEST_CODE_BIND_BANK", "", "REQUEST_CODE_BIND_WEB", "REQUEST_CODE_HAND_CHOICE", "REQUEST_CODE_QWALLET_FACE", "REQUEST_CODE_VERIFY_PASSWORD", "SCENE_TYPE_ADD_CARD_FOR_WITHDRAW", "SCENE_TYPE_BIND_FIRST_CARD_FOR_WITHDRAW", "SCENE_TYPE_OPEN_PAY_CODE", "SCENE_TYPE_OPEN_TOUCH_OR_FACE", "SCENE_TYPE_PAY", "SCENE_TYPE_REAL_NAME_BIND", "SCENE_TYPE_RECHARGE", "SCENE_TYPE_RESET_PWD_EMBLED", "SCENE_TYPE_RESET_PWD_OUTER", "SCENE_TYPE_WALLET_BIND", "SELECT_BANK_FRAGMENT_TAG", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankConstants {

    @NotNull
    public static final String BANK_FINISH_FRAGMENT_INPUT_TAG = "bank_finish_fragment_input";

    @NotNull
    public static final String BANK_FINISH_FRAGMENT_QUICK_TAG = "bank_finish_fragment_quick";

    @NotNull
    public static final String BANK_INPUT_VERIFY_FRAGMENT_TAG = "Bank_Input_Verify_fragment";

    @NotNull
    public static final String BIND_BANK_MAIN_FRAGMENT_TAG = "bind_bank_main_fragment";

    @NotNull
    public static final String EXTRA_KEY_BIND_SCENE_TYPE = "extra_key_bind_scene_type";

    @NotNull
    public static final BankConstants INSTANCE = new BankConstants();

    @NotNull
    public static final String QWALLET_BANK_TYPE_FRAGMENT_TAG = "qwallet_bank_type_fragment";
    public static final int REQUEST_CODE_BIND_BANK = 100;
    public static final int REQUEST_CODE_BIND_WEB = 102;
    public static final int REQUEST_CODE_HAND_CHOICE = 202;
    public static final int REQUEST_CODE_QWALLET_FACE = 101;
    public static final int REQUEST_CODE_VERIFY_PASSWORD = 201;
    public static final int SCENE_TYPE_ADD_CARD_FOR_WITHDRAW = 4;
    public static final int SCENE_TYPE_BIND_FIRST_CARD_FOR_WITHDRAW = 5;
    public static final int SCENE_TYPE_OPEN_PAY_CODE = 8;
    public static final int SCENE_TYPE_OPEN_TOUCH_OR_FACE = 9;
    public static final int SCENE_TYPE_PAY = 0;
    public static final int SCENE_TYPE_REAL_NAME_BIND = 7;
    public static final int SCENE_TYPE_RECHARGE = 6;
    public static final int SCENE_TYPE_RESET_PWD_EMBLED = 1;
    public static final int SCENE_TYPE_RESET_PWD_OUTER = 2;
    public static final int SCENE_TYPE_WALLET_BIND = 3;

    @NotNull
    public static final String SELECT_BANK_FRAGMENT_TAG = "select_bank_fragment";

    BankConstants() {
    }
}
