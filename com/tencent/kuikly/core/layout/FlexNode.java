package com.tencent.kuikly.core.layout;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.layout.FlexLayout;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0014\n\u0002\b\n\b\u0016\u0018\u0000 \u00e1\u00012\u00020\u0001:\u0001 B\t\u00a2\u0006\u0006\b\u00f4\u0001\u0010\u00f5\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0000J\u0010\u0010#\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0000JH\u0010/\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010,\u001a\u00020+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000-H\u0016J\u0010\u00100\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'J\u0006\u00101\u001a\u00020\u0002J\"\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u00020+2\b\b\u0002\u00105\u001a\u00020+J\u0006\u00107\u001a\u00020\u0002J\u0006\u00108\u001a\u00020\u0002J\u0006\u00109\u001a\u00020\u0002J\u0006\u0010:\u001a\u00020\u0002J\u0006\u0010;\u001a\u00020\u0002R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010=R\u001b\u0010B\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010R\u001a\u00020+8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010K\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010X\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010SR0\u0010b\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0002\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR*\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010m\u001a\u00020+2\u0006\u0010k\u001a\u00020+8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b@\u0010K\u001a\u0004\bl\u0010OR\u001a\u0010p\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bn\u0010K\u001a\u0004\bo\u0010OR\"\u0010w\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010~\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u007f\u0010y\u001a\u0005\b\u0080\u0001\u0010{\"\u0005\b\u0081\u0001\u0010}R(\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0083\u0001\u0010y\u001a\u0005\b\u0084\u0001\u0010{\"\u0005\b\u0085\u0001\u0010}R(\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0087\u0001\u0010y\u001a\u0005\b\u0088\u0001\u0010{\"\u0005\b\u0089\u0001\u0010}R'\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bT\u0010y\u001a\u0005\b\u008b\u0001\u0010{\"\u0005\b\u008c\u0001\u0010}R4\u0010\u0093\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0017\n\u0005\b^\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R5\u0010\u0097\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u008e\u0001\u001a\u0006\b\u0095\u0001\u0010\u0090\u0001\"\u0006\b\u0096\u0001\u0010\u0092\u0001R7\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0098\u00012\t\u0010\t\u001a\u0005\u0018\u00010\u0098\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010\u00a3\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\b\u007f\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R(\u0010\u00a5\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bx\u0010\u00a0\u0001\"\u0006\b\u00a4\u0001\u0010\u00a2\u0001R)\u0010\u00a7\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0083\u0001\u0010\u00a0\u0001\"\u0006\b\u00a6\u0001\u0010\u00a2\u0001R)\u0010\u00ac\u0001\u001a\u00020)2\u0006\u0010\t\u001a\u00020)8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001\"\u0006\b\u00aa\u0001\u0010\u00ab\u0001R)\u0010\u00af\u0001\u001a\u00020)2\u0006\u0010\t\u001a\u00020)8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010\u00a9\u0001\"\u0006\b\u00ae\u0001\u0010\u00ab\u0001R*\u0010\u00b4\u0001\u001a\u00030\u00b0\u00012\u0007\u0010\t\u001a\u00030\u00b0\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bd\u0010\u00b1\u0001\"\u0006\b\u00b2\u0001\u0010\u00b3\u0001R*\u0010\u00b9\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\t\u001a\u00030\u00b5\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bq\u0010\u00b6\u0001\"\u0006\b\u00b7\u0001\u0010\u00b8\u0001R*\u0010\u00be\u0001\u001a\u00030\u00ba\u00012\u0007\u0010\t\u001a\u00030\u00ba\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bJ\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R*\u0010\u00c0\u0001\u001a\u00030\u00ba\u00012\u0007\u0010\t\u001a\u00030\u00ba\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bM\u0010\u00bb\u0001\"\u0006\b\u00bf\u0001\u0010\u00bd\u0001R*\u0010\u000e\u001a\u00030\u00c1\u00012\u0007\u0010\t\u001a\u00030\u00c1\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00c2\u0001\u0010\u00c3\u0001\"\u0006\b\u00c4\u0001\u0010\u00c5\u0001R*\u0010\u00ca\u0001\u001a\u00030\u00c6\u00012\u0007\u0010\t\u001a\u00030\u00c6\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bn\u0010\u00c7\u0001\"\u0006\b\u00c8\u0001\u0010\u00c9\u0001R(\u0010\u00cc\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\b\\\u0010\u00a0\u0001\"\u0006\b\u00cb\u0001\u0010\u00a2\u0001R*\u0010\u00ce\u0001\u001a\u00030\u00ba\u00012\u0007\u0010\t\u001a\u00030\u00ba\u00018F@FX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\bG\u0010\u00bb\u0001\"\u0006\b\u00cd\u0001\u0010\u00bd\u0001R)\u0010\u00d1\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00cf\u0001\u0010\u00a0\u0001\"\u0006\b\u00d0\u0001\u0010\u00a2\u0001R)\u0010\u00d4\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00d2\u0001\u0010\u00a0\u0001\"\u0006\b\u00d3\u0001\u0010\u00a2\u0001R)\u0010\u00d7\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00d5\u0001\u0010\u00a0\u0001\"\u0006\b\u00d6\u0001\u0010\u00a2\u0001R)\u0010\u00da\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00d8\u0001\u0010\u00a0\u0001\"\u0006\b\u00d9\u0001\u0010\u00a2\u0001R)\u0010\u00dd\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00db\u0001\u0010\u00a0\u0001\"\u0006\b\u00dc\u0001\u0010\u00a2\u0001R)\u0010\u00e0\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00de\u0001\u0010\u00a0\u0001\"\u0006\b\u00df\u0001\u0010\u00a2\u0001R)\u0010\u00e3\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e1\u0001\u0010\u00a0\u0001\"\u0006\b\u00e2\u0001\u0010\u00a2\u0001R)\u0010\u00e5\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0094\u0001\u0010\u00a0\u0001\"\u0006\b\u00e4\u0001\u0010\u00a2\u0001R)\u0010\u00e8\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e6\u0001\u0010\u00a0\u0001\"\u0006\b\u00e7\u0001\u0010\u00a2\u0001R)\u0010\u00eb\u0001\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e9\u0001\u0010\u00a0\u0001\"\u0006\b\u00ea\u0001\u0010\u00a2\u0001R\u0015\u0010\u00ee\u0001\u001a\u00030\u00ec\u00018F\u00a2\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u00ed\u0001R\u0014\u0010\u00ef\u0001\u001a\u00030\u00ec\u00018F\u00a2\u0006\u0007\u001a\u0005\br\u0010\u00ed\u0001R\u0015\u0010\u00f1\u0001\u001a\u00030\u00ec\u00018F\u00a2\u0006\b\u001a\u0006\b\u00f0\u0001\u0010\u00ed\u0001R\u0015\u0010\u00f2\u0001\u001a\u00030\u00ec\u00018F\u00a2\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u00ed\u0001R\u0012\u0010\u00f3\u0001\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\bY\u0010t\u00a8\u0006\u00f6\u0001"}, d2 = {"Lcom/tencent/kuikly/core/layout/FlexNode;", "", "", "V0", "Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "spacingType", "Lcom/tencent/kuikly/core/layout/StyleSpace;", "styleSpace", "", "value", "T0", "Lcom/tencent/kuikly/core/layout/c;", "c", "Lcom/tencent/kuikly/core/layout/FlexLayout$PositionType;", "positionType", "S0", "A0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G0", "E", "padding", ExifInterface.LATITUDE_SOUTH, "H", "L", "Lcom/tencent/kuikly/core/layout/g;", "measureOutput", "width", "e0", "", "index", "g", "child", "a", "g0", "f0", "h0", "V", "node", "parentMaxWidth", "Lcom/tencent/kuikly/core/layout/b;", "layoutContext", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "parentDirection", "", "needLayoutAbsoluteChild", "", "dirtyList", "Y", "b", "i0", "Lcom/tencent/kuikly/core/layout/d;", "newFrame", "isAbsolute", "fromDirty", "W0", "Y0", "a0", "d0", "b0", "c0", "", "Ljava/util/List;", Node.CHILDREN_ATTR, "Lkotlin/Lazy;", "k", "()Lcom/tencent/kuikly/core/layout/c;", "flexStyle", "Lcom/tencent/kuikly/core/layout/FlexLayout;", "Lcom/tencent/kuikly/core/layout/FlexLayout;", "flexLayout", "Lcom/tencent/kuikly/core/layout/a;", "d", "Lcom/tencent/kuikly/core/layout/a;", "lastLayout", "e", "Z", "disableLayout", "f", "isScrollNode$core_release", "()Z", "J0", "(Z)V", "isScrollNode", "Lcom/tencent/kuikly/core/layout/d;", "r", "()Lcom/tencent/kuikly/core/layout/d;", "setLayoutFrame", "(Lcom/tencent/kuikly/core/layout/d;)V", "layoutFrame", tl.h.F, "layoutOriginFrame", "Lkotlin/Function1;", "i", "Lkotlin/jvm/functions/Function1;", ReportConstant.COSTREPORT_PREFIX, "()Lkotlin/jvm/functions/Function1;", "u0", "(Lkotlin/jvm/functions/Function1;)V", "layoutFrameDidChangedCallback", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "getSetNeedDirtyCallback", "()Lkotlin/jvm/functions/Function0;", "K0", "(Lkotlin/jvm/functions/Function0;)V", "setNeedDirtyCallback", "<set-?>", "W", "isDirty", "l", "X", ViewStickEventHelper.IS_SHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "y", "()I", "z0", "(I)V", "lineIndex", DomainData.DOMAIN_NAME, "Lcom/tencent/kuikly/core/layout/FlexNode;", "B", "()Lcom/tencent/kuikly/core/layout/FlexNode;", "C0", "(Lcom/tencent/kuikly/core/layout/FlexNode;)V", "nextAbsoluteChild", "o", BdhLogUtil.LogTag.Tag_Conn, "D0", "nextFlexChild", "p", "D", "E0", "nextMatchParentSizeChild", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getNextMinHeightChild", "F0", "nextMinHeightChild", UserInfo.SEX_FEMALE, "H0", HippyNestedScrollComponent.PRIORITY_PARENT, "Ljava/lang/Float;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Ljava/lang/Float;", "Q0", "(Ljava/lang/Float;)V", "styleOffsetX", "t", BdhLogUtil.LogTag.Tag_Req, "R0", "styleOffsetY", "Lcom/tencent/kuikly/core/layout/f;", "u", "Lcom/tencent/kuikly/core/layout/f;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/kuikly/core/layout/f;", "B0", "(Lcom/tencent/kuikly/core/layout/f;)V", "measureFunction", "()F", "s0", "(F)V", "lastLayoutWidth", "r0", "lastLayoutHeight", "t0", "lastParentMaxWith", "getFlexLayoutDirection", "()Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "o0", "(Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;)V", "flexLayoutDirection", "J", "setStyleDirection", "styleDirection", "Lcom/tencent/kuikly/core/layout/FlexDirection;", "()Lcom/tencent/kuikly/core/layout/FlexDirection;", "n0", "(Lcom/tencent/kuikly/core/layout/FlexDirection;)V", NodeProps.FLEX_DIRECTION, "Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", "()Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", "q0", "(Lcom/tencent/kuikly/core/layout/FlexJustifyContent;)V", NodeProps.JUSTIFY_CONTENT, "Lcom/tencent/kuikly/core/layout/FlexAlign;", "()Lcom/tencent/kuikly/core/layout/FlexAlign;", "k0", "(Lcom/tencent/kuikly/core/layout/FlexAlign;)V", NodeProps.ALIGN_ITEMS, "l0", NodeProps.ALIGN_SELF, "Lcom/tencent/kuikly/core/layout/FlexPositionType;", "G", "()Lcom/tencent/kuikly/core/layout/FlexPositionType;", "I0", "(Lcom/tencent/kuikly/core/layout/FlexPositionType;)V", "Lcom/tencent/kuikly/core/layout/FlexWrap;", "()Lcom/tencent/kuikly/core/layout/FlexWrap;", "p0", "(Lcom/tencent/kuikly/core/layout/FlexWrap;)V", NodeProps.FLEX_WRAP, "m0", NodeProps.FLEX, "j0", "alignContent", "P", "P0", "styleMinWidth", "N", "N0", "styleMaxWidth", "O", "O0", "styleMinHeight", "M", "M0", "styleMaxHeight", "U", "U0", "styleWidth", "K", "L0", "styleHeight", "v", "w0", "layoutWidth", "v0", "layoutHeight", "w", "x0", "layoutX", HippyTKDListViewAdapter.X, "y0", "layoutY", "", "()[F", "layoutDimensions", "styleDimensions", "T", "stylePosition", "layoutPosition", "childCount", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class FlexNode {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<FlexNode> children;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy flexStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final FlexLayout flexLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a lastLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean disableLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollNode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private d layoutFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d layoutOriginFrame;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Boolean, Unit> layoutFrameDidChangedCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> setNeedDirtyCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isDirty;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean isShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lineIndex;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private FlexNode nextAbsoluteChild;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private FlexNode nextFlexChild;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private FlexNode nextMatchParentSizeChild;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private FlexNode nextMinHeightChild;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private FlexNode parent;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Float styleOffsetX;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Float styleOffsetY;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private f measureFunction;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f117297a;

        static {
            int[] iArr = new int[StyleSpace.Type.values().length];
            try {
                iArr[StyleSpace.Type.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StyleSpace.Type.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StyleSpace.Type.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f117297a = iArr;
        }
    }

    public FlexNode() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<c>() { // from class: com.tencent.kuikly.core.layout.FlexNode$flexStyle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return FlexNode.this.c();
            }
        });
        this.flexStyle = lazy;
        this.flexLayout = new FlexLayout();
        this.lastLayout = new a();
        this.layoutFrame = d.INSTANCE.a();
        this.isDirty = true;
        this.isShow = true;
    }

    private final void T0(StyleSpace.Type spacingType, StyleSpace styleSpace, float value) {
        int i3 = b.f117297a[spacingType.ordinal()];
        if (i3 == 1) {
            styleSpace.c(StyleSpace.Type.LEFT, value);
            styleSpace.c(StyleSpace.Type.TOP, value);
            styleSpace.c(StyleSpace.Type.RIGHT, value);
            styleSpace.c(StyleSpace.Type.BOTTOM, value);
            return;
        }
        if (i3 == 2) {
            styleSpace.c(StyleSpace.Type.LEFT, value);
            styleSpace.c(StyleSpace.Type.RIGHT, value);
        } else if (i3 != 3) {
            styleSpace.c(spacingType, value);
        } else {
            styleSpace.c(StyleSpace.Type.TOP, value);
            styleSpace.c(StyleSpace.Type.BOTTOM, value);
        }
    }

    private final void V0() {
        if (this.disableLayout) {
            return;
        }
        this.lastLayout.a(this.flexLayout);
        X0(this, new d(w(), x(), v(), t()), false, false, 6, null);
    }

    /* renamed from: A, reason: from getter */
    public final f getMeasureFunction() {
        return this.measureFunction;
    }

    public final void A0(StyleSpace.Type spacingType, float value) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        float z16 = z(spacingType);
        boolean z17 = true;
        if (Float.isNaN(z16) || Float.isNaN(value) ? !Float.isNaN(z16) || !Float.isNaN(value) : Math.abs(value - z16) >= 1.0E-5f) {
            z17 = false;
        }
        if (z17) {
            return;
        }
        T0(spacingType, k().getMargin(), value);
        a0();
    }

    /* renamed from: B, reason: from getter */
    public final FlexNode getNextAbsoluteChild() {
        return this.nextAbsoluteChild;
    }

    public final void B0(f fVar) {
        if (Intrinsics.areEqual(this.measureFunction, fVar)) {
            return;
        }
        this.measureFunction = fVar;
    }

    /* renamed from: C, reason: from getter */
    public final FlexNode getNextFlexChild() {
        return this.nextFlexChild;
    }

    public final void C0(FlexNode flexNode) {
        this.nextAbsoluteChild = flexNode;
    }

    /* renamed from: D, reason: from getter */
    public final FlexNode getNextMatchParentSizeChild() {
        return this.nextMatchParentSizeChild;
    }

    public final void D0(FlexNode flexNode) {
        this.nextFlexChild = flexNode;
    }

    public final float E(StyleSpace.Type spacingType) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        return k().getPadding().a(spacingType);
    }

    public final void E0(FlexNode flexNode) {
        this.nextMatchParentSizeChild = flexNode;
    }

    /* renamed from: F, reason: from getter */
    public final FlexNode getParent() {
        return this.parent;
    }

    public final void F0(FlexNode flexNode) {
        this.nextMinHeightChild = flexNode;
    }

    public final FlexPositionType G() {
        return k().getPositionType();
    }

    public final void G0(StyleSpace.Type spacingType, float value) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        float E = E(spacingType);
        boolean z16 = true;
        if (Float.isNaN(E) || Float.isNaN(value) ? !Float.isNaN(E) || !Float.isNaN(value) : Math.abs(value - E) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        T0(spacingType, k().getPadding(), value);
        a0();
    }

    public final float H(StyleSpace.Type spacingType, StyleSpace.Type padding) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return k().getBorder().b(spacingType, padding);
    }

    public final void H0(FlexNode flexNode) {
        this.parent = flexNode;
    }

    public final float[] I() {
        return k().getDimensions();
    }

    public final void I0(FlexPositionType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getPositionType() != value) {
            k().D(value);
            a0();
        }
    }

    public final FlexLayoutDirection J() {
        return k().getDirection();
    }

    public final void J0(boolean z16) {
        this.isScrollNode = z16;
    }

    public final float K() {
        return k().getDimensions()[FlexLayout.DimensionType.DIMENSION_HEIGHT.ordinal()];
    }

    public final void K0(Function0<Unit> function0) {
        this.setNeedDirtyCallback = function0;
    }

    public final float L(StyleSpace.Type spacingType, StyleSpace.Type padding) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return k().getMargin().b(spacingType, padding);
    }

    public final void L0(float f16) {
        float[] dimensions = k().getDimensions();
        FlexLayout.DimensionType dimensionType = FlexLayout.DimensionType.DIMENSION_HEIGHT;
        float f17 = dimensions[dimensionType.ordinal()];
        boolean z16 = true;
        if (Float.isNaN(f17) || Float.isNaN(f16) ? !Float.isNaN(f17) || !Float.isNaN(f16) : Math.abs(f16 - f17) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().getDimensions()[dimensionType.ordinal()] = f16;
        a0();
    }

    public final float M() {
        return k().getMaxHeight();
    }

    public final void M0(float f16) {
        float maxHeight = k().getMaxHeight();
        boolean z16 = true;
        if (Float.isNaN(maxHeight) || Float.isNaN(f16) ? !Float.isNaN(maxHeight) || !Float.isNaN(f16) : Math.abs(f16 - maxHeight) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().z(f16);
        a0();
    }

    public final float N() {
        return k().getMaxWidth();
    }

    public final void N0(float f16) {
        float maxWidth = k().getMaxWidth();
        boolean z16 = true;
        if (Float.isNaN(maxWidth) || Float.isNaN(f16) ? !Float.isNaN(maxWidth) || !Float.isNaN(f16) : Math.abs(f16 - maxWidth) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().A(f16);
        a0();
    }

    public final float O() {
        return k().getMinHeight();
    }

    public final void O0(float f16) {
        float minHeight = k().getMinHeight();
        boolean z16 = true;
        if (Float.isNaN(minHeight) || Float.isNaN(f16) ? !Float.isNaN(minHeight) || !Float.isNaN(f16) : Math.abs(f16 - minHeight) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().B(f16);
        a0();
    }

    public final float P() {
        return k().getMinWidth();
    }

    public final void P0(float f16) {
        float minWidth = k().getMinWidth();
        boolean z16 = true;
        if (Float.isNaN(minWidth) || Float.isNaN(f16) ? !Float.isNaN(minWidth) || !Float.isNaN(f16) : Math.abs(f16 - minWidth) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().C(f16);
        a0();
    }

    /* renamed from: Q, reason: from getter */
    public final Float getStyleOffsetX() {
        return this.styleOffsetX;
    }

    public final void Q0(Float f16) {
        if (Intrinsics.areEqual(this.styleOffsetX, f16)) {
            return;
        }
        this.styleOffsetX = f16;
        d dVar = this.layoutOriginFrame;
        if (dVar == null) {
            a0();
        } else {
            Intrinsics.checkNotNull(dVar);
            X0(this, dVar, false, false, 2, null);
        }
    }

    /* renamed from: R, reason: from getter */
    public final Float getStyleOffsetY() {
        return this.styleOffsetY;
    }

    public final void R0(Float f16) {
        if (Intrinsics.areEqual(this.styleOffsetY, f16)) {
            return;
        }
        this.styleOffsetY = f16;
        d dVar = this.layoutOriginFrame;
        if (dVar == null) {
            a0();
        } else {
            Intrinsics.checkNotNull(dVar);
            X0(this, dVar, false, false, 2, null);
        }
    }

    public final float S(StyleSpace.Type spacingType, StyleSpace.Type padding) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return k().getPadding().b(spacingType, padding);
    }

    public final void S0(FlexLayout.PositionType positionType, float value) {
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        float f16 = k().getPosition()[positionType.ordinal()];
        boolean z16 = true;
        if (Float.isNaN(f16) || Float.isNaN(value) ? !Float.isNaN(f16) || !Float.isNaN(value) : Math.abs(value - f16) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().getPosition()[positionType.ordinal()] = value;
        a0();
    }

    public final float[] T() {
        return k().getPosition();
    }

    public final float U() {
        return k().getDimensions()[FlexLayout.DimensionType.DIMENSION_WIDTH.ordinal()];
    }

    public final void U0(float f16) {
        float[] dimensions = k().getDimensions();
        FlexLayout.DimensionType dimensionType = FlexLayout.DimensionType.DIMENSION_WIDTH;
        float f17 = dimensions[dimensionType.ordinal()];
        boolean z16 = true;
        if (Float.isNaN(f17) || Float.isNaN(f16) ? !Float.isNaN(f17) || !Float.isNaN(f16) : Math.abs(f16 - f17) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().getDimensions()[dimensionType.ordinal()] = f16;
        a0();
    }

    public final int V(FlexNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List<FlexNode> list = this.children;
        if (list != null) {
            return list.indexOf(child);
        }
        return -1;
    }

    /* renamed from: W, reason: from getter */
    public final boolean getIsDirty() {
        return this.isDirty;
    }

    public final void W0(d newFrame, boolean isAbsolute, boolean fromDirty) {
        Intrinsics.checkNotNullParameter(newFrame, "newFrame");
        this.layoutOriginFrame = newFrame;
        d dVar = this.isScrollNode ? new d(newFrame.getX(), newFrame.getY(), com.tencent.kuikly.core.utils.b.a(newFrame.getWidth()), com.tencent.kuikly.core.utils.b.a(newFrame.getHeight())) : newFrame;
        if (!isAbsolute && (this.styleOffsetX != null || this.styleOffsetY != null)) {
            float x16 = newFrame.getX();
            Float f16 = this.styleOffsetX;
            float floatValue = x16 + (f16 != null ? f16.floatValue() : 0.0f);
            float y16 = newFrame.getY();
            Float f17 = this.styleOffsetY;
            dVar = new d(floatValue, y16 + (f17 != null ? f17.floatValue() : 0.0f), newFrame.getWidth(), newFrame.getHeight());
        }
        if (this.layoutFrame.f() || !this.layoutFrame.equals(dVar)) {
            this.layoutFrame = dVar;
            Function1<? super Boolean, Unit> function1 = this.layoutFrameDidChangedCallback;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(fromDirty));
            }
        }
    }

    /* renamed from: X, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public void Y(FlexNode node, float parentMaxWidth, com.tencent.kuikly.core.layout.b layoutContext, FlexLayoutDirection parentDirection, boolean needLayoutAbsoluteChild, Set<FlexNode> dirtyList) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(dirtyList, "dirtyList");
        e.G(e.f117328a, node, parentMaxWidth, layoutContext, null, false, dirtyList, 24, null);
    }

    public final void Y0() {
        this.flexLayout.a(this.lastLayout);
    }

    public final void a(FlexNode child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.parent == null) {
            if (this.children == null) {
                this.children = new ArrayList();
            }
            List<FlexNode> list = this.children;
            Intrinsics.checkNotNull(list);
            if (index >= list.size()) {
                List<FlexNode> list2 = this.children;
                if (list2 != null) {
                    list2.add(child);
                }
            } else {
                List<FlexNode> list3 = this.children;
                if (list3 != null) {
                    list3.add(index, child);
                }
            }
            child.parent = this;
            a0();
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public final void a0() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        FlexNode flexNode = this.parent;
        if (flexNode != null && !flexNode.isDirty) {
            flexNode.a0();
        }
        Function0<Unit> function0 = this.setNeedDirtyCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void b(com.tencent.kuikly.core.layout.b layoutContext) {
        float U;
        this.flexLayout.d();
        LinkedHashSet<FlexNode> linkedHashSet = new LinkedHashSet();
        if (!Float.isNaN(N())) {
            U = N();
        } else {
            U = U();
        }
        Z(this, this, U, layoutContext, null, false, linkedHashSet, 24, null);
        for (FlexNode flexNode : linkedHashSet) {
            flexNode.V0();
            flexNode.d0();
        }
    }

    public final void b0() {
        a0();
        this.disableLayout = true;
    }

    public c c() {
        return new c();
    }

    public final FlexAlign d() {
        return k().getAlignContent();
    }

    public final FlexAlign e() {
        return k().getCom.tencent.mtt.hippy.dom.node.NodeProps.ALIGN_ITEMS java.lang.String();
    }

    public final g e0(g measureOutput, float width) {
        Intrinsics.checkNotNullParameter(measureOutput, "measureOutput");
        if (this.measureFunction != null) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            float f16 = Float.NaN;
            measureOutput.c(Float.NaN);
            measureOutput.d(Float.NaN);
            if (!Float.isNaN(t())) {
                f16 = t();
            } else if (!Float.isNaN(K())) {
                f16 = K();
            }
            f fVar = this.measureFunction;
            if (fVar != null) {
                fVar.measure(this, width, f16, measureOutput);
            }
            return measureOutput;
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public final FlexAlign f() {
        return k().getCom.tencent.mtt.hippy.dom.node.NodeProps.ALIGN_SELF java.lang.String();
    }

    public final void f0(FlexNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.children == null) {
            this.children = new ArrayList();
        }
        List<FlexNode> list = this.children;
        if (list != null) {
            list.add(child);
        }
    }

    public final FlexNode g(int index) {
        Object orNull;
        List<FlexNode> list = this.children;
        if (list == null) {
            return null;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, index);
        return (FlexNode) orNull;
    }

    public final void g0() {
        List<FlexNode> list = this.children;
        if (list != null) {
            list.clear();
        }
    }

    public final int h() {
        List<FlexNode> list = this.children;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final FlexNode h0(int index) {
        FlexNode remove;
        List<FlexNode> list = this.children;
        if (list == null || (remove = list.remove(index)) == null) {
            return null;
        }
        remove.parent = null;
        return remove;
    }

    public final float i() {
        return k().getFlex();
    }

    public final void i0() {
        this.flexLayout.d();
    }

    public final FlexDirection j() {
        return k().getCom.tencent.mtt.hippy.dom.node.NodeProps.FLEX_DIRECTION java.lang.String();
    }

    public final void j0(FlexAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getAlignContent() != value) {
            k().s(value);
            a0();
        }
    }

    public final c k() {
        return (c) this.flexStyle.getValue();
    }

    public final void k0(FlexAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getCom.tencent.mtt.hippy.dom.node.NodeProps.ALIGN_ITEMS java.lang.String() != value) {
            k().t(value);
            a0();
        }
    }

    public final FlexWrap l() {
        return k().getFlexWrap();
    }

    public final void l0(FlexAlign value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getCom.tencent.mtt.hippy.dom.node.NodeProps.ALIGN_SELF java.lang.String() != value) {
            k().u(value);
            a0();
        }
    }

    public final FlexJustifyContent m() {
        return k().getCom.tencent.mtt.hippy.dom.node.NodeProps.JUSTIFY_CONTENT java.lang.String();
    }

    public final void m0(float f16) {
        float flex = k().getFlex();
        boolean z16 = true;
        if (Float.isNaN(flex) || Float.isNaN(f16) ? !Float.isNaN(flex) || !Float.isNaN(f16) : Math.abs(f16 - flex) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        k().v(f16);
        a0();
    }

    public final float n() {
        return this.lastLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_HEIGHT.ordinal()];
    }

    public final void n0(FlexDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getCom.tencent.mtt.hippy.dom.node.NodeProps.FLEX_DIRECTION java.lang.String() != value) {
            k().w(value);
            a0();
        }
    }

    public final float o() {
        return this.lastLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_WIDTH.ordinal()];
    }

    public final void o0(FlexLayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.flexLayout.e(value);
    }

    public final float p() {
        return this.lastLayout.getParentMaxWidth();
    }

    public final void p0(FlexWrap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getFlexWrap() != value) {
            k().x(value);
            a0();
        }
    }

    public final float[] q() {
        return this.flexLayout.getDimensions();
    }

    public final void q0(FlexJustifyContent value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (k().getCom.tencent.mtt.hippy.dom.node.NodeProps.JUSTIFY_CONTENT java.lang.String() != value) {
            k().y(value);
            a0();
        }
    }

    /* renamed from: r, reason: from getter */
    public final d getLayoutFrame() {
        return this.layoutFrame;
    }

    public final void r0(float f16) {
        this.lastLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_HEIGHT.ordinal()] = f16;
    }

    public final Function1<Boolean, Unit> s() {
        return this.layoutFrameDidChangedCallback;
    }

    public final void s0(float f16) {
        this.lastLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_WIDTH.ordinal()] = f16;
    }

    public final float t() {
        return this.flexLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_HEIGHT.ordinal()];
    }

    public final void t0(float f16) {
        this.lastLayout.g(f16);
    }

    public final float[] u() {
        return this.flexLayout.getPosition();
    }

    public final void u0(Function1<? super Boolean, Unit> function1) {
        this.layoutFrameDidChangedCallback = function1;
    }

    public final float v() {
        return this.flexLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_WIDTH.ordinal()];
    }

    public final void v0(float f16) {
        this.flexLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_HEIGHT.ordinal()] = f16;
    }

    public final float w() {
        return this.flexLayout.getPosition()[FlexLayout.PositionType.POSITION_LEFT.ordinal()];
    }

    public final void w0(float f16) {
        this.flexLayout.getDimensions()[FlexLayout.DimensionType.DIMENSION_WIDTH.ordinal()] = f16;
    }

    public final float x() {
        return this.flexLayout.getPosition()[FlexLayout.PositionType.POSITION_TOP.ordinal()];
    }

    public final void x0(float f16) {
        this.flexLayout.getPosition()[FlexLayout.PositionType.POSITION_LEFT.ordinal()] = f16;
    }

    /* renamed from: y, reason: from getter */
    public final int getLineIndex() {
        return this.lineIndex;
    }

    public final void y0(float f16) {
        this.flexLayout.getPosition()[FlexLayout.PositionType.POSITION_TOP.ordinal()] = f16;
    }

    public final float z(StyleSpace.Type spacingType) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        return k().getMargin().a(spacingType);
    }

    public final void z0(int i3) {
        this.lineIndex = i3;
    }

    public final void c0() {
        this.disableLayout = false;
    }

    public final void d0() {
        this.isDirty = false;
    }

    public static /* synthetic */ void X0(FlexNode flexNode, d dVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            if ((i3 & 4) != 0) {
                z17 = true;
            }
            flexNode.W0(dVar, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayoutFrame");
    }

    public static /* synthetic */ void Z(FlexNode flexNode, FlexNode flexNode2, float f16, com.tencent.kuikly.core.layout.b bVar, FlexLayoutDirection flexLayoutDirection, boolean z16, Set set, int i3, Object obj) {
        if (obj == null) {
            flexNode.Y(flexNode2, f16, (i3 & 4) != 0 ? null : bVar, (i3 & 8) != 0 ? null : flexLayoutDirection, (i3 & 16) != 0 ? true : z16, set);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layoutNode");
    }
}
