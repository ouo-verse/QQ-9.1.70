package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msglist.holder.component.msgreply.MsgReplyProcessorInject;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.en;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.anonymous.api.IAnonymousApi;
import com.tencent.qqnt.aio.api.IAIOVasAvatarPendantExtApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemExtApi;
import com.tencent.qqnt.aio.nick.MemberLevelInfoCache;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00dc\u00022\u00020\u0001:\u0002\u0098\u0003B\u0011\u0012\u0006\u0010:\u001a\u00020\b\u00a2\u0006\u0006\b\u0096\u0003\u0010\u0097\u0003J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0002J\u0006\u0010\u0007\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0000H\u0017J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u001e2\u0006\u0010\u0004\u001a\u00020\u0001H\u0015J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020\u000eJ\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u000202H\u0016J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\fH\u0016R\u0017\u0010:\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R$\u0010P\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010<\u001a\u0004\bR\u0010>\"\u0004\bS\u0010@R$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010l\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010s\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010v\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010n\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR\"\u0010z\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010n\u001a\u0004\bx\u0010p\"\u0004\by\u0010rR%\u0010\u0082\u0001\u001a\u00020{8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R.\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0014\n\u0004\bL\u0010n\u001a\u0005\b\u0084\u0001\u0010p\"\u0005\b\u0085\u0001\u0010rR&\u0010\u008a\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0087\u0001\u0010n\u001a\u0005\b\u0088\u0001\u0010p\"\u0005\b\u0089\u0001\u0010rR&\u0010\u008e\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008b\u0001\u0010n\u001a\u0005\b\u008c\u0001\u0010p\"\u0005\b\u008d\u0001\u0010rR,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0091\u0001\u001a\u0006\b\u0098\u0001\u0010\u0093\u0001\"\u0006\b\u0099\u0001\u0010\u0095\u0001R+\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b3\u0010\u0091\u0001\u001a\u0006\b\u009b\u0001\u0010\u0093\u0001\"\u0006\b\u009c\u0001\u0010\u0095\u0001R'\u0010\u00a2\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\u000f\u0010|\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b\u00a0\u0001\u0010\u00a1\u0001R%\u0010\u00a5\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b1\u0010n\u001a\u0005\b\u00a3\u0001\u0010p\"\u0005\b\u00a4\u0001\u0010rR&\u0010\u00a9\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a6\u0001\u0010n\u001a\u0005\b\u00a7\u0001\u0010p\"\u0005\b\u00a8\u0001\u0010rR$\u0010\u00ab\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bR\u0010n\u001a\u0004\bm\u0010p\"\u0005\b\u00aa\u0001\u0010rR&\u0010\u00af\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00ac\u0001\u0010n\u001a\u0005\b\u00ad\u0001\u0010p\"\u0005\b\u00ae\u0001\u0010rR&\u0010\u00b3\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b0\u0001\u0010n\u001a\u0005\b\u00b1\u0001\u0010p\"\u0005\b\u00b2\u0001\u0010rR&\u0010\u00b7\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b4\u0001\u0010n\u001a\u0005\b\u00b5\u0001\u0010p\"\u0005\b\u00b6\u0001\u0010rR%\u0010\u00ba\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bx\u0010n\u001a\u0005\b\u00b8\u0001\u0010p\"\u0005\b\u00b9\u0001\u0010rR+\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bn\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001\"\u0006\b\u00bf\u0001\u0010\u00c0\u0001R,\u0010\u00c9\u0001\u001a\u0005\u0018\u00010\u00c2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001\u001a\u0006\b\u00c5\u0001\u0010\u00c6\u0001\"\u0006\b\u00c7\u0001\u0010\u00c8\u0001R+\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0015\u0010\u00bc\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00be\u0001\"\u0006\b\u00cb\u0001\u0010\u00c0\u0001R,\u0010\u00d0\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00cd\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00be\u0001\"\u0006\b\u00cf\u0001\u0010\u00c0\u0001R+\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bX\u0010\u00bc\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00be\u0001\"\u0006\b\u00d2\u0001\u0010\u00c0\u0001R,\u0010\u00db\u0001\u001a\u0005\u0018\u00010\u00d4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001\"\u0006\b\u00d9\u0001\u0010\u00da\u0001R,\u0010\u00e2\u0001\u001a\u0005\u0018\u00010\u00dc\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00dd\u0001\u0010\u00de\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00df\u0001\"\u0006\b\u00e0\u0001\u0010\u00e1\u0001R2\u0010\u00e8\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00bb\u0001\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00e5\u0001\"\u0006\b\u00e6\u0001\u0010\u00e7\u0001R,\u0010\u00ef\u0001\u001a\u0005\u0018\u00010\u00e9\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u00ea\u0001\u001a\u0006\b\u00eb\u0001\u0010\u00ec\u0001\"\u0006\b\u00ed\u0001\u0010\u00ee\u0001R%\u0010\u00f2\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00f0\u0001\u0010n\u001a\u0004\bV\u0010p\"\u0005\b\u00f1\u0001\u0010rR,\u0010\u00fa\u0001\u001a\u0005\u0018\u00010\u00f3\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00f4\u0001\u0010\u00f5\u0001\u001a\u0006\b\u00f6\u0001\u0010\u00f7\u0001\"\u0006\b\u00f8\u0001\u0010\u00f9\u0001R+\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u00fb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0092\u0001\u0010\u00fc\u0001\u001a\u0005\b^\u0010\u00fd\u0001\"\u0006\b\u00fe\u0001\u0010\u00ff\u0001R,\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0081\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0002\u0010\u0083\u0002\u001a\u0006\b\u008b\u0001\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R,\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u0089\u0002\u001a\u0006\b\u0087\u0001\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R*\u0010\u0094\u0002\u001a\u00030\u008e\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0002\u0010\u0090\u0002\u001a\u0006\b\u00f0\u0001\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R2\u0010\u0098\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u0095\u0002\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0096\u0002\u0010\u00e4\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00e5\u0001\"\u0006\b\u0097\u0002\u0010\u00e7\u0001R(\u0010\u009a\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0099\u0002\u0010w\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R(\u0010\u00a1\u0002\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u009e\u0002\u0010|\u001a\u0006\b\u009f\u0002\u0010\u009f\u0001\"\u0006\b\u00a0\u0002\u0010\u00a1\u0001R&\u0010\u00a4\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a2\u0002\u0010n\u001a\u0005\b\u0090\u0001\u0010p\"\u0005\b\u00a3\u0002\u0010rR%\u0010\u00a6\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u0098\u0001\u0010n\u001a\u0004\b|\u0010p\"\u0005\b\u00a5\u0002\u0010rR<\u0010\u00ac\u0002\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u00a8\u00020\u00a7\u0002j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030\u00a8\u0002`\u00a9\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00d7\u0001\u0010\u00aa\u0002\u001a\u0006\b\u0097\u0001\u0010\u00ab\u0002R:\u0010\u00ad\u0002\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00a7\u0002j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u00a9\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u00aa\u0002\u001a\u0006\b\u0096\u0002\u0010\u00ab\u0002R)\u0010\u00b2\u0002\u001a\u0010\u0012\u0005\u0012\u00030\u00af\u0002\u0012\u0004\u0012\u00020\f0\u00ae\u00028\u0006\u00a2\u0006\u000f\n\u0005\bC\u0010\u00b0\u0002\u001a\u0006\b\u00f4\u0001\u0010\u00b1\u0002R)\u0010\u00b8\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u00b3\u0002\u001a\u0006\b\u00b4\u0002\u0010\u00b5\u0002\"\u0006\b\u00b6\u0002\u0010\u00b7\u0002R(\u0010\u00bb\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00c5\u0001\u0010w\u001a\u0006\b\u00b9\u0002\u0010\u009b\u0002\"\u0006\b\u00ba\u0002\u0010\u009d\u0002R(\u0010\u00be\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00bc\u0002\u0010w\u001a\u0006\b\u00ac\u0001\u0010\u009b\u0002\"\u0006\b\u00bd\u0002\u0010\u009d\u0002R,\u0010\u00c5\u0002\u001a\u0005\u0018\u00010\u00bf\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c0\u0002\u0010\u00c1\u0002\u001a\u0006\b\u00d5\u0001\u0010\u00c2\u0002\"\u0006\b\u00c3\u0002\u0010\u00c4\u0002R+\u0010\u00cb\u0002\u001a\u0005\u0018\u00010\u00c6\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b=\u0010\u00c7\u0002\u001a\u0006\b\u00dd\u0001\u0010\u00c8\u0002\"\u0006\b\u00c9\u0002\u0010\u00ca\u0002R(\u0010\u00ce\u0002\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bo\u0010\u00b3\u0002\u001a\u0006\b\u00cc\u0002\u0010\u00b5\u0002\"\u0006\b\u00cd\u0002\u0010\u00b7\u0002R'\u0010\u00d0\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00d1\u0001\u0010w\u001a\u0005\bQ\u0010\u009b\u0002\"\u0006\b\u00cf\u0002\u0010\u009d\u0002R(\u0010\u00d2\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00ca\u0001\u0010w\u001a\u0006\b\u00a6\u0001\u0010\u009b\u0002\"\u0006\b\u00d1\u0002\u0010\u009d\u0002R7\u0010\u00d8\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ce\u0001\u0010\u00d3\u0002\u001a\u0006\b\u00d4\u0002\u0010\u00d5\u0002\"\u0006\b\u00d6\u0002\u0010\u00d7\u0002R&\u0010\u00db\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a7\u0001\u0010n\u001a\u0005\b\u00d9\u0002\u0010p\"\u0005\b\u00da\u0002\u0010rR&\u0010\u00de\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a3\u0001\u0010n\u001a\u0005\b\u00dc\u0002\u0010p\"\u0005\b\u00dd\u0002\u0010rR%\u0010\u00e0\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00ad\u0001\u0010n\u001a\u0004\bf\u0010p\"\u0005\b\u00df\u0002\u0010rR/\u0010\u00e5\u0002\u001a\u0005\u0018\u00010\u00e1\u00022\n\u0010\u00e2\u0002\u001a\u0005\u0018\u00010\u00e1\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b)\u0010\u00e3\u0002\u001a\u0006\b\u0082\u0002\u0010\u00e4\u0002R\u0017\u0010\u00e6\u0002\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010nR+\u0010\u00e9\u0002\u001a\u0005\u0018\u00010\u00e7\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b$\u0010\u00e8\u0002\u001a\u0006\b\u00e9\u0002\u0010\u00ea\u0002\"\u0006\b\u00eb\u0002\u0010\u00ec\u0002R%\u0010\u00ee\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00d9\u0002\u0010n\u001a\u0004\bw\u0010p\"\u0005\b\u00ed\u0002\u0010rR'\u0010\u00f0\u0002\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b-\u0010w\u001a\u0006\b\u00c0\u0002\u0010\u009b\u0002\"\u0006\b\u00ef\u0002\u0010\u009d\u0002R%\u0010\u00f2\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u001d\u0010n\u001a\u0005\b\u008f\u0002\u0010p\"\u0005\b\u00f1\u0002\u0010rR%\u0010\u00f4\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0006\u0010n\u001a\u0005\b\u00bc\u0002\u0010p\"\u0005\b\u00f3\u0002\u0010rR,\u0010\u00fb\u0002\u001a\u0005\u0018\u00010\u00f5\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b5\u0001\u0010\u00f6\u0002\u001a\u0006\b\u00f7\u0002\u0010\u00f8\u0002\"\u0006\b\u00f9\u0002\u0010\u00fa\u0002R&\u0010\u00fe\u0002\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00fc\u0002\u0010n\u001a\u0005\b\u00c3\u0001\u0010p\"\u0005\b\u00fd\u0002\u0010rR,\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u00ff\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R&\u0010\u0088\u0003\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b1\u0001\u0010n\u001a\u0005\b\u00fc\u0002\u0010p\"\u0005\b\u0087\u0003\u0010rR!\u0010\u008d\u0003\u001a\u00030\u0089\u00038FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b8\u0001\u0010\u008a\u0003\u001a\u0006\b\u008b\u0003\u0010\u008c\u0003R\u001a\u0010\u008e\u0003\u001a\u0005\u0018\u00010\u008f\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00e3\u0001\u0010\u0093\u0001R\u0014\u0010\u008f\u0003\u001a\u00020\u00188F\u00a2\u0006\b\u001a\u0006\b\u009e\u0002\u0010\u009f\u0001R\u0014\u0010\u0090\u0003\u001a\u00020\f8F\u00a2\u0006\b\u001a\u0006\b\u00a2\u0002\u0010\u00b5\u0002R\u0014\u0010\u0091\u0003\u001a\u00020\u000e8F\u00a2\u0006\b\u001a\u0006\b\u0099\u0002\u0010\u009b\u0002R'\u0010\u0092\u0003\u001a\u00020\u00052\u0007\u0010\u00e2\u0002\u001a\u00020\u00058F@BX\u0086\u000e\u00a2\u0006\r\n\u0005\b\u0092\u0003\u0010n\u001a\u0004\bn\u0010pR\u0013\u0010\u0093\u0003\u001a\u00020\u00058F\u00a2\u0006\u0007\u001a\u0005\b\u0080\u0003\u0010pR\u0014\u0010\u0095\u0003\u001a\u00020\f8F\u00a2\u0006\b\u001a\u0006\b\u0094\u0003\u0010\u00b5\u0002\u00a8\u0006\u0099\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/aio/data/msglist/a;", "", "y", "target", "", "O0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", DomainData.DOMAIN_NAME, "W0", "", SemanticAttributes.DbSystemValues.H2, "", BdhLogUtil.LogTag.Tag_Req, "Landroid/content/Context;", "context", "", "Y0", "X0", "b0", "newMsgItem", "l", "", "getMsgId", "getMsgSeq", "getViewType", "isSameContent", "N0", "Lkotlin/Pair;", "o", "isSameItem", "", "getChangePayload", "isSelf", "K0", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getFirstTypeElement", "e2", "I0", "V0", "J0", "k", "M0", "g2", "d2", "f2", ExifInterface.LATITUDE_SOUTH, "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f1", "toString", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "f", "Ljava/lang/CharSequence;", "A0", "()Ljava/lang/CharSequence;", "setTime", "(Ljava/lang/CharSequence;)V", "time", tl.h.F, "v0", "W1", "showNickName", "i", HippyTKDListViewAdapter.X, "setContentDescriptionNickName", "contentDescriptionNickName", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "K", "()Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "t1", "(Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;)V", "memberInfo", BdhLogUtil.LogTag.Tag_Conn, "U", "A1", "multiForwardMsgNickName", "Lcom/tencent/qqnt/aio/nick/i;", "D", "Lcom/tencent/qqnt/aio/nick/i;", "d0", "()Lcom/tencent/qqnt/aio/nick/i;", "H1", "(Lcom/tencent/qqnt/aio/nick/i;)V", "nickNameDrawInfo", "Lcom/tencent/qqnt/aio/nick/a;", "E", "Lcom/tencent/qqnt/aio/nick/a;", "B", "()Lcom/tencent/qqnt/aio/nick/a;", "setFlashNameData", "(Lcom/tencent/qqnt/aio/nick/a;)V", "flashNameData", "Landroid/content/res/ColorStateList;", UserInfo.SEX_FEMALE, "Landroid/content/res/ColorStateList;", "r", "()Landroid/content/res/ColorStateList;", "c1", "(Landroid/content/res/ColorStateList;)V", "bgTextColor", "G", "Z", "B0", "()Z", "c2", "(Z)V", "transformFailed", "H", "q1", "hasRead", "I", "Y", "E1", "needShowAnim", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileTransNotifyInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "setFileTransNotifyInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "fileTransNotifyInfo", "value", "w0", "X1", "showTimeStampFlag", "L", "getTimeStampChanged", "b2", "timeStampChanged", "M", "u0", "V1", "showNewMsgTip", "Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "N", "Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "k0", "()Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "L1", "(Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;)V", "relyMsgRecordParams", "P", "s0", "O1", "rootMsgRecordParams", "h0", "J1", "parentMsgRecordParams", "m0", "()J", "M1", "(J)V", "replyRealSourceMsgId", "G0", "j1", "isFlowMessage", "T", "F0", "h1", "isDui", "p1", "hasPlayedDui", "V", "H0", "l1", "isGagMode", "W", "S0", "S1", "isShotMode", "X", "P0", "P1", "isSelectMode", "T0", "T1", "isShotMsg", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getAnonymousAvatarDrawable", "()Landroid/graphics/drawable/Drawable;", "setAnonymousAvatarDrawable", "(Landroid/graphics/drawable/Drawable;)V", "anonymousAvatarDrawable", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "a0", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "x0", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "Y1", "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;)V", "skinBubbleInfo", "D0", "setVipIconDrawable", "vipIconDrawable", "c0", "E0", "setVipIconExtDrawable", "vipIconExtDrawable", "C0", "setVipGameIconDrawable", "vipGameIconDrawable", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "e0", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "t0", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "R1", "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;)V", "shootBubbleInfo", "Lcom/tencent/qqnt/aio/msg/e;", "f0", "Lcom/tencent/qqnt/aio/msg/e;", "()Lcom/tencent/qqnt/aio/msg/e;", Constants.BASE_IN_PLUGIN_ID, "(Lcom/tencent/qqnt/aio/msg/e;)V", "mutualMaskInfo", "g0", "Ljava/util/List;", "()Ljava/util/List;", "C1", "(Ljava/util/List;)V", "mutualMaskDrawableList", "Lcom/tencent/qqnt/aio/avatar/egg/a;", "Lcom/tencent/qqnt/aio/avatar/egg/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/aio/avatar/egg/a;", "b1", "(Lcom/tencent/qqnt/aio/avatar/egg/a;)V", "avatarEggInfo", "i0", "m1", "getAvatarEgg", "Lcom/tencent/qqnt/aio/essence/a;", "j0", "Lcom/tencent/qqnt/aio/essence/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/aio/essence/a;", "i1", "(Lcom/tencent/qqnt/aio/essence/a;)V", "essenceInfo", "Lcom/tencent/qqnt/aio/nick/gradelevel/a;", "Lcom/tencent/qqnt/aio/nick/gradelevel/a;", "()Lcom/tencent/qqnt/aio/nick/gradelevel/a;", ICustomDataEditor.NUMBER_PARAM_1, "(Lcom/tencent/qqnt/aio/nick/gradelevel/a;)V", "gradeLevelInfo", "Lcom/tencent/qqnt/aio/nick/f;", "l0", "Lcom/tencent/qqnt/aio/nick/f;", "()Lcom/tencent/qqnt/aio/nick/f;", "v1", "(Lcom/tencent/qqnt/aio/nick/f;)V", "memberLevelInfo", "Lcom/tencent/qqnt/aio/nick/e;", "Lcom/tencent/qqnt/aio/nick/e;", "()Lcom/tencent/qqnt/aio/nick/e;", "u1", "(Lcom/tencent/qqnt/aio/nick/e;)V", "memberLevelDrawableInfo", "Lcom/tencent/qqnt/aio/nick/k;", "n0", "Lcom/tencent/qqnt/aio/nick/k;", "()Lcom/tencent/qqnt/aio/nick/k;", "K1", "(Lcom/tencent/qqnt/aio/nick/k;)V", "qCircleRedDotInfo", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "o0", Constants.APK_CERTIFICATE, "nickIconData", "p0", "isPaiYiPaiNeedEffectAvatar", "()I", "I1", "(I)V", "q0", "O", "y1", "msgAnimTime", "r0", "x1", "msgAnimFlag", ICustomDataEditor.STRING_PARAM_1, "loadAvatarPendantFlag", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "msgAttrsMap", "resChangeMap", "", "Lcom/tencent/mobileqq/aio/msg/RefreshType;", "Ljava/util/Map;", "()Ljava/util/Map;", "refreshKeyMap", "Ljava/lang/String;", "w", "()Ljava/lang/String;", "g1", "(Ljava/lang/String;)V", "contentDescription", "getAvatarChangeFlag", "setAvatarChangeFlag", "avatarChangeFlag", "y0", "B1", "multiSelectFlag", "Lcom/tencent/qqnt/avatar/i;", "z0", "Lcom/tencent/qqnt/avatar/i;", "()Lcom/tencent/qqnt/avatar/i;", "setOptionVasAvatarData", "(Lcom/tencent/qqnt/avatar/i;)V", "optionVasAvatarData", "Lcom/tencent/qqnt/avatar/j;", "Lcom/tencent/qqnt/avatar/j;", "()Lcom/tencent/qqnt/avatar/j;", "setOptionVasPendantData", "(Lcom/tencent/qqnt/avatar/j;)V", "optionVasPendantData", "u", "e1", "chatBgPath", "k1", "forwardType", "z1", "msgViewHeight", "Lkotlin/Pair;", "t", "()Lkotlin/Pair;", "d1", "(Lkotlin/Pair;)V", "bubbleScreenInfo", "L0", "w1", "isMosaic", "U0", "U1", "isShowMsgReplyMsg", "o1", "hasMsgReplyClicked", "Lcom/tencent/mobileqq/aio/msg/v;", "<set-?>", "Lcom/tencent/mobileqq/aio/msg/v;", "()Lcom/tencent/mobileqq/aio/msg/v;", "replyParam", "transformed", "Lcom/tencent/mobileqq/aio/bubble/a;", "Lcom/tencent/mobileqq/aio/bubble/a;", "isShootBubbleInfo", "()Lcom/tencent/mobileqq/aio/bubble/a;", "setShootBubbleInfo", "(Lcom/tencent/mobileqq/aio/bubble/a;)V", "r1", "lastReceiveMsgFlag", ICustomDataEditor.STRING_ARRAY_PARAM_2, "themeChangeFlag", "N1", "requestAccessibilityFocus", "Z1", "supportTts", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/graphics/Rect;", "setContentMargin", "(Landroid/graphics/Rect;)V", "contentMargin", "Q0", "F1", "needShowReplySuggestionTail", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "R0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "p", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;)V", "appIconBindData", "Q1", "isSendBySelf", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lkotlin/Lazy;", "v", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "outMsgRecordParams", "rootMsgId", "rootMsgPeerId", "rootMsgChatType", "needShowReply", "isShootBubble", ReportConstant.COSTREPORT_PREFIX, "bubbleId", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOMsgItem extends com.tencent.aio.data.msglist.a {
    static IPatchRedirector $redirector_;

    /* renamed from: U0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final MsgRecord V0;

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.j optionVasPendantData;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private String chatBgPath;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private CharSequence multiForwardMsgNickName;

    /* renamed from: C0, reason: from kotlin metadata */
    private int forwardType;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.nick.i nickNameDrawInfo;

    /* renamed from: D0, reason: from kotlin metadata */
    private int msgViewHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.nick.a flashNameData;

    /* renamed from: E0, reason: from kotlin metadata */
    @Nullable
    private Pair<Integer, Integer> bubbleScreenInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ColorStateList bgTextColor;

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean isMosaic;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean transformFailed;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean isShowMsgReplyMsg;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hasRead;

    /* renamed from: H0, reason: from kotlin metadata */
    private boolean hasMsgReplyClicked;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needShowAnim;

    /* renamed from: I0, reason: from kotlin metadata */
    @Nullable
    private v replyParam;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private FileTransNotifyInfo fileTransNotifyInfo;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean transformed;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean showTimeStampFlag;

    /* renamed from: K0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.bubble.a isShootBubbleInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean timeStampChanged;

    /* renamed from: L0, reason: from kotlin metadata */
    private boolean lastReceiveMsgFlag;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean showNewMsgTip;

    /* renamed from: M0, reason: from kotlin metadata */
    private int themeChangeFlag;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private MsgRecordParams relyMsgRecordParams;

    /* renamed from: N0, reason: from kotlin metadata */
    private boolean requestAccessibilityFocus;

    /* renamed from: O0, reason: from kotlin metadata */
    private boolean supportTts;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private MsgRecordParams rootMsgRecordParams;

    /* renamed from: P0, reason: from kotlin metadata */
    @Nullable
    private Rect contentMargin;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private MsgRecordParams parentMsgRecordParams;

    /* renamed from: Q0, reason: from kotlin metadata */
    private boolean needShowReplySuggestionTail;

    /* renamed from: R, reason: from kotlin metadata */
    private long replyRealSourceMsgId;

    /* renamed from: R0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c appIconBindData;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isFlowMessage;

    /* renamed from: S0, reason: from kotlin metadata */
    private boolean isSendBySelf;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isDui;

    /* renamed from: T0, reason: from kotlin metadata */
    @NotNull
    private final Lazy contact;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean hasPlayedDui;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isGagMode;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isShotMode;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isSelectMode;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isShotMsg;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private Drawable anonymousAvatarDrawable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOBubbleSkinInfo skinBubbleInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable vipIconDrawable;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable vipIconExtDrawable;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable vipGameIconDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.skin.a shootBubbleInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence time;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.msg.e mutualMaskInfo;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends Drawable> mutualMaskDrawableList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence showNickName;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.avatar.egg.a avatarEggInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence contentDescriptionNickName;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean getAvatarEgg;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.essence.a essenceInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.nick.gradelevel.a gradeLevelInfo;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.nick.f memberLevelInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MemberInfo memberInfo;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.nick.e memberLevelDrawableInfo;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.aio.nick.k qCircleRedDotInfo;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> nickIconData;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private int isPaiYiPaiNeedEffectAvatar;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private long msgAnimTime;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean msgAnimFlag;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean loadAvatarPendantFlag;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, MsgAttributeInfo> msgAttrsMap;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> resChangeMap;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<RefreshType, String> refreshKeyMap;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String contentDescription;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private int avatarChangeFlag;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private int multiSelectFlag;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.i optionVasAvatarData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "EmptyMsgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "ENABLE_PAYLOAD_LOG", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.AIOMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MsgRecord a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOMsgItem.V0;
            }
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 184)) {
            redirector.redirect((short) 184);
        } else {
            INSTANCE = new Companion(null);
            V0 = new MsgRecord();
        }
    }

    public AIOMsgItem(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        this.msgRecord = msgRecord;
        this.time = "";
        this.showNickName = "";
        this.contentDescriptionNickName = com.tencent.mobileqq.aio.utils.al.i(msgRecord);
        this.multiForwardMsgNickName = "";
        this.fileTransNotifyInfo = new FileTransNotifyInfo();
        this.replyRealSourceMsgId = -1L;
        this.qCircleRedDotInfo = new com.tencent.qqnt.aio.nick.k(false, null, null, 7, null);
        this.msgAttrsMap = new HashMap<>();
        this.resChangeMap = com.tencent.qqnt.aio.msg.f.c(this);
        this.refreshKeyMap = MapsKt.mapOf(new Pair(RefreshType.REFRESH_WITH_MSGID, String.valueOf(getMsgId())), new Pair(RefreshType.REFRESH_WITH_UID, msgRecord.senderUid.toString()), new Pair(RefreshType.REFRESH_WITH_UIN, String.valueOf(msgRecord.senderUin)));
        this.contentDescription = "";
        this.chatBgPath = "";
        this.forwardType = -1;
        com.tencent.mobileqq.aio.utils.e eVar = com.tencent.mobileqq.aio.utils.e.f194142a;
        this.bubbleScreenInfo = new Pair<>(Integer.valueOf(eVar.f()), Integer.valueOf(eVar.e()));
        this.contact = LazyKt.lazy(new Function0<Contact>() { // from class: com.tencent.mobileqq.aio.msg.AIOMsgItem$contact$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgItem.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Contact invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new Contact(AIOMsgItem.this.getMsgRecord().chatType, AIOMsgItem.this.getMsgRecord().peerUid, AIOMsgItem.this.getMsgRecord().guildId) : (Contact) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    private final boolean O0(com.tencent.aio.data.msglist.a target) {
        AIOMsgItem aIOMsgItem;
        if (target instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) target;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            if (aIOMsgItem.msgRecord.msgType != this.msgRecord.msgType || !Intrinsics.areEqual(getClass(), target.getClass())) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static /* synthetic */ void Z0(AIOMsgItem aIOMsgItem, Context context, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                context = null;
            }
            aIOMsgItem.Y0(context);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTransform");
    }

    private final MsgRecordParams g0() {
        MsgRecordParams msgRecordParams = this.rootMsgRecordParams;
        if (msgRecordParams == null) {
            return this.relyMsgRecordParams;
        }
        return msgRecordParams;
    }

    private final CharSequence y() {
        MsgRecord msgRecord = this.msgRecord;
        if (msgRecord.chatType == 2) {
            return this.showNickName;
        }
        String str = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str, "{\n            msgRecord.sendNickName\n        }");
        return str;
    }

    @Nullable
    public final com.tencent.qqnt.aio.essence.a A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (com.tencent.qqnt.aio.essence.a) iPatchRedirector.redirect((short) 78, (Object) this);
        }
        return this.essenceInfo;
    }

    @NotNull
    public final CharSequence A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.time;
    }

    public final void A1(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) charSequence);
        } else {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.multiForwardMsgNickName = charSequence;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.nick.a B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.qqnt.aio.nick.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.flashNameData;
    }

    public final boolean B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.transformFailed;
    }

    public final void B1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, i3);
        } else {
            this.multiSelectFlag = i3;
        }
    }

    public final int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return ((Integer) iPatchRedirector.redirect((short) 115, (Object) this)).intValue();
        }
        return this.forwardType;
    }

    @Nullable
    public final Drawable C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (Drawable) iPatchRedirector.redirect((short) 66, (Object) this);
        }
        return this.vipGameIconDrawable;
    }

    public final void C1(@Nullable List<? extends Drawable> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) list);
        } else {
            this.mutualMaskDrawableList = list;
        }
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Boolean) iPatchRedirector.redirect((short) 76, (Object) this)).booleanValue();
        }
        return this.getAvatarEgg;
    }

    @Nullable
    public final Drawable D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Drawable) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        return this.vipIconDrawable;
    }

    public final void D1(@Nullable com.tencent.qqnt.aio.msg.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) eVar);
        } else {
            this.mutualMaskInfo = eVar;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.nick.gradelevel.a E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (com.tencent.qqnt.aio.nick.gradelevel.a) iPatchRedirector.redirect((short) 80, (Object) this);
        }
        return this.gradeLevelInfo;
    }

    @Nullable
    public final Drawable E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (Drawable) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.vipIconExtDrawable;
    }

    public final void E1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.needShowAnim = z16;
        }
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            return ((Boolean) iPatchRedirector.redirect((short) 126, (Object) this)).booleanValue();
        }
        return this.hasMsgReplyClicked;
    }

    public final boolean F0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.isDui;
    }

    public final void F1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, (Object) this, z16);
        } else {
            this.needShowReplySuggestionTail = z16;
        }
    }

    public final boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.hasPlayedDui;
    }

    public final boolean G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.isFlowMessage;
    }

    public final void G1(@Nullable List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, (Object) list);
        } else {
            this.nickIconData = list;
        }
    }

    public final boolean H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.hasRead;
    }

    public final boolean H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.isGagMode;
    }

    public final void H1(@Nullable com.tencent.qqnt.aio.nick.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iVar);
        } else {
            this.nickNameDrawInfo = iVar;
        }
    }

    public final boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            return ((Boolean) iPatchRedirector.redirect((short) 133, (Object) this)).booleanValue();
        }
        return this.lastReceiveMsgFlag;
    }

    public boolean I0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 171)) {
            return ((Boolean) iPatchRedirector.redirect((short) 171, (Object) this)).booleanValue();
        }
        if (p0() == 1 || p0() == 2) {
            return true;
        }
        return false;
    }

    public final void I1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, i3);
        } else {
            this.isPaiYiPaiNeedEffectAvatar = i3;
        }
    }

    public final boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Boolean) iPatchRedirector.redirect((short) 98, (Object) this)).booleanValue();
        }
        return this.loadAvatarPendantFlag;
    }

    public boolean J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 173)) {
            return ((Boolean) iPatchRedirector.redirect((short) 173, (Object) this)).booleanValue();
        }
        if (p0() == 1 || p0() == 2) {
            return true;
        }
        return false;
    }

    public final void J1(@Nullable MsgRecordParams msgRecordParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) msgRecordParams);
        } else {
            this.parentMsgRecordParams = msgRecordParams;
        }
    }

    @Nullable
    public final MemberInfo K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MemberInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.memberInfo;
    }

    public final boolean K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 167)) {
            return ((Boolean) iPatchRedirector.redirect((short) 167, (Object) this)).booleanValue();
        }
        if (this.msgRecord.sendType == 1) {
            return true;
        }
        return false;
    }

    public final void K1(@NotNull com.tencent.qqnt.aio.nick.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) kVar);
        } else {
            Intrinsics.checkNotNullParameter(kVar, "<set-?>");
            this.qCircleRedDotInfo = kVar;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.nick.e L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (com.tencent.qqnt.aio.nick.e) iPatchRedirector.redirect((short) 84, (Object) this);
        }
        return this.memberLevelDrawableInfo;
    }

    public final boolean L0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return ((Boolean) iPatchRedirector.redirect((short) 121, (Object) this)).booleanValue();
        }
        return this.isMosaic;
    }

    public final void L1(@Nullable MsgRecordParams msgRecordParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) msgRecordParams);
        } else {
            this.relyMsgRecordParams = msgRecordParams;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.nick.f M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            return (com.tencent.qqnt.aio.nick.f) iPatchRedirector.redirect((short) 82, (Object) this);
        }
        return this.memberLevelInfo;
    }

    public boolean M0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 175)) {
            return ((Boolean) iPatchRedirector.redirect((short) 175, (Object) this)).booleanValue();
        }
        return false;
    }

    public final void M1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, j3);
        } else {
            this.replyRealSourceMsgId = j3;
        }
    }

    public final boolean N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return ((Boolean) iPatchRedirector.redirect((short) 96, (Object) this)).booleanValue();
        }
        return this.msgAnimFlag;
    }

    public final boolean N0(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 162)) {
            return ((Boolean) iPatchRedirector.redirect((short) 162, (Object) this, (Object) target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof AIOMsgItem)) {
            return false;
        }
        List<MsgElement> h16 = MsgExtKt.h(this.msgRecord);
        List<MsgElement> h17 = MsgExtKt.h(((AIOMsgItem) target).msgRecord);
        if (Intrinsics.areEqual(h16, h17)) {
            return true;
        }
        if (h16 == null || h17 == null || h16.size() != h17.size()) {
            return false;
        }
        int size = h17.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!com.tencent.mobileqq.aio.utils.ai.k(h17.get(i3), h16.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final void N1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, z16);
        } else {
            this.requestAccessibilityFocus = z16;
        }
    }

    public final long O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Long) iPatchRedirector.redirect((short) 94, (Object) this)).longValue();
        }
        return this.msgAnimTime;
    }

    public final void O1(@Nullable MsgRecordParams msgRecordParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) msgRecordParams);
        } else {
            this.rootMsgRecordParams = msgRecordParams;
        }
    }

    @NotNull
    public final HashMap<Integer, MsgAttributeInfo> P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (HashMap) iPatchRedirector.redirect((short) 100, (Object) this);
        }
        return this.msgAttrsMap;
    }

    public final boolean P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        return this.isSelectMode;
    }

    public final void P1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            this.isSelectMode = z16;
        }
    }

    @NotNull
    public List<CharSequence> Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 181)) {
            return (List) iPatchRedirector.redirect((short) 181, (Object) this);
        }
        return new ArrayList();
    }

    public final boolean Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            return ((Boolean) iPatchRedirector.redirect((short) 147, (Object) this)).booleanValue();
        }
        return this.isSendBySelf;
    }

    public final void Q1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            iPatchRedirector.redirect((short) 148, (Object) this, z16);
        } else {
            this.isSendBySelf = z16;
        }
    }

    public int R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            return ((Integer) iPatchRedirector.redirect((short) 153, (Object) this)).intValue();
        }
        return this.msgRecord.sendStatus;
    }

    public final boolean R0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            return ((Boolean) iPatchRedirector.redirect((short) 131, (Object) this)).booleanValue();
        }
        if (this.isShootBubbleInfo == null) {
            this.isShootBubbleInfo = new com.tencent.mobileqq.aio.bubble.a(this);
        }
        com.tencent.mobileqq.aio.bubble.a aVar = this.isShootBubbleInfo;
        Intrinsics.checkNotNull(aVar);
        return aVar.c();
    }

    public final void R1(@Nullable com.tencent.mobileqq.aio.msglist.holder.skin.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) aVar);
        } else {
            this.shootBubbleInfo = aVar;
        }
    }

    public int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 180)) {
            return ((Integer) iPatchRedirector.redirect((short) 180, (Object) this)).intValue();
        }
        return 1;
    }

    public final boolean S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return this.isShotMode;
    }

    public final void S1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, z16);
        } else {
            this.isShotMode = z16;
        }
    }

    public final int T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return ((Integer) iPatchRedirector.redirect((short) 117, (Object) this)).intValue();
        }
        return this.msgViewHeight;
    }

    public final boolean T0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        return this.isShotMsg;
    }

    public final void T1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
        } else {
            this.isShotMsg = z16;
        }
    }

    @NotNull
    public final CharSequence U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.multiForwardMsgNickName;
    }

    public final boolean U0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            return ((Boolean) iPatchRedirector.redirect((short) 124, (Object) this)).booleanValue();
        }
        return this.isShowMsgReplyMsg;
    }

    public final void U1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, (Object) this, z16);
        } else {
            this.isShowMsgReplyMsg = z16;
        }
    }

    public final int V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return ((Integer) iPatchRedirector.redirect((short) 107, (Object) this)).intValue();
        }
        return this.multiSelectFlag;
    }

    public int V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 172)) {
            return ((Integer) iPatchRedirector.redirect((short) 172, (Object) this)).intValue();
        }
        return 0;
    }

    public final void V1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.showNewMsgTip = z16;
        }
    }

    @Nullable
    public final List<Drawable> W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (List) iPatchRedirector.redirect((short) 72, (Object) this);
        }
        return this.mutualMaskDrawableList;
    }

    public boolean W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            return ((Boolean) iPatchRedirector.redirect((short) 151, (Object) this)).booleanValue();
        }
        if (this.supportTts && com.tencent.mobileqq.aio.utils.d.o(this)) {
            return true;
        }
        return false;
    }

    public final void W1(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
        } else {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.showNickName = charSequence;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.msg.e X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (com.tencent.qqnt.aio.msg.e) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        return this.mutualMaskInfo;
    }

    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            iPatchRedirector.redirect((short) 155, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAIOMsgItemExtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAIOMsgItemExtApi::class.java)");
        IAIOMsgItemExtApi iAIOMsgItemExtApi = (IAIOMsgItemExtApi) api;
        this.msgAttrsMap.putAll(this.msgRecord.msgAttrs);
        if (this.memberLevelInfo == null && this.msgRecord.chatType == 2) {
            MemberLevelInfoCache b16 = MemberLevelInfoCache.INSTANCE.b();
            String str = this.msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
            String str2 = this.msgRecord.senderUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.senderUid");
            com.tencent.qqnt.aio.nick.f e16 = b16.e(str, str2);
            this.memberLevelInfo = e16;
            if (e16 != null) {
                String str3 = this.msgRecord.senderUid;
                Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.senderUid");
                e16.o(str3);
                String str4 = this.msgRecord.peerUid;
                Intrinsics.checkNotNullExpressionValue(str4, "msgRecord.peerUid");
                e16.n(str4);
            }
        }
        this.memberLevelDrawableInfo = iAIOMsgItemExtApi.getMemberLevelDrawable(this);
        this.vipIconDrawable = iAIOMsgItemExtApi.getVipIconDrawable(this);
        this.vipIconExtDrawable = iAIOMsgItemExtApi.getVipIconExtDrawable(this);
        this.vipGameIconDrawable = iAIOMsgItemExtApi.getVipGameDrawable(this);
        this.mutualMaskDrawableList = iAIOMsgItemExtApi.getMutualMaskDrawableList(this);
        this.optionVasAvatarData = ((IAIOVasAvatarPendantExtApi) QRoute.api(IAIOVasAvatarPendantExtApi.class)).getOptionVasAvatarData(this);
        this.optionVasPendantData = ((IAIOVasAvatarPendantExtApi) QRoute.api(IAIOVasAvatarPendantExtApi.class)).getOptionVasPendantData(this);
        this.showNickName = com.tencent.mobileqq.aio.utils.d.i(this);
        this.contentDescriptionNickName = y();
        com.tencent.qqnt.aio.nick.j jVar = com.tencent.qqnt.aio.nick.j.f351725a;
        if (jVar.d(this)) {
            this.nickNameDrawInfo = jVar.b(this.showNickName);
        }
        this.flashNameData = jVar.a(this);
        if (this.isShootBubbleInfo == null) {
            this.isShootBubbleInfo = new com.tencent.mobileqq.aio.bubble.a(this);
        }
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            this.contentDescription = f1();
        }
    }

    public final void X1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.showTimeStampFlag = z16;
        }
    }

    public final boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.needShowAnim;
    }

    @CallSuper
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 154)) {
            iPatchRedirector.redirect((short) 154, (Object) this, (Object) context);
            return;
        }
        this.transformed = true;
        try {
            CharSequence f16 = en.f(BaseApplication.getContext(), 3, this.msgRecord.msgTime * 1000, true, true);
            Intrinsics.checkNotNullExpressionValue(f16, "formatDateTime(\n        \u2026       true\n            )");
            this.time = f16;
            if (com.tencent.mobileqq.aio.utils.d.s(this)) {
                this.anonymousAvatarDrawable = ((IAnonymousApi) QRoute.api(IAnonymousApi.class)).getAvatarDrawable(this);
            }
            this.replyParam = MsgReplyProcessorInject.f191200a.e(this);
            this.hasMsgReplyClicked = MsgExtKt.z(this.msgRecord);
            W0();
        } catch (ArrayIndexOutOfBoundsException unused) {
            long j3 = this.msgRecord.msgTime;
            DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(BaseApplication.getContext());
            Intrinsics.checkNotNull(timeFormat, "null cannot be cast to non-null type java.text.SimpleDateFormat");
            throw new IllegalArgumentException("msgRecordTime is " + j3 + ", timeFormat is " + ((SimpleDateFormat) timeFormat).toLocalizedPattern());
        }
    }

    public final void Y1(@Nullable AIOBubbleSkinInfo aIOBubbleSkinInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) aIOBubbleSkinInfo);
        } else {
            this.skinBubbleInfo = aIOBubbleSkinInfo;
        }
    }

    public final boolean Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return ((Boolean) iPatchRedirector.redirect((short) 123, (Object) this)).booleanValue();
        }
        if (this.isShowMsgReplyMsg && !this.hasMsgReplyClicked && !isSelf()) {
            return true;
        }
        return false;
    }

    public final void Z1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, z16);
        } else {
            this.supportTts = z16;
        }
    }

    public final boolean a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            return ((Boolean) iPatchRedirector.redirect((short) 143, (Object) this)).booleanValue();
        }
        return this.needShowReplySuggestionTail;
    }

    public final void a1(@Nullable com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            iPatchRedirector.redirect((short) 146, (Object) this, (Object) cVar);
        } else {
            this.appIconBindData = cVar;
        }
    }

    public final void a2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, i3);
        } else {
            this.themeChangeFlag = i3;
        }
    }

    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 156, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new AIOMsgItem(targetMsgRecord);
    }

    public final void b1(@Nullable com.tencent.qqnt.aio.avatar.egg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) aVar);
        } else {
            this.avatarEggInfo = aVar;
        }
    }

    public final void b2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.timeStampChanged = z16;
        }
    }

    @Nullable
    public final List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (List) iPatchRedirector.redirect((short) 88, (Object) this);
        }
        return this.nickIconData;
    }

    public final void c1(@Nullable ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) colorStateList);
        } else {
            this.bgTextColor = colorStateList;
        }
    }

    public final void c2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.transformFailed = z16;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.nick.i d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.qqnt.aio.nick.i) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.nickNameDrawInfo;
    }

    public final void d1(@Nullable Pair<Integer, Integer> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this, (Object) pair);
        } else {
            this.bubbleScreenInfo = pair;
        }
    }

    public boolean d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 178)) {
            return ((Boolean) iPatchRedirector.redirect((short) 178, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.i e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return (com.tencent.qqnt.avatar.i) iPatchRedirector.redirect((short) 109, (Object) this);
        }
        return this.optionVasAvatarData;
    }

    public final void e1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.chatBgPath = str;
        }
    }

    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            return ((Boolean) iPatchRedirector.redirect((short) 170, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final com.tencent.qqnt.avatar.j f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return (com.tencent.qqnt.avatar.j) iPatchRedirector.redirect((short) 111, (Object) this);
        }
        return this.optionVasPendantData;
    }

    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 182)) {
            return (String) iPatchRedirector.redirect((short) 182, (Object) this);
        }
        return "";
    }

    public boolean f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 179)) {
            return ((Boolean) iPatchRedirector.redirect((short) 179, (Object) this)).booleanValue();
        }
        return false;
    }

    public final void g1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contentDescription = str;
        }
    }

    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 177)) {
            return ((Boolean) iPatchRedirector.redirect((short) 177, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        AIOMsgItem aIOMsgItem;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 165)) {
            return iPatchRedirector.redirect((short) 165, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        if (target instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) target;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null) {
            AIOMsgItem aIOMsgItem2 = (AIOMsgItem) target;
            if (aIOMsgItem2.timeStampChanged) {
                hashMap.put(AIOMsgItemPayloadType.TIMESTAMP_PAYLOAD, a.bd.f192647a);
            }
            int i3 = this.msgRecord.sendStatus;
            int i16 = aIOMsgItem2.msgRecord.sendStatus;
            if (i3 != i16) {
                hashMap.put(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD, new a.ay(i16));
            }
            com.tencent.mobileqq.aio.msglist.holder.skin.a aVar = this.shootBubbleInfo;
            boolean z17 = false;
            if (aVar != null && aVar.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                hashMap.put(AIOMsgItemPayloadType.SHOOT_BUBBLE_PAYLOAD, a.az.f192642a);
            }
            if (!com.tencent.qqnt.aio.msg.d.B(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.MUTUAL_MASK_PAYLOAD, a.ae.f192620a);
            }
            if (!com.tencent.qqnt.aio.msg.d.o(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.AVATAR_EGG_PAYLOAD, a.g.f192660a);
            }
            com.tencent.qqnt.aio.essence.a aVar2 = this.essenceInfo;
            if (aVar2 != null) {
                z17 = aVar2.a();
            }
            if (z17) {
                hashMap.put(AIOMsgItemPayloadType.ESSENCE_TAIL_PAYLOAD, a.m.f192666a);
            }
            if (!com.tencent.qqnt.aio.msg.d.A(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.MSG_EMO_REPLY_PAYLOAD, a.ac.f192618a);
            }
            if (!com.tencent.qqnt.aio.msg.d.D(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.QQ_STRANGER_TAIL_PAYLOAD, a.aq.f192633a);
            }
            if (!com.tencent.qqnt.aio.msg.d.x(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.GRADE_LEVEL_PAYLOAD, a.s.f192672a);
            }
            if (!com.tencent.qqnt.aio.msg.d.z(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.MEMBER_LEVEL_PAYLOAD, a.z.f192679a);
            }
            if (this.isPaiYiPaiNeedEffectAvatar == 1) {
                hashMap.put(AIOMsgItemPayloadType.PaiYiPai_PAYLOAD, a.ai.f192624a);
            }
            if (!com.tencent.qqnt.aio.msg.d.p(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD, a.i.f192662a);
            }
            if (!com.tencent.qqnt.aio.msg.d.w(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VAS_FONT_PAYLOAD, a.bi.f192652a);
            }
            if (!com.tencent.qqnt.aio.msg.d.G(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VAS_AVATAR_PAYLOAD, a.bg.f192650a);
            }
            if (!com.tencent.qqnt.aio.msg.d.H(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VAS_AVATAR_PENDENT_PAYLOAD, a.bf.f192649a);
            }
            if (!com.tencent.qqnt.aio.msg.f.b(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VAS_SPECIAL_SHAPE_PAYLOAD, a.bh.f192651a);
            }
            if (!com.tencent.qqnt.aio.msg.d.t(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VAS_NICK_BACKGROUND_PAYLOAD, a.bj.f192653a);
            }
            if (!com.tencent.qqnt.aio.msg.d.F(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VIP_ICON_PAYLOAD, a.bl.f192655a);
            }
            if (!com.tencent.qqnt.aio.msg.d.I(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.VIP_ICON_EX_PAYLOAD, a.bk.f192654a);
            }
            if (!com.tencent.qqnt.aio.msg.f.a(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.GIFT_PAYLOAD, a.r.f192671a);
            }
            if (this.loadAvatarPendantFlag != aIOMsgItem2.loadAvatarPendantFlag) {
                hashMap.put(AIOMsgItemPayloadType.LOAD_AVATAR_PENDANT_PAYLOAD, a.u.f192674a);
            }
            if (this.avatarChangeFlag != aIOMsgItem2.avatarChangeFlag) {
                hashMap.put(AIOMsgItemPayloadType.AVATAR_CHANGE_PAYLOAD, a.f.f192659a);
            }
            if (this.multiSelectFlag != aIOMsgItem2.multiSelectFlag) {
                hashMap.put(AIOMsgItemPayloadType.SELECT_PAYLOAD, a.ax.f192640a);
            }
            if (this.isSelectMode != aIOMsgItem2.isSelectMode) {
                hashMap.put(AIOMsgItemPayloadType.SELECT_PAYLOAD, a.ax.f192640a);
            }
            if (!Intrinsics.areEqual(this.showNickName, aIOMsgItem2.showNickName)) {
                hashMap.put(AIOMsgItemPayloadType.NICK_PAYLOAD, a.ag.f192622a);
            }
            if (!Intrinsics.areEqual(this.bgTextColor, aIOMsgItem2.bgTextColor)) {
                hashMap.put(AIOMsgItemPayloadType.BG_TEXT_COLOR_PAYLOAD, a.h.f192661a);
            }
            if (aIOMsgItem2.M0() != M0()) {
                hashMap.put(AIOMsgItemPayloadType.REPLY_MSG_REVOKED_PAYLOAD, a.ar.f192634a);
            }
            if (!com.tencent.mobileqq.aio.utils.ai.d(getFileTransNotifyInfo(), aIOMsgItem2.getFileTransNotifyInfo())) {
                hashMap.put(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD, new a.aw(aIOMsgItem2.getFileTransNotifyInfo()));
            }
            if (!com.tencent.qqnt.aio.msg.d.C(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.QCIRCLE_RED_DOT, a.ap.f192632a);
            }
            if (!com.tencent.qqnt.aio.msg.d.y(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.NICK_ICON_DATA, a.ah.f192623a);
            }
            if (this.isDui != aIOMsgItem2.isDui) {
                hashMap.put(AIOMsgItemPayloadType.DOU_TU_PAYLOAD, a.k.f192664a);
            }
            if (this.isFlowMessage != aIOMsgItem2.isFlowMessage) {
                hashMap.put(AIOMsgItemPayloadType.FOLLOW_MSG_PAYLOAD, a.q.f192670a);
            }
            if (this.isMosaic != aIOMsgItem2.isMosaic) {
                hashMap.put(AIOMsgItemPayloadType.SHOT_MOSAIC, a.aa.f192616a);
            }
            if (Z() != aIOMsgItem2.Z()) {
                hashMap.put(AIOMsgItemPayloadType.SHOULD_SHOW_REPLY_PAYLOAD, a.bb.f192645a);
            }
            if (this.lastReceiveMsgFlag != aIOMsgItem2.lastReceiveMsgFlag) {
                hashMap.put(AIOMsgItemPayloadType.LAST_RECEIVE_MSG_PAYLOAD, a.ab.f192617a);
            }
            if (!com.tencent.qqnt.aio.msg.d.E(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.RECOMMEND_MSG_PAYLOAD, a.at.f192636a);
            }
            if (!com.tencent.qqnt.aio.msg.d.v(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.MSG_FEEDBACK_BAR_PAYLOAD, a.ad.f192619a);
            }
            if (!com.tencent.qqnt.aio.msg.d.m(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.ADELIE_MSG_PUSH_STATE_PAYLOAD, a.C7332a.f192615a);
            }
            if (this.isShotMode != aIOMsgItem2.isShotMode) {
                hashMap.put(AIOMsgItemPayloadType.SHOT_MODE_PAYLOAD, a.ba.f192644a);
            }
            if (this.themeChangeFlag != aIOMsgItem2.themeChangeFlag) {
                hashMap.put(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD, a.bc.f192646a);
            }
            if (this.requestAccessibilityFocus != aIOMsgItem2.requestAccessibilityFocus) {
                hashMap.put(AIOMsgItemPayloadType.ACCESSIBILITY_FOCUS_PAYLOAD, new com.tencent.mobileqq.aio.msglist.payload.a());
            }
            if (!com.tencent.qqnt.aio.msg.d.q(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.SCREEN_SIZE_CHANGE, new com.tencent.mobileqq.aio.msglist.payload.a());
            }
            if (this.needShowReplySuggestionTail != aIOMsgItem2.needShowReplySuggestionTail) {
                hashMap.put(AIOMsgItemPayloadType.OPEN_AI_CHAT_PAYLOAD, a.au.f192637a);
            }
            if (!com.tencent.qqnt.aio.msg.d.n(this, aIOMsgItem2)) {
                hashMap.put(AIOMsgItemPayloadType.APP_ICON_BIND_PAYLOAD, a.d.f192657a);
            }
        }
        if (hashMap.isEmpty() && O0(target)) {
            return null;
        }
        return hashMap;
    }

    @NotNull
    public FileTransNotifyInfo getFileTransNotifyInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (FileTransNotifyInfo) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.fileTransNotifyInfo;
    }

    @Nullable
    public final MsgElement getFirstTypeElement(int type) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 169)) {
            return (MsgElement) iPatchRedirector.redirect((short) 169, (Object) this, type);
        }
        ArrayList<MsgElement> elements = this.msgRecord.elements;
        Object obj = null;
        if (elements.isEmpty()) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MsgElement) next).elementType == type) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (MsgElement) obj;
    }

    @Override // com.tencent.aio.data.msglist.a
    public long getMsgId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            return ((Long) iPatchRedirector.redirect((short) 158, (Object) this)).longValue();
        }
        return this.msgRecord.msgId;
    }

    @NotNull
    public final MsgRecord getMsgRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRecord;
    }

    @Override // com.tencent.aio.data.msglist.a
    public long getMsgSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 159)) {
            return ((Long) iPatchRedirector.redirect((short) 159, (Object) this)).longValue();
        }
        return this.msgRecord.msgSeq;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            return ((Integer) iPatchRedirector.redirect((short) 160, (Object) this)).intValue();
        }
        return !isSelf() ? 1 : 0;
    }

    @Nullable
    public final MsgRecordParams h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (MsgRecordParams) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.parentMsgRecordParams;
    }

    public final void h1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.isDui = z16;
        }
    }

    @NotNull
    public String h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            return (String) iPatchRedirector.redirect((short) 152, (Object) this);
        }
        return "";
    }

    @NotNull
    public final com.tencent.qqnt.aio.nick.k i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (com.tencent.qqnt.aio.nick.k) iPatchRedirector.redirect((short) 86, (Object) this);
        }
        return this.qCircleRedDotInfo;
    }

    public final void i1(@Nullable com.tencent.qqnt.aio.essence.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) aVar);
        } else {
            this.essenceInfo = aVar;
        }
    }

    @Override // com.tencent.aio.data.msglist.a
    public final boolean isSameContent(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            return ((Boolean) iPatchRedirector.redirect((short) 161, (Object) this, (Object) target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!O0(target)) {
            return false;
        }
        return o(target).getFirst().booleanValue();
    }

    @Override // com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 164)) {
            return ((Boolean) iPatchRedirector.redirect((short) 164, (Object) this, (Object) target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof AIOMsgItem)) {
            return false;
        }
        AIOMsgItem aIOMsgItem = (AIOMsgItem) target;
        String str = aIOMsgItem.msgRecord.peerUid;
        if (!Intrinsics.areEqual(str, str) || !Intrinsics.areEqual(this.msgRecord.senderUid, aIOMsgItem.msgRecord.senderUid)) {
            return false;
        }
        MsgRecord msgRecord = this.msgRecord;
        long j3 = msgRecord.msgId;
        MsgRecord msgRecord2 = aIOMsgItem.msgRecord;
        if (j3 != msgRecord2.msgId || msgRecord.msgType != msgRecord2.msgType) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 166)) {
            return ((Boolean) iPatchRedirector.redirect((short) 166, (Object) this)).booleanValue();
        }
        int i3 = this.forwardType;
        if (i3 != -1) {
            if (i3 == 0) {
                return false;
            }
            return true;
        }
        if (this.rootMsgRecordParams != null) {
            return false;
        }
        return com.tencent.mobileqq.aio.utils.al.g(this.msgRecord);
    }

    @NotNull
    public final Map<RefreshType, String> j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return (Map) iPatchRedirector.redirect((short) 102, (Object) this);
        }
        return this.refreshKeyMap;
    }

    public final void j1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            this.isFlowMessage = z16;
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 174)) {
            return ((Boolean) iPatchRedirector.redirect((short) 174, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final MsgRecordParams k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (MsgRecordParams) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.relyMsgRecordParams;
    }

    public final void k1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, (Object) this, i3);
        } else {
            this.forwardType = i3;
        }
    }

    @CallSuper
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            iPatchRedirector.redirect((short) 157, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        if (!newMsgItem.transformed) {
            newMsgItem.showNickName = this.showNickName;
        }
        newMsgItem.time = this.time;
        newMsgItem.X1(this.showTimeStampFlag);
        newMsgItem.hasRead = this.hasRead;
        newMsgItem.needShowAnim = this.needShowAnim;
        newMsgItem.showNewMsgTip = this.showNewMsgTip;
        newMsgItem.setFileTransNotifyInfo(getFileTransNotifyInfo());
        newMsgItem.rootMsgRecordParams = this.rootMsgRecordParams;
        newMsgItem.parentMsgRecordParams = this.parentMsgRecordParams;
        newMsgItem.isFlowMessage = this.isFlowMessage;
        newMsgItem.isDui = this.isDui;
        newMsgItem.isGagMode = this.isGagMode;
        newMsgItem.hasPlayedDui = this.hasPlayedDui;
        newMsgItem.skinBubbleInfo = this.skinBubbleInfo;
        newMsgItem.mutualMaskInfo = this.mutualMaskInfo;
        newMsgItem.mutualMaskDrawableList = this.mutualMaskDrawableList;
        newMsgItem.avatarEggInfo = this.avatarEggInfo;
        newMsgItem.getAvatarEgg = this.getAvatarEgg;
        newMsgItem.essenceInfo = this.essenceInfo;
        newMsgItem.gradeLevelInfo = this.gradeLevelInfo;
        newMsgItem.memberLevelInfo = this.memberLevelInfo;
        newMsgItem.memberLevelDrawableInfo = this.memberLevelDrawableInfo;
        newMsgItem.msgAttrsMap.putAll(this.msgAttrsMap);
        newMsgItem.resChangeMap.putAll(this.resChangeMap);
        newMsgItem.anonymousAvatarDrawable = this.anonymousAvatarDrawable;
        newMsgItem.nickNameDrawInfo = this.nickNameDrawInfo;
        newMsgItem.flashNameData = this.flashNameData;
        newMsgItem.contentDescription = this.contentDescription;
        newMsgItem.contentDescriptionNickName = this.contentDescriptionNickName;
        newMsgItem.msgAnimTime = this.msgAnimTime;
        newMsgItem.msgAnimFlag = this.msgAnimFlag;
        newMsgItem.vipIconDrawable = this.vipIconDrawable;
        newMsgItem.vipIconExtDrawable = this.vipIconExtDrawable;
        newMsgItem.vipGameIconDrawable = this.vipGameIconDrawable;
        newMsgItem.loadAvatarPendantFlag = this.loadAvatarPendantFlag;
        newMsgItem.avatarChangeFlag = this.avatarChangeFlag;
        newMsgItem.multiSelectFlag = this.multiSelectFlag;
        newMsgItem.isSelectMode = this.isSelectMode;
        newMsgItem.forwardType = this.forwardType;
        newMsgItem.optionVasAvatarData = this.optionVasAvatarData;
        newMsgItem.optionVasPendantData = this.optionVasPendantData;
        newMsgItem.forwardType = this.forwardType;
        newMsgItem.multiForwardMsgNickName = this.multiForwardMsgNickName;
        newMsgItem.bgTextColor = this.bgTextColor;
        newMsgItem.chatBgPath = this.chatBgPath;
        newMsgItem.memberInfo = this.memberInfo;
        newMsgItem.qCircleRedDotInfo = this.qCircleRedDotInfo;
        newMsgItem.nickIconData = this.nickIconData;
        newMsgItem.isShootBubbleInfo = this.isShootBubbleInfo;
        newMsgItem.isMosaic = this.isMosaic;
        newMsgItem.isShowMsgReplyMsg = this.isShowMsgReplyMsg;
        newMsgItem.hasMsgReplyClicked = this.hasMsgReplyClicked;
        newMsgItem.replyParam = this.replyParam;
        newMsgItem.lastReceiveMsgFlag = this.lastReceiveMsgFlag;
        newMsgItem.isShotMode = this.isShotMode;
        newMsgItem.requestAccessibilityFocus = this.requestAccessibilityFocus;
        newMsgItem.themeChangeFlag = this.themeChangeFlag;
        newMsgItem.supportTts = this.supportTts;
        newMsgItem.contentMargin = this.contentMargin;
        newMsgItem.needShowReplySuggestionTail = this.needShowReplySuggestionTail;
        newMsgItem.appIconBindData = this.appIconBindData;
        newMsgItem.isSendBySelf = this.isSendBySelf;
    }

    @Nullable
    public final v l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            return (v) iPatchRedirector.redirect((short) 128, (Object) this);
        }
        return this.replyParam;
    }

    public final void l1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.isGagMode = z16;
        }
    }

    @Override // com.tencent.aio.data.msglist.a
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final AIOMsgItem cloneNewInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 149, (Object) this);
        }
        return n(this.msgRecord);
    }

    public final long m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, (Object) this)).longValue();
        }
        return this.replyRealSourceMsgId;
    }

    public final void m1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, z16);
        } else {
            this.getAvatarEgg = z16;
        }
    }

    @NotNull
    public final AIOMsgItem n(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 150, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        AIOMsgItem b06 = b0(targetMsgRecord);
        l(b06);
        return b06;
    }

    public final boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            return ((Boolean) iPatchRedirector.redirect((short) 137, (Object) this)).booleanValue();
        }
        return this.requestAccessibilityFocus;
    }

    public final void n1(@Nullable com.tencent.qqnt.aio.nick.gradelevel.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) aVar);
        } else {
            this.gradeLevelInfo = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 163)) {
            return (Pair) iPatchRedirector.redirect((short) 163, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof AIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "not AIOMsgItem");
        }
        AIOMsgItem aIOMsgItem = (AIOMsgItem) target;
        if (this.msgRecord.elements.size() != aIOMsgItem.msgRecord.elements.size()) {
            return new Pair<>(Boolean.FALSE, "elements size");
        }
        int size = aIOMsgItem.msgRecord.elements.size();
        boolean z17 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MsgElement msgElement = aIOMsgItem.msgRecord.elements.get(i3);
            Intrinsics.checkNotNullExpressionValue(msgElement, "target.msgRecord.elements[index]");
            if (!com.tencent.mobileqq.aio.utils.ai.k(msgElement, this.msgRecord.elements.get(i3))) {
                return new Pair<>(Boolean.FALSE, "elements content");
            }
        }
        if (!com.tencent.mobileqq.aio.utils.ai.d(getFileTransNotifyInfo(), aIOMsgItem.getFileTransNotifyInfo())) {
            return new Pair<>(Boolean.FALSE, "fileTransNotifyInfo");
        }
        if (this.timeStampChanged) {
            return new Pair<>(Boolean.FALSE, "timeStampChanged");
        }
        MsgRecord msgRecord = this.msgRecord;
        boolean z18 = msgRecord.editable;
        MsgRecord msgRecord2 = aIOMsgItem.msgRecord;
        if (z18 != msgRecord2.editable) {
            return new Pair<>(Boolean.FALSE, "msgRecord.editable");
        }
        if (msgRecord.sendStatus != msgRecord2.sendStatus) {
            return new Pair<>(Boolean.FALSE, "sendStatus");
        }
        if (!com.tencent.qqnt.aio.msg.d.A(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "emojiLikesList");
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.a aVar = this.shootBubbleInfo;
        if (aVar != null && aVar.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new Pair<>(Boolean.FALSE, "shootBubbleInfo");
        }
        if (!com.tencent.qqnt.aio.msg.d.B(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameMutualMask");
        }
        if (!com.tencent.qqnt.aio.msg.d.o(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "avatarEggInfo");
        }
        com.tencent.qqnt.aio.essence.a aVar2 = this.essenceInfo;
        if (aVar2 != null) {
            z17 = aVar2.a();
        }
        if (z17) {
            return new Pair<>(Boolean.FALSE, "essenceInfo");
        }
        if (!com.tencent.qqnt.aio.msg.d.x(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameGradeLevel");
        }
        if (!com.tencent.qqnt.aio.msg.d.D(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameQQStrangerTail");
        }
        if (!com.tencent.qqnt.aio.msg.d.z(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameMemberInfo");
        }
        if (this.isPaiYiPaiNeedEffectAvatar == 1) {
            return new Pair<>(Boolean.FALSE, "isPaiYiPaiNeedEffectAvatar");
        }
        if (!com.tencent.qqnt.aio.msg.d.p(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameBubbleInfo");
        }
        if (!com.tencent.qqnt.aio.msg.d.q(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameBubblePadding");
        }
        if (!com.tencent.qqnt.aio.msg.d.w(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameFont");
        }
        if (!com.tencent.qqnt.aio.msg.d.G(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameVasAvatar");
        }
        if (!com.tencent.qqnt.aio.msg.d.H(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameVasAvatarPendent");
        }
        if (!com.tencent.qqnt.aio.msg.f.b(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameSpecialShapeMask");
        }
        if (!com.tencent.qqnt.aio.msg.d.t(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameColorNickInfo");
        }
        if (!com.tencent.qqnt.aio.msg.d.F(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameVIPIcon");
        }
        if (!com.tencent.qqnt.aio.msg.d.I(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameVipIconEx");
        }
        if (!com.tencent.qqnt.aio.msg.f.a(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameGiftRes");
        }
        if (this.loadAvatarPendantFlag != aIOMsgItem.loadAvatarPendantFlag) {
            return new Pair<>(Boolean.FALSE, "loadAvatarPendantFlag");
        }
        if (this.avatarChangeFlag != aIOMsgItem.avatarChangeFlag) {
            return new Pair<>(Boolean.FALSE, "avatarChangeFlag");
        }
        if (this.multiSelectFlag != aIOMsgItem.multiSelectFlag) {
            return new Pair<>(Boolean.FALSE, "multiSelectFlag");
        }
        if (this.isSelectMode != aIOMsgItem.isSelectMode) {
            return new Pair<>(Boolean.FALSE, "isSelectMode");
        }
        if (!Intrinsics.areEqual(this.showNickName, aIOMsgItem.showNickName)) {
            return new Pair<>(Boolean.FALSE, "showNickName");
        }
        if (!Intrinsics.areEqual(this.bgTextColor, aIOMsgItem.bgTextColor)) {
            return new Pair<>(Boolean.FALSE, "nickColor");
        }
        if (this.isFlowMessage != aIOMsgItem.isFlowMessage) {
            return new Pair<>(Boolean.FALSE, "isFlowMessage");
        }
        if (this.isDui != aIOMsgItem.isDui) {
            return new Pair<>(Boolean.FALSE, "isDui");
        }
        if (this.isMosaic != aIOMsgItem.isMosaic) {
            return new Pair<>(Boolean.FALSE, "isMosaic");
        }
        if (Z() != aIOMsgItem.Z()) {
            return new Pair<>(Boolean.FALSE, "needShowReply");
        }
        if (!com.tencent.qqnt.aio.msg.d.C(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameQCircleRedDot");
        }
        if (this.lastReceiveMsgFlag != aIOMsgItem.lastReceiveMsgFlag) {
            return new Pair<>(Boolean.FALSE, "msgActionFlag");
        }
        if (!com.tencent.qqnt.aio.msg.d.E(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "recommendMsg");
        }
        if (!com.tencent.qqnt.aio.msg.d.v(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "msgFeedbackFlag");
        }
        if (!com.tencent.qqnt.aio.msg.d.m(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "adelieMsgPushState");
        }
        if (!com.tencent.qqnt.aio.msg.d.y(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameIconData");
        }
        if (this.isShotMode != aIOMsgItem.isShotMode) {
            return new Pair<>(Boolean.FALSE, "isShotMode");
        }
        if (this.themeChangeFlag != aIOMsgItem.themeChangeFlag) {
            return new Pair<>(Boolean.FALSE, MiniGamePAHippyBaseFragment.KEY_THEME_CHANGE);
        }
        if (this.requestAccessibilityFocus != aIOMsgItem.requestAccessibilityFocus) {
            return new Pair<>(Boolean.FALSE, "accessibilityFocusChange");
        }
        if (this.needShowReplySuggestionTail != aIOMsgItem.needShowReplySuggestionTail) {
            return new Pair<>(Boolean.FALSE, "needShowReplySuggestionTail");
        }
        if (!com.tencent.qqnt.aio.msg.d.n(this, aIOMsgItem)) {
            return new Pair<>(Boolean.FALSE, "isSameAppIconBindData");
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    @NotNull
    public final HashMap<Integer, Integer> o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (HashMap) iPatchRedirector.redirect((short) 101, (Object) this);
        }
        return this.resChangeMap;
    }

    public final void o1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, (Object) this, z16);
        } else {
            this.hasMsgReplyClicked = z16;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c) iPatchRedirector.redirect((short) 145, (Object) this);
        }
        return this.appIconBindData;
    }

    public final int p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        MsgRecordParams g06 = g0();
        if (g06 != null) {
            return g06.a();
        }
        return this.msgRecord.chatType;
    }

    public final void p1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.hasPlayedDui = z16;
        }
    }

    @Nullable
    public final com.tencent.qqnt.aio.avatar.egg.a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (com.tencent.qqnt.aio.avatar.egg.a) iPatchRedirector.redirect((short) 74, (Object) this);
        }
        return this.avatarEggInfo;
    }

    public final long q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        MsgRecordParams g06 = g0();
        if (g06 != null) {
            return g06.b();
        }
        return getMsgId();
    }

    public final void q1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.hasRead = z16;
        }
    }

    @Nullable
    public final ColorStateList r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.bgTextColor;
    }

    @NotNull
    public final String r0() {
        String e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        MsgRecordParams g06 = g0();
        if (g06 == null || (e16 = g06.e()) == null) {
            String str = this.msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
            return str;
        }
        return e16;
    }

    public final void r1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, z16);
        } else {
            this.lastReceiveMsgFlag = z16;
        }
    }

    @NotNull
    public final String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            return (String) iPatchRedirector.redirect((short) 132, (Object) this);
        }
        if (this.isShootBubbleInfo == null) {
            this.isShootBubbleInfo = new com.tencent.mobileqq.aio.bubble.a(this);
        }
        com.tencent.mobileqq.aio.bubble.a aVar = this.isShootBubbleInfo;
        Intrinsics.checkNotNull(aVar);
        return aVar.b();
    }

    @Nullable
    public final MsgRecordParams s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (MsgRecordParams) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.rootMsgRecordParams;
    }

    public final void s1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this, z16);
        } else {
            this.loadAvatarPendantFlag = z16;
        }
    }

    public void setFileTransNotifyInfo(@NotNull FileTransNotifyInfo fileTransNotifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) fileTransNotifyInfo);
        } else {
            Intrinsics.checkNotNullParameter(fileTransNotifyInfo, "<set-?>");
            this.fileTransNotifyInfo = fileTransNotifyInfo;
        }
    }

    @Nullable
    public final Pair<Integer, Integer> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return (Pair) iPatchRedirector.redirect((short) 119, (Object) this);
        }
        return this.bubbleScreenInfo;
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.skin.a t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.a) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return this.shootBubbleInfo;
    }

    public final void t1(@Nullable MemberInfo memberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) memberInfo);
        } else {
            this.memberInfo = memberInfo;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 183)) {
            return (String) iPatchRedirector.redirect((short) 183, (Object) this);
        }
        long msgId = getMsgId();
        MsgRecord msgRecord = this.msgRecord;
        return "{msgId:" + msgId + ",type:" + msgRecord.msgType + ",peerId:" + msgRecord.peerUid + "}";
    }

    @NotNull
    public final String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return (String) iPatchRedirector.redirect((short) 113, (Object) this);
        }
        return this.chatBgPath;
    }

    public final boolean u0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return this.showNewMsgTip;
    }

    public final void u1(@Nullable com.tencent.qqnt.aio.nick.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) eVar);
        } else {
            this.memberLevelDrawableInfo = eVar;
        }
    }

    @NotNull
    public final Contact v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            return (Contact) iPatchRedirector.redirect((short) 168, (Object) this);
        }
        return (Contact) this.contact.getValue();
    }

    @NotNull
    public final CharSequence v0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.showNickName;
    }

    public final void v1(@Nullable com.tencent.qqnt.aio.nick.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) fVar);
        } else {
            this.memberLevelInfo = fVar;
        }
    }

    @NotNull
    public final String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (String) iPatchRedirector.redirect((short) 103, (Object) this);
        }
        return this.contentDescription;
    }

    public final boolean w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.showTimeStampFlag;
    }

    public final void w1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this, z16);
        } else {
            this.isMosaic = z16;
        }
    }

    @NotNull
    public final CharSequence x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.contentDescriptionNickName;
    }

    @Nullable
    public final AIOBubbleSkinInfo x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (AIOBubbleSkinInfo) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.skinBubbleInfo;
    }

    public final void x1(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, z16);
        } else {
            this.msgAnimFlag = z16;
        }
    }

    public final boolean y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            return ((Boolean) iPatchRedirector.redirect((short) 139, (Object) this)).booleanValue();
        }
        return this.supportTts;
    }

    public final void y1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, j3);
        } else {
            this.msgAnimTime = j3;
        }
    }

    @Nullable
    public final Rect z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            return (Rect) iPatchRedirector.redirect((short) 141, (Object) this);
        }
        return this.contentMargin;
    }

    public final int z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            return ((Integer) iPatchRedirector.redirect((short) 135, (Object) this)).intValue();
        }
        return this.themeChangeFlag;
    }

    public final void z1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, (Object) this, i3);
        } else {
            this.msgViewHeight = i3;
        }
    }
}
