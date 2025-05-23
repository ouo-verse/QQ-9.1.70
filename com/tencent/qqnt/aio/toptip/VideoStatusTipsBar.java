package com.tencent.qqnt.aio.toptip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.TipsBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.w;
import com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tenpay.sdk.util.UinConfigManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u00012\u00020\u00022\u00020\u0003:\u00044\u0088\u0001aB\t\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J0\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0002J*\u0010#\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J'\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190,2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u00100\u001a\u00020/H\u0002J)\u00104\u001a\u0004\u0018\u0001032\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001010,\"\u0004\u0018\u000101H\u0016\u00a2\u0006\u0004\b4\u00105J7\u00106\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001010,\"\u0004\u0018\u000101H\u0016\u00a2\u0006\u0004\b6\u00107J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\rJ&\u0010=\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rJ0\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010B\u001a\u00020\u0004J4\u0010F\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010C\u001a\u0004\u0018\u00010\u00192\b\u0010D\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u0019J\"\u0010I\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010\u00192\b\u0010H\u001a\u0004\u0018\u00010\u0019J\u0006\u0010J\u001a\u00020\u0004J\u0012\u0010K\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u000103H\u0016JB\u0010P\u001a\u00020\u00042\u0006\u0010M\u001a\u00020L2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00162\b\u0010O\u001a\u0004\u0018\u00010\u0019J\u000e\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0016J\b\u0010T\u001a\u00020SH\u0016J7\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u00020U2\u0006\u0010\t\u001a\u00020\b2\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001010,\"\u0004\u0018\u000101H\u0016\u00a2\u0006\u0004\bW\u0010XJ\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020/0YH\u0016R\u001a\u0010^\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b[\u0010P\u001a\u0004\b\\\u0010]R\u001c\u0010c\u001a\u0004\u0018\u00010_8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bT\u0010`\u001a\u0004\ba\u0010bR\u001a\u0010\u0011\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\bd\u0010P\u001a\u0004\be\u0010]R\u0018\u0010h\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010mR\u0016\u0010q\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010pR\u001e\u0010u\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010vR\u0016\u0010x\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010PR\u0018\u0010z\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010|R%\u0010\u007f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bP\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001b\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bA\u0010\u0084\u0001\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;", "Lcom/tencent/qqnt/aio/toptips/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/notification/e;", "", "B", "Lcom/tencent/qqnt/aio/toptips/c;", "tipsManager", "", "eventType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "event", "t", "", "memberUin", "relationId", "avType", "type", "memberNum", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$b;", "K", ReportConstant.COSTREPORT_PREFIX, "", "firstMemUin", "curType", "", "w", "v", "Landroid/content/Context;", "ctx", "name", "Landroid/widget/TextView;", "textView", "", "max", "E", "H", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/av/gaudio/AVNotifyCenter$h;", "userInfos", "", "y", "(Ljava/util/Collection;)[Ljava/lang/String;", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", HippyTKDListViewAdapter.X, "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", BdhLogUtil.LogTag.Tag_Req, "r", "delayMillis", "N", "relationType", "L", "from", "pUinType", "uin", "J", "u", "info", "groupId", "time", "O", "peerUin", "extraUin", "M", "G", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/app/QQAppInterface;", "pApp", "isOpenClass", "fromWhere", "I", "isVisible", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "e", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", tl.h.F, "d", "j", "()I", "barPriority", "", "[I", "b", "()[I", "excludeTypes", "f", "getType", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$RefreshMultiStateRunnable;", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$RefreshMultiStateRunnable;", "refreshRunnable", "Lmqq/os/MqqHandler;", "i", "Lmqq/os/MqqHandler;", "uiHandler", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "Lcom/tencent/qqnt/aio/helper/w;", "Lcom/tencent/qqnt/aio/helper/w;", "avHelper", "Ljava/lang/ref/WeakReference;", "D", "Ljava/lang/ref/WeakReference;", "weakApp", "Landroid/content/Context;", "context", "uinType", "Ljava/lang/String;", "mPeerUin", "Lcom/tencent/mobileqq/qqui/widget/TipsBar;", "Lcom/tencent/mobileqq/qqui/widget/TipsBar;", "multiVideoStatus", "Z", "isTimeShow", "()Z", "P", "(Z)V", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$b;", "notification", "<init>", "()V", "RefreshMultiStateRunnable", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class VideoStatusTipsBar extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener, com.tencent.mobileqq.aio.notification.e {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static String L;
    private static final int M = 0;
    private static final int N;
    private static final int P;
    private static final int Q;
    private static final int R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private w avHelper;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WeakReference<QQAppInterface> weakApp;

    /* renamed from: E, reason: from kotlin metadata */
    private Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private int uinType;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mPeerUin;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TipsBar multiVideoStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isTimeShow;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private IAIONotificationUIModel.b notification;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int barPriority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final int[] excludeTypes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RefreshMultiStateRunnable refreshRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MqqHandler uiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.aio.toptips.c topTipsManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$RefreshMultiStateRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;", "d", "Ljava/lang/ref/WeakReference;", "getMRef", "()Ljava/lang/ref/WeakReference;", "mRef", "tipsBar", "<init>", "(Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class RefreshMultiStateRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<VideoStatusTipsBar> mRef;

        public RefreshMultiStateRunnable(@NotNull VideoStatusTipsBar tipsBar) {
            Intrinsics.checkNotNullParameter(tipsBar, "tipsBar");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tipsBar);
            } else {
                this.mRef = new WeakReference<>(tipsBar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            VideoStatusTipsBar videoStatusTipsBar = this.mRef.get();
            if (videoStatusTipsBar != null) {
                videoStatusTipsBar.u();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$a;", "", "", "EVT_GAUDIO_MEMBER_JOIN", "I", "b", "()I", "EVT_GAUDIO_MEMBER_QUIT", "c", "EVT_GAUDIO_MEMBER_INFO", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.toptip.VideoStatusTipsBar$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return VideoStatusTipsBar.Q;
            }
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return VideoStatusTipsBar.N;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return VideoStatusTipsBar.P;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "text", "c", "name", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String name;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        public final void c(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.name = str;
            }
        }

        public final void d(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.text = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        INSTANCE = new Companion(null);
        N = 1;
        P = 2;
        Q = 3;
        R = 4;
    }

    public VideoStatusTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.barPriority = 2;
        this.type = 101;
        this.avHelper = new w(this);
        this.uinType = 10021;
    }

    private final void A(com.tencent.qqnt.aio.toptips.c tipsManager, int eventType) {
        Context context;
        String j3;
        if (eventType == 1005) {
            AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) runtime;
            this.weakApp = new WeakReference<>(qQAppInterface);
            this.topTipsManager = tipsManager;
            com.tencent.qqnt.aio.toptips.c cVar = null;
            if (tipsManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                tipsManager = null;
            }
            if (tipsManager.a().c().getContext() != null) {
                com.tencent.qqnt.aio.toptips.c cVar2 = this.topTipsManager;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                    cVar2 = null;
                }
                context = cVar2.a().c().requireContext();
                Intrinsics.checkNotNullExpressionValue(context, "{\n                topTip\u2026reContext()\n            }");
            } else {
                context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "{\n                BaseAp\u2026etContext()\n            }");
            }
            this.context = context;
            com.tencent.qqnt.aio.toptips.c cVar3 = this.topTipsManager;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            } else {
                cVar = cVar3;
            }
            AIOContact c16 = cVar.a().g().r().c();
            this.uinType = com.tencent.nt.adapter.session.c.c(c16.e());
            if (c16.e() == 1) {
                j3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(c16.j());
            } else {
                j3 = c16.j();
            }
            this.mPeerUin = j3;
            MqqHandler handler = qQAppInterface.getHandler(VideoStatusTipsBar.class);
            Intrinsics.checkNotNullExpressionValue(handler, "app.getHandler(VideoStatusTipsBar::class.java)");
            this.uiHandler = handler;
        }
    }

    private final void B() {
        if (this.multiVideoStatus == null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            TipsBar tipsBar = new TipsBar(context);
            this.multiVideoStatus = tipsBar;
            tipsBar.setBarType(2);
            TipsBar tipsBar2 = this.multiVideoStatus;
            if (tipsBar2 != null) {
                tipsBar2.setTipsIconLimitQuiToken(R.drawable.qui_telephone_filled_feedback_success);
            }
            TipsBar tipsBar3 = this.multiVideoStatus;
            if (tipsBar3 != null) {
                tipsBar3.C(true);
            }
            TipsBar tipsBar4 = this.multiVideoStatus;
            if (tipsBar4 != null) {
                tipsBar4.setOnClickListener(this);
            }
        }
    }

    private final boolean C() {
        QQAppInterface qQAppInterface;
        Context context;
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null || !qQAppInterface.getAVNotifyCenter().e0() || qQAppInterface.isVideoChatting()) {
            return false;
        }
        DataReport.Y(false, true);
        if (QLog.isColorLevel()) {
            QLog.d(L, 2, "startGroupAudio phone is calling!");
        }
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        String string = context2.getString(R.string.dg9);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qav_phone_is_calling)");
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        String string2 = context3.getString(R.string.dfp);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026impl.R.string.qav_notice)");
        Context context4 = this.context;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        } else {
            context = context4;
        }
        DialogUtil.createCustomDialog(context, 230, string2, string, R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.toptip.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoStatusTipsBar.D(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(DialogInterface dialogInterface, int i3) {
        DataReport.Y(false, false);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    private final String E(Context ctx, String name, TextView textView, float max) {
        boolean z16;
        boolean z17;
        boolean z18;
        TextPaint paint = textView.getPaint();
        if (max > 0.0f) {
            float measureText = paint.measureText(name);
            if (measureText > max) {
                float measureText2 = max - paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                String str = name;
                while (true) {
                    z16 = false;
                    if (measureText2 <= 0.0f || measureText <= measureText2) {
                        break;
                    }
                    if (str.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        break;
                    }
                    str = str.substring(0, str.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    measureText = paint.measureText(str);
                    if (measureText == 0.0f) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (str.length() > 0) {
                            z16 = true;
                        }
                        if (z16) {
                            measureText = 1 + measureText2;
                        }
                    }
                }
                if (measureText2 > 0.0f) {
                    if (str.length() > 0) {
                        z16 = true;
                    }
                    if (z16) {
                        return str + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    }
                    return name;
                }
                return name;
            }
            return name;
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        QQAppInterface qQAppInterface;
        int l3;
        int i3 = this.uinType;
        if (i3 != 3000 && i3 != 1) {
            if (C()) {
                return;
            }
            G();
            return;
        }
        String str = this.mPeerUin;
        Intrinsics.checkNotNull(str);
        long parseLong = Long.parseLong(str);
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            boolean i06 = qQAppInterface.getAVNotifyCenter().i0(this.mPeerUin);
            AVNotifyCenter.i p16 = qQAppInterface.getAVNotifyCenter().p(parseLong);
            if (p16 != null) {
                l3 = p16.f73810d;
            } else {
                l3 = qQAppInterface.getAVNotifyCenter().l(parseLong);
            }
            if ((l3 != 10 || i06) && C()) {
                return;
            }
            H();
        }
    }

    private final void H() {
        QQAppInterface qQAppInterface;
        int l3;
        QQAppInterface qQAppInterface2;
        Context context;
        String str;
        Context context2;
        Context context3;
        if (QLog.isDevelopLevel()) {
            QLog.i(L, 4, "onClick_multi");
        }
        int uinType2AVRelationType = ba.uinType2AVRelationType(this.uinType);
        String str2 = this.mPeerUin;
        Intrinsics.checkNotNull(str2);
        long parseLong = Long.parseLong(str2);
        HashMap hashMap = new HashMap();
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            AVNotifyCenter.i p16 = qQAppInterface.getAVNotifyCenter().p(parseLong);
            boolean z16 = false;
            int i3 = 2;
            if (p16 != null) {
                l3 = p16.f73810d;
                if (l3 == 2 && p16.f73812f == 2 && p16.f73813g == 4) {
                    z16 = true;
                }
            } else {
                l3 = qQAppInterface.getAVNotifyCenter().l(parseLong);
            }
            boolean z17 = z16;
            qQAppInterface.getAVNotifyCenter().B0(9, parseLong, l3);
            hashMap.put("MultiAVType", String.valueOf(l3));
            if (l3 == 2) {
                hashMap.put("Fromwhere", "SmallScreen");
                if (!qQAppInterface.getAVNotifyCenter().i0(this.mPeerUin)) {
                    String str3 = this.mPeerUin;
                    int j3 = TroopUtils.j(qQAppInterface, str3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(j3);
                    ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "Clk_video", 0, 0, str3, sb5.toString(), "2", "");
                }
            }
            if (qQAppInterface.getAVNotifyCenter().W(uinType2AVRelationType, parseLong)) {
                if (qQAppInterface.getAVNotifyCenter().A(String.valueOf(parseLong)) == 14) {
                    hashMap.put("from", "tipBar");
                    GroupVideoEntrance groupVideoEntrance = GroupVideoEntrance.f360542a;
                    Context context4 = this.context;
                    if (context4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context3 = null;
                    } else {
                        context3 = context4;
                    }
                    int i16 = this.uinType;
                    String str4 = this.mPeerUin;
                    Intrinsics.checkNotNull(str4);
                    groupVideoEntrance.I(qQAppInterface, context3, i16, str4, hashMap);
                    qQAppInterface2 = qQAppInterface;
                } else {
                    Context context5 = this.context;
                    if (context5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context2 = null;
                    } else {
                        context2 = context5;
                    }
                    qQAppInterface2 = qQAppInterface;
                    ChatActivityUtils.d0(qQAppInterface, context2, this.uinType, this.mPeerUin, true, true, null, hashMap);
                }
            } else {
                qQAppInterface2 = qQAppInterface;
                int M2 = qQAppInterface2.getAVNotifyCenter().M(this.mPeerUin);
                if (M2 != 4) {
                    i3 = 1;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(L, 4, "onClick_multi, sessionType[" + M2 + "], enterType[" + i3 + "]");
                }
                AVNotifyCenter aVNotifyCenter = qQAppInterface2.getAVNotifyCenter();
                Context context6 = this.context;
                if (context6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context6 = null;
                }
                if (!aVNotifyCenter.g(context6, i3, this.uinType, this.mPeerUin)) {
                    Context context7 = this.context;
                    if (context7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    } else {
                        context = context7;
                    }
                    I(qQAppInterface2, context, this.uinType, this.mPeerUin, l3, z17, null);
                }
                if (this.uinType == 1) {
                    if (qQAppInterface2.getAVNotifyCenter().l(parseLong) == 10) {
                        ReportController.o(null, "CliOper", "", "", "0X8005933", "0X8005933", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X80046DA", "0X80046DA", 0, 0, "", "", "", "");
                    }
                }
            }
            if (this.uinType == 3000) {
                if (qQAppInterface2.getAVNotifyCenter().W(uinType2AVRelationType, parseLong)) {
                    str = "Cover_back";
                } else {
                    str = "Clk_discuss_floating";
                }
                ReportController.o(qQAppInterface2, "CliOper", "", "", "Multi_call", str, 0, 0, "", "", "", "");
            }
        }
    }

    private final b K(long memberUin, long relationId, int avType, int type, long memberNum) {
        QQAppInterface qQAppInterface;
        String str;
        String str2;
        b bVar = new b();
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String valueOf = String.valueOf(memberUin);
            int i3 = 2;
            Context context = null;
            if (memberUin != 0 && !currentAccountUin.equals(valueOf) && avType != 2) {
                String valueOf2 = String.valueOf(relationId);
                if (this.uinType == 1) {
                    i3 = 1;
                }
                str2 = ac.s(qQAppInterface, valueOf, valueOf2, i3, 0);
                if (type == N) {
                    int i16 = this.uinType;
                    if (i16 == 3000) {
                        Context context2 = this.context;
                        if (context2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context2 = null;
                        }
                        str = context2.getString(R.string.f170265kn);
                    } else {
                        if (i16 == 1) {
                            Context context3 = this.context;
                            if (context3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context3 = null;
                            }
                            str = context3.getString(R.string.f170228jh);
                        }
                        str = null;
                    }
                    this.isTimeShow = false;
                } else {
                    if (type == P) {
                        int i17 = this.uinType;
                        if (i17 == 3000) {
                            Context context4 = this.context;
                            if (context4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context4 = null;
                            }
                            str = context4.getString(R.string.f170266ko);
                        } else if (i17 == 1) {
                            Context context5 = this.context;
                            if (context5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context5 = null;
                            }
                            str = context5.getString(R.string.f170229ji);
                        }
                        this.isTimeShow = false;
                    }
                    str = null;
                    this.isTimeShow = false;
                }
            } else {
                if (qQAppInterface.getAVNotifyCenter().k0()) {
                    Context context6 = this.context;
                    if (context6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context6 = null;
                    }
                    str = context6.getString(R.string.f170267kp);
                    qQAppInterface.getAVNotifyCenter().O0(false);
                    if (avType == 2) {
                        this.isTimeShow = false;
                    }
                } else {
                    int i18 = this.uinType;
                    if (i18 == 3000) {
                        Context context7 = this.context;
                        if (context7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context7 = null;
                        }
                        str = context7.getString(R.string.f170259kg);
                    } else if (i18 == 1) {
                        str = v(relationId, avType);
                    } else {
                        str = null;
                    }
                    qQAppInterface.getAVNotifyCenter().O0(true);
                    if (str != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        str = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    }
                    this.isTimeShow = true;
                }
                str2 = null;
            }
            int i19 = this.uinType;
            if (i19 == 3000) {
                TipsBar tipsBar = this.multiVideoStatus;
                Context context8 = this.context;
                if (context8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context = context8;
                }
                ba.setAccText(tipsBar, context.getString(R.string.bhn));
            } else if (i19 == 1) {
                TipsBar tipsBar2 = this.multiVideoStatus;
                Context context9 = this.context;
                if (context9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context = context9;
                }
                ba.setAccText(tipsBar2, context.getString(R.string.bho), avType);
            }
            bVar.c(str2);
            bVar.d(str);
        }
        return bVar;
    }

    private final void Q() {
        boolean z16;
        com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
        com.tencent.qqnt.aio.toptips.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            cVar = null;
        }
        if (cVar.b() == getType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.i(L, 2, "show tips bar");
            }
            com.tencent.qqnt.aio.toptips.c cVar3 = this.topTipsManager;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            } else {
                cVar2 = cVar3;
            }
            cVar2.e(this);
        }
    }

    private final void s() {
        z();
    }

    private final int t(int event) {
        if (event != 20) {
            if (event != 21) {
                if (event != 23) {
                    return Q;
                }
                return P;
            }
            return M;
        }
        return M;
    }

    private final String v(long relationId, int avType) {
        QQAppInterface qQAppInterface;
        AVNotifyCenter.i iVar;
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            Context context = null;
            if (qQAppInterface.getAVNotifyCenter() != null) {
                iVar = qQAppInterface.getAVNotifyCenter().Q(relationId, avType);
            } else {
                iVar = null;
            }
            if (iVar != null && iVar.b()) {
                Context context2 = this.context;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context = context2;
                }
                String string = context.getString(R.string.fym);
                Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026nclass_chating)\n        }");
                return string;
            }
            if (iVar != null && iVar.c()) {
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context = context3;
                }
                String string2 = context.getString(R.string.f170230yr4);
                Intrinsics.checkNotNullExpressionValue(string2, "{\n            context.ge\u2026iceing_number3)\n        }");
                return string2;
            }
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context4;
            }
            String string3 = context.getString(R.string.f170252kb);
            Intrinsics.checkNotNullExpressionValue(string3, "{\n            context.ge\u2026_group_chating)\n        }");
            return string3;
        }
        return "";
    }

    private final String w(boolean firstMemUin, long relationId, int avType, int curType, long memberNum) {
        QQAppInterface qQAppInterface;
        Context context;
        String string;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null) {
            return "";
        }
        AVNotifyCenter.i Q2 = qQAppInterface.getAVNotifyCenter() != null ? qQAppInterface.getAVNotifyCenter().Q(relationId, avType) : null;
        if (firstMemUin) {
            if (this.uinType == 1) {
                if (Q2 != null && Q2.b()) {
                    if (memberNum > 99) {
                        Context context14 = this.context;
                        if (context14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context13 = null;
                        } else {
                            context13 = context14;
                        }
                        string = context13.getString(R.string.fyl);
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Context context15 = this.context;
                        if (context15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context15 = null;
                        }
                        String string2 = context15.getString(R.string.fyk);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ss_chat_videoing_number3)");
                        string = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                        Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
                } else if (Q2 == null || !Q2.c()) {
                    if (memberNum > 99) {
                        Context context16 = this.context;
                        if (context16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context11 = null;
                        } else {
                            context11 = context16;
                        }
                        string = context11.getString(R.string.f170253kc);
                    } else {
                        if (Q2 != null && Q2.f73814h) {
                            Context context17 = this.context;
                            if (context17 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context10 = null;
                            } else {
                                context10 = context17;
                            }
                            string = context10.getString(R.string.f170227yr3);
                        } else {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            Context context18 = this.context;
                            if (context18 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context18 = null;
                            }
                            String string3 = context18.getString(R.string.f170226jg);
                            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026up_chat_videoing_number3)");
                            string = String.format(string3, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
                } else {
                    if (memberNum > 99) {
                        Context context19 = this.context;
                        if (context19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context12 = null;
                        } else {
                            context12 = context19;
                        }
                        string = context12.getString(R.string.f170254ys2);
                    } else {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        Context context20 = this.context;
                        if (context20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context20 = null;
                        }
                        String string4 = context20.getString(R.string.f170230yr4);
                        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026up_chat_voiceing_number3)");
                        string = String.format(string4, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                        Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
                }
            } else {
                if (avType != 2 || memberNum <= 99) {
                    return "";
                }
                if (Q2 != null && Q2.b()) {
                    Context context21 = this.context;
                    if (context21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context9 = null;
                    } else {
                        context9 = context21;
                    }
                    string = context9.getString(R.string.fyl);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
                } else if (Q2 != null && Q2.c()) {
                    Context context22 = this.context;
                    if (context22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context8 = null;
                    } else {
                        context8 = context22;
                    }
                    string = context8.getString(R.string.f170254ys2);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
                } else {
                    Context context23 = this.context;
                    if (context23 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context7 = null;
                    } else {
                        context7 = context23;
                    }
                    string = context7.getString(R.string.f170253kc);
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
                }
            }
        } else if (this.uinType == 1) {
            if (Q2 != null && Q2.b()) {
                if (memberNum > 99) {
                    Context context24 = this.context;
                    if (context24 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context6 = null;
                    } else {
                        context6 = context24;
                    }
                    string = context6.getString(R.string.fyl);
                } else {
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    Context context25 = this.context;
                    if (context25 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context25 = null;
                    }
                    String string5 = context25.getString(R.string.fyk);
                    Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026ss_chat_videoing_number3)");
                    string = String.format(string5, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                    Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
            } else if (Q2 == null || !Q2.c()) {
                Context context26 = this.context;
                if (context26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context4 = null;
                } else {
                    context4 = context26;
                }
                string = context4.getString(R.string.f170225jf);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026umber2)\n                }");
            } else {
                if (memberNum > 99) {
                    Context context27 = this.context;
                    if (context27 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context5 = null;
                    } else {
                        context5 = context27;
                    }
                    string = context5.getString(R.string.f170254ys2);
                } else {
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    Context context28 = this.context;
                    if (context28 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context28 = null;
                    }
                    String string6 = context28.getString(R.string.f170230yr4);
                    Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri\u2026up_chat_voiceing_number3)");
                    string = String.format(string6, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                    Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                }
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    if\u2026      }\n                }");
            }
        } else {
            if (avType != 2 || memberNum <= 99) {
                return "";
            }
            if (Q2 != null && Q2.b()) {
                Context context29 = this.context;
                if (context29 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context3 = null;
                } else {
                    context3 = context29;
                }
                string = context3.getString(R.string.fyl);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
            } else if (Q2 != null && Q2.c()) {
                Context context30 = this.context;
                if (context30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context2 = null;
                } else {
                    context2 = context30;
                }
                string = context2.getString(R.string.f170254ys2);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
            } else {
                Context context31 = this.context;
                if (context31 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                } else {
                    context = context31;
                }
                string = context.getString(R.string.f170233jl);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026than99)\n                }");
            }
        }
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AIONotificationBusiId x() {
        long j3;
        QQAppInterface qQAppInterface;
        int l3;
        boolean z16;
        Long longOrNull;
        String str = this.mPeerUin;
        if (str != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            AVNotifyCenter.i p16 = qQAppInterface.getAVNotifyCenter().p(j3);
            if (p16 != null) {
                l3 = p16.f73810d;
            } else {
                l3 = qQAppInterface.getAVNotifyCenter().l(j3);
            }
            boolean z17 = false;
            if (l3 == 2) {
                if (p16 != null && p16.b()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                return AIONotificationBusiId.TROOP_CLASS;
            }
            if (l3 == 2) {
                return AIONotificationBusiId.TROOP_LIVE;
            }
            return AIONotificationBusiId.AUDIO_VIDEO_CHAT;
        }
        return AIONotificationBusiId.AUDIO_VIDEO_CHAT;
    }

    private final String[] y(Collection<? extends AVNotifyCenter.h> userInfos) {
        ArrayList arrayList = new ArrayList();
        if (userInfos != null) {
            Iterator<T> it = userInfos.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((AVNotifyCenter.h) it.next()).f73805a));
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNullExpressionValue(array, "uinList.toArray(arrayOf<String>())");
        return (String[]) array;
    }

    private final void z() {
        boolean z16;
        com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            cVar = null;
        }
        if (cVar.b() != getType() && this.notification == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i(L, 2, "hide tips bar");
            }
            com.tencent.qqnt.aio.toptips.c cVar2 = this.topTipsManager;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                cVar2 = null;
            }
            cVar2.i(this, false);
            this.notification = null;
        }
    }

    public final void G() {
        QQAppInterface qQAppInterface;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(L, 4, "onClick_double");
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            boolean z18 = false;
            int i3 = 1;
            if (qQAppInterface.getAVNotifyCenter().L() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (qQAppInterface.getAVNotifyCenter().d0(this.mPeerUin)) {
                if (qQAppInterface.getAVNotifyCenter().C(this.mPeerUin) == 1) {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X800478D", "0X800478D", 0, 0, "", "", "", "");
                    z18 = true;
                } else {
                    ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004789", "0X8004789", 0, 0, "", "", "", "");
                }
                z17 = z18;
            } else {
                z17 = z16;
            }
            if (!z17) {
                i3 = 2;
            }
            AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            if (aVNotifyCenter.g(context, i3, this.uinType, this.mPeerUin)) {
                return;
            }
            com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                cVar = null;
            }
            AIOContact c16 = cVar.a().g().r().c();
            if (qQAppInterface.getAVNotifyCenter().T()) {
                HashMap hashMap = new HashMap();
                hashMap.put("should_believe_only_audio_flag", "true");
                hashMap.put("from", "4");
                Context context2 = this.context;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context2 = null;
                }
                ChatActivityUtils.c0(qQAppInterface, context2, this.uinType, this.mPeerUin, c16.g(), z17, "", false, true, null, "AIO_Adelie_AV", hashMap);
            } else {
                Context context3 = this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context3 = null;
                }
                ChatActivityUtils.h0(qQAppInterface, context3, this.uinType, this.mPeerUin, c16.g(), null, z17, "", false, true, null, "from_internal");
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "2", "", "", "");
        }
    }

    public final void I(@NotNull QQAppInterface pApp, @NotNull Context ctx, int pUinType, @Nullable String uin, int avType, boolean isOpenClass, @Nullable String fromWhere) {
        boolean z16;
        long[] jArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, pApp, ctx, Integer.valueOf(pUinType), uin, Integer.valueOf(avType), Boolean.valueOf(isOpenClass), fromWhere);
            return;
        }
        Intrinsics.checkNotNullParameter(pApp, "pApp");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!NetworkUtil.isNetSupport(ctx.getApplicationContext())) {
            QQToast.makeText(ctx, R.string.cgc, 0).show(ctx.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (uin == null) {
            return;
        }
        boolean i06 = pApp.getAVNotifyCenter().i0(uin);
        if (avType == 2 && !i06) {
            HashMap hashMap = new HashMap();
            hashMap.put("MultiAVType", "2");
            hashMap.put("from", "tipBar");
            GroupVideoEntrance.f360542a.I(pApp, ctx, pUinType, uin, hashMap);
            return;
        }
        if (pApp.getAVNotifyCenter().L() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (pApp.getAVNotifyCenter().h(ctx, pUinType, uin, z16)) {
            return;
        }
        Intent intent = new Intent(ctx, (Class<?>) MultiVideoEnterPageActivity.class);
        intent.addFlags(262144);
        intent.addFlags(268435456);
        if (pUinType == 3000) {
            Manager manager = pApp.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.DiscussionManager");
            ArrayList<DiscussionMemberInfo> m3 = ((n) manager).m(uin);
            if (m3 != null) {
                int size = m3.size();
                jArr = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    DiscussionMemberInfo discussionMemberInfo = m3.get(i3);
                    if (discussionMemberInfo != null) {
                        Long valueOf = Long.valueOf(discussionMemberInfo.memberUin);
                        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(memberUin)");
                        jArr[i3] = valueOf.longValue();
                    }
                }
            } else {
                jArr = null;
            }
            intent.putExtra("DiscussUinList", jArr);
        }
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("uin", uin);
        intent.putExtra("uinType", pUinType);
        intent.putExtra("Type", 3);
        intent.putExtra("GroupId", uin);
        intent.putExtra("openClass", isOpenClass);
        intent.putExtra("MultiAVType", avType);
        intent.putExtra("Fromwhere", fromWhere);
        intent.putExtra("flag", i06);
        if (1 == pUinType) {
            intent.putExtra("groupInfo", cp.k(pApp, uin));
        }
        ctx.startActivity(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x02e4, code lost:
    
        if (r4 != 2) goto L206;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void J(@NotNull String from, int pUinType, @Nullable String uin, int type, long memberUin) {
        long j3;
        QQAppInterface qQAppInterface;
        Vector<AVNotifyCenter.h> vector;
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        long j16;
        int i19;
        AVNotifyCenter.i Q2;
        AVNotifyCenter.i Q3;
        boolean z17;
        QQAppInterface qQAppInterface2;
        long j17;
        Vector<AVNotifyCenter.h> vector2;
        b L2;
        int i26;
        boolean z18;
        int i27;
        boolean z19;
        boolean z26;
        TipsBar tipsBar;
        boolean z27;
        int i28;
        Object obj;
        String str;
        String format;
        boolean equals;
        boolean z28;
        int i29;
        AVNotifyCenter.i p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, from, Integer.valueOf(pUinType), uin, Integer.valueOf(type), Long.valueOf(memberUin));
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (QQAudioHelper.j()) {
            QLog.w(L, 1, "refreshMultiVideoStatus[" + from + "], uinType[" + pUinType + "], uin[" + uin + "], type[" + type + "], memberUin[" + memberUin + "], curType[" + this.uinType + "]");
        }
        int i36 = this.uinType;
        if (i36 != 3000 && i36 != 1) {
            s();
            return;
        }
        try {
            Intrinsics.checkNotNull(uin);
            j3 = Long.parseLong(uin);
        } catch (NumberFormatException unused) {
            j3 = 0;
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null) {
            return;
        }
        int uinType2AVRelationType = ba.uinType2AVRelationType(this.uinType);
        long y16 = qQAppInterface.getAVNotifyCenter().y(uinType2AVRelationType, j3);
        Vector<AVNotifyCenter.h> s16 = qQAppInterface.getAVNotifyCenter().s(j3);
        int l3 = qQAppInterface.getAVNotifyCenter().l(j3);
        boolean W = qQAppInterface.getAVNotifyCenter().W(uinType2AVRelationType, j3);
        if (uinType2AVRelationType != 1 || W || uin == null || !TextUtils.isDigitsOnly(uin)) {
            vector = s16;
            z16 = W;
        } else {
            try {
                z16 = W;
                try {
                    p16 = qQAppInterface.getAVNotifyCenter().p(Long.parseLong(uin));
                } catch (NumberFormatException e16) {
                    e = e16;
                    vector = s16;
                }
            } catch (NumberFormatException e17) {
                e = e17;
                vector = s16;
                z16 = W;
            }
            if (p16 != null) {
                if (p16.f73810d != 10 || p16.f73809c <= 0) {
                    vector = s16;
                } else {
                    vector = s16;
                    if (System.currentTimeMillis() > p16.f73816j + 90000) {
                        try {
                            QLog.w(L, 1, "refreshMultiVideoStatus, \u8dd1\u9a6c\u706f\u8d85\u65f6," + p16 + "]");
                            p16.f73809c = 0;
                            qQAppInterface.getAVNotifyCenter().I0(14, uinType2AVRelationType, j3, null, 0L);
                        } catch (NumberFormatException e18) {
                            e = e18;
                            i29 = type;
                            if (QLog.isColorLevel()) {
                                i3 = 2;
                            } else {
                                i3 = 2;
                                QLog.e(L, 2, "refreshMultiVideoStatus error : " + e);
                            }
                            i16 = i29;
                            j16 = y16;
                            i17 = l3;
                            i18 = 0;
                            if (i17 != i3) {
                            }
                            i19 = uinType2AVRelationType;
                            qQAppInterface.getAVNotifyCenter().H0(j3, i17, (int) j16);
                            if (i17 == i3) {
                            }
                            if (j16 > 0) {
                            }
                        }
                    }
                }
                i29 = t(p16.f73815i);
                try {
                    long j18 = p16.f73809c;
                    try {
                        i17 = p16.f73810d;
                        i16 = i29;
                        j16 = j18;
                        i3 = 2;
                        i18 = 1;
                    } catch (NumberFormatException e19) {
                        e = e19;
                        y16 = j18;
                        if (QLog.isColorLevel()) {
                        }
                        i16 = i29;
                        j16 = y16;
                        i17 = l3;
                        i18 = 0;
                        if (i17 != i3) {
                        }
                        i19 = uinType2AVRelationType;
                        qQAppInterface.getAVNotifyCenter().H0(j3, i17, (int) j16);
                        if (i17 == i3) {
                        }
                        if (j16 > 0) {
                        }
                    }
                } catch (NumberFormatException e26) {
                    e = e26;
                }
                if (i17 != i3 || i17 == 10) {
                    i19 = uinType2AVRelationType;
                    qQAppInterface.getAVNotifyCenter().H0(j3, i17, (int) j16);
                    if (i17 == i3 && (Q2 = qQAppInterface.getAVNotifyCenter().Q(j3, i17)) != null) {
                        qQAppInterface.getAVNotifyCenter().a1(2, j3, i17, Q2.f73812f, Q2.f73813g, Q2.f73811e, Q2.f73809c > 0 ? 23 : 21, Q2.f73809c);
                        Q3 = qQAppInterface.getAVNotifyCenter().Q(j3, i17);
                        if (Q3 != null) {
                            Q3.f73814h = Q2.f73814h;
                        }
                    }
                } else {
                    i19 = uinType2AVRelationType;
                }
                if (j16 > 0) {
                    s();
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    String str2 = L;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("refreshMultiVideoStatus, \u663e\u793a\u8dd1\u9a6c\u706f, memberNum[");
                    sb5.append(j16);
                    sb5.append("], avType[");
                    sb5.append(i17);
                    sb5.append("], isChatting[");
                    z17 = z16;
                    sb5.append(z17);
                    sb5.append("], step[");
                    sb5.append(i18);
                    sb5.append("]");
                    QLog.w(str2, 1, sb5.toString());
                } else {
                    z17 = z16;
                }
                B();
                if (z17) {
                    qQAppInterface2 = qQAppInterface;
                    j17 = j16;
                    vector2 = vector;
                    L2 = K(memberUin, j3, i17, i16, j17);
                } else {
                    qQAppInterface2 = qQAppInterface;
                    j17 = j16;
                    vector2 = vector;
                    L2 = L(i19, j3, i17, j17);
                }
                if (i16 != N && i16 != P) {
                    N(90000L);
                } else {
                    N(3000L);
                }
                if (i17 == 2 && !qQAppInterface2.getAVNotifyCenter().i0(uin)) {
                    String str3 = this.mPeerUin;
                    int j19 = TroopUtils.j(qQAppInterface2, str3);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(j19);
                    ReportController.o(null, "dc00899", "Grp_video", "", UinConfigManager.KEY_ADS, "exp_aio", 0, 0, str3, sb6.toString(), "", "");
                    TipsBar tipsBar2 = this.multiVideoStatus;
                    if (tipsBar2 != null) {
                        tipsBar2.setAvatarUins(y(vector2));
                    }
                    z26 = false;
                } else {
                    Vector<AVNotifyCenter.h> vector3 = vector2;
                    if (i17 != 10) {
                        z18 = true;
                        i26 = i19;
                        i27 = 2;
                        if (i17 != 1) {
                        }
                    } else {
                        i26 = i19;
                        z18 = true;
                        i27 = 2;
                    }
                    if (!qQAppInterface2.getAVNotifyCenter().i0(uin)) {
                        Vector<AVNotifyCenter.h> x16 = i26 == i27 ? qQAppInterface2.getAVNotifyCenter().x(i26, j3) : vector3;
                        if (x16 != null && x16.size() == z18) {
                            equals = StringsKt__StringsJVMKt.equals(qQAppInterface2.getCurrentUin(), String.valueOf(x16.get(0).f73805a), z18);
                            if (equals) {
                                z19 = z18;
                                if (x16 == null && x16.size() != 0 && !z19) {
                                    FriendDataServiceImpl service = FriendDataServiceImpl.getService(qQAppInterface2);
                                    Intrinsics.checkNotNullExpressionValue(service, "getService(app)");
                                    ArrayList arrayList = new ArrayList();
                                    int size = x16.size();
                                    for (int i37 = 0; i37 < size; i37++) {
                                        if (service.isFriend(String.valueOf(x16.get(i37).f73805a))) {
                                            arrayList.add(x16.get(i37));
                                        }
                                        if (arrayList.size() == 4) {
                                            break;
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        TipsBar tipsBar3 = this.multiVideoStatus;
                                        if (tipsBar3 != null) {
                                            tipsBar3.setAvatarUins(y(arrayList));
                                        }
                                    } else {
                                        TipsBar tipsBar4 = this.multiVideoStatus;
                                        if (tipsBar4 != null) {
                                            tipsBar4.setAvatarUins((String[]) new ArrayList().toArray(new String[0]));
                                        }
                                    }
                                    int i38 = this.uinType == 1 ? 1 : 2;
                                    if (arrayList.size() == 0) {
                                        i28 = 0;
                                        obj = x16.get(0);
                                    } else {
                                        i28 = 0;
                                        obj = arrayList.get(0);
                                    }
                                    String s17 = ac.s(qQAppInterface2, String.valueOf(((AVNotifyCenter.h) obj).f73805a), uin, i38, i28);
                                    if (j17 == 1) {
                                        Context context = this.context;
                                        if (context == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("context");
                                            context = null;
                                        }
                                        format = context.getString(R.string.f170264km);
                                    } else {
                                        int i39 = this.uinType;
                                        if (i39 == 3000) {
                                            Context context2 = this.context;
                                            if (context2 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                                context2 = null;
                                            }
                                            str = context2.getString(R.string.f170261kj);
                                        } else if (i39 == 1) {
                                            Context context3 = this.context;
                                            if (context3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                                context3 = null;
                                            }
                                            str = context3.getString(R.string.f170225jf);
                                        } else {
                                            str = null;
                                        }
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        Intrinsics.checkNotNull(str);
                                        format = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
                                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                    }
                                    Context context4 = this.context;
                                    if (context4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("context");
                                        context4 = null;
                                    }
                                    TextView textView = new TextView(context4.getApplicationContext());
                                    textView.setTextSize(14.0f);
                                    TipsBar tipsBar5 = this.multiVideoStatus;
                                    Intrinsics.checkNotNull(tipsBar5);
                                    float dimensionPixelSize = tipsBar5.getResources().getDimensionPixelSize(R.dimen.f158923b64);
                                    Context context5 = this.context;
                                    if (context5 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("context");
                                        context5 = null;
                                    }
                                    L2.d(ba.getNameMaxMaseaured(context5, s17.toString(), textView, dimensionPixelSize) + format);
                                    z26 = false;
                                    if (this.isTimeShow) {
                                        this.isTimeShow = false;
                                    }
                                    L2.c(null);
                                } else {
                                    z26 = false;
                                    Context context6 = null;
                                    tipsBar = this.multiVideoStatus;
                                    if (tipsBar != null) {
                                        tipsBar.setTipsIconLimitQuiToken(R.drawable.qui_telephone_filled_feedback_success);
                                    }
                                    if (z19) {
                                        Context context7 = this.context;
                                        if (context7 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("context");
                                        } else {
                                            context6 = context7;
                                        }
                                        L2.d(context6.getString(R.string.f170260ki));
                                    }
                                    z27 = true;
                                    QLog.w(L, 1, "\u62ff\u4e0d\u5230\u7528\u6237\u6570\u636e\uff0c\u653e\u5f03\u5c55\u793a aloneStatus:" + z19);
                                    O(L2.a(), L2.b(), String.valueOf(j3), i17, "");
                                    if (qQAppInterface2.isVideoChatting()) {
                                        z28 = z27;
                                    } else {
                                        z28 = qQAppInterface2.getAVNotifyCenter().N() != 3 ? z27 : z26;
                                    }
                                    S(z28);
                                    return;
                                }
                            }
                        }
                        z19 = false;
                        if (x16 == null) {
                        }
                        z26 = false;
                        Context context62 = null;
                        tipsBar = this.multiVideoStatus;
                        if (tipsBar != null) {
                        }
                        if (z19) {
                        }
                        z27 = true;
                        QLog.w(L, 1, "\u62ff\u4e0d\u5230\u7528\u6237\u6570\u636e\uff0c\u653e\u5f03\u5c55\u793a aloneStatus:" + z19);
                        O(L2.a(), L2.b(), String.valueOf(j3), i17, "");
                        if (qQAppInterface2.isVideoChatting()) {
                        }
                        S(z28);
                        return;
                    }
                    z27 = z18;
                    z26 = false;
                    O(L2.a(), L2.b(), String.valueOf(j3), i17, "");
                    if (qQAppInterface2.isVideoChatting()) {
                    }
                    S(z28);
                    return;
                }
                z27 = true;
                O(L2.a(), L2.b(), String.valueOf(j3), i17, "");
                if (qQAppInterface2.isVideoChatting()) {
                }
                S(z28);
                return;
            }
            vector = s16;
        }
        i3 = 2;
        i16 = type;
        j16 = y16;
        i17 = l3;
        i18 = 0;
        if (i17 != i3) {
        }
        i19 = uinType2AVRelationType;
        qQAppInterface.getAVNotifyCenter().H0(j3, i17, (int) j16);
        if (i17 == i3) {
            qQAppInterface.getAVNotifyCenter().a1(2, j3, i17, Q2.f73812f, Q2.f73813g, Q2.f73811e, Q2.f73809c > 0 ? 23 : 21, Q2.f73809c);
            Q3 = qQAppInterface.getAVNotifyCenter().Q(j3, i17);
            if (Q3 != null) {
            }
        }
        if (j16 > 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x024a  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b L(int relationType, long relationId, int avType, long memberNum) {
        QQAppInterface qQAppInterface;
        int i3;
        String s16;
        String str;
        String str2;
        int i16;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (b) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(relationType), Long.valueOf(relationId), Integer.valueOf(avType), Long.valueOf(memberNum));
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            AVNotifyCenter.h w3 = qQAppInterface.getAVNotifyCenter().w(relationType, relationId);
            if (w3 == null) {
                int i17 = this.uinType;
                if (i17 == 3000) {
                    Context context = this.context;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context = null;
                    }
                    str4 = context.getString(R.string.f170262kk);
                    str3 = "format(format, *args)";
                } else if (i17 == 1) {
                    str3 = "format(format, *args)";
                    str4 = w(true, relationId, avType, i17, memberNum);
                } else {
                    str3 = "format(format, *args)";
                    str4 = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Intrinsics.checkNotNull(str4);
                str = String.format(str4, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, str3);
                if (avType == 2 && memberNum > 99) {
                    str = w(true, relationId, avType, this.uinType, memberNum);
                }
            } else {
                if (w3.f73806b) {
                    String z16 = qQAppInterface.getAVNotifyCenter().z(w3.f73805a);
                    if (z16 == null) {
                        int i18 = this.uinType;
                        if (i18 == 3000) {
                            Context context2 = this.context;
                            if (context2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context2 = null;
                            }
                            str = context2.getString(R.string.f170262kk);
                        } else if (i18 == 1) {
                            Context context3 = this.context;
                            if (context3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context3 = null;
                            }
                            str = context3.getString(R.string.f170226jg);
                        } else {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            Intrinsics.checkNotNull(str);
                            str = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        }
                        if (avType == 2 && memberNum > 99) {
                            Context context4 = this.context;
                            if (context4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context4 = null;
                            }
                            str = context4.getString(R.string.f170253kc);
                        }
                    } else {
                        if (memberNum == 1) {
                            Context context5 = this.context;
                            if (context5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context5 = null;
                            }
                            str2 = context5.getString(R.string.f170263kl);
                        } else {
                            int i19 = this.uinType;
                            if (i19 == 3000) {
                                Context context6 = this.context;
                                if (context6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("context");
                                    context6 = null;
                                }
                                str2 = context6.getString(R.string.f170261kj);
                            } else if (i19 == 1) {
                                Context context7 = this.context;
                                if (context7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("context");
                                    context7 = null;
                                }
                                str2 = context7.getString(R.string.f170225jf);
                            } else {
                                str2 = null;
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                Intrinsics.checkNotNull(str2);
                                str2 = String.format(str2, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                            }
                            if (avType == 2 && memberNum > 99) {
                                Context context8 = this.context;
                                if (context8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("context");
                                    context8 = null;
                                }
                                str2 = context8.getString(R.string.f170233jl);
                            }
                        }
                        s16 = z16;
                        str = str2;
                    }
                } else {
                    String valueOf = String.valueOf(w3.f73805a);
                    String valueOf2 = String.valueOf(relationId);
                    if (this.uinType == 1) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    s16 = ac.s(qQAppInterface, valueOf, valueOf2, i3, 0);
                    if (memberNum == 1) {
                        Context context9 = this.context;
                        if (context9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context9 = null;
                        }
                        str = context9.getString(R.string.f170263kl);
                    } else {
                        int i26 = this.uinType;
                        if (i26 == 3000) {
                            Context context10 = this.context;
                            if (context10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context10 = null;
                            }
                            str = context10.getString(R.string.f170261kj);
                        } else if (i26 == 1) {
                            str = w(false, relationId, avType, i26, memberNum);
                        } else {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                            Intrinsics.checkNotNull(str);
                            str = String.format(str, Arrays.copyOf(new Object[]{Long.valueOf(memberNum)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        }
                        if (avType == 2 && memberNum > 99) {
                            str = w(false, relationId, avType, this.uinType, memberNum);
                        }
                    }
                }
                i16 = this.uinType;
                if (i16 != 3000) {
                    TipsBar tipsBar = this.multiVideoStatus;
                    Context context11 = this.context;
                    if (context11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context11 = null;
                    }
                    ba.setAccText(tipsBar, context11.getString(R.string.dc5));
                } else if (i16 == 1) {
                    TipsBar tipsBar2 = this.multiVideoStatus;
                    Context context12 = this.context;
                    if (context12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context12 = null;
                    }
                    ba.setAccText(tipsBar2, context12.getString(R.string.dct), avType);
                }
                b bVar = new b();
                bVar.c(s16);
                bVar.d(str);
                this.isTimeShow = false;
                return bVar;
            }
            s16 = null;
            i16 = this.uinType;
            if (i16 != 3000) {
            }
            b bVar2 = new b();
            bVar2.c(s16);
            bVar2.d(str);
            this.isTimeShow = false;
            return bVar2;
        }
        return new b();
    }

    public final void M(int pUinType, @Nullable String peerUin, @Nullable String extraUin) {
        QQAppInterface qQAppInterface;
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(pUinType), peerUin, extraUin);
            return;
        }
        B();
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            boolean d06 = qQAppInterface.getAVNotifyCenter().d0(peerUin);
            boolean isVideoChatting = qQAppInterface.isVideoChatting();
            qQAppInterface.getAVNotifyCenter().f0();
            boolean k06 = qQAppInterface.getAVNotifyCenter().k0();
            if (d06) {
                i3 = qQAppInterface.getAVNotifyCenter().C(peerUin);
            } else if (isVideoChatting) {
                i3 = qQAppInterface.getAVNotifyCenter().L();
            } else {
                i3 = 0;
            }
            String str = L;
            int N2 = qQAppInterface.getAVNotifyCenter().N();
            boolean f06 = qQAppInterface.getAVNotifyCenter().f0();
            boolean k07 = qQAppInterface.getAVNotifyCenter().k0();
            int type = getType();
            com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
            Context context = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                cVar = null;
            }
            QLog.w(str, 1, "refreshVideoStatus, uinType[" + pUinType + "], peerUin[" + peerUin + "], extraUin[" + extraUin + "], sessionType[" + i3 + "], isOtherTerminalAvChatting[" + d06 + "], isVideoChatting[" + isVideoChatting + "], SmallScreenState[" + N2 + "], isReceiver[" + f06 + "], isWaitingState[" + k07 + "], type[" + type + "], currentType[" + cVar.b() + "]");
            if ((isVideoChatting && !qQAppInterface.getAVNotifyCenter().c0() && ((i3 == 1 || i3 == 2) && this.uinType == pUinType && (Intrinsics.areEqual(this.mPeerUin, peerUin) || Intrinsics.areEqual(this.mPeerUin, extraUin)))) || (d06 && Intrinsics.areEqual(this.mPeerUin, peerUin))) {
                if (d06) {
                    TipsBar tipsBar = this.multiVideoStatus;
                    Context context2 = this.context;
                    if (context2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context2 = null;
                    }
                    ba.setAccText(tipsBar, context2.getString(R.string.f171213d90));
                } else if (isVideoChatting) {
                    if (pUinType == 1) {
                        TipsBar tipsBar2 = this.multiVideoStatus;
                        Context context3 = this.context;
                        if (context3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context3 = null;
                        }
                        ba.setAccText(tipsBar2, context3.getString(R.string.f170489sp), qQAppInterface.getAVNotifyCenter().l(qQAppInterface.getAVNotifyCenter().n()));
                    } else {
                        TipsBar tipsBar3 = this.multiVideoStatus;
                        Context context4 = this.context;
                        if (context4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context4 = null;
                        }
                        ba.setAccText(tipsBar3, context4.getString(R.string.f170489sp));
                    }
                }
                String str2 = "";
                if (d06) {
                    if (i3 == 1) {
                        Context context5 = this.context;
                        if (context5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            context5 = null;
                        }
                        str2 = context5.getResources().getString(R.string.f171213d90);
                        Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr\u2026_another_terminal_online)");
                    }
                    if (i3 == 2) {
                        Context context6 = this.context;
                        if (context6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                        } else {
                            context = context6;
                        }
                        str2 = context.getResources().getString(R.string.dlq);
                        Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr\u2026_another_terminal_online)");
                    }
                } else if (isVideoChatting) {
                    if (k06) {
                        Context context7 = this.context;
                        if (context7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                        } else {
                            context = context7;
                        }
                        str2 = context.getResources().getString(R.string.dmu);
                        Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr\u2026.string.qav_waiting_text)");
                    } else if (i3 != 1) {
                        if (i3 == 2) {
                            Context context8 = this.context;
                            if (context8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                            } else {
                                context = context8;
                            }
                            str2 = context.getResources().getString(R.string.dm5);
                            Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr\u2026.string.qav_video_online)");
                        }
                    } else {
                        Context context9 = this.context;
                        if (context9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                        } else {
                            context = context9;
                        }
                        str2 = context.getResources().getString(R.string.d99);
                        Intrinsics.checkNotNullExpressionValue(str2, "context.resources.getStr\u2026.string.qav_audio_online)");
                    }
                }
                String str3 = str2;
                O(null, str3, peerUin, 0, "");
                QLog.i(L, 1, "refreshVideoStatus info=" + str3 + ", peerUin=" + peerUin);
                if (isVideoChatting && !d06) {
                    if (qQAppInterface.getAVNotifyCenter().N() != 3) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    S(z18);
                    z16 = true;
                } else {
                    z16 = true;
                    S(true);
                }
                if (isVideoChatting && !qQAppInterface.getAVNotifyCenter().k0()) {
                    z17 = z16;
                } else {
                    z17 = false;
                }
                this.isTimeShow = z17;
                return;
            }
            z();
        }
    }

    public final void N(long delayMillis) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, delayMillis);
            return;
        }
        MqqHandler mqqHandler = null;
        if (this.refreshRunnable == null) {
            this.refreshRunnable = new RefreshMultiStateRunnable(this);
        } else {
            MqqHandler mqqHandler2 = this.uiHandler;
            if (mqqHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
                mqqHandler2 = null;
            }
            mqqHandler2.removeCallbacks(this.refreshRunnable);
        }
        MqqHandler mqqHandler3 = this.uiHandler;
        if (mqqHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiHandler");
        } else {
            mqqHandler = mqqHandler3;
        }
        mqqHandler.postDelayed(this.refreshRunnable, delayMillis);
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
            qQAppInterface.getAVNotifyCenter().O0(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O(@Nullable String name, @Nullable String info, @Nullable String groupId, int avType, @NotNull String time) {
        QQAppInterface qQAppInterface;
        int i3;
        AVNotifyCenter.i iVar;
        String str;
        TipsBar tipsBar;
        IAIONotificationUIModel.b bVar;
        int i16;
        int i17;
        List split$default;
        List split$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, name, info, groupId, Integer.valueOf(avType), time);
            return;
        }
        Intrinsics.checkNotNullParameter(time, "time");
        StringBuilder sb5 = new StringBuilder();
        com.tencent.qqnt.aio.toptips.c cVar = null;
        if (name != null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            TextView textView = new TextView(context.getApplicationContext());
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            float dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.f159193wz);
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            String E = E(context3, name, textView, dimensionPixelSize);
            textView.setTextSize(14.0f);
            textView.setSingleLine();
            textView.setGravity(5);
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context4 = null;
            }
            textView.setMaxWidth(context4.getResources().getDimensionPixelSize(R.dimen.f158932sr));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(E);
            sb5.append(E);
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference == null || (qQAppInterface = weakReference.get()) == null) {
            return;
        }
        if (avType == 0) {
            try {
                AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
                Long valueOf = Long.valueOf(groupId);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(groupId)");
                i3 = aVNotifyCenter.l(valueOf.longValue());
            } catch (Exception unused) {
                i3 = 0;
            }
        } else {
            i3 = avType;
        }
        try {
            AVNotifyCenter aVNotifyCenter2 = qQAppInterface.getAVNotifyCenter();
            Long valueOf2 = Long.valueOf(groupId);
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(groupId)");
            int l3 = aVNotifyCenter2.l(valueOf2.longValue());
            AVNotifyCenter aVNotifyCenter3 = qQAppInterface.getAVNotifyCenter();
            Long valueOf3 = Long.valueOf(groupId);
            Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(groupId)");
            iVar = aVNotifyCenter3.Q(valueOf3.longValue(), l3);
        } catch (Exception e16) {
            QLog.e(L, 1, "[setMultiText] getVideoRoomInfo error, e = " + e16);
            iVar = null;
        }
        if (info != null) {
            String str2 = qQAppInterface.getAVNotifyCenter().f73768n.get(groupId);
            if (str2 != null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{";"}, false, 0, 6, (Object) null);
                Object[] array = split$default.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Integer valueOf4 = Integer.valueOf(((String[]) array)[0]);
                Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(value.split(\";\").toTypedArray()[0])");
                int intValue = valueOf4.intValue();
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{";"}, false, 0, 6, (Object) null);
                Object[] array2 = split$default2.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                Integer valueOf5 = Integer.valueOf(((String[]) array2)[1]);
                Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(value.split(\";\").toTypedArray()[1])");
                i16 = valueOf5.intValue();
                i17 = intValue;
            } else {
                i16 = 0;
                i17 = 0;
            }
            if (i17 == 1) {
                if (i16 > 99) {
                    Context context5 = this.context;
                    if (context5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context5 = null;
                    }
                    str = context5.getString(R.string.ddp);
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Context context6 = this.context;
                    if (context6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context6 = null;
                    }
                    String string = context6.getString(R.string.ddo);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_statustipbar_multi_tips)");
                    str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                }
            } else if (iVar == null || !iVar.a()) {
                if (i3 == 2) {
                    Context context7 = this.context;
                    if (context7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context7 = null;
                    }
                    String string2 = context7.getString(R.string.f173216i41);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.traffic_group_audio)");
                    Context context8 = this.context;
                    if (context8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                        context8 = null;
                    }
                    String string3 = context8.getString(R.string.f173217i42);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026.traffic_group_broadcast)");
                    str = StringsKt__StringsJVMKt.replace$default(info, string2, string3, false, 4, (Object) null);
                }
            } else if (VideoUtil.i()) {
                Context context9 = this.context;
                if (context9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context9 = null;
                }
                String string4 = context9.getString(R.string.f173216i41);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.traffic_group_audio)");
                Context context10 = this.context;
                if (context10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context10 = null;
                }
                String string5 = context10.getString(R.string.f23228745);
                Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026ideo_in_multi_video_test)");
                str = StringsKt__StringsJVMKt.replace$default(info, string4, string5, false, 4, (Object) null);
            } else {
                Context context11 = this.context;
                if (context11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context11 = null;
                }
                String string6 = context11.getString(R.string.f173216i41);
                Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.string.traffic_group_audio)");
                Context context12 = this.context;
                if (context12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context12 = null;
                }
                String string7 = context12.getString(R.string.f23227744);
                Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri\u2026oup_video_in_multi_video)");
                str = StringsKt__StringsJVMKt.replace$default(info, string6, string7, false, 4, (Object) null);
            }
            sb5.append(str);
            if (this.isTimeShow) {
                sb5.append(" ");
                sb5.append(time);
            }
            tipsBar = this.multiVideoStatus;
            if (tipsBar != null) {
                tipsBar.setTipsText(sb5.toString());
            }
            bVar = this.notification;
            if (bVar == null) {
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "appendStr.toString()");
                bVar.h(sb6);
                com.tencent.qqnt.aio.toptips.c cVar2 = this.topTipsManager;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
                } else {
                    cVar = cVar2;
                }
                Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationManager");
                ((com.tencent.mobileqq.aio.notification.c) cVar).j(bVar.getToken(), bVar);
                return;
            }
            return;
        }
        str = info;
        sb5.append(str);
        if (this.isTimeShow) {
        }
        tipsBar = this.multiVideoStatus;
        if (tipsBar != null) {
        }
        bVar = this.notification;
        if (bVar == null) {
        }
    }

    public final void P(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isTimeShow = z16;
        }
    }

    public final void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i3 = this.uinType;
        String str = this.mPeerUin;
        Intrinsics.checkNotNull(str);
        J("showMeetingInvitedInfo", i3, str, R, 0L);
    }

    public final void S(boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, isVisible);
        } else if (isVisible) {
            Q();
        } else {
            z();
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            cVar = null;
        }
        Context requireContext = cVar.a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "topTipsManager.getAioCon\u2026fragment.requireContext()");
        this.context = requireContext;
        B();
        return this.multiVideoStatus;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.excludeTypes;
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NotNull
    public IAIONotificationUIModel e() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.notification == null) {
            AIONotificationBusiId x16 = x();
            TipsBar tipsBar = this.multiVideoStatus;
            if (tipsBar != null) {
                str = tipsBar.r();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.notification = new IAIONotificationUIModel.b(x16, str, IAIONotificationUIModel.ActionIcon.ARROW, null, 0, new Function2<IAIONotificationUIModel, Integer, Unit>() { // from class: com.tencent.qqnt.aio.toptip.VideoStatusTipsBar$getNotificationUIModel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoStatusTipsBar.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                    invoke(iAIONotificationUIModel, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i3);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                    if (i3 == 1 || i3 == 2) {
                        VideoStatusTipsBar.this.F();
                    }
                }
            }, 24, null);
        }
        IAIONotificationUIModel.b bVar = this.notification;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.IAIONotificationUIModel");
        return bVar;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c tipsManager, int eventType, @NotNull Object... params) {
        QQAppInterface qQAppInterface;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(tipsManager, "tipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        A(tipsManager, eventType);
        w wVar = this.avHelper;
        com.tencent.qqnt.aio.toptips.c cVar = this.topTipsManager;
        Context context = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsManager");
            cVar = null;
        }
        wVar.g(cVar, eventType);
        if (L == null) {
            L = "VideoStatusTipsBar." + this.uinType + "." + this.mPeerUin + "_" + QQAudioHelper.b();
        }
        if (QQAudioHelper.j()) {
            QLog.w(L, 1, "onAIOEvent,eventType[" + eventType + "], uinType[" + this.uinType + "], peerUid[" + StringUtil.getSimpleUinForPrint(this.mPeerUin) + "]");
        }
        long b16 = QQAudioHelper.b();
        int i3 = this.uinType;
        if (i3 != 3000 && i3 != 1) {
            WeakReference<QQAppInterface> weakReference = this.weakApp;
            if (weakReference != null && (qQAppInterface = weakReference.get()) != null) {
                int L2 = qQAppInterface.getAVNotifyCenter().L();
                if (L2 != 1 && L2 != 2) {
                    if (L2 == 3) {
                        if (qQAppInterface.getAVNotifyCenter().i0(this.mPeerUin)) {
                            return;
                        }
                        J("onAIOEvent_2_" + eventType + "." + b16, this.uinType, this.mPeerUin, M, 0L);
                    }
                } else {
                    M(qQAppInterface.getAVNotifyCenter().P(), qQAppInterface.getAVNotifyCenter().F(), qQAppInterface.getAVNotifyCenter().r());
                }
                if (qQAppInterface.getAVNotifyCenter().d0(this.mPeerUin)) {
                    FriendDataServiceImpl service = FriendDataServiceImpl.getService(qQAppInterface);
                    Intrinsics.checkNotNullExpressionValue(service, "getService(app)");
                    if (service.isFriend(this.mPeerUin)) {
                        String str = this.mPeerUin;
                        Intrinsics.checkNotNull(str);
                        if (qQAppInterface.getAVNotifyCenter().d0(str)) {
                            int C = qQAppInterface.getAVNotifyCenter().C(str);
                            if (C == 1) {
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X800478C", "0X800478C", 0, 0, "", "", "", "");
                            }
                            if (C == 2) {
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004788", "0X8004788", 0, 0, "", "", "", "");
                            }
                        }
                        M(0, str, "");
                        try {
                            j3 = Long.parseLong(str);
                        } catch (Exception unused) {
                            j3 = 0;
                        }
                        if (j3 != 0) {
                            long D = qQAppInterface.getAVNotifyCenter().D(str);
                            QLog.w(L, 1, "QueryRoomInfo.notify, eventType[" + eventType + "], roomId[" + D + "], peerUin[" + str + "], seq[" + b16 + "]");
                            Intent intent = new Intent("tencent.video.q2v.sendQueryRoomInfoRequest");
                            intent.putExtra("roomId", D);
                            intent.putExtra("peerUin", Long.parseLong(str));
                            intent.putExtra("uin", qQAppInterface.getAccount());
                            intent.putExtra("seq", b16);
                            Context context2 = this.context;
                            if (context2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                            } else {
                                context = context2;
                            }
                            context.sendBroadcast(intent);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        J("onAIOEvent_1_" + eventType + "." + b16, this.uinType, this.mPeerUin, M, 0L);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        List<AIONotificationBusiId> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AIONotificationBusiId[]{AIONotificationBusiId.AUDIO_VIDEO_CHAT, AIONotificationBusiId.TROOP_LIVE, AIONotificationBusiId.TROOP_CLASS});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 25, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.barPriority;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        g((com.tencent.qqnt.aio.toptips.c) notificationManager, eventType, params);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) v3);
        } else {
            F();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        int i3 = this.uinType;
        String str = this.mPeerUin;
        Intrinsics.checkNotNull(str);
        J("cancelMeetingInvitedInfo", i3, str, R, 0L);
    }

    public final void u() {
        QQAppInterface qQAppInterface;
        AVNotifyCenter aVNotifyCenter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        WeakReference<QQAppInterface> weakReference = this.weakApp;
        if (weakReference != null) {
            qQAppInterface = weakReference.get();
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && (aVNotifyCenter = qQAppInterface.getAVNotifyCenter()) != null) {
            aVNotifyCenter.O0(true);
        }
        J("doRefreshMultiState", this.uinType, this.mPeerUin, M, 0L);
    }
}
