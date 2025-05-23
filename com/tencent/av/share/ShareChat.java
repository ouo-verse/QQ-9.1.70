package com.tencent.av.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.Constants;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.av.ReqGroupVideo$ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo$ReqPushShareArk;
import com.tencent.av.ReqGroupVideo$RspCreateShareUrl;
import com.tencent.av.ReqGroupVideo$RspPushShareArk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.common$ErrorInfo;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.g;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.aj;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShareChat {

    /* renamed from: a, reason: collision with root package name */
    String f74419a;

    /* renamed from: b, reason: collision with root package name */
    protected QBaseActivity f74420b;

    /* renamed from: c, reason: collision with root package name */
    QQAppInterface f74421c;

    /* renamed from: d, reason: collision with root package name */
    long f74422d;

    /* renamed from: e, reason: collision with root package name */
    int f74423e;

    /* renamed from: f, reason: collision with root package name */
    protected String f74424f;

    /* renamed from: g, reason: collision with root package name */
    protected String f74425g;

    /* renamed from: h, reason: collision with root package name */
    SharePanel f74426h;

    /* renamed from: i, reason: collision with root package name */
    protected TroopInfoData f74427i = new TroopInfoData();

    /* renamed from: j, reason: collision with root package name */
    boolean f74428j = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class MyResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private int f74429d;

        /* renamed from: e, reason: collision with root package name */
        private int f74430e;

        /* renamed from: f, reason: collision with root package name */
        private long f74431f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<SharePanel> f74432h;

        public MyResultReceiver(Handler handler, SharePanel sharePanel, int i3, int i16, long j3) {
            super(handler);
            this.f74432h = new WeakReference<>(sharePanel);
            this.f74429d = i3;
            this.f74430e = i16;
            this.f74431f = j3;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            SharePanel sharePanel = this.f74432h.get();
            if (sharePanel == null) {
                return;
            }
            int i16 = this.f74429d;
            if (i16 == 1) {
                QLog.w("ShareChat", 1, "shareToQzone.onReceiveResult, resultCode[" + i3 + "], seq[" + this.f74431f + "]");
                sharePanel.g(3, this.f74430e, i3 != -1 ? 3 : 2);
                return;
            }
            if (i16 == 2 || i16 == 3) {
                QLog.w("ShareChat", 1, "shareToMobileQQ.onReceiveResult, resultCode[" + i3 + "], seq[" + this.f74431f + "]");
                sharePanel.g(2, this.f74430e, i3 == -1 ? 2 : 3);
                return;
            }
            if (i16 != 4) {
                if (i16 != 5) {
                    return;
                }
                QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[" + i3 + "], seq[" + this.f74431f + "]");
                sharePanel.g(123, this.f74430e, 3);
                return;
            }
            QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_QRForwardReceiver, resultCode[" + i3 + "], seq[" + this.f74431f + "], mIHandle[" + sharePanel.f74438f + "]");
            SharePanel.b bVar = sharePanel.f74438f;
            if (bVar != null) {
                bVar.c(123, this.f74430e, i3 != -1 ? 3 : 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class SharePanel {

        /* renamed from: a, reason: collision with root package name */
        final long f74433a;

        /* renamed from: c, reason: collision with root package name */
        int f74435c;

        /* renamed from: d, reason: collision with root package name */
        ShareActionSheet f74436d;

        /* renamed from: e, reason: collision with root package name */
        c f74437e;

        /* renamed from: b, reason: collision with root package name */
        int f74434b = 0;

        /* renamed from: f, reason: collision with root package name */
        b f74438f = null;

        /* renamed from: g, reason: collision with root package name */
        String f74439g = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (QLog.isColorLevel()) {
                    QLog.w("ShareChat", 1, "ShareActionSheetBuilder.onDismiss, mChoosedChannel[" + SharePanel.this.f74434b + "], mIHandle[" + SharePanel.this.f74438f + "]");
                }
                SharePanel sharePanel = SharePanel.this;
                int i3 = sharePanel.f74434b;
                if (i3 != 0 || sharePanel.f74438f == null) {
                    return;
                }
                sharePanel.g(i3, sharePanel.f74435c, 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public interface b {
            TroopInfoData a();

            int b();

            void c(int i3, int i16, int i17);

            Bitmap d(long j3);

            void e(int i3, int i16, int i17);

            String f(int i3);

            int g();

            String getDesc();

            String getHeadUrl();

            long getRoomId();

            String h(long j3, int i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class c implements ShareActionSheet.OnItemClickListener {

            /* renamed from: d, reason: collision with root package name */
            long f74446d = 0;

            /* renamed from: e, reason: collision with root package name */
            Context f74447e;

            public c(Context context) {
                this.f74447e = context;
            }

            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                int i3;
                int i16;
                Context context = this.f74447e;
                if (context == null) {
                    return;
                }
                ShareActionSheet shareActionSheet2 = SharePanel.this.f74436d;
                if (shareActionSheet2 != null) {
                    shareActionSheet2.dismiss();
                }
                SharePanel sharePanel = SharePanel.this;
                if (sharePanel.f74438f == null) {
                    return;
                }
                int i17 = actionSheetItem.action;
                if (i17 != 1) {
                    i3 = 2;
                    if (i17 != 2) {
                        if (i17 != 3) {
                            i3 = 6;
                            if (i17 != 6) {
                                i3 = 24;
                                if (i17 != 24) {
                                    i3 = 26;
                                    if (i17 != 26) {
                                        i3 = 123;
                                        if (i17 != 123) {
                                            if (i17 == 9) {
                                                i3 = 9;
                                            } else if (i17 != 10) {
                                                i3 = 72;
                                                if (i17 != 72) {
                                                    i3 = 73;
                                                    if (i17 != 73) {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                i3 = 10;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            i3 = 3;
                        }
                    }
                } else {
                    i3 = 1;
                }
                sharePanel.f74434b = i3;
                if (i3 == 9 || i3 == 10) {
                    if (WXShareHelper.b0().e0()) {
                        i16 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
                    } else {
                        i16 = R.string.f173257ih1;
                    }
                    if (i16 != -1) {
                        Context context2 = this.f74447e;
                        QQToast.makeText(context2, context2.getString(i16), 0).show();
                        SharePanel sharePanel2 = SharePanel.this;
                        sharePanel2.g(sharePanel2.f74434b, sharePanel2.f74435c, 3);
                        return;
                    }
                }
                QLog.w("ShareChat", 1, "onItemClick, mChoosedChannel[" + SharePanel.this.f74434b + "], position[], id[" + i3 + "], seq[" + this.f74446d + "], mChoosedLinkType[" + SharePanel.this.f74435c + "]");
                SharePanel sharePanel3 = SharePanel.this;
                if (sharePanel3.f74435c == -1) {
                    sharePanel3.f(this.f74446d, context, actionSheetItem);
                } else {
                    sharePanel3.e(this.f74446d, context, actionSheetItem);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class d implements WXShareHelper.a {

            /* renamed from: d, reason: collision with root package name */
            WeakReference<SharePanel> f74449d;

            /* renamed from: e, reason: collision with root package name */
            long f74450e;

            /* renamed from: f, reason: collision with root package name */
            WeakReference<Context> f74451f;

            /* renamed from: h, reason: collision with root package name */
            String f74452h;

            /* renamed from: i, reason: collision with root package name */
            int f74453i;

            /* renamed from: m, reason: collision with root package name */
            int f74454m;

            d(SharePanel sharePanel, long j3, Context context, String str, int i3, int i16) {
                this.f74449d = new WeakReference<>(sharePanel);
                this.f74450e = j3;
                this.f74451f = new WeakReference<>(context);
                this.f74452h = str;
                this.f74453i = i3;
                this.f74454m = i16;
            }

            @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
            public void onWXShareResp(BaseResp baseResp) {
                QLog.w("ShareChat", 1, "onWXShareResp, mWXTransaction[" + this.f74452h + "], transaction[" + baseResp.transaction + "], errCode[" + baseResp.errCode + "], seq[" + this.f74450e + "]");
                if (TextUtils.equals(this.f74452h, baseResp.transaction)) {
                    SharePanel sharePanel = this.f74449d.get();
                    Context context = this.f74451f.get();
                    if (sharePanel == null || context == null) {
                        return;
                    }
                    int i3 = baseResp.errCode;
                    if (i3 != -2) {
                        if (i3 != 0) {
                            QQToast.makeText(context, 1, context.getString(R.string.hit), 0).show();
                        } else {
                            QQToast.makeText(context, 2, context.getString(R.string.hj9), 0).show();
                        }
                    }
                    WXShareHelper.b0().q0(this);
                    sharePanel.g(this.f74453i, this.f74454m, baseResp.errCode != 0 ? 3 : 2);
                }
            }
        }

        SharePanel(long j3, int i3) {
            this.f74435c = i3;
            this.f74433a = j3;
        }

        private void c(long j3, Context context, int i3, b bVar, String str) {
            String str2 = context.getString(R.string.f171017iq4) + str;
            if (QLog.isColorLevel()) {
                QLog.w("ShareChat", 1, "copyTroopLink, text[" + str2 + "], seq[" + j3 + "]");
            }
            ClipboardMonitor.setPrimaryClip((ClipboardManager) context.getSystemService("clipboard"), ClipData.newPlainText("troop_url", str2));
            QQToast.makeText(context, 2, R.string.iq5, 0).show();
            g(1, i3, 2);
        }

        private void k(long j3, Context context, int i3, b bVar, String str, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            Context context2;
            long j16;
            String str2 = "]";
            if (bVar == null || actionSheetItem == null) {
                return;
            }
            try {
                Object m3 = ShareChat.m(context);
                String m16 = ShareChat.m(context);
                String g16 = ShareChat.g(bVar);
                try {
                    String i16 = ShareChat.i(bVar);
                    try {
                        String string = context.getString(R.string.f171015iq2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("prompt", m3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("forward", true);
                            jSONObject2.put("autosize", true);
                            jSONObject.put(DownloadInfo.spKey_Config, jSONObject2);
                            jSONObject.put("app", IShareChatApi.GAV_ARK_APP_NAME);
                            jSONObject.put("ver", Constants.DEFAULT_MIN_APP_VERSION);
                            jSONObject.put("view", "qqavchat");
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("title", m16);
                            jSONObject4.put("desc", g16);
                            jSONObject4.put("preview", i16);
                            jSONObject4.put("tag", string);
                            jSONObject4.put(WadlProxyConsts.KEY_JUMP_URL, str);
                            if (bVar.b() == 99) {
                                TroopInfoData a16 = bVar.a();
                                jSONObject4.put(IShareChatApi.GAV_ARK_FROM_TYPE, IShareChatApi.GAV_ARK_FROM_CHATTING);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_NAME_KEY, a16.troopName);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_OWNER_KEY, a16.bOwner);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_ADMIN_KEY, a16.bAdmin);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_CARD_KEY, a16.troopCard);
                                jSONObject4.put(IShareChatApi.GAV_ARK_ROOM_ID_KEY, bVar.getRoomId());
                                jSONObject4.put(IShareChatApi.GAV_ARK_ROOM_CREATE_TIME_KEY, bVar.g());
                            } else {
                                jSONObject4.put(IShareChatApi.GAV_ARK_FROM_TYPE, IShareChatApi.GAV_ARK_FROM_INVITE);
                            }
                            jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_UIN_KEY, this.f74439g);
                            String f16 = bVar.f(2);
                            if (!TextUtils.isEmpty(f16)) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("type", f16);
                                jSONObject5.put("name", f16);
                                jSONObject5.put(AdMetricTag.Report.TYPE, "898");
                                jSONObject5.put("r2", StringUtil.stringToLong("ShareChat", this.f74439g));
                                jSONObject4.put("report", jSONObject5);
                            }
                            jSONObject3.put("news", jSONObject4);
                            jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject3);
                            String jSONObject6 = jSONObject.toString();
                            String string2 = jSONObject.getString("app");
                            String string3 = jSONObject.getString("ver");
                            String string4 = jSONObject.getString("view");
                            String optString = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                            String string5 = jSONObject.getString(DownloadInfo.spKey_Config);
                            String string6 = jSONObject.getString(PublicAccountMessageUtilImpl.META_NAME);
                            String string7 = jSONObject.getString("prompt");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("shareToMobileQQ, data[");
                            sb5.append(jSONObject6);
                            sb5.append("], appName[");
                            sb5.append(string2);
                            sb5.append("], appMinVersion[");
                            sb5.append(string3);
                            sb5.append("], appView[");
                            sb5.append(string4);
                            sb5.append("], config[");
                            sb5.append(string5);
                            sb5.append("], metaList[");
                            sb5.append(string6);
                            sb5.append("], promptText[");
                            sb5.append(string7);
                            sb5.append("], seq[");
                            j16 = j3;
                            try {
                                sb5.append(j16);
                                str2 = "]";
                                try {
                                    sb5.append(str2);
                                    QLog.w("ShareChat", 1, sb5.toString());
                                    Intent intent = new Intent();
                                    intent.putExtra("forward_type", 27);
                                    intent.putExtra("is_ark_display_share", true);
                                    intent.putExtra("forward_ark_app_name", string2);
                                    intent.putExtra("forward_ark_app_view", string4);
                                    intent.putExtra("forward_ark_biz_src", optString);
                                    intent.putExtra("forward_ark_app_ver", string3);
                                    intent.putExtra("forward_ark_app_prompt", string7);
                                    intent.putExtra("forward_ark_app_meta", string6);
                                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, string5);
                                    Bundle a17 = QQCustomArkDialog.b.a(string2, string4, optString, string3, string6, context.getResources().getDisplayMetrics().scaledDensity, null, null);
                                    a17.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                    a17.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                                    a17.putString("key_direct_show_uin", actionSheetItem.uin);
                                    intent.putExtras(a17);
                                    intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(new Handler(), this, 3, i3, j3));
                                    context2 = context;
                                    try {
                                        ForwardBaseOption.startForwardActivityForResult((Activity) context2, intent, (Class<?>) ForwardRecentTranslucentActivity.class, -1);
                                    } catch (Exception e16) {
                                        e = e16;
                                        QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                                        QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                                        g(2, i3, 3);
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    context2 = context;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                context2 = context;
                                str2 = "]";
                                QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                                QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                                g(2, i3, 3);
                            }
                        } catch (Exception e19) {
                            e = e19;
                            j16 = j3;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        context2 = context;
                        str2 = "]";
                        j16 = j3;
                    }
                } catch (Exception e27) {
                    e = e27;
                    context2 = context;
                    str2 = "]";
                    j16 = j3;
                    QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                    QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                    g(2, i3, 3);
                }
            } catch (Exception e28) {
                e = e28;
                context2 = context;
            }
        }

        private void o(long j3, Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            b bVar = this.f74438f;
            if (bVar == null) {
                QLog.w("ShareChat", 1, "tryToGetShareLink, mIHandle\u4e3a\u7a7a");
                return;
            }
            String h16 = bVar.h(j3, this.f74435c);
            if (TextUtils.isEmpty(h16)) {
                boolean isNetSupport = NetworkUtil.isNetSupport(null);
                QLog.w("ShareChat", 1, "tryToGetShareLink, url\u4e3a\u7a7a, isConn[" + isNetSupport + "], mChoosedChannel[" + this.f74434b + "], mChoosedLinkType[" + this.f74435c + "], seq[" + j3 + "]");
                if (!isNetSupport && this.f74434b != 1) {
                    QQToast.makeText(context, context.getString(R.string.b3j), 0).show();
                    if (QLog.isColorLevel()) {
                        QLog.w("ShareChat", 1, "tryToGetShareLink, !isNetSupport, mChoosedChannel[" + this.f74434b + "]");
                    }
                } else {
                    QQToast.makeText(context, HardCodeUtil.qqStr(R.string.td6), 0).show();
                }
                g(this.f74434b, this.f74435c, 3);
                return;
            }
            int i3 = this.f74434b;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        j(j3, context, this.f74435c, this.f74438f, h16);
                        return;
                    }
                    if (i3 == 6) {
                        if (QfavBuilder.a0(h16).g(context, actionSheetItem.uin, 103, null)) {
                            QQToast.makeText(context, 2, R.string.b3n, 0).show();
                            return;
                        }
                        return;
                    }
                    if (i3 == 26) {
                        i(j3, context, this.f74435c, this.f74438f, h16);
                        return;
                    }
                    if (i3 == 123) {
                        n(j3, context, this.f74435c, this.f74438f, h16);
                        return;
                    }
                    if (i3 == 9) {
                        l(j3, context, false, this.f74435c, h16, this.f74438f);
                        return;
                    }
                    if (i3 == 10) {
                        l(j3, context, true, this.f74435c, h16, this.f74438f);
                        return;
                    } else if (i3 == 72) {
                        k(j3, context, this.f74435c, this.f74438f, h16, actionSheetItem);
                        return;
                    } else if (i3 != 73) {
                        return;
                    }
                }
                h(j3, context, this.f74435c, this.f74438f, h16, actionSheetItem);
                return;
            }
            c(j3, context, this.f74435c, this.f74438f, h16);
        }

        void a(long j3, Context context, String str, int i3, int i16) {
            WXShareHelper.b0().A(new d(this, j3, context, str, i3, i16));
        }

        void d(Context context, int i3) {
            if (this.f74436d != null) {
                return;
            }
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = context;
            param.fullScreen = false;
            ShareActionSheet create = ShareActionSheetFactory.create(param);
            this.f74436d = create;
            if (context != null) {
                create.setActionSheetTitle(context.getString(R.string.hja));
                this.f74436d.setIntentForStartForwardRecentActivity((Intent) ((Activity) context).getIntent().clone());
            }
            this.f74436d.setRowVisibility(0, 0, 0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
            if (i3 != 99) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
            }
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
            if (i3 != 99) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(123));
            }
            this.f74436d.setActionSheetItems(arrayList, arrayList2);
            this.f74436d.setOnDismissListener(new a());
            this.f74436d.setItemClickListenerV2(this.f74437e);
        }

        void g(int i3, int i16, int i17) {
            b bVar = this.f74438f;
            if (bVar != null) {
                bVar.e(i3, i16, i17);
            }
            b();
        }

        public void h(long j3, Context context, int i3, b bVar, String str, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            Context context2;
            long j16;
            String str2 = "]";
            if (bVar == null) {
                return;
            }
            try {
                Object m3 = ShareChat.m(context);
                String m16 = ShareChat.m(context);
                String g16 = ShareChat.g(bVar);
                try {
                    String i16 = ShareChat.i(bVar);
                    try {
                        String string = context.getString(R.string.f171015iq2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("prompt", m3);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("forward", true);
                            jSONObject2.put("autosize", true);
                            jSONObject.put(DownloadInfo.spKey_Config, jSONObject2);
                            jSONObject.put("app", IShareChatApi.GAV_ARK_APP_NAME);
                            jSONObject.put("ver", Constants.DEFAULT_MIN_APP_VERSION);
                            jSONObject.put("view", "qqavchat");
                            JSONObject jSONObject3 = new JSONObject();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("title", m16);
                            jSONObject4.put("desc", g16);
                            jSONObject4.put("preview", i16);
                            jSONObject4.put("tag", string);
                            jSONObject4.put(WadlProxyConsts.KEY_JUMP_URL, str);
                            if (bVar.b() == 99) {
                                TroopInfoData a16 = bVar.a();
                                jSONObject4.put(IShareChatApi.GAV_ARK_FROM_TYPE, IShareChatApi.GAV_ARK_FROM_CHATTING);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_NAME_KEY, a16.troopName);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_OWNER_KEY, a16.bOwner);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_ADMIN_KEY, a16.bAdmin);
                                jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_CARD_KEY, a16.troopCard);
                                jSONObject4.put(IShareChatApi.GAV_ARK_ROOM_ID_KEY, bVar.getRoomId());
                                jSONObject4.put(IShareChatApi.GAV_ARK_ROOM_CREATE_TIME_KEY, bVar.g());
                            } else {
                                jSONObject4.put(IShareChatApi.GAV_ARK_FROM_TYPE, IShareChatApi.GAV_ARK_FROM_INVITE);
                            }
                            jSONObject4.put(IShareChatApi.GAV_ARK_GROUP_UIN_KEY, this.f74439g);
                            String f16 = bVar.f(2);
                            if (!TextUtils.isEmpty(f16)) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("type", f16);
                                jSONObject5.put("name", f16);
                                jSONObject5.put(AdMetricTag.Report.TYPE, "898");
                                jSONObject5.put("r2", StringUtil.stringToLong("ShareChat", this.f74439g));
                                jSONObject4.put("report", jSONObject5);
                            }
                            jSONObject3.put("news", jSONObject4);
                            jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, jSONObject3);
                            String jSONObject6 = jSONObject.toString();
                            String string2 = jSONObject.getString("app");
                            String string3 = jSONObject.getString("ver");
                            String string4 = jSONObject.getString("view");
                            String optString = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                            String string5 = jSONObject.getString(DownloadInfo.spKey_Config);
                            String string6 = jSONObject.getString(PublicAccountMessageUtilImpl.META_NAME);
                            String string7 = jSONObject.getString("prompt");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("shareToMobileQQ, data[");
                            sb5.append(jSONObject6);
                            sb5.append("], appName[");
                            sb5.append(string2);
                            sb5.append("], appMinVersion[");
                            sb5.append(string3);
                            sb5.append("], appView[");
                            sb5.append(string4);
                            sb5.append("], config[");
                            sb5.append(string5);
                            sb5.append("], metaList[");
                            sb5.append(string6);
                            sb5.append("], promptText[");
                            sb5.append(string7);
                            sb5.append("], seq[");
                            j16 = j3;
                            try {
                                sb5.append(j16);
                                str2 = "]";
                                try {
                                    sb5.append(str2);
                                    QLog.w("ShareChat", 1, sb5.toString());
                                    Intent intent = new Intent();
                                    intent.putExtra("forward_type", 27);
                                    intent.putExtra("is_ark_display_share", true);
                                    intent.putExtra("forward_ark_app_name", string2);
                                    intent.putExtra("forward_ark_app_view", string4);
                                    intent.putExtra("forward_ark_biz_src", optString);
                                    intent.putExtra("forward_ark_app_ver", string3);
                                    intent.putExtra("forward_ark_app_prompt", string7);
                                    intent.putExtra("forward_ark_app_meta", string6);
                                    intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, string5);
                                    intent.putExtras(QQCustomArkDialog.b.a(string2, string4, optString, string3, string6, context.getResources().getDisplayMetrics().scaledDensity, null, null));
                                    intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(new Handler(), this, 2, i3, j3));
                                    context2 = context;
                                    try {
                                        ForwardBaseOption.startForwardActivity(context2, intent);
                                    } catch (Exception e16) {
                                        e = e16;
                                        QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                                        QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                                        g(2, i3, 3);
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    context2 = context;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                context2 = context;
                                str2 = "]";
                                QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                                QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                                g(2, i3, 3);
                            }
                        } catch (Exception e19) {
                            e = e19;
                            j16 = j3;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        context2 = context;
                        str2 = "]";
                        j16 = j3;
                    }
                } catch (Exception e27) {
                    e = e27;
                    context2 = context;
                    str2 = "]";
                    j16 = j3;
                    QLog.w("ShareChat", 1, "shareToMobileQQ, Exception, seq[" + j16 + str2, e);
                    QQToast.makeText(context2, HardCodeUtil.qqStr(R.string.td8), 0).show();
                    g(2, i3, 3);
                }
            } catch (Exception e28) {
                e = e28;
                context2 = context;
            }
        }

        void m(Context context, String str, int i3, b bVar) {
            this.f74439g = str;
            this.f74438f = bVar;
            c cVar = new c(context);
            this.f74437e = cVar;
            cVar.f74446d = this.f74433a;
            d(context, i3);
            this.f74436d.show();
        }

        public String toString() {
            return this.f74433a + "";
        }

        void b() {
            this.f74434b = 0;
        }

        void e(long j3, Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            this.f74435c = 0;
            o(j3, context, actionSheetItem);
        }

        void f(long j3, Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            this.f74435c = 1;
            o(j3, context, actionSheetItem);
        }

        void n(long j3, final Context context, final int i3, b bVar, String str) {
            int i16;
            final TroopInfoData a16 = bVar.a();
            if (a16 == null) {
                g(123, i3, 3);
                return;
            }
            final Intent intent = new Intent(context, (Class<?>) QRDisplayActivity.class);
            intent.putExtra("title", context.getString(R.string.vo7));
            if (TextUtils.isEmpty(a16.troopName)) {
                intent.putExtra("nick", a16.newTroopName);
            } else {
                intent.putExtra("nick", a16.troopName);
            }
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
            intent.putExtra("url", str);
            intent.putExtra("uin", a16.troopUin);
            if (a16.bOwner) {
                i16 = 0;
            } else {
                i16 = a16.bAdmin ? 1 : 2;
            }
            intent.putExtra("adminLevel", i16);
            intent.putExtra("type", 11);
            intent.putExtra("GroupFlagExt", a16.dwGroupFlagExt);
            intent.putExtra("AuthGroupType", a16.dwAuthGroupType);
            QQAppInterface qQAppInterface = appInterface instanceof QQAppInterface ? (QQAppInterface) appInterface : null;
            boolean V = qQAppInterface != null ? ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).V(a16.troopUin) : false;
            intent.putExtra("isQidianPrivateTroop", V);
            if (V) {
                intent.putExtra("groupOwner", a16.troopowneruin);
            }
            intent.putExtra("PARAM_QRForwardReceiver", new MyResultReceiver(new Handler(), this, 4, i3, j3));
            intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(new Handler(), this, 5, i3, j3));
            final QQAppInterface qQAppInterface2 = qQAppInterface;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.share.ShareChat.SharePanel.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QQAppInterface qQAppInterface3 = qQAppInterface2;
                        if (qQAppInterface3 != null) {
                            intent.putExtra(PreDetect.FACE_DETECT, qQAppInterface3.getTroopFaceBitmap(a16.troopUin, (byte) 3, false, false));
                        }
                        context.startActivity(intent);
                    } catch (Exception unused) {
                        SharePanel.this.g(123, i3, 3);
                    }
                }
            }, 8, null, true);
        }

        private void j(long j3, Context context, int i3, b bVar, String str) {
            String i16 = ShareChat.i(bVar);
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(i16)) {
                arrayList.add(i16);
            }
            String str2 = context.getString(R.string.f171017iq4) + str;
            Bundle bundle = new Bundle();
            bundle.putString("title", ShareChat.m(context));
            bundle.putString("desc", ShareChat.g(bVar));
            bundle.putLong("req_share_id", 0L);
            bundle.putString("detail_url", str);
            bundle.putString("url", str);
            bundle.putStringArrayList("image_url", arrayList);
            bundle.putString(AppConstants.Key.SHARE_REQ_TROOP_WORDING, str2);
            bundle.putString(AppConstants.Key.SHARE_REQ_BIZNAME, "JoinTroopLink");
            bundle.putParcelable("PARAM_ActivityResultReceiver", new MyResultReceiver(new Handler(), this, 1, i3, j3));
            QZoneShareManager.jumpToQzoneShare((AppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, bundle, (DialogInterface.OnDismissListener) null, 145);
            if (QLog.isColorLevel()) {
                QLog.w("ShareChat", 1, "shareToQzone, shareLink[" + str + "], seq[" + j3 + "]");
            }
        }

        private void i(long j3, Context context, int i3, b bVar, String str) {
            if (bVar == null) {
                return;
            }
            g.d(1);
            Intent intent = new Intent(context, (Class<?>) DirectForwardActivity.class);
            intent.putExtra("isFromShare", true);
            intent.putExtra("isFromTeamWork", true);
            intent.putExtra("toUin", AppConstants.DATALINE_PC_UIN);
            intent.putExtra("uinType", 6000);
            intent.putExtra("forward_type", -1);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, ((Object) context.getResources().getText(R.string.f171017iq4)) + str);
            intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
            context.startActivity(intent);
        }

        private void l(long j3, Context context, boolean z16, int i3, String str, b bVar) {
            String str2;
            String valueOf = String.valueOf(System.currentTimeMillis());
            Bitmap r16 = com.tencent.mobileqq.troopshare.e.r(bVar != null ? bVar.d(j3) : null);
            String m3 = ShareChat.m(context);
            String g16 = ShareChat.g(bVar);
            a(j3, context, valueOf, z16 ? 10 : 9, i3);
            if (z16) {
                str2 = valueOf;
                WXShareHelper.b0().K0(valueOf, m3, r16, g16, str);
            } else {
                str2 = valueOf;
                WXShareHelper.b0().J0(str2, m3, r16, com.tencent.mobileqq.troopshare.e.A(g16, context), str);
            }
            if (QLog.isColorLevel()) {
                QLog.w("ShareChat", 1, "shareToWX, mWXTransaction[" + str2 + "], bFriendCircle[" + z16 + "], shareLink[" + str + "], seq[" + j3 + "]");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements SharePanel.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f74455a;

        a(long j3) {
            this.f74455a = j3;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public TroopInfoData a() {
            return ShareChat.this.f74427i;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public int b() {
            return 99;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public void c(int i3, int i16, int i17) {
            QLog.w("ShareChat", 1, "onQRForward, choosedChannel[" + i3 + "], choosedLinkType[" + i16 + "], result[" + i17 + "], seq[" + this.f74455a + "]");
            if (i17 == 2) {
                com.tencent.av.share.a.n(i3, i16, 99, null);
            }
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public Bitmap d(long j3) {
            ShareChat shareChat = ShareChat.this;
            QQAppInterface qQAppInterface = shareChat.f74421c;
            if (qQAppInterface == null) {
                return null;
            }
            return qQAppInterface.getTroopFaceBitmap(shareChat.f74419a, (byte) 3, false, false);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public void e(int i3, int i16, int i17) {
            QLog.w("ShareChat", 1, "onFinish, choosedChannel[" + i3 + "], choosedLinkType[" + i16 + "], result[" + i17 + "], seq[" + this.f74455a + "]");
            com.tencent.av.share.a.m(i3, i16);
            if (i17 == 2) {
                com.tencent.av.share.a.n(i3, i16, 99, null);
            }
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String f(int i3) {
            return null;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public int g() {
            return ShareChat.this.f74423e;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String getDesc() {
            ShareChat shareChat = ShareChat.this;
            return ShareChat.h(shareChat.f74421c, shareChat.f74419a);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String getHeadUrl() {
            return ShareChat.j(ShareChat.this.f74419a);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public long getRoomId() {
            return ShareChat.this.f74422d;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String h(long j3, int i3) {
            ShareChat shareChat = ShareChat.this;
            if (shareChat.f74420b == null) {
                return null;
            }
            String k3 = shareChat.k(i3);
            if (TextUtils.isEmpty(k3)) {
                ShareChat shareChat2 = ShareChat.this;
                shareChat2.s(j3, shareChat2.f74422d, shareChat2.f74423e);
            }
            return k3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends MessageHandler.b<ReqGroupVideo$ReqCreateShareUrl, ReqGroupVideo$RspCreateShareUrl> {
        b() {
        }

        @Override // com.tencent.av.business.handler.MessageHandler.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(long j3, boolean z16, ReqGroupVideo$ReqCreateShareUrl reqGroupVideo$ReqCreateShareUrl, ReqGroupVideo$RspCreateShareUrl reqGroupVideo$RspCreateShareUrl, Object obj) {
            ShareChat.this.f74428j = false;
            String stringUtf8 = reqGroupVideo$RspCreateShareUrl.share_url_with_no_sig.get().toStringUtf8();
            String stringUtf82 = reqGroupVideo$RspCreateShareUrl.share_url.get().toStringUtf8();
            common$ErrorInfo common_errorinfo = reqGroupVideo$RspCreateShareUrl.result.get();
            int F2 = MessageHandler.F2(common_errorinfo);
            QLog.w("ShareChat", 1, "requestGetUrlFromServer.callback, result[" + F2 + "], bytes_errmsg[" + common_errorinfo.bytes_errmsg.get().toStringUtf8() + "], shareUrlWithNoSig[" + stringUtf8 + "], shareUrl[" + stringUtf82 + "], seq[" + j3 + "]");
            if (F2 == 0) {
                ShareChat shareChat = ShareChat.this;
                shareChat.f74425g = stringUtf82;
                shareChat.f74424f = stringUtf8;
                cp.a h16 = cp.h();
                ShareChat shareChat2 = ShareChat.this;
                h16.c(shareChat2.f74427i.troopUin, shareChat2.f74424f, shareChat2.f74425g);
            }
            ShareChat shareChat3 = ShareChat.this;
            shareChat3.l(shareChat3.f74421c, shareChat3.f74427i.troopUin);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends MessageHandler.b<ReqGroupVideo$ReqPushShareArk, ReqGroupVideo$RspPushShareArk> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f74466a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f74467b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f74468c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74469d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f74470e;

        e(String str, int i3, String str2, String str3, BaseQQAppInterface baseQQAppInterface) {
            this.f74466a = str;
            this.f74467b = i3;
            this.f74468c = str2;
            this.f74469d = str3;
            this.f74470e = baseQQAppInterface;
        }

        @Override // com.tencent.av.business.handler.MessageHandler.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(long j3, boolean z16, ReqGroupVideo$ReqPushShareArk reqGroupVideo$ReqPushShareArk, ReqGroupVideo$RspPushShareArk reqGroupVideo$RspPushShareArk, Object obj) {
            int F2 = MessageHandler.F2(reqGroupVideo$RspPushShareArk.result.get());
            QLog.d("ShareChat", 1, "shareGAVArkMsg errCode[" + F2 + "]");
            if (F2 == 0) {
                ShareChat.u(this.f74466a, this.f74467b, this.f74468c, this.f74469d, (QQAppInterface) this.f74470e, BaseApplication.getContext());
            }
        }
    }

    private static boolean b(BaseQQAppInterface baseQQAppInterface, int i3, long j3, long j16, JSONObject jSONObject, String str, ReqGroupVideo$ReqPushShareArk reqGroupVideo$ReqPushShareArk) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("ShareChat", 2, "shareGAVArkMsg chatting");
        }
        String string = !jSONObject.isNull(IShareChatApi.GAV_ARK_GROUP_NAME_KEY) ? jSONObject.getString(IShareChatApi.GAV_ARK_GROUP_NAME_KEY) : "";
        String string2 = jSONObject.isNull(IShareChatApi.GAV_ARK_GROUP_CARD_KEY) ? "" : jSONObject.getString(IShareChatApi.GAV_ARK_GROUP_CARD_KEY);
        boolean z16 = jSONObject.getBoolean(IShareChatApi.GAV_ARK_GROUP_OWNER_KEY);
        boolean z17 = jSONObject.getBoolean(IShareChatApi.GAV_ARK_GROUP_ADMIN_KEY);
        if (TextUtils.isEmpty(string2)) {
            string2 = ac.g((QQAppInterface) baseQQAppInterface, baseQQAppInterface.getCurrentAccountUin(), true);
        }
        if (TextUtils.isEmpty(string2)) {
            string2 = baseQQAppInterface.getCurrentAccountUin();
        }
        int i16 = z16 ? 1 : z17 ? 2 : 3;
        long j17 = jSONObject.getLong(IShareChatApi.GAV_ARK_ROOM_ID_KEY);
        int i17 = jSONObject.getInt(IShareChatApi.GAV_ARK_ROOM_CREATE_TIME_KEY);
        if (j3 != 0 && j16 != -1 && !string.isEmpty() && !string2.isEmpty() && !str.isEmpty()) {
            reqGroupVideo$ReqPushShareArk.uin.set(baseQQAppInterface.getLongAccountUin());
            reqGroupVideo$ReqPushShareArk.room_id.set(j17);
            reqGroupVideo$ReqPushShareArk.room_create_time.set(i17);
            reqGroupVideo$ReqPushShareArk.send_type.set(j16);
            reqGroupVideo$ReqPushShareArk.recv_uin.set(j3);
            reqGroupVideo$ReqPushShareArk.group_name.set(ByteStringMicro.copyFromUtf8(string));
            reqGroupVideo$ReqPushShareArk.share_name.set(ByteStringMicro.copyFromUtf8(string2));
            reqGroupVideo$ReqPushShareArk.role.set(i16);
            reqGroupVideo$ReqPushShareArk.group_code.set(StringUtil.stringToLong("ShareChat", str));
            QLog.d("ShareChat", 1, String.format(Locale.ENGLISH, "shareGAVArkMsg chatting success : uin[%d], roomId[%d], room_create_time[%d], send_type[%d], recv_uin[%d], group_name[%s], share_name[%s], role[%d], groupUin[%s]", Long.valueOf(baseQQAppInterface.getLongAccountUin()), Long.valueOf(j17), Integer.valueOf(i17), Long.valueOf(j16), Long.valueOf(j3), string, string2, Integer.valueOf(i16), str));
            return true;
        }
        QLog.e("ShareChat", 1, "shareGAVArkMsg chatting failed : sendUin[" + com.tencent.mobileqq.qcall.g.a(j3) + "], sessionType[" + i3 + "] troopName[" + string + "] shareName[" + string2 + "]");
        return false;
    }

    private static boolean c(BaseQQAppInterface baseQQAppInterface, int i3, long j3, long j16, JSONObject jSONObject, String str, ReqGroupVideo$ReqPushShareArk reqGroupVideo$ReqPushShareArk) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("ShareChat", 2, "shareGAVArkMsg invite");
        }
        String string = !jSONObject.isNull(WadlProxyConsts.KEY_JUMP_URL) ? jSONObject.getString(WadlProxyConsts.KEY_JUMP_URL) : "";
        String string2 = jSONObject.isNull("desc") ? "" : jSONObject.getString("desc");
        if (j3 != 0 && j16 != -1 && !string.isEmpty() && !string2.isEmpty() && !str.isEmpty()) {
            reqGroupVideo$ReqPushShareArk.send_type.set(j16);
            reqGroupVideo$ReqPushShareArk.recv_uin.set(j3);
            reqGroupVideo$ReqPushShareArk.ark_jump_url.set(ByteStringMicro.copyFromUtf8(string));
            reqGroupVideo$ReqPushShareArk.ark_desc.set(ByteStringMicro.copyFromUtf8(string2));
            reqGroupVideo$ReqPushShareArk.req_source.set(2);
            reqGroupVideo$ReqPushShareArk.group_code.set(StringUtil.stringToLong("ShareChat", str));
            QLog.d("ShareChat", 1, String.format(Locale.ENGLISH, "shareGAVArkMsg invite success : uin[%s],  send_type[%d], recv_uin[%d], jump_url[%s], decs[%s], groupUin[%s]", com.tencent.mobileqq.qcall.g.a(baseQQAppInterface.getLongAccountUin()), Long.valueOf(j16), Long.valueOf(j3), string, string2, str));
            return true;
        }
        QLog.e("ShareChat", 1, "shareGAVArkMsg invite failed : sendUin[" + com.tencent.mobileqq.qcall.g.a(j3) + "], sessionType[" + i3 + "] jumpUrl[" + string + "] decs[" + string2 + "]");
        return false;
    }

    static boolean d(ax axVar) {
        if (axVar.k()) {
            return true;
        }
        String str = axVar.f307441f.get("from_url_InternalCheck");
        QLog.w("ShareChat", 1, "handle_forward, KEY_CurrentUrl[" + str + "]");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace('\\', '/');
        return replace.startsWith("https://web.qun.qq.com/") || replace.startsWith("http://web.qun.qq.com/");
    }

    static void f(QQAppInterface qQAppInterface, Context context, String str, String str2, int i3) {
        long d16 = com.tencent.av.utils.e.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("forward, url[");
        sb5.append(str2);
        sb5.append("], fromchannel[");
        sb5.append(i3);
        sb5.append("], seq[");
        sb5.append(d16);
        sb5.append("], app[");
        sb5.append(qQAppInterface != null);
        sb5.append("], context[");
        sb5.append(context);
        sb5.append("]");
        QLog.w("ShareChat", 1, sb5.toString());
        if (qQAppInterface == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        SharePanel sharePanel = new SharePanel(d16, 0);
        WeakReference weakReference = new WeakReference(context);
        ((Activity) context).getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
        sharePanel.m(context, str, i3, new d(str2, qQAppInterface, str, i3, d16, weakReference));
    }

    static String j(String str) {
        return ((ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", str, 0) + "100";
    }

    static void n(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, View view, String str) {
        k.n(qBaseActivity, str);
    }

    public static boolean o(ax axVar) {
        int stringToLong;
        if (!"avshare/forward".equals(axVar.f307440e) || !d(axVar)) {
            return false;
        }
        String str = axVar.f307441f.get("url");
        String str2 = axVar.f307441f.get("exp");
        String str3 = axVar.f307441f.get("guin");
        String str4 = axVar.f307441f.get("fromchannel");
        if (TextUtils.isEmpty(str) || (stringToLong = (int) StringUtil.stringToLong("ShareChat", str4)) == 0) {
            return false;
        }
        com.tencent.av.share.a.g(stringToLong, str3);
        com.tencent.av.utils.e.p("handle_forward");
        long stringToLong2 = StringUtil.stringToLong("ShareChat", str2);
        long i3 = com.tencent.av.utils.e.i();
        if (stringToLong2 < i3) {
            QQToast makeText = QQToast.makeText(axVar.f307437b, R.string.iq7, 1);
            makeText.setAutoTextSize();
            makeText.show();
            QLog.w("ShareChat", 1, "handle_forward, expTime[" + stringToLong2 + "], curTime[" + i3 + "]");
            return true;
        }
        if (((TroopManager) axVar.e().getManager(QQManagerFactory.TROOP_MANAGER)).k(str3) == null) {
            if (QLog.isColorLevel()) {
                QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str3 + "]");
            }
            QQToast makeText2 = QQToast.makeText(axVar.f307437b, R.string.iq7, 1);
            makeText2.setAutoTextSize();
            makeText2.show();
            return true;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) axVar.e();
        aj ajVar = (aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean d16 = ajVar.d(str3);
        boolean f16 = ajVar.f(str3);
        if (!d16 && !f16) {
            if (com.tencent.av.utils.e.k()) {
                QLog.w("ShareChat", 1, "handle_forward, troopUin[" + str3 + "], isAdmin[" + d16 + "], isOwner[" + f16 + "]");
            }
            QQToast makeText3 = QQToast.makeText(axVar.f307437b, R.string.iq8, 1);
            makeText3.setAutoTextSize();
            makeText3.show();
            return true;
        }
        axVar.f307458w = false;
        Context context = axVar.f307437b;
        if (context instanceof JumpActivity) {
            ((JumpActivity) context).initFinishBroadcastReceiver();
        }
        f(qQAppInterface, axVar.f307437b, str3, str, stringToLong);
        return true;
    }

    public static boolean p(ax axVar) {
        if (!"avshare/group".equals(axVar.f307440e)) {
            return false;
        }
        String str = axVar.f307441f.get("guid");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.tencent.av.utils.e.p("handle_startGAudio");
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.addFlags(268435456);
        intent.putExtra("guid", str);
        PublicFragmentActivity.b.a(axVar.f307437b, intent, PublicTransFragmentActivity.class, AVSchema.class);
        com.tencent.av.share.a.k();
        return true;
    }

    public static boolean r(ax axVar) {
        if ("avshare/group".equals(axVar.f307440e)) {
            return p(axVar);
        }
        if ("avshare/forward".equals(axVar.f307440e)) {
            return o(axVar);
        }
        return false;
    }

    public static void u(String str, int i3, String str2, String str3, QQAppInterface qQAppInterface, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str2;
        sessionInfo.f179559f = str3;
        ChatActivityFacade.K0(qQAppInterface, context, sessionInfo, str);
    }

    public static void v(BaseQQAppInterface baseQQAppInterface, QBaseActivity qBaseActivity, View view, Intent intent) {
        if (baseQQAppInterface instanceof QQAppInterface) {
            int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0);
            String stringExtra = intent.getStringExtra("group_uin");
            if (intExtra == 35) {
                com.tencent.av.share.a.a();
                n((QQAppInterface) baseQQAppInterface, qBaseActivity, view, stringExtra);
            } else {
                long longExtra = intent.getLongExtra(AudienceReportConst.ROOM_ID, 0L);
                int intExtra2 = intent.getIntExtra("room_create_time", 0);
                com.tencent.av.share.a.b();
                new ShareChat().x((QQAppInterface) baseQQAppInterface, qBaseActivity, stringExtra, longExtra, intExtra2);
            }
        }
    }

    void l(QQAppInterface qQAppInterface, String str) {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(str, "ShareChat", null, new c(str));
    }

    boolean q() {
        TroopInfo B = ((TroopManager) this.f74421c.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f74419a);
        if (B == null) {
            QLog.w("ShareChat", 1, "initData fail, mGroupUin[" + this.f74419a + "]");
            return false;
        }
        this.f74427i.updateForTroopInfo(B, this.f74421c.getCurrentAccountUin());
        return true;
    }

    void s(long j3, long j16, int i3) {
        QLog.w("ShareChat", 1, "reRequest, mIsRequesting[" + this.f74428j + "], seq[" + j3 + "]");
        if (this.f74428j) {
            return;
        }
        q();
        t(j3, j16, i3);
    }

    void x(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, String str, long j3, int i3) {
        this.f74419a = str;
        this.f74420b = qBaseActivity;
        this.f74421c = qQAppInterface;
        this.f74422d = j3;
        this.f74423e = i3;
        if (q()) {
            l(qQAppInterface, str);
            cp.d a16 = cp.h().a(str);
            long d16 = com.tencent.av.utils.e.d();
            if (a16 == null) {
                t(d16, j3, i3);
            } else {
                this.f74424f = a16.f307555b;
                this.f74425g = a16.f307556c;
                QLog.w("ShareChat", 1, "ShareChat, \u4ece\u7f13\u5b58\u4e2d\u627e\u5230url, groupUin[" + str + "], mShareUrlWithNoSig[" + this.f74424f + "], mShareUrl[" + this.f74425g + "], seq[" + d16 + "], mSharePanel[" + this.f74426h + "]");
            }
            QBaseActivity qBaseActivity2 = this.f74420b;
            int i16 = 0;
            boolean V = (qBaseActivity2 == null || !(qBaseActivity2.getAppRuntime() instanceof QQAppInterface)) ? false : ((TroopManager) ((QQAppInterface) this.f74420b.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).V(this.f74427i.troopUin);
            if (this.f74427i.isOwnerOrAdim() && !V) {
                if (!((TroopInfo.hasPayPrivilege((long) this.f74427i.mTroopPrivilegeFlag, 128) && TroopInfo.hasPayPrivilege((long) this.f74427i.mTroopPrivilegeFlag, 512)) | (this.f74427i.cGroupOption == 1))) {
                    i16 = -1;
                }
            }
            this.f74426h = new SharePanel(d16, i16);
            QBaseActivity qBaseActivity3 = this.f74420b;
            if (qBaseActivity3 != null) {
                qBaseActivity3.getIntent().putExtra("big_brother_source_key", "biz_src_jc_yinshipin");
                this.f74426h.m(this.f74420b, this.f74419a, 99, new a(d16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements SharePanel.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f74460a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f74461b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f74462c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f74463d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f74464e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f74465f;

        d(String str, QQAppInterface qQAppInterface, String str2, int i3, long j3, WeakReference weakReference) {
            this.f74460a = str;
            this.f74461b = qQAppInterface;
            this.f74462c = str2;
            this.f74463d = i3;
            this.f74464e = j3;
            this.f74465f = weakReference;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public TroopInfoData a() {
            TroopInfoData troopInfoData = new TroopInfoData();
            troopInfoData.troopUin = this.f74462c;
            troopInfoData.updateForTroopInfo(((TroopManager) this.f74461b.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f74462c), this.f74461b.getCurrentAccountUin());
            return troopInfoData;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public int b() {
            return this.f74463d;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public Bitmap d(long j3) {
            return this.f74461b.getTroopFaceBitmap(this.f74462c, (byte) 3, false, false);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String f(int i3) {
            return "0X800A3E4";
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public int g() {
            return 0;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String getDesc() {
            return ShareChat.h(this.f74461b, this.f74462c);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String getHeadUrl() {
            return ShareChat.j(this.f74462c);
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public long getRoomId() {
            return 0L;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public String h(long j3, int i3) {
            return this.f74460a;
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public void c(int i3, int i16, int i17) {
            if (i17 == 2) {
                com.tencent.av.share.a.n(i3, i16, this.f74463d, this.f74462c);
            }
        }

        @Override // com.tencent.av.share.ShareChat.SharePanel.b
        public void e(int i3, int i16, int i17) {
            if (i17 == 2) {
                com.tencent.av.share.a.n(i3, i16, this.f74463d, this.f74462c);
            }
            ShareChat.e(this.f74464e, (Context) this.f74465f.get());
        }
    }

    static String g(SharePanel.b bVar) {
        if (bVar != null) {
            return bVar.getDesc();
        }
        return null;
    }

    static String i(SharePanel.b bVar) {
        if (bVar != null) {
            return bVar.getHeadUrl();
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:6|(8:(2:9|(2:13|(1:15)(1:41)))(1:42)|16|17|(1:19)(1:38)|20|(2:29|(2:36|37)(2:33|(1:35)))(2:24|(1:26))|27|28)|43|16|17|(0)(0)|20|(1:22)|29|(1:31)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c2, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ShareChat", 1, "json error[" + r0.getMessage() + "]");
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[Catch: JSONException -> 0x00c1, TryCatch #0 {JSONException -> 0x00c1, blocks: (B:17:0x003a, B:19:0x004e, B:20:0x0056, B:22:0x0062, B:24:0x006f, B:27:0x009c, B:29:0x007c, B:31:0x0082, B:33:0x008f, B:36:0x00b9), top: B:16:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean w(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3, String str3) {
        long j3;
        JSONObject jSONObject;
        String str4;
        if (!(baseQQAppInterface instanceof QQAppInterface)) {
            QLog.d("ShareChat", 1, "shareGAVArkMsg errCode[!(app instanceof QQAppInterface)]");
            return true;
        }
        long stringToLong = StringUtil.stringToLong("ShareChat", str2);
        if (i3 != 0) {
            if (i3 == 1) {
                j3 = 1;
            } else if (i3 != 1000 && i3 != 1004) {
                j3 = i3 != 3000 ? -1L : 2L;
            }
            jSONObject = new JSONObject(str).getJSONObject("news");
            if (jSONObject.isNull(IShareChatApi.GAV_ARK_GROUP_UIN_KEY)) {
                str4 = jSONObject.getString(IShareChatApi.GAV_ARK_GROUP_UIN_KEY);
            } else {
                str4 = "";
            }
            String str5 = str4;
            ReqGroupVideo$ReqPushShareArk reqGroupVideo$ReqPushShareArk = new ReqGroupVideo$ReqPushShareArk();
            if (jSONObject.isNull(IShareChatApi.GAV_ARK_FROM_TYPE) && IShareChatApi.GAV_ARK_FROM_CHATTING.equalsIgnoreCase(jSONObject.getString(IShareChatApi.GAV_ARK_FROM_TYPE))) {
                if (!b(baseQQAppInterface, i3, stringToLong, j3, jSONObject, str5, reqGroupVideo$ReqPushShareArk)) {
                    return true;
                }
            } else if (jSONObject.isNull(IShareChatApi.GAV_ARK_FROM_TYPE) && IShareChatApi.GAV_ARK_FROM_INVITE.equalsIgnoreCase(jSONObject.getString(IShareChatApi.GAV_ARK_FROM_TYPE))) {
                if (!c(baseQQAppInterface, i3, stringToLong, j3, jSONObject, str5, reqGroupVideo$ReqPushShareArk)) {
                    return true;
                }
            } else {
                QLog.d("ShareChat", 1, "shareGAVArkMsg errCode[GAV_ARK_FROM_TYPE == null]");
                return false;
            }
            MessageHandler.I2(com.tencent.av.utils.e.d(), baseQQAppInterface, "QQRTCSvc.push_share_ark", reqGroupVideo$ReqPushShareArk, new e(str3, i3, str2, str5, baseQQAppInterface));
            return true;
        }
        j3 = 0;
        jSONObject = new JSONObject(str).getJSONObject("news");
        if (jSONObject.isNull(IShareChatApi.GAV_ARK_GROUP_UIN_KEY)) {
        }
        String str52 = str4;
        ReqGroupVideo$ReqPushShareArk reqGroupVideo$ReqPushShareArk2 = new ReqGroupVideo$ReqPushShareArk();
        if (jSONObject.isNull(IShareChatApi.GAV_ARK_FROM_TYPE)) {
        }
        if (jSONObject.isNull(IShareChatApi.GAV_ARK_FROM_TYPE)) {
        }
        QLog.d("ShareChat", 1, "shareGAVArkMsg errCode[GAV_ARK_FROM_TYPE == null]");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements Function2<Boolean, TroopInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74458d;

        c(String str) {
            this.f74458d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, TroopInfo troopInfo) {
            if (troopInfo == null) {
                return null;
            }
            String str = troopInfo.troopuin;
            if (TextUtils.isEmpty(this.f74458d) || !TextUtils.equals(this.f74458d, str)) {
                return null;
            }
            QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + bool + "]");
            ShareChat.this.q();
            return null;
        }
    }

    static void e(long j3, Context context) {
        if (context == null) {
            return;
        }
        QLog.w("ShareChat", 1, "finishJumpActivity, seq[" + j3 + "]");
        JumpActivity.sendFinishBroadcast(context);
    }

    static String m(Context context) {
        return context.getString(R.string.f171016iq3);
    }

    static String h(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return null;
        }
        String currentNickname = qQAppInterface.getCurrentNickname();
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, qQAppInterface.getCurrentUin(), null, "ShareChat");
        if (troopMemberInfoSync != null) {
            currentNickname = troopMemberInfoSync.nickInfo.getShowName();
        }
        return currentNickname + String.format(qQAppInterface.getApp().getString(R.string.iq6), ac.g0(qQAppInterface, str, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(int i3) {
        if (i3 == 0) {
            return this.f74424f;
        }
        if (i3 != 1) {
            return null;
        }
        return this.f74425g;
    }

    void t(long j3, long j16, int i3) {
        int i16;
        this.f74428j = true;
        long stringToLong = StringUtil.stringToLong("ShareChat", this.f74427i.troopUin);
        String str = this.f74427i.troopCard;
        if (TextUtils.isEmpty(str)) {
            QQAppInterface qQAppInterface = this.f74421c;
            str = ac.g(qQAppInterface, qQAppInterface.getCurrentAccountUin(), true);
        }
        if (TextUtils.isEmpty(str)) {
            str = this.f74421c.getCurrentAccountUin();
        }
        TroopInfoData troopInfoData = this.f74427i;
        if (troopInfoData.bOwner) {
            i16 = 1;
        } else {
            i16 = troopInfoData.bAdmin ? 2 : 3;
        }
        b bVar = new b();
        QLog.w("ShareChat", 1, "requestGetUrlFromServer, shareName[" + str + "], role[" + i16 + "], troopUin[" + stringToLong + "], roomID[" + j16 + "], roomCreateTime[" + i3 + "], seq[" + j3 + "]");
        ReqGroupVideo$ReqCreateShareUrl reqGroupVideo$ReqCreateShareUrl = new ReqGroupVideo$ReqCreateShareUrl();
        reqGroupVideo$ReqCreateShareUrl.uint64_uin.set(this.f74421c.getLongAccountUin());
        reqGroupVideo$ReqCreateShareUrl.uint64_group_code.set(stringToLong);
        reqGroupVideo$ReqCreateShareUrl.uint64_room_id.set(j16);
        reqGroupVideo$ReqCreateShareUrl.uint32_room_create_time.set(i3);
        reqGroupVideo$ReqCreateShareUrl.group_name.set(ByteStringMicro.copyFromUtf8(this.f74427i.troopName));
        reqGroupVideo$ReqCreateShareUrl.share_name.set(ByteStringMicro.copyFromUtf8(str));
        reqGroupVideo$ReqCreateShareUrl.role.set(i16);
        MessageHandler.I2(j3, this.f74421c, "QQRTCSvc.group_video_create_share_url", reqGroupVideo$ReqCreateShareUrl, bVar);
    }
}
