package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    private static void a(Intent intent, Intent intent2) {
        intent.putExtra("filepictest", true);
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        boolean booleanExtra = intent.getBooleanExtra("k_favorites", false);
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_TEXT);
        boolean booleanExtra2 = intent.getBooleanExtra("isFromShare", false);
        int intExtra = intent.getIntExtra("forward_type", 0);
        String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        intent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", intExtra);
        bundle.putParcelable("fileinfo", forwardFileInfo);
        bundle.putBoolean("not_forward", true);
        intent2.putExtras(bundle);
        intent2.putExtra(AppConstants.Key.FORWARD_FILEPATH, stringExtra2);
        intent2.putExtra(AppConstants.Key.FORWARD_TEXT, stringExtra);
        intent2.putExtra("k_favorites", booleanExtra);
        intent2.putExtra("isFromShare", booleanExtra2);
    }

    public static void b(Activity activity, Intent intent, boolean z16, int i3, String str) {
        if (intent == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
            return;
        }
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Intent intent2 = new Intent();
        intent2.putExtra("forward_source_business_type", i3);
        intent2.putExtra("forward_source_sub_business_type", str);
        if (!z16) {
            a(intent, intent2);
        }
        c(activity, intent2);
    }

    public static void c(Activity activity, Intent intent) {
        ForwardUtils.r0(activity, intent);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 103);
    }

    public static void d(Activity activity, Intent intent, boolean z16, int i3, String str) {
        if (intent == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
            return;
        }
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        if (!z16) {
            a(intent, new Intent());
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 103, i3, str);
        } else {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 21, i3, str);
        }
    }

    public static void e(Activity activity, Intent intent, boolean z16, String str, int i3) {
        if (intent == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
            return;
        }
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        intent.putExtra("key_direct_show_uin_type", i3);
        intent.putExtra("key_direct_show_uin", str);
        if (!z16) {
            intent.putExtra("filepictest", true);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 21);
        } else {
            ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 21);
        }
    }

    public static Intent f(Activity activity, Intent intent, boolean z16) {
        if (intent == null) {
            BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
            return null;
        }
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        if (!z16) {
            intent.putExtra("filepictest", true);
            ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
            String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            boolean booleanExtra = intent.getBooleanExtra("k_favorites", false);
            String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_TEXT);
            boolean booleanExtra2 = intent.getBooleanExtra("isFromShare", false);
            int intExtra = intent.getIntExtra("forward_type", 0);
            Intent intent2 = new Intent();
            intent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", intExtra);
            bundle.putParcelable("fileinfo", forwardFileInfo);
            bundle.putBoolean("not_forward", true);
            intent2.putExtras(bundle);
            intent2.putExtra(AppConstants.Key.FORWARD_FILEPATH, stringExtra);
            intent2.putExtra(AppConstants.Key.FORWARD_TEXT, stringExtra2);
            intent2.putExtra("k_favorites", booleanExtra);
            intent2.putExtra("isFromShare", booleanExtra2);
            if (AIOFilePictureData.class.isInstance(intent)) {
                intent2.putExtra("isPic", true);
                intent2.putExtra("direct_send_if_dataline_forward", true);
            }
        }
        return intent;
    }
}
