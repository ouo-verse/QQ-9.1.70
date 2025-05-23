package com.tencent.mobileqq.troop.homework.api;

import android.app.Activity;
import android.os.Bundle;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.state.data.SquareJSConst;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bg\u0018\u0000 %2\u00020\u0001:\u0003&'(J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&JD\u0010\u000f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&JG\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&\u00a2\u0006\u0004\b\u0017\u0010\u0019J\u001c\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J*\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\"\u0010\u001d\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H&J\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J*\u0010 \u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J\b\u0010$\u001a\u00020\u0016H&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "extras", "", "troopUin", "", "startPublishHomeWorkFragment", "title", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "extData", "openTeacherHistoryMsgPage", "url", "", "chatType", ark.APP_SPECIFIC_BIZSRC, "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "from", "", "handleHttpUrl", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;)Z", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "openNoticeListPage", "noticeId", "openNoticeDetailPage", "isHWUrlAndEquals", "openClockInListPage", "clockInId", "openClockInDetailPage", "Ljava/lang/Class;", "", "getTeacherHistoryMsgParser", "isSwitchOn", "Companion", "a", "DetailPageFrom", "TeacherMsgSourceFrom", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IHWTroopUIApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CLOCK_IN_ARK_ID = "familySchoolGroup.checkin";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String NOTICE_ARK_ID = "familySchoolGroup.notification";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "GROUP_ARK", "C2C_ARK", "NOTICE_LIST", "GROUP_BAR", "OTHER", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class DetailPageFrom implements Serializable {
        private static final /* synthetic */ DetailPageFrom[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DetailPageFrom C2C_ARK;
        public static final DetailPageFrom GROUP_ARK;
        public static final DetailPageFrom GROUP_BAR;
        public static final DetailPageFrom NOTICE_LIST;
        public static final DetailPageFrom OTHER;

        private static final /* synthetic */ DetailPageFrom[] $values() {
            return new DetailPageFrom[]{GROUP_ARK, C2C_ARK, NOTICE_LIST, GROUP_BAR, OTHER};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24572);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            GROUP_ARK = new DetailPageFrom("GROUP_ARK", 0);
            C2C_ARK = new DetailPageFrom("C2C_ARK", 1);
            NOTICE_LIST = new DetailPageFrom("NOTICE_LIST", 2);
            GROUP_BAR = new DetailPageFrom("GROUP_BAR", 3);
            OTHER = new DetailPageFrom("OTHER", 4);
            $VALUES = $values();
        }

        DetailPageFrom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DetailPageFrom valueOf(String str) {
            return (DetailPageFrom) Enum.valueOf(DetailPageFrom.class, str);
        }

        public static DetailPageFrom[] values() {
            return (DetailPageFrom[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$TeacherMsgSourceFrom;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "UNKNOWN", "PUSH", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TeacherMsgSourceFrom {
        private static final /* synthetic */ TeacherMsgSourceFrom[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TeacherMsgSourceFrom PUSH;
        public static final TeacherMsgSourceFrom UNKNOWN;
        private final int value;

        private static final /* synthetic */ TeacherMsgSourceFrom[] $values() {
            return new TeacherMsgSourceFrom[]{UNKNOWN, PUSH};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24575);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            UNKNOWN = new TeacherMsgSourceFrom("UNKNOWN", 0, 0);
            PUSH = new TeacherMsgSourceFrom("PUSH", 1, 1);
            $VALUES = $values();
        }

        TeacherMsgSourceFrom(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static TeacherMsgSourceFrom valueOf(String str) {
            return (TeacherMsgSourceFrom) Enum.valueOf(TeacherMsgSourceFrom.class, str);
        }

        public static TeacherMsgSourceFrom[] values() {
            return (TeacherMsgSourceFrom[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$a;", "", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f296273a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24567);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f296273a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b {
        public static /* synthetic */ boolean a(IHWTroopUIApi iHWTroopUIApi, Activity activity, String str, Integer num, String str2, DetailPageFrom detailPageFrom, int i3, Object obj) {
            String str3;
            DetailPageFrom detailPageFrom2;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    num = -1;
                }
                Integer num2 = num;
                if ((i3 & 8) != 0) {
                    str3 = null;
                } else {
                    str3 = str2;
                }
                if ((i3 & 16) != 0) {
                    detailPageFrom2 = null;
                } else {
                    detailPageFrom2 = detailPageFrom;
                }
                return iHWTroopUIApi.handleHttpUrl(activity, str, num2, str3, detailPageFrom2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleHttpUrl");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_NOT_PUNISHED), (Class<?>) IHWTroopUIApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f296273a;
        }
    }

    @NotNull
    Class<Object> getTeacherHistoryMsgParser();

    boolean handleHttpUrl(@Nullable Activity activity, @Nullable String url);

    boolean handleHttpUrl(@Nullable Activity activity, @Nullable String url, @Nullable Integer chatType, @Nullable String bizSrc);

    boolean handleHttpUrl(@Nullable Activity activity, @Nullable String url, @Nullable Integer chatType, @Nullable String bizSrc, @Nullable DetailPageFrom from);

    boolean isHWUrlAndEquals(@Nullable String url, @NotNull String troopUin, @NotNull String noticeId);

    boolean isSwitchOn();

    void openClockInDetailPage(@Nullable Activity activity, @NotNull String troopUin, @NotNull String clockInId, @NotNull DetailPageFrom from);

    void openClockInListPage(@Nullable Activity activity, @NotNull String troopUin);

    void openNoticeDetailPage(@Nullable Activity activity, @NotNull String troopUin, @NotNull String noticeId, @NotNull DetailPageFrom from);

    void openNoticeListPage(@Nullable Activity activity, @NotNull String troopUin);

    void openTeacherHistoryMsgPage(@Nullable String title, @Nullable String troopUin, @Nullable ArrayList<String> uinList, @Nullable Bundle extData);

    void startPublishHomeWorkFragment(@Nullable Activity activity, @Nullable Bundle extras, @Nullable String troopUin);
}
