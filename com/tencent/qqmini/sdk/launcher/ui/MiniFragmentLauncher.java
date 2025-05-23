package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.ui.MoreFragment;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniFragmentLauncher {
    private static final Class FRAGMENT_ACTIVITY = MiniFragmentActivity.class;
    private static final Class FRAGMENT_ACTIVITY_TRANSLUCENT = MiniTranslucentFragmentActivity.class;
    private static final String PACKAGE_NAME = "com.tencent.qqmini.sdk.ui.";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum FragmentType {
        FRAGMENT_APPINFO_LOADING("MiniAppInfoLoadingFragment"),
        FRAGMENT_ADD_PHONE_NUMBER("AddPhoneNumberFragment"),
        FRAGMENT_PHONE_NUMBER_MANAGEMENT("PhoneNumberManagementFragment"),
        FRAGMENT_MAIN_PAGE("MainPageFragment"),
        FRAGMENT_SHARE_TRANSITIVE("ShareTransitiveFragment"),
        FRAGMENT_MORE(MoreFragment.TAG),
        FRAGMENT_BROWSER("BaseBrowserFragment"),
        FRAGMENT_TRANSLUCENT_BROWSER("TranslucentBrowserFragment"),
        FRAGMENT_PERMISSION_SETTING("PermissionSettingFragment"),
        FRAGMENT_SUB_MSG_PERMISSION_SETTING("SubscribePermissionSettingFragment");

        private Class mFragmentClass;
        private String mShortClassName;

        FragmentType(String str) {
            this.mShortClassName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Class fragmentClass() {
            if (this.mFragmentClass == null) {
                this.mFragmentClass = MiniFragmentLauncher.findClass(this.mShortClassName);
            }
            return this.mFragmentClass;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class findClass(String str) {
        return AppLoaderFactory.g().findClass(PACKAGE_NAME + str);
    }

    public static void start(Context context, Intent intent, FragmentType fragmentType) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, FRAGMENT_ACTIVITY);
        intent.putExtra("public_fragment_class", fragmentType.fragmentClass());
        context.startActivity(intent);
    }

    public static void startForResult(Activity activity, Intent intent, int i3, FragmentType fragmentType) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(activity, FRAGMENT_ACTIVITY);
        intent.putExtra("public_fragment_class", fragmentType.fragmentClass());
        activity.startActivityForResult(intent, i3);
    }

    public static void startTranslucent(Context context, Intent intent, FragmentType fragmentType) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, FRAGMENT_ACTIVITY_TRANSLUCENT);
        intent.putExtra("public_fragment_class", fragmentType.fragmentClass());
        context.startActivity(intent);
    }

    public static void startTranslucentForResult(Activity activity, Intent intent, int i3, FragmentType fragmentType) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(activity, FRAGMENT_ACTIVITY_TRANSLUCENT);
        intent.putExtra("public_fragment_class", fragmentType.fragmentClass());
        activity.startActivityForResult(intent, i3);
    }
}
