package com.tencent.mobileqq.emoticonview.report;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionManagePageReportUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mEmotionDaTongReportHelper", "Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportHelper;", "getDtReportElementName", "", "commonTabEmojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonTabEmojiInfo;", "initElements", "", "reportEmoticonPackageClick", "reportEmoticonPackageExpose", "mShowingCommonTabEmojiInfoList", "", "reportFavoriteEmotionClick", "reportManageEmotionClick", "reportPageExit", "reportPageExpose", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmotionManagePageReportUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EM_BAS_AI_EXPRESSION;

    @NotNull
    private static final String EM_BAS_FAVORITE_EMOJI;

    @NotNull
    private static final String EM_BAS_GIF_EMOJI;

    @NotNull
    private static final String EM_BAS_MANAGE;

    @NotNull
    private static final String EM_BAS_SUPER_QQ_SHOW;

    @NotNull
    private static final String EM_PARAMS_IS_OPEN;

    @NotNull
    private static final String PG_BAS_EMOJI_MANAGEMENT;

    @NotNull
    private final EmotionDaTongReportHelper mEmotionDaTongReportHelper;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionManagePageReportUtil$Companion;", "", "()V", "EM_BAS_AI_EXPRESSION", "", "getEM_BAS_AI_EXPRESSION", "()Ljava/lang/String;", "EM_BAS_FAVORITE_EMOJI", "getEM_BAS_FAVORITE_EMOJI", "EM_BAS_GIF_EMOJI", "getEM_BAS_GIF_EMOJI", "EM_BAS_MANAGE", "getEM_BAS_MANAGE", "EM_BAS_SUPER_QQ_SHOW", "getEM_BAS_SUPER_QQ_SHOW", "EM_PARAMS_IS_OPEN", "getEM_PARAMS_IS_OPEN", "PG_BAS_EMOJI_MANAGEMENT", "getPG_BAS_EMOJI_MANAGEMENT", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String getEM_BAS_AI_EXPRESSION() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return EmotionManagePageReportUtil.EM_BAS_AI_EXPRESSION;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_FAVORITE_EMOJI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return EmotionManagePageReportUtil.EM_BAS_FAVORITE_EMOJI;
            }
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_GIF_EMOJI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return EmotionManagePageReportUtil.EM_BAS_GIF_EMOJI;
            }
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_MANAGE() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return EmotionManagePageReportUtil.EM_BAS_MANAGE;
            }
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_SUPER_QQ_SHOW() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return EmotionManagePageReportUtil.EM_BAS_SUPER_QQ_SHOW;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final String getEM_PARAMS_IS_OPEN() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return EmotionManagePageReportUtil.EM_PARAMS_IS_OPEN;
            }
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }

        @NotNull
        public final String getPG_BAS_EMOJI_MANAGEMENT() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return EmotionManagePageReportUtil.PG_BAS_EMOJI_MANAGEMENT;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        PG_BAS_EMOJI_MANAGEMENT = "pg_bas_emoji_management";
        EM_BAS_AI_EXPRESSION = EmotionDaTongReportUtil.EM_BAS_AI_EXPRESSION;
        EM_BAS_SUPER_QQ_SHOW = "em_bas_super_qq_show";
        EM_BAS_GIF_EMOJI = "em_bas_gif_emoji";
        EM_BAS_FAVORITE_EMOJI = "em_bas_favorite_emoji";
        EM_BAS_MANAGE = "em_bas_manage";
        EM_PARAMS_IS_OPEN = "is_open";
    }

    public EmotionManagePageReportUtil(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        EmotionDaTongReportHelper emotionDaTongReportHelper = new EmotionDaTongReportHelper(context);
        this.mEmotionDaTongReportHelper = emotionDaTongReportHelper;
        EmotionDaTongReportHelper.initPage$default(emotionDaTongReportHelper, PG_BAS_EMOJI_MANAGEMENT, null, 2, null);
        initElements();
    }

    private final String getDtReportElementName(CommonTabEmojiInfo commonTabEmojiInfo) {
        if (commonTabEmojiInfo.bottomEmojitabType == 6) {
            int i3 = commonTabEmojiInfo.epId;
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 == 7) {
                            return EM_BAS_SUPER_QQ_SHOW;
                        }
                    } else {
                        return EM_BAS_AI_EXPRESSION;
                    }
                } else {
                    return EM_BAS_GIF_EMOJI;
                }
            } else {
                return EM_BAS_FAVORITE_EMOJI;
            }
        }
        return null;
    }

    public final void initElements() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(EM_BAS_FAVORITE_EMOJI);
        arrayList.add(EM_BAS_MANAGE);
        arrayList.add(EM_BAS_AI_EXPRESSION);
        arrayList.add(EM_BAS_SUPER_QQ_SHOW);
        arrayList.add(EM_BAS_GIF_EMOJI);
        this.mEmotionDaTongReportHelper.initElement(arrayList);
    }

    public final void reportEmoticonPackageClick(@NotNull CommonTabEmojiInfo commonTabEmojiInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) commonTabEmojiInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(commonTabEmojiInfo, "commonTabEmojiInfo");
        String dtReportElementName = getDtReportElementName(commonTabEmojiInfo);
        if (!TextUtils.isEmpty(dtReportElementName)) {
            HashMap hashMap = new HashMap();
            String str2 = EM_PARAMS_IS_OPEN;
            if (commonTabEmojiInfo.isHide) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put(str2, str);
            EmotionDaTongReportHelper emotionDaTongReportHelper = this.mEmotionDaTongReportHelper;
            Intrinsics.checkNotNull(dtReportElementName);
            EmotionDaTongReportHelper.reportClick$default(emotionDaTongReportHelper, dtReportElementName, null, 2, null);
        }
    }

    public final void reportEmoticonPackageExpose(@NotNull List<CommonTabEmojiInfo> mShowingCommonTabEmojiInfoList) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mShowingCommonTabEmojiInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(mShowingCommonTabEmojiInfoList, "mShowingCommonTabEmojiInfoList");
        for (CommonTabEmojiInfo commonTabEmojiInfo : mShowingCommonTabEmojiInfoList) {
            String dtReportElementName = getDtReportElementName(commonTabEmojiInfo);
            if (!TextUtils.isEmpty(dtReportElementName)) {
                HashMap hashMap = new HashMap();
                String str2 = EM_PARAMS_IS_OPEN;
                if (commonTabEmojiInfo.isHide) {
                    str = "0";
                } else {
                    str = "1";
                }
                hashMap.put(str2, str);
                EmotionDaTongReportHelper emotionDaTongReportHelper = this.mEmotionDaTongReportHelper;
                Intrinsics.checkNotNull(dtReportElementName);
                EmotionDaTongReportHelper.reportExpose$default(emotionDaTongReportHelper, dtReportElementName, null, 2, null);
            }
        }
    }

    public final void reportFavoriteEmotionClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportClick$default(this.mEmotionDaTongReportHelper, EM_BAS_FAVORITE_EMOJI, null, 2, null);
        }
    }

    public final void reportManageEmotionClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportClick$default(this.mEmotionDaTongReportHelper, EM_BAS_MANAGE, null, 2, null);
        }
    }

    public final void reportPageExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportPageExit$default(this.mEmotionDaTongReportHelper, null, 1, null);
        }
    }

    public final void reportPageExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportPageExpose$default(this.mEmotionDaTongReportHelper, null, 1, null);
        }
    }
}
