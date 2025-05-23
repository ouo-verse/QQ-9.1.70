package com.tencent.mobileqq.qroute.route;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001e\b\u0000\u0012\b\u0010\u00c6\u0001\u001a\u00030\u00c5\u0001\u0012\u0007\u0010\u00ca\u0001\u001a\u00020\u0005\u00a2\u0006\u0006\b\u00cc\u0001\u0010\u00cd\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\r\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000eJ \u0010\u0011\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010J\u0018\u0010\u0014\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0018\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002J'\u0010\u001a\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001d\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010J\u0018\u0010 \u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u001a\u0010#\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!J\u0018\u0010&\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020$J\u001a\u0010(\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010'J\u0018\u0010+\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020)J\u001a\u0010-\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010,J\u0018\u00100\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020.J\u001a\u00102\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u000101J\u0018\u00105\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u00104\u001a\u000203J\u001a\u00107\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u000106J\u0018\u0010:\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u00109\u001a\u000208J\u001a\u0010<\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u00109\u001a\u0004\u0018\u00010;J\u001a\u0010?\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010>\u001a\u0004\u0018\u00010=J'\u0010@\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u0019\u00a2\u0006\u0004\b@\u0010AJ \u0010B\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u0010J\u001a\u0010E\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010D\u001a\u0004\u0018\u00010CJ'\u0010F\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0019\u00a2\u0006\u0004\bF\u0010GJ \u0010H\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u0010J*\u0010K\u001a\u00020\u0000\"\b\b\u0000\u0010I*\u00020C2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010JJ\u001a\u0010N\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010M\u001a\u0004\u0018\u00010LJ\u001c\u0010Q\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010OH\u0007J\u001c\u0010T\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010S\u001a\u0004\u0018\u00010RH\u0007J\u001a\u0010W\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010V\u001a\u0004\u0018\u00010UJ\u0010\u0010X\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010UJ\u0010\u0010X\u001a\u00020\u00002\u0006\u0010V\u001a\u00020YH\u0007J\u001a\u0010\\\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010[\u001a\u00020ZH\u0007J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0012J>\u0010f\u001a\u00020\u000026\u0010e\u001a2\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d0_J\u001a\u0010h\u001a\u00020\u0000\"\u0004\b\u0000\u0010I2\f\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000gJB\u0010l\u001a\u00020\u00002:\u0010e\u001a6\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110i\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020d0_j\u0002`kJ)\u0010n\u001a\u00020\u00002!\u0010e\u001a\u001d\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020d0mJ@\u0010o\u001a\u00020\u000028\u0010e\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d\u0018\u00010_J$\u0010t\u001a\u00020\u00002\u0006\u0010q\u001a\u00020p2\u0006\u0010r\u001a\u00020\u000b2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010UH\u0007J$\u0010t\u001a\u00020\u00002\u0006\u0010v\u001a\u00020u2\u0006\u0010r\u001a\u00020\u000b2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010UH\u0007J$\u0010t\u001a\u00020\u00002\u0006\u0010v\u001a\u00020w2\u0006\u0010r\u001a\u00020\u000b2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010UH\u0007J\u001e\u0010z\u001a\u00020\u00002\u0006\u0010q\u001a\u00020p2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000bJ\u000e\u0010|\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u000bJ\u0010\u0010}\u001a\u00020\u00002\b\u0010s\u001a\u0004\u0018\u00010UJ\u000f\u0010\u0080\u0001\u001a\u00020\u00002\u0006\u0010\u007f\u001a\u00020~J\u0010\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\u0007\u0010\u0083\u0001\u001a\u00020dJ\u0016\u0010\u0084\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010I\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0086\u0001\u001a\u00020\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008a\u0001\u001a\u00020U8\u0006\u00a2\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010]\u001a\u00020\u00122\u0007\u0010\u008e\u0001\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b]\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u008e\u0001\u0010\u0092\u0001\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d\u0018\u00010_29\u0010\u008e\u0001\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d\u0018\u00010_8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R6\u0010\u0096\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010g2\r\u0010\u008e\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010g8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u008e\u0001\u0010\u009a\u0001\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d\u0018\u00010_29\u0010\u008e\u0001\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020d\u0018\u00010_8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u0093\u0001\u001a\u0006\b\u009b\u0001\u0010\u0095\u0001R\u009a\u0001\u0010\u009c\u0001\u001a:\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110i\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020d\u0018\u00010_j\u0004\u0018\u0001`k2?\u0010\u008e\u0001\u001a:\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110i\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(j\u0012\u0004\u0012\u00020d\u0018\u00010_j\u0004\u0018\u0001`k8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u0093\u0001\u001a\u0006\b\u009d\u0001\u0010\u0095\u0001Rd\u0010\u009e\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020d\u0018\u00010m2$\u0010\u008e\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020d\u0018\u00010m8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001R,\u0010\u0006\u001a\u0004\u0018\u00010\u00052\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u0006\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R,\u0010\b\u001a\u0004\u0018\u00010\u00022\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\b\u0010\u0087\u0001\u001a\u0006\b\u00a5\u0001\u0010\u0089\u0001R,\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\b\u0003\u0010\u0087\u0001\u001a\u0006\b\u00a6\u0001\u0010\u0089\u0001R,\u0010q\u001a\u0004\u0018\u00010p2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010p8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bq\u0010\u00a7\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R,\u0010v\u001a\u0004\u0018\u00010u2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010u8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bv\u0010\u00aa\u0001\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001R.\u0010\u00ad\u0001\u001a\u0004\u0018\u00010w2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010w8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R,\u0010s\u001a\u0004\u0018\u00010U2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010U8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bs\u0010\u008b\u0001\u001a\u0006\b\u00b1\u0001\u0010\u008d\u0001R(\u0010x\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\bx\u0010\u00b2\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001R(\u0010y\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\by\u0010\u00b2\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b4\u0001R*\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b4\u0001R,\u0010r\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u000f\n\u0005\br\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R0\u0010\u00bb\u0001\u001a\u0005\u0018\u00010\u00ba\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u00ba\u00018\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001R*\u0010\u00bf\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00bf\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00c0\u0001\u0010\u00b4\u0001R.\u0010\u00c1\u0001\u001a\u0004\u0018\u00010~2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010~8\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001d\u0010\u00c6\u0001\u001a\u00030\u00c5\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u001c\u0010\u00ca\u0001\u001a\u00020\u00058\u0006\u00a2\u0006\u0010\n\u0006\b\u00ca\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00cb\u0001\u0010\u00a4\u0001\u00a8\u0006\u00ce\u0001"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/Navigator;", "", "", "action", "withAction", "Landroid/net/Uri;", "data", "withData", "type", "withType", "key", "", PoiListCacheRecord.WEIGHT_TYPE, "withInt", "", "withIntArray", "Ljava/util/ArrayList;", "withIntArrayList", "", PoiListCacheRecord.TIMESTAMP_TYPE, "withLong", "", "withLongArray", HippyControllerProps.STRING, "withString", "", "withStringArray", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/qroute/route/Navigator;", "stringList", "withStringList", "", HippyControllerProps.BOOLEAN, "withBoolean", "", "booleanArray", "withBooleanArray", "", "double", "withDouble", "", "withDoubleArray", "", "byte", "withByte", "", "withByteArray", "", Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, "withShort", "", "withShortArray", "", WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, "withChar", "", "withCharArray", "", "float", "withFloat", "", "withFloatArray", "", "charSequence", "withCharSequence", "withCharSequenceArray", "(Ljava/lang/String;[Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/qroute/route/Navigator;", "withCharSequenceArrayList", "Landroid/os/Parcelable;", "parcelable", "withParcelable", "withParcelableArray", "(Ljava/lang/String;[Landroid/os/Parcelable;)Lcom/tencent/mobileqq/qroute/route/Navigator;", "withParcelableArrayList", "T", "Landroid/util/SparseArray;", "withSparseParcelableArray", "Ljava/io/Serializable;", "seralizable", "withSerializable", "Landroid/util/Size;", "size", "withSize", "Landroid/util/SizeF;", "sizeF", "withSizeF", "Landroid/os/Bundle;", "bundle", "withBundle", "withAll", "Landroid/os/PersistableBundle;", "Landroid/os/Binder;", "binder", "withBinder", "timeout", "withTimeout", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "navigator", PushClientConstants.TAG_CLASS_NAME, "", "block", "subscribeBefore", "Lcom/tencent/mobileqq/qroute/route/m;", "subscribeSuccess", "Lcom/tencent/mobileqq/qroute/exception/QRouteException;", "exception", "Lcom/tencent/mobileqq/qroute/route/FailedCallback;", "subscribeFailed", "Lkotlin/Function1;", "subscribeTimeout", "subscribeRouteIntercept", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "options", "withRequestCode", "Landroid/app/Fragment;", "fragment", "Landroidx/fragment/app/Fragment;", "enterAnim", "exitAnim", "withTransition", "flag", "withFlags", "withOptions", "Landroid/content/ServiceConnection;", "serviceConnection", "withServiceConn", WadlProxyConsts.FLAGS, "withServiceFlags", Const.BUNDLE_KEY_REQUEST, "requestWithReturn", "()Ljava/lang/Object;", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "extras", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "<set-?>", "J", "getTimeout", "()J", "beforeRouteCallback", "Lkotlin/jvm/functions/Function2;", "getBeforeRouteCallback", "()Lkotlin/jvm/functions/Function2;", "routeSuccessCallback", "Lcom/tencent/mobileqq/qroute/route/m;", "getRouteSuccessCallback", "()Lcom/tencent/mobileqq/qroute/route/m;", "routeInterceptCallback", "getRouteInterceptCallback", "routeFailedCallback", "getRouteFailedCallback", "routeTimeoutCallback", "Lkotlin/jvm/functions/Function1;", "getRouteTimeoutCallback", "()Lkotlin/jvm/functions/Function1;", "Landroid/net/Uri;", "getData", "()Landroid/net/Uri;", "getType", "getAction", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Landroid/app/Fragment;", "getFragment", "()Landroid/app/Fragment;", "fragmentX", "Landroidx/fragment/app/Fragment;", "getFragmentX", "()Landroidx/fragment/app/Fragment;", "getOptions", "I", "getEnterAnim", "()I", "getExitAnim", "getFlags", "Ljava/lang/Integer;", "getRequestCode", "()Ljava/lang/Integer;", "Landroid/os/UserHandle;", "userHandle", "Landroid/os/UserHandle;", "getUserHandle", "()Landroid/os/UserHandle;", "bindServiceFlags", "getBindServiceFlags", "serviceConn", "Landroid/content/ServiceConnection;", "getServiceConn", "()Landroid/content/ServiceConnection;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", LayoutAttrDefine.CLICK_URI, "getUri", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class Navigator {
    static IPatchRedirector $redirector_;

    @Nullable
    private String action;

    @Nullable
    private Activity activity;

    @Nullable
    private Function2<? super Navigator, ? super String, Unit> beforeRouteCallback;
    private int bindServiceFlags;

    @NotNull
    private final Context context;

    @Nullable
    private Uri data;
    private int enterAnim;
    private int exitAnim;

    @NotNull
    private final Bundle extras;
    private int flags;

    @Nullable
    private Fragment fragment;

    @Nullable
    private androidx.fragment.app.Fragment fragmentX;

    @Nullable
    private Bundle options;

    @NotNull
    private final String path;

    @Nullable
    private Integer requestCode;

    @Nullable
    private Function2<? super Navigator, ? super QRouteException, Unit> routeFailedCallback;

    @Nullable
    private Function2<? super Navigator, ? super String, Unit> routeInterceptCallback;

    @Nullable
    private m<?> routeSuccessCallback;

    @Nullable
    private Function1<? super Navigator, Unit> routeTimeoutCallback;

    @Nullable
    private ServiceConnection serviceConn;
    private long timeout;

    @Nullable
    private String type;

    @NotNull
    private final Uri uri;

    @Nullable
    private UserHandle userHandle;

    public Navigator(@NotNull Context context, @NotNull Uri uri) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) context, (Object) uri);
            return;
        }
        this.context = context;
        this.uri = uri;
        String path = uri.getPath();
        if (path == null) {
            Intrinsics.throwNpe();
        }
        this.path = path;
        this.extras = new Bundle();
        this.timeout = -1L;
        this.enterAnim = -1;
        this.exitAnim = -1;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkExpressionValueIsNotNull(queryParameterNames, "uri.queryParameterNames");
        for (String str : queryParameterNames) {
            this.extras.putString(str, this.uri.getQueryParameter(str));
        }
    }

    public static /* synthetic */ Navigator withRequestCode$default(Navigator navigator, Activity activity, int i3, Bundle bundle, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bundle = null;
        }
        return navigator.withRequestCode(activity, i3, bundle);
    }

    @Nullable
    public final String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.action;
    }

    @Nullable
    public final Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Activity) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.activity;
    }

    @Nullable
    public final Function2<Navigator, String, Unit> getBeforeRouteCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.beforeRouteCallback;
    }

    public final int getBindServiceFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.bindServiceFlags;
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (Context) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.context;
    }

    @Nullable
    public final Uri getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Uri) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.data;
    }

    public final int getEnterAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.enterAnim;
    }

    public final int getExitAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.exitAnim;
    }

    @NotNull
    public final Bundle getExtras() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extras;
    }

    public final int getFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.flags;
    }

    @Nullable
    public final Fragment getFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Fragment) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.fragment;
    }

    @Nullable
    public final androidx.fragment.app.Fragment getFragmentX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (androidx.fragment.app.Fragment) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.fragmentX;
    }

    @Nullable
    public final Bundle getOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bundle) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.options;
    }

    @NotNull
    public final String getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.path;
    }

    @Nullable
    public final Integer getRequestCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Integer) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.requestCode;
    }

    @Nullable
    public final Function2<Navigator, QRouteException, Unit> getRouteFailedCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Function2) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.routeFailedCallback;
    }

    @Nullable
    public final Function2<Navigator, String, Unit> getRouteInterceptCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Function2) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.routeInterceptCallback;
    }

    @Nullable
    public final m<?> getRouteSuccessCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (m) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.routeSuccessCallback;
    }

    @Nullable
    public final Function1<Navigator, Unit> getRouteTimeoutCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Function1) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.routeTimeoutCallback;
    }

    @Nullable
    public final ServiceConnection getServiceConn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ServiceConnection) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.serviceConn;
    }

    public final long getTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.timeout;
    }

    @Nullable
    public final String getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.type;
    }

    @NotNull
    public final Uri getUri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return (Uri) iPatchRedirector.redirect((short) 80, (Object) this);
        }
        return this.uri;
    }

    @Nullable
    public final UserHandle getUserHandle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (UserHandle) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.userHandle;
    }

    public final void request() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
        } else {
            Router2.f276492c.l(this);
        }
    }

    public final <T> T requestWithReturn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (T) iPatchRedirector.redirect((short) 78, (Object) this);
        }
        return (T) Router2.f276492c.m(this);
    }

    @NotNull
    public final Navigator subscribeBefore(@NotNull Function2<? super Navigator, ? super String, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (Navigator) iPatchRedirector.redirect((short) 61, (Object) this, (Object) block);
        }
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.beforeRouteCallback = block;
        return this;
    }

    @NotNull
    public final Navigator subscribeFailed(@NotNull Function2<? super Navigator, ? super QRouteException, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (Navigator) iPatchRedirector.redirect((short) 63, (Object) this, (Object) block);
        }
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.routeFailedCallback = block;
        return this;
    }

    @NotNull
    public final Navigator subscribeRouteIntercept(@Nullable Function2<? super Navigator, ? super String, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (Navigator) iPatchRedirector.redirect((short) 65, (Object) this, (Object) block);
        }
        this.routeInterceptCallback = block;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> Navigator subscribeSuccess(@NotNull m<T> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Navigator) iPatchRedirector.redirect((short) 62, (Object) this, (Object) block);
        }
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.routeSuccessCallback = block;
        return this;
    }

    @NotNull
    public final Navigator subscribeTimeout(@NotNull Function1<? super Navigator, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (Navigator) iPatchRedirector.redirect((short) 64, (Object) this, (Object) block);
        }
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.routeTimeoutCallback = block;
        return this;
    }

    @NotNull
    public final Navigator withAction(@NotNull String action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Navigator) iPatchRedirector.redirect((short) 23, (Object) this, (Object) action);
        }
        Intrinsics.checkParameterIsNotNull(action, "action");
        this.action = action;
        return this;
    }

    @NotNull
    public final Navigator withAll(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (Navigator) iPatchRedirector.redirect((short) 57, (Object) this, (Object) bundle);
        }
        this.extras.putAll(bundle);
        return this;
    }

    @TargetApi(18)
    @NotNull
    public final Navigator withBinder(@Nullable String key, @NotNull Binder binder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (Navigator) iPatchRedirector.redirect((short) 59, (Object) this, (Object) key, (Object) binder);
        }
        Intrinsics.checkParameterIsNotNull(binder, "binder");
        this.extras.putBinder(key, binder);
        return this;
    }

    @NotNull
    public final Navigator withBoolean(@Nullable String key, boolean r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Navigator) iPatchRedirector.redirect((short) 34, this, key, Boolean.valueOf(r65));
        }
        this.extras.putBoolean(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withBooleanArray(@Nullable String key, @Nullable boolean[] booleanArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Navigator) iPatchRedirector.redirect((short) 35, (Object) this, (Object) key, (Object) booleanArray);
        }
        this.extras.putBooleanArray(key, booleanArray);
        return this;
    }

    @NotNull
    public final Navigator withBundle(@Nullable String key, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (Navigator) iPatchRedirector.redirect((short) 56, (Object) this, (Object) key, (Object) bundle);
        }
        this.extras.putBundle(key, bundle);
        return this;
    }

    @NotNull
    public final Navigator withByte(@Nullable String key, byte r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Navigator) iPatchRedirector.redirect((short) 38, this, key, Byte.valueOf(r65));
        }
        this.extras.putByte(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withByteArray(@Nullable String key, @Nullable byte[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (Navigator) iPatchRedirector.redirect((short) 39, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putByteArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withChar(@Nullable String key, char r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (Navigator) iPatchRedirector.redirect((short) 42, this, key, Character.valueOf(r65));
        }
        this.extras.putChar(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withCharArray(@Nullable String key, @Nullable char[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (Navigator) iPatchRedirector.redirect((short) 43, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putCharArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withCharSequence(@Nullable String key, @Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (Navigator) iPatchRedirector.redirect((short) 46, (Object) this, (Object) key, (Object) charSequence);
        }
        this.extras.putCharSequence(key, charSequence);
        return this;
    }

    @NotNull
    public final Navigator withCharSequenceArray(@Nullable String key, @Nullable CharSequence[] charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Navigator) iPatchRedirector.redirect((short) 47, (Object) this, (Object) key, (Object) charSequence);
        }
        this.extras.putCharSequenceArray(key, charSequence);
        return this;
    }

    @NotNull
    public final Navigator withCharSequenceArrayList(@Nullable String key, @Nullable ArrayList<CharSequence> charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Navigator) iPatchRedirector.redirect((short) 48, (Object) this, (Object) key, (Object) charSequence);
        }
        this.extras.putCharSequenceArrayList(key, charSequence);
        return this;
    }

    @NotNull
    public final Navigator withData(@NotNull Uri data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Navigator) iPatchRedirector.redirect((short) 24, (Object) this, (Object) data);
        }
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.data = data;
        return this;
    }

    @NotNull
    public final Navigator withDouble(@Nullable String key, double r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Navigator) iPatchRedirector.redirect((short) 36, this, key, Double.valueOf(r65));
        }
        this.extras.putDouble(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withDoubleArray(@Nullable String key, @Nullable double[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Navigator) iPatchRedirector.redirect((short) 37, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putDoubleArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withFlags(int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (Navigator) iPatchRedirector.redirect((short) 73, (Object) this, flag);
        }
        this.flags = flag | this.flags;
        return this;
    }

    @NotNull
    public final Navigator withFloat(@Nullable String key, float r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (Navigator) iPatchRedirector.redirect((short) 44, this, key, Float.valueOf(r65));
        }
        this.extras.putFloat(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withFloatArray(@Nullable String key, @Nullable float[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (Navigator) iPatchRedirector.redirect((short) 45, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putFloatArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withInt(@Nullable String key, int r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Navigator) iPatchRedirector.redirect((short) 26, (Object) this, (Object) key, r56);
        }
        this.extras.putInt(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withIntArray(@Nullable String key, @Nullable int[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Navigator) iPatchRedirector.redirect((short) 27, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putIntArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withIntArrayList(@Nullable String key, @Nullable ArrayList<Integer> r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Navigator) iPatchRedirector.redirect((short) 28, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putIntegerArrayList(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withLong(@Nullable String key, long r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Navigator) iPatchRedirector.redirect((short) 29, this, key, Long.valueOf(r65));
        }
        this.extras.putLong(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withLongArray(@Nullable String key, @Nullable long[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Navigator) iPatchRedirector.redirect((short) 30, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putLongArray(key, r56);
        return this;
    }

    @NotNull
    public final Navigator withOptions(@Nullable Bundle options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (Navigator) iPatchRedirector.redirect((short) 74, (Object) this, (Object) options);
        }
        this.options = options;
        return this;
    }

    @NotNull
    public final Navigator withParcelable(@Nullable String key, @Nullable Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Navigator) iPatchRedirector.redirect((short) 49, (Object) this, (Object) key, (Object) parcelable);
        }
        this.extras.putParcelable(key, parcelable);
        return this;
    }

    @NotNull
    public final Navigator withParcelableArray(@Nullable String key, @Nullable Parcelable[] parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Navigator) iPatchRedirector.redirect((short) 50, (Object) this, (Object) key, (Object) parcelable);
        }
        this.extras.putParcelableArray(key, parcelable);
        return this;
    }

    @NotNull
    public final Navigator withParcelableArrayList(@Nullable String key, @Nullable ArrayList<Parcelable> parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Navigator) iPatchRedirector.redirect((short) 51, (Object) this, (Object) key, (Object) parcelable);
        }
        this.extras.putParcelableArrayList(key, parcelable);
        return this;
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 67)) ? withRequestCode$default(this, activity, i3, (Bundle) null, 4, (Object) null) : (Navigator) iPatchRedirector.redirect((short) 67, (Object) this, (Object) activity, i3);
    }

    @NotNull
    public final Navigator withSerializable(@Nullable String key, @Nullable Serializable seralizable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (Navigator) iPatchRedirector.redirect((short) 53, (Object) this, (Object) key, (Object) seralizable);
        }
        this.extras.putSerializable(key, seralizable);
        return this;
    }

    @NotNull
    public final Navigator withServiceConn(@NotNull ServiceConnection serviceConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (Navigator) iPatchRedirector.redirect((short) 75, (Object) this, (Object) serviceConnection);
        }
        Intrinsics.checkParameterIsNotNull(serviceConnection, "serviceConnection");
        this.serviceConn = serviceConnection;
        return this;
    }

    @NotNull
    public final Navigator withServiceFlags(int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return (Navigator) iPatchRedirector.redirect((short) 76, (Object) this, flags);
        }
        this.bindServiceFlags = flags | this.bindServiceFlags;
        return this;
    }

    @NotNull
    public final Navigator withShort(@Nullable String key, short r65) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Navigator) iPatchRedirector.redirect((short) 40, this, key, Short.valueOf(r65));
        }
        this.extras.putShort(key, r65);
        return this;
    }

    @NotNull
    public final Navigator withShortArray(@Nullable String key, @Nullable short[] r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (Navigator) iPatchRedirector.redirect((short) 41, (Object) this, (Object) key, (Object) r56);
        }
        this.extras.putShortArray(key, r56);
        return this;
    }

    @TargetApi(21)
    @NotNull
    public final Navigator withSize(@Nullable String key, @Nullable Size size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (Navigator) iPatchRedirector.redirect((short) 54, (Object) this, (Object) key, (Object) size);
        }
        this.extras.putSize(key, size);
        return this;
    }

    @TargetApi(21)
    @NotNull
    public final Navigator withSizeF(@Nullable String key, @Nullable SizeF sizeF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Navigator) iPatchRedirector.redirect((short) 55, (Object) this, (Object) key, (Object) sizeF);
        }
        this.extras.putSizeF(key, sizeF);
        return this;
    }

    @NotNull
    public final <T extends Parcelable> Navigator withSparseParcelableArray(@Nullable String key, @Nullable SparseArray<T> parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (Navigator) iPatchRedirector.redirect((short) 52, (Object) this, (Object) key, (Object) parcelable);
        }
        this.extras.putSparseParcelableArray(key, parcelable);
        return this;
    }

    @NotNull
    public final Navigator withString(@Nullable String key, @Nullable String string) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Navigator) iPatchRedirector.redirect((short) 31, (Object) this, (Object) key, (Object) string);
        }
        this.extras.putString(key, string);
        return this;
    }

    @NotNull
    public final Navigator withStringArray(@Nullable String key, @Nullable String[] string) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Navigator) iPatchRedirector.redirect((short) 32, (Object) this, (Object) key, (Object) string);
        }
        this.extras.putStringArray(key, string);
        return this;
    }

    @NotNull
    public final Navigator withStringList(@Nullable String key, @Nullable ArrayList<String> stringList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Navigator) iPatchRedirector.redirect((short) 33, (Object) this, (Object) key, (Object) stringList);
        }
        this.extras.putStringArrayList(key, stringList);
        return this;
    }

    @NotNull
    public final Navigator withTimeout(long timeout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (Navigator) iPatchRedirector.redirect((short) 60, (Object) this, timeout);
        }
        this.timeout = timeout;
        return this;
    }

    @NotNull
    public final Navigator withTransition(@NotNull Activity activity, int enterAnim, int exitAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (Navigator) iPatchRedirector.redirect((short) 72, this, activity, Integer.valueOf(enterAnim), Integer.valueOf(exitAnim));
        }
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activity = activity;
        this.enterAnim = enterAnim;
        this.exitAnim = exitAnim;
        return this;
    }

    @NotNull
    public final Navigator withType(@NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Navigator) iPatchRedirector.redirect((short) 25, (Object) this, (Object) type);
        }
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.type = type;
        return this;
    }

    public static /* synthetic */ Navigator withRequestCode$default(Navigator navigator, Fragment fragment, int i3, Bundle bundle, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bundle = null;
        }
        return navigator.withRequestCode(fragment, i3, bundle);
    }

    @TargetApi(21)
    @NotNull
    public final Navigator withAll(@NotNull PersistableBundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (Navigator) iPatchRedirector.redirect((short) 58, (Object) this, (Object) bundle);
        }
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        this.extras.putAll(bundle);
        return this;
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull Fragment fragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 69)) ? withRequestCode$default(this, fragment, i3, (Bundle) null, 4, (Object) null) : (Navigator) iPatchRedirector.redirect((short) 69, (Object) this, (Object) fragment, i3);
    }

    public static /* synthetic */ Navigator withRequestCode$default(Navigator navigator, androidx.fragment.app.Fragment fragment, int i3, Bundle bundle, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            bundle = null;
        }
        return navigator.withRequestCode(fragment, i3, bundle);
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull androidx.fragment.app.Fragment fragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 71)) ? withRequestCode$default(this, fragment, i3, (Bundle) null, 4, (Object) null) : (Navigator) iPatchRedirector.redirect((short) 71, (Object) this, (Object) fragment, i3);
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull Activity activity, int requestCode, @Nullable Bundle options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (Navigator) iPatchRedirector.redirect((short) 66, this, activity, Integer.valueOf(requestCode), options);
        }
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activity = activity;
        this.requestCode = Integer.valueOf(requestCode);
        this.options = options;
        return this;
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull Fragment fragment, int requestCode, @Nullable Bundle options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (Navigator) iPatchRedirector.redirect((short) 68, this, fragment, Integer.valueOf(requestCode), options);
        }
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        this.fragment = fragment;
        this.requestCode = Integer.valueOf(requestCode);
        this.options = options;
        return this;
    }

    @JvmOverloads
    @NotNull
    public final Navigator withRequestCode(@NotNull androidx.fragment.app.Fragment fragment, int requestCode, @Nullable Bundle options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (Navigator) iPatchRedirector.redirect((short) 70, this, fragment, Integer.valueOf(requestCode), options);
        }
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        this.fragmentX = fragment;
        this.requestCode = Integer.valueOf(requestCode);
        this.options = options;
        return this;
    }
}
