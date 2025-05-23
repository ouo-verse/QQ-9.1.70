package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ff;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.zebra.ZebraPluginProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import ud1.GameRankConfig;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCardApiImpl implements ITroopCardApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopCardApiImpl";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294237d;

        a(boolean z16) {
            this.f294237d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294237d) {
                com.tencent.mobileqq.troop.troopcard.ui.m.a(2, new Object());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294239d;

        b(boolean z16) {
            this.f294239d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294239d) {
                com.tencent.mobileqq.troop.troopcard.ui.m.a(2, new Object());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294241d;

        c(boolean z16) {
            this.f294241d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294241d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294243d;

        d(boolean z16) {
            this.f294243d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294243d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294245d;

        e(boolean z16) {
            this.f294245d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294245d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294247d;

        f(boolean z16) {
            this.f294247d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294247d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294249d;

        g(boolean z16) {
            this.f294249d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopCardApiImpl.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (this.f294249d) {
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A57F", 2, 0, "", "", "", "");
            }
        }
    }

    public TroopCardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String getGameRankPageUrl(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            return str.replace("[group-code]", map.get("group-code")).replace("[from]", map.get("from"));
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void ForwardSdkShareOption_startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, activity, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3), str2);
        } else {
            ForwardSdkBaseOption.E(activity, z16, str, j3, i3, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void FreezedLiangGroup(Activity activity, Object obj) {
        int i3;
        String str;
        String str2;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) activity, obj);
            return;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
        if (a16) {
            i3 = 15;
        } else {
            i3 = 8;
        }
        SpannableString j3 = ff.j(0, i3);
        if (troopInfoData.bOwner) {
            String str3 = troopInfoData.troopUin;
            if (j3 != null) {
                str = j3.toString();
            } else {
                str = "";
            }
            String str4 = str;
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            a aVar = new a(a16);
            if (a16) {
                str2 = "0X800A57F";
            } else {
                str2 = "0X8009E38";
            }
            String str5 = str2;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(activity, str3, str4, qqStr, aVar, str5, i16, a16);
            return;
        }
        ff.d0(activity, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void JoinTroopSecurityTipsHelper_showTips(AppInterface appInterface, int i3, long j3, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, appInterface, Integer.valueOf(i3), Long.valueOf(j3), activity);
        } else {
            com.tencent.mobileqq.troop.jointroopsecuritytips.b.a((QQAppInterface) appInterface, i3, j3, activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Intent addFriendLogicActivity_startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? AddFriendLogicActivity.startJoinTroop(context, str, str2, s16, i3, str3, str4, str5, str6, str7, str8, str9) : (Intent) iPatchRedirector.redirect((short) 33, this, context, str, str2, Short.valueOf(s16), Integer.valueOf(i3), str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void addRecentTroopItemIntoRecentMsgList(AppInterface appInterface, String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).f(str, str2, j3);
        } else {
            iPatchRedirector.redirect((short) 39, this, appInterface, str, str2, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public byte[] base64Decode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (byte[]) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.wifi.a.a(str, 0);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void bnrReport(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) appInterface, i3);
        } else {
            qx.a.j(appInterface, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public int[] buildCustomClipDecoderParams(int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (int[]) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
        return com.tencent.mobileqq.urldrawable.a.b(i3, i16, i17, i18, i19, i26);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Dialog createQuestionDialog(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Dialog) iPatchRedirector.redirect((short) 32, (Object) this, (Object) activity);
        }
        return com.tencent.mobileqq.qqexpand.utils.q.b(activity);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Bitmap exifBitmapCreator_createBitmap(Bitmap bitmap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (Bitmap) iPatchRedirector.redirect((short) 57, (Object) this, (Object) bitmap, (Object) str);
        }
        return ((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(str, bitmap);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void freezedLiangGroup(Activity activity, Object obj) {
        int i3;
        String str;
        String str2;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) activity, obj);
            return;
        }
        TroopInfo troopInfo = (TroopInfo) obj;
        boolean a16 = TroopManager.g.a(troopInfo.groupFreezeReason);
        if (a16) {
            i3 = 15;
        } else {
            i3 = 8;
        }
        SpannableString j3 = ff.j(0, i3);
        if (troopInfo.isOwner()) {
            String str3 = troopInfo.troopuin;
            if (j3 != null) {
                str = j3.toString();
            } else {
                str = "";
            }
            String str4 = str;
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            b bVar = new b(a16);
            if (a16) {
                str2 = "0X800A57F";
            } else {
                str2 = "0X8009E38";
            }
            String str5 = str2;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(activity, str3, str4, qqStr, bVar, str5, i16, a16);
            return;
        }
        ff.d0(activity, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Intent getChatActivityIntent(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Intent) iPatchRedirector.redirect((short) 34, (Object) this, (Object) activity, i3);
        }
        if (i3 == 30) {
            return new Intent(activity, (Class<?>) ChatActivity.class);
        }
        return com.tencent.mobileqq.activity.aio.l.w(activity, SplashActivity.getAliasName());
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public String getFriendDisplayName(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this, (Object) appInterface, (Object) str);
        }
        return ac.y((QQAppInterface) appInterface, str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void getFriendInfo(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) appInterface, (Object) str);
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Object getHighwayConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return FMTSrvAddrProvider.getInstance().getHighwayConfig();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void getOpenID(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInterface, (Object) str);
        } else {
            com.tencent.mobileqq.app.handler.a.a(((QQAppInterface) appInterface).getMsgHandler(), str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Object getOpenIDFromCacheAndDB(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface, (Object) str);
        }
        return ((QQAppInterface) appInterface).getMsgHandler().b3(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Class<?> getTroopAdminListClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Class) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return TroopAdminList.class;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Class<?> getTroopAvatarWallEditActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Class) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return TroopAvatarWallEditActivity.class;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public String getTroopCardTipsContent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
        }
        String string = context.getString(R.string.f23334770);
        com.tencent.mobileqq.troop.troopgame.a aVar = (com.tencent.mobileqq.troop.troopgame.a) am.s().x(695);
        if (aVar != null && !TextUtils.isEmpty(aVar.d())) {
            return aVar.d();
        }
        return string;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Class<?> getTroopClassChoiceActivtiyClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Class) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return TroopClassChoiceActivity.class;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public String getTroopGameCardResDownloadPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopgame.c.e();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Class<?> getTroopTagViewActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Class) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return TroopTagViewActivity.class;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Object get_CUSTOM_CLIP_DECODER() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return com.tencent.mobileqq.urldrawable.a.f306344x;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void goToMsgList(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) activity);
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.addFlags(67108864);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        activity.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleAppShareAction(AppRuntime appRuntime, Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, appRuntime, activity, intent);
            return;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
        m3.putExtras(new Bundle(intent.getExtras()));
        ForwardUtils.p((QQAppInterface) appRuntime, activity, ForwardUtils.n0(m3), m3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleEditClosed(boolean z16, View view, Bundle bundle) {
        Rect d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, Boolean.valueOf(z16), view, bundle);
        } else if (!z16 && (d16 = com.tencent.common.galleryactivity.j.d(view)) != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", d16);
        }
    }

    public void handleGotoBigPic(Object obj, Context context) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, obj, (Object) context);
            return;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
        if (troopInfoData.bOwner) {
            String str2 = troopInfoData.troopUin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            g gVar = new g(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            String str3 = str;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(context, str2, spannableString, qqStr, gVar, str3, i16, a16);
            return;
        }
        ff.d0(context, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleModiftyTroopHeadFreezed(Object obj, Context context) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, obj, (Object) context);
            return;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
        if (troopInfoData.bOwner) {
            String str2 = troopInfoData.troopUin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            e eVar = new e(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            String str3 = str;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(context, str2, spannableString, qqStr, eVar, str3, i16, a16);
            return;
        }
        ff.d0(context, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleModifyNameFreezed(Object obj, Context context) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, obj, (Object) context);
            return;
        }
        TroopInfoData troopInfoData = (TroopInfoData) obj;
        boolean a16 = TroopManager.g.a(troopInfoData.groupFreezeReason);
        if (troopInfoData.bOwner) {
            String str2 = troopInfoData.troopUin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.kgm);
            c cVar = new c(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            String str3 = str;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(context, str2, spannableString, qqStr, cVar, str3, i16, a16);
            return;
        }
        ff.d0(context, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleModifyNameFreezedByTroopInfo(Object obj, Context context) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, obj, (Object) context);
            return;
        }
        TroopInfo troopInfo = (TroopInfo) obj;
        boolean a16 = TroopManager.g.a(troopInfo.groupFreezeReason);
        if (troopInfo.isOwner()) {
            String str2 = troopInfo.troopuin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.kgm);
            d dVar = new d(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            String str3 = str;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(context, str2, spannableString, qqStr, dVar, str3, i16, a16);
            return;
        }
        ff.d0(context, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void handleModifyTroopHeadFreezedByTroopInfo(Object obj, Context context) {
        int i3;
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, obj, (Object) context);
            return;
        }
        TroopInfo troopInfo = (TroopInfo) obj;
        boolean a16 = TroopManager.g.a(troopInfo.groupFreezeReason);
        if (troopInfo.isOwner()) {
            String str2 = troopInfo.troopuin;
            if (a16) {
                i3 = 15;
            } else {
                i3 = 8;
            }
            String spannableString = ff.j(0, i3).toString();
            String qqStr = HardCodeUtil.qqStr(R.string.j6l);
            f fVar = new f(a16);
            if (a16) {
                str = "0X800A57F";
            } else {
                str = "0X8009E38";
            }
            String str3 = str;
            if (a16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ff.b0(context, str2, spannableString, qqStr, fVar, str3, i16, a16);
            return;
        }
        ff.d0(context, a16);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public boolean isFastDoubleClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return UIUtils.n();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public boolean isInstanceOfTroopAvatarWallEditActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity)).booleanValue();
        }
        return activity instanceof TroopAvatarWallEditActivity;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void jionTroopFromTroopAssociation(Context context, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, obj);
        } else {
            com.tencent.mobileqq.troop.associations.a.a(context, (AssociatedTroopItem) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public URL nearbyImgDownloader_convertURL(String str) throws MalformedURLException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (URL) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return NearbyImgDownloader.convertURL(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public boolean needAnswerQuestion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str)).booleanValue();
        }
        return ((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void openAddTroopWebInfo(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, activity, str, str2);
            return;
        }
        String str3 = str + "?_wv=1031&troopUin=" + str2 + "&isVerify=0";
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str3);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        intent.putExtra("show_right_close_button", true);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void openGameRankPage(Context context, Map<String, String> map) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) context, (Object) map);
            return;
        }
        GameRankConfig gameRankConfig = ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getGameRankConfig();
        if (gameRankConfig != null) {
            if (gameRankConfig.getGameRankPageType() == 1 && !TextUtils.isEmpty(gameRankConfig.getGameRankH5Url())) {
                String gameRankPageUrl = getGameRankPageUrl(gameRankConfig.getGameRankH5Url(), map);
                Intent intent = new Intent();
                intent.putExtra("url", gameRankPageUrl);
                RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                return;
            }
            if (gameRankConfig.getGameRankPageType() == 0 && !TextUtils.isEmpty(gameRankConfig.getGameRankHippyPageUrl())) {
                String gameRankPageUrl2 = getGameRankPageUrl(gameRankConfig.getGameRankHippyPageUrl(), map);
                OpenHippyInfo openHippyInfo = new OpenHippyInfo();
                openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_GUILD;
                openHippyInfo.url = gameRankPageUrl2;
                openHippyInfo.errorUrl = gameRankConfig.getGameRankHippyPageErrorUrl();
                Uri parse = Uri.parse(gameRankPageUrl2);
                if (parse.isHierarchical()) {
                    String host = parse.getHost();
                    if (!TextUtils.isEmpty(host) && (split = host.split("\\.")) != null && split.length > 0) {
                        int max = Math.max(0, split.length - 3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(split[max]);
                        for (int i3 = max + 1; i3 < split.length; i3++) {
                            sb5.append('.');
                            sb5.append(split[i3]);
                        }
                        openHippyInfo.domain = sb5.toString();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "openGameRankPage, domain=", openHippyInfo.domain);
                        }
                    }
                }
                openHippyInfo.isStatusBarDarkFont = true;
                openHippyInfo.isEnbaleRightFling = false;
                openHippyInfo.updateJsBundleType = 1;
                openHippyInfo.isTransparent = true;
                ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void openTroopAssociationWebPage(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) str);
        } else {
            com.tencent.mobileqq.troop.associations.a.b(context, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void openTroopInfoFromTroopAssociation(Context context, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, obj);
        } else {
            com.tencent.mobileqq.troop.associations.a.c(context, (AssociatedTroopItem) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public int parseColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
        }
        return com.tencent.mobileqq.util.n.a(str);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Uri profileCardUtils_enterSnapshot(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Uri) iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity, i3);
        }
        return ProfileCardUtils.enterSnapshot(activity, i3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void refreshTroopFace(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) appInterface, (Object) str);
        } else {
            ((QQAppInterface) appInterface).refreshTroopFace(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void reportGameCardStatus(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime == null) {
            return;
        }
        QLog.d(TAG, 1, "reportGroupGameCardStatus");
        List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
        if (joinedTroopInfoFromCache != null && joinedTroopInfoFromCache.size() > 0) {
            for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
                if (troopInfo.isTroopGameCardEnabled()) {
                    WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
                    wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setBussinessId("1").setPageId("122").setOperModule(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR).setOperId("209461").setModuleType("104705").setExt(2, String.valueOf(troopInfo.wMemberNum)).setExt(3, troopInfo.getTroopUin()).setExt(6, String.valueOf(troopInfo.nTroopGrade));
                    wadlReportBuilder.report();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void reportTask(AppInterface appInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, appInterface, str, Integer.valueOf(i3));
        } else {
            new com.tencent.mobileqq.statistics.q((QQAppInterface) appInterface).i("dc00899").a("Grp_private").f("Grp_data").d("exp").b(str, String.valueOf(i3)).g();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void secRecognize(boolean z16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), view);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void setNightModeFilterForDrawable(AppInterface appInterface, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface, (Object) drawable);
        } else {
            ProfileCardUtils.setNightModeFilterForDrawable(appInterface, drawable);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public boolean shouldShowGameRankEntrance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        GameRankConfig gameRankConfig = ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getGameRankConfig();
        if (gameRankConfig != null) {
            return gameRankConfig.getShowGameRank();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startModifyHomeworkTroopNickname(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, context, str, str2, str3);
        } else {
            com.tencent.mobileqq.troop.utils.d.c(context, str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startModifyLocationActivityForResultEx(Activity activity, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, activity, str, str2, Integer.valueOf(i3));
        } else {
            TroopLocationModifyActivity.startModifyLocationActivityForResultEx(activity, str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startPhotoEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2, str3);
        } else {
            PhotoUtils.startPhotoEdit(intent, activity, str, i3, i16, i17, i18, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startPhotoEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, intent, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2, str3, Integer.valueOf(i19));
        } else {
            PhotoUtils.startPhotoEditForResult(intent, activity, str, i3, i16, i17, i18, str2, str3, i19);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startPhotoList(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
        } else {
            ZebraPluginProxy.startPhotoList(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startPhotoListEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, intent, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2);
        } else {
            PhotoUtils.startPhotoListEdit(intent, activity, str, i3, i16, i17, i18, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void startPhotoListEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, intent, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str2, Integer.valueOf(i19));
        } else {
            PhotoUtils.startPhotoListEditForResult(intent, activity, str, i3, i16, i17, i18, str2, i19);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void storyReportor(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public Intent addFriendLogicActivity_startJoinTroop(Context context, String str, String str2, short s16, int i3, String str3, String str4, String str5, String str6, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) ? AddFriendLogicActivity.n3(context, str, str2, s16, i3, str3, str4, str5, str6, str7) : (Intent) iPatchRedirector.redirect((short) 48, this, context, str, str2, Short.valueOf(s16), Integer.valueOf(i3), str3, str4, str5, str6, str7);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCardApi
    public void addRecentTroopItemIntoRecentMsgList(AppRuntime appRuntime, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).d((TroopInfo) obj);
        } else {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) appRuntime, obj);
        }
    }
}
