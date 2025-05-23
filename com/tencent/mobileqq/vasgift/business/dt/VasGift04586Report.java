package com.tencent.mobileqq.vasgift.business.dt;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oh2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0003\b\u0089\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\u0006\u0010K\u001a\u00020$\u00a2\u0006\u0006\b\u00c9\u0001\u0010\u00ca\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J~\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\f\u0010%\u001a\u00020\u000b*\u00020$H\u0002J\f\u0010&\u001a\u00020\u000b*\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\u0016\u0010+\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0002J\f\u0010,\u001a\u00020\u0004*\u00020\u0006H\u0002J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020\u0002J\u0006\u0010/\u001a\u00020\u0002J\u0016\u00100\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0016\u00101\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u001e\u00104\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004J&\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010:\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bJ\u0016\u0010;\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bJ\u000e\u0010<\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010=\u001a\u00020\u0002J\u000e\u0010>\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010?\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010@\u001a\u00020\u0002J\u0006\u0010A\u001a\u00020\u0002J\u0012\u0010C\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010D\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010E\u001a\u00020\u0002H\u0016J\b\u0010F\u001a\u00020\u0002H\u0016J \u0010G\u001a\u00020\u00022\u0006\u00106\u001a\u0002052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010K\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\bE\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bF\u0010LR\u0014\u0010N\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010LR\u0014\u0010O\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bD\u0010LR\u0014\u0010P\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bG\u0010LR\u0014\u0010R\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bQ\u0010LR\u0014\u0010T\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bS\u0010LR\u0014\u0010V\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bU\u0010LR\u0014\u0010X\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bW\u0010LR\u0014\u0010Z\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bY\u0010LR\u0014\u0010\\\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b[\u0010LR\u0014\u0010^\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b]\u0010LR\u0014\u0010a\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0014\u0010e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010g\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bf\u0010LR\u0014\u0010i\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bh\u0010LR\u0014\u0010k\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bj\u0010LR\u0014\u0010m\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bl\u0010LR\u0014\u0010o\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bn\u0010LR\u0014\u0010q\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bp\u0010LR\u0014\u0010s\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\br\u0010LR\u0014\u0010u\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bt\u0010LR\u0014\u0010w\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bv\u0010LR\u0014\u0010y\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bx\u0010LR\u0014\u0010{\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bz\u0010LR\u0014\u0010}\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b|\u0010LR\u0014\u0010\u007f\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b~\u0010LR\u0016\u0010\u0081\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010LR\u0016\u0010\u0083\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010LR\u0016\u0010\u0085\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010LR\u0016\u0010\u0087\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010LR\u0016\u0010\u0089\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010LR\u0016\u0010\u008b\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010LR\u0015\u0010\u008c\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b`\u0010LR\u0016\u0010\u008e\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010LR\u0016\u0010\u0090\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010LR\u0016\u0010\u0092\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010LR\u0016\u0010\u0094\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010LR\u0016\u0010\u0096\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010LR\u0016\u0010\u0098\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010LR\u0016\u0010\u009a\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010LR\u0016\u0010\u009c\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010LR\u0016\u0010\u009e\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010LR\u0016\u0010\u00a0\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010LR\u0016\u0010\u00a2\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010LR\u0016\u0010\u00a4\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010LR\u0016\u0010\u00a6\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010LR\u0016\u0010\u00a8\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u0010LR\u0016\u0010\u00aa\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00a9\u0001\u0010LR\u0016\u0010\u00ac\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00ab\u0001\u0010LR\u0016\u0010\u00ae\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00ad\u0001\u0010LR\u0016\u0010\u00b0\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00af\u0001\u0010LR\u0016\u0010\u00b2\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00b1\u0001\u0010LR\u0016\u0010\u00b4\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0007\n\u0005\b\u00b3\u0001\u0010LR\u0015\u0010\u00b5\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010LR\u0015\u0010\u00b6\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b4\u0010LR\u0015\u0010\u00b7\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010LR\u0015\u0010\u00b8\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u0010LR\u0015\u0010\u00b9\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010LR\u0015\u0010\u00ba\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b@\u0010LR\u0015\u0010\u00bb\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bA\u0010LR\u0015\u0010\u00bc\u0001\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010LR\u0015\u0010\u00bd\u0001\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010`R\u0015\u0010\u00be\u0001\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010`R\u0017\u0010\u00c1\u0001\u001a\u00030\u00bf\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0005\u0010\u00c0\u0001R\u0017\u0010\u00c2\u0001\u001a\u00030\u00bf\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b'\u0010\u00c0\u0001R(\u0010\u00c6\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00040\u00c3\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u00c4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b(\u0010\u00c5\u0001R\u0018\u0010\u00c7\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b#\u0010\u00ad\u0001R\u0018\u0010\u00c8\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u008d\u0001\u00a8\u0006\u00cb\u0001"}, d2 = {"Lcom/tencent/mobileqq/vasgift/business/dt/VasGift04586Report;", "Lnh2/b;", "", "z0", "", "n0", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "position", "y0", "w0", "", "reportTime", "h0", "code", "f0", "", "balance", "E0", "authCode", "L0", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "actionId", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", "H0", "l0", "q0", "Lcom/tencent/mobileqq/vasgift/mvvm/business/QQGiftPanelViewModel;", "k0", "m0", "o0", "p0", "Lkotlin/Function0;", "block", "J0", "d0", "C0", "v0", "s0", "u0", "t0", "validComboCount", "allComboCount", "e0", "", "isSuccess", "g0", "tabName", "tabID", "B0", "K0", "A0", "D0", "G0", "F0", "i0", "j0", "name", "c", "d", "a", "b", "e", "Lcom/tencent/mobileqq/vasgift/mvvm/business/QQGiftPanelViewModel;", "r0", "()Lcom/tencent/mobileqq/vasgift/mvvm/business/QQGiftPanelViewModel;", "viewModel", "Ljava/lang/String;", "TAG", "GIFT_PANEL_APP_ID", "SUB_MODULE_ID_BANNER_ACTIVITY", "SUB_MODULE_ID_CHOOSE_FRIEND", "f", "SUB_MODULE_ID_GIFT_DESC", "g", "SUB_MODULE_ID_GIFT_ITEMS", h.F, "SUB_MODULE_ID_TAB", "i", "SUB_MODULE_ID_RECHARGE", "j", "SUB_MODULE_ID_DIALOG", "k", "SUB_MODULE_ID_GIFT_SEND", "l", "ITEM_ID_CHOOSE_FRIEND", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "ACTION_ID_COMBO_EVENT", DomainData.DOMAIN_NAME, "ACTION_ID_COMBO_SUCCESS", "o", "ACTION_ID_COMBO_FAILED", "p", "KEY_UID", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "KEY_TO_UID", "r", "KEY_SCREEN_TYPE", ReportConstant.COSTREPORT_PREFIX, "KEY_SGRP_CHANNEL_ID", "t", "KEY_SGRP_SUB_CHANNEL_ID", "u", "KEY_QQ_GROUP_ID", "v", "KEY_QQLIVE_USER_ID", "w", "KEY_QQLIVE_ANCHOR_ID", HippyTKDListViewAdapter.X, "KEY_QQLIVE_ROOM_ID", "y", "KEY_QQLIVE_PROGRAMME_ID", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "KEY_QQLIVE_ZHIBO_TYPE", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "KEY_QQLIVE_ZHIBO_CONTENT", "B", "KEY_QQLIVE_START_SOURCE", BdhLogUtil.LogTag.Tag_Conn, "KEY_QQLIVE_ENTER_ID", "D", "KEY_QQLIVE_COMING_WAY", "E", "KEY_QQLIVE_ABTOKEN", UserInfo.SEX_FEMALE, "KEY_QQLIVE_SCENE_ID", "G", "KEY_QQLIVE_SUBSCENE_ID", "H", "KEY_GIFT_NAME", "KEY_GIFT_ID", "J", "KEY_GIFT_PRICE", "K", "KEY_GIFT_TYPE", "L", "KEY_GIFT_PAGE_NUM", "M", "KEY_GIFT_COMBO_CLICK", "N", "KEY_GIFT_COMBO_REAL", "O", "KEY_GIFT_FAIL_REASON", "P", "KEY_GIFT_CLASSFY", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "KEY_GIFT_PACKAGE_NUM", BdhLogUtil.LogTag.Tag_Req, "KEY_GIFT_JIAOBIAO_ID", ExifInterface.LATITUDE_SOUTH, "KEY_GIFT_JIAOBIAO_NAME", "T", "KEY_GIFT_EUIP_TYPE", "U", "GIFT_EUIP_TYPE_PAD", "V", "GIFT_EUIP_TYPE_PHONE", "W", "GIFT_TYPE_BAG", "X", "GIFT_TYPE_PANEL", "Y", "VAL_GIFT_TYPE_GOLD", "Z", "VAL_GIFT_TYPE_FREE", "a0", "VAL_GIFT_TYPE_ACTIVE", "b0", "ITEM_ID_SEND_BTN", "c0", "ITEM_ID_RECHARGE_GOLD", "ITEM_ID_RECHARGE_VOUCHER", "ITEM_ID_DIALOG", "ITEM_ID_DIALOG_RECHARGE", "VAL_SCREEN_TYPE_PORTRAIT", "VAL_SCREEN_TYPE_LANDSCAPE", "SCENE_ITEM_KEY_REPORT_TAB_ID", "SCENE_ITEM_KEY_REPORT_FLOW_ID", "USER_AUTH_STATUS", "BTN_TYPE_COMMON", "BTN_TYPE_COMBO", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "busiInfoJson", "giftSendBusiInfoJson", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "exposedGiftItems", "isRechargeExposed", "currentBalance", "<init>", "(Lcom/tencent/mobileqq/vasgift/mvvm/business/QQGiftPanelViewModel;)V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasGift04586Report implements nh2.b {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ZHIBO_CONTENT;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_START_SOURCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ENTER_ID;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_COMING_WAY;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ABTOKEN;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_SCENE_ID;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_SUBSCENE_ID;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_NAME;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_ID;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_PRICE;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_TYPE;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_PAGE_NUM;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_COMBO_CLICK;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_COMBO_REAL;

    /* renamed from: O, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_FAIL_REASON;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_CLASSFY;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_PACKAGE_NUM;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_JIAOBIAO_ID;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_JIAOBIAO_NAME;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String KEY_GIFT_EUIP_TYPE;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final String GIFT_EUIP_TYPE_PAD;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final String GIFT_EUIP_TYPE_PHONE;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final String GIFT_TYPE_BAG;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final String GIFT_TYPE_PANEL;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final String VAL_GIFT_TYPE_GOLD;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final String VAL_GIFT_TYPE_FREE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQGiftPanelViewModel viewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String VAL_GIFT_TYPE_ACTIVE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_SEND_BTN;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String GIFT_PANEL_APP_ID;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_RECHARGE_GOLD;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_BANNER_ACTIVITY;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_RECHARGE_VOUCHER;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_CHOOSE_FRIEND;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_DIALOG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_GIFT_DESC;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_DIALOG_RECHARGE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_GIFT_ITEMS;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String VAL_SCREEN_TYPE_PORTRAIT;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_TAB;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String VAL_SCREEN_TYPE_LANDSCAPE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_RECHARGE;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SCENE_ITEM_KEY_REPORT_TAB_ID;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_DIALOG;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SCENE_ITEM_KEY_REPORT_FLOW_ID;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUB_MODULE_ID_GIFT_SEND;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String USER_AUTH_STATUS;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ITEM_ID_CHOOSE_FRIEND;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final int BTN_TYPE_COMMON;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int ACTION_ID_COMBO_EVENT;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final int BTN_TYPE_COMBO;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int ACTION_ID_COMBO_SUCCESS;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject busiInfoJson;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int ACTION_ID_COMBO_FAILED;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject giftSendBusiInfoJson;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_UID;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> exposedGiftItems;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_TO_UID;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isRechargeExposed;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_SCREEN_TYPE;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private long currentBalance;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_SGRP_CHANNEL_ID;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_SGRP_SUB_CHANNEL_ID;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQ_GROUP_ID;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_USER_ID;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ANCHOR_ID;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ROOM_ID;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_PROGRAMME_ID;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_QQLIVE_ZHIBO_TYPE;

    public VasGift04586Report(@NotNull QQGiftPanelViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.TAG = "VasGift04586Report";
        this.GIFT_PANEL_APP_ID = "qq_gift_panel";
        this.SUB_MODULE_ID_BANNER_ACTIVITY = "1";
        this.SUB_MODULE_ID_CHOOSE_FRIEND = "2";
        this.SUB_MODULE_ID_GIFT_DESC = "3";
        this.SUB_MODULE_ID_GIFT_ITEMS = "4";
        this.SUB_MODULE_ID_TAB = "5";
        this.SUB_MODULE_ID_RECHARGE = "6";
        this.SUB_MODULE_ID_DIALOG = "7";
        this.SUB_MODULE_ID_GIFT_SEND = "8";
        this.ITEM_ID_CHOOSE_FRIEND = "choose_fri";
        this.ACTION_ID_COMBO_EVENT = 212;
        this.ACTION_ID_COMBO_SUCCESS = 213;
        this.ACTION_ID_COMBO_FAILED = 214;
        this.KEY_UID = "uid";
        this.KEY_TO_UID = "to_uid";
        this.KEY_SCREEN_TYPE = "screen_type";
        this.KEY_SGRP_CHANNEL_ID = "sgrp_channel_id";
        this.KEY_SGRP_SUB_CHANNEL_ID = "sgrp_sub_channel_id";
        this.KEY_QQ_GROUP_ID = "qq_group_id";
        this.KEY_QQLIVE_USER_ID = "qqlive_user_id";
        this.KEY_QQLIVE_ANCHOR_ID = "qqlive_anchor_id";
        this.KEY_QQLIVE_ROOM_ID = "qqlive_room_id";
        this.KEY_QQLIVE_PROGRAMME_ID = "qqlive_programme_id";
        this.KEY_QQLIVE_ZHIBO_TYPE = "qqlive_zhibo_type";
        this.KEY_QQLIVE_ZHIBO_CONTENT = "qqlive_zhibo_content";
        this.KEY_QQLIVE_START_SOURCE = "qqlive_start_source";
        this.KEY_QQLIVE_ENTER_ID = "qqlive_enter_id";
        this.KEY_QQLIVE_COMING_WAY = "qqlive_coming_way";
        this.KEY_QQLIVE_ABTOKEN = QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN;
        this.KEY_QQLIVE_SCENE_ID = "qqlive_scene_id";
        this.KEY_QQLIVE_SUBSCENE_ID = "qqlive_subscene_id";
        this.KEY_GIFT_NAME = "gift_name";
        this.KEY_GIFT_ID = "gift_id";
        this.KEY_GIFT_PRICE = "gift_price";
        this.KEY_GIFT_TYPE = "gift_type";
        this.KEY_GIFT_PAGE_NUM = "page_num";
        this.KEY_GIFT_COMBO_CLICK = "gift_combo_click";
        this.KEY_GIFT_COMBO_REAL = "gift_combo_real";
        this.KEY_GIFT_FAIL_REASON = "gift_fail_reason";
        this.KEY_GIFT_CLASSFY = "gift_classify";
        this.KEY_GIFT_PACKAGE_NUM = "gift_num";
        this.KEY_GIFT_JIAOBIAO_ID = "jiaobiao_id";
        this.KEY_GIFT_JIAOBIAO_NAME = "jiaobiao_name";
        this.KEY_GIFT_EUIP_TYPE = "euip_type";
        this.GIFT_EUIP_TYPE_PAD = "pad";
        this.GIFT_EUIP_TYPE_PHONE = "phone";
        this.GIFT_TYPE_BAG = "bag";
        this.GIFT_TYPE_PANEL = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL;
        this.VAL_GIFT_TYPE_GOLD = "gold";
        this.VAL_GIFT_TYPE_FREE = "free";
        this.VAL_GIFT_TYPE_ACTIVE = "active";
        this.ITEM_ID_SEND_BTN = "send";
        this.ITEM_ID_RECHARGE_GOLD = "recharge_gold";
        this.ITEM_ID_RECHARGE_VOUCHER = "recharge_voucher";
        this.ITEM_ID_DIALOG = "tanchuang";
        this.ITEM_ID_DIALOG_RECHARGE = "recharge";
        this.VAL_SCREEN_TYPE_PORTRAIT = "shu";
        this.VAL_SCREEN_TYPE_LANDSCAPE = "heng";
        this.SCENE_ITEM_KEY_REPORT_TAB_ID = "ReportTabID";
        this.SCENE_ITEM_KEY_REPORT_FLOW_ID = "ReportFlowID";
        this.USER_AUTH_STATUS = "person_verify";
        this.BTN_TYPE_COMMON = 1;
        this.BTN_TYPE_COMBO = 2;
        this.busiInfoJson = new JSONObject();
        this.giftSendBusiInfoJson = new JSONObject();
        this.exposedGiftItems = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(long balance) {
        I0(this, null, null, this.SUB_MODULE_ID_RECHARGE, this.ITEM_ID_RECHARGE_GOLD, null, null, 101, (int) balance, 0, null, null, null, 3891, null);
    }

    private final void H0(String pageId, String moduleId, String subModuleId, String itemId, String subItemId, String itemType, int actionId, int actionValue, int actionAttr, String ruleId, String busiInfo, String positionId) {
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(this.GIFT_PANEL_APP_ID, pageId, moduleId, subModuleId, itemId, subItemId, itemType, actionId, actionValue, actionAttr, ruleId, busiInfo, positionId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void I0(VasGift04586Report vasGift04586Report, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, int i17, String str7, String str8, String str9, int i18, Object obj) {
        String k06 = (i18 & 1) != 0 ? vasGift04586Report.k0(vasGift04586Report.viewModel) : str;
        String str10 = (i18 & 2) != 0 ? "" : str2;
        String str11 = (i18 & 4) != 0 ? "" : str3;
        vasGift04586Report.H0(k06, str10, str11, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? "" : str5, (i18 & 32) != 0 ? "" : str6, i3, (i18 & 128) != 0 ? 0 : i16, (i18 & 256) == 0 ? i17 : 0, (i18 & 512) != 0 ? vasGift04586Report.p0() : str7, (i18 & 1024) != 0 ? vasGift04586Report.l0(str11) : str8, (i18 & 2048) != 0 ? "" : str9);
    }

    private final void J0(Function0<Unit> block) {
        try {
            block.invoke();
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L0(int authCode) {
        if (authCode != -11154) {
            if (authCode != -11153) {
                if (authCode != 0) {
                    return 0;
                }
                return 3;
            }
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d0(d dVar) {
        if (this.viewModel.c3(dVar)) {
            return this.BTN_TYPE_COMBO;
        }
        return this.BTN_TYPE_COMMON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(d data, int code, String reportTime) {
        this.giftSendBusiInfoJson.put(this.KEY_GIFT_FAIL_REASON, String.valueOf(code));
        this.giftSendBusiInfoJson.put("req_timestamp", reportTime);
        String str = this.SUB_MODULE_ID_GIFT_SEND;
        int i3 = this.ACTION_ID_COMBO_FAILED;
        String valueOf = String.valueOf(this.viewModel.Q2());
        String giftName = data.f264876e;
        String tabName = data.U;
        Intrinsics.checkNotNullExpressionValue(giftName, "giftName");
        Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
        I0(this, null, null, str, valueOf, giftName, null, i3, 0, 0, null, null, tabName, 1955, null);
        this.giftSendBusiInfoJson.remove(this.KEY_GIFT_FAIL_REASON);
        this.giftSendBusiInfoJson.remove("req_timestamp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(d data, String reportTime) {
        this.giftSendBusiInfoJson.put("req_timestamp", reportTime);
        String str = this.SUB_MODULE_ID_GIFT_SEND;
        int i3 = this.ACTION_ID_COMBO_SUCCESS;
        int d06 = d0(data);
        String valueOf = String.valueOf(this.viewModel.Q2());
        String giftName = data.f264876e;
        String tabName = data.U;
        Intrinsics.checkNotNullExpressionValue(giftName, "giftName");
        Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
        I0(this, null, null, str, valueOf, giftName, null, i3, 0, d06, null, null, tabName, 1699, null);
        this.giftSendBusiInfoJson.remove("req_timestamp");
    }

    private final String k0(QQGiftPanelViewModel qQGiftPanelViewModel) {
        com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig = qQGiftPanelViewModel.H2().getSDKConfig();
        String appID = sDKConfig.f264976e;
        if (TextUtils.isEmpty(appID)) {
            appID = sDKConfig.f264977f;
        }
        if (TextUtils.isEmpty(appID)) {
            int i3 = sDKConfig.f264972a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            appID = sb5.toString();
        }
        Intrinsics.checkNotNullExpressionValue(appID, "appID");
        return appID;
    }

    private final String l0(String subModuleId) {
        if (!Intrinsics.areEqual(subModuleId, this.SUB_MODULE_ID_GIFT_ITEMS) && !Intrinsics.areEqual(subModuleId, this.SUB_MODULE_ID_GIFT_SEND)) {
            String jSONObject = this.busiInfoJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "busiInfoJson.toString()");
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (this.busiInfoJson.names() != null) {
            JSONArray names = this.busiInfoJson.names();
            Intrinsics.checkNotNull(names);
            int length = names.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONArray names2 = this.busiInfoJson.names();
                Intrinsics.checkNotNull(names2);
                String string = names2.getString(i3);
                jSONObject2.put(string, this.busiInfoJson.get(string));
            }
        }
        if (this.giftSendBusiInfoJson.names() != null) {
            JSONArray names3 = this.giftSendBusiInfoJson.names();
            Intrinsics.checkNotNull(names3);
            int length2 = names3.length();
            for (int i16 = 0; i16 < length2; i16++) {
                JSONArray names4 = this.giftSendBusiInfoJson.names();
                Intrinsics.checkNotNull(names4);
                String string2 = names4.getString(i16);
                jSONObject2.put(string2, this.giftSendBusiInfoJson.get(string2));
            }
        }
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "mergedJSON.toString()");
        return jSONObject3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m0(d dVar) {
        if (dVar.F == 1) {
            return this.VAL_GIFT_TYPE_FREE;
        }
        if (dVar.f264881h == 2) {
            return this.VAL_GIFT_TYPE_ACTIVE;
        }
        return this.VAL_GIFT_TYPE_GOLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n0() {
        IVasTempApi iVasTempApi = (IVasTempApi) QRoute.api(IVasTempApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (iVasTempApi.isTabletDevice(context)) {
            return 8;
        }
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r3 != 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String o0() {
        long j3;
        com.tencent.mobileqq.qqgift.mvvm.business.data.a D2;
        com.tencent.mobileqq.qqgift.data.service.c x16 = this.viewModel.H2().a().x();
        if (x16 != null) {
            j3 = x16.f264861b;
        }
        j3 = 0;
        if (j3 == 0 && (D2 = this.viewModel.D2()) != null && !TextUtils.isEmpty(D2.f264936c)) {
            String str = D2.f264936c;
            Intrinsics.checkNotNullExpressionValue(str, "p.anchorId");
            return str;
        }
        return String.valueOf(j3);
    }

    private final String p0() {
        String w26 = this.viewModel.w2();
        Intrinsics.checkNotNullExpressionValue(w26, "viewModel.abTestValue");
        return w26;
    }

    private final String q0() {
        if (this.viewModel.H2().getAppRuntime().getApplicationContext().getResources().getConfiguration().orientation == 1) {
            return this.VAL_SCREEN_TYPE_PORTRAIT;
        }
        return this.VAL_SCREEN_TYPE_LANDSCAPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final d data, int position) {
        oh2.c e16;
        C0(data);
        this.giftSendBusiInfoJson.put(this.KEY_GIFT_PAGE_NUM, String.valueOf((position / n0()) + 1));
        nh2.c H2 = this.viewModel.H2();
        if (H2 != null && (e16 = H2.e()) != null) {
            e16.m(null, false, new c.a() { // from class: com.tencent.mobileqq.vasgift.business.dt.b
                @Override // oh2.c.a
                public final void a(boolean z16, int i3, String str) {
                    VasGift04586Report.x0(VasGift04586Report.this, data, z16, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(VasGift04586Report this$0, d data, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.giftSendBusiInfoJson.put(this$0.USER_AUTH_STATUS, this$0.L0(i3));
        String str2 = this$0.SUB_MODULE_ID_GIFT_SEND;
        int d06 = this$0.d0(data);
        String valueOf = String.valueOf(this$0.viewModel.Q2());
        String giftName = data.f264876e;
        String tabName = data.U;
        Intrinsics.checkNotNullExpressionValue(giftName, "giftName");
        Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
        I0(this$0, null, null, str2, valueOf, giftName, null, 102, 0, d06, null, null, tabName, 1699, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(d data, int position) {
        C0(data);
        this.giftSendBusiInfoJson.put(this.KEY_GIFT_PAGE_NUM, String.valueOf((position / n0()) + 1));
        I0(this, null, null, this.SUB_MODULE_ID_GIFT_SEND, String.valueOf(this.viewModel.Q2()), null, null, 101, 0, d0(data), null, null, null, 3763, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        this.busiInfoJson.put(this.KEY_UID, this.viewModel.H2().getAppRuntime().getCurrentAccountUin());
        this.busiInfoJson.put(this.KEY_SCREEN_TYPE, q0());
        this.busiInfoJson.put(this.KEY_GIFT_PACKAGE_NUM, this.viewModel.D2().f264952s);
        String str = this.viewModel.H2().getSDKConfig().f264976e;
        if (Intrinsics.areEqual(str, WadlProxyConsts.CHANNEL)) {
            this.busiInfoJson.put(this.KEY_SGRP_CHANNEL_ID, this.viewModel.D2().f264944k);
            this.busiInfoJson.put(this.KEY_SGRP_SUB_CHANNEL_ID, this.viewModel.D2().f264945l);
            return;
        }
        if (Intrinsics.areEqual(str, "10012")) {
            this.busiInfoJson.put(this.KEY_QQ_GROUP_ID, this.viewModel.D2().f264951r);
            return;
        }
        this.busiInfoJson.put(this.KEY_QQLIVE_USER_ID, this.viewModel.D2().f264935b);
        this.busiInfoJson.put(this.KEY_QQLIVE_ANCHOR_ID, this.viewModel.D2().f264936c);
        this.busiInfoJson.put(this.KEY_QQLIVE_ROOM_ID, this.viewModel.D2().f264937d);
        this.busiInfoJson.put(this.KEY_QQLIVE_PROGRAMME_ID, this.viewModel.D2().f264938e);
        this.busiInfoJson.put(this.KEY_QQLIVE_ZHIBO_TYPE, this.viewModel.D2().f264939f);
        this.busiInfoJson.put(this.KEY_QQLIVE_ZHIBO_CONTENT, this.viewModel.D2().f264940g);
        this.busiInfoJson.put(this.KEY_QQLIVE_START_SOURCE, this.viewModel.D2().f264941h);
        this.busiInfoJson.put(this.KEY_QQLIVE_ENTER_ID, this.viewModel.D2().f264949p);
        this.busiInfoJson.put(this.KEY_QQLIVE_COMING_WAY, this.viewModel.D2().f264948o);
        this.busiInfoJson.put(this.KEY_QQLIVE_ABTOKEN, this.viewModel.D2().f264950q);
        this.busiInfoJson.put(this.KEY_QQLIVE_SCENE_ID, this.viewModel.D2().f264942i);
        this.busiInfoJson.put(this.KEY_QQLIVE_SUBSCENE_ID, this.viewModel.D2().f264943j);
    }

    public final void A0(final long balance) {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onRechargeGoldBalanceChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                VasGift04586Report.this.currentBalance = balance;
                z16 = VasGift04586Report.this.isRechargeExposed;
                if (z16) {
                    return;
                }
                VasGift04586Report.this.E0(balance);
                VasGift04586Report.this.isRechargeExposed = true;
            }
        });
    }

    public final void B0(@NotNull String tabName, @NotNull String tabID) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(tabID, "tabID");
        I0(this, null, null, this.SUB_MODULE_ID_TAB, tabID, null, null, 101, 0, 0, null, null, tabName, 1971, null);
    }

    public final void C0(@NotNull final d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$putGiftSendBusiInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JSONObject jSONObject;
                String str;
                String str2;
                String str3;
                String str4;
                String m06;
                String str5;
                String o06;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                String str12;
                jSONObject = VasGift04586Report.this.giftSendBusiInfoJson;
                VasGift04586Report vasGift04586Report = VasGift04586Report.this;
                d dVar = data;
                str = vasGift04586Report.KEY_GIFT_ID;
                jSONObject.put(str, dVar.f264874d);
                str2 = vasGift04586Report.KEY_GIFT_NAME;
                jSONObject.put(str2, dVar.f264876e);
                str3 = vasGift04586Report.KEY_GIFT_PRICE;
                jSONObject.put(str3, dVar.f264878f);
                str4 = vasGift04586Report.KEY_GIFT_TYPE;
                m06 = vasGift04586Report.m0(dVar);
                jSONObject.put(str4, m06);
                str5 = vasGift04586Report.KEY_TO_UID;
                o06 = vasGift04586Report.o0();
                jSONObject.put(str5, o06);
                str6 = vasGift04586Report.KEY_GIFT_CLASSFY;
                jSONObject.put(str6, dVar.f264875d0 ? vasGift04586Report.GIFT_TYPE_BAG : vasGift04586Report.GIFT_TYPE_PANEL);
                if (dVar.Y != 0) {
                    str12 = vasGift04586Report.KEY_GIFT_JIAOBIAO_ID;
                    jSONObject.put(str12, dVar.Y);
                }
                if (!TextUtils.isEmpty(dVar.X)) {
                    str11 = vasGift04586Report.KEY_GIFT_JIAOBIAO_NAME;
                    jSONObject.put(str11, dVar.X);
                }
                IVasTempApi iVasTempApi = (IVasTempApi) QRoute.api(IVasTempApi.class);
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                if (iVasTempApi.isTabletDevice(context)) {
                    str9 = vasGift04586Report.KEY_GIFT_EUIP_TYPE;
                    str10 = vasGift04586Report.GIFT_EUIP_TYPE_PAD;
                    jSONObject.put(str9, str10);
                } else {
                    str7 = vasGift04586Report.KEY_GIFT_EUIP_TYPE;
                    str8 = vasGift04586Report.GIFT_EUIP_TYPE_PHONE;
                    jSONObject.put(str7, str8);
                }
            }
        });
    }

    public final void D0() {
        J0(new VasGift04586Report$rechargeGoldClick$1(this));
    }

    public final void F0(final long balance) {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$rechargeVoucherClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                str = VasGift04586Report.this.SUB_MODULE_ID_RECHARGE;
                str2 = VasGift04586Report.this.ITEM_ID_RECHARGE_VOUCHER;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, str2, null, null, 102, (int) balance, 0, null, null, null, 3891, null);
            }
        });
    }

    public final void G0(long balance) {
        I0(this, null, null, this.SUB_MODULE_ID_RECHARGE, this.ITEM_ID_RECHARGE_VOUCHER, null, null, 101, (int) balance, 0, null, null, null, 3891, null);
    }

    public final void K0(@NotNull final String tabID, @NotNull final String tabName) {
        Intrinsics.checkNotNullParameter(tabID, "tabID");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$tabSelected$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                str = VasGift04586Report.this.SUB_MODULE_ID_TAB;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, tabID, null, null, 102, 0, 0, null, null, tabName, 1971, null);
            }
        });
    }

    @Override // nh2.b
    public void a() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onChooseFriendExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                str = VasGift04586Report.this.SUB_MODULE_ID_CHOOSE_FRIEND;
                str2 = VasGift04586Report.this.ITEM_ID_CHOOSE_FRIEND;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, str2, null, null, 101, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
            }
        });
    }

    @Override // nh2.b
    public void b() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onChooseFriendClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                str = VasGift04586Report.this.SUB_MODULE_ID_CHOOSE_FRIEND;
                str2 = VasGift04586Report.this.ITEM_ID_CHOOSE_FRIEND;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, str2, null, null, 102, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
            }
        });
    }

    @Override // nh2.b
    public void c(@Nullable final String name) {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onBannerActivityExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                if (name != null) {
                    str = this.SUB_MODULE_ID_BANNER_ACTIVITY;
                    VasGift04586Report.I0(this, null, null, str, name, null, null, 101, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
                }
            }
        });
    }

    @Override // nh2.b
    public void d(@Nullable final String name) {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onBannerActivityClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                if (name != null) {
                    str = this.SUB_MODULE_ID_BANNER_ACTIVITY;
                    VasGift04586Report.I0(this, null, null, str, name, null, null, 102, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
                }
            }
        });
    }

    @Override // nh2.b
    public void e(final boolean isSuccess, final int code, @NotNull final String reportTime) {
        Intrinsics.checkNotNullParameter(reportTime, "reportTime");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$onConsumeCurrencyResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasGift04586Report vasGift04586Report = VasGift04586Report.this;
                boolean z16 = isSuccess;
                d P2 = vasGift04586Report.getViewModel().P2();
                Intrinsics.checkNotNullExpressionValue(P2, "viewModel.selectedGiftData");
                vasGift04586Report.g0(z16, P2, code, reportTime);
            }
        });
    }

    public final void e0(@NotNull final d data, final int validComboCount, final int allComboCount) {
        Intrinsics.checkNotNullParameter(data, "data");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$comboEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JSONObject jSONObject;
                String str;
                JSONObject jSONObject2;
                String str2;
                String str3;
                int i3;
                int d06;
                JSONObject jSONObject3;
                String str4;
                JSONObject jSONObject4;
                String str5;
                jSONObject = VasGift04586Report.this.giftSendBusiInfoJson;
                str = VasGift04586Report.this.KEY_GIFT_COMBO_REAL;
                jSONObject.put(str, validComboCount);
                jSONObject2 = VasGift04586Report.this.giftSendBusiInfoJson;
                str2 = VasGift04586Report.this.KEY_GIFT_COMBO_CLICK;
                jSONObject2.put(str2, allComboCount);
                str3 = VasGift04586Report.this.SUB_MODULE_ID_GIFT_SEND;
                i3 = VasGift04586Report.this.ACTION_ID_COMBO_EVENT;
                String valueOf = String.valueOf(VasGift04586Report.this.getViewModel().Q2());
                d dVar = data;
                String tabName = dVar.U;
                String giftName = dVar.f264876e;
                d06 = VasGift04586Report.this.d0(dVar);
                VasGift04586Report vasGift04586Report = VasGift04586Report.this;
                Intrinsics.checkNotNullExpressionValue(giftName, "giftName");
                Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
                VasGift04586Report.I0(vasGift04586Report, null, null, str3, valueOf, giftName, null, i3, 0, d06, null, null, tabName, 1699, null);
                jSONObject3 = VasGift04586Report.this.giftSendBusiInfoJson;
                str4 = VasGift04586Report.this.KEY_GIFT_COMBO_REAL;
                jSONObject3.remove(str4);
                jSONObject4 = VasGift04586Report.this.giftSendBusiInfoJson;
                str5 = VasGift04586Report.this.KEY_GIFT_COMBO_CLICK;
                jSONObject4.remove(str5);
            }
        });
    }

    public final void g0(final boolean isSuccess, @NotNull final d data, final int code, @NotNull final String reportTime) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reportTime, "reportTime");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$comboResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (isSuccess) {
                    this.h0(data, reportTime);
                } else {
                    this.f0(data, code, reportTime);
                }
            }
        });
    }

    public final void i0() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$dialogExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                str = VasGift04586Report.this.SUB_MODULE_ID_DIALOG;
                str2 = VasGift04586Report.this.ITEM_ID_DIALOG;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, str2, null, null, 101, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
            }
        });
    }

    public final void j0() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$dialogRechargeClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                str = VasGift04586Report.this.SUB_MODULE_ID_DIALOG;
                str2 = VasGift04586Report.this.ITEM_ID_DIALOG_RECHARGE;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str, str2, null, null, 102, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
            }
        });
    }

    @NotNull
    /* renamed from: r0, reason: from getter */
    public final QQGiftPanelViewModel getViewModel() {
        return this.viewModel;
    }

    public final void s0() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$giftDescExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String selectedGiftName = VasGift04586Report.this.getViewModel().P2() != null ? VasGift04586Report.this.getViewModel().P2().f264876e : "";
                str = VasGift04586Report.this.SUB_MODULE_ID_GIFT_DESC;
                String valueOf = String.valueOf(VasGift04586Report.this.getViewModel().Q2());
                VasGift04586Report vasGift04586Report = VasGift04586Report.this;
                Intrinsics.checkNotNullExpressionValue(selectedGiftName, "selectedGiftName");
                VasGift04586Report.I0(vasGift04586Report, null, null, str, valueOf, selectedGiftName, null, 101, 0, 0, null, null, null, 4003, null);
            }
        });
    }

    public final void t0(@NotNull final d data, final int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$giftItemClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JSONObject jSONObject;
                String str;
                int n06;
                String str2;
                VasGift04586Report.this.C0(data);
                jSONObject = VasGift04586Report.this.giftSendBusiInfoJson;
                str = VasGift04586Report.this.KEY_GIFT_PAGE_NUM;
                int i3 = position;
                n06 = VasGift04586Report.this.n0();
                jSONObject.put(str, String.valueOf((i3 / n06) + 1));
                str2 = VasGift04586Report.this.SUB_MODULE_ID_GIFT_ITEMS;
                VasGift04586Report.I0(VasGift04586Report.this, null, null, str2, String.valueOf(VasGift04586Report.this.getViewModel().Q2()), null, null, 102, 0, 0, null, null, null, LaunchScene.LAUNCH_SCENE_QUN_AIO_CM_SHOW_GAME_BATTLE_STORE, null);
                d dVar = data;
                if (dVar.E) {
                    VasGift04586Report.this.w0(dVar, position);
                }
            }
        });
    }

    public final void u0(@NotNull final d data, final int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$giftItemExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                JSONObject jSONObject;
                String str;
                int n06;
                String str2;
                int d06;
                ArrayList arrayList2;
                d dVar = d.this;
                if (dVar.E) {
                    this.y0(dVar, position);
                }
                arrayList = this.exposedGiftItems;
                if (arrayList.contains(Integer.valueOf(d.this.f264874d))) {
                    return;
                }
                this.C0(d.this);
                jSONObject = this.giftSendBusiInfoJson;
                str = this.KEY_GIFT_PAGE_NUM;
                int i3 = position;
                n06 = this.n0();
                jSONObject.put(str, String.valueOf((i3 / n06) + 1));
                str2 = this.SUB_MODULE_ID_GIFT_ITEMS;
                d06 = this.d0(d.this);
                String valueOf = String.valueOf(this.getViewModel().Q2());
                d dVar2 = d.this;
                String giftName = dVar2.f264876e;
                String tabName = dVar2.U;
                VasGift04586Report vasGift04586Report = this;
                Intrinsics.checkNotNullExpressionValue(giftName, "giftName");
                Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
                VasGift04586Report.I0(vasGift04586Report, null, null, str2, valueOf, giftName, null, 101, 0, d06, null, null, tabName, 1699, null);
                arrayList2 = this.exposedGiftItems;
                arrayList2.add(Integer.valueOf(d.this.f264874d));
            }
        });
    }

    public final void v0() {
        J0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vasgift.business.dt.VasGift04586Report$giftPanelExpose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VasGift04586Report.this.z0();
                VasGift04586Report.I0(VasGift04586Report.this, null, null, null, null, null, null, 100, 0, 0, null, null, null, 4031, null);
            }
        });
    }
}
