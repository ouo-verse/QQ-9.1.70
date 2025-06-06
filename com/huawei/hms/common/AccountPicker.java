package com.huawei.hms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AccountPicker {
    public static final String CHOOSE_ACCOUNT = "com.huawei.hms.common.account.CHOOSE_ACCOUNT";
    public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
    public static final int CUSTOM_THEME_GAMES = 1;
    public static final int CUSTOM_THEME_NONE = 0;
    public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
    public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
    public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
    public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
    public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
    public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
    public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
    public static final String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
    public static final String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
    public static final String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
    public static final String EXTRA_OVERRIDE_THEME = "overrideTheme";
    public static final String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
    public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
    public static final String EXTRA_SET_HMS_CORE_ACCOUNT = "setHmsCoreAccount";
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_LIGHT = 1;

    AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z16, String str, String str2, String[] strArr2, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(CHOOSE_ACCOUNT);
        try {
            intent.setPackage(PackageConstants.SERVICES_PACKAGE_ALL_SCENE);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("AccountPicker", "IllegalArgumentException when newChooseAccountIntent intent.setPackage");
        }
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z16);
        intent.putExtra(EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra(EXTRA_SET_HMS_CORE_ACCOUNT, false);
        intent.putExtra(EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        return intent;
    }
}
