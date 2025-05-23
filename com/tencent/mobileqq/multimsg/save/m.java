package com.tencent.mobileqq.multimsg.save;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.multisave.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001M\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0003VWXB\u0011\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u001c\u0010\u001a\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018J\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0003J\u0014\u0010(\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*J\u0018\u0010/\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010\u001c2\u0006\u0010.\u001a\u00020\u001eJ\u001e\u00101\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\b\u00102\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00104\u001a\u000203H\u0016J&\u00108\u001a\u00020\u00032\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fR \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010B\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010CR\u0016\u0010E\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010CR\u0016\u0010F\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010CR\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/m;", "Lmqq/manager/Manager;", "Landroid/os/Handler$Callback;", "", "v", "l", "Lcom/tencent/mobileqq/multimsg/save/d;", "fileSaveResult", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Dialog;", "dialog", "B", "y", "", "Lcom/tencent/mobileqq/multimsg/save/m$b;", "reqList", "", "isNeedTipsFileSize", HippyTKDListViewAdapter.X, QQBrowserActivity.KEY_MSG_TYPE, "", "sourcePath", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "p", "w", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "req", "i", "j", "o", tl.h.F, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/multimsg/save/f;", "callBack", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "key", "fileTransNotifyInfo", "G", "fileSaveReqList", BdhLogUtil.LogTag.Tag_Conn, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Message;", "msg", "handleMessage", AdMetricTag.Report.TYPE, "curType", "t", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/multimsg/save/m$c;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "existFileReqMap", "e", "unExistFileReqMap", "f", "Lcom/tencent/mobileqq/multimsg/save/f;", "saveCallBack", "Z", "isPartSaveFail", "isPartSaveSuccess", "isWholeSaving", "J", "totalFileLength", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "mHandler", "com/tencent/mobileqq/multimsg/save/m$e", "E", "Lcom/tencent/mobileqq/multimsg/save/m$e;", "msgListner", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", UserInfo.SEX_FEMALE, "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class m implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long totalFileLength;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Handler mHandler;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e msgListner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, c> existFileReqMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, c> unExistFileReqMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f saveCallBack;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPartSaveFail;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPartSaveSuccess;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isWholeSaving;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/m$a;", "", "", "CANCEL_TAG", "Ljava/lang/String;", "", "CANCEL_TYPE_REPORT", "I", "FILE_PIC", "", "FILE_TIPS_SIZE", "J", "FILE_VIDEO", "KB", "MB", "MULTI_RICH_MEDIA_TRANSFER_STATUS_DOWNLOADING", "MULTI_RICH_MEDIA_TRANSFER_STATUS_FAIL", "MULTI_RICH_MEDIA_TRANSFER_STATUS_PART_FAIL", "MULTI_RICH_MEDIA_TRANSFER_STATUS_SUCCESS", "PIC", "SAVE_TAG", "SAVE_TYPE_REPORT", "TAG", "VIDEO", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multimsg.save.m$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/m$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "J", "()J", "fileSize", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "richMediaElementGetReq", "<init>", "(IJLcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int msgType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long fileSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RichMediaElementGetReq richMediaElementGetReq;

        public b(int i3, long j3, @NotNull RichMediaElementGetReq richMediaElementGetReq) {
            Intrinsics.checkNotNullParameter(richMediaElementGetReq, "richMediaElementGetReq");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), richMediaElementGetReq);
                return;
            }
            this.msgType = i3;
            this.fileSize = j3;
            this.richMediaElementGetReq = richMediaElementGetReq;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.fileSize;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.msgType;
        }

        @NotNull
        public final RichMediaElementGetReq c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RichMediaElementGetReq) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.richMediaElementGetReq;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.msgType == bVar.msgType && this.fileSize == bVar.fileSize && Intrinsics.areEqual(this.richMediaElementGetReq, bVar.richMediaElementGetReq)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.msgType * 31) + androidx.fragment.app.a.a(this.fileSize)) * 31) + this.richMediaElementGetReq.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "MultiReachMediaMsgItemADownloadReq(msgType=" + this.msgType + ", fileSize=" + this.fileSize + ", richMediaElementGetReq=" + this.richMediaElementGetReq + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/m$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", QQBrowserActivity.KEY_MSG_TYPE, "", "J", "()J", "fileSize", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "richMediaElementGetReq", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "notifyInfo", "<init>", "(IJLcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int msgType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long fileSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RichMediaElementGetReq richMediaElementGetReq;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private FileTransNotifyInfo notifyInfo;

        public c(int i3, long j3, @NotNull RichMediaElementGetReq richMediaElementGetReq, @NotNull FileTransNotifyInfo notifyInfo) {
            Intrinsics.checkNotNullParameter(richMediaElementGetReq, "richMediaElementGetReq");
            Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), richMediaElementGetReq, notifyInfo);
                return;
            }
            this.msgType = i3;
            this.fileSize = j3;
            this.richMediaElementGetReq = richMediaElementGetReq;
            this.notifyInfo = notifyInfo;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.fileSize;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.msgType;
        }

        @NotNull
        public final FileTransNotifyInfo c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (FileTransNotifyInfo) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.notifyInfo;
        }

        @NotNull
        public final RichMediaElementGetReq d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RichMediaElementGetReq) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.richMediaElementGetReq;
        }

        public final void e(@NotNull FileTransNotifyInfo fileTransNotifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileTransNotifyInfo);
            } else {
                Intrinsics.checkNotNullParameter(fileTransNotifyInfo, "<set-?>");
                this.notifyInfo = fileTransNotifyInfo;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.msgType == cVar.msgType && this.fileSize == cVar.fileSize && Intrinsics.areEqual(this.richMediaElementGetReq, cVar.richMediaElementGetReq) && Intrinsics.areEqual(this.notifyInfo, cVar.notifyInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return (((((this.msgType * 31) + androidx.fragment.app.a.a(this.fileSize)) * 31) + this.richMediaElementGetReq.hashCode()) * 31) + this.notifyInfo.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "MultiReachMediaMsgItemADownloadState(msgType=" + this.msgType + ", fileSize=" + this.fileSize + ", richMediaElementGetReq=" + this.richMediaElementGetReq + ", notifyInfo=" + this.notifyInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/multimsg/save/m$d", "Lcom/tencent/mobileqq/filemanager/multisave/a$a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements a.InterfaceC7581a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileTransNotifyInfo f251725b;

        d(FileTransNotifyInfo fileTransNotifyInfo) {
            this.f251725b = fileTransNotifyInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) fileTransNotifyInfo);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.multisave.a.InterfaceC7581a
        public void onError(int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (QLog.isColorLevel()) {
                QLog.e("NTMultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + errorCode + " ,errorMsg = " + errorMsg);
            }
            o oVar = o.f251729a;
            FileTransNotifyInfo fileTransNotifyInfo = this.f251725b;
            com.tencent.mobileqq.multimsg.save.d d16 = oVar.d(oVar.e(fileTransNotifyInfo.msgId, fileTransNotifyInfo.msgElementId), m.this.unExistFileReqMap);
            d16.f251679b = -1;
            d16.f251680c = errorCode;
            d16.f251681d = errorMsg;
            m.this.z(d16);
        }

        @Override // com.tencent.mobileqq.filemanager.multisave.a.InterfaceC7581a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Handler handler = m.this.mHandler;
                Intrinsics.checkNotNull(handler);
                Message obtainMessage = handler.obtainMessage(1);
                Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler!!.obtainMessage\u2026ts.MSG_TYPE_SAVE_SUCCESS)");
                o oVar = o.f251729a;
                FileTransNotifyInfo fileTransNotifyInfo = this.f251725b;
                com.tencent.mobileqq.multimsg.save.d d16 = oVar.d(oVar.e(fileTransNotifyInfo.msgId, fileTransNotifyInfo.msgElementId), m.this.unExistFileReqMap);
                d16.f251679b = 0;
                obtainMessage.obj = d16;
                Handler handler2 = m.this.mHandler;
                Intrinsics.checkNotNull(handler2);
                handler2.sendMessage(obtainMessage);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/multimsg/save/m$e", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) notifyInfo);
            } else {
                m.this.w(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(@Nullable FileTransNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) notifyInfo);
            } else if (notifyInfo != null) {
                m.this.G(o.f251729a.e(notifyInfo.msgId, notifyInfo.msgElementId), notifyInfo);
                m.this.k();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m(@Nullable QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.existFileReqMap = new ConcurrentHashMap<>();
        this.unExistFileReqMap = new ConcurrentHashMap<>();
        this.msgListner = new e();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    private final void B(Activity activity, Dialog dialog) {
        if (dialog != null && activity != null && !activity.isFinishing()) {
            try {
                dialog.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("NTMultiRichMediaSaveManager", 2, "showDialogSafe exception: " + th5.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(List list, m this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            this$0.x(list, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(m this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(m this$0, Activity activity, Dialog dialog) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.B(activity, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        int i3;
        long j3;
        ConcurrentHashMap<String, c> concurrentHashMap = this.existFileReqMap;
        if (concurrentHashMap == null || this.unExistFileReqMap == null) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = concurrentHashMap.entrySet().iterator();
        long j16 = 0;
        while (it.hasNext()) {
            j16 += it.next().getValue().a();
        }
        Iterator<Map.Entry<String, c>> it5 = this.unExistFileReqMap.entrySet().iterator();
        while (true) {
            i3 = 0;
            if (!it5.hasNext()) {
                break;
            }
            c value = it5.next().getValue();
            if (value.c().trasferStatus == 4) {
                i3 = 1;
            }
            if (i3 != 0) {
                j3 = value.a();
            } else {
                j3 = value.c().fileProgress;
            }
            j16 += j3;
        }
        long j17 = this.totalFileLength;
        if (j17 > 0) {
            i3 = (int) ((j16 * 100) / j17);
        }
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "calculateWholeProgress totalProgress = " + i3);
        }
        f fVar = this.saveCallBack;
        if (fVar != null) {
            fVar.b(i3);
        }
    }

    private final void l() {
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "cancelDownloading");
        }
        if (this.unExistFileReqMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.unExistFileReqMap.entrySet().iterator();
        while (it.hasNext()) {
            c value = it.next().getValue();
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.cancelGetRichMediaElement(value.d());
            }
        }
    }

    private final int q() {
        if (this.unExistFileReqMap.isEmpty()) {
            return 1;
        }
        boolean z16 = false;
        boolean z17 = false;
        for (Map.Entry<String, c> entry : this.unExistFileReqMap.entrySet()) {
            entry.getKey();
            int i3 = entry.getValue().c().trasferStatus;
            if (i3 != 4) {
                if (i3 != 5) {
                    return 0;
                }
                z17 = true;
            } else {
                z16 = true;
            }
        }
        if (z16 && !z17) {
            return 1;
        }
        if (!z16 && z17) {
            return 2;
        }
        if (!z16 || !z17) {
            return 1;
        }
        return 3;
    }

    private final long r() {
        this.totalFileLength = 0L;
        if (!this.unExistFileReqMap.isEmpty()) {
            Iterator<Map.Entry<String, c>> it = this.unExistFileReqMap.entrySet().iterator();
            while (it.hasNext()) {
                c value = it.next().getValue();
                if (value != null) {
                    this.totalFileLength += value.a();
                }
            }
        }
        if (!this.existFileReqMap.isEmpty()) {
            Iterator<Map.Entry<String, c>> it5 = this.existFileReqMap.entrySet().iterator();
            while (it5.hasNext()) {
                c value2 = it5.next().getValue();
                if (value2 != null) {
                    this.totalFileLength += value2.a();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "getTotalFileLength totalFileLength = " + this.totalFileLength);
        }
        return this.totalFileLength;
    }

    private final void u() {
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "saveBegin");
        }
        this.isWholeSaving = true;
        this.totalFileLength = r();
        f fVar = this.saveCallBack;
        if (fVar != null) {
            fVar.c();
        }
    }

    private final void v() {
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "saveCancel");
        }
        f fVar = this.saveCallBack;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.a();
        }
        this.totalFileLength = 0L;
    }

    private final void y() {
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "saveTips");
        }
        f fVar = this.saveCallBack;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(com.tencent.mobileqq.multimsg.save.d fileSaveResult) {
        Handler handler = this.mHandler;
        Intrinsics.checkNotNull(handler);
        Message obtainMessage = handler.obtainMessage(2);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "mHandler!!.obtainMessage\u2026tants.MSG_TYPE_SAVE_FAIL)");
        obtainMessage.obj = fileSaveResult;
        Handler handler2 = this.mHandler;
        Intrinsics.checkNotNull(handler2);
        handler2.sendMessage(obtainMessage);
    }

    public final void A(@NotNull f callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) callBack);
        } else {
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            this.saveCallBack = callBack;
        }
    }

    public final void C(@NotNull final Activity activity, @Nullable final List<b> fileSaveReqList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) fileSaveReqList);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f173078h45), activity.getString(R.string.f173077h44), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.multimsg.save.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.D(fileSaveReqList, this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.multimsg.save.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.E(m.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026 { _, _ -> saveCancel() }");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            B(activity, createCustomDialog);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.multimsg.save.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.F(m.this, activity, createCustomDialog);
                }
            });
        }
    }

    public final boolean G(@Nullable String key, @NotNull FileTransNotifyInfo fileTransNotifyInfo) {
        ConcurrentHashMap<String, c> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) key, (Object) fileTransNotifyInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(fileTransNotifyInfo, "fileTransNotifyInfo");
        QLog.i("NTMultiRichMediaSaveManager", 1, "updateFileSaveResult key= " + key);
        if (!TextUtils.isEmpty(key) && (concurrentHashMap = this.unExistFileReqMap) != null) {
            Intrinsics.checkNotNull(key);
            if (concurrentHashMap.containsKey(key)) {
                QLog.i("NTMultiRichMediaSaveManager", 1, "notifyInfo key= " + key);
                c cVar = this.unExistFileReqMap.get(key);
                if (cVar != null) {
                    cVar.e(fileTransNotifyInfo);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final void h(@NotNull List<b> reqList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) reqList);
            return;
        }
        Intrinsics.checkNotNullParameter(reqList, "reqList");
        for (b bVar : reqList) {
            if (o.f251729a.f(bVar)) {
                i(bVar);
            } else {
                j(bVar);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            int q16 = q();
            if (q16 != 1) {
                if (q16 != 2) {
                    if (q16 == 3) {
                        w e16 = com.tencent.qqnt.msg.f.e();
                        if (e16 != null) {
                            e16.removeMsgListener(this.msgListner);
                        }
                        f fVar = this.saveCallBack;
                        if (fVar != null) {
                            fVar.e(3);
                        }
                    }
                } else {
                    w e17 = com.tencent.qqnt.msg.f.e();
                    if (e17 != null) {
                        e17.removeMsgListener(this.msgListner);
                    }
                    f fVar2 = this.saveCallBack;
                    if (fVar2 != null) {
                        fVar2.e(-1);
                    }
                }
            } else {
                w e18 = com.tencent.qqnt.msg.f.e();
                if (e18 != null) {
                    e18.removeMsgListener(this.msgListner);
                }
                f fVar3 = this.saveCallBack;
                if (fVar3 != null) {
                    fVar3.e(0);
                }
            }
        }
        return true;
    }

    public final void i(@NotNull b req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        this.existFileReqMap.put(o.f251729a.e(req.c().msgId, req.c().elementId), new c(req.b(), req.a(), req.c(), new FileTransNotifyInfo()));
    }

    public final void j(@NotNull b req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        this.unExistFileReqMap.put(o.f251729a.e(req.c().msgId, req.c().elementId), new c(req.b(), req.a(), req.c(), new FileTransNotifyInfo()));
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            l();
            n();
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, "clearFileSaveRequest");
        }
        o();
        this.saveCallBack = null;
        this.isPartSaveFail = false;
        this.isPartSaveSuccess = false;
        this.isWholeSaving = false;
        this.totalFileLength = 0L;
        Handler handler = this.mHandler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.existFileReqMap.clear();
            this.unExistFileReqMap.clear();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NTMultiRichMediaSaveManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        v();
        l();
        n();
    }

    public final void p(int msgType, @NotNull String sourcePath, @NotNull FileTransNotifyInfo notifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(msgType), sourcePath, notifyInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        File file = new File(sourcePath);
        if (msgType != 0) {
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType == 3) {
                        o.f251729a.k(sourcePath, new d(notifyInfo));
                        return;
                    }
                    return;
                }
            } else {
                o oVar = o.f251729a;
                String name = file.getName();
                Handler handler = this.mHandler;
                Intrinsics.checkNotNull(handler);
                oVar.j(sourcePath, name, notifyInfo, handler);
                return;
            }
        }
        o oVar2 = o.f251729a;
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "tempFile.name");
        Handler handler2 = this.mHandler;
        Intrinsics.checkNotNull(handler2);
        oVar2.i(sourcePath, name2, notifyInfo, handler2);
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.saveCallBack = null;
        }
    }

    public final void t(@Nullable List<b> fileSaveReqList, int reportType, int curType) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, fileSaveReqList, Integer.valueOf(reportType), Integer.valueOf(curType));
            return;
        }
        if (fileSaveReqList != null && !fileSaveReqList.isEmpty()) {
            if (reportType != 1) {
                if (reportType != 2) {
                    str = "";
                } else {
                    str = "0X8009F8A";
                }
            } else {
                str = "0X8009F89";
            }
            Iterator<b> it = fileSaveReqList.iterator();
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (it.hasNext()) {
                int b16 = it.next().b();
                if (b16 != 0) {
                    if (b16 != 1) {
                        if (b16 != 2) {
                            if (b16 == 3) {
                                i17++;
                            }
                        } else {
                            i18++;
                        }
                    } else {
                        i19++;
                    }
                } else {
                    i16++;
                }
            }
            if (curType != 1) {
                if (curType != 2) {
                    if (curType == 3) {
                        i3 = 3;
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 1;
            }
            if (!TextUtils.isEmpty(str)) {
                int i26 = i17;
                int i27 = i18;
                int i28 = i19;
                ReportController.o(null, "dc00898", "", "", str, str, i3, 0, String.valueOf(i16), String.valueOf(i19), String.valueOf(i18), String.valueOf(i17));
                if (QLog.isColorLevel()) {
                    QLog.d("NTMultiRichMediaSaveManager", 2, "reportSaveMultiFile reportTag = " + str + ", fromType = " + i3 + ", picCount = " + i16 + ", videoCount = " + i28 + ", filePicCount = " + i27 + ", fileVideoCount = " + i26);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTMultiRichMediaSaveManager", 2, "reportSaveMultiFile fileSaveReqList is empty!");
        }
    }

    public final void w(@Nullable FileTransNotifyInfo notifyInfo) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) notifyInfo);
            return;
        }
        if (notifyInfo == null || notifyInfo.fileDownType != 1) {
            return;
        }
        String e16 = o.f251729a.e(notifyInfo.msgId, notifyInfo.msgElementId);
        if (!G(e16, notifyInfo)) {
            return;
        }
        if (notifyInfo.fileErrCode == 0 && (cVar = this.unExistFileReqMap.get(e16)) != null) {
            int b16 = cVar.b();
            String str = cVar.c().filePath;
            Intrinsics.checkNotNullExpressionValue(str, "it.notifyInfo.filePath");
            p(b16, str, notifyInfo);
        }
        k();
    }

    public final void x(@NotNull List<b> reqList, boolean isNeedTipsFileSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, reqList, Boolean.valueOf(isNeedTipsFileSize));
            return;
        }
        Intrinsics.checkNotNullParameter(reqList, "reqList");
        if (reqList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("NTMultiRichMediaSaveManager", 2, "saveMultiRichMedialFile fileSaveReqList is empty!");
                return;
            }
            return;
        }
        if (isNeedTipsFileSize && o.f251729a.g(reqList)) {
            y();
            return;
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(this.msgListner);
        }
        o();
        h(reqList);
        u();
        k();
        for (b bVar : reqList) {
            if (o.f251729a.f(bVar)) {
                int b16 = bVar.b();
                String str = bVar.c().filePath;
                Intrinsics.checkNotNullExpressionValue(str, "req.richMediaElementGetReq.filePath");
                p(b16, str, new FileTransNotifyInfo());
            } else {
                w e17 = com.tencent.qqnt.msg.f.e();
                if (e17 != null) {
                    e17.getRichMediaElement(bVar.c());
                }
            }
        }
    }
}
