package com.tencent.mobileqq.guild.robot.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import ap0.f;
import com.google.gson.Gson;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.robot.api.impl.GuildRobotPageApiImpl;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.RobotPermissionFragment;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.robot.components.setting.RobotActiveMsgControlDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback;
import com.tencent.util.URLUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kr0.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nx1.ReportPageArgs;
import nx1.c;
import xw1.d;

/* loaded from: classes14.dex */
public class GuildRobotPageApiImpl implements IGuildRobotPageApi {
    public static final int OUT_TIME_CACHE = 300000;
    private static final String TAG = "GuildRobotPageApiImpl";
    private final Gson mGson = new Gson();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements IGProFetchGuildRobotPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f232040a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f232041b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f232042c;

        a(Context context, String str, String str2) {
            this.f232040a = context;
            this.f232041b = str;
            this.f232042c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp, String str) {
            if (i3 == 0 && gProGuildRobotPermissionRsp != null) {
                d(gProGuildRobotPermissionRsp);
            } else {
                c(i3, str);
            }
        }

        public void c(int i3, String str) {
            QLog.e(GuildRobotPageApiImpl.TAG, 1, "errCode = " + i3 + " msg = " + str + " guildId = " + this.f232042c + " robotUin = " + this.f232041b);
            Context context = this.f232040a;
            if (context == null) {
                QLog.e(GuildRobotPageApiImpl.TAG, 1, "jumpPermissionSettingPage, onError: context == null");
                return;
            }
            b bVar = (b) GuildRobotPageApiImpl.this.mGson.fromJson(cl.d(context, GuildRobotPageApiImpl.createCacheId(this.f232041b, this.f232042c)), b.class);
            int robotArkPermissionCacheTime = ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getRobotArkPermissionCacheTime() * 1000;
            if (robotArkPermissionCacheTime <= 0) {
                robotArkPermissionCacheTime = 300000;
            }
            if (bVar != null && SystemClock.currentThreadTimeMillis() - bVar.f232047d <= robotArkPermissionCacheTime) {
                int i16 = bVar.f232045b;
                int i17 = bVar.f232044a;
                if (i16 == 0) {
                    QQToast.makeText(this.f232040a, 0, HardCodeUtil.qqStr(R.string.f15124176), 1).show();
                    return;
                } else if (i16 == 1 && i17 == 1) {
                    QQToast.makeText(this.f232040a, 0, HardCodeUtil.qqStr(R.string.f138820_l), 1).show();
                    return;
                }
            }
            GuildRobotPageApiImpl.this.startPermissionPage(this.f232040a, this.f232041b, this.f232042c, null);
        }

