package com.tencent.mobileqq.gamecenter.qa.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gamecenter.qa.config.QAArticleConfigParser;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.editor.effect.SpanCollectMode;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.gamecenter.qa.view.ab;
import com.tencent.mobileqq.gamecenter.qa.view.w;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import ud1.GameQAHippyPageConfig;
import ud1.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQAUtil {

    /* renamed from: a, reason: collision with root package name */
    private static vd1.b f212678a;

    /* JADX WARN: Removed duplicated region for block: B:16:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A(Context context, int i3, long j3, boolean z16, boolean z17, int i16) {
        boolean z18;
        QLog.d("QQGameStrategyUtil", 1, "openQAQuestionPage");
        if (context == null) {
            QLog.e("QQGameStrategyUtil", 1, "openQAQuestionPage, context null");
            return;
        }
        GameQAHippyPageConfig gameQAHippyPageConfig = (GameQAHippyPageConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100784");
        String str = "https://youxi.gamecenter.qq.com/ogame/game-strategy-qa/question.html?appid=%s&qusid=%s&_wv=131073&_wwv=132&_fv=0&gamecenter_src=pindao&adtag=pindao_feeds_qus";
        String str2 = null;
        if (gameQAHippyPageConfig != null) {
            String questionUrl = gameQAHippyPageConfig.getQuestionUrl();
            if (z17) {
                questionUrl = gameQAHippyPageConfig.getAnswerUrl();
            }
            if (!TextUtils.isEmpty(questionUrl)) {
                try {
                    str2 = gameQAHippyPageConfig.getQuestionErrorUrl();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "https://youxi.gamecenter.qq.com/ogame/game-strategy-qa/question.html?appid=%s&qusid=%s&_wv=131073&_wwv=132&_fv=0&gamecenter_src=pindao&adtag=pindao_feeds_qus";
                    }
                    String format = String.format(str2, Integer.valueOf(i3), Long.valueOf(j3));
                    String str3 = "appid=%s&qusid=%s";
                    if (z16) {
                        str3 = "appid=%s&qusid=%s&tag=question&adtag=pindao_afterask";
                        if (i16 > 0) {
                            str3 = "appid=%s&qusid=%s&tag=question&adtag=pindao_afterask&guru_invited_num=" + i16;
                        }
                    } else if (z17) {
                        str3 = "appid=%s&qusid=%s&adtag=pindao_afteranswer&show_answer_success=1&tag=answer";
                    }
                    String replace = questionUrl.replace("[params]", URLEncoder.encode(String.format(str3, Integer.valueOf(i3), Long.valueOf(j3)), "UTF-8"));
                    if (QLog.isColorLevel()) {
                        QLog.d("QQGameStrategyUtil", 2, "openQAQuestionPage, url=", replace);
                    }
                    y(context, gameQAHippyPageConfig.getDomain(), replace, format);
                    z18 = true;
                } catch (Exception e16) {
                    QLog.e("QQGameStrategyUtil", 1, "openQAQuestionPage, exception=", e16);
                }
                if (z18) {
                    QLog.d("QQGameStrategyUtil", 1, "openQAQuestionPage, open h5");
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("url", String.format(str, Integer.valueOf(i3), Long.valueOf(j3)));
                    RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                    return;
                }
                return;
            }
            QLog.w("QQGameStrategyUtil", 1, "openQAQuestionPage, questionUrl null");
        } else {
            QLog.w("QQGameStrategyUtil", 1, "openQAQuestionPage, config null");
        }
        z18 = false;
        if (z18) {
        }
    }

    public static void B() {
        ((IWebProcessManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(30, null);
    }

    public static String C(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile("\\t|\\r|\\n").matcher(str).replaceAll("");
        }
        return null;
    }

    public static void D(int i3, long j3, GameQALinkCardData gameQALinkCardData) {
        String str;
        if (gameQALinkCardData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(6, String.valueOf(j3));
        if (gameQALinkCardData.getTitle() != null) {
            str = gameQALinkCardData.getTitle();
        } else {
            str = "";
        }
        hashMap.put(3, str);
        hashMap.put(9, String.valueOf(n(gameQALinkCardData)));
        e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "102549", "912753", "8", String.valueOf(i3), hashMap);
    }

    public static void E(String str, String str2, int i3) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).encodeInt("sp_key_game_center_qa_game_appid_" + str + "_" + str2, i3);
        }
    }

    public static void F() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).encodeBool(peekAppRuntime.getAccount() + "sp_key_ask_button_tips_default_shown", true);
        }
    }

    public static void G(vd1.b bVar) {
        f212678a = bVar;
    }

    public static void H() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).encodeBool(peekAppRuntime.getAccount() + "sp_key_game_center_qa_expert_guide", true);
        }
    }

    public static void I(View view, QBaseActivity qBaseActivity, boolean z16) {
        int i3;
        view.setFitsSystemWindows(true);
        view.setPadding(0, ImmersiveUtils.getStatusBarHeight(qBaseActivity), 0, 0);
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(qBaseActivity);
        if (systemBarComp != null) {
            systemBarComp.init();
            Resources resources = qBaseActivity.getResources();
            if (z16) {
                i3 = R.color.cfi;
            } else {
                i3 = R.color.cfh;
            }
            systemBarComp.setStatusBarColor(resources.getColor(i3));
            ImmersiveUtils.setStatusTextColor(true, qBaseActivity.getWindow());
            if (Build.VERSION.SDK_INT >= 26) {
                View decorView = qBaseActivity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
        }
    }

    public static boolean J() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD);
        String str = peekAppRuntime.getAccount() + "sp_key_ask_button_tips_timestamp";
        long decodeLong = from.decodeLong(str, 0L);
        String str2 = peekAppRuntime.getAccount() + "sp_key_ask_button_tips_count";
        int decodeInt = from.decodeInt(str2, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - decodeLong >= 86400) {
            from.encodeInt(str2, 0);
            from.encodeLong(str, currentTimeMillis);
            return true;
        }
        int g16 = g();
        QLog.d("QQGameStrategyUtil", 1, "shouldShowAskButtonTips, current count=", Integer.valueOf(decodeInt), ", askButtonTestShowMaxTimes=", Integer.valueOf(g16));
        if (decodeInt >= g16) {
            return false;
        }
        return true;
    }

    public static void K(final Context context, final boolean z16, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(context, !z16 ? 1 : 0, i3, 0).show();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float a(AlignmentSpan alignmentSpan, Paragraph paragraph, GameStrategyEditTextView gameStrategyEditTextView, int i3) {
        AbsoluteSizeSpan absoluteSizeSpan;
        float textSize;
        float textSize2;
        float f16;
        float f17 = 0.0f;
        if (alignmentSpan != null && ((alignmentSpan.getValue() == Layout.Alignment.ALIGN_CENTER || alignmentSpan.getValue() == Layout.Alignment.ALIGN_OPPOSITE) && gameStrategyEditTextView != null && paragraph != null && paragraph.getMEnd() > paragraph.getMStart())) {
            String replaceAll = gameStrategyEditTextView.getText().toString().substring(paragraph.getMStart(), paragraph.getMEnd()).replaceAll(RedTouch.NEWLINE_CHAR, "");
            List<zd1.e<Integer>> d16 = com.tencent.mobileqq.gamecenter.qa.editor.effect.h.FONTSIZE.d(gameStrategyEditTextView.getText(), paragraph, SpanCollectMode.SPAN_FLAGS);
            if (d16 != null && !d16.isEmpty()) {
                zd1.e<Integer> eVar = d16.get(0);
                if (eVar instanceof AbsoluteSizeSpan) {
                    absoluteSizeSpan = (AbsoluteSizeSpan) eVar;
                    textSize = gameStrategyEditTextView.getTextSize();
                    if (absoluteSizeSpan != null) {
                        textSize = absoluteSizeSpan.getValue().intValue();
                    }
                    textSize2 = gameStrategyEditTextView.getPaint().getTextSize();
                    if (textSize2 != textSize) {
                        gameStrategyEditTextView.getPaint().setTextSize(textSize);
                    }
                    float measureText = gameStrategyEditTextView.getPaint().measureText(replaceAll);
                    int width = (gameStrategyEditTextView.getWidth() - gameStrategyEditTextView.getPaddingLeft()) - gameStrategyEditTextView.getPaddingRight();
                    if (alignmentSpan.getValue() != Layout.Alignment.ALIGN_OPPOSITE) {
                        float f18 = width - i3;
                        if (measureText <= f18) {
                            f16 = f18 - measureText;
                            f17 = f16;
                        }
                        gameStrategyEditTextView.getPaint().setTextSize(textSize2);
                    } else {
                        float f19 = width;
                        if (measureText <= f19) {
                            f16 = ((f19 - measureText) / 2.0f) - i3;
                            f17 = f16;
                        }
                        gameStrategyEditTextView.getPaint().setTextSize(textSize2);
                    }
                }
            }
            absoluteSizeSpan = null;
            textSize = gameStrategyEditTextView.getTextSize();
            if (absoluteSizeSpan != null) {
            }
            textSize2 = gameStrategyEditTextView.getPaint().getTextSize();
            if (textSize2 != textSize) {
            }
            float measureText2 = gameStrategyEditTextView.getPaint().measureText(replaceAll);
            int width2 = (gameStrategyEditTextView.getWidth() - gameStrategyEditTextView.getPaddingLeft()) - gameStrategyEditTextView.getPaddingRight();
            if (alignmentSpan.getValue() != Layout.Alignment.ALIGN_OPPOSITE) {
            }
        }
        return f17;
    }

    public static boolean b(String str) {
        try {
            ClipboardMonitor.setPrimaryClip((ClipboardManager) BaseApplication.getContext().getSystemService("clipboard"), ClipData.newPlainText("Label", str));
            return true;
        } catch (Exception e16) {
            QLog.e("QQGameStrategyUtil", 1, "copyToClipboard, exception=", e16);
            return false;
        }
    }

    public static void c(w wVar, EditText editText) {
        if (wVar != null && editText != null) {
            Editable editableText = editText.getEditableText();
            int spanStart = editableText.getSpanStart(wVar);
            int spanEnd = editableText.getSpanEnd(wVar);
            if (spanStart - 1 >= 0 && spanEnd >= 0) {
                editableText.delete(spanStart, spanEnd);
                editText.setSelection(spanStart);
            }
        }
    }

    public static void d(ab abVar, EditText editText) {
        if (abVar != null && editText != null) {
            Editable editableText = editText.getEditableText();
            int spanStart = editableText.getSpanStart(abVar);
            int spanEnd = editableText.getSpanEnd(abVar);
            if (spanStart >= 0 && spanEnd >= 0) {
                editText.setSelection(spanEnd);
                editableText.delete(spanStart, spanEnd);
            }
        }
    }

    public static String e(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(1);
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(currentTimeMillis);
        int i16 = calendar2.get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (i3 == i16) {
            simpleDateFormat = new SimpleDateFormat("MM-dd");
        }
        return simpleDateFormat.format(Long.valueOf(j3));
    }

    public static int f(String str, String str2) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return 0;
        }
        return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).decodeInt("sp_key_game_center_qa_game_appid_" + str + "_" + str2, 0);
    }

    public static int g() {
        int i3;
        try {
            i3 = Integer.parseInt(new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("100495", "1".getBytes()), StandardCharsets.UTF_8).trim());
            try {
                QLog.d("QQGameStrategyUtil", 1, "getAskBtnTestMaxShowTimes, result=", Integer.valueOf(i3));
            } catch (Exception e16) {
                e = e16;
                QLog.e("QQGameStrategyUtil", 1, "getAskBtnTestMaxShowTimes, exception=", e);
                return i3;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 1;
        }
        return i3;
    }

    public static vd1.b h() {
        return f212678a;
    }

    public static Map<Integer, String> i(Activity activity, GameStrategyChannelEntry gameStrategyChannelEntry) {
        HashMap hashMap = new HashMap();
        if (gameStrategyChannelEntry != null) {
            hashMap.put(6, gameStrategyChannelEntry.guildId);
            hashMap.put(7, gameStrategyChannelEntry.channelId);
        }
        if (activity instanceof QBaseActivity) {
            hashMap.put(8, ((QBaseActivity) activity).getCurrentAccountUinFromRuntime());
        }
        return hashMap;
    }

    public static Map<Integer, String> j(Activity activity, GameStrategyChannelEntry gameStrategyChannelEntry, long j3) {
        Map<Integer, String> i3 = i(activity, gameStrategyChannelEntry);
        i3.put(3, String.valueOf(j3));
        return i3;
    }

    public static String k(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = str.replaceAll("\n", " ").replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("<br />", "").replaceAll("<br/>", "").replaceAll("</div>", "").replaceAll("</span>", "").replaceAll("\\{\\{[^<]*\\}\\}", "").replaceAll("<div[^<]*>", "").replaceAll("<span[^<]*>", "").replaceAll("</p>", "").replaceAll("<p[^<]*>", "").replaceAll("&nbsp", "").replaceAll("&apos;", "'").replaceAll("&quot;", "\"").replaceAll("&nbsp;", " ").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", ContainerUtils.FIELD_DELIMITER);
                try {
                    return str2.trim();
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("QQGameStrategyUtil", 1, "getFilteredHtmlTag, content=" + str + ", exception=", e);
                    return str2;
                }
            } catch (Exception e17) {
                e = e17;
                str2 = str;
            }
        } else {
            return str;
        }
    }

    public static String l(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        String valueOf = String.valueOf(j3);
        if (j3 >= 10000) {
            return (j3 / 10000) + "w+";
        }
        if (j3 >= 1000) {
            return (j3 / 1000) + "k+";
        }
        return valueOf;
    }

    public static String m(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        String valueOf = String.valueOf(j3);
        if (j3 >= 10000) {
            long j16 = j3 / 10000;
            long j17 = (j3 % 10000) / 1000;
            if (j17 != 0) {
                return j16 + "." + j17 + "w";
            }
            return j16 + "w";
        }
        return valueOf;
    }

    public static int n(GameQALinkCardData gameQALinkCardData) {
        if (gameQALinkCardData == null || gameQALinkCardData.getLinkType() == LinkType.REFERENCE_TYPE_QA) {
            return 6;
        }
        if (gameQALinkCardData.getLinkType() == LinkType.REFERENCE_TYPE_XWORLD) {
            return 1;
        }
        if (gameQALinkCardData.getLinkType() != LinkType.REFERENCE_TYPE_CHANNEL) {
            return 6;
        }
        return 3;
    }

    public static List<String> o(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(https://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 2).matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static void p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD);
            String str = peekAppRuntime.getAccount() + "sp_key_ask_button_tips_count";
            from.encodeInt(str, from.decodeInt(str, 0) + 1);
        }
    }

    public static boolean q(String str) {
        QAArticleConfigParser.b bVar;
        List<g.a> a16;
        if (!TextUtils.isEmpty(str) && (bVar = (QAArticleConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100492")) != null && bVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String() != null && (a16 = bVar.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String().a()) != null && a16.size() > 0) {
            for (g.a aVar : a16) {
                List<String> list = aVar.f438845c;
                if (list != null && list.size() > 0) {
                    Iterator<String> it = aVar.f438845c.iterator();
                    while (it.hasNext()) {
                        if (str.startsWith(it.next())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean r() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).decodeBool(peekAppRuntime.getAccount() + "sp_key_ask_button_tips_default_shown", false);
        }
        return true;
    }

    public static boolean s(int i3) {
        if (i3 != LinkType.REFERENCE_TYPE_QA.getType() && i3 != LinkType.REFERENCE_TYPE_CHANNEL.getType() && i3 != LinkType.REFERENCE_TYPE_XWORLD.getType()) {
            return false;
        }
        return true;
    }

    public static boolean t(GameQALinkCardData gameQALinkCardData) {
        if (gameQALinkCardData != null && s(gameQALinkCardData.getLinkType().getType())) {
            return true;
        }
        return false;
    }

    public static boolean u() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_GUILD).decodeBool(peekAppRuntime.getAccount() + "sp_key_game_center_qa_expert_guide", false);
        }
        return true;
    }

    public static boolean v(int i3) {
        if (i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    public static void w(int i3) {
        if (i3 > 0) {
            QLog.d("QQGameStrategyUtil", 1, "jumpMiniGameApp miniGameAppId:", Integer.valueOf(i3));
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            if (iMiniAppService != null) {
                iMiniAppService.startAppByAppid(MobileQQ.sMobileQQ, String.valueOf(i3), "", "", LaunchScene.LAUNCH_SCENE_GAME_CENTER_QA, null);
            }
        }
    }

    public static void x(Context context, int i3, String str) {
        QLog.d("QQGameStrategyUtil", 1, "openMoreQuestionPage");
        if (context == null) {
            QLog.e("QQGameStrategyUtil", 1, "openMoreQuestionPage, context null");
            return;
        }
        GameQAHippyPageConfig gameQAHippyPageConfig = (GameQAHippyPageConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100784");
        boolean z16 = false;
        if (gameQAHippyPageConfig != null) {
            String moreQuestionUrl = gameQAHippyPageConfig.getMoreQuestionUrl();
            if (!TextUtils.isEmpty(moreQuestionUrl)) {
                try {
                    y(context, gameQAHippyPageConfig.getDomain(), moreQuestionUrl.replace("[params]", URLEncoder.encode(String.format("appid=%s&ptype=more-ques", Integer.valueOf(i3)), "UTF-8")), str);
                    z16 = true;
                } catch (Exception e16) {
                    QLog.e("QQGameStrategyUtil", 1, "openMoreQuestionPage, exception=", e16);
                }
            } else {
                QLog.w("QQGameStrategyUtil", 1, "openMoreQuestionPage, homePageUrl null");
            }
        } else {
            QLog.w("QQGameStrategyUtil", 1, "openMoreQuestionPage, config null");
        }
        if (!z16) {
            QLog.d("QQGameStrategyUtil", 1, "openMoreQuestionPage, open h5");
            Intent intent = new Intent();
            intent.putExtra("url", str);
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    public static void y(Context context, String str, String str2, String str3) {
        QLog.d("QQGameStrategyUtil", 1, "openQAHippyPage");
        if (context != null && !TextUtils.isEmpty(str2)) {
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_GAMECENTER_STRATEGYQA;
            openHippyInfo.url = str2;
            openHippyInfo.errorUrl = str3;
            openHippyInfo.domain = str;
            openHippyInfo.isStatusBarDarkFont = true;
            openHippyInfo.isAnimated = true;
            openHippyInfo.isEnbaleRightFling = false;
            openHippyInfo.isFullScreen = false;
            openHippyInfo.updateJsBundleType = 1;
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo);
            return;
        }
        QLog.e("QQGameStrategyUtil", 1, "openQAHippyPage, invalid param");
    }

    public static void z(Context context, int i3, long j3) {
        A(context, i3, j3, false, false, 0);
    }
}
