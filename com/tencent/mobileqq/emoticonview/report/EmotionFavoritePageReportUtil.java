package com.tencent.mobileqq.emoticonview.report;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionFavoritePageReportUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mEmotionDaTongReportHelper", "Lcom/tencent/mobileqq/emoticonview/report/EmotionDaTongReportHelper;", "initElements", "", "reportEmojiAddedClick", "reportEmojiClick", "emojiID", "", "reportEmojiManageClick", "reportPageExit", "reportPageExpose", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmotionFavoritePageReportUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EM_BAS_EMOJI;

    @NotNull
    private static final String EM_BAS_EMOJI_ADDED;

    @NotNull
    private static final String EM_BAS_MANAGE;

    @NotNull
    private static final String PARAM_STICKER_ID;

    @NotNull
    private static final String PG_BAS_EMOJI_MANAGEMENT;

    @NotNull
    private final EmotionDaTongReportHelper mEmotionDaTongReportHelper;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/report/EmotionFavoritePageReportUtil$Companion;", "", "()V", "EM_BAS_EMOJI", "", "getEM_BAS_EMOJI", "()Ljava/lang/String;", "EM_BAS_EMOJI_ADDED", "getEM_BAS_EMOJI_ADDED", "EM_BAS_MANAGE", "getEM_BAS_MANAGE", "PARAM_STICKER_ID", "getPARAM_STICKER_ID", "PG_BAS_EMOJI_MANAGEMENT", "getPG_BAS_EMOJI_MANAGEMENT", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String getEM_BAS_EMOJI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return EmotionFavoritePageReportUtil.EM_BAS_EMOJI;
            }
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_EMOJI_ADDED() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return EmotionFavoritePageReportUtil.EM_BAS_EMOJI_ADDED;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final String getEM_BAS_MANAGE() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return EmotionFavoritePageReportUtil.EM_BAS_MANAGE;
            }
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @NotNull
        public final String getPARAM_STICKER_ID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return EmotionFavoritePageReportUtil.PARAM_STICKER_ID;
            }
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @NotNull
        public final String getPG_BAS_EMOJI_MANAGEMENT() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return EmotionFavoritePageReportUtil.PG_BAS_EMOJI_MANAGEMENT;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21291);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        PG_BAS_EMOJI_MANAGEMENT = "pg_bas_collect_emoji_management";
        EM_BAS_EMOJI_ADDED = "em_bas_emoji_added";
        EM_BAS_MANAGE = "em_bas_manage";
        EM_BAS_EMOJI = "em_bas_emoji";
        PARAM_STICKER_ID = QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID;
    }

    public EmotionFavoritePageReportUtil(@NotNull Context context) {
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

    public final void initElements() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(EM_BAS_EMOJI_ADDED);
        arrayList.add(EM_BAS_MANAGE);
        arrayList.add(EM_BAS_EMOJI);
        this.mEmotionDaTongReportHelper.initElement(arrayList);
    }

    public final void reportEmojiAddedClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportClick$default(this.mEmotionDaTongReportHelper, EM_BAS_EMOJI_ADDED, null, 2, null);
        }
    }

    public final void reportEmojiClick(@Nullable String emojiID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) emojiID);
            return;
        }
        HashMap hashMap = new HashMap();
        String str = PARAM_STICKER_ID;
        if (emojiID == null) {
            emojiID = "0";
        }
        hashMap.put(str, emojiID);
        this.mEmotionDaTongReportHelper.reportClick(EM_BAS_EMOJI, hashMap);
    }

    public final void reportEmojiManageClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportClick$default(this.mEmotionDaTongReportHelper, EM_BAS_MANAGE, null, 2, null);
        }
    }

    public final void reportPageExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportPageExit$default(this.mEmotionDaTongReportHelper, null, 1, null);
        }
    }

    public final void reportPageExpose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            EmotionDaTongReportHelper.reportPageExpose$default(this.mEmotionDaTongReportHelper, null, 1, null);
        }
    }
}
