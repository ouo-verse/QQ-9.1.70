package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.gamecenter.share.GameShareNetHelper;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GameShareUtilImpl implements IGameShareUtil {
    static IPatchRedirector $redirector_ = null;
    private static final long MIN_CLICK_INTERVAL = 1000;
    private static final String TAG = "QQGamePub_Util";
    private static long sLastClickTime;
    private static View.OnClickListener sUrlListener;
    int DP_SOURCE_RIGHT_MARGIN_DEFAULT;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[Catch: all -> 0x0166, TryCatch #0 {all -> 0x0166, blocks: (B:25:0x006f, B:27:0x0078, B:30:0x0082, B:32:0x008b, B:33:0x00b7, B:35:0x00c0, B:37:0x00d3, B:39:0x00d7, B:41:0x00db, B:44:0x00f3, B:52:0x0124, B:54:0x012a, B:58:0x009d), top: B:24:0x006f }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #0 {all -> 0x0166, blocks: (B:25:0x006f, B:27:0x0078, B:30:0x0082, B:32:0x008b, B:33:0x00b7, B:35:0x00c0, B:37:0x00d3, B:39:0x00d7, B:41:0x00db, B:44:0x00f3, B:52:0x0124, B:54:0x012a, B:58:0x009d), top: B:24:0x006f }] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            Object tag;
            String str;
            String str2;
            String str3;
            String str4;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                if (Math.abs(serverTimeMillis - GameShareUtilImpl.sLastClickTime) >= 1000) {
                    GameShareUtilImpl.sLastClickTime = serverTimeMillis;
                    if (view != null && view.getContext() != null) {
                        Context context = view.getContext();
                        if (context instanceof Activity) {
                            Activity activity = (Activity) context;
                            if (!activity.isFinishing()) {
                                Object tag2 = view.getTag(-1);
                                if (tag2 instanceof String) {
                                    String str5 = (String) tag2;
                                    if (!TextUtils.isEmpty(str5)) {
                                        String lowerCase = str5.substring(0, 6).toLowerCase();
                                        try {
                                            if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
                                                if (lowerCase.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                                                    Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                                                    intent.setData(Uri.parse(str5));
                                                    activity.startActivityForResult(intent, -1);
                                                }
                                                tag = view.getTag(-4);
                                                if (tag instanceof String) {
                                                    Object tag3 = view.getTag(-2);
                                                    Object tag4 = view.getTag(-3);
                                                    Object tag5 = view.getTag(-5);
                                                    if ((tag3 instanceof Integer) && (tag4 instanceof Integer) && (tag5 instanceof Integer)) {
                                                        int intValue = ((Integer) tag3).intValue();
                                                        int intValue2 = ((Integer) tag4).intValue();
                                                        int intValue3 = ((Integer) tag5).intValue();
                                                        if (intValue != 0 && intValue2 != 0) {
                                                            GameShareNetHelper.b().c((String) tag, ((Integer) tag3).intValue(), ((Integer) tag4).intValue());
                                                        }
                                                        if (intValue3 != 1 && intValue3 != 0) {
                                                            if (intValue3 == 2) {
                                                                str = "87007";
                                                                str2 = "206676";
                                                                str3 = str;
                                                                str4 = str2;
                                                                if (!TextUtils.isEmpty(str4)) {
                                                                    HashMap hashMap = new HashMap();
                                                                    hashMap.put(2, intValue2 + "");
                                                                    hashMap.put(4, "20");
                                                                    hl0.a.c(null, "870", str4, (String) tag, str3, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
                                                                }
                                                            } else {
                                                                str4 = null;
                                                                str3 = null;
                                                                if (!TextUtils.isEmpty(str4)) {
                                                                }
                                                            }
                                                        }
                                                        str = "87006";
                                                        str2 = "206675";
                                                        str3 = str;
                                                        str4 = str2;
                                                        if (!TextUtils.isEmpty(str4)) {
                                                        }
                                                    }
                                                }
                                            }
                                            Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                                            intent2.putExtra("url", str5);
                                            intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                                            activity.startActivityForResult(intent2, -1);
                                            tag = view.getTag(-4);
                                            if (tag instanceof String) {
                                            }
                                        } catch (Throwable th5) {
                                            if (QLog.isDevelopLevel()) {
                                                th5.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            sLastClickTime = 0L;
            sUrlListener = new a();
        }
    }

    public GameShareUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.DP_SOURCE_RIGHT_MARGIN_DEFAULT = 10;
        }
    }

    private boolean isFromGameShare(AbsStructMsg absStructMsg) {
        if (absStructMsg instanceof StructMsgForImageShare) {
            return isGameShare(absStructMsg);
        }
        return false;
    }

    private static boolean isPicInAIOSizeOk(StructMsgForImageShare structMsgForImageShare) {
        if (structMsgForImageShare.width >= structMsgForImageShare.height) {
            return true;
        }
        return false;
    }

    public static void reportSourceShowInGallery(String str, int i3, Object obj) {
        Map<Object, Integer> map = IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE;
        Integer num = map.get(obj);
        if (num == null || num.intValue() != i3) {
            HashMap hashMap = new HashMap();
            hashMap.put(2, i3 + "");
            hashMap.put(4, "8");
            hl0.a.c(null, "870", "206673", str, "87007", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
            map.put(obj, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void convertDataForGallery(Object obj, Object obj2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, obj, obj2);
            return;
        }
        try {
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) obj2;
            if (obj != null && structMsgForImageShare != null) {
                String valueFromMsg = getValueFromMsg(IGameShareUtil.KEY_SOURCE_PIC_TXT, "", structMsgForImageShare.message);
                String valueFromMsg2 = getValueFromMsg(IGameShareUtil.KEY_SOURCE_PIC_URL, "", structMsgForImageShare.message);
                if (!TextUtils.isEmpty(valueFromMsg) && !TextUtils.isEmpty(valueFromMsg2)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    valueFromMsg = IGameShareUtil.DEFAULT_VALUE_SOURCE_AIO_RIGHT_TXT;
                    valueFromMsg2 = IGameShareUtil.DEF_PIC_LEFT_URL + structMsgForImageShare.mSourceAppid;
                }
                setPicDataToImageData(obj, structMsgForImageShare, valueFromMsg, valueFromMsg2, getIntFromMsg(IGameShareUtil.KEY_SOURCE_PIC_TYPE, 0, structMsgForImageShare.message), getIntFromMsg(IGameShareUtil.KEY_SOURCE_PIC_SUBTYPE, 0, structMsgForImageShare.message), z16);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public IGameShareUtil.a getGalleryData(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IGameShareUtil.a) iPatchRedirector.redirect((short) 14, (Object) this, obj);
        }
        try {
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) obj;
            if (structMsgForImageShare != null && !TextUtils.isEmpty(structMsgForImageShare.mMsgActionData)) {
                JSONObject jSONObject = new JSONObject(structMsgForImageShare.mMsgActionData);
                IGameShareUtil.a aVar = new IGameShareUtil.a();
                aVar.f264389a = jSONObject.optString(IGameShareUtil.KEY_SOURCE_PIC_TXT);
                aVar.f264390b = jSONObject.optString(IGameShareUtil.KEY_SOURCE_PIC_URL);
                aVar.f264391c = jSONObject.optInt(IGameShareUtil.KEY_SOURCE_PIC_TYPE, 0);
                aVar.f264392d = jSONObject.optInt(IGameShareUtil.KEY_SOURCE_PIC_SUBTYPE, 0);
                aVar.f264393e = jSONObject.optBoolean(IGameShareUtil.KEY_SOURCE_PIC_HAS_DATA);
                return aVar;
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public int getIntFromMsg(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), messageRecord)).intValue();
        }
        String valueFromMsg = getValueFromMsg(str, "", messageRecord);
        if (TextUtils.isEmpty(valueFromMsg)) {
            return i3;
        }
        try {
            return Integer.parseInt(valueFromMsg);
        } catch (Throwable unused) {
            return i3;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public TextView getSourceInGallery(Context context, RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TextView) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) relativeLayout);
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        relativeLayout.addView(linearLayout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.addRule(12, -1);
        layoutParams.addRule(0, R.id.gqp);
        layoutParams.rightMargin = BaseAIOUtils.f(20.0f, resources);
        TextView textView = new TextView(context);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int f16 = BaseAIOUtils.f(16.0f, resources);
        layoutParams2.bottomMargin = f16;
        layoutParams2.leftMargin = f16;
        layoutParams2.height = BaseAIOUtils.f(28.0f, resources);
        textView.setBackgroundResource(R.drawable.knm);
        textView.setTextColor(-1);
        textView.setTextSize(1, 12.0f);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public String getValueFromMsg(String str, String str2, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, str, str2, messageRecord);
        }
        if (messageRecord != null) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(str);
            if (TextUtils.isEmpty(extInfoFromExtStr)) {
                return str2;
            }
            return extInfoFromExtStr;
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void handleBubbleViewForGameShare(int i3, Object obj, MessageRecord messageRecord) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), obj, messageRecord);
            return;
        }
        if ((obj instanceof SessionInfo) && messageRecord != null) {
            SessionInfo sessionInfo = (SessionInfo) obj;
            int i19 = sessionInfo.f179555d;
            if (i19 != 0 && i19 != 1) {
                return;
            }
            String str = null;
            String str2 = "";
            if (messageRecord instanceof MessageForStructing) {
                AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
                if (absStructMsg instanceof AbsShareMsg) {
                    AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                    str = String.valueOf(absShareMsg.mSourceAppid);
                    if (absShareMsg.mMsgServiceID != 5) {
                        str2 = absShareMsg.mContentTitle;
                        i18 = 0;
                    }
                } else {
                    i18 = -1;
                }
                i16 = i18;
            } else if (messageRecord instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                str = messageForArkApp.ark_app_message.getAppIdFromMeta();
                if ("com.tencent.structmsg".equals(messageForArkApp.ark_app_message.appName)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(messageForArkApp.ark_app_message.metaList).optJSONObject("news");
                        if (optJSONObject != null) {
                            str2 = optJSONObject.optString("title");
                        }
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "handleBubbleViewForGameShare", th5);
                        }
                    }
                    i16 = 0;
                } else {
                    str2 = messageForArkApp.ark_app_message.appName;
                    i16 = 1;
                }
            } else {
                i16 = -1;
            }
            String str3 = str2;
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("key_open_game_tag_name");
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("key_open_game_message_ext");
            if (isWhiteByAppid(str) && !TextUtils.isEmpty(extInfoFromExtStr)) {
                if (i3 == 0) {
                    if (!TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("game_source_report_status"))) {
                        return;
                    } else {
                        messageRecord.saveExtInfoToExtStr("game_source_report_status", "1");
                    }
                }
                if (sessionInfo.f179555d == 0) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).reportGameShare(i3, i16, i17, str, extInfoFromExtStr, extInfoFromExtStr2, str3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "handleBubbleViewForGameShare appid=" + str + ",tagName=" + extInfoFromExtStr + ",sessionInfo=" + obj);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public boolean isGameShare(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof AbsShareMsg) {
            return isWhiteByAppid(String.valueOf(((AbsShareMsg) obj).mSourceAppid));
        }
        QLog.w(TAG, 1, "isGameShare msg instance of " + obj);
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public boolean isWhiteByAppid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void releaseCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void saveGalleryDataToMsg(AppRuntime appRuntime, Bundle bundle) {
        String str;
        String string;
        String string2;
        int i3;
        int i16;
        long j3;
        int i17;
        String string3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "saveGalleryDataToMsg params=" + bundle);
        }
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 1, "saveGalleryDataToMsg params is null");
                return;
            }
            return;
        }
        try {
            string = bundle.getString(IGameShareUtil.KEY_SOURCE_PIC_TXT);
            string2 = bundle.getString(IGameShareUtil.KEY_SOURCE_PIC_URL);
            i3 = bundle.getInt(IGameShareUtil.KEY_SOURCE_PIC_TYPE, 0);
            i16 = bundle.getInt(IGameShareUtil.KEY_SOURCE_PIC_SUBTYPE, 0);
            j3 = bundle.getLong("uniseq");
            i17 = bundle.getInt("is_troop");
            string3 = bundle.getString("friend_uin");
            str = TAG;
        } catch (Throwable th5) {
            th = th5;
            str = TAG;
        }
        try {
            MessageRecord queryMsgItemByUniseq = ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(string3, i17, j3);
            if (queryMsgItemByUniseq != null) {
                saveValueToMsg(IGameShareUtil.KEY_SOURCE_PIC_TXT, string, queryMsgItemByUniseq);
                saveValueToMsg(IGameShareUtil.KEY_SOURCE_PIC_URL, string2, queryMsgItemByUniseq);
                saveValueToMsg(IGameShareUtil.KEY_SOURCE_PIC_TYPE, String.valueOf(i3), queryMsgItemByUniseq);
                saveValueToMsg(IGameShareUtil.KEY_SOURCE_PIC_SUBTYPE, String.valueOf(i16), queryMsgItemByUniseq);
                ThreadManagerV2.excute(new Runnable(appRuntime, queryMsgItemByUniseq) { // from class: com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AppRuntime f264401d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ MessageRecord f264402e;

                    {
                        this.f264401d = appRuntime;
                        this.f264402e = queryMsgItemByUniseq;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, GameShareUtilImpl.this, appRuntime, queryMsgItemByUniseq);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        IMessageFacade iMessageFacade = (IMessageFacade) this.f264401d.getRuntimeService(IMessageFacade.class, "");
                        MessageRecord messageRecord = this.f264402e;
                        iMessageFacade.updateMsgFieldByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                    }
                }, 32, null, false);
            }
        } catch (Throwable th6) {
            th = th6;
            th.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(str, 1, "saveGalleryDataToMsg exception", th);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void saveValueToMsg(String str, String str2, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, messageRecord);
        } else if (messageRecord != null && !TextUtils.isEmpty(str2)) {
            messageRecord.saveExtInfoToExtStr(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void setPicDataToImageData(Object obj, Object obj2, String str, String str2, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, obj, obj2, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        if ((obj instanceof AIOImageData) && (obj2 instanceof StructMsgForImageShare)) {
            AIOImageData aIOImageData = (AIOImageData) obj;
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) obj2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IGameShareUtil.KEY_SOURCE_PIC_TXT, str);
                jSONObject.put(IGameShareUtil.KEY_SOURCE_PIC_URL, str2);
                jSONObject.put(IGameShareUtil.KEY_SOURCE_PIC_TYPE, i3);
                jSONObject.put(IGameShareUtil.KEY_SOURCE_PIC_SUBTYPE, i16);
                jSONObject.put(IGameShareUtil.KEY_SOURCE_PIC_HAS_DATA, z16);
                structMsgForImageShare.mMsgActionData = jSONObject.toString();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
            aIOImageData.Z = structMsgForImageShare.getBytes();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void tryAdjustThumbSize(Object obj, Object obj2, Object obj3) {
        ThumbWidthHeightDP thumbWidthHeightDP;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, obj, obj2, obj3);
            return;
        }
        try {
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) obj;
            MessageForPic messageForPic = (MessageForPic) obj2;
            com.tencent.mobileqq.structmsg.view.e eVar = (com.tencent.mobileqq.structmsg.view.e) obj3;
            if (isFromGameShare(structMsgForImageShare) && isPicInAIOSizeOk(structMsgForImageShare) && eVar != null) {
                if (messageForPic == null) {
                    thumbWidthHeightDP = null;
                } else {
                    thumbWidthHeightDP = messageForPic.thumbWidthHeightDP;
                }
                if (thumbWidthHeightDP != null) {
                    thumbWidthHeightDP.mMinWidth = 251;
                    thumbWidthHeightDP.mMaxWidth = Math.max(251, thumbWidthHeightDP.mMaxWidth);
                    thumbWidthHeightDP.mMaxHeight = Math.max(thumbWidthHeightDP.mMaxHeight, thumbWidthHeightDP.mMinWidth);
                    eVar.W0 = Math.max(thumbWidthHeightDP.mMaxWidth, eVar.W0);
                    eVar.X0 = Math.max(thumbWidthHeightDP.mMaxHeight, eVar.X0);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void tryCompactMaxWidth(Object obj, ImageView imageView, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, obj, imageView, obj2);
            return;
        }
        try {
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) obj;
            com.tencent.mobileqq.structmsg.view.e eVar = (com.tencent.mobileqq.structmsg.view.e) obj2;
            if (isFromGameShare(structMsgForImageShare) && isPicInAIOSizeOk(structMsgForImageShare) && imageView != null && eVar != null) {
                int f16 = BaseAIOUtils.f(eVar.W0, imageView.getContext().getResources());
                int f17 = BaseAIOUtils.f(eVar.X0, imageView.getContext().getResources());
                if (f16 > imageView.getMaxWidth()) {
                    imageView.setMaxWidth(f16);
                }
                if (f17 > imageView.getMaxHeight()) {
                    imageView.setMaxHeight(f17);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void tryHandleAioSource(View view, RelativeLayout relativeLayout, boolean z16, Resources resources, Context context, Object obj) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, relativeLayout, Boolean.valueOf(z16), resources, context, obj);
            return;
        }
        try {
            AbsStructMsg absStructMsg = (AbsStructMsg) obj;
            if (!isFromGameShare(absStructMsg)) {
                return;
            }
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) absStructMsg;
            if (isPicInAIOSizeOk(structMsgForImageShare) && view != null && relativeLayout != null && resources != null && context != null && absStructMsg.message != null) {
                if (view instanceof TextView) {
                    textView = (TextView) view;
                    textView.setBackgroundDrawable(null);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                    layoutParams.addRule(15, -1);
                    textView.setLayoutParams(layoutParams);
                } else {
                    textView = null;
                }
                relativeLayout.setBackgroundResource(R.drawable.f161457xw);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                if (z16) {
                    layoutParams2.addRule(7, R.id.chat_item_content_layout);
                    layoutParams2.rightMargin = BaseAIOUtils.f(this.DP_SOURCE_RIGHT_MARGIN_DEFAULT, resources);
                } else {
                    layoutParams2.addRule(5, 0);
                    layoutParams2.addRule(7, R.id.chat_item_content_layout);
                    layoutParams2.addRule(1, R.id.chat_item_head_icon);
                    layoutParams2.rightMargin = BaseAIOUtils.f(this.DP_SOURCE_RIGHT_MARGIN_DEFAULT, resources);
                }
                relativeLayout.setLayoutParams(layoutParams2);
                TextView textView2 = new TextView(context);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.addRule(6, R.id.j4r);
                layoutParams3.addRule(1, R.id.j4r);
                layoutParams3.addRule(11, -1);
                layoutParams3.addRule(8, R.id.j4r);
                layoutParams3.addRule(15, -1);
                layoutParams3.rightMargin = BaseAIOUtils.f(8.0f, resources);
                relativeLayout.addView(textView2, layoutParams3);
                textView2.setGravity(21);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setSingleLine(true);
                textView2.setTextColor(-1);
                textView2.setTextSize(2, 12.0f);
                textView2.setCompoundDrawablePadding(BaseAIOUtils.f(5.0f, resources));
                Drawable drawable = resources.getDrawable(R.drawable.gak);
                drawable.setBounds(0, 0, BaseAIOUtils.f(6.0f, resources), BaseAIOUtils.f(10.0f, resources));
                textView2.setCompoundDrawables(null, null, drawable, null);
                String valueFromMsg = getValueFromMsg(IGameShareUtil.KEY_SOURCE_AIO_TXT, "", absStructMsg.message);
                if (TextUtils.isEmpty(valueFromMsg)) {
                    GameShareNetHelper.b().d(structMsgForImageShare.mSourceAppid, structMsgForImageShare.message);
                    valueFromMsg = IGameShareUtil.DEFAULT_VALUE_SOURCE_AIO_RIGHT_TXT;
                }
                String valueFromMsg2 = getValueFromMsg(IGameShareUtil.KEY_SOURCE_AIO_URL, "", absStructMsg.message);
                if (TextUtils.isEmpty(valueFromMsg2)) {
                    valueFromMsg2 = IGameShareUtil.DEF_AIO_RIGHT_URL + structMsgForImageShare.mSourceAppid;
                }
                int intFromMsg = getIntFromMsg(IGameShareUtil.KEY_SOURCE_AIO_TYPE, 0, absStructMsg.message);
                int intFromMsg2 = getIntFromMsg(IGameShareUtil.KEY_SOURCE_AIO_SUBTYPE, 0, absStructMsg.message);
                String str = structMsgForImageShare.mSourceAppid + "";
                if (textView != null) {
                    textView.setTag(-1, valueFromMsg2);
                    textView.setTag(-5, 0);
                    textView.setOnClickListener(sUrlListener);
                    ((IQWalletApi) QRoute.api(IQWalletApi.class)).setAlphaChangeListener(textView, 0.5f);
                }
                textView2.setText(valueFromMsg);
                textView2.setTag(-1, valueFromMsg2);
                textView2.setTag(-2, Integer.valueOf(intFromMsg));
                textView2.setTag(-3, Integer.valueOf(intFromMsg2));
                textView2.setTag(-4, str);
                textView2.setTag(-5, 1);
                textView2.setOnClickListener(sUrlListener);
                ((IQWalletApi) QRoute.api(IQWalletApi.class)).setAlphaChangeListener(textView2, 0.5f);
                Map<Object, Integer> map = IGameShareUtil.S_MSG_TO_REPORT_SUB_TYPE;
                Integer num = map.get(Long.valueOf(absStructMsg.message.uniseq));
                if (num == null || num.intValue() != intFromMsg2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(2, intFromMsg2 + "");
                    hashMap.put(4, "8");
                    hl0.a.c(null, "870", "206672", str, "87006", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
                    map.put(Long.valueOf(absStructMsg.message.uniseq), Integer.valueOf(intFromMsg2));
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
    public void updateSourceInGallery(TextView textView, Context context, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, textView, context, obj, obj2);
        }
    }
}
