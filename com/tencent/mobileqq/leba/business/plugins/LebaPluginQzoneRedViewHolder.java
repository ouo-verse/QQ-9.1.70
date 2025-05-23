package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.dz;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.RoundImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.qzonehub.api.IQZonePadApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 m2\u00020\u0001:\u0002;>B\u000f\u0012\u0006\u0010j\u001a\u00020i\u00a2\u0006\u0004\bk\u0010lJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u0004J\b\u00107\u001a\u0004\u0018\u000106J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0018\u0010E\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010<R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0018\u0010Q\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010<R\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010LR\u0016\u0010Y\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u00107R\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder;", "", "Lcom/tencent/mobileqq/servlet/QZoneManagerImp;", "qim", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder$b;", "drawParams", "", "v", "w", "", "actionType", "subActionType", "reserves", "V", ReportConstant.COSTREPORT_PREFIX, "y", "u", "t", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "H", "G", UserInfo.SEX_FEMALE, "E", "params", "P", "L", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "countInfo", "O", "U", "M", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "redPointCountId", "N", "B", "Lmqq/app/AppRuntime;", "D", "Landroid/view/View;", "entryHeader", BdhLogUtil.LogTag.Tag_Req, "r", "K", "Z", "Y", "W", "X", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a0", "", "I", "J", "b0", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "mQzoneRedDot", "b", "mQzonePassiveRedDot", "c", "mQzoneVisit", "d", "mQzoneRedDotText", "e", "mQzoneRecommTextRedDot", "Landroid/widget/ImageSwitcher;", "f", "Landroid/widget/ImageSwitcher;", "mQzoneFeedSubIcon", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "mQzonefeedIconShadow", tl.h.F, "mQzoneFeedSubIcontwo", "i", "mQzoneBubbleRedDotText", "Lcom/tencent/mobileqq/utils/RoundImageView;", "j", "Lcom/tencent/mobileqq/utils/RoundImageView;", "mQzoneBubbleRedDotIcon", "k", "mQzoneBubbleRedDot", "l", "showRedDotType", "Lcom/tencent/mobileqq/activity/dz;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/dz;", "lebaQZoneFacePlayHelper", DomainData.DOMAIN_NAME, "Landroid/view/View;", "root", "Lcom/tencent/mobileqq/avatar/observer/a;", "o", "Lcom/tencent/mobileqq/avatar/observer/a;", "getAvatarObserver", "()Lcom/tencent/mobileqq/avatar/observer/a;", "setAvatarObserver", "(Lcom/tencent/mobileqq/avatar/observer/a;)V", "avatarObserver", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "<init>", "(Landroid/view/ViewGroup;)V", "p", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginQzoneRedViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzoneRedDot;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzonePassiveRedDot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzoneVisit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzoneRedDotText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzoneRecommTextRedDot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageSwitcher mQzoneFeedSubIcon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mQzonefeedIconShadow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageSwitcher mQzoneFeedSubIcontwo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mQzoneBubbleRedDotText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundImageView mQzoneBubbleRedDotIcon;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mQzoneBubbleRedDot;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int showRedDotType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dz lebaQZoneFacePlayHelper;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.avatar.observer.a avatarObserver;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder$a;", "", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "visitorCountInfo", "", "b", "recommCountInfo", "a", "", "PUBLISH_PLUS_ICON_TIAN_SHU_ENTRY", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a(@Nullable QZoneCountInfo recommCountInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) recommCountInfo)).booleanValue();
            }
            if (recommCountInfo == null || TextUtils.isEmpty(recommCountInfo.strShowMsg) || recommCountInfo.uCount <= 0) {
                return false;
            }
            return true;
        }

        public final boolean b(@Nullable QZoneCountInfo visitorCountInfo) {
            ArrayList<QZoneCountUserInfo> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) visitorCountInfo)).booleanValue();
            }
            if (visitorCountInfo == null || (arrayList = visitorCountInfo.friendList) == null || arrayList.size() <= 0 || visitorCountInfo.uCount <= 0) {
                return false;
            }
            return true;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder$b;", "", "", "b", "", "a", "I", "f", "()I", "k", "(I)V", "style", "c", tl.h.F, WidgetCacheConstellationData.NUM, "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "g", "(Ljava/util/ArrayList;)V", "feedOwners", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "qzoneRedDotText", "", "e", "Z", "()Z", "j", "(Z)V", "showRecomTextRedDot", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int style;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int num;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<String> feedOwners;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String qzoneRedDotText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean showRecomTextRedDot;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final ArrayList<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.feedOwners;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "style: " + this.style + ", num: " + this.num + ", feedOwners: " + this.feedOwners + ", qzoneRedDotText: " + this.qzoneRedDotText + ", showRecomTextRedDot: " + this.showRecomTextRedDot;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.num;
        }

        @Nullable
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.qzoneRedDotText;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.showRecomTextRedDot;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.style;
        }

        public final void g(@Nullable ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            } else {
                this.feedOwners = arrayList;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.num = i3;
            }
        }

        public final void i(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.qzoneRedDotText = str;
            }
        }

        public final void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.showRecomTextRedDot = z16;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.style = i3;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginQzoneRedViewHolder$c", "Lcom/tencent/mobileqq/avatar/observer/a;", "", "isSuccess", "", "uin", "", "onUpdateCustomHead", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean isSuccess, @NotNull String uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (isSuccess && !TextUtils.isEmpty(uin)) {
                LebaPluginQzoneRedViewHolder.this.b0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "state", "Lcom/tencent/libra/LoadState;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/libra/request/Option;", "onStateChange"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class d implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public final void onStateChange(LoadState loadState, Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadState, (Object) option);
                return;
            }
            if (loadState.isFinishError()) {
                RoundImageView roundImageView = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
                if (roundImageView != null) {
                    roundImageView.setVisibility(8);
                    return;
                }
                return;
            }
            RoundImageView roundImageView2 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
            if (roundImageView2 != null) {
                roundImageView2.setVisibility(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58862);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginQzoneRedViewHolder(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
            return;
        }
        this.showRedDotType = -1;
        this.avatarObserver = new c();
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.gxp, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026layout, container, false)");
        this.root = inflate;
        R(inflate);
    }

    private final void A(QZoneManagerImp qim) {
        int i3 = this.showRedDotType;
        if (i3 == 2 || i3 == 74) {
            ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).saveRedCountInfo(74, qim.k(74));
            if (!((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.peekAppRuntime()) || QzoneFrame.isShowOldQZoneFrame()) {
                qim.h(74);
            }
        }
    }

    private final void B(final QZoneCountInfo countInfo, final b params) {
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            TextView textView = this.mQzoneRedDot;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
            TextView textView2 = this.mQzoneVisit;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(8);
            TextView textView3 = this.mQzoneRedDotText;
            Intrinsics.checkNotNull(textView3);
            textView3.setVisibility(8);
            TextView textView4 = this.mQzoneRecommTextRedDot;
            Intrinsics.checkNotNull(textView4);
            textView4.setVisibility(8);
            ImageSwitcher imageSwitcher = this.mQzoneFeedSubIcon;
            Intrinsics.checkNotNull(imageSwitcher);
            imageSwitcher.setVisibility(8);
            ImageView imageView = this.mQzonefeedIconShadow;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
            ImageSwitcher imageSwitcher2 = this.mQzoneFeedSubIcontwo;
            Intrinsics.checkNotNull(imageSwitcher2);
            imageSwitcher2.setVisibility(8);
            RoundImageView roundImageView = this.mQzoneBubbleRedDotIcon;
            if (roundImageView != null) {
                roundImageView.setBorderWidth(0);
            }
            RoundImageView roundImageView2 = this.mQzoneBubbleRedDotIcon;
            if (roundImageView2 != null) {
                roundImageView2.setBorderColor(-1);
            }
            if (((IQZonePadApi) QRoute.api(IQZonePadApi.class)).shouldAdapt(MobileQQ.sMobileQQ.getApplicationContext()) || TextUtils.isEmpty(params.d())) {
                TextView textView5 = this.mQzoneBubbleRedDotText;
                Intrinsics.checkNotNull(textView5);
                textView5.setVisibility(8);
            } else {
                TextView textView6 = this.mQzoneBubbleRedDotText;
                Intrinsics.checkNotNull(textView6);
                textView6.setText(params.d());
                TextView textView7 = this.mQzoneBubbleRedDotText;
                Intrinsics.checkNotNull(textView7);
                textView7.setVisibility(0);
            }
            if (TextUtils.isEmpty(countInfo.iconUrl)) {
                RoundImageView roundImageView3 = this.mQzoneBubbleRedDotIcon;
                Intrinsics.checkNotNull(roundImageView3);
                roundImageView3.setVisibility(8);
            } else {
                Option option = Option.obtain().setUrl(countInfo.iconUrl).setTargetView(this.mQzoneBubbleRedDotIcon).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setRequestWidth(ImmersiveUtils.dpToPx(32.0f)).setRequestHeight(ImmersiveUtils.dpToPx(32.0f));
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                qQPicLoader.e(option, new d());
            }
            ImageView imageView2 = this.mQzoneBubbleRedDot;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(0);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(params, countInfo) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$drawBubbleStyleRedDot$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LebaPluginQzoneRedViewHolder.b f240154d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QZoneCountInfo f240155e;

            {
                this.f240154d = params;
                this.f240155e = countInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, LebaPluginQzoneRedViewHolder.this, params, countInfo);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TextView textView8 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDot;
                    Intrinsics.checkNotNull(textView8);
                    textView8.setVisibility(8);
                    TextView textView9 = LebaPluginQzoneRedViewHolder.this.mQzoneVisit;
                    Intrinsics.checkNotNull(textView9);
                    textView9.setVisibility(8);
                    TextView textView10 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                    Intrinsics.checkNotNull(textView10);
                    textView10.setVisibility(8);
                    TextView textView11 = LebaPluginQzoneRedViewHolder.this.mQzoneRecommTextRedDot;
                    Intrinsics.checkNotNull(textView11);
                    textView11.setVisibility(8);
                    ImageSwitcher imageSwitcher3 = LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcon;
                    Intrinsics.checkNotNull(imageSwitcher3);
                    imageSwitcher3.setVisibility(8);
                    ImageView imageView3 = LebaPluginQzoneRedViewHolder.this.mQzonefeedIconShadow;
                    Intrinsics.checkNotNull(imageView3);
                    imageView3.setVisibility(8);
                    ImageSwitcher imageSwitcher4 = LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcontwo;
                    Intrinsics.checkNotNull(imageSwitcher4);
                    imageSwitcher4.setVisibility(8);
                    RoundImageView roundImageView4 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
                    if (roundImageView4 != null) {
                        roundImageView4.setBorderWidth(0);
                    }
                    RoundImageView roundImageView5 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
                    if (roundImageView5 != null) {
                        roundImageView5.setBorderColor(-1);
                    }
                    if (((IQZonePadApi) QRoute.api(IQZonePadApi.class)).shouldAdapt(MobileQQ.sMobileQQ.getApplicationContext()) || TextUtils.isEmpty(this.f240154d.d())) {
                        TextView textView12 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotText;
                        Intrinsics.checkNotNull(textView12);
                        textView12.setVisibility(8);
                    } else {
                        TextView textView13 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotText;
                        Intrinsics.checkNotNull(textView13);
                        textView13.setText(this.f240154d.d());
                        TextView textView14 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotText;
                        Intrinsics.checkNotNull(textView14);
                        textView14.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(this.f240155e.iconUrl)) {
                        RoundImageView roundImageView6 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
                        Intrinsics.checkNotNull(roundImageView6);
                        roundImageView6.setVisibility(8);
                    } else {
                        Option option2 = Option.obtain().setUrl(this.f240155e.iconUrl).setTargetView(LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setRequestWidth(ImmersiveUtils.dpToPx(32.0f)).setRequestHeight(ImmersiveUtils.dpToPx(32.0f));
                        QQPicLoader qQPicLoader2 = QQPicLoader.f201806a;
                        Intrinsics.checkNotNullExpressionValue(option2, "option");
                        qQPicLoader2.e(option2, new LebaPluginQzoneRedViewHolder.d());
                    }
                    ImageView imageView4 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDot;
                    Intrinsics.checkNotNull(imageView4);
                    imageView4.setVisibility(0);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private final void C(final b drawParams, Context context) {
        int i3;
        if (drawParams.f() == 12) {
            return;
        }
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            try {
                TextView textView = this.mQzoneBubbleRedDotText;
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(8);
                RoundImageView roundImageView = this.mQzoneBubbleRedDotIcon;
                Intrinsics.checkNotNull(roundImageView);
                roundImageView.setVisibility(8);
                ImageView imageView = this.mQzoneBubbleRedDot;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(8);
                if (drawParams.f() != -1) {
                    if (this.mQzoneRedDot != null) {
                        TextView textView2 = this.mQzoneRedDot;
                        Intrinsics.checkNotNull(textView2);
                        textView2.setVisibility(0);
                    }
                    com.tencent.widget.d.b(this.mQzoneRedDot, drawParams.f(), drawParams.c(), 0);
                    com.tencent.widget.d.e(MobileQQ.sMobileQQ.getApplicationContext(), this.mQzoneRedDot, drawParams.f(), false);
                    if (this.mQzoneVisit != null) {
                        TextView textView3 = this.mQzoneVisit;
                        Intrinsics.checkNotNull(textView3);
                        textView3.setVisibility(8);
                    }
                } else if (this.mQzoneRedDot != null) {
                    TextView textView4 = this.mQzoneRedDot;
                    Intrinsics.checkNotNull(textView4);
                    textView4.setVisibility(8);
                }
                if (!TextUtils.isEmpty(drawParams.d())) {
                    TextView textView5 = this.mQzoneRedDotText;
                    Intrinsics.checkNotNull(textView5);
                    textView5.setText(drawParams.d());
                    TextView textView6 = this.mQzoneRedDotText;
                    Intrinsics.checkNotNull(textView6);
                    ViewGroup.LayoutParams layoutParams = textView6.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (this.lebaQZoneFacePlayHelper != null) {
                        dz dzVar = this.lebaQZoneFacePlayHelper;
                        Intrinsics.checkNotNull(dzVar);
                        i3 = dzVar.l();
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 1) {
                        marginLayoutParams.rightMargin = ViewUtils.dpToPx(68.0f);
                    } else if (i3 == 1) {
                        marginLayoutParams.rightMargin = ViewUtils.dpToPx(40.0f);
                    } else {
                        marginLayoutParams.rightMargin = ViewUtils.dpToPx(17.0f);
                    }
                    TextView textView7 = this.mQzoneRedDotText;
                    Intrinsics.checkNotNull(textView7);
                    textView7.setVisibility(0);
                    if (FontSettingManager.getFontLevel() > 17.0f) {
                        TextView textView8 = this.mQzoneRedDotText;
                        Intrinsics.checkNotNull(textView8);
                        textView8.setVisibility(8);
                    }
                } else {
                    TextView textView9 = this.mQzoneRedDotText;
                    Intrinsics.checkNotNull(textView9);
                    textView9.setVisibility(8);
                }
                if (!drawParams.e()) {
                    TextView textView10 = this.mQzoneRecommTextRedDot;
                    Intrinsics.checkNotNull(textView10);
                    textView10.setVisibility(8);
                    return;
                } else {
                    com.tencent.widget.d.b(this.mQzoneRecommTextRedDot, 8, drawParams.c(), 0);
                    TextView textView11 = this.mQzoneRecommTextRedDot;
                    Intrinsics.checkNotNull(textView11);
                    textView11.setVisibility(0);
                    return;
                }
            } catch (Exception e16) {
                QLog.e(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "updateQZoneRedFlag" + e16);
                return;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawParams) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$finalDrawRedDot$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LebaPluginQzoneRedViewHolder.b f240156d;

            {
                this.f240156d = drawParams;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this, (Object) drawParams);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        TextView textView12 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotText;
                        Intrinsics.checkNotNull(textView12);
                        textView12.setVisibility(8);
                        RoundImageView roundImageView2 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDotIcon;
                        Intrinsics.checkNotNull(roundImageView2);
                        roundImageView2.setVisibility(8);
                        ImageView imageView2 = LebaPluginQzoneRedViewHolder.this.mQzoneBubbleRedDot;
                        Intrinsics.checkNotNull(imageView2);
                        imageView2.setVisibility(8);
                        if (this.f240156d.f() != -1) {
                            if (LebaPluginQzoneRedViewHolder.this.mQzoneRedDot != null) {
                                TextView textView13 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDot;
                                Intrinsics.checkNotNull(textView13);
                                textView13.setVisibility(0);
                            }
                            com.tencent.widget.d.b(LebaPluginQzoneRedViewHolder.this.mQzoneRedDot, this.f240156d.f(), this.f240156d.c(), 0);
                            com.tencent.widget.d.e(MobileQQ.sMobileQQ.getApplicationContext(), LebaPluginQzoneRedViewHolder.this.mQzoneRedDot, this.f240156d.f(), false);
                            if (LebaPluginQzoneRedViewHolder.this.mQzoneVisit != null) {
                                TextView textView14 = LebaPluginQzoneRedViewHolder.this.mQzoneVisit;
                                Intrinsics.checkNotNull(textView14);
                                textView14.setVisibility(8);
                            }
                        } else if (LebaPluginQzoneRedViewHolder.this.mQzoneRedDot != null) {
                            TextView textView15 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDot;
                            Intrinsics.checkNotNull(textView15);
                            textView15.setVisibility(8);
                        }
                        if (!TextUtils.isEmpty(this.f240156d.d())) {
                            TextView textView16 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                            Intrinsics.checkNotNull(textView16);
                            textView16.setText(this.f240156d.d());
                            TextView textView17 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                            Intrinsics.checkNotNull(textView17);
                            ViewGroup.LayoutParams layoutParams2 = textView17.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                            if (LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                                dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                                Intrinsics.checkNotNull(dzVar2);
                                i16 = dzVar2.l();
                            } else {
                                i16 = 0;
                            }
                            if (i16 > 1) {
                                marginLayoutParams2.rightMargin = ViewUtils.dpToPx(68.0f);
                            } else if (i16 == 1) {
                                marginLayoutParams2.rightMargin = ViewUtils.dpToPx(40.0f);
                            } else {
                                marginLayoutParams2.rightMargin = ViewUtils.dpToPx(17.0f);
                            }
                            TextView textView18 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                            Intrinsics.checkNotNull(textView18);
                            textView18.setVisibility(0);
                            if (FontSettingManager.getFontLevel() > 17.0f) {
                                TextView textView19 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                                Intrinsics.checkNotNull(textView19);
                                textView19.setVisibility(8);
                            }
                        } else {
                            TextView textView20 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDotText;
                            Intrinsics.checkNotNull(textView20);
                            textView20.setVisibility(8);
                        }
                        if (!this.f240156d.e()) {
                            TextView textView21 = LebaPluginQzoneRedViewHolder.this.mQzoneRecommTextRedDot;
                            Intrinsics.checkNotNull(textView21);
                            textView21.setVisibility(8);
                            return;
                        } else {
                            com.tencent.widget.d.b(LebaPluginQzoneRedViewHolder.this.mQzoneRecommTextRedDot, 8, this.f240156d.c(), 0);
                            TextView textView22 = LebaPluginQzoneRedViewHolder.this.mQzoneRecommTextRedDot;
                            Intrinsics.checkNotNull(textView22);
                            textView22.setVisibility(0);
                            return;
                        }
                    } catch (Exception e17) {
                        QLog.e(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "updateQZoneRedFlag" + e17);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private final AppRuntime D() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    private final int E() {
        int F = F();
        int G = G();
        int H = H();
        QLog.d("LebaPluginQzoneRedViewHolder", 1, "getPassiveInfoTotalCount qzone cnt:", Integer.valueOf(H), ",moment cnt:", Integer.valueOf(G), ",intimate cnt:", Integer.valueOf(F));
        return H + G + F;
    }

    private final int F() {
        QZoneManagerImp qZoneManagerImp;
        Manager manager = D().getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp == null) {
            QLog.e("LebaPluginQzoneRedViewHolder", 1, "manager impl is null");
            return 0;
        }
        return qZoneManagerImp.j(73);
    }

    private final int G() {
        QZoneManagerImp qZoneManagerImp;
        Manager manager = D().getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp == null) {
            QLog.e("LebaPluginQzoneRedViewHolder", 1, "manager impl is null");
            return 0;
        }
        return qZoneManagerImp.j(66);
    }

    private final int H() {
        QZoneManagerImp qZoneManagerImp;
        Manager manager = D().getManager(QQManagerFactory.QZONE_MANAGER);
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp == null) {
            QLog.e("LebaPluginQzoneRedViewHolder", 1, "manager impl is null");
            return 0;
        }
        return qZoneManagerImp.j(1);
    }

    private final void L(final b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.LebaPluginQzoneRedViewHolder", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
        }
        drawParams.k(8);
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            if (this.mQzoneFeedSubIcon != null && this.lebaQZoneFacePlayHelper != null) {
                dz dzVar = this.lebaQZoneFacePlayHelper;
                Intrinsics.checkNotNull(dzVar);
                dzVar.z(drawParams.a());
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawParams) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initActiveCountIdUI$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LebaPluginQzoneRedViewHolder.b f240157d;

                {
                    this.f240157d = drawParams;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this, (Object) drawParams);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcon != null && LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                        dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                        Intrinsics.checkNotNull(dzVar2);
                        dzVar2.z(this.f240157d.a());
                    }
                }
            });
        }
        if (qim != null) {
            qZoneCountInfo = qim.k(2);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            drawParams.i(qZoneCountInfo.strShowMsg);
        }
        this.showRedDotType = 2;
    }

    private final void M(QZoneCountInfo countInfo, b drawParams) {
        final String str = countInfo.strShowMsg;
        long j3 = countInfo.friendList.get(0).uin;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        final String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(str)) {
            drawParams.k(-1);
            if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                try {
                    if (this.mQzoneVisit != null) {
                        TextView textView = this.mQzoneVisit;
                        Intrinsics.checkNotNull(textView);
                        textView.setVisibility(0);
                        TextView textView2 = this.mQzoneVisit;
                        Intrinsics.checkNotNull(textView2);
                        textView2.setText(str);
                    }
                    if (this.mQzoneRedDot != null) {
                        TextView textView3 = this.mQzoneRedDot;
                        Intrinsics.checkNotNull(textView3);
                        textView3.setVisibility(8);
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(sb6);
                    if (this.mQzoneFeedSubIcon != null && this.lebaQZoneFacePlayHelper != null) {
                        dz dzVar = this.lebaQZoneFacePlayHelper;
                        Intrinsics.checkNotNull(dzVar);
                        dzVar.z(arrayList);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "updateQZoneRedFlag" + e16);
                    return;
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str, sb6) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initBirthDayCountIdUI$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f240158d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f240159e;

                {
                    this.f240158d = str;
                    this.f240159e = sb6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, LebaPluginQzoneRedViewHolder.this, str, sb6);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (LebaPluginQzoneRedViewHolder.this.mQzoneVisit != null) {
                            TextView textView4 = LebaPluginQzoneRedViewHolder.this.mQzoneVisit;
                            Intrinsics.checkNotNull(textView4);
                            textView4.setVisibility(0);
                            TextView textView5 = LebaPluginQzoneRedViewHolder.this.mQzoneVisit;
                            Intrinsics.checkNotNull(textView5);
                            textView5.setText(this.f240158d);
                        }
                        if (LebaPluginQzoneRedViewHolder.this.mQzoneRedDot != null) {
                            TextView textView6 = LebaPluginQzoneRedViewHolder.this.mQzoneRedDot;
                            Intrinsics.checkNotNull(textView6);
                            textView6.setVisibility(8);
                        }
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add(this.f240159e);
                        if (LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcon != null && LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                            dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                            Intrinsics.checkNotNull(dzVar2);
                            dzVar2.z(arrayList2);
                        }
                    } catch (Exception e17) {
                        QLog.e(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "updateQZoneRedFlag" + e17);
                    }
                }
            });
        }
    }

    private final void N(QZoneCountInfo countInfo, int redPointCountId, b drawParams) {
        drawParams.i(countInfo.strShowMsg);
        this.showRedDotType = redPointCountId;
        if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null) {
            QZoneUnreadServletLogic.d0(BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), countInfo.actPageAttach);
            String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(redPointCountId);
            QZoneUnreadServletLogic.i0(currentUin, sb5.toString());
            byte[] bArr = countInfo.tianshuTrans;
            if (bArr != null && bArr.length > 0 && redPointCountId == 1017) {
                QZoneUnreadServletLogic.f0(BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), countInfo.tianshuTrans);
            }
        }
        drawParams.k(12);
        B(countInfo, drawParams);
    }

    private final void O(QZoneCountInfo countInfo, final b drawParams) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("LebaPluginQzoneRedViewHolder", 1, "begin init moment red dot");
        }
        drawParams.k(8);
        ArrayList<QZoneCountUserInfo> arrayList = countInfo.friendList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) != null) {
                    QZoneCountUserInfo qZoneCountUserInfo = arrayList.get(i3);
                    Intrinsics.checkNotNull(qZoneCountUserInfo);
                    try {
                        str = String.valueOf(qZoneCountUserInfo.uin);
                    } catch (Exception e16) {
                        QLog.e("LebaPluginQzoneRedViewHolder", 1, e16, new Object[0]);
                        str = "";
                    }
                    arrayList2.add(str);
                }
            }
            drawParams.g(arrayList2);
            if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                if (this.mQzoneFeedSubIcon != null && this.lebaQZoneFacePlayHelper != null) {
                    dz dzVar = this.lebaQZoneFacePlayHelper;
                    Intrinsics.checkNotNull(dzVar);
                    dzVar.z(drawParams.a());
                }
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawParams) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initExtraActiveCountIdUi$$inlined$runOnMainThread$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ LebaPluginQzoneRedViewHolder.b f240160d;

                    {
                        this.f240160d = drawParams;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this, (Object) drawParams);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcon != null && LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                            dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                            Intrinsics.checkNotNull(dzVar2);
                            dzVar2.z(this.f240160d.a());
                        }
                    }
                });
            }
        } else {
            drawParams.g(null);
        }
        drawParams.i(countInfo.strShowMsg);
        QLog.d("LebaPluginQzoneRedViewHolder", 1, "active red dot msg is " + countInfo.strShowMsg + " time is " + countInfo.cTime);
    }

    private final void P(final b params) {
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            if (params.c() > 0) {
                TextView textView = this.mQzonePassiveRedDot;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                com.tencent.widget.d.b(this.mQzonePassiveRedDot, 9, params.c(), 0);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.c(this.root, HardCodeUtil.qqStr(R.string.nlm), Button.class.getName());
                    return;
                }
                return;
            }
            TextView textView2 = this.mQzonePassiveRedDot;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (AppSetting.f99565y) {
                AccessibilityUtil.c(this.root, HardCodeUtil.qqStr(R.string.hvk), Button.class.getName());
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(this) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initPassiveCountIdUI$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LebaPluginQzoneRedViewHolder this$0;

            {
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.b.this, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (LebaPluginQzoneRedViewHolder.b.this.c() > 0) {
                    TextView textView3 = this.this$0.mQzonePassiveRedDot;
                    if (textView3 != null) {
                        textView3.setVisibility(0);
                    }
                    com.tencent.widget.d.b(this.this$0.mQzonePassiveRedDot, 9, LebaPluginQzoneRedViewHolder.b.this.c(), 0);
                    if (AppSetting.f99565y) {
                        AccessibilityUtil.c(this.this$0.root, HardCodeUtil.qqStr(R.string.nlm), Button.class.getName());
                        return;
                    }
                    return;
                }
                TextView textView4 = this.this$0.mQzonePassiveRedDot;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                if (AppSetting.f99565y) {
                    AccessibilityUtil.c(this.this$0.root, HardCodeUtil.qqStr(R.string.hvk), Button.class.getName());
                }
            }
        });
    }

    private final void Q(QZoneCountInfo countInfo, b drawParams) {
        drawParams.i(countInfo.strShowMsg);
        this.showRedDotType = 1028;
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBytes("publish_plus_icon_tian_shu_entry", countInfo.tianshuTrans);
        drawParams.k(12);
        B(countInfo, drawParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View S(QBaseActivity qBaseActivity) {
        ImageView imageView = new ImageView(qBaseActivity);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View T(QBaseActivity qBaseActivity) {
        ImageView imageView = new ImageView(qBaseActivity);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private final void U(QZoneCountInfo countInfo, b drawParams) {
        final ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<QZoneCountUserInfo> arrayList2 = countInfo.friendList;
        if (arrayList2 != null) {
            Iterator<QZoneCountUserInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                QZoneCountUserInfo next = it.next();
                if (next != null) {
                    long j3 = next.uin;
                    if (j3 >= 10000) {
                        arrayList.add(String.valueOf(j3));
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            drawParams.k(8);
            if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                if (this.mQzoneFeedSubIcon != null && this.lebaQZoneFacePlayHelper != null) {
                    dz dzVar = this.lebaQZoneFacePlayHelper;
                    Intrinsics.checkNotNull(dzVar);
                    dzVar.z(arrayList);
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initVisitorOrRecommendCountIdUI$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f240162d;

                {
                    this.f240162d = arrayList;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this, (Object) arrayList);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (LebaPluginQzoneRedViewHolder.this.mQzoneFeedSubIcon != null && LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                        dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                        Intrinsics.checkNotNull(dzVar2);
                        dzVar2.z(this.f240162d);
                    }
                }
            });
            return;
        }
        drawParams.k(0);
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            if (this.lebaQZoneFacePlayHelper != null) {
                dz dzVar2 = this.lebaQZoneFacePlayHelper;
                Intrinsics.checkNotNull(dzVar2);
                dzVar2.m();
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$initVisitorOrRecommendCountIdUI$$inlined$runOnMainThread$2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                    dz dzVar3 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                    Intrinsics.checkNotNull(dzVar3);
                    dzVar3.m();
                }
            }
        });
    }

    private final void V(int actionType, int subActionType, int reserves) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = actionType;
        lpReportInfo_pf00064.subactionType = subActionType;
        lpReportInfo_pf00064.reserves = reserves;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(33:1|(1:3)(1:88)|4|(1:6)(1:87)|7|(1:9)|10|(1:12)|13|(1:15)(1:86)|(2:19|(3:21|22|23))|25|26|27|(1:29)|30|(16:35|(14:40|(12:45|(10:50|(8:55|(6:60|(4:65|(4:67|(2:69|(1:71))(1:76)|72|(1:74))|22|23)|77|(0)|22|23)|78|(5:62|65|(0)|22|23)|77|(0)|22|23)|79|(7:57|60|(0)|77|(0)|22|23)|78|(0)|77|(0)|22|23)|80|(9:52|55|(0)|78|(0)|77|(0)|22|23)|79|(0)|78|(0)|77|(0)|22|23)|81|(11:47|50|(0)|79|(0)|78|(0)|77|(0)|22|23)|80|(0)|79|(0)|78|(0)|77|(0)|22|23)|82|(13:42|45|(0)|80|(0)|79|(0)|78|(0)|77|(0)|22|23)|81|(0)|80|(0)|79|(0)|78|(0)|77|(0)|22|23)|83|(15:37|40|(0)|81|(0)|80|(0)|79|(0)|78|(0)|77|(0)|22|23)|82|(0)|81|(0)|80|(0)|79|(0)|78|(0)|77|(0)|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0125, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0126, code lost:
    
        com.tencent.qphone.base.util.QLog.e(cooperation.qzone.QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 1, "updateQZoneRedFlag" + r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d5 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e1 A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ed A[Catch: Exception -> 0x0125, TryCatch #0 {Exception -> 0x0125, blocks: (B:27:0x0078, B:29:0x007e, B:30:0x0093, B:32:0x0099, B:37:0x00a5, B:42:0x00b1, B:47:0x00bd, B:52:0x00c9, B:57:0x00d5, B:62:0x00e1, B:67:0x00ed, B:69:0x00f8, B:71:0x00fe, B:72:0x0115, B:74:0x011b, B:76:0x0109), top: B:26:0x0078 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c0(QQAppInterface qQAppInterface, final LebaPluginQzoneRedViewHolder this$0) {
        QZoneManagerImp qZoneManagerImp;
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = new b();
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        ArrayList<String> arrayList = null;
        if (manager instanceof QZoneManagerImp) {
            qZoneManagerImp = (QZoneManagerImp) manager;
        } else {
            qZoneManagerImp = null;
        }
        if (qZoneManagerImp != null) {
            i3 = this$0.E();
        } else {
            i3 = 0;
        }
        bVar.h(i3);
        if (qZoneManagerImp != null) {
            arrayList = qZoneManagerImp.l();
        }
        bVar.g(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.LebaPluginQzoneRedViewHolder", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + bVar.c());
        }
        this$0.P(bVar);
        if (qZoneManagerImp != null) {
            i16 = qZoneManagerImp.j(2);
        } else {
            i16 = 0;
        }
        if (i16 > 0 && bVar.a() != null) {
            ArrayList<String> a16 = bVar.a();
            Intrinsics.checkNotNull(a16);
            if (a16.size() > 0) {
                this$0.L(bVar, qZoneManagerImp);
                QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
                this$0.C(bVar, applicationContext);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.LebaPluginQzoneRedViewHolder", 2, "updateQZoneFlag.noflag count=" + i16);
        }
        if (!this$0.v(bVar, qZoneManagerImp) && !this$0.w(bVar, qZoneManagerImp)) {
            z16 = false;
            if (!z16 && !this$0.z(bVar, qZoneManagerImp)) {
                z17 = false;
                if (!z17 && !this$0.t(bVar, qZoneManagerImp)) {
                    z18 = false;
                    if (!z18 && !this$0.x(bVar, qZoneManagerImp)) {
                        z19 = false;
                        if (!z19 && !this$0.u(bVar, qZoneManagerImp)) {
                            z26 = false;
                            if (!z26 && !this$0.y(bVar, qZoneManagerImp)) {
                                z27 = false;
                                if (!z27 && !this$0.s(bVar, qZoneManagerImp)) {
                                    z28 = false;
                                    if (!z28) {
                                        bVar.k(0);
                                        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                                            if (this$0.lebaQZoneFacePlayHelper != null) {
                                                dz dzVar = this$0.lebaQZoneFacePlayHelper;
                                                Intrinsics.checkNotNull(dzVar);
                                                dzVar.m();
                                            }
                                        } else {
                                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQzoneRedViewHolder$updateRedFlag$lambda$4$$inlined$runOnMainThread$1
                                                static IPatchRedirector $redirector_;

                                                {
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginQzoneRedViewHolder.this);
                                                    }
                                                }

                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    IPatchRedirector iPatchRedirector = $redirector_;
                                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                        iPatchRedirector.redirect((short) 2, (Object) this);
                                                    } else if (LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper != null) {
                                                        dz dzVar2 = LebaPluginQzoneRedViewHolder.this.lebaQZoneFacePlayHelper;
                                                        Intrinsics.checkNotNull(dzVar2);
                                                        dzVar2.m();
                                                    }
                                                }
                                            });
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("UndealCount.ZebraAlbum.LebaPluginQzoneRedViewHolder", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
                                        }
                                    }
                                    QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                                    Context applicationContext2 = MobileQQ.sMobileQQ.getApplicationContext();
                                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "sMobileQQ.applicationContext");
                                    this$0.C(bVar, applicationContext2);
                                }
                                z28 = true;
                                if (!z28) {
                                }
                                QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                                Context applicationContext22 = MobileQQ.sMobileQQ.getApplicationContext();
                                Intrinsics.checkNotNullExpressionValue(applicationContext22, "sMobileQQ.applicationContext");
                                this$0.C(bVar, applicationContext22);
                            }
                            z27 = true;
                            if (!z27) {
                                z28 = false;
                                if (!z28) {
                                }
                                QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                                Context applicationContext222 = MobileQQ.sMobileQQ.getApplicationContext();
                                Intrinsics.checkNotNullExpressionValue(applicationContext222, "sMobileQQ.applicationContext");
                                this$0.C(bVar, applicationContext222);
                            }
                            z28 = true;
                            if (!z28) {
                            }
                            QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                            Context applicationContext2222 = MobileQQ.sMobileQQ.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext2222, "sMobileQQ.applicationContext");
                            this$0.C(bVar, applicationContext2222);
                        }
                        z26 = true;
                        if (!z26) {
                            z27 = false;
                            if (!z27) {
                            }
                            z28 = true;
                            if (!z28) {
                            }
                            QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                            Context applicationContext22222 = MobileQQ.sMobileQQ.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext22222, "sMobileQQ.applicationContext");
                            this$0.C(bVar, applicationContext22222);
                        }
                        z27 = true;
                        if (!z27) {
                        }
                        z28 = true;
                        if (!z28) {
                        }
                        QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                        Context applicationContext222222 = MobileQQ.sMobileQQ.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext222222, "sMobileQQ.applicationContext");
                        this$0.C(bVar, applicationContext222222);
                    }
                    z19 = true;
                    if (!z19) {
                        z26 = false;
                        if (!z26) {
                        }
                        z27 = true;
                        if (!z27) {
                        }
                        z28 = true;
                        if (!z28) {
                        }
                        QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                        Context applicationContext2222222 = MobileQQ.sMobileQQ.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2222222, "sMobileQQ.applicationContext");
                        this$0.C(bVar, applicationContext2222222);
                    }
                    z26 = true;
                    if (!z26) {
                    }
                    z27 = true;
                    if (!z27) {
                    }
                    z28 = true;
                    if (!z28) {
                    }
                    QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                    Context applicationContext22222222 = MobileQQ.sMobileQQ.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext22222222, "sMobileQQ.applicationContext");
                    this$0.C(bVar, applicationContext22222222);
                }
                z18 = true;
                if (!z18) {
                    z19 = false;
                    if (!z19) {
                    }
                    z26 = true;
                    if (!z26) {
                    }
                    z27 = true;
                    if (!z27) {
                    }
                    z28 = true;
                    if (!z28) {
                    }
                    QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                    Context applicationContext222222222 = MobileQQ.sMobileQQ.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext222222222, "sMobileQQ.applicationContext");
                    this$0.C(bVar, applicationContext222222222);
                }
                z19 = true;
                if (!z19) {
                }
                z26 = true;
                if (!z26) {
                }
                z27 = true;
                if (!z27) {
                }
                z28 = true;
                if (!z28) {
                }
                QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                Context applicationContext2222222222 = MobileQQ.sMobileQQ.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2222222222, "sMobileQQ.applicationContext");
                this$0.C(bVar, applicationContext2222222222);
            }
            z17 = true;
            if (!z17) {
                z18 = false;
                if (!z18) {
                }
                z19 = true;
                if (!z19) {
                }
                z26 = true;
                if (!z26) {
                }
                z27 = true;
                if (!z27) {
                }
                z28 = true;
                if (!z28) {
                }
                QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
                Context applicationContext22222222222 = MobileQQ.sMobileQQ.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext22222222222, "sMobileQQ.applicationContext");
                this$0.C(bVar, applicationContext22222222222);
            }
            z18 = true;
            if (!z18) {
            }
            z19 = true;
            if (!z19) {
            }
            z26 = true;
            if (!z26) {
            }
            z27 = true;
            if (!z27) {
            }
            z28 = true;
            if (!z28) {
            }
            QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
            Context applicationContext222222222222 = MobileQQ.sMobileQQ.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext222222222222, "sMobileQQ.applicationContext");
            this$0.C(bVar, applicationContext222222222222);
        }
        z16 = true;
        if (!z16) {
            z17 = false;
            if (!z17) {
            }
            z18 = true;
            if (!z18) {
            }
            z19 = true;
            if (!z19) {
            }
            z26 = true;
            if (!z26) {
            }
            z27 = true;
            if (!z27) {
            }
            z28 = true;
            if (!z28) {
            }
            QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
            Context applicationContext2222222222222 = MobileQQ.sMobileQQ.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2222222222222, "sMobileQQ.applicationContext");
            this$0.C(bVar, applicationContext2222222222222);
        }
        z17 = true;
        if (!z17) {
        }
        z18 = true;
        if (!z18) {
        }
        z19 = true;
        if (!z19) {
        }
        z26 = true;
        if (!z26) {
        }
        z27 = true;
        if (!z27) {
        }
        z28 = true;
        if (!z28) {
        }
        QLog.d("LebaPluginQzoneRedViewHolder", 2, "UpdateRedFlag end: " + bVar.b());
        Context applicationContext22222222222222 = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext22222222222222, "sMobileQQ.applicationContext");
        this$0.C(bVar, applicationContext22222222222222);
    }

    private final boolean s(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (qim != null) {
            qZoneCountInfo = qim.k(1018);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            N(qZoneCountInfo, 1018, drawParams);
            return true;
        }
        return false;
    }

    private final boolean t(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        ArrayList<QZoneCountUserInfo> arrayList = null;
        if (qim != null) {
            qZoneCountInfo = qim.k(6);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            arrayList = qZoneCountInfo.friendList;
        }
        if (arrayList == null || qZoneCountInfo.friendList.size() <= 0 || qZoneCountInfo.friendList.get(0).uin <= 0 || qZoneCountInfo.uCount <= 0) {
            return false;
        }
        this.showRedDotType = 6;
        M(qZoneCountInfo, drawParams);
        return true;
    }

    private final boolean u(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (qim != null) {
            qZoneCountInfo = qim.k(1017);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo != null) {
            N(qZoneCountInfo, 1017, drawParams);
            return true;
        }
        return false;
    }

    private final boolean v(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.peekAppRuntime()) && !QzoneFrame.isShowOldQZoneFrame()) {
            QLog.i("LebaPluginQzoneRedViewHolder", 1, "not show red dot in this mode");
            return false;
        }
        if (qim != null) {
            qZoneCountInfo = qim.k(74);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null) {
            return false;
        }
        this.showRedDotType = 74;
        ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).saveRedCountInfo(74, qZoneCountInfo);
        O(qZoneCountInfo, drawParams);
        return true;
    }

    private final boolean w(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (((IQZonePadApi) QRoute.api(IQZonePadApi.class)).isMomentSwitchClosed()) {
            QLog.d("LebaPluginQzoneRedViewHolder", 1, "is pad, not show moment red count");
            return false;
        }
        if (qim != null) {
            qZoneCountInfo = qim.k(67);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null) {
            return false;
        }
        this.showRedDotType = 67;
        com.tencent.mobileqq.service.qzone.b.x(67, qZoneCountInfo.cTime);
        com.tencent.mobileqq.service.qzone.b.y(67, qZoneCountInfo.uCount);
        O(qZoneCountInfo, drawParams);
        V(637, 49, 1);
        return true;
    }

    private final boolean x(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (qim != null) {
            qZoneCountInfo = qim.k(1028);
        } else {
            qZoneCountInfo = null;
        }
        if (qZoneCountInfo == null) {
            return false;
        }
        if (!((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).isValidPublishPlusIconRedDot(qZoneCountInfo)) {
            QLog.i("LebaPluginQzoneRedViewHolder", 1, "is invalid publish plus icon");
            return false;
        }
        Q(qZoneCountInfo, drawParams);
        return true;
    }

    private final boolean y(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (qim != null) {
            qZoneCountInfo = qim.k(1013);
        } else {
            qZoneCountInfo = null;
        }
        if (INSTANCE.a(qZoneCountInfo)) {
            Intrinsics.checkNotNull(qZoneCountInfo);
            drawParams.i(qZoneCountInfo.strShowMsg);
            this.showRedDotType = 1013;
            if (BaseApplicationImpl.getApplication() != null && BaseApplicationImpl.getApplication().getRuntime() != null) {
                QZoneUnreadServletLogic.d0(BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), qZoneCountInfo.actPageAttach);
            }
            ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
            if (arrayList == null || arrayList.size() == 0) {
                drawParams.j(true);
            }
            U(qZoneCountInfo, drawParams);
            return true;
        }
        return false;
    }

    private final boolean z(b drawParams, QZoneManagerImp qim) {
        QZoneCountInfo qZoneCountInfo;
        if (qim != null) {
            qZoneCountInfo = qim.k(3);
        } else {
            qZoneCountInfo = null;
        }
        if (INSTANCE.b(qZoneCountInfo)) {
            Intrinsics.checkNotNull(qZoneCountInfo);
            drawParams.i(qZoneCountInfo.strShowMsg);
            this.showRedDotType = 3;
            U(qZoneCountInfo, drawParams);
            return true;
        }
        return false;
    }

    @Nullable
    public final String I() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        TextView textView2 = this.mQzonePassiveRedDot;
        if (textView2 != null) {
            Intrinsics.checkNotNull(textView2);
            if (textView2.getVisibility() == 0 && (textView = this.mQzoneRedDot) != null) {
                Intrinsics.checkNotNull(textView);
                if (textView.getVisibility() == 0) {
                    return "num_red_dot";
                }
            }
        }
        TextView textView3 = this.mQzonePassiveRedDot;
        if (textView3 != null) {
            Intrinsics.checkNotNull(textView3);
            if (textView3.getVisibility() == 0) {
                return "little_red_dot";
            }
        }
        TextView textView4 = this.mQzoneRedDot;
        if (textView4 != null) {
            Intrinsics.checkNotNull(textView4);
            if (textView4.getVisibility() == 0) {
                return "little_red_dot";
            }
        }
        TextView textView5 = this.mQzoneVisit;
        if (textView5 != null) {
            Intrinsics.checkNotNull(textView5);
            if (textView5.getVisibility() == 0) {
                return "little_red_dot";
            }
            return null;
        }
        return null;
    }

    public final void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QZoneManagerImp");
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
        TextView textView = this.mQzoneVisit;
        if (textView != null) {
            Intrinsics.checkNotNull(textView);
            if (textView.getVisibility() == 0) {
                qZoneManagerImp.h(61);
                qZoneManagerImp.h(6);
            }
        }
        A(qZoneManagerImp);
        int i3 = this.showRedDotType;
        if (i3 == 2 || i3 == 67) {
            if (i3 == 67) {
                V(637, 49, 2);
                com.tencent.mobileqq.service.qzone.b.t(qZoneManagerImp.k(67));
            }
            qZoneManagerImp.h(67);
        }
        if (this.showRedDotType == 3) {
            qZoneManagerImp.h(3);
        }
        if (this.showRedDotType == 1028) {
            qZoneManagerImp.h(1028);
        }
        if (this.showRedDotType == 1013) {
            qZoneManagerImp.h(1013);
        }
        int i16 = this.showRedDotType;
        if (i16 == 1017 || i16 == 1018) {
            qZoneManagerImp.h(i16);
        }
    }

    public final boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        TextView textView = this.mQzoneRedDot;
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void R(@NotNull View entryHeader) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entryHeader);
            return;
        }
        Intrinsics.checkNotNullParameter(entryHeader, "entryHeader");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final QBaseActivity qBaseActivity = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        Context context = entryHeader.getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        }
        if (qQAppInterface != null && qBaseActivity != null) {
            View findViewById = entryHeader.findViewById(R.id.qzone_feed_reddot);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzoneRedDot = (TextView) findViewById;
            View findViewById2 = entryHeader.findViewById(R.id.hly);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzonePassiveRedDot = (TextView) findViewById2;
            View findViewById3 = entryHeader.findViewById(R.id.huj);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzoneVisit = (TextView) findViewById3;
            View findViewById4 = entryHeader.findViewById(R.id.f69473iu);
            Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzoneRedDotText = (TextView) findViewById4;
            View findViewById5 = entryHeader.findViewById(R.id.f69463it);
            Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzoneRecommTextRedDot = (TextView) findViewById5;
            View findViewById6 = entryHeader.findViewById(R.id.hh_);
            Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageSwitcher");
            this.mQzoneFeedSubIcon = (ImageSwitcher) findViewById6;
            View findViewById7 = entryHeader.findViewById(R.id.f68243fi);
            Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
            this.mQzoneBubbleRedDotText = (TextView) findViewById7;
            View findViewById8 = entryHeader.findViewById(R.id.f68233fh);
            Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type com.tencent.mobileqq.utils.RoundImageView");
            this.mQzoneBubbleRedDotIcon = (RoundImageView) findViewById8;
            View findViewById9 = entryHeader.findViewById(R.id.f68223fg);
            Intrinsics.checkNotNull(findViewById9, "null cannot be cast to non-null type android.widget.ImageView");
            this.mQzoneBubbleRedDot = (ImageView) findViewById9;
            ImageSwitcher imageSwitcher = this.mQzoneFeedSubIcon;
            Intrinsics.checkNotNull(imageSwitcher);
            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.mobileqq.leba.business.plugins.ag
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    View S;
                    S = LebaPluginQzoneRedViewHolder.S(QBaseActivity.this);
                    return S;
                }
            });
            View findViewById10 = entryHeader.findViewById(R.id.hhl);
            Intrinsics.checkNotNull(findViewById10, "null cannot be cast to non-null type android.widget.ImageView");
            this.mQzonefeedIconShadow = (ImageView) findViewById10;
            View findViewById11 = entryHeader.findViewById(R.id.hha);
            Intrinsics.checkNotNull(findViewById11, "null cannot be cast to non-null type android.widget.ImageSwitcher");
            ImageSwitcher imageSwitcher2 = (ImageSwitcher) findViewById11;
            this.mQzoneFeedSubIcontwo = imageSwitcher2;
            Intrinsics.checkNotNull(imageSwitcher2);
            imageSwitcher2.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.tencent.mobileqq.leba.business.plugins.ah
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    View T;
                    T = LebaPluginQzoneRedViewHolder.T(QBaseActivity.this);
                    return T;
                }
            });
            this.lebaQZoneFacePlayHelper = new dz(this.mQzoneFeedSubIcon, this.mQzoneFeedSubIcontwo, this.mQzonefeedIconShadow, qQAppInterface);
            return;
        }
        QLog.i("LebaPluginQzoneRedViewHolder", 1, "initQzone app == null || activity == null");
    }

    public final void W() {
        QQAppInterface qQAppInterface;
        dz dzVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && (dzVar = this.lebaQZoneFacePlayHelper) != null) {
            dzVar.r(qQAppInterface);
        }
    }

    public final void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        dz dzVar = this.lebaQZoneFacePlayHelper;
        if (dzVar != null) {
            dzVar.s();
        }
    }

    public final void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        dz dzVar = this.lebaQZoneFacePlayHelper;
        if (dzVar != null) {
            dzVar.t();
        }
    }

    public final void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        dz dzVar = this.lebaQZoneFacePlayHelper;
        if (dzVar != null) {
            dzVar.v();
        }
    }

    public final void a0() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.avatarObserver);
        }
    }

    public final void b0() {
        final QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.i("LebaPluginQzoneRedViewHolder", 1, "updateQZoneRedFlag app == null");
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.ai
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginQzoneRedViewHolder.c0(QQAppInterface.this, this);
                }
            }, 5, null, false);
        }
    }

    public final void q() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.avatarObserver);
        }
    }

    @NotNull
    public final View r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.root;
    }
}