        public void d(GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
            if (this.f232040a == null) {
                QLog.e(GuildRobotPageApiImpl.TAG, 1, "jumpPermissionSettingPage, onResponse: context == null");
                return;
            }
            int operatorRole = gProGuildRobotPermissionRsp.getOperatorRole();
            int role = gProGuildRobotPermissionRsp.getRole();
            GuildRobotPageApiImpl.updateCache(this.f232040a, this.f232041b, this.f232042c, gProGuildRobotPermissionRsp);
            if (operatorRole == 0) {
                QQToast.makeText(this.f232040a, 0, HardCodeUtil.qqStr(R.string.f15124176), 1).show();
            } else if (operatorRole != 1 || role != 1) {
                GuildRobotPageApiImpl.this.startPermissionPage(this.f232040a, this.f232041b, this.f232042c, gProGuildRobotPermissionRsp);
            } else {
                QQToast.makeText(this.f232040a, 0, HardCodeUtil.qqStr(R.string.f138820_l), 1).show();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback
        public void onFetchGuildRobotPermission(final int i3, final String str, final GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRobotPageApiImpl.a.this.b(i3, gProGuildRobotPermissionRsp, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f232044a;

        /* renamed from: b, reason: collision with root package name */
        int f232045b;

        /* renamed from: c, reason: collision with root package name */
        int f232046c;

        /* renamed from: d, reason: collision with root package name */
        long f232047d;

        public b(int i3, int i16, int i17, long j3) {
            this.f232044a = i3;
            this.f232045b = i16;
            this.f232046c = i17;
            this.f232047d = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createCacheId(String str, String str2) {
        return str + str2;
    }

    private void doCommandClickLogic(boolean z16, @NonNull CommonBotInfo commonBotInfo, @NonNull CommonBotFeatureInfo commonBotFeatureInfo, EditText editText, Activity activity) {
        f.isSlashListeningBlocked = true;
        f.isAtListeningBlocked = true;
        String removeSearchMessage = removeSearchMessage(editText);
        if (!z16) {
            hx1.b.c(activity, editText, String.valueOf(commonBotInfo.getTinyid()), commonBotInfo.getName(), false);
        }
        hx1.b.d(editText, commonBotFeatureInfo.getName() + " ");
        zo0.a aVar = f.guildRobotAtHelper;
        if (aVar != null) {
            aVar.b(commonBotInfo);
        }
        f.isAtListeningBlocked = false;
        if (isInlineSearchCommand(commonBotFeatureInfo)) {
            hx1.b.d(editText, removeSearchMessage);
        }
    }

    private static EditText getEditText(@NonNull com.tencent.aio.api.runtime.a aVar) {
        k k3 = aVar.e().k(new GuildAioInputMsgIntent.GetInputEditTextEventR());
        if (k3 instanceof a.C10677a) {
            return ((a.C10677a) k3).getInput();
        }
        return null;
    }

    private static boolean isInlineSearchCommand(CommonBotFeatureInfo commonBotFeatureInfo) {
        return commonBotFeatureInfo.getName().trim().equals("/\u641c\u7d22");
    }

    private static boolean isMuted(@NonNull CommonBotInfo commonBotInfo) {
        if ((commonBotInfo.getMark() & 32768) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$jumpPermissionSettingPage$0(Context context) {
        QQToast.makeText(context, R.string.f1511016s, 1).show();
    }

    private static String removeSearchMessage(EditText editText) {
        Editable editableText = editText.getEditableText();
        String trim = editableText.toString().replace("/", "").trim();
        editableText.clear();
        QLog.i(TAG, 1, "removeSearchMessage() invoked. searchMessage: " + trim);
        return trim;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPermissionPage(Context context, String str, String str2, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
        Bundle bundle = new Bundle();
        bundle.putString("guildId", str2);
        bundle.putString("ROBOT_UIN_KEY", str);
        if (gProGuildRobotPermissionRsp != null) {
            bundle.putString("ROBOT_PERMISSION_DATA", this.mGson.toJson(RobotAuthorizeAddInfo.a(gProGuildRobotPermissionRsp)));
        }
        Intent intent = new Intent();
        intent.putExtra("ROBOT_PERMISSION_SETTING_FLAG", bundle);
        QPublicFragmentActivity.start(context, intent, RobotPermissionFragment.class);
    }

    private static d toOldModel(CommonBotInfo commonBotInfo) {
        d dVar = new d();
        dVar.d(commonBotInfo.getName());
        dVar.b(Integer.valueOf(commonBotInfo.getInlineSearch()));
        dVar.e(commonBotInfo.getTinyid());
        dVar.f(commonBotInfo.getUin());
        dVar.a(String.valueOf(commonBotInfo.getAppid()));
        dVar.c(commonBotInfo.getMark());
        return dVar;
    }

    public static void updateCache(Context context, String str, String str2, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
        if (context == null) {
            return;
        }
        b bVar = new b(gProGuildRobotPermissionRsp.getOperatorRole(), gProGuildRobotPermissionRsp.getRole(), gProGuildRobotPermissionRsp.getRobotStatus(), SystemClock.currentThreadTimeMillis());
        cl.j(context, createCacheId(str, str2), new Gson().toJson(bVar));
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public uw1.a createGuildRobotAtManager(Activity activity, ViewGroup viewGroup, AIOParam aIOParam, EditText editText, com.tencent.aio.api.runtime.a aVar) {
        ix1.a aVar2 = new ix1.a(activity, viewGroup, aIOParam, editText);
        aVar2.f408906d = aVar;
        aVar2.P(0);
        return aVar2;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void handleSlashOnCommandItemClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull CommonBotInfo commonBotInfo, @NonNull CommonBotFeatureInfo commonBotFeatureInfo) {
        if (isMuted(commonBotInfo)) {
            QQToast.makeText(aVar.c().requireContext(), 0, R.string.f222486dn).show();
            return;
        }
        EditText editText = getEditText(aVar);
        FragmentActivity activity = aVar.c().getActivity();
        if (editText != null && activity != null) {
            doCommandClickLogic(com.tencent.guild.aio.util.ex.a.i(aVar), commonBotInfo, commonBotFeatureInfo, editText, activity);
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void handleSlashOnServiceItemClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull CommonBotInfo commonBotInfo, @NonNull CommonBotFeatureInfo commonBotFeatureInfo) {
        Context requireContext = aVar.c().requireContext();
        if (isMuted(commonBotInfo)) {
            QQToast.makeText(requireContext, 0, R.string.f222486dn).show();
            return;
        }
        int type = commonBotFeatureInfo.getType();
        if (type == CommonBotFeatureType.MINIAPP.ordinal()) {
            hx1.b.k(requireContext, commonBotFeatureInfo.getUrl());
        } else if (type == CommonBotFeatureType.H5.ordinal()) {
            hx1.b.j(requireContext, commonBotFeatureInfo.getUrl());
        } else {
            QQToast.makeText(requireContext, R.string.f143550md, 1).show();
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void handleSlashOnTitleClick(@NonNull com.tencent.aio.api.runtime.a aVar, @NonNull String str) {
        FragmentActivity activity = aVar.c().getActivity();
        AIOParam g16 = aVar.g();
        if (activity != null && g16 != null) {
            RobotInfoFragment.wh(activity, com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.a.g(g16), str, "", "0", false, 16);
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public boolean isDirectRobotAIO(@NonNull com.tencent.aio.api.runtime.a aVar) {
        return com.tencent.guild.aio.util.ex.a.i(aVar);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public boolean isInlineSearchEnable(Context context) {
        return hx1.b.a(context);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void jumpPermissionSettingPage(AppRuntime appRuntime, final Context context, String str, String str2) {
        if (context == null) {
            QLog.e(TAG, 1, "jumpPermissionSettingPage, context == null");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ww1.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRobotPageApiImpl.lambda$jumpPermissionSettingPage$0(context);
                }
            });
            return;
        }
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotPermission(new GProGuildRobotPermissionReq(Long.parseLong(str2), Long.parseLong(str)), new a(context, str, str2));
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void jumpRobotPushSettingPage(Context context, String str, String str2, int i3, int i16) {
        String str3 = ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getPushMsgSettingLink() + "?botTid=" + str2 + "&guildId=" + str + "&userType=" + i3 + "&source=" + i16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "url = " + str3);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", false);
        bundle.putBoolean("hide_operation_bar", true);
        cx.b(context, str3, bundle);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void openRobotActiveMsgControlDialogFragment(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4) {
        RobotActiveMsgControlDialogFragment.Fh(fragmentActivity, str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void openRobotAuthorizeFragment(@NonNull FragmentActivity fragmentActivity, @NonNull long j3, @NonNull long j16, @NonNull long j17, @NonNull String str, @NonNull vw1.d dVar, @NonNull String str2) {
        RobotAuthorizeAddFragment.Ih(fragmentActivity, j3, j16, j17, str, dVar, str2);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void openRobotFaqPage(Context context, String str) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "guildId \u4e3a\u7a7a");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        String selfTinyId = iGPSService.getSelfTinyId();
        String guildUserNick = iGPSService.getGuildUserNick(str, selfTinyId);
        String avatarUrl = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(peekAppRuntime, str, selfTinyId);
        String addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(URLUtil.addParameterWithoutEncode(bs.i(), "openid", selfTinyId), "nickname", guildUserNick);
        if (avatarUrl != null) {
            try {
                addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(addParameterWithoutEncode, "avatar", URLEncoder.encode(avatarUrl, "utf-8"));
            } catch (UnsupportedEncodingException e16) {
                QLog.e(TAG, 1, "openFaqPage errCode:" + e16.toString());
            }
        }
        sx1.f.k(context, URLUtil.addParameterWithoutEncode(URLUtil.deleteParameter(addParameterWithoutEncode, "_wv"), "_wv", "0"));
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void reportRobotCommandJump(@NonNull View view) {
        kx1.a.c(view);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void reportSlashPageIn(@NonNull View view, @NonNull com.tencent.aio.api.runtime.a aVar) {
        FragmentActivity activity = aVar.c().getActivity();
        AIOParam g16 = aVar.g();
        if (activity != null && g16 != null) {
            c.c(new ReportPageArgs(aVar.c().requireActivity(), view, com.tencent.guild.aio.util.a.g(g16), com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.i(aVar)));
        } else {
            QLog.e(TAG, 1, "[reportSlashPageIn]: activity or aioParam is null");
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void reportSlashPageOut(@NonNull View view, @NonNull com.tencent.aio.api.runtime.a aVar) {
        FragmentActivity activity = aVar.c().getActivity();
        AIOParam g16 = aVar.g();
        if (activity != null && g16 != null) {
            c.d(new ReportPageArgs(activity, view, com.tencent.guild.aio.util.a.g(g16), com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.i(aVar)));
        } else {
            QLog.e(TAG, 1, "[reportSlashPageIn]: activity or aioParam is null");
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi
    public void openRobotAuthorizeFragment(@NonNull FragmentActivity fragmentActivity, @NonNull long j3, @NonNull long j16, @NonNull long j17, @NonNull String str, @NonNull vw1.d dVar, @NonNull int i3) {
        RobotAuthorizeAddFragment.Ih(fragmentActivity, j3, j16, j17, str, dVar, String.valueOf(i3));
    }
}
