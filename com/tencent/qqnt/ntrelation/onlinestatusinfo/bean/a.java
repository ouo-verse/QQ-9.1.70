package com.tencent.qqnt.ntrelation.onlinestatusinfo.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u0005\n\u0003\b\u0087\u0001\b\u0086\b\u0018\u0000 \u00b2\u00012\u00020\u0001:\u0001\fB\u00bc\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0015\u0012\b\b\u0002\u00103\u001a\u00020,\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010J\u001a\u00020\u0015\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u0012\b\b\u0002\u0010P\u001a\u00020\u0004\u0012\b\b\u0002\u0010T\u001a\u00020\u0004\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010h\u001a\u00020\u0015\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010q\u001a\u00020\u0004\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0015\u0012\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u0015\u0012\t\b\u0002\u0010\u00a0\u0001\u001a\u00020\u0015\u0012\t\b\u0002\u0010\u00a3\u0001\u001a\u00020\u0015\u0012\u000b\b\u0002\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u00ac\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u00af\u0001\u001a\u00020\u0015\u00a2\u0006\u0006\b\u00b0\u0001\u0010\u00b1\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\"\u00103\u001a\u00020,8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\"\u0010;\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R$\u0010>\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u000b\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010\u000fR\"\u0010J\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0017\u001a\u0004\bH\u0010\u0019\"\u0004\bI\u0010\u001bR\"\u0010M\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001e\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R\"\u0010P\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u001e\u001a\u0004\bN\u0010 \"\u0004\bO\u0010\"R\"\u0010T\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u001e\u001a\u0004\bR\u0010 \"\u0004\bS\u0010\"R$\u0010X\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\bY\u0010\r\"\u0004\bZ\u0010\u000fR$\u0010^\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u000b\u001a\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000fR$\u0010b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\u000b\u001a\u0004\b`\u0010\r\"\u0004\ba\u0010\u000fR$\u0010e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u000b\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010\u000fR\"\u0010h\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u0017\u001a\u0004\bf\u0010\u0019\"\u0004\bg\u0010\u001bR$\u0010k\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u000b\u001a\u0004\bi\u0010\r\"\u0004\bj\u0010\u000fR$\u0010n\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000fR\"\u0010q\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001e\u001a\u0004\bo\u0010 \"\u0004\bp\u0010\"R$\u0010t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010\u000b\u001a\u0004\br\u0010\r\"\u0004\bs\u0010\u000fR$\u0010w\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u000b\u001a\u0004\bu\u0010\r\"\u0004\bv\u0010\u000fR$\u0010{\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010\u000b\u001a\u0004\by\u0010\r\"\u0004\bz\u0010\u000fR$\u0010}\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u000b\u001a\u0004\b|\u0010\r\"\u0004\b$\u0010\u000fR$\u0010\u007f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b~\u0010\r\"\u0004\b(\u0010\u000fR'\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b\u000e\u0010\u000b\u001a\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000fR&\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\b\u0013\u0010\u000b\u001a\u0005\b\u0083\u0001\u0010\r\"\u0004\b\n\u0010\u000fR'\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u0085\u0001\u0010\u000b\u001a\u0005\b\u0086\u0001\u0010\r\"\u0004\b\u0011\u0010\u000fR(\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u000b\u001a\u0005\b\u0089\u0001\u0010\r\"\u0005\b\u008a\u0001\u0010\u000fR'\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u008c\u0001\u0010\u000b\u001a\u0005\b\u008d\u0001\u0010\r\"\u0004\b\u0016\u0010\u000fR&\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bm\u0010\u000b\u001a\u0005\b\u008f\u0001\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u0092\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bp\u0010\u001e\u001a\u0005\b\u0091\u0001\u0010 \"\u0004\bG\u0010\"R$\u0010\u0094\u0001\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bv\u0010\u0017\u001a\u0005\b\u0093\u0001\u0010\u0019\"\u0004\bC\u0010\u001bR&\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bz\u0010\u000b\u001a\u0005\b\u0095\u0001\u0010\r\"\u0004\b?\u0010\u000fR'\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\ba\u0010\u000b\u001a\u0005\b\u0097\u0001\u0010\r\"\u0005\b\u0085\u0001\u0010\u000fR'\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bZ\u0010\u000b\u001a\u0005\b\u0099\u0001\u0010\r\"\u0005\b\u0088\u0001\u0010\u000fR'\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b]\u0010\u000b\u001a\u0005\b\u009b\u0001\u0010\r\"\u0005\b\u008c\u0001\u0010\u000fR$\u0010\u009e\u0001\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bg\u0010\u0017\u001a\u0005\b\u009d\u0001\u0010\u0019\"\u0004\b-\u0010\u001bR$\u0010\u00a0\u0001\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0005\b\u009f\u0001\u0010\u0017\u001a\u0004\b.\u0010\u0019\"\u0004\bU\u0010\u001bR%\u0010\u00a3\u0001\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u00a1\u0001\u0010\u0017\u001a\u0005\b\u00a2\u0001\u0010\u0019\"\u0004\bQ\u0010\u001bR'\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u00a4\u0001\u0010\u000b\u001a\u0005\b\u00a5\u0001\u0010\r\"\u0004\bx\u0010\u000fR'\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u00a7\u0001\u0010\u000b\u001a\u0005\b\u00a8\u0001\u0010\r\"\u0004\b4\u0010\u000fR%\u0010\u00ac\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u00aa\u0001\u0010\u001e\u001a\u0005\b\u00ab\u0001\u0010 \"\u0004\b8\u0010\"R%\u0010\u00af\u0001\u001a\u00020\u00158\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u00ad\u0001\u0010\u0017\u001a\u0005\b\u00ae\u0001\u0010\u0019\"\u0004\b_\u0010\u001b\u00a8\u0006\u00b3\u0001"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "x0", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b1", "(Ljava/lang/String;)V", "uid", "y0", "f0", "c1", "uin", "", "z0", "J", "b", "()J", "r0", "(J)V", "abilityBits", "A0", "I", "y", "()I", "K0", "(I)V", "iBatteryStatus", "B0", BdhLogUtil.LogTag.Tag_Conn, "O0", "netTypeIconId", "C0", "e0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "uExtOnlineStatus", "", "D0", "B", "u", "()B", "G0", "(B)V", "detalStatusFlag", "E0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "L0", "iTermType", "F0", "E", "P0", "netWork", "V", "U0", IOnlineStatusService.SONG_ID, "H0", "Z", "V0", "songName", "I0", "G", "R0", "singerName", "J0", "N", "T0", "songEndTime", "b0", "X0", "songSourceType", "a0", "W0", "songPauseRemainTime", "M0", "M", "S0", "songDuration", "N0", "d0", "Z0", "temper", "o0", "l1", "weatherType", "p0", "m1", "weatherTypeId", "Q0", "n0", "k1", "weatherTip", "c", "s0", "adCode", "q0", ICustomDataEditor.NUMBER_PARAM_1, "weatherUpdateTime", "f", "u0", "city", "j0", "g1", "weatherDecs", "k0", "h1", "weatherFlag", "e", "t0", GdtGetUserInfoHandler.KEY_AREA, "l0", "i1", "weatherIconKey", "Y0", "m0", "j1", "weatherPrompt", "p", "constellationTodayTrend", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "constellationTomorrowTrend", "j", "v0", "constellationBgImageUrl", "l", "constellationIconUrl", "d1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "constellationJumpUrl", "e1", "k", "w0", "constellationDateStr", "f1", DomainData.DOMAIN_NAME, "constellationLuckyColor", "o", "constellationLuckyNumber", HippyTKDListViewAdapter.X, "diyEmoType", "w", "diyEmoSeverId", "v", "diyDesc", "g0", "videoId", "h0", "videoName", "i0", AppConstants.Key.KEY_QZONE_VIDEO_URL, "r", "curOlympicRank", "o1", "lastLoginType", "p1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lastLoginClient", "q1", "c0", "strTermDesc", "r1", ReportConstant.COSTREPORT_PREFIX, "customOnlineStatus", ICustomDataEditor.STRING_PARAM_1, "t", "customOnlineStatusType", "t1", UserInfo.SEX_FEMALE, "setTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;JIIJBIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;IJ)V", "u1", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: u1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A0, reason: from kotlin metadata */
    private int iBatteryStatus;

    /* renamed from: B0, reason: from kotlin metadata */
    private int netTypeIconId;

    /* renamed from: C0, reason: from kotlin metadata */
    private long uExtOnlineStatus;

    /* renamed from: D0, reason: from kotlin metadata */
    private byte detalStatusFlag;

    /* renamed from: E0, reason: from kotlin metadata */
    private int iTermType;

    /* renamed from: F0, reason: from kotlin metadata */
    private int netWork;

    /* renamed from: G0, reason: from kotlin metadata */
    @Nullable
    private String songId;

    /* renamed from: H0, reason: from kotlin metadata */
    @Nullable
    private String songName;

    /* renamed from: I0, reason: from kotlin metadata */
    @Nullable
    private String singerName;

    /* renamed from: J0, reason: from kotlin metadata */
    private long songEndTime;

    /* renamed from: K0, reason: from kotlin metadata */
    private int songSourceType;

    /* renamed from: L0, reason: from kotlin metadata */
    private int songPauseRemainTime;

    /* renamed from: M0, reason: from kotlin metadata */
    private int songDuration;

    /* renamed from: N0, reason: from kotlin metadata */
    @Nullable
    private String temper;

    /* renamed from: O0, reason: from kotlin metadata */
    @Nullable
    private String weatherType;

    /* renamed from: P0, reason: from kotlin metadata */
    @Nullable
    private String weatherTypeId;

    /* renamed from: Q0, reason: from kotlin metadata */
    @Nullable
    private String weatherTip;

    /* renamed from: R0, reason: from kotlin metadata */
    @Nullable
    private String adCode;

    /* renamed from: S0, reason: from kotlin metadata */
    private long weatherUpdateTime;

    /* renamed from: T0, reason: from kotlin metadata */
    @Nullable
    private String city;

    /* renamed from: U0, reason: from kotlin metadata */
    @Nullable
    private String weatherDecs;

    /* renamed from: V0, reason: from kotlin metadata */
    private int weatherFlag;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private String area;

    /* renamed from: X0, reason: from kotlin metadata */
    @Nullable
    private String weatherIconKey;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private String weatherPrompt;

    /* renamed from: Z0, reason: from kotlin metadata */
    @Nullable
    private String constellationTodayTrend;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationTomorrowTrend;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationBgImageUrl;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationIconUrl;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationJumpUrl;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationDateStr;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationLuckyColor;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationLuckyNumber;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    private int diyEmoType;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    private long diyEmoSeverId;

    /* renamed from: j1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String diyDesc;

    /* renamed from: k1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoId;

    /* renamed from: l1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoName;

    /* renamed from: m1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoUrl;

    /* renamed from: n1, reason: collision with root package name and from kotlin metadata */
    private long curOlympicRank;

    /* renamed from: o1, reason: collision with root package name and from kotlin metadata */
    private long lastLoginType;

    /* renamed from: p1, reason: collision with root package name and from kotlin metadata */
    private long lastLoginClient;

    /* renamed from: q1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String strTermDesc;

    /* renamed from: r1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String customOnlineStatus;

    /* renamed from: s1, reason: collision with root package name and from kotlin metadata */
    private int customOnlineStatusType;

    /* renamed from: t1, reason: collision with root package name and from kotlin metadata */
    private long setTime;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private long abilityBits;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a$a;", "", "", "CLIENT_DEFAULT", "I", "CLIENT_IPHONE", "CLIENT_MOBILE", "CLIENT_PC", "TERM_TYPE_HRTX_IPHONE", "TERM_TYPE_MOBILE_IPAD_NEW", "TERM_TYPE_MOBILE_IPHONE", "TERM_TYPE_MOBILE_WINPHONE_NEW", "TERM_TYPE_WINPHONE", "TYPE_FROM_CHAT", "TYPE_FROM_CONTACT", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 155)) {
            redirector.redirect((short) 155);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(null, null, 0L, 0, 0, 0L, (byte) 0, 0, 0, null, null, null, 0L, 0, 0, 0, null, null, null, null, null, 0L, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, null, null, null, 0L, 0L, 0L, null, null, 0, 0L, -1, 131071, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 154)) {
            return;
        }
        iPatchRedirector.redirect((short) 154, (Object) this);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Long) iPatchRedirector.redirect((short) 91, (Object) this)).longValue();
        }
        return this.lastLoginClient;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void A0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) str);
        } else {
            this.constellationLuckyNumber = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Long) iPatchRedirector.redirect((short) 89, (Object) this)).longValue();
        }
        return this.lastLoginType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void B0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        } else {
            this.constellationTodayTrend = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.netTypeIconId;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void C0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) str);
        } else {
            this.constellationTomorrowTrend = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void D0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, j3);
        } else {
            this.curOlympicRank = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.netWork;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void E0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) str);
        } else {
            this.customOnlineStatus = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Long) iPatchRedirector.redirect((short) 99, (Object) this)).longValue();
        }
        return this.setTime;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void F0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, i3);
        } else {
            this.customOnlineStatusType = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.singerName;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void G0(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Byte.valueOf(b16));
        } else {
            this.detalStatusFlag = b16;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void H0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) str);
        } else {
            this.diyDesc = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void I0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, j3);
        } else {
            this.diyEmoSeverId = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void J0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3);
        } else {
            this.diyEmoType = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void K0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.iBatteryStatus = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void L0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.iTermType = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.songDuration;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void M0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, j3);
        } else {
            this.lastLoginClient = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.songEndTime;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void N0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, j3);
        } else {
            this.lastLoginType = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void O0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.netTypeIconId = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void P0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.netWork = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void Q0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, j3);
        } else {
            this.setTime = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void R0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.singerName = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void S0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.songDuration = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void T0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.songEndTime = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void U0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.songId = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.songId;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void V0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.songName = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void W0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.songPauseRemainTime = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void X0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.songSourceType = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void Y0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) str);
        } else {
            this.strTermDesc = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.songName;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void Z0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            this.temper = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c, com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a */
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.songPauseRemainTime;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void a1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.uExtOnlineStatus = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.abilityBits;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.songSourceType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void b1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.adCode;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (String) iPatchRedirector.redirect((short) 93, (Object) this);
        }
        return this.strTermDesc;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void c1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.temper;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void d1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
        } else {
            this.videoId = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return this.area;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.uExtOnlineStatus;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void e1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) str);
        } else {
            this.videoName = str;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            return ((Boolean) iPatchRedirector.redirect((short) 153, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Intrinsics.areEqual(getUid(), aVar.getUid()) && Intrinsics.areEqual(f0(), aVar.f0()) && b() == aVar.b() && y() == aVar.y() && C() == aVar.C() && e0() == aVar.e0() && u() == aVar.u() && z() == aVar.z() && E() == aVar.E() && Intrinsics.areEqual(V(), aVar.V()) && Intrinsics.areEqual(Z(), aVar.Z()) && Intrinsics.areEqual(G(), aVar.G()) && N() == aVar.N() && b0() == aVar.b0() && a0() == aVar.a0() && M() == aVar.M() && Intrinsics.areEqual(d0(), aVar.d0()) && Intrinsics.areEqual(o0(), aVar.o0()) && Intrinsics.areEqual(p0(), aVar.p0()) && Intrinsics.areEqual(n0(), aVar.n0()) && Intrinsics.areEqual(c(), aVar.c()) && q0() == aVar.q0() && Intrinsics.areEqual(f(), aVar.f()) && Intrinsics.areEqual(j0(), aVar.j0()) && k0() == aVar.k0() && Intrinsics.areEqual(e(), aVar.e()) && Intrinsics.areEqual(l0(), aVar.l0()) && Intrinsics.areEqual(m0(), aVar.m0()) && Intrinsics.areEqual(p(), aVar.p()) && Intrinsics.areEqual(q(), aVar.q()) && Intrinsics.areEqual(j(), aVar.j()) && Intrinsics.areEqual(l(), aVar.l()) && Intrinsics.areEqual(m(), aVar.m()) && Intrinsics.areEqual(k(), aVar.k()) && Intrinsics.areEqual(n(), aVar.n()) && Intrinsics.areEqual(o(), aVar.o()) && x() == aVar.x() && w() == aVar.w() && Intrinsics.areEqual(v(), aVar.v()) && Intrinsics.areEqual(g0(), aVar.g0()) && Intrinsics.areEqual(h0(), aVar.h0()) && Intrinsics.areEqual(i0(), aVar.i0()) && r() == aVar.r() && B() == aVar.B() && A() == aVar.A() && Intrinsics.areEqual(c0(), aVar.c0()) && Intrinsics.areEqual(s(), aVar.s()) && t() == aVar.t() && F() == aVar.F();
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.city;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @NotNull
    public String f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void f1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) str);
        } else {
            this.videoUrl = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (String) iPatchRedirector.redirect((short) 81, (Object) this);
        }
        return this.videoId;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void g1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
        } else {
            this.weatherDecs = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (String) iPatchRedirector.redirect((short) 83, (Object) this);
        }
        return this.videoName;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void h1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.weatherFlag = i3;
        }
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        int hashCode19;
        int hashCode20;
        int hashCode21;
        int hashCode22;
        int hashCode23;
        int hashCode24;
        int hashCode25;
        int hashCode26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            return ((Integer) iPatchRedirector.redirect((short) 152, (Object) this)).intValue();
        }
        int hashCode27 = ((((((((((((((((getUid().hashCode() * 31) + f0().hashCode()) * 31) + androidx.fragment.app.a.a(b())) * 31) + y()) * 31) + C()) * 31) + androidx.fragment.app.a.a(e0())) * 31) + u()) * 31) + z()) * 31) + E()) * 31;
        int i3 = 0;
        if (V() == null) {
            hashCode = 0;
        } else {
            hashCode = V().hashCode();
        }
        int i16 = (hashCode27 + hashCode) * 31;
        if (Z() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = Z().hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        if (G() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = G().hashCode();
        }
        int a16 = (((((((((i17 + hashCode3) * 31) + androidx.fragment.app.a.a(N())) * 31) + b0()) * 31) + a0()) * 31) + M()) * 31;
        if (d0() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = d0().hashCode();
        }
        int i18 = (a16 + hashCode4) * 31;
        if (o0() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = o0().hashCode();
        }
        int i19 = (i18 + hashCode5) * 31;
        if (p0() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = p0().hashCode();
        }
        int i26 = (i19 + hashCode6) * 31;
        if (n0() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = n0().hashCode();
        }
        int i27 = (i26 + hashCode7) * 31;
        if (c() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = c().hashCode();
        }
        int a17 = (((i27 + hashCode8) * 31) + androidx.fragment.app.a.a(q0())) * 31;
        if (f() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = f().hashCode();
        }
        int i28 = (a17 + hashCode9) * 31;
        if (j0() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = j0().hashCode();
        }
        int k06 = (((i28 + hashCode10) * 31) + k0()) * 31;
        if (e() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = e().hashCode();
        }
        int i29 = (k06 + hashCode11) * 31;
        if (l0() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = l0().hashCode();
        }
        int i36 = (i29 + hashCode12) * 31;
        if (m0() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = m0().hashCode();
        }
        int i37 = (i36 + hashCode13) * 31;
        if (p() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = p().hashCode();
        }
        int i38 = (i37 + hashCode14) * 31;
        if (q() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = q().hashCode();
        }
        int i39 = (i38 + hashCode15) * 31;
        if (j() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = j().hashCode();
        }
        int i46 = (i39 + hashCode16) * 31;
        if (l() == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = l().hashCode();
        }
        int i47 = (i46 + hashCode17) * 31;
        if (m() == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = m().hashCode();
        }
        int i48 = (i47 + hashCode18) * 31;
        if (k() == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = k().hashCode();
        }
        int i49 = (i48 + hashCode19) * 31;
        if (n() == null) {
            hashCode20 = 0;
        } else {
            hashCode20 = n().hashCode();
        }
        int i56 = (i49 + hashCode20) * 31;
        if (o() == null) {
            hashCode21 = 0;
        } else {
            hashCode21 = o().hashCode();
        }
        int x16 = (((((i56 + hashCode21) * 31) + x()) * 31) + androidx.fragment.app.a.a(w())) * 31;
        if (v() == null) {
            hashCode22 = 0;
        } else {
            hashCode22 = v().hashCode();
        }
        int i57 = (x16 + hashCode22) * 31;
        if (g0() == null) {
            hashCode23 = 0;
        } else {
            hashCode23 = g0().hashCode();
        }
        int i58 = (i57 + hashCode23) * 31;
        if (h0() == null) {
            hashCode24 = 0;
        } else {
            hashCode24 = h0().hashCode();
        }
        int i59 = (i58 + hashCode24) * 31;
        if (i0() == null) {
            hashCode25 = 0;
        } else {
            hashCode25 = i0().hashCode();
        }
        int a18 = (((((((i59 + hashCode25) * 31) + androidx.fragment.app.a.a(r())) * 31) + androidx.fragment.app.a.a(B())) * 31) + androidx.fragment.app.a.a(A())) * 31;
        if (c0() == null) {
            hashCode26 = 0;
        } else {
            hashCode26 = c0().hashCode();
        }
        int i65 = (a18 + hashCode26) * 31;
        if (s() != null) {
            i3 = s().hashCode();
        }
        return ((((i65 + i3) * 31) + t()) * 31) + androidx.fragment.app.a.a(F());
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (String) iPatchRedirector.redirect((short) 85, (Object) this);
        }
        return this.videoUrl;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void i1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str);
        } else {
            this.weatherIconKey = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return this.constellationBgImageUrl;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.weatherDecs;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void j1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            this.weatherPrompt = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (String) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return this.constellationDateStr;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.weatherFlag;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void k1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            this.weatherTip = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (String) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.constellationIconUrl;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.weatherIconKey;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void l1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        } else {
            this.weatherType = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (String) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        return this.constellationJumpUrl;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.weatherPrompt;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void m1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        } else {
            this.weatherTypeId = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (String) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return this.constellationLuckyColor;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.weatherTip;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void n1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, j3);
        } else {
            this.weatherUpdateTime = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (String) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        return this.constellationLuckyNumber;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.weatherType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.constellationTodayTrend;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.weatherTypeId;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this.constellationTomorrowTrend;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Long) iPatchRedirector.redirect((short) 45, (Object) this)).longValue();
        }
        return this.weatherUpdateTime;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Long) iPatchRedirector.redirect((short) 87, (Object) this)).longValue();
        }
        return this.curOlympicRank;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void r0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.abilityBits = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (String) iPatchRedirector.redirect((short) 95, (Object) this);
        }
        return this.customOnlineStatus;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void s0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        } else {
            this.adCode = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Integer) iPatchRedirector.redirect((short) 97, (Object) this)).intValue();
        }
        return this.customOnlineStatusType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void t0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
        } else {
            this.area = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (String) iPatchRedirector.redirect((short) 101, (Object) this);
        }
        return super.toString();
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public byte u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Byte) iPatchRedirector.redirect((short) 15, (Object) this)).byteValue();
        }
        return this.detalStatusFlag;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void u0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            this.city = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    @Nullable
    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.diyDesc;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void v0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
        } else {
            this.constellationBgImageUrl = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Long) iPatchRedirector.redirect((short) 77, (Object) this)).longValue();
        }
        return this.diyEmoSeverId;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void w0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        } else {
            this.constellationDateStr = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        return this.diyEmoType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void x0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        } else {
            this.constellationIconUrl = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.iBatteryStatus;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void y0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
        } else {
            this.constellationJumpUrl = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.iTermType;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c
    public void z0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        } else {
            this.constellationLuckyColor = str;
        }
    }

    public /* synthetic */ a(String str, String str2, long j3, int i3, int i16, long j16, byte b16, int i17, int i18, String str3, String str4, String str5, long j17, int i19, int i26, int i27, String str6, String str7, String str8, String str9, String str10, long j18, String str11, String str12, int i28, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i29, long j19, String str24, String str25, String str26, String str27, long j26, long j27, long j28, String str28, String str29, int i36, long j29, int i37, int i38, DefaultConstructorMarker defaultConstructorMarker) {
        this((i37 & 1) != 0 ? "" : str, (i37 & 2) != 0 ? "" : str2, (i37 & 4) != 0 ? 0L : j3, (i37 & 8) != 0 ? 0 : i3, (i37 & 16) != 0 ? 0 : i16, (i37 & 32) != 0 ? 0L : j16, (i37 & 64) != 0 ? (byte) 0 : b16, (i37 & 128) != 0 ? 0 : i17, (i37 & 256) != 0 ? 0 : i18, (i37 & 512) != 0 ? "" : str3, (i37 & 1024) != 0 ? "" : str4, (i37 & 2048) != 0 ? "" : str5, (i37 & 4096) != 0 ? 0L : j17, (i37 & 8192) != 0 ? 0 : i19, (i37 & 16384) != 0 ? 0 : i26, (i37 & 32768) != 0 ? 0 : i27, (i37 & 65536) != 0 ? "" : str6, (i37 & 131072) != 0 ? "" : str7, (i37 & 262144) != 0 ? "" : str8, (i37 & 524288) != 0 ? "" : str9, (i37 & 1048576) != 0 ? "" : str10, (i37 & 2097152) != 0 ? 0L : j18, (i37 & 4194304) != 0 ? "" : str11, (i37 & 8388608) != 0 ? "" : str12, (i37 & 16777216) != 0 ? 0 : i28, (i37 & 33554432) != 0 ? "" : str13, (i37 & 67108864) != 0 ? "" : str14, (i37 & 134217728) != 0 ? "" : str15, (i37 & 268435456) != 0 ? "" : str16, (i37 & 536870912) != 0 ? "" : str17, (i37 & 1073741824) != 0 ? "" : str18, (i37 & Integer.MIN_VALUE) != 0 ? "" : str19, (i38 & 1) != 0 ? "" : str20, (i38 & 2) != 0 ? "" : str21, (i38 & 4) != 0 ? "" : str22, (i38 & 8) != 0 ? "" : str23, (i38 & 16) != 0 ? 0 : i29, (i38 & 32) != 0 ? 0L : j19, (i38 & 64) != 0 ? "" : str24, (i38 & 128) != 0 ? "" : str25, (i38 & 256) != 0 ? "" : str26, (i38 & 512) != 0 ? "" : str27, (i38 & 1024) != 0 ? -1L : j26, (i38 & 2048) != 0 ? 0L : j27, (i38 & 4096) != 0 ? 0L : j28, (i38 & 8192) != 0 ? "" : str28, (i38 & 16384) == 0 ? str29 : "", (32768 & i38) != 0 ? 0 : i36, (i38 & 65536) != 0 ? 0L : j29);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), str3, str4, str5, Long.valueOf(j17), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), str6, str7, str8, str9, str10, Long.valueOf(j18), str11, str12, Integer.valueOf(i28), str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, Integer.valueOf(i29), Long.valueOf(j19), str24, str25, str26, str27, Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), str28, str29, Integer.valueOf(i36), Long.valueOf(j29), Integer.valueOf(i37), Integer.valueOf(i38), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uid, @NotNull String uin, long j3, int i3, int i16, long j16, byte b16, int i17, int i18, @Nullable String str, @Nullable String str2, @Nullable String str3, long j17, int i19, int i26, int i27, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, long j18, @Nullable String str9, @Nullable String str10, int i28, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @Nullable String str21, int i29, long j19, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25, long j26, long j27, long j28, @Nullable String str26, @Nullable String str27, int i36, long j29) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, uin, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), str, str2, str3, Long.valueOf(j17), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), str4, str5, str6, str7, str8, Long.valueOf(j18), str9, str10, Integer.valueOf(i28), str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, Integer.valueOf(i29), Long.valueOf(j19), str22, str23, str24, str25, Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), str26, str27, Integer.valueOf(i36), Long.valueOf(j29));
            return;
        }
        this.uid = uid;
        this.uin = uin;
        this.abilityBits = j3;
        this.iBatteryStatus = i3;
        this.netTypeIconId = i16;
        this.uExtOnlineStatus = j16;
        this.detalStatusFlag = b16;
        this.iTermType = i17;
        this.netWork = i18;
        this.songId = str;
        this.songName = str2;
        this.singerName = str3;
        this.songEndTime = j17;
        this.songSourceType = i19;
        this.songPauseRemainTime = i26;
        this.songDuration = i27;
        this.temper = str4;
        this.weatherType = str5;
        this.weatherTypeId = str6;
        this.weatherTip = str7;
        this.adCode = str8;
        this.weatherUpdateTime = j18;
        this.city = str9;
        this.weatherDecs = str10;
        this.weatherFlag = i28;
        this.area = str11;
        this.weatherIconKey = str12;
        this.weatherPrompt = str13;
        this.constellationTodayTrend = str14;
        this.constellationTomorrowTrend = str15;
        this.constellationBgImageUrl = str16;
        this.constellationIconUrl = str17;
        this.constellationJumpUrl = str18;
        this.constellationDateStr = str19;
        this.constellationLuckyColor = str20;
        this.constellationLuckyNumber = str21;
        this.diyEmoType = i29;
        this.diyEmoSeverId = j19;
        this.diyDesc = str22;
        this.videoId = str23;
        this.videoName = str24;
        this.videoUrl = str25;
        this.curOlympicRank = j26;
        this.lastLoginType = j27;
        this.lastLoginClient = j28;
        this.strTermDesc = str26;
        this.customOnlineStatus = str27;
        this.customOnlineStatusType = i36;
        this.setTime = j29;
    }
}
