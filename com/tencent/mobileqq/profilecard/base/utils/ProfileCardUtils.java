package com.tencent.mobileqq.profilecard.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMedalWallEntryInfo;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMetalWallUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileCardUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String MAP_KEY_CLICK_LISTENER = "MAP_KEY_CLICK_LISTENER";
    public static final String MAP_KEY_VIEW = "MAP_KEY_VIEW";
    public static final String MAP_KEY_WIDTH = "MAP_KEY_WIDTH";
    private static final String TAG = "ProfileCardUtils";

    public ProfileCardUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void enterNTAio(Context context, Intent intent, String str) {
        if (context != null && intent != null) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (!TextUtils.isEmpty(uidFromUin)) {
                intent.putExtra("key_peerId", uidFromUin);
            }
            intent.putExtra("key_from", "3");
            context.startActivity(intent);
            return;
        }
        QLog.e(TAG, 1, "enterNTAio is error!");
    }

    public static Uri enterSnapshot(Activity activity, int i3) {
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            return null;
        }
        if (AudioUtil.h(0)) {
            DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f6e), activity.getString(R.string.f6f), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                    }
                }
            }, null).show();
            return null;
        }
        if (QQAudioHelper.g(0)) {
            DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f6e), activity.getString(R.string.f6g), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i16);
                    }
                }
            }, null).show();
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_PATH;
        sb5.append(str);
        sb5.append("photo/");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString()));
        if (!file.exists()) {
            file.mkdirs();
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str + "photo/" + System.currentTimeMillis() + ".jpg");
        Intent intent = new Intent();
        Uri systemCapture = FileProvider7Helper.setSystemCapture(activity, new File(sDKPrivatePath), intent);
        intent.putExtra("android.intent.extra.videoQuality", 100);
        activity.startActivityForResult(intent, i3);
        return systemCapture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, Object> getOnlineStatusViewAndClickListener(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar, final String str, AppRuntime.Status status, AppRuntime appRuntime, final Context context) {
        TextView textView;
        Integer num;
        View.OnClickListener onClickListener = null;
        if (!OnlineStatusToggleUtils.t()) {
            return null;
        }
        if (cVar != null && !TextUtils.isEmpty(str) && appRuntime != null && context != null && status != null) {
            if (str.equals(appRuntime.getCurrentUin()) && AppSetting.t(context)) {
                return null;
            }
            au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(status, cVar.e0());
            if (onlineStatusItem.f255489b == 0 && status != AppRuntime.Status.qme && str.equals(appRuntime.getCurrentUin())) {
                textView = new TextView(context);
                textView.setGravity(16);
                textView.setText(context.getString(R.string.f201494uy));
                textView.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_primary));
                textView.setCompoundDrawablePadding(ViewUtils.dip2px(2.0f));
                textView.setSingleLine();
                textView.setTextSize(10.0f);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.k5d);
                if (drawable != null) {
                    int dip2px = ViewUtils.dip2px(12.0f);
                    drawable.setBounds(0, 0, dip2px, dip2px);
                }
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.f161201k71));
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(50.0f), ViewUtils.dip2px(20.0f)));
                textView.setPadding(ViewUtils.dip2px(6.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(6.0f), ViewUtils.dip2px(3.0f));
                num = Integer.valueOf(ViewUtils.dip2px(50.0f));
            } else if ((onlineStatusItem.f255489b > 0 && status == AppRuntime.Status.online) || status == AppRuntime.Status.qme) {
                Drawable selfStatusDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(cVar.e0(), status, 1, cVar, 0);
                if (selfStatusDrawable == null) {
                    return null;
                }
                int dip2px2 = ViewUtils.dip2px(19.2f);
                Integer valueOf = Integer.valueOf(dip2px2);
                selfStatusDrawable.setBounds(0, 0, dip2px2, dip2px2);
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(dip2px2, dip2px2));
                imageView.setImageDrawable(selfStatusDrawable);
                num = valueOf;
                textView = imageView;
            } else {
                textView = null;
                num = null;
            }
            if (str.equals(appRuntime.getCurrentUin())) {
                onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.utils.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProfileCardUtils.lambda$getOnlineStatusViewAndClickListener$0(context, view);
                    }
                };
            } else if ((cVar.e0() > 0 && status == AppRuntime.Status.online) || status == AppRuntime.Status.qme) {
                onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.base.utils.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProfileCardUtils.lambda$getOnlineStatusViewAndClickListener$1(str, view);
                    }
                };
            }
            HashMap hashMap = new HashMap();
            hashMap.put(MAP_KEY_VIEW, textView);
            hashMap.put(MAP_KEY_WIDTH, num);
            hashMap.put(MAP_KEY_CLICK_LISTENER, onClickListener);
            return hashMap;
        }
        QLog.d(TAG, 1, "getOnlineStatusViewAndClickListener simpleInfo " + cVar + " uin " + str + " status " + status + " appruntime " + appRuntime + " context " + context);
        return null;
    }

    public static String getProfileDetailUrl(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        if (qQAppInterface == null || profileCardInfo == null || (allInOne = profileCardInfo.allInOne) == null || TextUtils.isEmpty(allInOne.uin)) {
            return null;
        }
        return getProfileDetailUrl(profileCardInfo.allInOne.uin, qQAppInterface.getAppid(), "android-" + AppSetting.f99551k, profileCardInfo.troopUin, ProfileMetalWallUtils.getProfileMetalWallEntryInfo(qQAppInterface, profileCardInfo));
    }

    public static boolean isDefaultProfile(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null || profileCardInfo.curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getOnlineStatusViewAndClickListener$0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (context instanceof QBaseActivity)) {
            QBaseActivity qBaseActivity = (QBaseActivity) context;
            ViewGroup viewGroup = (ViewGroup) qBaseActivity.findViewById(R.id.zxc);
            viewGroup.setVisibility(0);
            ((ViewGroup) viewGroup.getParent()).bringChildToFront(viewGroup);
            ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).newAccountPanel(qBaseActivity, 8).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getOnlineStatusViewAndClickListener$1(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Context context = view.getContext();
        if (context instanceof Activity) {
            l.W((Activity) context, str, 6, false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static void notifyUser(int i3, int i16) {
        notifyUser(i3, BaseApplication.getContext().getString(i16));
    }

    public static void openProfileEdit(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo) {
        if (appInterface == null || activity == null || profileCardInfo == null || ProfileEditUtils.openNewProfileEdit(activity, profileCardInfo.allInOne)) {
            return;
        }
        BusinessCard a16 = BusinessCardUtils.a(appInterface, profileCardInfo);
        Intent intent = new Intent(activity, (Class<?>) FriendProfileMoreInfoActivity.class);
        AllInOne allInOne = profileCardInfo.allInOne;
        Intent q06 = ProfileCardUtil.q0(intent, allInOne.uin, appInterface, allInOne, a16);
        q06.putExtra("profile_entry_type", profileCardInfo.allInOne.profileEntryType);
        q06.putExtra("troopUin", profileCardInfo.troopUin);
        q06.putExtra("memberUin", profileCardInfo.allInOne.uin);
        q06.putExtra("isTroopMemberCard", profileCardInfo.isTroopMemberCard);
        activity.startActivityForResult(q06, 1022);
    }

    public static void openProfileEditWithData(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo, Bundle bundle) {
        if (appInterface != null && activity != null && profileCardInfo != null) {
            if (ProfileEditUtils.openNewProfileEdit(activity, profileCardInfo.allInOne, bundle)) {
                return;
            }
            BusinessCard a16 = BusinessCardUtils.a(appInterface, profileCardInfo);
            Intent intent = new Intent(activity, (Class<?>) FriendProfileMoreInfoActivity.class);
            AllInOne allInOne = profileCardInfo.allInOne;
            Intent q06 = ProfileCardUtil.q0(intent, allInOne.uin, appInterface, allInOne, a16);
            if (bundle != null) {
                q06.putExtras(bundle);
            }
            q06.putExtra("profile_entry_type", profileCardInfo.allInOne.profileEntryType);
            q06.putExtra("troopUin", profileCardInfo.troopUin);
            q06.putExtra("memberUin", profileCardInfo.allInOne.uin);
            q06.putExtra("isTroopMemberCard", profileCardInfo.isTroopMemberCard);
            activity.startActivityForResult(q06, 1022);
            return;
        }
        QLog.e(TAG, 1, "[openProfileEditWithData] param invalid");
    }

    public static void setNightModeFilterForDrawable(AppInterface appInterface, Drawable drawable) {
        if (appInterface != null && drawable != null) {
            if (ThemeUtil.isInNightMode(appInterface)) {
                drawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    public static void setNightModeFilterForImageView(AppInterface appInterface, ImageView imageView) {
        if (appInterface != null && imageView != null) {
            if (ThemeUtil.isInNightMode(appInterface)) {
                imageView.setColorFilter(1996488704);
            } else {
                imageView.setColorFilter(0);
            }
        }
    }

    public static void notifyUser(int i3, String str) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
    }

    public static String getProfileDetailUrl(String str, int i3, String str2, String str3, ProfileMedalWallEntryInfo profileMedalWallEntryInfo) {
        String format = String.format(IProfileCardConst.PROFILE_DETAIL_URL, str, Integer.valueOf(i3), str2);
        if (!TextUtils.isEmpty(str3)) {
            format = format + "&troopUin=" + str3;
        }
        if (profileMedalWallEntryInfo == null) {
            return format;
        }
        if (profileMedalWallEntryInfo.showMetalWall) {
            format = format + "&mwentry=1";
        }
        if (profileMedalWallEntryInfo.hasRedPoint) {
            format = format + "&mwredpoint=1";
        }
        if (profileMedalWallEntryInfo.redPointCount <= 1) {
            return format;
        }
        return format + "&mwredpointnum=" + profileMedalWallEntryInfo.redPointCount;
    }
}
