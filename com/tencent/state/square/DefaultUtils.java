package com.tencent.state.square;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.api.SummaryData;
import com.tencent.state.square.config.MsgBoxConfig;
import com.tencent.state.square.config.PerformanceConfig;
import com.tencent.state.square.data.SquareDeviceInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 x2\u00020\u0001:\u0001xB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\u001a\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\fH\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010>\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\u0012\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\f2\u0006\u0010 \u001a\u00020GH\u0016J3\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\f2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020J0MH\u0016J\u0018\u0010Q\u001a\u00020J2\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0012H\u0016J\u0010\u0010T\u001a\u00020J2\u0006\u0010U\u001a\u00020\u0006H\u0016J\u0018\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0004H\u0016J\u0010\u0010Z\u001a\u00020J2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020J2\u0006\u0010^\u001a\u00020\u0004H\u0016J\u0010\u0010_\u001a\u00020J2\u0006\u0010^\u001a\u00020\u0004H\u0016J\u0010\u0010`\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J3\u0010a\u001a\u00020J2\u0006\u0010K\u001a\u00020\f2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020J0MH\u0016J\"\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\f2\u0006\u0010g\u001a\u00020hH\u0016JU\u0010i\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\f2\u0006\u0010l\u001a\u00020\f2\b\u0010m\u001a\u0004\u0018\u00010\f2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020J0MH\u0016J@\u0010i\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\f2\u0006\u0010o\u001a\u00020\f2\b\u0010m\u001a\u0004\u0018\u00010\f2\u0006\u0010p\u001a\u00020\u00062\f\u0010L\u001a\b\u0012\u0004\u0012\u00020J0qH\u0016J \u0010r\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010s\u001a\u00020\u00042\u0006\u0010t\u001a\u00020\u0004H\u0016J\"\u0010r\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010u\u001a\u0004\u0018\u00010\f2\u0006\u0010t\u001a\u00020\u0004H\u0016J\b\u0010v\u001a\u00020JH\u0016J\u0010\u0010w\u001a\u00020J2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006y"}, d2 = {"Lcom/tencent/state/square/DefaultUtils;", "Lcom/tencent/state/square/ICommonUtils;", "()V", "filamentPlayCountIncludeMe", "", "forbiddenLocalRecord", "", "needShieldTeenager", "playCountIncludeMe", "squareDebug", "checkZplanAccessible", "uin", "", "enableZPlanFilamentBase", "formatTimeForMsgBox", "context", "Landroid/content/Context;", "time", "", "getAppReportVersionName", "getApplication", "Landroid/app/Application;", "getCpuCoreNum", "getCpuMaxFreq", "getCurrentAccountUin", "getDebugFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "pageType", "Lcom/tencent/state/square/DebugPageType;", "getDeviceName", "getForbidLocalRecord", "getFriendRemarkName", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getGpuInfo", "getMsgBoxConfig", "Lcom/tencent/state/square/config/MsgBoxConfig;", "getNeedReportPlaySuccess", "getNeedShieldTeenager", "getPagImageView", "Lcom/tencent/state/square/api/ISquarePagView;", "getPagView", "getRAMSize", "getSelfTinyId", "getServerTime", "getSquareDebug", "getSquareDeviceInfo", "Lcom/tencent/state/square/data/SquareDeviceInfo;", "getSquareFilamentPlayCountIncludeMe", "getSquarePlayCountIncludeMe", "getSummaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", DownloadInfo.spKey_Config, "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "getSystemVersion", "getUrlDrawableFile", "Ljava/io/File;", "url", "getUserAppearanceKey", "hasSendFriendRequest", "isApngLoaded", "isBackgroundStop", "isCurrentAccount", "isDrawableReady", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "isLikeIconUseHug", "isSongPlaying", "songMid", "isSwitchOn", "key", "loadRawConfig", "", VipFunCallConstants.KEY_GROUP, "paiYiPaiFriend", "", "friendUin", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "phoneVibrate", "from", "duration", "setForbidLocalRecord", "forbidden", "setImmersiveStatus", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "setNeedShieldTeenager", "setSquareDebug", "isDebug", "setSquareFilamentPlayCountIncludeMe", "playCount", "setSquarePlayCountIncludeMe", "setStandardFont", "shouldShowSmallHomeEntry", "showCallOutPopupWindow", "Landroid/widget/PopupWindow;", "decor", "Landroid/view/View;", "text", "style", "Lcom/tencent/state/square/CalloutPopupWindowStyle;", "showDialog", "msg", "rightText", "leftText", "title", "isRight", "midText", "isSelect", "Lkotlin/Function0;", UIJsPlugin.EVENT_SHOW_TOAST, PoiListCacheRecord.WEIGHT_TYPE, "type", "message", "startZPlanEngineWhenNotReady", "unSetStandardFont", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class DefaultUtils implements ICommonUtils {
    private static final String TAG = "DefaultUtils";
    private boolean needShieldTeenager;
    private boolean squareDebug;
    private int playCountIncludeMe = 10;
    private int filamentPlayCountIncludeMe = 2;
    private boolean forbiddenLocalRecord = true;

    @Override // com.tencent.state.square.ICommonUtils
    public boolean checkZplanAccessible(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean enableZPlanFilamentBase() {
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String formatTimeForMsgBox(@NotNull Context context, long time) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(time));
            Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"HH:mm\").format(Date(time))");
            return format;
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "formatTimeForMsgBox err.", th5);
            return "";
        }
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getAppReportVersionName() {
        return "8.8.0.1888";
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public Application getApplication() {
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public Integer getAvatarGender() {
        return ICommonUtils.DefaultImpls.getAvatarGender(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getCpuCoreNum() {
        return 8;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getCpuMaxFreq() {
        return 3000;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getCurrentAccountUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime()");
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "MobileQQ.sMobileQQ.peekA\u2026ntime().currentAccountUin");
        return currentAccountUin;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public QPublicBaseFragment getDebugFragment(@NotNull DebugPageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getDeviceName() {
        return "mock device name";
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getForbidLocalRecord, reason: from getter */
    public boolean getForbiddenLocalRecord() {
        return this.forbiddenLocalRecord;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getFriendRemarkName(@NotNull String uin, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return defaultValue;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getGpuInfo() {
        return "mock gpu info";
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public MsgBoxConfig getMsgBoxConfig() {
        return new MsgBoxConfig();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getNeedReportPlaySuccess() {
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getNeedShieldTeenager() {
        return this.needShieldTeenager;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public ISquarePagView getPagImageView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public ISquarePagView getPagView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public PerformanceConfig getPerformanceConfig() {
        return ICommonUtils.DefaultImpls.getPerformanceConfig(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getQZoneFeedsBubbleText() {
        return ICommonUtils.DefaultImpls.getQZoneFeedsBubbleText(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public String getQZoneHomePageUrl() {
        return ICommonUtils.DefaultImpls.getQZoneHomePageUrl(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getQZonePrivacyDialogShowLimitDay() {
        return ICommonUtils.DefaultImpls.getQZonePrivacyDialogShowLimitDay(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public int getRAMSize() {
        return 8000;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getSelfTinyId() {
        return "";
    }

    @Override // com.tencent.state.square.ICommonUtils
    public long getServerTime() {
        return System.currentTimeMillis() / 1000;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getShaderUseMulti() {
        return ICommonUtils.DefaultImpls.getShaderUseMulti(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getSquareDebug() {
        return this.squareDebug;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public SquareDeviceInfo getSquareDeviceInfo() {
        return new SquareDeviceInfo();
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getSquareFilamentPlayCountIncludeMe, reason: from getter */
    public int getFilamentPlayCountIncludeMe() {
        return this.filamentPlayCountIncludeMe;
    }

    @Override // com.tencent.state.square.ICommonUtils
    /* renamed from: getSquarePlayCountIncludeMe, reason: from getter */
    public int getPlayCountIncludeMe() {
        return this.playCountIncludeMe;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean getStudyMode() {
        return ICommonUtils.DefaultImpls.getStudyMode(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public ISquareSummaryView getSummaryView(@NotNull final Context context, @NotNull final SquareSummaryViewConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return new ISquareSummaryView(context, config) { // from class: com.tencent.state.square.DefaultUtils$getSummaryView$1
            final /* synthetic */ SquareSummaryViewConfig $config;
            final /* synthetic */ Context $context;
            private TextView textView;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$context = context;
                this.$config = config;
                TextView textView = new TextView(context);
                textView.setTextColor(config.getNormalTextColor());
                textView.setTextSize(config.getTextSize());
                textView.setGravity(16);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                Unit unit = Unit.INSTANCE;
                this.textView = textView;
            }

            @Override // com.tencent.state.square.api.ISquareSummaryView
            @NotNull
            public String getSummaryMsgText() {
                String obj;
                CharSequence text = this.textView.getText();
                if (text == null || (obj = text.toString()) == null) {
                    return "";
                }
                return obj;
            }

            @Override // com.tencent.state.square.api.ISquareSummaryView
            @NotNull
            public View getView() {
                return this.textView;
            }

            @Override // com.tencent.state.square.api.ISquareSummaryView
            /* renamed from: isContainerEmoji */
            public boolean getHasEmoji() {
                return false;
            }

            @Override // com.tencent.state.square.api.ISquareSummaryView
            public void setSummaryData(@NotNull SummaryData summaryData, @Nullable SquareSummaryViewConfig config2) {
                Intrinsics.checkNotNullParameter(summaryData, "summaryData");
                this.textView.setText(summaryData.getMsgText());
                if (config2 != null) {
                    this.textView.setTextColor(config2.getNormalTextColor());
                    this.textView.setTextSize(config2.getTextSize());
                }
            }

            @Override // com.tencent.state.square.api.ISquareSummaryView
            public void setSummaryMsgText(@NotNull String text, boolean isContainEmoji) {
                Intrinsics.checkNotNullParameter(text, "text");
            }
        };
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getSystemVersion() {
        return "mock system version";
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public File getUrlDrawableFile(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public String getUserAppearanceKey() {
        return "";
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean hasSendFriendRequest(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isApngLoaded() {
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isBackgroundStop() {
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isCurrentAccount(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "MobileQQ.sMobileQQ.peekAppRuntime()");
        return Intrinsics.areEqual(peekAppRuntime.getCurrentAccountUin(), uin);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isDebugVersion() {
        return ICommonUtils.DefaultImpls.isDebugVersion(this);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isDrawableReady(@Nullable URLDrawable urlDrawable) {
        Integer num;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isDrawableReady status:");
        URL url = null;
        if (urlDrawable != null) {
            num = Integer.valueOf(urlDrawable.getStatus());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", url:");
        if (urlDrawable != null) {
            url = urlDrawable.getURL();
        }
        sb5.append(url);
        squareLog.d(TAG, sb5.toString());
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isLikeIconUseHug() {
        return true;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isSongPlaying(@Nullable String songMid) {
        return false;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public boolean isSwitchOn(@NotNull String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return defaultValue;
    }

    @Override // com.tencent.state.square.ICommonUtils
    @NotNull
    public byte[] loadRawConfig(@NotNull String group, @NotNull byte[] defaultValue) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return defaultValue;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void paiYiPaiFriend(@NotNull String friendUin, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "paiYiPaiFriend friendUin:" + friendUin);
        callback.invoke(Boolean.FALSE);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setForbidLocalRecord(boolean forbidden) {
        this.forbiddenLocalRecord = forbidden;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setImmersiveStatus(@NotNull Activity activity, int color) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().addFlags(67108864);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setNeedShieldTeenager(boolean needShieldTeenager) {
        this.needShieldTeenager = needShieldTeenager;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquareDebug(boolean isDebug) {
        this.squareDebug = isDebug;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquareFilamentPlayCountIncludeMe(int playCount) {
        this.filamentPlayCountIncludeMe = playCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setSquarePlayCountIncludeMe(int playCount) {
        this.playCountIncludeMe = playCount;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void setStandardFont(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void shouldShowSmallHomeEntry(@NotNull String friendUin, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(Boolean.TRUE);
    }

    @Override // com.tencent.state.square.ICommonUtils
    @Nullable
    public PopupWindow showCallOutPopupWindow(@NotNull View decor, @NotNull String text, @NotNull CalloutPopupWindowStyle style) {
        Intrinsics.checkNotNullParameter(decor, "decor");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        return null;
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showDialog(@NotNull Context context, @NotNull String msg2, @NotNull String midText, @Nullable String title, boolean isSelect, @NotNull final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(midText, "midText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new AlertDialog.Builder(context).setMessage(msg2).setNeutralButton(midText, new DialogInterface.OnClickListener() { // from class: com.tencent.state.square.DefaultUtils$showDialog$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                Function0.this.invoke();
                dialogInterface.dismiss();
            }
        }).setTitle(title).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToast(@NotNull Context context, @Nullable String message, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Toast.makeText(context, message, 0).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToastSafely(@Nullable Context context, @Nullable String str, int i3) {
        ICommonUtils.DefaultImpls.showToastSafely(this, context, str, i3);
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void startZPlanEngineWhenNotReady() {
        SquareBaseKt.getSquareLog().d(TAG, "startZPlanEngineWhenNotReady");
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void unSetStandardFont(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showToast(@NotNull Context context, int r26, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Toast.makeText(context, r26, 0).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void showDialog(@NotNull Context context, @NotNull String msg2, @NotNull String rightText, @NotNull String leftText, @Nullable String title, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new AlertDialog.Builder(context).setMessage(msg2).setPositiveButton(rightText, new DialogInterface.OnClickListener() { // from class: com.tencent.state.square.DefaultUtils$showDialog$2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                Function1.this.invoke(Boolean.TRUE);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(leftText, new DialogInterface.OnClickListener() { // from class: com.tencent.state.square.DefaultUtils$showDialog$3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                Function1.this.invoke(Boolean.FALSE);
                dialogInterface.dismiss();
            }
        }).setTitle(title).show();
    }

    @Override // com.tencent.state.square.ICommonUtils
    public void phoneVibrate(int from, long duration) {
    }
}
