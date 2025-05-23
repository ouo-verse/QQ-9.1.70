package com.tencent.rdelivery.reshub.core;

import android.app.Application;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.standard.file.IRFile;
import com.tencent.raft.standard.log.IRLog;
import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.raft.standard.report.IRReport;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.TargetType;
import com.tencent.rdelivery.reshub.api.j;
import com.tencent.rdelivery.reshub.api.m;
import com.tencent.rdelivery.reshub.api.q;
import com.tencent.rdelivery.reshub.api.r;
import com.tencent.rdelivery.reshub.report.ReportHelper;
import com.tencent.rdelivery.reshub.util.PendingDeleteManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u00e0\u0001\u0010\u00e1\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J0\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0014\u0010\u0016\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013JF\u0010$\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u0012\u0010*\u001a\u00020\u00172\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(J\u0012\u0010+\u001a\u00020\u00172\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b$\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010L\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010S\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b6\u0010P\"\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010a\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010i\u001a\u00020b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010p\u001a\u00020j8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bc\u0010m\"\u0004\bn\u0010oR\"\u0010x\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR#\u0010\u0080\u0001\u001a\u00020y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR(\u0010\u0084\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u0093\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\be\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R)\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u0095\u0001\u0010X\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R*\u0010\u00a0\u0001\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R(\u0010\u00a4\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00a1\u0001\u0010X\u001a\u0006\b\u00a1\u0001\u0010\u0097\u0001\"\u0006\b\u00a2\u0001\u0010\u00a3\u0001R(\u0010\u00a7\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0088\u0001\u0010X\u001a\u0006\b\u00a5\u0001\u0010\u0097\u0001\"\u0006\b\u00a6\u0001\u0010\u00a3\u0001R)\u0010\u00ae\u0001\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R'\u0010\u00b1\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b=\u0010X\u001a\u0006\b\u00af\u0001\u0010\u0097\u0001\"\u0006\b\u00b0\u0001\u0010\u00a3\u0001R'\u0010\u00b4\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b2\u0010X\u001a\u0006\b\u00b2\u0001\u0010\u0097\u0001\"\u0006\b\u00b3\u0001\u0010\u00a3\u0001R*\u0010\u00b9\u0001\u001a\u00030\u00b5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0096\u0001\u001a\u0006\b\u0095\u0001\u0010\u00b6\u0001\"\u0006\b\u00b7\u0001\u0010\u00b8\u0001R'\u0010\u00bb\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00aa\u0001\u0010X\u001a\u0005\bN\u0010\u0097\u0001\"\u0006\b\u00ba\u0001\u0010\u00a3\u0001R&\u0010\u00bd\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bV\u0010X\u001a\u0005\br\u0010\u0097\u0001\"\u0006\b\u00bc\u0001\u0010\u00a3\u0001R'\u0010\u00bf\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0082\u0001\u0010X\u001a\u0005\bk\u0010\u0097\u0001\"\u0006\b\u00be\u0001\u0010\u00a3\u0001R'\u0010\u00c1\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00af\u0001\u0010X\u001a\u0005\bz\u0010\u0097\u0001\"\u0006\b\u00c0\u0001\u0010\u00a3\u0001R(\u0010\u00c3\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u009c\u0001\u0010X\u001a\u0006\b\u0081\u0001\u0010\u0097\u0001\"\u0006\b\u00c2\u0001\u0010\u00a3\u0001R'\u0010\u00c5\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bB\u0010X\u001a\u0006\b\u0086\u0001\u0010\u0097\u0001\"\u0006\b\u00c4\u0001\u0010\u00a3\u0001R(\u0010\u00c7\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00b2\u0001\u0010X\u001a\u0006\b\u00a8\u0001\u0010\u0097\u0001\"\u0006\b\u00c6\u0001\u0010\u00a3\u0001R(\u0010\u00cb\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00c8\u0001\u0010X\u001a\u0006\b\u00c9\u0001\u0010\u0097\u0001\"\u0006\b\u00ca\u0001\u0010\u00a3\u0001R\u0018\u0010\u00cc\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010XR\u0018\u0010\u00cd\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c9\u0001\u0010XR\u0018\u0010\u00cf\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ce\u0001\u0010XR9\u0010\u00d4\u0001\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u00d1\u00010\u00d0\u0001j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u00d1\u0001`\u00d2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u00d3\u0001R-\u0010\u00d9\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00140\u00d5\u0001j\t\u0012\u0004\u0012\u00020\u0014`\u00d6\u00018\u0006\u00a2\u0006\u000f\n\u0005\b|\u0010\u00d7\u0001\u001a\u0006\b\u009a\u0001\u0010\u00d8\u0001R,\u0010\u00db\u0001\u001a\u0005\u0018\u00010\u00da\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00db\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00dd\u0001\"\u0006\b\u00de\u0001\u0010\u00df\u0001\u00a8\u0006\u00e2\u0001"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/j;", "Lcom/tencent/rdelivery/reshub/api/j;", "", "b", "", ExifInterface.LATITUDE_SOUTH, "U", "Landroid/app/Application;", "context", "Lcom/tencent/rdelivery/reshub/api/s;", "params", "Lcom/tencent/raft/standard/net/IRDownload;", "downloadDelegate", "Lcom/tencent/raft/standard/net/IRNetwork;", "networkDelegate", "Lcom/tencent/raft/standard/report/IRReport;", "reportDelegate", "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "Lcom/tencent/rdelivery/reshub/processor/a;", "list", "O", "", "appId", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/rdelivery/reshub/api/TargetType;", "target", MosaicConstants$JsProperty.PROP_ENV, "Liz3/e;", "listener", "Lcom/tencent/rdelivery/reshub/api/f;", "interceptor", "Lcom/tencent/rdelivery/reshub/api/r;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/rdelivery/reshub/api/i;", "a", BdhLogUtil.LogTag.Tag_Req, "P", "T", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "e", "f", "Landroid/app/Application;", "d", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "Lcom/tencent/rdelivery/reshub/api/s;", "w", "()Lcom/tencent/rdelivery/reshub/api/s;", "setParams", "(Lcom/tencent/rdelivery/reshub/api/s;)V", "c", "Lcom/tencent/raft/standard/net/IRDownload;", "i", "()Lcom/tencent/raft/standard/net/IRDownload;", "setDownloadDelegate", "(Lcom/tencent/raft/standard/net/IRDownload;)V", "Lcom/tencent/raft/standard/net/IRNetwork;", "v", "()Lcom/tencent/raft/standard/net/IRNetwork;", "setNetworkDelegate", "(Lcom/tencent/raft/standard/net/IRNetwork;)V", "Lcom/tencent/raft/standard/report/IRReport;", "D", "()Lcom/tencent/raft/standard/report/IRReport;", "setReportDelegate", "(Lcom/tencent/raft/standard/report/IRReport;)V", "Lcom/tencent/rdelivery/reshub/api/c;", "Lcom/tencent/rdelivery/reshub/api/c;", tl.h.F, "()Lcom/tencent/rdelivery/reshub/api/c;", "setDeviceInfo", "(Lcom/tencent/rdelivery/reshub/api/c;)V", "deviceInfo", "Lcom/tencent/raft/standard/storage/IRStorage;", "g", "Lcom/tencent/raft/standard/storage/IRStorage;", "()Lcom/tencent/raft/standard/storage/IRStorage;", "V", "(Lcom/tencent/raft/standard/storage/IRStorage;)V", "configStorageDelegate", "Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;", "Z", "(Lcom/tencent/raft/standard/storage/IRStorage$IRStorageFactory;)V", "rdeliveryConfigStorageFactory", "Lcom/tencent/rdelivery/reshub/api/m;", "Lcom/tencent/rdelivery/reshub/api/m;", "M", "()Lcom/tencent/rdelivery/reshub/api/m;", "d0", "(Lcom/tencent/rdelivery/reshub/api/m;)V", "versionDelegate", "Lcom/tencent/raft/standard/file/IRFile;", "j", "Lcom/tencent/raft/standard/file/IRFile;", "p", "()Lcom/tencent/raft/standard/file/IRFile;", "X", "(Lcom/tencent/raft/standard/file/IRFile;)V", "fileDelegate", "Lcom/tencent/rdelivery/reshub/api/d;", "k", "Lcom/tencent/rdelivery/reshub/api/d;", "()Lcom/tencent/rdelivery/reshub/api/d;", "W", "(Lcom/tencent/rdelivery/reshub/api/d;)V", "downloadStorageDelegate", "Lcom/tencent/rdelivery/reshub/api/l;", "l", "Lcom/tencent/rdelivery/reshub/api/l;", "L", "()Lcom/tencent/rdelivery/reshub/api/l;", "setUnzipConfigDelegate", "(Lcom/tencent/rdelivery/reshub/api/l;)V", "unzipConfigDelegate", "Lcom/tencent/raft/standard/task/IRTask;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/raft/standard/task/IRTask;", "K", "()Lcom/tencent/raft/standard/task/IRTask;", "c0", "(Lcom/tencent/raft/standard/task/IRTask;)V", "taskExecutorDelegate", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setRdeliveryTaskExecutorDelegate", "rdeliveryTaskExecutorDelegate", "Lcom/tencent/raft/standard/log/IRLog;", "o", "Lcom/tencent/raft/standard/log/IRLog;", "t", "()Lcom/tencent/raft/standard/log/IRLog;", "Y", "(Lcom/tencent/raft/standard/log/IRLog;)V", "logDelegate", "Lcom/tencent/rdelivery/reshub/api/k;", "Lcom/tencent/rdelivery/reshub/api/k;", HippyTKDListViewAdapter.X, "()Lcom/tencent/rdelivery/reshub/api/k;", "setPresetResConfigDelegate", "(Lcom/tencent/rdelivery/reshub/api/k;)V", "presetResConfigDelegate", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "J", "()Z", "strictRemoteVersionCheck", "Lcom/tencent/rdelivery/reshub/core/RemoteResFileChangedStrategy;", "r", "Lcom/tencent/rdelivery/reshub/core/RemoteResFileChangedStrategy;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/rdelivery/reshub/core/RemoteResFileChangedStrategy;", "setRemoteResFileChangedStrategy", "(Lcom/tencent/rdelivery/reshub/core/RemoteResFileChangedStrategy;)V", "remoteResFileChangedStrategy", ReportConstant.COSTREPORT_PREFIX, "setInternalInitMMKVForRDelivery", "(Z)V", "internalInitMMKVForRDelivery", "G", "a0", "resetFileBeforeDownload", "u", "Ljava/lang/String;", "y", "()Ljava/lang/String;", "setRdeliveryBundleId", "(Ljava/lang/String;)V", "rdeliveryBundleId", "B", "setRdeliveryTestServer", "rdeliveryTestServer", "E", "setRequestEverySingleRemoteConfig", "requestEverySingleRemoteConfig", "", "()J", "setIgnoreSameRequestInterval", "(J)V", "ignoreSameRequestInterval", "setDebugForceExecuteLoadRequest", "debugForceExecuteLoadRequest", "setEnableCheckAutoPreloadWhenInit", "enableCheckAutoPreloadWhenInit", "setEnableCheckAutoPreloadWhenEnterForeground", "enableCheckAutoPreloadWhenEnterForeground", "setEnableOnceForProcessReport", "enableOnceForProcessReport", "setEnableSampleReport", "enableSampleReport", "setEnableSeparateBuiltInConfigFile", "enableSeparateBuiltInConfigFile", "setNeedFindLoadSpecificResWhenPatch", "needFindLoadSpecificResWhenPatch", UserInfo.SEX_FEMALE, "H", "b0", "setInnerConfigStoreSuffix", "multiProcessMode", "completeCallbackOnMainThread", "I", "progressCallbackOnMainThread", "Ljava/util/HashMap;", "Lcom/tencent/rdelivery/reshub/core/i;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "map", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "injectedProcessor", "Lcom/tencent/rdelivery/reshub/api/q;", "sevenZipDecompressor", "Lcom/tencent/rdelivery/reshub/api/q;", "()Lcom/tencent/rdelivery/reshub/api/q;", "setSevenZipDecompressor", "(Lcom/tencent/rdelivery/reshub/api/q;)V", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class j implements com.tencent.rdelivery.reshub.api.j {

    /* renamed from: A, reason: from kotlin metadata */
    private static boolean enableCheckAutoPreloadWhenEnterForeground;

    /* renamed from: D, reason: from kotlin metadata */
    private static boolean enableSeparateBuiltInConfigFile;

    /* renamed from: E, reason: from kotlin metadata */
    private static boolean needFindLoadSpecificResWhenPatch;

    /* renamed from: F, reason: from kotlin metadata */
    private static boolean setInnerConfigStoreSuffix;

    /* renamed from: G, reason: from kotlin metadata */
    private static boolean multiProcessMode;

    /* renamed from: I, reason: from kotlin metadata */
    private static boolean progressCallbackOnMainThread;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static Application context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static ResHubParams params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static IRDownload downloadDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static IRNetwork networkDelegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static IRReport reportDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IRStorage.IRStorageFactory rdeliveryConfigStorageFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static m versionDelegate;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IRFile fileDelegate;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IRTask rdeliveryTaskExecutorDelegate;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static boolean strictRemoteVersionCheck;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static boolean rdeliveryTestServer;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static boolean requestEverySingleRemoteConfig;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private static boolean debugForceExecuteLoadRequest;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private static boolean enableCheckAutoPreloadWhenInit;
    public static final j L = new j();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.rdelivery.reshub.api.c deviceInfo = new b();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IRStorage configStorageDelegate = new mz3.a();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.rdelivery.reshub.api.d downloadStorageDelegate = new c();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.rdelivery.reshub.api.l unzipConfigDelegate = new d();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IRTask taskExecutorDelegate = new DefaultTaskExecutorDelegateImpl();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IRLog logDelegate = new com.tencent.rdelivery.reshub.util.g();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static com.tencent.rdelivery.reshub.api.k presetResConfigDelegate = new mz3.b();

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static RemoteResFileChangedStrategy remoteResFileChangedStrategy = RemoteResFileChangedStrategy.OVERRIDE;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static boolean internalInitMMKVForRDelivery = true;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static boolean resetFileBeforeDownload = true;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String rdeliveryBundleId = "";

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static long ignoreSameRequestInterval = 10800000;

    /* renamed from: B, reason: from kotlin metadata */
    private static boolean enableOnceForProcessReport = true;

    /* renamed from: C, reason: from kotlin metadata */
    private static boolean enableSampleReport = true;

    /* renamed from: H, reason: from kotlin metadata */
    private static boolean completeCallbackOnMainThread = true;

    /* renamed from: J, reason: from kotlin metadata */
    private static HashMap<String, i> map = new HashMap<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private static final ArrayList<com.tencent.rdelivery.reshub.processor.a> injectedProcessor = new ArrayList<>();

    static {
        int i3 = 1;
        rdeliveryConfigStorageFactory = new MmkvStorage.b(null, i3, 0 == true ? 1 : 0);
        fileDelegate = new com.tencent.rdelivery.reshub.util.f(false, i3, 0 == true ? 1 : 0);
    }

    j() {
    }

    private final void b() {
        if (Q()) {
            return;
        }
        ReportHelper reportHelper = new ReportHelper();
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(10002);
        reportHelper.b(aVar);
        throw new IllegalStateException("ResHub Not Initialized.");
    }

    @Nullable
    public final IRTask A() {
        return rdeliveryTaskExecutorDelegate;
    }

    public final boolean B() {
        return rdeliveryTestServer;
    }

    @NotNull
    public final RemoteResFileChangedStrategy C() {
        return remoteResFileChangedStrategy;
    }

    @NotNull
    public final IRReport D() {
        IRReport iRReport = reportDelegate;
        if (iRReport == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportDelegate");
        }
        return iRReport;
    }

    public final boolean E() {
        return requestEverySingleRemoteConfig;
    }

    @NotNull
    public com.tencent.rdelivery.reshub.api.i F(@NotNull String appId, @NotNull String appKey, @NotNull TargetType target, @NotNull String env, @Nullable iz3.e eVar) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(env, "env");
        return j.a.a(this, appId, appKey, target, env, eVar);
    }

    public final boolean G() {
        return resetFileBeforeDownload;
    }

    public final boolean H() {
        return setInnerConfigStoreSuffix;
    }

    @Nullable
    public final q I() {
        return null;
    }

    public final boolean J() {
        return strictRemoteVersionCheck;
    }

    @NotNull
    public final IRTask K() {
        return taskExecutorDelegate;
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.api.l L() {
        return unzipConfigDelegate;
    }

    @Nullable
    public final m M() {
        return versionDelegate;
    }

    public final void N(@NotNull Application context2, @NotNull ResHubParams params2, @NotNull IRDownload downloadDelegate2, @NotNull IRNetwork networkDelegate2, @NotNull IRReport reportDelegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(params2, "params");
        Intrinsics.checkParameterIsNotNull(downloadDelegate2, "downloadDelegate");
        Intrinsics.checkParameterIsNotNull(networkDelegate2, "networkDelegate");
        Intrinsics.checkParameterIsNotNull(reportDelegate2, "reportDelegate");
        long uptimeMillis = SystemClock.uptimeMillis();
        context = context2;
        params = params2;
        downloadDelegate = downloadDelegate2;
        networkDelegate = networkDelegate2;
        reportDelegate = reportDelegate2;
        if (params2.getMultiProcessMode()) {
            configStorageDelegate = new MmkvStorage("reshub_configs", null, 2, 0 == true ? 1 : 0);
        }
        h.f364427b.a(context2, true, SystemClock.uptimeMillis() - uptimeMillis);
    }

    public final void O(@NotNull List<? extends com.tencent.rdelivery.reshub.processor.a> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        ArrayList<com.tencent.rdelivery.reshub.processor.a> arrayList = injectedProcessor;
        arrayList.clear();
        arrayList.addAll(list);
    }

    public final boolean P() {
        if (S()) {
            ResHubParams resHubParams = params;
            if (resHubParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            return resHubParams.getCompleteCallbackOnMainThread();
        }
        return completeCallbackOnMainThread;
    }

    public final boolean Q() {
        if (context != null && downloadDelegate != null && networkDelegate != null && reportDelegate != null) {
            return true;
        }
        return false;
    }

    public final boolean R() {
        if (S()) {
            ResHubParams resHubParams = params;
            if (resHubParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            if (!resHubParams.getMultiProcessMode() && !multiProcessMode) {
                return false;
            }
            return true;
        }
        return multiProcessMode;
    }

    public final boolean S() {
        if (params != null) {
            return true;
        }
        return false;
    }

    public final boolean T() {
        if (S()) {
            ResHubParams resHubParams = params;
            if (resHubParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            return resHubParams.getProgressCallbackOnMainThread();
        }
        return progressCallbackOnMainThread;
    }

    public final boolean U() {
        if (reportDelegate != null) {
            return true;
        }
        return false;
    }

    public final void V(@NotNull IRStorage iRStorage) {
        Intrinsics.checkParameterIsNotNull(iRStorage, "<set-?>");
        configStorageDelegate = iRStorage;
    }

    public final void W(@NotNull com.tencent.rdelivery.reshub.api.d dVar) {
        Intrinsics.checkParameterIsNotNull(dVar, "<set-?>");
        downloadStorageDelegate = dVar;
    }

    public final void X(@NotNull IRFile iRFile) {
        Intrinsics.checkParameterIsNotNull(iRFile, "<set-?>");
        fileDelegate = iRFile;
    }

    public final void Y(@NotNull IRLog iRLog) {
        Intrinsics.checkParameterIsNotNull(iRLog, "<set-?>");
        logDelegate = iRLog;
    }

    public final void Z(@NotNull IRStorage.IRStorageFactory iRStorageFactory) {
        Intrinsics.checkParameterIsNotNull(iRStorageFactory, "<set-?>");
        rdeliveryConfigStorageFactory = iRStorageFactory;
    }

    @Override // com.tencent.rdelivery.reshub.api.j
    @NotNull
    public synchronized com.tencent.rdelivery.reshub.api.i a(@NotNull String appId, @NotNull String appKey, @NotNull TargetType target, @NotNull String env, @Nullable iz3.e listener, @Nullable com.tencent.rdelivery.reshub.api.f interceptor, @Nullable r extraParams) {
        i iVar;
        String str;
        String str2;
        String str3;
        String str4;
        ResHubParams resHubParams;
        ResHubParams resHubParams2;
        ResHubParams resHubParams3;
        ResHubParams resHubParams4;
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(env, "env");
        b();
        PendingDeleteManager.f364584c.o();
        String str5 = appId + target.name() + env;
        HashMap<String, i> hashMap = map;
        iVar = hashMap.get(str5);
        if (iVar == null) {
            String str6 = null;
            if (extraParams != null) {
                str = extraParams.getBusinessSetName();
            } else {
                str = null;
            }
            if (extraParams != null && (resHubParams4 = extraParams.getResHubParams()) != null) {
                str2 = resHubParams4.getLocalPresetPath();
            } else {
                str2 = null;
            }
            if (extraParams != null && (resHubParams3 = extraParams.getResHubParams()) != null) {
                str3 = resHubParams3.getAppVersion();
            } else {
                str3 = null;
            }
            if (extraParams != null && (resHubParams2 = extraParams.getResHubParams()) != null) {
                str4 = resHubParams2.getConfigStoreSuffix();
            } else {
                str4 = null;
            }
            if (extraParams != null && (resHubParams = extraParams.getResHubParams()) != null) {
                str6 = resHubParams.getDeviceId();
            }
            i iVar2 = new i(new a(appId, appKey, target, env, str, str2, str3, str4, str6), listener, extraParams);
            if (interceptor != null) {
                iVar2.z(interceptor);
            }
            hashMap.put(str5, iVar2);
            iVar = iVar2;
        }
        return iVar;
    }

    public final void a0(boolean z16) {
        resetFileBeforeDownload = z16;
    }

    public final void b0(boolean z16) {
        setInnerConfigStoreSuffix = z16;
    }

    @NotNull
    public final IRStorage c() {
        return configStorageDelegate;
    }

    public final void c0(@NotNull IRTask iRTask) {
        Intrinsics.checkParameterIsNotNull(iRTask, "<set-?>");
        taskExecutorDelegate = iRTask;
    }

    @NotNull
    public final Application d() {
        Application application = context;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return application;
    }

    public final void d0(@Nullable m mVar) {
        versionDelegate = mVar;
    }

    @NotNull
    public final String e(@Nullable a appInfo) {
        String str;
        String appVersion;
        if (S()) {
            ResHubParams resHubParams = params;
            if (resHubParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            str = resHubParams.getAppVersion();
        } else {
            str = "";
        }
        if (appInfo != null && (appVersion = appInfo.getAppVersion()) != null) {
            return appVersion;
        }
        return str;
    }

    @NotNull
    public final String f(@Nullable a appInfo) {
        String str;
        String str2;
        if (S()) {
            ResHubParams resHubParams = params;
            if (resHubParams == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }
            str = resHubParams.getDeviceId();
        } else {
            str = "";
        }
        if (appInfo != null && (str2 = appInfo.getCom.tencent.bugly.common.constants.Constants.SP_DEVICE_ID java.lang.String()) != null) {
            return str2;
        }
        return str;
    }

    public final boolean g() {
        return debugForceExecuteLoadRequest;
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.api.c h() {
        return deviceInfo;
    }

    @NotNull
    public final IRDownload i() {
        IRDownload iRDownload = downloadDelegate;
        if (iRDownload == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadDelegate");
        }
        return iRDownload;
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.api.d j() {
        return downloadStorageDelegate;
    }

    public final boolean k() {
        return enableCheckAutoPreloadWhenEnterForeground;
    }

    public final boolean l() {
        return enableCheckAutoPreloadWhenInit;
    }

    public final boolean m() {
        return enableOnceForProcessReport;
    }

    public final boolean n() {
        return enableSampleReport;
    }

    public final boolean o() {
        return enableSeparateBuiltInConfigFile;
    }

    @NotNull
    public final IRFile p() {
        return fileDelegate;
    }

    public final long q() {
        return ignoreSameRequestInterval;
    }

    @NotNull
    public final ArrayList<com.tencent.rdelivery.reshub.processor.a> r() {
        return injectedProcessor;
    }

    public final boolean s() {
        return internalInitMMKVForRDelivery;
    }

    @NotNull
    public final IRLog t() {
        return logDelegate;
    }

    public final boolean u() {
        return needFindLoadSpecificResWhenPatch;
    }

    @NotNull
    public final IRNetwork v() {
        IRNetwork iRNetwork = networkDelegate;
        if (iRNetwork == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkDelegate");
        }
        return iRNetwork;
    }

    @NotNull
    public final ResHubParams w() {
        ResHubParams resHubParams = params;
        if (resHubParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }
        return resHubParams;
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.api.k x() {
        return presetResConfigDelegate;
    }

    @NotNull
    public final String y() {
        return rdeliveryBundleId;
    }

    @NotNull
    public final IRStorage.IRStorageFactory z() {
        return rdeliveryConfigStorageFactory;
    }
}
