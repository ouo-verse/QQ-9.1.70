package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.d;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForNearbyMarketGrayTips extends ChatMessage {
    public static final int ACTION_AUTO_INPUT = 3;
    public static final int ACTION_AUTO_INPUT_FACE_SCORE = 4;
    public static final int ACTION_DEFAULT = 0;
    public static final int ACTION_JUMP_NATIVE = 2;
    public static final int ACTION_JUMP_WEB = 1;
    private static final String NAME_AIO_TYPE = "aioType";
    private static final String NAME_CONTENT = "content";
    private static final String NAME_HIGHTLIGHT = "high_light";
    private static final String NAME_ID = "id";
    private static final String NAME_LINK = "link";
    private static final String NAME_SCENE = "scene";
    public static final int SCENE_AIO = 8;
    public static final int SCENE_AIO_FACE_SCORE = 16;
    public static final int SCENE_DEFAULT = 0;
    public static final int SCENE_KEYWORD = 4;
    public static final int SCENE_SAY_HI = 1;
    public static final int SCENE_SAY_HI_FREQ = 2;
    public static final String TAG = "MessageForNearbyMarketGrayTips";
    public int AioType = 0;
    public int gender;
    private String mContent;
    private String mHighLight;
    private int mId;
    private String mLink;
    private int mScene;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class HightlightClickableSpan extends ClickableSpan {
        private long C;
        private int D;
        private MessageForNearbyMarketGrayTips E;
        private int F = Integer.MAX_VALUE;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQAppInterface> f203092d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<Context> f203093e;

        /* renamed from: f, reason: collision with root package name */
        private int f203094f;

        /* renamed from: h, reason: collision with root package name */
        private int f203095h;

        /* renamed from: i, reason: collision with root package name */
        private int f203096i;

        /* renamed from: m, reason: collision with root package name */
        private String f203097m;

        public HightlightClickableSpan(QQAppInterface qQAppInterface, Context context, int i3, int i16, int i17, String str, int i18, MessageForNearbyMarketGrayTips messageForNearbyMarketGrayTips) {
            this.f203092d = new WeakReference<>(qQAppInterface);
            this.f203093e = new WeakReference<>(context);
            this.f203096i = i3;
            this.f203094f = i16;
            this.f203095h = i17;
            this.f203097m = str;
            this.D = i18;
            this.E = messageForNearbyMarketGrayTips;
        }

        public void b(String str) {
            if (QLog.isDevelopLevel()) {
                QLog.i(MessageForNearbyMarketGrayTips.TAG, 4, "clickAutoInput, content = " + str);
            }
            final QQAppInterface qQAppInterface = this.f203092d.get();
            if (qQAppInterface == null) {
                return;
            }
            long abs = Math.abs(System.currentTimeMillis() - this.C);
            if (abs > 5000) {
                if (QLog.isColorLevel()) {
                    QLog.i(MessageForNearbyMarketGrayTips.TAG, 2, "clickAutoInput, time = " + abs);
                    return;
                }
                return;
            }
            ((d) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).R1("tag_nearby_chat", str, null);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    if (QLog.isDevelopLevel()) {
                        QLog.i(MessageForNearbyMarketGrayTips.TAG, 4, "0X80052C4");
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, HightlightClickableSpan.this.E.frienduin, "", "", "");
                    if (HightlightClickableSpan.this.E.AioType == 1 || HightlightClickableSpan.this.E.AioType == 3) {
                        QQAppInterface qQAppInterface2 = qQAppInterface;
                        if (HightlightClickableSpan.this.E.AioType == 0) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        ReportController.o(qQAppInterface2, "dc00899", "grp_lbs", "", "tmp_grey", "clk_blue", 0, 0, str2, "", "", "");
                    }
                }
            }, 2, null, false);
        }

        public void c(String str) {
            if (QLog.isDevelopLevel()) {
                QLog.i(MessageForNearbyMarketGrayTips.TAG, 4, "clickJumpNative, schema = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QQAppInterface qQAppInterface = this.f203092d.get();
            Context context = this.f203093e.get();
            if (qQAppInterface != null && context != null) {
                ax c16 = bi.c(qQAppInterface, context, str);
                if (c16 != null) {
                    c16.b();
                } else {
                    d(str);
                }
            }
        }

        public void d(String str) {
            Context context;
            if (QLog.isDevelopLevel()) {
                QLog.i(MessageForNearbyMarketGrayTips.TAG, 4, "clickJumpWeb, url = " + str);
            }
            if (TextUtils.isEmpty(str) || (context = this.f203093e.get()) == null) {
                return;
            }
            if (str.contains("strangerUin=xxx")) {
                str = str.replace("strangerUin=xxx", "strangerUin=" + this.E.frienduin);
            }
            QQAppInterface qQAppInterface = this.f203092d.get();
            if (qQAppInterface != null) {
                if (str.contains("sign=xxx")) {
                    int i3 = this.E.istroop;
                    if (1001 == i3) {
                        str = str.replace("sign=xxx", "sign=" + Utils.e(qQAppInterface.getMsgCache().b0(this.E.frienduin)));
                    } else if (1010 == i3) {
                        str = str.replace("sign=xxx", "sign=" + Utils.e(qQAppInterface.getMsgCache().q0(this.E.frienduin)));
                    } else if (10002 == i3) {
                        str = str.replace("sign=xxx", "sign=" + Utils.e(qQAppInterface.getMsgCache().c1(this.E.frienduin)));
                    }
                }
                if (str.contains("sourceType=xxx")) {
                    int i16 = this.E.istroop;
                    if (1001 == i16) {
                        str = str.replace("sourceType=xxx", "sourceType=1");
                    } else if (1010 == i16) {
                        str = str.replace("sourceType=xxx", "sourceType=2");
                    }
                }
                if (str.equals("https://imgcache.qq.com/club/client/flower/release/html/index.html")) {
                    String str2 = this.E.frienduin;
                    str = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", k.b(str2), Utils.e(qQAppInterface.getMsgCache().b0(str2)).toLowerCase(), 1, "aio.plus.s", "");
                    if (QLog.isColorLevel()) {
                        QLog.i(MessageForNearbyMarketGrayTips.TAG, 2, "jump flow store, " + str);
                    }
                }
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", URLUtil.guessUrl(str));
            context.startActivity(intent);
        }

        public String e(boolean z16) {
            QQAppInterface qQAppInterface = this.f203092d.get();
            if (qQAppInterface == null) {
                return null;
            }
            NearbyGrayTipsManager nearbyGrayTipsManager = (NearbyGrayTipsManager) qQAppInterface.getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
            if (nearbyGrayTipsManager != null) {
                return nearbyGrayTipsManager.e(this.f203096i, z16);
            }
            return "";
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            QQAppInterface qQAppInterface = this.f203092d.get();
            if (qQAppInterface != null) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X800524C", "0X800524C", 0, 0, String.valueOf(this.f203096i), "", "", "");
                if (this.E.AioType == 0) {
                    str = "0";
                } else {
                    str = "1";
                }
                ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_link", 0, 0, str, "", "", "");
            }
            int i3 = this.f203095h;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.C = System.currentTimeMillis();
                        String e16 = e(false);
                        if (TextUtils.isEmpty(e16)) {
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    HightlightClickableSpan.this.b(HightlightClickableSpan.this.e(true));
                                }
                            }, 5, null, true);
                            return;
                        } else {
                            b(e16);
                            return;
                        }
                    }
                    return;
                }
                c(this.f203097m);
                return;
            }
            d(this.f203097m);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            int i3 = this.f203094f;
            if (i3 == -1) {
                textPaint.setColor(textPaint.linkColor);
            } else {
                textPaint.setColor(i3);
            }
            textPaint.setUnderlineText(false);
        }
    }

    public static String makeGrayTipMsg(int i3, String str, String str2, int i16, String str3, int i17) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i3);
            jSONObject.put("content", str);
            jSONObject.put(NAME_HIGHTLIGHT, str2);
            jSONObject.put("scene", i16);
            jSONObject.put("link", str3);
            jSONObject.put(NAME_AIO_TYPE, i17);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "doParse: " + this.f203106msg);
        }
        String str = this.f203106msg;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mId = jSONObject.getInt("id");
            this.mContent = jSONObject.getString("content");
            if (jSONObject.has(NAME_HIGHTLIGHT)) {
                this.mHighLight = jSONObject.getString(NAME_HIGHTLIGHT);
            } else {
                this.mHighLight = null;
            }
            if (jSONObject.has("scene")) {
                this.mScene = jSONObject.getInt("scene");
            } else {
                this.mScene = 0;
            }
            if (jSONObject.has("link")) {
                this.mLink = jSONObject.getString("link");
            } else {
                this.mLink = null;
            }
            if (jSONObject.has(NAME_AIO_TYPE)) {
                this.AioType = jSONObject.getInt(NAME_AIO_TYPE);
            } else {
                this.AioType = 0;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            this.mContent = str;
            this.mHighLight = null;
            this.mScene = 0;
            this.mLink = null;
            this.AioType = 0;
        }
    }

    public SpannableString getHightlightMsgText(QQAppInterface qQAppInterface, Context context) {
        int i3;
        int i16;
        int i17;
        if (!TextUtils.isEmpty(this.mContent) && !TextUtils.isEmpty(this.mHighLight)) {
            i3 = this.mContent.indexOf(this.mHighLight);
        } else {
            i3 = -1;
        }
        int i18 = i3;
        int i19 = 0;
        if (i18 >= 0) {
            i16 = this.mHighLight.length() + i18;
        } else {
            i16 = 0;
        }
        SpannableString spannableString = new SpannableString(this.mContent);
        if (i18 >= 0 && i16 > i18) {
            int i26 = this.mScene;
            if (i26 != 1 && i26 != 2 && i26 != 4) {
                if (i26 != 8) {
                    if (i26 == 16) {
                        i17 = 4;
                        spannableString.setSpan(new HightlightClickableSpan(qQAppInterface, context, this.mId, -12541697, i17, this.mLink, this.mScene, this), i18, i16, 33);
                    }
                } else {
                    i19 = 3;
                }
                i17 = i19;
                spannableString.setSpan(new HightlightClickableSpan(qQAppInterface, context, this.mId, -12541697, i17, this.mLink, this.mScene, this), i18, i16, 33);
            } else {
                if (!TextUtils.isEmpty(this.mLink)) {
                    if (this.mLink.startsWith("mqqapi://")) {
                        i17 = 2;
                    } else {
                        i17 = 1;
                    }
                    spannableString.setSpan(new HightlightClickableSpan(qQAppInterface, context, this.mId, -12541697, i17, this.mLink, this.mScene, this), i18, i16, 33);
                }
                i17 = i19;
                spannableString.setSpan(new HightlightClickableSpan(qQAppInterface, context, this.mId, -12541697, i17, this.mLink, this.mScene, this), i18, i16, 33);
            }
        }
        return spannableString;
    }
}
