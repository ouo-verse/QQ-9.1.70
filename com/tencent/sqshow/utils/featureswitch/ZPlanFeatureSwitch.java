package com.tencent.sqshow.utils.featureswitch;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqfeatureswitch.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.al;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonAvatarIconConfig;
import com.tencent.zplan.common.utils.GsonUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import j74.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u00a8\u0001\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0086\u0002B\u000b\b\u0002\u00a2\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0006J\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u001bJ\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u001dJ\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tJ\"\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010 J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\tJ\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\tJ\u0006\u00101\u001a\u00020\tJ\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u00020\u001bJ\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u001bJ\u0006\u0010;\u001a\u00020\u0004J\u0006\u0010<\u001a\u00020\u0004J\u0006\u0010=\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004J\u0006\u0010A\u001a\u00020\u0006J\u0006\u0010B\u001a\u00020\u0006J\u0006\u0010C\u001a\u00020\u0006J\u0006\u0010D\u001a\u00020\u0006J\u0006\u0010E\u001a\u00020\u0006J\u0006\u0010F\u001a\u00020\u0006J\u0006\u0010G\u001a\u00020\u0006J\u0006\u0010H\u001a\u00020\u0004J\u0006\u0010I\u001a\u00020\u0006J\u0006\u0010J\u001a\u00020\u0004J\u0006\u0010K\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u0004J\u0006\u0010M\u001a\u00020\tJ\u0006\u0010N\u001a\u00020\tJ\u0006\u0010O\u001a\u00020\u0006J\u0006\u0010P\u001a\u00020\u001dJ\u0006\u0010Q\u001a\u00020\u0006J\u0006\u0010R\u001a\u00020\u0004J\b\u0010S\u001a\u0004\u0018\u00010\tJ\u0006\u0010T\u001a\u00020\u001dJ\u0006\u0010U\u001a\u00020\u001dJ\u0006\u0010V\u001a\u00020\u001dJ\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020\tJ\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020\tJ\u0006\u0010[\u001a\u00020\tJ\u0006\u0010\\\u001a\u00020\tJ\u0006\u0010]\u001a\u00020\u0006J\u0006\u0010^\u001a\u00020\u001bJ\u0006\u0010_\u001a\u00020\u0006J\u0006\u0010`\u001a\u00020\u0006J\u0006\u0010a\u001a\u00020\u0004J\u0006\u0010b\u001a\u00020\tJ\u0006\u0010c\u001a\u00020\tJ\u0006\u0010d\u001a\u00020\u0004J\u0006\u0010e\u001a\u00020\u0004J\u0006\u0010f\u001a\u00020\u0004J\u0006\u0010g\u001a\u00020\u0006J\u0006\u0010h\u001a\u00020\u0004J\u0006\u0010i\u001a\u00020\u0006J\u0006\u0010j\u001a\u00020\tJ\u0006\u0010k\u001a\u00020\u0004J\u0006\u0010l\u001a\u00020\u0004J\u0006\u0010m\u001a\u00020\u0004J\u0006\u0010n\u001a\u00020\u0004J\u0006\u0010o\u001a\u00020\u0006J\u0006\u0010p\u001a\u00020\u0004J\u0006\u0010q\u001a\u00020\u0006J\u0006\u0010r\u001a\u00020\u001bJ\u0006\u0010s\u001a\u00020\tJ\u0006\u0010t\u001a\u00020\tJ\u0006\u0010u\u001a\u00020\u0004J\u0006\u0010v\u001a\u00020\u0004J\u0012\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0012\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010|\u001a\u00020\u0004J\u0006\u0010}\u001a\u00020\u0004J\u0006\u0010~\u001a\u00020\u0004J\u0006\u0010\u007f\u001a\u00020\u0004J\u0007\u0010\u0080\u0001\u001a\u00020\u0004J\u0007\u0010\u0081\u0001\u001a\u00020\u0006J\u0007\u0010\u0082\u0001\u001a\u00020\u0004J\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\u0085\u0001\u001a\u00020\u00062\u0007\u0010\u0084\u0001\u001a\u00020\u0006J\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\u0007\u0010\u0087\u0001\u001a\u00020\u0004J\u0007\u0010\u0088\u0001\u001a\u00020\u0004J\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u0013\u0010\u008a\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0007\u0010\u008c\u0001\u001a\u00020\u0006J\u0007\u0010\u008d\u0001\u001a\u00020\u0004J\u0007\u0010\u008e\u0001\u001a\u00020\tJ\u0007\u0010\u008f\u0001\u001a\u00020\u0004J\u0007\u0010\u0090\u0001\u001a\u00020\u001bJ\u0007\u0010\u0091\u0001\u001a\u00020\u0006J\u0007\u0010\u0092\u0001\u001a\u00020\u0004J\u0007\u0010\u0093\u0001\u001a\u00020\u0004J\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0007\u0010\u0095\u0001\u001a\u00020\u0004J\u0007\u0010\u0096\u0001\u001a\u00020\u001bJ\u0007\u0010\u0097\u0001\u001a\u00020\u0006J\u0007\u0010\u0098\u0001\u001a\u00020\tJ\u0007\u0010\u0099\u0001\u001a\u00020\u001bJ\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010 J\u0007\u0010\u009b\u0001\u001a\u00020\tJ\u0007\u0010\u009c\u0001\u001a\u00020\u0004J\u0007\u0010\u009d\u0001\u001a\u00020\u0004J\u0007\u0010\u009e\u0001\u001a\u00020\u0006J\u0007\u0010\u009f\u0001\u001a\u00020\u0004J\u0007\u0010\u00a0\u0001\u001a\u00020\u0006J\u0007\u0010\u00a1\u0001\u001a\u00020\u001dJ\u0007\u0010\u00a2\u0001\u001a\u00020\tJ\u0007\u0010\u00a3\u0001\u001a\u00020\tJ\u0007\u0010\u00a4\u0001\u001a\u00020\tJ\u0007\u0010\u00a5\u0001\u001a\u00020\tJ\u0007\u0010\u00a6\u0001\u001a\u00020\u0004J\u0007\u0010\u00a7\u0001\u001a\u00020\u0004J\u0007\u0010\u00a8\u0001\u001a\u00020\u0004J\u0007\u0010\u00a9\u0001\u001a\u00020\u0004J\u0007\u0010\u00aa\u0001\u001a\u00020\u0004J\u0007\u0010\u00ab\u0001\u001a\u00020\u0004J\u0007\u0010\u00ac\u0001\u001a\u00020\u001dJ\u0007\u0010\u00ad\u0001\u001a\u00020\tJ\u0007\u0010\u00ae\u0001\u001a\u00020\u0004J\u0007\u0010\u00af\u0001\u001a\u00020\u0006J\u0007\u0010\u00b0\u0001\u001a\u00020\u0004J\u0007\u0010\u00b1\u0001\u001a\u00020\u0004J\u0007\u0010\u00b2\u0001\u001a\u00020\u0004J\u0007\u0010\u00b3\u0001\u001a\u00020\u0004J\u0007\u0010\u00b4\u0001\u001a\u00020\u0004J\u0007\u0010\u00b5\u0001\u001a\u00020\u0004J\u0007\u0010\u00b6\u0001\u001a\u00020\u0004J\u0007\u0010\u00b7\u0001\u001a\u00020\u0004J\u0007\u0010\u00b8\u0001\u001a\u00020\u001bJ\u0007\u0010\u00b9\u0001\u001a\u00020\u001bJ\u0007\u0010\u00ba\u0001\u001a\u00020\u0004J\u0007\u0010\u00bb\u0001\u001a\u00020\tJ\u0007\u0010\u00bc\u0001\u001a\u00020\u0004J\u0007\u0010\u00bd\u0001\u001a\u00020\u0004J\u0007\u0010\u00be\u0001\u001a\u00020\u0004J\u0007\u0010\u00bf\u0001\u001a\u00020\u0004J\u0007\u0010\u00c0\u0001\u001a\u00020\u0004J\u0007\u0010\u00c1\u0001\u001a\u00020\u0004J\u0007\u0010\u00c2\u0001\u001a\u00020\u0004J\u0007\u0010\u00c3\u0001\u001a\u00020\u0004J\u0007\u0010\u00c4\u0001\u001a\u00020\u001bJ\u0007\u0010\u00c5\u0001\u001a\u00020\u001bJ\u0007\u0010\u00c6\u0001\u001a\u00020\u001bJ\u0007\u0010\u00c7\u0001\u001a\u00020\u0004J\u0007\u0010\u00c8\u0001\u001a\u00020\u0004J\u0010\u0010\u00ca\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00c9\u0001J\u0007\u0010\u00cb\u0001\u001a\u00020\u001bJ\t\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\tJ\u0007\u0010\u00cd\u0001\u001a\u00020\tJ\u0007\u0010\u00ce\u0001\u001a\u00020\u0004J\u0007\u0010\u00cf\u0001\u001a\u00020\u0004J\u0007\u0010\u00d0\u0001\u001a\u00020\u001bJ\u0007\u0010\u00d1\u0001\u001a\u00020\u0004J\u0007\u0010\u00d2\u0001\u001a\u00020\u001bJ\u0007\u0010\u00d3\u0001\u001a\u00020\u001bJ\u0007\u0010\u00d4\u0001\u001a\u00020\u0004J\u0007\u0010\u00d5\u0001\u001a\u00020\u0004J\u0010\u0010\u00d6\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00c9\u0001J\t\u0010\u00d7\u0001\u001a\u0004\u0018\u00010 J\u0007\u0010\u00d8\u0001\u001a\u00020\u0004J\u0007\u0010\u00d9\u0001\u001a\u00020\tJ\u0007\u0010\u00da\u0001\u001a\u00020\u0004J\u0007\u0010\u00db\u0001\u001a\u00020\tJ\u0007\u0010\u00dc\u0001\u001a\u00020\u0004J\u0007\u0010\u00dd\u0001\u001a\u00020\u0004J\u0007\u0010\u00de\u0001\u001a\u00020\tJ\u0007\u0010\u00df\u0001\u001a\u00020\u0004J\u0007\u0010\u00e0\u0001\u001a\u00020\tJ\u0007\u0010\u00e1\u0001\u001a\u00020\tJ\u0007\u0010\u00e2\u0001\u001a\u00020\u0004J\u0007\u0010\u00e3\u0001\u001a\u00020\u0004J\u0007\u0010\u00e4\u0001\u001a\u00020\u0004J\b\u0010\u00e6\u0001\u001a\u00030\u00e5\u0001J\u0007\u0010\u00e7\u0001\u001a\u00020\u0004J\u0007\u0010\u00e8\u0001\u001a\u00020\tJ\u0007\u0010\u00e9\u0001\u001a\u00020\u0004J\u0007\u0010\u00ea\u0001\u001a\u00020\u0004J\u0007\u0010\u00eb\u0001\u001a\u00020\u0004J\u0007\u0010\u00ec\u0001\u001a\u00020\u0004J\t\u0010\u00ed\u0001\u001a\u0004\u0018\u00010 J\u0007\u0010\u00ee\u0001\u001a\u00020\u0004J\u0007\u0010\u00ef\u0001\u001a\u00020\u0004J\u0007\u0010\u00f0\u0001\u001a\u00020\u0004J\u0007\u0010\u00f1\u0001\u001a\u00020\tJ\u0007\u0010\u00f2\u0001\u001a\u00020\u0004J\u0007\u0010\u00f3\u0001\u001a\u00020\u0004J\u0007\u0010\u00f4\u0001\u001a\u00020\u0004J\u0007\u0010\u00f5\u0001\u001a\u00020\u0004J\u0007\u0010\u00f6\u0001\u001a\u00020\u001bJ\u0007\u0010\u00f7\u0001\u001a\u00020\u0004J\u0007\u0010\u00f8\u0001\u001a\u00020 J\u0007\u0010\u00f9\u0001\u001a\u00020\u0004J\u0007\u0010\u00fa\u0001\u001a\u00020\u0004J\u0007\u0010\u00fb\u0001\u001a\u00020\u0004J\u0007\u0010\u00fc\u0001\u001a\u00020\u0006R\u001a\u0010\u00fe\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b^\u0010\u00fd\u0001R+\u0010\u0083\u0002\u001a\u0016\u0012\u0005\u0012\u00030\u0080\u00020\u00ff\u0001j\n\u0012\u0005\u0012\u00030\u0080\u0002`\u0081\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u0082\u0002\u00a8\u0006\u0087\u0002"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/ZPlanFeatureSwitch;", "", "", ICustomDataEditor.STRING_PARAM_3, "", "E0", "", "Q1", "", "", NowProxyConstants.AccountInfoKey.A2, "z2", "p2", "K2", "L0", "Lcom/tencent/sqshow/utils/featureswitch/ZPlanFeatureSwitch$MemeConfig;", "v1", "b2", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "r3", "h3", "g3", "key", "secondaryKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, ICustomDataEditor.STRING_ARRAY_PARAM_1, "W0", "", "X0", "", "V0", "Y0", "Lorg/json/JSONObject;", "Z0", "toggleKey", "b1", "f3", "w3", ICustomDataEditor.NUMBER_PARAM_3, "x3", "P", Constants.APK_CERTIFICATE, "I0", "H0", "H1", "d3", "f0", "M1", ICustomDataEditor.NUMBER_PARAM_1, "q1", "i", "W2", "o3", "C1", Constants.BASE_IN_PLUGIN_ID, "u1", "t1", "T", "N0", ExifInterface.LATITUDE_SOUTH, "j3", "P1", BdhLogUtil.LogTag.Tag_Conn, "j", "i3", "d2", "S0", "w2", ICustomDataEditor.STRING_PARAM_1, "w1", "x1", "N1", "I", "O1", "U", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g2", "J2", "r1", "u2", "B2", "l0", "f2", "Z1", "Y1", "O2", "S1", "U2", "T2", "S2", "Q2", "R2", "P2", "b", "d1", "e1", "h0", "R0", "Q0", "H", "V2", "N", "z3", "O", "y3", Constants.MMCCID, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u3", "y1", "n0", "m2", "k2", Constants.BASE_IN_PLUGIN_VERSION, "C2", "l3", "G", "l2", ICustomDataEditor.NUMBER_PARAM_2, SemanticAttributes.DbSystemValues.H2, "i2", "j2", "c3", "K", "L", "Z", "a0", "R1", "k3", "M2", "scene", "o2", "B0", "D0", "C0", "y2", "x2", "k0", "F2", "Z2", "L2", UserInfo.SEX_FEMALE, "T0", "U0", DomainData.DOMAIN_NAME, "d0", "k", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I1", "J1", "K1", "L1", "N2", "F1", "m3", "J", "p1", BdhLogUtil.LogTag.Tag_Req, "f1", "M0", "X1", "I2", "K0", "J0", "V1", "W", "u", ICustomDataEditor.STRING_ARRAY_PARAM_3, "b3", "e", h.F, "H2", "G0", "F0", "M", "a", "v3", "p0", "v0", "D", "g", "w0", ICustomDataEditor.STRING_PARAM_2, "r2", "f", "o0", "A0", "z0", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "r", "p", "y", "t2", "g1", "i1", "X", "e0", "", "c1", "h1", "j1", "O0", "j0", "i0", ICustomDataEditor.STRING_ARRAY_PARAM_2, "t3", "E1", "k1", "V", "E", "E2", "U1", "Y", "e2", "c0", "W1", "Y2", "o", "A1", "e3", "z1", "B1", "X2", "w", "v", "Lcom/tencent/sqshow/utils/featureswitch/model/t;", "l1", "m0", "c2", "p3", "s0", "u0", "r0", "o1", "b0", HippyTKDListViewAdapter.X, "l", "P0", "q0", "g0", "t0", "x0", "m1", "T1", "v2", "y0", "q3", "t", "q2", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "sFeatureService", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqfeatureswitch/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sListeners", "<init>", "()V", "MemeConfig", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFeatureSwitch {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanFeatureSwitch f369852a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static IFeatureRuntimeService sFeatureService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<c> sListeners;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/ZPlanFeatureSwitch$MemeConfig;", "", "()V", "greyTipsOn", "", "getGreyTipsOn", "()I", "tabReddotOn", "getTabReddotOn", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class MemeConfig {
        private final int greyTipsOn;
        private final int tabReddotOn;

        public final int getGreyTipsOn() {
            return this.greyTipsOn;
        }

        public final int getTabReddotOn() {
            return this.tabReddotOn;
        }
    }

    static {
        ZPlanFeatureSwitch zPlanFeatureSwitch = new ZPlanFeatureSwitch();
        f369852a = zPlanFeatureSwitch;
        sListeners = new ArrayList<>();
        zPlanFeatureSwitch.r3();
    }

    ZPlanFeatureSwitch() {
    }

    private final Map<String, String> A2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_mod_silent_download", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    private final boolean E0() {
        String str;
        if (!w3()) {
            return false;
        }
        double ceil = Math.ceil(m.c() / 1.073741824E9d);
        int x36 = x3();
        if (ceil < x36) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "enableZPlanPreload memory disable, return false, memoryGB: " + ceil + ", memoryConfig: " + x36);
            return false;
        }
        long lastZPlanUsingTimeStamp = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getLastZPlanUsingTimeStamp();
        if (lastZPlanUsingTimeStamp > 0) {
            int L0 = L0();
            double ceil2 = Math.ceil((((System.currentTimeMillis() - lastZPlanUsingTimeStamp) * 1.0d) / 1000) / 3600);
            double d16 = L0;
            if (ceil2 > d16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("enableZPlanPreload ");
                if (ceil2 > d16) {
                    str = "exceed time limit";
                } else {
                    str = " true";
                }
                sb5.append(str);
                sb5.append(", configDuration=");
                sb5.append(L0);
                sb5.append(", duration=");
                sb5.append(ceil2);
                sb5.append(", lastUsingTime=");
                sb5.append(lastZPlanUsingTimeStamp);
                QLog.i("[ZPlanFeatureSwitch]", 1, sb5.toString());
                return false;
            }
        }
        return true;
    }

    private final Map<String, String> K2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_tab_refresh_config", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    private final int L0() {
        al alVar = al.f335776a;
        return f369852a.W0("ZPlan", "zplan_active_using_duration", 24);
    }

    @JvmStatic
    public static final int Q1() {
        return f369852a.W0("ZPlan", "zplan_record_count_limit", 11) + (((IZPlanApi) QRoute.api(IZPlanApi.class)).isBigScreen() ? 3 : 0);
    }

    private final Map<String, String> b2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_avatar_dress_share_switch", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    private final Map<String, String> p2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_resource_req_limit", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    @JvmStatic
    public static final void s3() {
        ArrayList<c> arrayList = sListeners;
        if (!arrayList.isEmpty()) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "onFeatureUpdate, listener size=" + arrayList.size());
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    private final MemeConfig v1() {
        return (MemeConfig) GsonUtil.f385283b.a().fromJson(Y0("ZPlan", "meme_config_data", "{\"greyTipsOn\":0,\"tabReddotOn\":1}"), MemeConfig.class);
    }

    private final Map<String, String> z2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_mod_silent_download_reserve", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean A() {
        return W0("ZPlan", "zplan_game_in_main_world", 0) > 0;
    }

    public final boolean A0() {
        return W0("ZPlan", "zplan_filament_static_imageview", 1) > 0;
    }

    public final String A1() {
        return Y0("ZPlan", "ZplanCMShowNewerGuideEntranceName", "\u9009\u62e9\u865a\u62df\u5f62\u8c61");
    }

    public final boolean B() {
        return W0("ZPlan", "zplan_game_use_surfaceview", 1) > 0;
    }

    public final boolean B0() {
        return a1("ZPlan", "zplan_download_diff_enable", false);
    }

    public final String B1() {
        return Y0("ZPlan", "ZplanCMShowNewerGuideEntranceLink", "https://h5.cmshow.qq.com/next/newRoleType.html?_wv=16777223&_wwv=8704");
    }

    public final int B2() {
        return W0("ZPlan", "zplan_cmshow_ue_offscreen_height", 400);
    }

    public final boolean C() {
        return W0("ZPlan", "zplan_gif_frame_encode_immediately", 0) > 0;
    }

    public final boolean C0() {
        return a1("ZPlan", "zplan_mod_res_auto_clear", false);
    }

    public final String C1() {
        return Y0("ZPlan", "zplan_official_appearance_key", "");
    }

    public final String C2() {
        return Y0("ZPlan", "zplan_account_online_status_black_list", "1000,1030");
    }

    public final boolean D() {
        IFeatureRuntimeService r36 = r3();
        if (r36 == null) {
            return false;
        }
        return r36.isFeatureSwitchEnable("open_zplan_avatar_guest_entrance", false);
    }

    public final boolean D0() {
        return a1("ZPlan", "zplan_mod_version_skip_diff", false);
    }

    public final long D1() {
        return X0("ZPlan", "zplan_official_appearance_key_timestamp", 0L);
    }

    public final String D2() {
        return Y0("ZPlan", "zplan_account_online_status_to_portrait_id_mapping", "");
    }

    public final boolean E() {
        return W0("ZPlan", "enable_hide_zplan_avatar", 0) > 0;
    }

    public final long E1() {
        return X0("ZPlan", "enable_pause_queue_when_enter_background", 0L);
    }

    public final List<String> E2() {
        JSONObject b16;
        JSONArray optJSONArray;
        String Y0 = Y0("ZPlan", "zplan_pag_so_decoder_phone_list", "");
        if (Y0 == null || (b16 = com.tencent.zplan.common.utils.h.f385294a.b(Y0)) == null || (optJSONArray = b16.optJSONArray("PhoneList")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string = optJSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "scenes.getString(i)");
            arrayList.add(string);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final boolean F() {
        return a1("ZPlan", "zplan_long_appearance_key", false);
    }

    public final int F0() {
        return W0("ZPlan", "zplan_emo2d_gif_transparent_threshold", 150);
    }

    public final String F1() {
        al alVar = al.f335776a;
        return f369852a.Y0("ZPlan", "zplan_dynamic_avatar_lottie_url", "https://image.superqqshow.qq.com/qq/downqq/zplan_avatar_loading_animation.zip");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000f, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int F2() {
        Integer intOrNull;
        String str = K2().get("refreshInterval");
        if (str == null || intOrNull == null) {
            return 5;
        }
        return intOrNull.intValue();
    }

    public final boolean G() {
        return W0("ZPlan", "zplan_lua_bridge_call_native_on_async", 1) > 0;
    }

    public final boolean G0() {
        return a1("ZPlan", "zplan_emo2d_gif_use_white_background", false);
    }

    public final String G1() {
        return Y0("ZPlan", "zplan_qzone_concise_dynamic_avatar_config", "{\"dynamicImageWidth\":720,\"dynamicImageHeight\":1280,\"defaultWindowsillLocation\":0.359, \"defaultBottomLocation\":0.855,\"defaultTopLocation\":0.144}");
    }

    public final String G2() {
        return Y0("ZPlan", "zplan_preload_world_scene_data", "{\"ViewType\":1,\"HideResidence\":false,\"NeedActiveHotPatchUpdate\":true,\"Source\":\"em_zplan_entrance_qq_main_preload\",\"ViewportType\":1,\"SubScene\":{\"SceneType\":0},\"PlayMontage\":1}");
    }

    public final boolean H() {
        return W0("ZPlan", "zplan_record_meme_on_gender_changed", 1) > 0;
    }

    public final String H0() {
        return Y0("ZPlan", "aio_frame_anim_avatar_bubble_text", "\u53cc\u51fb\u7a7a\u767d\u5904\u53ef\u4ee5\u53ec\u5524/\u6536\u8d77\u6211\u54e6");
    }

    public final String H1() {
        return Y0("ZPlan", "zplan_qzone_concise_dynamic_record_config", "{\"timeout_retry_time\":1,\"lua_error_retry_code\":\"3,8,9,15,100\",\"lua_error_retry_time\":3}");
    }

    public final String H2() {
        return Y0("ZPlan", "zplan_qzone_avatar_config", "");
    }

    public final boolean I() {
        return W0("ZPlan", "zplan_meme_record_v2_reuse_runtime_data", 1) > 0;
    }

    public final String I0() {
        return Y0("ZPlan", "aio_frame_anim_avatar_config", "{\"dynamicImageWidth\":360,\"dynamicImageHeight\":640,\"flipEnable\":1,\"aioBubbleDuration\":5000,\"distancePercentage\":0.266}");
    }

    public final long I1() {
        al alVar = al.f335776a;
        return f369852a.X0("ZPlan", "zplan_qzone_pre_record_loading_timeout", 0L);
    }

    public final String I2() {
        return Y0("ZPlan", "get_zplan_qzone_avatar_play_strategy", "ZPlanQZoneAvatarPlayStrategy");
    }

    public final boolean J() {
        al alVar = al.f335776a;
        return f369852a.W0("ZPlan", "zplan_enable_meme_resume_engine_on_suspended", 1) > 0;
    }

    public final String J0() {
        return Y0("ZPlan", "action_sheet_go_portal", "\u66f4\u6362\u88c5\u626e");
    }

    public final int J1() {
        al alVar = al.f335776a;
        return f369852a.W0("ZPlan", "zplan_qzone_record_err_bubble_expiration", 15);
    }

    public final String J2() {
        return Y0("ZPlan", "zplan_cdn_upload_record_host", "home.thd.qq.com");
    }

    public final boolean K() {
        return Intrinsics.areEqual("1", A2().get("totalSwitch"));
    }

    public final String K0() {
        return Y0("ZPlan", "action_sheet_go_small_home", "\u8fdb\u5165\u8da3\u90bb");
    }

    public final String K1() {
        al alVar = al.f335776a;
        return f369852a.Y0("ZPlan", "zplan_qzone_record_err_bubble_text", "\u52a8\u4f5c\u5f55\u5236\u5931\u8d25");
    }

    public final boolean L() {
        return Intrinsics.areEqual("1", A2().get("enableKingCard"));
    }

    public final long L1() {
        al alVar = al.f335776a;
        return f369852a.X0("ZPlan", "zplan_qzone_record_loading_timeout", 120000L);
    }

    public final String L2() {
        return Y0("ZPlan", "zplan_ue4_switch_config", "");
    }

    public final boolean M() {
        return W0("ZPlan", "zplan_native_record_static_img", 1) > 0;
    }

    public final float M0() {
        al alVar = al.f335776a;
        return f369852a.V0("ZPlan", "zplan_aio_fullscreen_meme_stage_width_ratio", 0.7f);
    }

    public final int M1() {
        return W0("ZPlan", "zplan_realtime_event_polling_gap", 30);
    }

    public final Map<String, String> M2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_ue_env_config", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean N() {
        if (V2()) {
            return false;
        }
        boolean isZPlanEnable = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanEnable();
        boolean z16 = W0("ZPlan", "zplan_paralle_world", 0) > 0;
        boolean z17 = Math.ceil(((double) m.c()) / 1.073741824E9d) >= ((double) z3());
        QLog.i("[ZPlanFeatureSwitch]", 1, "enableParallelWorld : isZPlanEnable:" + isZPlanEnable + ", isWorldEnable: " + z16 + ", isMemoryEnable: " + z17);
        return isZPlanEnable && z16 && z17;
    }

    public final long N0() {
        return W0("ZPlan", "zplan_auto_record_meme_memory_threshold", 800) * 1024 * 1024;
    }

    public final int N1() {
        int parseInt;
        String Y0 = Y0("ZPlan", "zplan_record_thread_pool_size", "4,2,1");
        if (TextUtils.isEmpty(Y0)) {
            return 1;
        }
        Object[] array = new Regex(",").split(Y0, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr == null || strArr.length != 3) {
            return 1;
        }
        try {
            if (DeviceInfoUtils.isHighPerfDevice()) {
                parseInt = Integer.parseInt(strArr[0]);
            } else if (DeviceInfoUtils.isLowPerfDevice()) {
                parseInt = Integer.parseInt(strArr[2]);
            } else {
                parseInt = Integer.parseInt(strArr[1]);
            }
            return parseInt;
        } catch (NumberFormatException e16) {
            QLog.e("[ZPlanFeatureSwitch]", 1, "getRecordAsyncThreadMaxCount exception, config:" + Y0, e16);
            return 1;
        }
    }

    public final JSONObject N2() {
        al alVar = al.f335776a;
        return f369852a.Z0("ZPlan", "zootopia_back_toast", null);
    }

    public final boolean O() {
        boolean isZPlanEnable = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanEnable();
        boolean f36 = f3();
        boolean N = N();
        boolean z16 = W0("ZPlan", "zplan_preload_world", 0) > 0;
        boolean z17 = Math.ceil(((double) m.c()) / 1.073741824E9d) >= ((double) y3());
        QLog.i("[ZPlanFeatureSwitch]", 1, "enablePreloadWorld : isZPlanEnable:" + isZPlanEnable + ", isPreloadEnable: " + f36 + ", isWorldEnable: " + N + ", isPreloadWorldEnable: " + z16 + ", isMemoryEnable: " + z17);
        return isZPlanEnable && f36 && N && z16 && z17;
    }

    public final String O0() {
        return Y0("ZPlan", "zplan_avatar_config_rainbow_name", "action_and_bg_conf_v2");
    }

    public final int O1() {
        int parseInt;
        String Y0 = Y0("ZPlan", "zplan_record_delay_frames", "10,20,20");
        if (TextUtils.isEmpty(Y0)) {
            return 20;
        }
        Object[] array = new Regex(",").split(Y0, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr == null || strArr.length != 3) {
            return 20;
        }
        try {
            if (DeviceInfoUtils.isHighPerfDevice()) {
                parseInt = Integer.parseInt(strArr[0]);
            } else if (DeviceInfoUtils.isLowPerfDevice()) {
                parseInt = Integer.parseInt(strArr[2]);
            } else {
                parseInt = Integer.parseInt(strArr[1]);
            }
            return parseInt;
        } catch (NumberFormatException e16) {
            QLog.e("[ZPlanFeatureSwitch]", 1, "getRecordDelayFrames exception, config:" + Y0, e16);
            return 20;
        }
    }

    public final float O2() {
        return V0("ZPlan", "zplan_get_cover_frame_time", 33.333332f);
    }

    public final boolean P() {
        return W0("ZPlan", "zplan_qzone_concise_dynamic_avatar", 0) > 0;
    }

    public final String P0() {
        String str = b2().get("shareType");
        return str == null ? "0" : str;
    }

    public final int P1() {
        return W0("ZPlan", "zplan_frame_drawable_max_count", 20);
    }

    public final int P2() {
        return W0("ZPlan", "zplan_gif_limited_alpha", 10);
    }

    public final boolean Q() {
        al alVar = al.f335776a;
        return f369852a.a1("ZPlan", "zplan_qzone_enable_loading_anim", true);
    }

    public final String Q0() {
        al alVar = al.f335776a;
        return f369852a.Y0("ZPlan", "zplan_avatar_hot_patch_bg", "https://static-res.qq.com/static-res/zplan/hotpatch/zplan_avatar_hot_patch_bg.png");
    }

    public final String Q2() {
        return Y0("ZPlan", "zplan_setting_feedback_name", "\u95ee\u9898\u53cd\u9988");
    }

    public final boolean R() {
        return W0("ZPlan", "zplan_enable_record_in_new_obj", 1) > 0;
    }

    public final String R0() {
        al alVar = al.f335776a;
        return f369852a.Y0("ZPlan", "zplan_avatar_hot_patch_desc", "\u52a0\u8f7d\u4e2d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000f, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int R1() {
        Integer intOrNull;
        String str = A2().get("cacheValidHours");
        if (str == null || intOrNull == null) {
            return 8;
        }
        return intOrNull.intValue();
    }

    public final String R2() {
        return Y0("ZPlan", "zplan_setting_feedback_url", "https://ti.qq.com/tucao/index.html?productId=367198");
    }

    public final boolean S() {
        return W0("ZPlan", "zplan_record_meme_on_appearance_key_change", 1) > 0;
    }

    public final int S0() {
        return W0("ZPlan", "cmshow_meme_action_maximum_frame_count", 100);
    }

    public final String S1() {
        return Y0("ZPlan", "zplan_assistant_setting_entrance", "\u8d85\u7ea7QQ\u79c0\u8bbe\u7f6e");
    }

    public final String S2() {
        return Y0("ZPlan", "zplan_setting_qzone_switch_desc", "\u5173\u95ed\u540e\uff0c\u5c06\u4e0d\u4f1a\u5728\u597d\u53cb\u52a8\u6001\u9875\u5c55\u793a\u865a\u62df\u5f62\u8c61\u548c\u5546\u57ce\u9875\u5165\u53e3");
    }

    public final boolean T() {
        return W0("ZPlan", "zplan_record_meme_on_enter_aio", 0) > 0;
    }

    public final long T0() {
        return X0("ZPlan", "zplan_cloud_cache_max_waiting_time", 10000L);
    }

    public final boolean T1() {
        return b1("zplan_dress_up_share_record_use_filament", false);
    }

    public final String T2() {
        return Y0("ZPlan", "zplan_setting_qzone_switch", "\u52a8\u6001\u9875");
    }

    public final boolean U() {
        return W0("ZPlan", "zplan_record_queue_pause", 1) > 0;
    }

    public final int U0() {
        return W0("ZPlan", "zplan_cloud_resource_download_timeout", 30);
    }

    public final JSONObject U1() {
        return Z0("ZPlan", "zplan_small_home_float_window_config", (JSONObject) al.f335776a.a());
    }

    public final String U2() {
        return Y0("ZPlan", "zplan_setting_title", "\u8d85\u7ea7QQ\u79c0\u8bbe\u7f6e");
    }

    public final boolean V() {
        return b1("zplan_enable_record_with_userdata", false);
    }

    public final float V0(String key, String secondaryKey, float defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        IFeatureRuntimeService r36 = r3();
        if (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (string = r36.getString(secondaryKey, "")) == null) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(string);
        } catch (Exception e16) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "getConfig error", e16);
            return defaultValue;
        }
    }

    public final boolean V1() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        return iFeatureRuntimeService != null && iFeatureRuntimeService.isFeatureSwitchEnable("zplan_mod_silent_auth", false);
    }

    public final boolean V2() {
        boolean contains$default;
        String Y0 = Y0("ZPlan", "zplan_black_uin_list", "8538762,18451021,2843646474,352658087,2328666549,211770364,85797612,3028885050,1349814675");
        if (TextUtils.isEmpty(Y0)) {
            return false;
        }
        String valueOf = String.valueOf(((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin());
        if (TextUtils.isEmpty(valueOf)) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) Y0, (CharSequence) valueOf, false, 2, (Object) null);
        return contains$default;
    }

    public final boolean W() {
        return W0("ZPlan", "zplan_report_dynamic_avatar_to_da_tong", 1) > 0;
    }

    public final int W0(String key, String secondaryKey, int defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        IFeatureRuntimeService r36 = r3();
        if (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (string = r36.getString(secondaryKey, "")) == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(string);
        } catch (Exception e16) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "getConfig error", e16);
            return defaultValue;
        }
    }

    public final String W1() {
        return Y0("ZPlan", "UploadUnRecordZPlanAvatarHint", "\u6b63\u5728\u52a0\u8f7d\u8d44\u6e90,\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    public final boolean W2() {
        return W0("ZPlan", "zplan_aio_entrance_btn_show", 0) > 0;
    }

    public final boolean X() {
        return W0("ZPlan", "zplan_enable_report_easter_egg", 1) > 0;
    }

    public final long X0(String key, String secondaryKey, long defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        IFeatureRuntimeService r36 = r3();
        if (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (string = r36.getString(secondaryKey, "")) == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(string);
        } catch (Exception e16) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "getConfig error", e16);
            return defaultValue;
        }
    }

    public final String X1() {
        return Y0("ZPlan", "zplan_avatar_background_color", "#EBEDF4");
    }

    public final boolean X2() {
        return W0("ZPlan", "CMShowKeywordAssociation", 1) > 0;
    }

    public final boolean Y() {
        return W0("ZPlan", "enable_report_zplan_avatar", 1) > 0;
    }

    public final String Y0(String key, String secondaryKey, String defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        IFeatureRuntimeService r36 = r3();
        return (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (string = r36.getString(secondaryKey, "")) == null) ? defaultValue : string;
    }

    public final float Y1() {
        return V0("ZPlan", "zplan_avatar_video_bitrate_ratio", 4.0f);
    }

    public final boolean Y2() {
        return W0("ZPlan", "CMShowMemeTabInFace", 0) > 0;
    }

    public final boolean Z() {
        return Intrinsics.areEqual("1", z2().get("enableInZplan"));
    }

    public final JSONObject Z0(String key, String secondaryKey, JSONObject defaultValue) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        IFeatureRuntimeService r36 = r3();
        return (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (jSONObject = r36.getJSONObject(secondaryKey, "")) == null) ? defaultValue : jSONObject;
    }

    public final float Z1() {
        return V0("ZPlan", "zplan_avatar_video_bitrate_ratio_in_list", 0.5f);
    }

    public final boolean Z2() {
        return a1("ZPlan", "zplan_download_in_zplan_process", false);
    }

    public final boolean a() {
        return W0("ZPlan", "zplan_profile_avatar_change_jump_make_up_page", 1) > 0;
    }

    public final boolean a0() {
        return Intrinsics.areEqual("1", z2().get("enableOuterZplan"));
    }

    public final boolean a1(String key, String secondaryKey, boolean defaultValue) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(secondaryKey, "secondaryKey");
        IFeatureRuntimeService r36 = r3();
        if (r36 == null || !r36.isFeatureSwitchEnable(secondaryKey, false) || (string = r36.getString(secondaryKey, "")) == null) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(string);
        } catch (Exception unused) {
            return defaultValue;
        }
    }

    public final long a2() {
        return X0("ZPlan", "zplan_get_zplan_avatar_drawable_delay_time", 100L);
    }

    public final boolean a3() {
        return W0("ZPlan", "zplan_avatar_request_sticker_info_from_server", 1) > 0;
    }

    public final long b() {
        return X0("ZPlan", "zplan_cmshow_check_apng_frame_size", 1048576L);
    }

    public final boolean b0() {
        return b1("zplan_enable_upload_js_record_result", true);
    }

    public final boolean b1(String toggleKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(toggleKey, "toggleKey");
        IFeatureRuntimeService r36 = r3();
        return r36 == null ? defaultValue : r36.isFeatureSwitchEnable(toggleKey, defaultValue);
    }

    public final boolean b3() {
        MemeConfig v16 = v1();
        return v16 != null && v16.getTabReddotOn() > 0;
    }

    public final boolean c() {
        return a.f409621a.a(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "zplan_enable_filament_save_in_sdcard", false);
    }

    public final boolean c0() {
        return W0("ZPlan", "EnableUploadUnRecordZPlanAvatar", 0) > 0;
    }

    public final List<Integer> c1() {
        JSONObject b16;
        JSONArray optJSONArray;
        String Y0 = Y0("ZPlan", "zplan_enter_avatar_continue_record", "{\"SceneList\":[0,1]}");
        if (Y0 == null || (b16 = com.tencent.zplan.common.utils.h.f385294a.b(Y0)) == null || (optJSONArray = b16.optJSONArray("SceneList")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Integer.valueOf(optJSONArray.getInt(i3)));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final String c2() {
        return Y0("ZPlan", "get_zplan_avatar_event_tag_content", "\u9650\u65f6");
    }

    public final boolean c3() {
        return a1("ZPlan", "zplan_download_l2n_enable_newimpl", false);
    }

    public final boolean d() {
        return W0("ZPlan", "zplan_detect_error_on_l2n_end", 1) > 0;
    }

    public final boolean d0() {
        IFeatureRuntimeService r36 = r3();
        if (r36 == null) {
            return false;
        }
        return r36.isFeatureSwitchEnable("qq_expression_zplan_tab_redDotID", false);
    }

    public final int d1() {
        return W0("ZPlan", "zplan_crash_max_count", 3);
    }

    public final int d2() {
        return W0("ZPlan", "zplan_avatar_frame_rate", 120);
    }

    public final boolean d3() {
        int W0 = W0("ZPlan", "zplan_qzone_concise_dynamic_memory_threshold", 5);
        long c16 = m.c();
        long j3 = c16 / 1073741824;
        QLog.i("[ZPlanFeatureSwitch]", 1, "isMemoryThresholdEnableDynamicAvatar, threshlod=" + W0 + " GB, memoryGB=" + j3 + " GB  memoryB=" + c16 + " B");
        return c16 == 0 || j3 >= ((long) W0);
    }

    public final boolean e() {
        return W0("ZPlan", "cmshow_disable_sso_request", 1) > 0;
    }

    public final boolean e0() {
        IFeatureRuntimeService r36 = r3();
        if (r36 == null) {
            return false;
        }
        return r36.isFeatureSwitchEnable("zplan_enable_shp_cache_v2", false);
    }

    public final int e1() {
        return W0("ZPlan", "zplan_crash_time_interval", 120000);
    }

    public final String e2() {
        return Y0("ZPlan", "ZplanAvatarTitleString", "\u8d85\u7ea7QQ\u79c0\u5934\u50cf");
    }

    public final boolean e3() {
        return W0("ZPlan", "CMShowNewerGuideEntranceShow", 1) > 0;
    }

    public final boolean f() {
        return a1("ZPlan", "cmshow_disable_hardware_support", true);
    }

    public final boolean f0() {
        return W0("ZPlan", "zplan_gif_txt_config", 1) > 0;
    }

    public final int f1() {
        return W0("ZPlan", "zplan_dynamic_avatar_record_repeat_time", 3);
    }

    public final String f2() {
        return Y0("ZPlan", "zplan_avatar_video_bitrate_ratio_black_list", "HUAWEI,HONOR");
    }

    public final boolean f3() {
        if (V2()) {
            return false;
        }
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanEnable() && E0();
    }

    public final boolean g() {
        return W0("ZPlan", "zplan_edit_avatar_upload_with_check_appearance_key", 0) > 0;
    }

    public final boolean g0() {
        return W0("ZPlan", "enable_easter_egg_request_cloud_cache", 1) > 0;
    }

    public final long g1() {
        return X0("ZPlan", "zplan_cartoon_resource_ready_wait_time_limit", 5000L);
    }

    public final String g2() {
        return Y0("ZPlan", "zplan_cdn_upload_host", "zplan.gtimg.cn");
    }

    public final boolean g3() {
        return a.f409621a.a(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "zplan_preload_process_enable", false);
    }

    public final float h() {
        return V0("ZPlan", "zplan_emoticon_2d_radius", 10.0f);
    }

    public final boolean h0() {
        return W0("ZPlan", "zplan_apng_avatar", 0) > 0;
    }

    public final long h1() {
        return X0("ZPlan", "zplan_easter_egg_portrait_local_expiration_interval", 31536000000L);
    }

    public final Map<String, String> h2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_common_config", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean h3() {
        return a.f409621a.a(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "zplan_preload_enable", false);
    }

    public final boolean i() {
        return W0("ZPlan", "zplan_aio_gif_config", 1) > 0;
    }

    public final boolean i0() {
        return W0("ZPlan", "enable_zplan_avatar_action_list_out_frame", 0) > 0;
    }

    public final long i1() {
        return X0("ZPlan", "zplan_easter_egg_portrait_record_time_out", 120000L);
    }

    public final Map<String, String> i2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_dns_config", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean i3() {
        return W0("ZPlan", "zplan_frame_drawable_low_memory_mode", 1) > 0;
    }

    public final boolean j() {
        return W0("ZPlan", "zplan_apng_frame_encode_immediately", 0) > 0;
    }

    public final boolean j0() {
        return W0("ZPlan", "enable_zplan_avatar_out_frame", 1) > 0;
    }

    public final String j1() {
        return Y0("ZPlan", "getEasterEggPortraitWrongAppearanceInfo", "");
    }

    public final Map<String, String> j2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_httpdns_key", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean j3() {
        return W0("ZPlan", "zplan_frame_play_open", 1) > 0;
    }

    public final boolean k() {
        return W0("ZPlan", "zplan_enable_avatar_bubble", 1) > 0;
    }

    public final boolean k0() {
        return a1("ZPlan", "zplan_avatar_suit_pre_download", false);
    }

    public final long k1() {
        return X0("ZPlan", "get_easter_egg_show_avatar_animate_duration", 200L);
    }

    public final long k2() {
        return X0("ZPlan", "zplan_download_http_live_time", 60L);
    }

    public final boolean k3() {
        return Intrinsics.areEqual("1", z2().get("needNotification"));
    }

    public final boolean l() {
        String str = b2().get("enableShare");
        if (str == null) {
            return true;
        }
        return Intrinsics.areEqual("1", str);
    }

    public final boolean l0() {
        return W0("ZPlan", "zplan_cmshow_avatar_video_compress", 1) > 0;
    }

    public final ZPlanEmoticonAvatarIconConfig l1() {
        ZPlanEmoticonAvatarIconConfig zPlanEmoticonAvatarIconConfig = new ZPlanEmoticonAvatarIconConfig(6085, 72, "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultFemaleMemeIcon.png", "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultMaleMemeIcon.png", false);
        IFeatureRuntimeService r36 = r3();
        if (r36 == null) {
            return zPlanEmoticonAvatarIconConfig;
        }
        try {
            Map<String, String> isEnabledWithDataSet = r36.isEnabledWithDataSet("zplan_enable_emoticon_avatar_icon", "");
            if (isEnabledWithDataSet == null) {
                return zPlanEmoticonAvatarIconConfig;
            }
            String str = isEnabledWithDataSet.get("action_id");
            int parseInt = str != null ? Integer.parseInt(str) : 6085;
            String str2 = isEnabledWithDataSet.get("avatar_size");
            int parseInt2 = str2 != null ? Integer.parseInt(str2) : 72;
            String str3 = isEnabledWithDataSet.get("default_female_url");
            if (str3 == null) {
                str3 = "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultFemaleMemeIcon.png";
            }
            String str4 = str3;
            String str5 = isEnabledWithDataSet.get("default_male_url");
            if (str5 == null) {
                str5 = "https://static-res.qq.com/static-res/zplan/aio/tab_icon/defaultMaleMemeIcon.png";
            }
            String str6 = str5;
            String str7 = isEnabledWithDataSet.get("need_upload");
            return new ZPlanEmoticonAvatarIconConfig(parseInt, parseInt2, str4, str6, str7 != null ? Boolean.parseBoolean(str7) : false);
        } catch (Exception e16) {
            QLog.i("[ZPlanFeatureSwitch]", 1, "getEmoticonAvatarIconConfig error: " + e16);
            return zPlanEmoticonAvatarIconConfig;
        }
    }

    public final Map<String, String> l2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_enable_multi_thread", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean l3() {
        return W0("ZPlan", "zplan_aio_avatar", 1) == 1;
    }

    public final boolean m() {
        return W0("ZPlan", "zplan_cloud_cache_appearance_key_check", 0) > 0;
    }

    public final boolean m0() {
        return W0("ZPlan", "enable_zPlan_curr_avatar_move_to_first_pos", 1) > 0;
    }

    public final long m1() {
        return X0("ZPlan", "zplan_filament_portal_loading_delay_time", 100L);
    }

    public final int m2() {
        return W0("ZPlan", "zplan_download_optimize_thread_pool_size", 16);
    }

    public final boolean m3() {
        al alVar = al.f335776a;
        return f369852a.a1("ZPlan", "zplan_enable_meme_block_send", false);
    }

    public final boolean n() {
        return W0("ZPlan", "zplan_enable_cloud_record_on_aio_emotion_tab", 1) > 0;
    }

    public final boolean n0() {
        return W0("ZPlan", "zplan_download_optimize", 1) > 0;
    }

    public final String n1() {
        return Y0("ZPlan", "zplan_home_page_tab_config_v2", "");
    }

    public final Map<String, String> n2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_download_queue_manager", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final boolean n3() {
        return W0("ZPlan", "zplan_kill_process_when_preload", 1) > 0;
    }

    public final boolean o() {
        return W0("ZPlan", "CMShowMiniApiUsageReduce", 1) == 1;
    }

    public final String o0() {
        return Y0("ZPlan", "zplan_head_easter_egg", "{\"aio\":0, \"recent\":0}");
    }

    public final JSONObject o1() {
        return Z0("ZPlan", "zplan_intercept_url_with_native_list", new JSONObject());
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x001e, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int o2(int scene) {
        Integer intOrNull;
        String str = p2().get("Scene_" + scene);
        if (str == null || intOrNull == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    public final boolean o3() {
        return !f3() && Intrinsics.areEqual(Y0("ZPlan", "zplan_kill_process_when_portal_exit", "1"), "1");
    }

    public final boolean p() {
        return false;
    }

    public final boolean p0() {
        return W0("ZPlan", "enable_zplan_easter_egg_batch_query", 1) > 0;
    }

    public final int p1() {
        return W0("ZPlan", "zplan_limit_frame_count_for_sharpp_comptess_rate", 1);
    }

    public final boolean p3() {
        return W0("ZPlan", "easter_egg_need_out_bound_avatar", 1) > 0;
    }

    public final boolean q() {
        return false;
    }

    public final boolean q0() {
        return W0("ZPlan", "enable_zplan_easter_egg_download_and_upload_2_zplan_server", 1) > 0;
    }

    public final String q1() {
        return Y0("ZPlan", "zplan_loading_record_avatar_info", "");
    }

    public final int q2() {
        return W0("ZPlan", "zplan_easter_egg_support_version", 0);
    }

    public final boolean q3() {
        int W0 = W0("ZPlan", "zplan_filament_portal_need_record_first_frame", 0);
        QLog.i("[ZPlanFeatureSwitch]", 1, "needRecordFirstFrameInPortal config: " + W0);
        return W0 > 0;
    }

    public final boolean r() {
        return false;
    }

    public final boolean r0() {
        return W0("ZPlan", "enable_zplan_easter_egg_pre_download_pag", 0) > 0;
    }

    public final int r1() {
        return W0("ZPlan", "zplan_rrc_local_res_upload_try_count", 3);
    }

    public final long r2() {
        return X0("ZPlan", "zplan_edit_avatar_check_expire_cloud_delay_time", JoinTimeType.SEVEN_DAY);
    }

    public final synchronized IFeatureRuntimeService r3() {
        AppRuntime peekAppRuntime;
        if (sFeatureService == null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            sFeatureService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        return sFeatureService;
    }

    public final boolean s() {
        return false;
    }

    public final boolean s0() {
        return W0("ZPlan", "enable_zplan_easter_egg_record_separate_single", 1) > 0;
    }

    public final int s1() {
        return W0("ZPlan", "zplan_meme_cover_maximum_frame_count", 10);
    }

    public final long s2() {
        return X0("ZPlan", "zplan_edit_avatar_check_expire_local_delay_time", 0L);
    }

    public final boolean t() {
        return W0("ZPlan", "zplan_filament_dynamic_pause_on_background", 1) > 0;
    }

    public final boolean t0() {
        return W0("ZPlan", "enable_easter_egg_record_upload", 1) > 0;
    }

    public final int t1() {
        return W0("ZPlan", "zplan_meme_engine_error_try_count", 2);
    }

    public final long t2() {
        return X0("ZPlan", "zplan_filament_delay_release_time", 10000L);
    }

    public final boolean t3() {
        return X0("ZPlan", "enable_pause_queue_when_enter_background", 0L) > 0;
    }

    public final boolean u() {
        return W0("ZPlan", "zplan_emoticon_2d_gif_switch", 1) > 0;
    }

    public final boolean u0() {
        return W0("ZPlan", "enable_zplan_easter_egg_record_with_v2", 1) > 0;
    }

    public final int u1() {
        return W0("ZPlan", "zplan_meme_frame_waiting_index", 1);
    }

    public final float u2() {
        return V0("ZPlan", "zplan_get_cover_frame_time", 33.333332f);
    }

    public final boolean u3() {
        return W0("ZPlan", "zplan_meme_report_on_hit_cache", 0) > 0;
    }

    public final boolean v() {
        boolean b16 = b1("zplan_enable_emoticon_avatar_icon", false);
        QLog.i("[ZPlanFeatureSwitch]", 1, "enableEmoticonAvatarIcon status: " + b16);
        return b16;
    }

    public final boolean v0() {
        return W0("ZPlan", "enable_zplan_easter_egg_single_query", 1) > 0;
    }

    public final JSONObject v2() {
        try {
            return new JSONObject(Y0("ZPlan", "zplan_lite_pre_compiled_shader", "{}"));
        } catch (Throwable th5) {
            QLog.e("[ZPlanFeatureSwitch]", 1, "getZPlanLitePreCompiledShader parse json error: ", th5);
            return new JSONObject();
        }
    }

    public final boolean v3() {
        return W0("ZPlan", "zplan_aio_show_gif_loading", 0) > 0;
    }

    public final boolean w() {
        return W0("ZPlan", "enable_emotion_record_optimization", 1) > 0;
    }

    public final boolean w0() {
        return W0("ZPlan", "zplan_edit_avatar_check_expire", 1) > 0;
    }

    public final int w1() {
        return W0("ZPlan", "zplan_meme_shp_estimate_compress_rate", 2);
    }

    public final int w2() {
        return W0("ZPlan", "zplan_meme_action_maximum_frame_count", 150);
    }

    public final boolean w3() {
        return W0("ZPlan", "zplan_preload_enable", 0) > 0;
    }

    public final boolean x() {
        return W0("ZPlan", "enable_filament_inner_resource", 1) > 0;
    }

    public final boolean x0() {
        return W0("ZPlan", "zplan_filament_portal_first_frame_enable", 1) > 0;
    }

    public final int x1() {
        return W0("ZPlan", "zplan_meme_shp_quality_parameter", 27);
    }

    public final Map<String, String> x2() {
        IFeatureRuntimeService iFeatureRuntimeService = sFeatureService;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet("zplan_mod_hot_patch", "") : null;
        return isEnabledWithDataSet == null ? new LinkedHashMap() : isEnabledWithDataSet;
    }

    public final int x3() {
        return W0("ZPlan", "zplan_preload_memory", 8);
    }

    public final boolean y() {
        return W0("ZPlan", "zplan_filament_use_somanager", 0) > 0;
    }

    public final boolean y0() {
        boolean isFilamentEnabled = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isFilamentEnabled();
        int W0 = W0("ZPlan", "zplan_filament_portal_stop_engine_enable", 0);
        QLog.i("[ZPlanFeatureSwitch]", 1, "enableZPlanFilamentPortalStopEngine config: " + W0 + ", enableFilament: " + isFilamentEnabled);
        if (W0 > 0) {
            return true;
        }
        return !isFilamentEnabled;
    }

    public final int y1() {
        return W0("ZPlan", "zplan_meme_task_id_start_from", 0);
    }

    public final String y2() {
        return Y0("ZPlan", "zplan_mod_res_url_rule", "");
    }

    public final int y3() {
        return W0("ZPlan", "zplan_preload_world_memory_threshold", 12);
    }

    public final boolean z() {
        return W0("ZPlan", "zplan_white_list_check_get_gpu_info", 1) > 0;
    }

    public final boolean z0() {
        return W0("ZPlan", "zplan_filament_release", 1) > 0;
    }

    public final String z1() {
        return Y0("ZPlan", "CMShowNewerGuideEntranceLink", "https://open.cmshow.qq.com/next/registerProcess.html?_wv=16777223&_wwv=8704");
    }

    public final int z3() {
        return W0("ZPlan", "zplan_paralle_world_memory_threshold", 8);
    }
}
