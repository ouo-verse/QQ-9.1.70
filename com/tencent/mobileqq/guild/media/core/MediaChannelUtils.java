package com.tencent.mobileqq.guild.media.core;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avbiz.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.MediaChannelPermissionFragment;
import com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo;
import com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006J*\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bJ\u0012\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\bJD\u0010+\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\b2\"\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010'j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`(2\b\b\u0002\u0010*\u001a\u00020\bJ\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0006J\u0012\u0010.\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u001e\u00102\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\b2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e00J\u0010\u00103\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJS\u0010=\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e002#\b\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000e052\u0006\u0010:\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010<\u001a\u00020;J\u0010\u0010@\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0007J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0007J\u0010\u0010D\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0007J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010F\u001a\u00020\u0004H\u0002J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020\u0004H\u0002J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007JB\u0010M\u001a\u00020\u000e28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(L\u0012\u0006\u0012\u0004\u0018\u00010\u000e0JH\u0007JR\u0010P\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(L\u0012\u0006\u0012\u0004\u0018\u00010\u000e0JH\u0007J\b\u0010Q\u001a\u00020\u0004H\u0007J\b\u0010R\u001a\u00020\u0006H\u0007J\u0010\u0010S\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0007J\u0010\u0010U\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001fH\u0007\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/MediaChannelUtils;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", HippyTKDListViewAdapter.X, "", "resId", "", "p", "result", "errMsg", "sucTipResId", "errTipResId", "", "U", "sucTip", "errTip", ExifInterface.LATITUDE_SOUTH, "maxLength", "text", "k", "channelId", "u", "time", "f", "userAVState", "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "j", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "v", QCircleAlphaUserReporter.KEY_USER, "t", "g", "reportView", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportEventParams", "eventType", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", DomainData.DOMAIN_NAME, "reason", "Lkotlin/Function0;", "onConfirm", "P", ReportConstant.COSTREPORT_PREFIX, "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "onFailed", "tag", "Lcom/tencent/mobileqq/guild/media/floatwindow/FloatWindowPermissionHandler;", "permissionHandler", "H", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfos", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "y", "r", "Lkotlin/Function2;", "isSuccess", "permissionIsNewGet", "O", "businessId", "bizPermissionId", "N", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", BdhLogUtil.LogTag.Tag_Conn, "E", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MediaChannelUtils f228046a = new MediaChannelUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            long j3;
            int compareValues;
            UserBusinessInfo userBusinessInfo = ((com.tencent.mobileqq.guild.media.core.data.p) t17).C;
            long j16 = 0;
            if (userBusinessInfo != null) {
                j3 = userBusinessInfo.getSortKey();
            } else {
                j3 = 0;
            }
            Long valueOf = Long.valueOf(j3);
            UserBusinessInfo userBusinessInfo2 = ((com.tencent.mobileqq.guild.media.core.data.p) t16).C;
            if (userBusinessInfo2 != null) {
                j16 = userBusinessInfo2.getSortKey();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(j16));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            long j3;
            int compareValues;
            UserBusinessInfo userBusinessInfo = ((com.tencent.mobileqq.guild.media.core.data.p) t17).C;
            long j16 = 0;
            if (userBusinessInfo != null) {
                j3 = userBusinessInfo.getSortKey();
            } else {
                j3 = 0;
            }
            Long valueOf = Long.valueOf(j3);
            UserBusinessInfo userBusinessInfo2 = ((com.tencent.mobileqq.guild.media.core.data.p) t16).C;
            if (userBusinessInfo2 != null) {
                j16 = userBusinessInfo2.getSortKey();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(j16));
            return compareValues;
        }
    }

    MediaChannelUtils() {
    }

    private final boolean A() {
        if (m.n(j.c()) == 2) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean B(@NotNull Context context) {
        boolean z16;
        Number valueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        int d16 = bi.d();
        boolean z17 = false;
        if (AppSetting.t(context) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            valueOf = Float.valueOf(d16 * com.tencent.mobileqq.pad.e.g());
        } else if (!z16) {
            valueOf = Integer.valueOf(d16);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (ViewUtils.pxToDp(valueOf.floatValue()) < 400) {
            z17 = true;
        }
        QLog.d("MediaChannelUtils", 1, "isSmallScreen " + z17);
        return z17;
    }

    @JvmStatic
    public static final boolean C(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        int n3 = f228046a.n(channelId);
        if (n3 != 2 && n3 != 4) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean E(@NotNull com.tencent.mobileqq.guild.media.core.data.p user) {
        Intrinsics.checkNotNullParameter(user, "user");
        if (user.f228098f == 0 && !user.f228101i && !user.f228102j) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.guild.media.core.data.r F(@NotNull com.tencent.mobileqq.guild.media.core.data.r userInfos) {
        List sortedWith;
        List sortedWith2;
        boolean z16;
        Intrinsics.checkNotNullParameter(userInfos, "userInfos");
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.guild.media.core.data.p> list = userInfos.f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "userInfos.anchors");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((com.tencent.mobileqq.guild.media.core.data.p) next).f228099g == 1) {
                z17 = true;
            }
            if (z17) {
                arrayList2.add(next);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (hashSet.add(((com.tencent.mobileqq.guild.media.core.data.p) obj).f228093a)) {
                arrayList3.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new a());
        List<com.tencent.mobileqq.guild.media.core.data.p> list2 = userInfos.f228125a;
        Intrinsics.checkNotNullExpressionValue(list2, "userInfos.anchors");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list2) {
            if (((com.tencent.mobileqq.guild.media.core.data.p) obj2).f228099g == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList4.add(obj2);
            }
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : arrayList4) {
            if (hashSet2.add(((com.tencent.mobileqq.guild.media.core.data.p) obj3).f228093a)) {
                arrayList5.add(obj3);
            }
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList5, new b());
        arrayList.addAll(sortedWith);
        arrayList.addAll(sortedWith2);
        com.tencent.mobileqq.guild.media.core.data.r rVar = new com.tencent.mobileqq.guild.media.core.data.r();
        rVar.f228125a.clear();
        rVar.f228125a.addAll(arrayList);
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function0 onSuccess, Function1 onFailed, boolean z16) {
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "$onFailed");
        if (z16) {
            onSuccess.invoke();
        } else {
            onFailed.invoke("no float window permission");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Ref.BooleanRef isClickPermissionBtn, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(isClickPermissionBtn, "$isClickPermissionBtn");
        isClickPermissionBtn.element = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 onFailed, Ref.BooleanRef isClickPermissionBtn, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onFailed, "$onFailed");
        Intrinsics.checkNotNullParameter(isClickPermissionBtn, "$isClickPermissionBtn");
        onFailed.invoke("cancel float window permission");
        isClickPermissionBtn.element = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Ref.BooleanRef isClickPermissionBtn, Function1 onFailed, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(isClickPermissionBtn, "$isClickPermissionBtn");
        Intrinsics.checkNotNullParameter(onFailed, "$onFailed");
        if (!isClickPermissionBtn.element) {
            onFailed.invoke("dismiss request float window permission");
        }
        isClickPermissionBtn.element = false;
    }

    @JvmStatic
    public static final boolean M() {
        return com.tencent.mobileqq.guild.util.h.m(ch.m(), Constants.Business.QQ_GUILD, null);
    }

    @JvmStatic
    public static final void N(@NotNull String businessId, @NotNull String bizPermissionId, @NotNull Function2<? super Boolean, ? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(bizPermissionId, "bizPermissionId");
        Intrinsics.checkNotNullParameter(result, "result");
        BusinessConfig businessConfig = new BusinessConfig(businessId, QQPermissionConstants.Business.SCENE.ENTER_AUDIO_ROOM);
        QBaseActivity splashActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(splashActivity, businessConfig);
        if (qQPermission == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "requestMediaChannelSystemPermissions, " + splashActivity + "," + qQPermission + ", please check!!!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.", 1, (String) it.next(), null);
            }
            result.invoke(Boolean.TRUE, Boolean.FALSE);
            return;
        }
        if (qQPermission.hasPermission(bizPermissionId) == 0) {
            result.invoke(Boolean.TRUE, Boolean.FALSE);
        } else {
            MediaChannelPermissionFragment.INSTANCE.a(businessConfig, bizPermissionId, result);
        }
    }

    @JvmStatic
    public static final void O(@NotNull Function2<? super Boolean, ? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        N(QQPermissionConstants.Business.ID.QQ_CHANNEL_AUDIO, QQPermissionConstants.Permission.RECORD_AUDIO, result);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Q(MediaChannelUtils mediaChannelUtils, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelUtils$showOneBtnDialog$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        mediaChannelUtils.P(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    public static /* synthetic */ void T(MediaChannelUtils mediaChannelUtils, int i3, String str, String str2, String str3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        if ((i16 & 8) != 0) {
            str3 = "";
        }
        mediaChannelUtils.S(i3, str, str2, str3);
    }

    public static /* synthetic */ void V(MediaChannelUtils mediaChannelUtils, int i3, String str, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            i16 = 0;
        }
        if ((i18 & 8) != 0) {
            i17 = 0;
        }
        mediaChannelUtils.U(i3, str, i16, i17);
    }

    @JvmStatic
    public static final int h(@NotNull View rootView) {
        boolean A;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        int k3 = j.c().getUserInfoList().k(1);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("MediaChannelUtils", 2, "getColumnsCount by user list, size " + k3 + " !");
        }
        if (k3 <= 0) {
            return 1;
        }
        MediaChannelUtils mediaChannelUtils = f228046a;
        if (mediaChannelUtils.x(rootView)) {
            return 4;
        }
        boolean z16 = false;
        if (1 <= k3 && k3 < 6) {
            z16 = true;
        }
        if (z16 || (A = mediaChannelUtils.A())) {
            return 2;
        }
        if (!A) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final int i(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (f228046a.x(rootView)) {
            return 4;
        }
        return 2;
    }

    @JvmStatic
    public static final int m() {
        n o06 = MediaChannelCore.INSTANCE.a().o0();
        Integer value = o06.M().getValue();
        if (value != null && value.intValue() == 2) {
            return 2;
        }
        if (j.c().getUserInfoList().h() != null) {
            return 7;
        }
        Integer value2 = o06.M().getValue();
        if (value2 != null && value2.intValue() == 6) {
            return 6;
        }
        IGProPlayInfo playInfo = o06.getPlayInfo();
        if (playInfo != null && (playInfo.getPlayNodeExInfo().getPlayState() == 1 || playInfo.getPlayNodeExInfo().getPlayState() == 2)) {
            return 4;
        }
        if (j.c().f() != 8) {
            return 1;
        }
        return 5;
    }

    public static /* synthetic */ int o(MediaChannelUtils mediaChannelUtils, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = j.c().e();
        }
        return mediaChannelUtils.n(str);
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.guild.media.core.data.r q(@NotNull com.tencent.mobileqq.guild.media.core.data.r userInfos) {
        Intrinsics.checkNotNullParameter(userInfos, "userInfos");
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.guild.media.core.data.p> list = userInfos.f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "userInfos.anchors");
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((com.tencent.mobileqq.guild.media.core.data.p) obj).f228093a)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!((com.tencent.mobileqq.guild.media.core.data.p) obj2).f228103k) {
                arrayList3.add(obj2);
            }
        }
        arrayList.addAll(arrayList3);
        com.tencent.mobileqq.guild.media.core.data.r rVar = new com.tencent.mobileqq.guild.media.core.data.r();
        rVar.f228125a.clear();
        rVar.f228125a.addAll(arrayList);
        return rVar;
    }

    @JvmStatic
    public static final int r(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        boolean x16 = f228046a.x(rootView);
        if (x16) {
            return 8;
        }
        if (!x16) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean w(Context context) {
        int i3 = x.f(context).f185860a;
        QLog.d("MediaChannelUtils", 1, "isCurrentPageUnfold ScreenWidth=" + i3);
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.PHONE) {
            if (i3 > 1500) {
                return true;
            }
            return false;
        }
        if (AppSetting.t(context) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            QLog.d("MediaChannelUtils", 1, "isSplitViewMode");
            if (i3 * com.tencent.mobileqq.pad.e.g() > 1500.0f) {
                return true;
            }
            return false;
        }
        if (i3 > 1500) {
            return true;
        }
        return false;
    }

    private final boolean y() {
        return true;
    }

    public final boolean D(int userAVState) {
        if (userAVState == 3 || userAVState == 4 || userAVState == 1) {
            return true;
        }
        return false;
    }

    public final void G(@NotNull View reportView, @NotNull String elementId, @NotNull HashMap<String, Object> reportEventParams, @NotNull String eventType) {
        Intrinsics.checkNotNullParameter(reportView, "reportView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(reportEventParams, "reportEventParams");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (reportEventParams.isEmpty()) {
            return;
        }
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(eventType, reportView, reportEventParams);
        QLog.d("MediaChannelUtils", 1, "reportElement, " + elementId + ", " + eventType + ", " + reportEventParams);
    }

    public final void H(@NotNull final Function0<Unit> onSuccess, @NotNull final Function1<? super String, Unit> onFailed, @NotNull String tag, @Nullable Activity activity, @NotNull FloatWindowPermissionHandler permissionHandler) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(permissionHandler, "permissionHandler");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Exception());
            d16.d(tag, 2, "requestFloatWindowPermissionTrace: " + stackTraceToString);
        }
        if (permissionHandler.e()) {
            onSuccess.invoke();
        } else {
            if (s(activity)) {
                onFailed.invoke("need permission without valid context");
                return;
            }
            permissionHandler.l(new FloatWindowPermissionHandler.a() { // from class: com.tencent.mobileqq.guild.media.core.s
                @Override // com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler.a
                public final void a(boolean z16) {
                    MediaChannelUtils.I(Function0.this, onFailed, z16);
                }
            });
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            permissionHandler.j(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelUtils.J(Ref.BooleanRef.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelUtils.K(Function1.this, booleanRef, dialogInterface, i3);
                }
            }, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.media.core.v
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MediaChannelUtils.L(Ref.BooleanRef.this, onFailed, dialogInterface);
                }
            });
        }
    }

    public final void P(@NotNull String reason, @NotNull final Function0<Unit> onConfirm) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, reason, (String) null, qBaseActivity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MediaChannelUtils.R(Function0.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void S(int result, @NotNull String errMsg, @NotNull String sucTip, @NotNull String errTip) {
        int i3;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(sucTip, "sucTip");
        Intrinsics.checkNotNullParameter(errTip, "errTip");
        if (result != 1013 && result != -93 && result != 1002) {
            if (result != 0) {
                if (!TextUtils.isEmpty(errTip)) {
                    i3 = 1;
                    errMsg = errTip;
                }
            } else {
                i3 = 2;
                errMsg = sucTip;
            }
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            QQToast makeText = QQToast.makeText(context, i3, errMsg, 0);
            Intrinsics.checkNotNullExpressionValue(makeText, "makeText(context, toastI\u2026tTip, Toast.LENGTH_SHORT)");
            makeText.show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        errMsg = p(R.string.f1498013_);
        i3 = 0;
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        QQToast makeText2 = QQToast.makeText(context2, i3, errMsg, 0);
        Intrinsics.checkNotNullExpressionValue(makeText2, "makeText(context, toastI\u2026tTip, Toast.LENGTH_SHORT)");
        makeText2.show(context2.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public final void U(int result, @NotNull String errMsg, int sucTipResId, int errTipResId) {
        String str;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        String str2 = "";
        if (sucTipResId == 0) {
            str = "";
        } else {
            str = p(sucTipResId);
        }
        if (errTipResId != 0) {
            str2 = p(errTipResId);
        }
        S(result, errMsg, str, str2);
    }

    @NotNull
    public final String f(int time) {
        String valueOf;
        String valueOf2;
        int i3 = time / 60;
        int i16 = time % 60;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = String.valueOf(i16);
        }
        return valueOf + ":" + valueOf2;
    }

    @NotNull
    public final String g() {
        String str = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(str, "{\n            AppSetting.subVersion\n        }");
        return str;
    }

    public final int j(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.activity.richmedia.i f16 = x.f(activity);
        if (f16.b() > f16.a()) {
            return 2;
        }
        return 1;
    }

    @NotNull
    public final String k(int maxLength, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() > maxLength) {
            return ((Object) text.subSequence(0, maxLength)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return text;
    }

    public final int l() {
        if (z()) {
            return 12;
        }
        return 3;
    }

    public final int n(@Nullable String channelId) {
        int i3;
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(channelId);
        boolean z16 = false;
        if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null) {
            i3 = voiceSpeakModeCfg.getSpeakMode();
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            if (channelInfo != null && channelInfo.getTalkPermission() == 2) {
                z16 = true;
            }
            if (z16 && channelInfo.isAllowOtherRaiseHand()) {
                return 4;
            }
            return i3;
        }
        return i3;
    }

    @NotNull
    public final String p(int resId) {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        try {
            String string = context.getString(resId);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
            return string;
        } catch (Resources.NotFoundException e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getStrTextByResId: msg[" + e16.getMessage() + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("MediaChannelUtils", 1, (String) it.next(), null);
            }
            return "";
        }
    }

    public final boolean s(@Nullable Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public final boolean t(@NotNull com.tencent.mobileqq.guild.media.core.data.p user) {
        Intrinsics.checkNotNullParameter(user, "user");
        if (QLog.isColorLevel()) {
            QLog.d("MediaChannelUtils", 1, "isAdminUser, userType: " + user.f228097e + ", roleList: " + user.I);
        }
        int i3 = user.f228097e;
        if (i3 == 1 || i3 == 2 || user.I.contains(5) || user.I.contains(7) || user.I.contains(2) || user.I.contains(4)) {
            return true;
        }
        return false;
    }

    public final boolean u(@Nullable String channelId) {
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        if (TextUtils.isEmpty(channelId)) {
            QLog.d("MediaChannelUtils", 1, "isAudioQueueMode err channelid");
            return false;
        }
        IRuntimeService runtimeService = ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface()\n         \u2026va, ProcessConstant.MAIN)");
        IGProChannelInfo channelInfo = ((IGPSService) runtimeService).getChannelInfo(channelId);
        if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null && voiceSpeakModeCfg.getSpeakMode() == 2) {
            return true;
        }
        return false;
    }

    public final boolean v(@NotNull com.tencent.mobileqq.guild.media.core.data.p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullExpressionValue(userInfo.I, "userInfo.roleList");
        if ((!r0.isEmpty()) && userInfo.I.contains(5) && userInfo.I.contains(7) && !userInfo.I.contains(2) && !userInfo.I.contains(4)) {
            return true;
        }
        return false;
    }

    public final boolean x(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return y();
        }
        if (rootView.getMeasuredWidth() <= 0) {
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            boolean w3 = w(context);
            QLog.i("MediaChannelUtils", 1, "[isCurrentPageUnfold] view is not ready. isCurrentPageUnfold " + w3);
            return w3;
        }
        if (rootView.getMeasuredWidth() > 1500) {
            return true;
        }
        return false;
    }

    public final boolean z() {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Bundle loadBeanBundle = j.a().getLoadBeanBundle();
        if (loadBeanBundle == null || (joinInfoParam = (JumpGuildParam.JoinInfoParam) loadBeanBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) == null) {
            return false;
        }
        String mainSource = joinInfoParam.getMainSource();
        String subSource = joinInfoParam.getSubSource();
        if (!Intrinsics.areEqual(mainSource, "partner") || !Intrinsics.areEqual(subSource, IndividuationUrlHelper.UrlId.CARD_HOME)) {
            return false;
        }
        return true;
    }
}
