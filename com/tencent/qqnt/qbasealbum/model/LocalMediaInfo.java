package com.tencent.qqnt.qbasealbum.model;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.utils.InitDataUtil;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0003\b\u00a9\u0001\u0018\u0000 \u00a8\u00022\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0006\u00a9\u0002\u00aa\u0002\u00ab\u0002B\u0013\u0012\t\b\u0002\u0010\u00a6\u0002\u001a\u000207\u00a2\u0006\u0005\b\u00a7\u0002\u0010YJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\rR\u001c\u0010\u0016\u001a\b\u0018\u00010\u0015R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0018\u00010\u0018R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\"\u00101\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\"\u00104\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010)R\"\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010)\u001a\u0004\bE\u0010+\"\u0004\bF\u0010-R\"\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010)\u001a\u0004\bH\u0010+\"\u0004\bI\u0010-R\"\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010)\u001a\u0004\bK\u0010+\"\u0004\bL\u0010-R:\u0010O\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010U\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bU\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010#\u001a\u0004\b[\u0010%\"\u0004\b\\\u0010'R\"\u0010]\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010)\u001a\u0004\b^\u0010+\"\u0004\b_\u0010-R$\u0010c\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010+\"\u0004\bb\u0010-R$\u0010f\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bd\u0010\u001f\"\u0004\be\u0010!R$\u0010i\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bg\u0010\u001f\"\u0004\bh\u0010!R$\u0010l\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bj\u0010W\"\u0004\bk\u0010YR$\u0010o\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bm\u0010W\"\u0004\bn\u0010YR$\u0010p\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bp\u0010W\"\u0004\bq\u0010YR(\u0010t\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\br\u0010%\"\u0004\bs\u0010'R$\u0010w\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bu\u0010+\"\u0004\bv\u0010-R(\u0010}\u001a\u0004\u0018\u00010x2\b\u0010`\u001a\u0004\u0018\u00010x8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R$\u0010~\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b~\u0010W\"\u0004\b\u007f\u0010YR+\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010%\"\u0005\b\u0081\u0001\u0010'R+\u0010\u0088\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R'\u0010\u0089\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010W\"\u0005\b\u008a\u0001\u0010YR'\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010+\"\u0005\b\u008c\u0001\u0010-R'\u0010\u0090\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010+\"\u0005\b\u008f\u0001\u0010-R'\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010+\"\u0005\b\u0092\u0001\u0010-R'\u0010\u0096\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010+\"\u0005\b\u0095\u0001\u0010-R'\u0010\u0097\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010W\"\u0005\b\u0098\u0001\u0010YR'\u0010\u0099\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0099\u0001\u0010W\"\u0005\b\u009a\u0001\u0010YR'\u0010\u009b\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010W\"\u0005\b\u009c\u0001\u0010YR+\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009d\u0001\u0010%\"\u0005\b\u009e\u0001\u0010'RW\u0010\u00a2\u0001\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`N2\u001e\u0010`\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`N8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a0\u0001\u0010R\"\u0005\b\u00a1\u0001\u0010TR'\u0010\u00a5\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a3\u0001\u0010\u001f\"\u0005\b\u00a4\u0001\u0010!R+\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a6\u0001\u0010%\"\u0005\b\u00a7\u0001\u0010'R+\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a9\u0001\u0010%\"\u0005\b\u00aa\u0001\u0010'R'\u0010\u00ae\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ac\u0001\u0010+\"\u0005\b\u00ad\u0001\u0010-R'\u0010\u00b1\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00af\u0001\u0010+\"\u0005\b\u00b0\u0001\u0010-R'\u0010\u00b4\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b2\u0001\u0010+\"\u0005\b\u00b3\u0001\u0010-R'\u0010\u00b7\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b5\u0001\u0010+\"\u0005\b\u00b6\u0001\u0010-R+\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b8\u0001\u0010%\"\u0005\b\u00b9\u0001\u0010'RW\u0010\u00bd\u0001\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u0001`N2\u001e\u0010`\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u0001`N8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00bb\u0001\u0010R\"\u0005\b\u00bc\u0001\u0010TR'\u0010\u00c0\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00be\u0001\u0010\u001f\"\u0005\b\u00bf\u0001\u0010!R'\u0010\u00c3\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c1\u0001\u0010+\"\u0005\b\u00c2\u0001\u0010-R'\u0010\u00c6\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c4\u0001\u0010+\"\u0005\b\u00c5\u0001\u0010-R'\u0010\u00c9\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c7\u0001\u0010\u001f\"\u0005\b\u00c8\u0001\u0010!R'\u0010\u00cc\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ca\u0001\u0010\u001f\"\u0005\b\u00cb\u0001\u0010!R+\u0010\u00cf\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00cd\u0001\u0010%\"\u0005\b\u00ce\u0001\u0010'R+\u0010\u00d2\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d0\u0001\u0010%\"\u0005\b\u00d1\u0001\u0010'R+\u0010\u00d5\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d3\u0001\u0010%\"\u0005\b\u00d4\u0001\u0010'R+\u0010\u00d8\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d6\u0001\u0010%\"\u0005\b\u00d7\u0001\u0010'R'\u0010\u00db\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d9\u0001\u0010+\"\u0005\b\u00da\u0001\u0010-R+\u0010\u00de\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00dc\u0001\u0010%\"\u0005\b\u00dd\u0001\u0010'R+\u0010\u00e1\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00df\u0001\u0010\u0085\u0001\"\u0006\b\u00e0\u0001\u0010\u0087\u0001R+\u0010\u00e4\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e2\u0001\u0010\u0085\u0001\"\u0006\b\u00e3\u0001\u0010\u0087\u0001R+\u0010\u00e7\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e5\u0001\u0010\u0085\u0001\"\u0006\b\u00e6\u0001\u0010\u0087\u0001R+\u0010\u00ea\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00e8\u0001\u0010\u0085\u0001\"\u0006\b\u00e9\u0001\u0010\u0087\u0001R+\u0010\u00ed\u0001\u001a\u00030\u0083\u00012\u0007\u0010`\u001a\u00030\u0083\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00eb\u0001\u0010\u0085\u0001\"\u0006\b\u00ec\u0001\u0010\u0087\u0001RW\u0010\u00f0\u0001\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`N2\u001e\u0010`\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010Mj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`N8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ee\u0001\u0010R\"\u0005\b\u00ef\u0001\u0010TR'\u0010\u00f1\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f1\u0001\u0010W\"\u0005\b\u00f2\u0001\u0010YR'\u0010\u00f5\u0001\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f3\u0001\u0010W\"\u0005\b\u00f4\u0001\u0010YR'\u0010\u00f8\u0001\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f6\u0001\u0010\u001f\"\u0005\b\u00f7\u0001\u0010!R'\u0010\u00fb\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f9\u0001\u0010+\"\u0005\b\u00fa\u0001\u0010-R'\u0010\u00fe\u0001\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00fc\u0001\u0010+\"\u0005\b\u00fd\u0001\u0010-R'\u0010\u0081\u0002\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ff\u0001\u0010+\"\u0005\b\u0080\u0002\u0010-R+\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0082\u0002\u0010%\"\u0005\b\u0083\u0002\u0010'R'\u0010\u0087\u0002\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0085\u0002\u0010W\"\u0005\b\u0086\u0002\u0010YR'\u0010\u008a\u0002\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0088\u0002\u0010+\"\u0005\b\u0089\u0002\u0010-R+\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008b\u0002\u0010%\"\u0005\b\u008c\u0002\u0010'R+\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008e\u0002\u0010%\"\u0005\b\u008f\u0002\u0010'R'\u0010\u0093\u0002\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0091\u0002\u0010+\"\u0005\b\u0092\u0002\u0010-R+\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0094\u0002\u0010%\"\u0005\b\u0095\u0002\u0010'R'\u0010\u0097\u0002\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0097\u0002\u0010W\"\u0005\b\u0098\u0002\u0010YR+\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0099\u0002\u0010%\"\u0005\b\u009a\u0002\u0010'R'\u0010\u009c\u0002\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009c\u0002\u0010W\"\u0005\b\u009d\u0002\u0010YR'\u0010\u00a0\u0002\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009e\u0002\u0010+\"\u0005\b\u009f\u0002\u0010-R'\u0010\u00a3\u0002\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a1\u0002\u0010W\"\u0005\b\u00a2\u0002\u0010YR'\u0010\u00a4\u0002\u001a\u0002072\u0006\u0010`\u001a\u0002078F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a4\u0002\u0010W\"\u0005\b\u00a5\u0002\u0010Y\u00a8\u0006\u00ac\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "toString", "other", "", "compareTo", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "", "writeToParcel", "localMediaInfo", "copyForEdit", "copyForEditRestore", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "toSelectMediaInfo", "initExtData", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$d;", "extData", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$d;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$c;", "innerData", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$c;", "", "_id", "J", "get_id", "()J", "set_id", "(J)V", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "pathHash", "I", "getPathHash", "()I", "setPathHash", "(I)V", "fileSize", "getFileSize", "setFileSize", "addedDate", "getAddedDate", "setAddedDate", "modifiedDate", "getModifiedDate", "setModifiedDate", "", "is0BFile", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "set0BFile", "(Ljava/lang/Boolean;)V", "videoDuration", "Ljava/lang/Long;", "getVideoDuration", "()Ljava/lang/Long;", "setVideoDuration", "(Ljava/lang/Long;)V", "innerMimeType", "mMediaType", "getMMediaType", "setMMediaType", "mediaWidth", "getMediaWidth", "setMediaWidth", "mediaHeight", "getMediaHeight", "setMediaHeight", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOriginPath", "Ljava/util/ArrayList;", "getMOriginPath", "()Ljava/util/ArrayList;", "setMOriginPath", "(Ljava/util/ArrayList;)V", "isSystemMeidaStore", "Z", "()Z", "setSystemMeidaStore", "(Z)V", "picPathBeforeEdit", "getPicPathBeforeEdit", "setPicPathBeforeEdit", "extAlbumId", "getExtAlbumId", "setExtAlbumId", "value", "getOrientation", "setOrientation", "orientation", "getMStartTime", "setMStartTime", "mStartTime", "getMTotalDuration", "setMTotalDuration", "mTotalDuration", "getMChecked", "setMChecked", "mChecked", "getNeedProcess", "setNeedProcess", "needProcess", "isSegment", "setSegment", "getFakeVid", "setFakeVid", "fakeVid", "getMVideoType", "setMVideoType", "mVideoType", "Landroid/graphics/Rect;", "getThumbRect", "()Landroid/graphics/Rect;", "setThumbRect", "(Landroid/graphics/Rect;)V", "thumbRect", "isRecord", "setRecord", "getThumbnailPath", "setThumbnailPath", "thumbnailPath", "", "getThumbnailProgress", "()F", "setThumbnailProgress", "(F)V", "thumbnailProgress", "isProgressThumbnail", "setProgressThumbnail", "getSelectStatus", "setSelectStatus", "selectStatus", "getRotation", "setRotation", BasicAnimation.KeyPath.ROTATION, "getLatitude", "setLatitude", "latitude", "getLongitude", "setLongitude", "longitude", "isMakeVideo", "setMakeVideo", "isSyncToWeishi", "setSyncToWeishi", "isVideoReady", "setVideoReady", "getMissionID", "setMissionID", "missionID", "getAiTextLabel", "setAiTextLabel", "aiTextLabel", "getMCloudPhotoOwnerUin", "setMCloudPhotoOwnerUin", "mCloudPhotoOwnerUin", "getMCloudPhotoOwnerAlbumId", "setMCloudPhotoOwnerAlbumId", "mCloudPhotoOwnerAlbumId", "getMCloudPhotoId", "setMCloudPhotoId", "mCloudPhotoId", "getThumbWidth", "setThumbWidth", "thumbWidth", "getThumbHeight", "setThumbHeight", "thumbHeight", "getIndex", "setIndex", "index", "getPosition", "setPosition", "position", "getMMimeType", "setMMimeType", "mMimeType", "getMTransferPosList", "setMTransferPosList", "mTransferPosList", "getMediaBitrate", "setMediaBitrate", "mediaBitrate", "getMediaOriginWidth", "setMediaOriginWidth", "mediaOriginWidth", "getMediaOriginHeight", "setMediaOriginHeight", "mediaOriginHeight", "getMediaOriginSize", "setMediaOriginSize", "mediaOriginSize", "getMediaOriginBitrate", "setMediaOriginBitrate", "mediaOriginBitrate", "getMaterialID", "setMaterialID", "materialID", "getMaterialName", "setMaterialName", "materialName", "getFilterID", "setFilterID", ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID, "getScheme", "setScheme", ZPlanPublishSource.FROM_SCHEME, "getShowCircleTakeSame", "setShowCircleTakeSame", "showCircleTakeSame", "getMKuolieId", "setMKuolieId", "mKuolieId", "getMKuolieCenterX", "setMKuolieCenterX", "mKuolieCenterX", "getMKuolieCenterY", "setMKuolieCenterY", "mKuolieCenterY", "getMKuolieRotate", "setMKuolieRotate", "mKuolieRotate", "getMKuolieWidthScale", "setMKuolieWidthScale", "mKuolieWidthScale", "getMKuolieHeightScale", "setMKuolieHeightScale", "mKuolieHeightScale", "getMHashTagList", "setMHashTagList", "mHashTagList", "isRegionThumbUseNewDecoder", "setRegionThumbUseNewDecoder", "getMIsUploadOrigin", "setMIsUploadOrigin", "mIsUploadOrigin", "getVisableTime", "setVisableTime", "visableTime", "getListViewPosition", "setListViewPosition", "listViewPosition", "getThumbSize", "setThumbSize", "thumbSize", "getPanoramaPhotoType", "setPanoramaPhotoType", "panoramaPhotoType", "getMAudioPath", "setMAudioPath", "mAudioPath", "getMHasAudioTrack", "setMHasAudioTrack", "mHasAudioTrack", "getMSampleRate", "setMSampleRate", "mSampleRate", "getMAlbumName", "setMAlbumName", "mAlbumName", "getMTransId", "setMTransId", "mTransId", "getMTextId", "setMTextId", "mTextId", "getMTextStr", "setMTextStr", "mTextStr", "isRwa", "setRwa", "getVideoMimeType", "setVideoMimeType", "videoMimeType", "isHDRVideo", "setHDRVideo", "getExtIndexInSelectedMedia", "setExtIndexInSelectedMedia", "extIndexInSelectedMedia", "getExtIsEdit", "setExtIsEdit", "extIsEdit", "isVideoShareToQZone", "setVideoShareToQZone", "needSimpleData", "<init>", "Companion", "b", "c", "d", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class LocalMediaInfo implements Comparable<LocalMediaInfo>, Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<LocalMediaInfo> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int DEFAULT = 0;
    public static final int PHOTO_LAST_SELECTED = 3;
    public static final int PHOTO_SELECTED = 1;
    public static final int PHOTO_UNSELECTED = 2;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicInteger f361271d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<Integer, String> f361272e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, Integer> f361273f;

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f361274h;
    private static final long serialVersionUID;
    private long _id;
    private long addedDate;
    private int extAlbumId;

    @Nullable
    private d extData;
    private long fileSize;

    @Nullable
    private c innerData;
    private int innerMimeType;

    @Nullable
    private Boolean is0BFile;
    private boolean isSystemMeidaStore;
    private int mMediaType;

    @Nullable
    private ArrayList<String> mOriginPath;
    private int mediaHeight;
    private int mediaWidth;
    private long modifiedDate;

    @Nullable
    private String path;
    private int pathHash;

    @Nullable
    private String picPathBeforeEdit;

    @Nullable
    private Long videoDuration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qbasealbum/model/LocalMediaInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<LocalMediaInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMediaInfo createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z36 = false;
            LocalMediaInfo localMediaInfo = new LocalMediaInfo(z36, 1, null);
            localMediaInfo.set_id(parcel.readLong());
            localMediaInfo.setPath(parcel.readString());
            localMediaInfo.setFileSize(parcel.readLong());
            localMediaInfo.setAddedDate(parcel.readLong());
            localMediaInfo.setModifiedDate(parcel.readLong());
            localMediaInfo.setOrientation(parcel.readInt());
            localMediaInfo.setRotation(parcel.readInt());
            com.tencent.qqnt.qbasealbum.ktx.b.t(localMediaInfo, parcel.readLong());
            if (parcel.readByte() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            localMediaInfo.setMChecked(z16);
            localMediaInfo.setSelectStatus(parcel.readInt());
            localMediaInfo.setThumbWidth(parcel.readInt());
            localMediaInfo.setThumbHeight(parcel.readInt());
            localMediaInfo.setThumbnailPath(parcel.readString());
            localMediaInfo.setIndex(parcel.readInt());
            localMediaInfo.setPosition(parcel.readInt());
            localMediaInfo.setMMimeType(parcel.readString());
            localMediaInfo.setMMediaType(parcel.readInt());
            localMediaInfo.setMediaWidth(parcel.readInt());
            localMediaInfo.setMediaHeight(parcel.readInt());
            localMediaInfo.setMediaBitrate(parcel.readLong());
            localMediaInfo.setMediaOriginWidth(parcel.readInt());
            localMediaInfo.setMediaOriginHeight(parcel.readInt());
            localMediaInfo.setMediaOriginSize(parcel.readLong());
            localMediaInfo.setMediaOriginBitrate(parcel.readLong());
            if (parcel.readByte() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            localMediaInfo.setSystemMeidaStore(z17);
            if (parcel.readByte() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            localMediaInfo.setRegionThumbUseNewDecoder(z18);
            localMediaInfo.setLongitude(parcel.readInt());
            localMediaInfo.setLatitude(parcel.readInt());
            localMediaInfo.setPanoramaPhotoType(parcel.readInt());
            localMediaInfo.setMCloudPhotoOwnerUin(parcel.readLong());
            localMediaInfo.setMCloudPhotoOwnerAlbumId(parcel.readString());
            localMediaInfo.setMCloudPhotoId(parcel.readString());
            if (parcel.readByte() == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            localMediaInfo.setVideoReady(z19);
            localMediaInfo.setMaterialID(parcel.readString());
            localMediaInfo.setMaterialName(parcel.readString());
            localMediaInfo.setFilterID(parcel.readString());
            localMediaInfo.setScheme(parcel.readString());
            localMediaInfo.setShowCircleTakeSame(parcel.readInt());
            localMediaInfo.setMissionID(parcel.readString());
            localMediaInfo.setMTransferPosList(parcel.readArrayList(Long.TYPE.getClassLoader()));
            localMediaInfo.setAiTextLabel(parcel.readArrayList(String.class.getClassLoader()));
            localMediaInfo.setThumbnailProgress(parcel.readFloat());
            localMediaInfo.setMOriginPath(parcel.readArrayList(String.class.getClassLoader()));
            localMediaInfo.setMKuolieId(parcel.readString());
            localMediaInfo.setMKuolieCenterX(parcel.readFloat());
            localMediaInfo.setMKuolieCenterY(parcel.readFloat());
            localMediaInfo.setMKuolieRotate(parcel.readFloat());
            localMediaInfo.setMKuolieWidthScale(parcel.readFloat());
            localMediaInfo.setMKuolieHeightScale(parcel.readFloat());
            localMediaInfo.setMHashTagList(parcel.readArrayList(String.class.getClassLoader()));
            if (parcel.readByte() == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            localMediaInfo.setRwa(z26);
            localMediaInfo.setPicPathBeforeEdit(parcel.readString());
            localMediaInfo.setVideoMimeType(parcel.readString());
            if (parcel.readByte() == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            localMediaInfo.setHDRVideo(z27);
            if (parcel.readByte() == 1) {
                z28 = true;
            } else {
                z28 = false;
            }
            localMediaInfo.setSegment(z28);
            if (parcel.readByte() == 1) {
                z29 = true;
            } else {
                z29 = false;
            }
            localMediaInfo.setVideoShareToQZone(z29);
            localMediaInfo.setExtAlbumId(parcel.readInt());
            localMediaInfo.setExtIndexInSelectedMedia(parcel.readInt());
            if (parcel.readByte() == 1) {
                z36 = true;
            }
            localMediaInfo.setExtIsEdit(z36);
            return localMediaInfo;
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMediaInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LocalMediaInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new LocalMediaInfo[0];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$b;", "", "", "serialVersionUID", "J", "a", "()J", "getSerialVersionUID$annotations", "()V", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "DEFAULT", "I", "PHOTO_LAST_SELECTED", "PHOTO_SELECTED", "PHOTO_UNSELECTED", "<init>", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.LocalMediaInfo$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return LocalMediaInfo.serialVersionUID;
            }
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
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
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b`\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00cf\u0001\u0010\u00d0\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\"\u0010,\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R\"\u0010/\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b.\u0010\u0014R\"\u00103\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R:\u0010;\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u000104j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`58\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b\u0003\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR$\u0010B\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0018\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR$\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0018\u001a\u0004\b<\u0010\u0019\"\u0004\bC\u0010\u001bR$\u0010H\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0018\u001a\u0004\bF\u0010\u0019\"\u0004\bG\u0010\u001bR:\u0010L\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u000104j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`58\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:R\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR$\u0010\\\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u0018\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\u001bR$\u0010`\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\u0018\u001a\u0004\b^\u0010\u0019\"\u0004\b_\u0010\u001bR$\u0010c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019\"\u0004\bb\u0010\u001bR$\u0010g\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u0018\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\u001bR\"\u0010m\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010V\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010p\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010\u0018\u001a\u0004\b]\u0010\u0019\"\u0004\bo\u0010\u001bR\"\u0010u\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010Z\u001a\u0004\bQ\u0010r\"\u0004\bs\u0010tR\"\u0010x\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010Z\u001a\u0004\bU\u0010r\"\u0004\bw\u0010tR\"\u0010{\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010Z\u001a\u0004\ba\u0010r\"\u0004\bz\u0010tR\"\u0010}\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010Z\u001a\u0004\bd\u0010r\"\u0004\b|\u0010tR#\u0010\u0080\u0001\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b~\u0010Z\u001a\u0004\bY\u0010r\"\u0004\b\u007f\u0010tR<\u0010\u0082\u0001\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u000104j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`58\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bJ\u00107\u001a\u0004\bI\u00108\"\u0005\b\u0081\u0001\u0010:R%\u0010\u0085\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u0083\u0001\u0010\u0010\u001a\u0004\bM\u0010\u0012\"\u0005\b\u0084\u0001\u0010\u0014R%\u0010\u0088\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bZ\u0010\u0004\u001a\u0005\b\u0086\u0001\u0010\u0006\"\u0005\b\u0087\u0001\u0010\bR$\u0010\u008a\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b^\u0010V\u001a\u0004\b%\u0010j\"\u0005\b\u0089\u0001\u0010lR&\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bN\u0010\u0018\u001a\u0004\b0\u0010\u0019\"\u0005\b\u008b\u0001\u0010\u001bR$\u0010\u008e\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bV\u0010\u0010\u001a\u0004\bE\u0010\u0012\"\u0005\b\u008d\u0001\u0010\u0014R$\u0010\u0090\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u0004\u0010V\u001a\u0004\bn\u0010j\"\u0005\b\u008f\u0001\u0010lR&\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bR\u0010\u0018\u001a\u0004\b-\u0010\u0019\"\u0005\b\u0091\u0001\u0010\u001bR'\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u0093\u0001\u0010\u0018\u001a\u0004\b~\u0010\u0019\"\u0005\b\u0094\u0001\u0010\u001bR%\u0010\u0098\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u0096\u0001\u0010V\u001a\u0004\bv\u0010j\"\u0005\b\u0097\u0001\u0010lR&\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u0011\u0010\u0018\u001a\u0004\by\u0010\u0019\"\u0005\b\u0099\u0001\u0010\u001bR%\u0010\u009d\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u009b\u0001\u0010\u0010\u001a\u0004\b6\u0010\u0012\"\u0005\b\u009c\u0001\u0010\u0014R&\u0010\u00a1\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009e\u0001\u0010\u0010\u001a\u0005\b\u009f\u0001\u0010\u0012\"\u0005\b\u00a0\u0001\u0010\u0014R%\u0010\u00a3\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\be\u0010V\u001a\u0005\b\u0083\u0001\u0010j\"\u0005\b\u00a2\u0001\u0010lR'\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bi\u0010\u0018\u001a\u0005\b\u00a4\u0001\u0010\u0019\"\u0005\b\u00a5\u0001\u0010\u001bR%\u0010\u00a9\u0001\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b \u0010Z\u001a\u0005\b\u00a7\u0001\u0010r\"\u0005\b\u00a8\u0001\u0010tR&\u0010\u00ad\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00aa\u0001\u0010\u0010\u001a\u0005\b\u00ab\u0001\u0010\u0012\"\u0005\b\u00ac\u0001\u0010\u0014R(\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a4\u0001\u0010\u0018\u001a\u0005\b\u0096\u0001\u0010\u0019\"\u0005\b\u00ae\u0001\u0010\u001bR%\u0010\u00b1\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00a7\u0001\u0010V\u001a\u0004\b\u0017\u0010j\"\u0005\b\u00b0\u0001\u0010lR&\u0010\u00b4\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b2\u0001\u0010V\u001a\u0005\b\u009e\u0001\u0010j\"\u0005\b\u00b3\u0001\u0010lR&\u0010\u00b6\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0086\u0001\u0010V\u001a\u0005\b\u0093\u0001\u0010j\"\u0005\b\u00b5\u0001\u0010lR%\u0010\u00b9\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00b7\u0001\u0010V\u001a\u0004\b\u0004\u0010j\"\u0005\b\u00b8\u0001\u0010lR%\u0010\u00bc\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0010\u0010\u0010\u001a\u0005\b\u00ba\u0001\u0010\u0012\"\u0005\b\u00bb\u0001\u0010\u0014R%\u0010\u00be\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b*\u0010V\u001a\u0005\b\u00aa\u0001\u0010j\"\u0005\b\u00bd\u0001\u0010lR%\u0010\u00c0\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b&\u0010V\u001a\u0005\b\u009b\u0001\u0010j\"\u0005\b\u00bf\u0001\u0010lR&\u0010\u00c3\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00ba\u0001\u0010\u0010\u001a\u0005\b\u00c1\u0001\u0010\u0012\"\u0005\b\u00c2\u0001\u0010\u0014R(\u0010\u00c5\u0001\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00c1\u0001\u0010\u0018\u001a\u0005\b\u00b2\u0001\u0010\u0019\"\u0005\b\u00c4\u0001\u0010\u001bR&\u0010\u00c7\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0010\u001a\u0005\b\u00b7\u0001\u0010\u0012\"\u0005\b\u00c6\u0001\u0010\u0014R%\u0010\u00ca\u0001\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b1\u0010\u0010\u001a\u0005\b\u00c8\u0001\u0010\u0012\"\u0005\b\u00c9\u0001\u0010\u0014R%\u0010\u00cc\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00ab\u0001\u0010V\u001a\u0004\b\u001e\u0010j\"\u0005\b\u00cb\u0001\u0010lR%\u0010\u00ce\u0001\u001a\u00020h8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00c8\u0001\u0010V\u001a\u0004\b)\u0010j\"\u0005\b\u00cd\u0001\u0010l\u00a8\u0006\u00d1\u0001"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$c;", "", "", "a", "J", "y", "()J", "H0", "(J)V", "mStartTime", "b", "B", "K0", "mTotalDuration", "", "c", "Z", "N", "()Z", "X0", "(Z)V", "needProcess", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "j0", "(Ljava/lang/String;)V", "fakeVid", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", ExifInterface.LATITUDE_SOUTH, "()Landroid/graphics/Rect;", "i1", "(Landroid/graphics/Rect;)V", "thumbRect", "f", "b0", "b1", "isRecord", "g", "a0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "isProgressThumbnail", h.F, "O0", "isMakeVideo", "i", "f0", "h1", "isSyncToWeishi", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "i0", "(Ljava/util/ArrayList;)V", "aiTextLabel", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v0", "mCloudPhotoOwnerUin", "l", "u0", "mCloudPhotoOwnerAlbumId", "t0", "mCloudPhotoId", DomainData.DOMAIN_NAME, "w", "F0", "mMimeType", "o", "D", "M0", "mTransferPosList", "p", "H", "R0", "mediaBitrate", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", "U0", "mediaOriginSize", "r", "I", "S0", "mediaOriginBitrate", ReportConstant.COSTREPORT_PREFIX, UserInfo.SEX_FEMALE, "P0", "materialID", "t", "G", "Q0", "materialName", "u", "k0", ITroopAnnouncementHelperApi.CONTROL_INFO_FILTER_ID, "v", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "e1", ZPlanPublishSource.FROM_SCHEME, "", BdhLogUtil.LogTag.Tag_Req, "()I", "g1", "(I)V", "showCircleTakeSame", HippyTKDListViewAdapter.X, "C0", "mKuolieId", "", "()F", "z0", "(F)V", "mKuolieCenterX", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "A0", "mKuolieCenterY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D0", "mKuolieRotate", "E0", "mKuolieWidthScale", BdhLogUtil.LogTag.Tag_Conn, "B0", "mKuolieHeightScale", "x0", "mHashTagList", "E", "y0", "mIsUploadOrigin", "X", "p1", "visableTime", "o0", "listViewPosition", "r0", "mAudioPath", "w0", "mHasAudioTrack", "G0", "mSampleRate", "q0", "mAlbumName", "L", "L0", "mTransId", "M", "I0", "mTextId", "J0", "mTextStr", "O", "s0", "mChecked", "P", "e0", "f1", "isSegment", "N0", "mVideoType", "U", "k1", "thumbnailPath", "V", "l1", "thumbnailProgress", "T", "g0", ICustomDataEditor.NUMBER_PARAM_1, "isVideoReady", "W0", "missionID", "m0", "index", "W", "Z0", "position", "V0", "mediaOriginWidth", "Y", "T0", "mediaOriginHeight", "c0", "c1", "isRegionThumbUseNewDecoder", "j1", "thumbSize", "Y0", "panoramaPhotoType", "d0", "d1", "isRwa", "m1", "videoMimeType", "l0", "isHDRVideo", "h0", "o1", "isVideoShareToQZone", "n0", "latitude", "p0", "longitude", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: A, reason: from kotlin metadata */
        private float mKuolieRotate;

        /* renamed from: B, reason: from kotlin metadata */
        private float mKuolieWidthScale;

        /* renamed from: C, reason: from kotlin metadata */
        private float mKuolieHeightScale;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private ArrayList<String> mHashTagList;

        /* renamed from: E, reason: from kotlin metadata */
        private boolean mIsUploadOrigin;

        /* renamed from: F, reason: from kotlin metadata */
        private long visableTime;

        /* renamed from: G, reason: from kotlin metadata */
        private int listViewPosition;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private String mAudioPath;

        /* renamed from: I, reason: from kotlin metadata */
        private boolean mHasAudioTrack;

        /* renamed from: J, reason: from kotlin metadata */
        private int mSampleRate;

        /* renamed from: K, reason: from kotlin metadata */
        @Nullable
        private String mAlbumName;

        /* renamed from: L, reason: from kotlin metadata */
        @Nullable
        private String mTransId;

        /* renamed from: M, reason: from kotlin metadata */
        private int mTextId;

        /* renamed from: N, reason: from kotlin metadata */
        @Nullable
        private String mTextStr;

        /* renamed from: O, reason: from kotlin metadata */
        private boolean mChecked;

        /* renamed from: P, reason: from kotlin metadata */
        private boolean isSegment;

        /* renamed from: Q, reason: from kotlin metadata */
        private int mVideoType;

        /* renamed from: R, reason: from kotlin metadata */
        @Nullable
        private String thumbnailPath;

        /* renamed from: S, reason: from kotlin metadata */
        private float thumbnailProgress;

        /* renamed from: T, reason: from kotlin metadata */
        private boolean isVideoReady;

        /* renamed from: U, reason: from kotlin metadata */
        @Nullable
        private String missionID;

        /* renamed from: V, reason: from kotlin metadata */
        private int index;

        /* renamed from: W, reason: from kotlin metadata */
        private int position;

        /* renamed from: X, reason: from kotlin metadata */
        private int mediaOriginWidth;

        /* renamed from: Y, reason: from kotlin metadata */
        private int mediaOriginHeight;

        /* renamed from: Z, reason: from kotlin metadata */
        private boolean isRegionThumbUseNewDecoder;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long mStartTime;

        /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
        private int thumbSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long mTotalDuration;

        /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
        private int panoramaPhotoType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean needProcess;

        /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
        private boolean isRwa;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String fakeVid;

        /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String videoMimeType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Rect thumbRect;

        /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
        private boolean isHDRVideo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isRecord;

        /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
        private boolean isVideoShareToQZone;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean isProgressThumbnail;

        /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
        private int latitude;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean isMakeVideo;

        /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
        private int longitude;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean isSyncToWeishi;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<String> aiTextLabel;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private long mCloudPhotoOwnerUin;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mCloudPhotoOwnerAlbumId;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mCloudPhotoId;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mMimeType;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ArrayList<Long> mTransferPosList;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private long mediaBitrate;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private long mediaOriginSize;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private long mediaOriginBitrate;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String materialID;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String materialName;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String filterID;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String scheme;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        private int showCircleTakeSame;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mKuolieId;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        private float mKuolieCenterX;

        /* renamed from: z, reason: collision with root package name and from kotlin metadata */
        private float mKuolieCenterY;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                return;
            }
            this.isProgressThumbnail = true;
            this.mCloudPhotoOwnerAlbumId = "";
            this.mCloudPhotoId = "";
            this.materialID = "";
            this.materialName = "";
            this.filterID = "";
            this.scheme = "";
            this.mKuolieId = "";
            this.mHashTagList = new ArrayList<>();
            this.listViewPosition = -1;
            this.mSampleRate = 1;
            this.mTextId = -1;
            this.thumbnailProgress = 0.5f;
        }

        @Nullable
        public final String A() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
                return (String) iPatchRedirector.redirect((short) 80, (Object) this);
            }
            return this.mTextStr;
        }

        public final void A0(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
                iPatchRedirector.redirect((short) 53, this, Float.valueOf(f16));
            } else {
                this.mKuolieCenterY = f16;
            }
        }

        public final long B() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.mTotalDuration;
        }

        public final void B0(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
                iPatchRedirector.redirect((short) 59, this, Float.valueOf(f16));
            } else {
                this.mKuolieHeightScale = f16;
            }
        }

        @Nullable
        public final String C() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
                return (String) iPatchRedirector.redirect((short) 76, (Object) this);
            }
            return this.mTransId;
        }

        public final void C0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
                iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
            } else {
                this.mKuolieId = str;
            }
        }

        @Nullable
        public final ArrayList<Long> D() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (ArrayList) iPatchRedirector.redirect((short) 30, (Object) this);
            }
            return this.mTransferPosList;
        }

        public final void D0(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
                iPatchRedirector.redirect((short) 55, this, Float.valueOf(f16));
            } else {
                this.mKuolieRotate = f16;
            }
        }

        public final int E() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
                return ((Integer) iPatchRedirector.redirect((short) 86, (Object) this)).intValue();
            }
            return this.mVideoType;
        }

        public final void E0(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
                iPatchRedirector.redirect((short) 57, this, Float.valueOf(f16));
            } else {
                this.mKuolieWidthScale = f16;
            }
        }

        @Nullable
        public final String F() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                return (String) iPatchRedirector.redirect((short) 38, (Object) this);
            }
            return this.materialID;
        }

        public final void F0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            } else {
                this.mMimeType = str;
            }
        }

        @Nullable
        public final String G() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                return (String) iPatchRedirector.redirect((short) 40, (Object) this);
            }
            return this.materialName;
        }

        public final void G0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
                iPatchRedirector.redirect((short) 73, (Object) this, i3);
            } else {
                this.mSampleRate = i3;
            }
        }

        public final long H() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
            }
            return this.mediaBitrate;
        }

        public final void H0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.mStartTime = j3;
            }
        }

        public final long I() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return ((Long) iPatchRedirector.redirect((short) 36, (Object) this)).longValue();
            }
            return this.mediaOriginBitrate;
        }

        public final void I0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
                iPatchRedirector.redirect((short) 79, (Object) this, i3);
            } else {
                this.mTextId = i3;
            }
        }

        public final int J() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
                return ((Integer) iPatchRedirector.redirect((short) 102, (Object) this)).intValue();
            }
            return this.mediaOriginHeight;
        }

        public final void J0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
                iPatchRedirector.redirect((short) 81, (Object) this, (Object) str);
            } else {
                this.mTextStr = str;
            }
        }

        public final long K() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
            }
            return this.mediaOriginSize;
        }

        public final void K0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            } else {
                this.mTotalDuration = j3;
            }
        }

        public final int L() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
                return ((Integer) iPatchRedirector.redirect((short) 100, (Object) this)).intValue();
            }
            return this.mediaOriginWidth;
        }

        public final void L0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
                iPatchRedirector.redirect((short) 77, (Object) this, (Object) str);
            } else {
                this.mTransId = str;
            }
        }

        @Nullable
        public final String M() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
                return (String) iPatchRedirector.redirect((short) 94, (Object) this);
            }
            return this.missionID;
        }

        public final void M0(@Nullable ArrayList<Long> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, (Object) arrayList);
            } else {
                this.mTransferPosList = arrayList;
            }
        }

        public final boolean N() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.needProcess;
        }

        public final void N0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
                iPatchRedirector.redirect((short) 87, (Object) this, i3);
            } else {
                this.mVideoType = i3;
            }
        }

        public final int O() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
                return ((Integer) iPatchRedirector.redirect((short) 108, (Object) this)).intValue();
            }
            return this.panoramaPhotoType;
        }

        public final void O0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, z16);
            } else {
                this.isMakeVideo = z16;
            }
        }

        public final int P() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
                return ((Integer) iPatchRedirector.redirect((short) 98, (Object) this)).intValue();
            }
            return this.position;
        }

        public final void P0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
            } else {
                this.materialID = str;
            }
        }

        @Nullable
        public final String Q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
                return (String) iPatchRedirector.redirect((short) 44, (Object) this);
            }
            return this.scheme;
        }

        public final void Q0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
            } else {
                this.materialName = str;
            }
        }

        public final int R() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
                return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
            }
            return this.showCircleTakeSame;
        }

        public final void R0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, (Object) this, j3);
            } else {
                this.mediaBitrate = j3;
            }
        }

        @Nullable
        public final Rect S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Rect) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.thumbRect;
        }

        public final void S0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                iPatchRedirector.redirect((short) 37, (Object) this, j3);
            } else {
                this.mediaOriginBitrate = j3;
            }
        }

        public final int T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
                return ((Integer) iPatchRedirector.redirect((short) 106, (Object) this)).intValue();
            }
            return this.thumbSize;
        }

        public final void T0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
                iPatchRedirector.redirect((short) 103, (Object) this, i3);
            } else {
                this.mediaOriginHeight = i3;
            }
        }

        @Nullable
        public final String U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
                return (String) iPatchRedirector.redirect((short) 88, (Object) this);
            }
            return this.thumbnailPath;
        }

        public final void U0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                iPatchRedirector.redirect((short) 35, (Object) this, j3);
            } else {
                this.mediaOriginSize = j3;
            }
        }

        public final float V() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
                return ((Float) iPatchRedirector.redirect((short) 90, (Object) this)).floatValue();
            }
            return this.thumbnailProgress;
        }

        public final void V0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
                iPatchRedirector.redirect((short) 101, (Object) this, i3);
            } else {
                this.mediaOriginWidth = i3;
            }
        }

        @Nullable
        public final String W() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
                return (String) iPatchRedirector.redirect((short) 112, (Object) this);
            }
            return this.videoMimeType;
        }

        public final void W0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
                iPatchRedirector.redirect((short) 95, (Object) this, (Object) str);
            } else {
                this.missionID = str;
            }
        }

        public final long X() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
                return ((Long) iPatchRedirector.redirect((short) 64, (Object) this)).longValue();
            }
            return this.visableTime;
        }

        public final void X0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.needProcess = z16;
            }
        }

        public final boolean Y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
                return ((Boolean) iPatchRedirector.redirect((short) 114, (Object) this)).booleanValue();
            }
            return this.isHDRVideo;
        }

        public final void Y0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
                iPatchRedirector.redirect((short) 109, (Object) this, i3);
            } else {
                this.panoramaPhotoType = i3;
            }
        }

        public final boolean Z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
            }
            return this.isMakeVideo;
        }

        public final void Z0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
                iPatchRedirector.redirect((short) 99, (Object) this, i3);
            } else {
                this.position = i3;
            }
        }

        @Nullable
        public final ArrayList<String> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (ArrayList) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return this.aiTextLabel;
        }

        public final boolean a0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.isProgressThumbnail;
        }

        public final void a1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.isProgressThumbnail = z16;
            }
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.fakeVid;
        }

        public final boolean b0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.isRecord;
        }

        public final void b1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, z16);
            } else {
                this.isRecord = z16;
            }
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                return (String) iPatchRedirector.redirect((short) 42, (Object) this);
            }
            return this.filterID;
        }

        public final boolean c0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
                return ((Boolean) iPatchRedirector.redirect((short) 104, (Object) this)).booleanValue();
            }
            return this.isRegionThumbUseNewDecoder;
        }

        public final void c1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
                iPatchRedirector.redirect((short) 105, (Object) this, z16);
            } else {
                this.isRegionThumbUseNewDecoder = z16;
            }
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
                return ((Integer) iPatchRedirector.redirect((short) 96, (Object) this)).intValue();
            }
            return this.index;
        }

        public final boolean d0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
                return ((Boolean) iPatchRedirector.redirect((short) 110, (Object) this)).booleanValue();
            }
            return this.isRwa;
        }

        public final void d1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
                iPatchRedirector.redirect((short) 111, (Object) this, z16);
            } else {
                this.isRwa = z16;
            }
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
                return ((Integer) iPatchRedirector.redirect((short) 118, (Object) this)).intValue();
            }
            return this.latitude;
        }

        public final boolean e0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
                return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this)).booleanValue();
            }
            return this.isSegment;
        }

        public final void e1(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
            } else {
                this.scheme = str;
            }
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
                return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
            }
            return this.listViewPosition;
        }

        public final boolean f0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
            }
            return this.isSyncToWeishi;
        }

        public final void f1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
                iPatchRedirector.redirect((short) 85, (Object) this, z16);
            } else {
                this.isSegment = z16;
            }
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
                return ((Integer) iPatchRedirector.redirect((short) 120, (Object) this)).intValue();
            }
            return this.longitude;
        }

        public final boolean g0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
                return ((Boolean) iPatchRedirector.redirect((short) 92, (Object) this)).booleanValue();
            }
            return this.isVideoReady;
        }

        public final void g1(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
                iPatchRedirector.redirect((short) 47, (Object) this, i3);
            } else {
                this.showCircleTakeSame = i3;
            }
        }

        @Nullable
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
                return (String) iPatchRedirector.redirect((short) 74, (Object) this);
            }
            return this.mAlbumName;
        }

        public final boolean h0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
                return ((Boolean) iPatchRedirector.redirect((short) 116, (Object) this)).booleanValue();
            }
            return this.isVideoShareToQZone;
        }

        public final void h1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, z16);
            } else {
                this.isSyncToWeishi = z16;
            }
        }

        @Nullable
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
                return (String) iPatchRedirector.redirect((short) 68, (Object) this);
            }
            return this.mAudioPath;
        }

        public final void i0(@Nullable ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) arrayList);
            } else {
                this.aiTextLabel = arrayList;
            }
        }

        public final void i1(@Nullable Rect rect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) rect);
            } else {
                this.thumbRect = rect;
            }
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
                return ((Boolean) iPatchRedirector.redirect((short) 82, (Object) this)).booleanValue();
            }
            return this.mChecked;
        }

        public final void j0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.fakeVid = str;
            }
        }

        public final void j1(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
                iPatchRedirector.redirect((short) 107, (Object) this, i3);
            } else {
                this.thumbSize = i3;
            }
        }

        @Nullable
        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (String) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return this.mCloudPhotoId;
        }

        public final void k0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
            } else {
                this.filterID = str;
            }
        }

        public final void k1(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
                iPatchRedirector.redirect((short) 89, (Object) this, (Object) str);
            } else {
                this.thumbnailPath = str;
            }
        }

        @Nullable
        public final String l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return this.mCloudPhotoOwnerAlbumId;
        }

        public final void l0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
                iPatchRedirector.redirect((short) 115, (Object) this, z16);
            } else {
                this.isHDRVideo = z16;
            }
        }

        public final void l1(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
                iPatchRedirector.redirect((short) 91, this, Float.valueOf(f16));
            } else {
                this.thumbnailProgress = f16;
            }
        }

        public final long m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
            }
            return this.mCloudPhotoOwnerUin;
        }

        public final void m0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
                iPatchRedirector.redirect((short) 97, (Object) this, i3);
            } else {
                this.index = i3;
            }
        }

        public final void m1(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
                iPatchRedirector.redirect((short) 113, (Object) this, (Object) str);
            } else {
                this.videoMimeType = str;
            }
        }

        public final boolean n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
                return ((Boolean) iPatchRedirector.redirect((short) 70, (Object) this)).booleanValue();
            }
            return this.mHasAudioTrack;
        }

        public final void n0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
                iPatchRedirector.redirect((short) 119, (Object) this, i3);
            } else {
                this.latitude = i3;
            }
        }

        public final void n1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
                iPatchRedirector.redirect((short) 93, (Object) this, z16);
            } else {
                this.isVideoReady = z16;
            }
        }

        @Nullable
        public final ArrayList<String> o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
                return (ArrayList) iPatchRedirector.redirect((short) 60, (Object) this);
            }
            return this.mHashTagList;
        }

        public final void o0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
                iPatchRedirector.redirect((short) 67, (Object) this, i3);
            } else {
                this.listViewPosition = i3;
            }
        }

        public final void o1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
                iPatchRedirector.redirect((short) 117, (Object) this, z16);
            } else {
                this.isVideoShareToQZone = z16;
            }
        }

        public final boolean p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
                return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
            }
            return this.mIsUploadOrigin;
        }

        public final void p0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
                iPatchRedirector.redirect((short) 121, (Object) this, i3);
            } else {
                this.longitude = i3;
            }
        }

        public final void p1(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
                iPatchRedirector.redirect((short) 65, (Object) this, j3);
            } else {
                this.visableTime = j3;
            }
        }

        public final float q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
                return ((Float) iPatchRedirector.redirect((short) 50, (Object) this)).floatValue();
            }
            return this.mKuolieCenterX;
        }

        public final void q0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
                iPatchRedirector.redirect((short) 75, (Object) this, (Object) str);
            } else {
                this.mAlbumName = str;
            }
        }

        public final float r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
                return ((Float) iPatchRedirector.redirect((short) 52, (Object) this)).floatValue();
            }
            return this.mKuolieCenterY;
        }

        public final void r0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
                iPatchRedirector.redirect((short) 69, (Object) this, (Object) str);
            } else {
                this.mAudioPath = str;
            }
        }

        public final float s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
                return ((Float) iPatchRedirector.redirect((short) 58, (Object) this)).floatValue();
            }
            return this.mKuolieHeightScale;
        }

        public final void s0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
                iPatchRedirector.redirect((short) 83, (Object) this, z16);
            } else {
                this.mChecked = z16;
            }
        }

        @Nullable
        public final String t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
                return (String) iPatchRedirector.redirect((short) 48, (Object) this);
            }
            return this.mKuolieId;
        }

        public final void t0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            } else {
                this.mCloudPhotoId = str;
            }
        }

        public final float u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
                return ((Float) iPatchRedirector.redirect((short) 54, (Object) this)).floatValue();
            }
            return this.mKuolieRotate;
        }

        public final void u0(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            } else {
                this.mCloudPhotoOwnerAlbumId = str;
            }
        }

        public final float v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
                return ((Float) iPatchRedirector.redirect((short) 56, (Object) this)).floatValue();
            }
            return this.mKuolieWidthScale;
        }

        public final void v0(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, j3);
            } else {
                this.mCloudPhotoOwnerUin = j3;
            }
        }

        @Nullable
        public final String w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (String) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return this.mMimeType;
        }

        public final void w0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
                iPatchRedirector.redirect((short) 71, (Object) this, z16);
            } else {
                this.mHasAudioTrack = z16;
            }
        }

        public final int x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
                return ((Integer) iPatchRedirector.redirect((short) 72, (Object) this)).intValue();
            }
            return this.mSampleRate;
        }

        public final void x0(@Nullable ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
                iPatchRedirector.redirect((short) 61, (Object) this, (Object) arrayList);
            } else {
                this.mHashTagList = arrayList;
            }
        }

        public final long y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.mStartTime;
        }

        public final void y0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
                iPatchRedirector.redirect((short) 63, (Object) this, z16);
            } else {
                this.mIsUploadOrigin = z16;
            }
        }

        public final int z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
                return ((Integer) iPatchRedirector.redirect((short) 78, (Object) this)).intValue();
            }
            return this.mTextId;
        }

        public final void z0(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
                iPatchRedirector.redirect((short) 51, this, Float.valueOf(f16));
            } else {
                this.mKuolieCenterX = f16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo$d;", "", "", "a", "I", "c", "()I", "j", "(I)V", "orientation", "b", "e", "l", "selectStatus", "d", "k", BasicAnimation.KeyPath.ROTATION, "g", DomainData.DOMAIN_NAME, "thumbWidth", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "thumbHeight", h.F, "extIndexInSelectedMedia", "", "Z", "()Z", "i", "(Z)V", "extIsEdit", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int orientation;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int selectStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int rotation;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int thumbWidth;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int thumbHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int extIndexInSelectedMedia;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean extIsEdit;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.extIndexInSelectedMedia;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.extIsEdit;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.orientation;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.rotation;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.selectStatus;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.thumbHeight;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.thumbWidth;
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, i3);
            } else {
                this.extIndexInSelectedMedia = i3;
            }
        }

        public final void i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, z16);
            } else {
                this.extIsEdit = z16;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.orientation = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.rotation = i3;
            }
        }

        public final void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.selectStatus = i3;
            }
        }

        public final void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.thumbHeight = i3;
            }
        }

        public final void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.thumbWidth = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 176)) {
            redirector.redirect((short) 176);
            return;
        }
        INSTANCE = new Companion(null);
        serialVersionUID = 4712583313352439425L;
        f361271d = new AtomicInteger(0);
        f361272e = new ConcurrentHashMap<>();
        f361273f = new ConcurrentHashMap<>();
        f361274h = g.f361234b.a();
        CREATOR = new a();
    }

    public LocalMediaInfo() {
        this(false, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 175)) {
            return;
        }
        iPatchRedirector.redirect((short) 175, (Object) this);
    }

    public static final long getSerialVersionUID() {
        return INSTANCE.a();
    }

    @NotNull
    public final LocalMediaInfo copyForEdit(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 171)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 171, (Object) this, (Object) localMediaInfo);
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        com.tencent.qqnt.qbasealbum.ktx.b.r(this, true);
        this.isSystemMeidaStore = false;
        this.path = localMediaInfo.path;
        this.fileSize = localMediaInfo.fileSize;
        setOrientation(localMediaInfo.getOrientation());
        com.tencent.qqnt.qbasealbum.ktx.b.t(this, com.tencent.qqnt.qbasealbum.ktx.b.f(localMediaInfo));
        setMVideoType(localMediaInfo.getMVideoType());
        setRotation(localMediaInfo.getRotation());
        setThumbWidth(localMediaInfo.getThumbWidth());
        setThumbHeight(localMediaInfo.getThumbHeight());
        this.mediaWidth = localMediaInfo.mediaWidth;
        this.mediaHeight = localMediaInfo.mediaHeight;
        this.mOriginPath = localMediaInfo.mOriginPath;
        return this;
    }

    @NotNull
    public final LocalMediaInfo copyForEditRestore(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 172)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 172, (Object) this, (Object) localMediaInfo);
        }
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        com.tencent.qqnt.qbasealbum.ktx.b.r(this, false);
        this.isSystemMeidaStore = true;
        this.path = localMediaInfo.path;
        this.fileSize = localMediaInfo.fileSize;
        setOrientation(localMediaInfo.getOrientation());
        com.tencent.qqnt.qbasealbum.ktx.b.t(this, com.tencent.qqnt.qbasealbum.ktx.b.f(localMediaInfo));
        setMVideoType(localMediaInfo.getMVideoType());
        setRotation(localMediaInfo.getRotation());
        setThumbWidth(localMediaInfo.getThumbWidth());
        setThumbHeight(localMediaInfo.getThumbHeight());
        this.mediaWidth = localMediaInfo.mediaWidth;
        this.mediaHeight = localMediaInfo.mediaHeight;
        this.mOriginPath = localMediaInfo.mOriginPath;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 169)) {
            return ((Integer) iPatchRedirector.redirect((short) 169, (Object) this)).intValue();
        }
        return 0;
    }

    public final long getAddedDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.addedDate;
    }

    @Nullable
    public final ArrayList<String> getAiTextLabel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (ArrayList) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    public final int getExtAlbumId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 159)) {
            return ((Integer) iPatchRedirector.redirect((short) 159, (Object) this)).intValue();
        }
        return this.extAlbumId;
    }

    public final int getExtIndexInSelectedMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            return ((Integer) iPatchRedirector.redirect((short) 161, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    public final boolean getExtIsEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 163)) {
            return ((Boolean) iPatchRedirector.redirect((short) 163, (Object) this)).booleanValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.b();
        }
        return false;
    }

    @Nullable
    public final String getFakeVid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public final long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.fileSize;
    }

    @Nullable
    public final String getFilterID() {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return (String) iPatchRedirector.redirect((short) 103, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (c16 = cVar.c()) == null) {
            return "";
        }
        return c16;
    }

    public final int getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Integer) iPatchRedirector.redirect((short) 73, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.d();
        }
        return 0;
    }

    public final int getLatitude() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.e();
        }
        return 0;
    }

    public final int getListViewPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            return ((Integer) iPatchRedirector.redirect((short) 131, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.f();
        }
        return -1;
    }

    public final int getLongitude() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.g();
        }
        return 0;
    }

    @Nullable
    public final String getMAlbumName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            return (String) iPatchRedirector.redirect((short) 143, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.h();
        }
        return null;
    }

    @Nullable
    public final String getMAudioPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            return (String) iPatchRedirector.redirect((short) 137, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.i();
        }
        return null;
    }

    public final boolean getMChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.j();
        }
        return false;
    }

    @Nullable
    public final String getMCloudPhotoId() {
        String k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (String) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (k3 = cVar.k()) == null) {
            return "";
        }
        return k3;
    }

    @Nullable
    public final String getMCloudPhotoOwnerAlbumId() {
        String l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (String) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (l3 = cVar.l()) == null) {
            return "";
        }
        return l3;
    }

    public final long getMCloudPhotoOwnerUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Long) iPatchRedirector.redirect((short) 63, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.m();
        }
        return 0L;
    }

    public final boolean getMHasAudioTrack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            return ((Boolean) iPatchRedirector.redirect((short) 139, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.n();
        }
        return false;
    }

    @Nullable
    public final ArrayList<String> getMHashTagList() {
        ArrayList<String> o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return (ArrayList) iPatchRedirector.redirect((short) 121, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (o16 = cVar.o()) == null) {
            return new ArrayList<>();
        }
        return o16;
    }

    public final boolean getMIsUploadOrigin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            return ((Boolean) iPatchRedirector.redirect((short) 127, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.p();
        }
        return false;
    }

    public final float getMKuolieCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return ((Float) iPatchRedirector.redirect((short) 111, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.q();
        }
        return 0.0f;
    }

    public final float getMKuolieCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return ((Float) iPatchRedirector.redirect((short) 113, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.r();
        }
        return 0.0f;
    }

    public final float getMKuolieHeightScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return ((Float) iPatchRedirector.redirect((short) 119, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.s();
        }
        return 0.0f;
    }

    @Nullable
    public final String getMKuolieId() {
        String t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return (String) iPatchRedirector.redirect((short) 109, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (t16 = cVar.t()) == null) {
            return "";
        }
        return t16;
    }

    public final float getMKuolieRotate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return ((Float) iPatchRedirector.redirect((short) 115, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.u();
        }
        return 0.0f;
    }

    public final float getMKuolieWidthScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return ((Float) iPatchRedirector.redirect((short) 117, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.v();
        }
        return 0.0f;
    }

    public final int getMMediaType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Integer) iPatchRedirector.redirect((short) 79, (Object) this)).intValue();
        }
        return this.mMediaType;
    }

    @Nullable
    public final String getMMimeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (String) iPatchRedirector.redirect((short) 77, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            return cVar.w();
        }
        int i3 = this.innerMimeType;
        if (i3 == -1) {
            return null;
        }
        return f361272e.get(Integer.valueOf(i3));
    }

    @Nullable
    public final ArrayList<String> getMOriginPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (ArrayList) iPatchRedirector.redirect((short) 97, (Object) this);
        }
        return this.mOriginPath;
    }

    public final int getMSampleRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            return ((Integer) iPatchRedirector.redirect((short) 141, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.x();
        }
        return 1;
    }

    public final long getMStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.y();
        }
        return 0L;
    }

    public final int getMTextId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            return ((Integer) iPatchRedirector.redirect((short) 147, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.z();
        }
        return -1;
    }

    @Nullable
    public final String getMTextStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return (String) iPatchRedirector.redirect((short) 149, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.A();
        }
        return null;
    }

    public final long getMTotalDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.B();
        }
        return 0L;
    }

    @Nullable
    public final String getMTransId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            return (String) iPatchRedirector.redirect((short) 145, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.C();
        }
        return null;
    }

    @Nullable
    public final ArrayList<Long> getMTransferPosList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (ArrayList) iPatchRedirector.redirect((short) 81, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.D();
        }
        return null;
    }

    public final int getMVideoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.E();
        }
        return 0;
    }

    @Nullable
    public final String getMaterialID() {
        String F;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (String) iPatchRedirector.redirect((short) 99, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (F = cVar.F()) == null) {
            return "";
        }
        return F;
    }

    @Nullable
    public final String getMaterialName() {
        String G;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (String) iPatchRedirector.redirect((short) 101, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (G = cVar.G()) == null) {
            return "";
        }
        return G;
    }

    public final long getMediaBitrate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Long) iPatchRedirector.redirect((short) 87, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.H();
        }
        return 0L;
    }

    public final int getMediaHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return ((Integer) iPatchRedirector.redirect((short) 85, (Object) this)).intValue();
        }
        return this.mediaHeight;
    }

    public final long getMediaOriginBitrate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return ((Long) iPatchRedirector.redirect((short) 95, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.I();
        }
        return 0L;
    }

    public final int getMediaOriginHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Integer) iPatchRedirector.redirect((short) 91, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.J();
        }
        return 0;
    }

    public final long getMediaOriginSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Long) iPatchRedirector.redirect((short) 93, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.K();
        }
        return 0L;
    }

    public final int getMediaOriginWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Integer) iPatchRedirector.redirect((short) 89, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.L();
        }
        return 0;
    }

    public final int getMediaWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return ((Integer) iPatchRedirector.redirect((short) 83, (Object) this)).intValue();
        }
        return this.mediaWidth;
    }

    @Nullable
    public final String getMissionID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.M();
        }
        return null;
    }

    public final long getModifiedDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.modifiedDate;
    }

    public final boolean getNeedProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.N();
        }
        return false;
    }

    public final int getOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }

    public final int getPanoramaPhotoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            return ((Integer) iPatchRedirector.redirect((short) 135, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.O();
        }
        return 0;
    }

    @Nullable
    public final String getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.path;
    }

    public final int getPathHash() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.pathHash;
    }

    @Nullable
    public final String getPicPathBeforeEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            return (String) iPatchRedirector.redirect((short) 153, (Object) this);
        }
        return this.picPathBeforeEdit;
    }

    public final int getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.P();
        }
        return 0;
    }

    public final int getRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.d();
        }
        return 0;
    }

    @Nullable
    public final String getScheme() {
        String Q;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return (String) iPatchRedirector.redirect((short) 105, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (Q = cVar.Q()) == null) {
            return "";
        }
        return Q;
    }

    public final int getSelectStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.e();
        }
        return 0;
    }

    public final int getShowCircleTakeSame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return ((Integer) iPatchRedirector.redirect((short) 107, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.R();
        }
        return 0;
    }

    public final int getThumbHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Integer) iPatchRedirector.redirect((short) 71, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.f();
        }
        return 0;
    }

    @Nullable
    public final Rect getThumbRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Rect) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.S();
        }
        return null;
    }

    public final int getThumbSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            return ((Integer) iPatchRedirector.redirect((short) 133, (Object) this)).intValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.T();
        }
        return 0;
    }

    public final int getThumbWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Integer) iPatchRedirector.redirect((short) 69, (Object) this)).intValue();
        }
        d dVar = this.extData;
        if (dVar != null) {
            return dVar.g();
        }
        return 0;
    }

    @Nullable
    public final String getThumbnailPath() {
        String U;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar == null || (U = cVar.U()) == null) {
            return "";
        }
        return U;
    }

    public final float getThumbnailProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Float) iPatchRedirector.redirect((short) 41, (Object) this)).floatValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.V();
        }
        return 0.5f;
    }

    @Nullable
    public final Long getVideoDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Long) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.videoDuration;
    }

    @Nullable
    public final String getVideoMimeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            return (String) iPatchRedirector.redirect((short) 155, (Object) this);
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.W();
        }
        return null;
    }

    public final long getVisableTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            return ((Long) iPatchRedirector.redirect((short) 129, (Object) this)).longValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.X();
        }
        return 0L;
    }

    public final long get_id() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this._id;
    }

    public final void initExtData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 174)) {
            iPatchRedirector.redirect((short) 174, (Object) this);
        } else if (this.extData == null) {
            this.extData = new d();
        }
    }

    @Nullable
    public final Boolean is0BFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Boolean) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.is0BFile;
    }

    public final boolean isHDRVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 157)) {
            return ((Boolean) iPatchRedirector.redirect((short) 157, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.Y();
        }
        return false;
    }

    public final boolean isMakeVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.Z();
        }
        return false;
    }

    public final boolean isProgressThumbnail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.a0();
        }
        return true;
    }

    public final boolean isRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.b0();
        }
        return false;
    }

    public final boolean isRegionThumbUseNewDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            return ((Boolean) iPatchRedirector.redirect((short) 125, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.c0();
        }
        return false;
    }

    public final boolean isRwa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            return ((Boolean) iPatchRedirector.redirect((short) 151, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.d0();
        }
        return false;
    }

    public final boolean isSegment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.e0();
        }
        return false;
    }

    public final boolean isSyncToWeishi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.f0();
        }
        return false;
    }

    public final boolean isSystemMeidaStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return ((Boolean) iPatchRedirector.redirect((short) 123, (Object) this)).booleanValue();
        }
        return this.isSystemMeidaStore;
    }

    public final boolean isVideoReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.g0();
        }
        return false;
    }

    public final boolean isVideoShareToQZone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 165)) {
            return ((Boolean) iPatchRedirector.redirect((short) 165, (Object) this)).booleanValue();
        }
        c cVar = this.innerData;
        if (cVar != null) {
            return cVar.h0();
        }
        return false;
    }

    public final void set0BFile(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bool);
        } else {
            this.is0BFile = bool;
        }
    }

    public final void setAddedDate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.addedDate = j3;
        }
    }

    public final void setAiTextLabel(@Nullable ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) arrayList);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.i0(arrayList);
        }
    }

    public final void setExtAlbumId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            iPatchRedirector.redirect((short) 160, (Object) this, i3);
        } else {
            this.extAlbumId = i3;
        }
    }

    public final void setExtIndexInSelectedMedia(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 162)) {
            iPatchRedirector.redirect((short) 162, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.h(i3);
        }
    }

    public final void setExtIsEdit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 164)) {
            iPatchRedirector.redirect((short) 164, (Object) this, z16);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.i(z16);
        }
    }

    public final void setFakeVid(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.j0(str);
        }
    }

    public final void setFileSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.fileSize = j3;
        }
    }

    public final void setFilterID(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.k0(str);
        }
    }

    public final void setHDRVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 158)) {
            iPatchRedirector.redirect((short) 158, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.l0(z16);
        }
    }

    public final void setIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.m0(i3);
        }
    }

    public final void setLatitude(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.n0(i3);
        }
    }

    public final void setListViewPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.o0(i3);
        }
    }

    public final void setLongitude(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.p0(i3);
        }
    }

    public final void setMAlbumName(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.q0(str);
        }
    }

    public final void setMAudioPath(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.r0(str);
        }
    }

    public final void setMChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.s0(z16);
        }
    }

    public final void setMCloudPhotoId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.t0(str);
        }
    }

    public final void setMCloudPhotoOwnerAlbumId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.u0(str);
        }
    }

    public final void setMCloudPhotoOwnerUin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.v0(j3);
        }
    }

    public final void setMHasAudioTrack(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            iPatchRedirector.redirect((short) 140, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.w0(z16);
        }
    }

    public final void setMHashTagList(@Nullable ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this, (Object) arrayList);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.x0(arrayList);
        }
    }

    public final void setMIsUploadOrigin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.y0(z16);
        }
    }

    public final void setMKuolieCenterX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.z0(f16);
        }
    }

    public final void setMKuolieCenterY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.A0(f16);
        }
    }

    public final void setMKuolieHeightScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.B0(f16);
        }
    }

    public final void setMKuolieId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.C0(str);
        }
    }

    public final void setMKuolieRotate(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            iPatchRedirector.redirect((short) 116, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.D0(f16);
        }
    }

    public final void setMKuolieWidthScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            iPatchRedirector.redirect((short) 118, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.E0(f16);
        }
    }

    public final void setMMediaType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, i3);
        } else {
            this.mMediaType = i3;
        }
    }

    public final void setMMimeType(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            cVar.F0(str);
            return;
        }
        if (str == null) {
            this.innerMimeType = -1;
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = f361273f;
        if (concurrentHashMap.containsKey(str)) {
            Integer num = concurrentHashMap.get(str);
            Intrinsics.checkNotNull(num);
            this.innerMimeType = num.intValue();
            return;
        }
        AtomicInteger atomicInteger = f361271d;
        synchronized (atomicInteger) {
            int andIncrement = atomicInteger.getAndIncrement();
            concurrentHashMap.put(str, Integer.valueOf(andIncrement));
            f361272e.put(Integer.valueOf(andIncrement), str);
            this.innerMimeType = andIncrement;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setMOriginPath(@Nullable ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) arrayList);
        } else {
            this.mOriginPath = arrayList;
        }
    }

    public final void setMSampleRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            iPatchRedirector.redirect((short) 142, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.G0(i3);
        }
    }

    public final void setMStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.H0(j3);
        }
    }

    public final void setMTextId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            iPatchRedirector.redirect((short) 148, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.I0(i3);
        }
    }

    public final void setMTextStr(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            iPatchRedirector.redirect((short) 150, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.J0(str);
        }
    }

    public final void setMTotalDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.K0(j3);
        }
    }

    public final void setMTransId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            iPatchRedirector.redirect((short) 146, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.L0(str);
        }
    }

    public final void setMTransferPosList(@Nullable ArrayList<Long> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) arrayList);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.M0(arrayList);
        }
    }

    public final void setMVideoType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.N0(i3);
        }
    }

    public final void setMakeVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.O0(z16);
        }
    }

    public final void setMaterialID(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.P0(str);
        }
    }

    public final void setMaterialName(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.Q0(str);
        }
    }

    public final void setMediaBitrate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.R0(j3);
        }
    }

    public final void setMediaHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, i3);
        } else {
            this.mediaHeight = i3;
        }
    }

    public final void setMediaOriginBitrate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.S0(j3);
        }
    }

    public final void setMediaOriginHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.T0(i3);
        }
    }

    public final void setMediaOriginSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.U0(j3);
        }
    }

    public final void setMediaOriginWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.V0(i3);
        }
    }

    public final void setMediaWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, i3);
        } else {
            this.mediaWidth = i3;
        }
    }

    public final void setMissionID(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.W0(str);
        }
    }

    public final void setModifiedDate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.modifiedDate = j3;
        }
    }

    public final void setNeedProcess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.X0(z16);
        }
    }

    public final void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.j(i3);
        }
    }

    public final void setPanoramaPhotoType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            iPatchRedirector.redirect((short) 136, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.Y0(i3);
        }
    }

    public final void setPath(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.path = str;
        }
    }

    public final void setPathHash(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.pathHash = i3;
        }
    }

    public final void setPicPathBeforeEdit(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 154)) {
            iPatchRedirector.redirect((short) 154, (Object) this, (Object) str);
        } else {
            this.picPathBeforeEdit = str;
        }
    }

    public final void setPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.Z0(i3);
        }
    }

    public final void setProgressThumbnail(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.a1(z16);
        }
    }

    public final void setRecord(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.b1(z16);
        }
    }

    public final void setRegionThumbUseNewDecoder(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.c1(z16);
        }
    }

    public final void setRotation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.k(i3);
        }
    }

    public final void setRwa(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.d1(z16);
        }
    }

    public final void setScheme(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.e1(str);
        }
    }

    public final void setSegment(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.f1(z16);
        }
    }

    public final void setSelectStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.l(i3);
        }
    }

    public final void setShowCircleTakeSame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.g1(i3);
        }
    }

    public final void setSyncToWeishi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.h1(z16);
        }
    }

    public final void setSystemMeidaStore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, (Object) this, z16);
        } else {
            this.isSystemMeidaStore = z16;
        }
    }

    public final void setThumbHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.m(i3);
        }
    }

    public final void setThumbRect(@Nullable Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) rect);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.i1(rect);
        }
    }

    public final void setThumbSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this, i3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.j1(i3);
        }
    }

    public final void setThumbWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, i3);
            return;
        }
        d dVar = this.extData;
        if (dVar != null) {
            dVar.n(i3);
        }
    }

    public final void setThumbnailPath(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.k1(str);
        }
    }

    public final void setThumbnailProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Float.valueOf(f16));
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.l1(f16);
        }
    }

    public final void setVideoDuration(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) l3);
        } else {
            this.videoDuration = l3;
        }
    }

    public final void setVideoMimeType(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            iPatchRedirector.redirect((short) 156, (Object) this, (Object) str);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.m1(str);
        }
    }

    public final void setVideoReady(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.n1(z16);
        }
    }

    public final void setVideoShareToQZone(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 166)) {
            iPatchRedirector.redirect((short) 166, (Object) this, z16);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.o1(z16);
        }
    }

    public final void setVisableTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, (Object) this, j3);
            return;
        }
        c cVar = this.innerData;
        if (cVar != null) {
            cVar.p1(j3);
        }
    }

    public final void set_id(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this._id = j3;
        }
    }

    @NotNull
    public final SelectMediaInfo toSelectMediaInfo() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 173)) {
            return (SelectMediaInfo) iPatchRedirector.redirect((short) 173, (Object) this);
        }
        PageType g16 = com.tencent.qqnt.qbasealbum.ktx.b.g(this);
        String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(this);
        if (c16 == null) {
            str = "";
        } else {
            str = c16;
        }
        int i3 = this.mediaWidth;
        int i16 = this.mediaHeight;
        String str3 = this.path;
        if (str3 == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        return new SelectMediaInfo(g16, str, i3, i16, str2, null, null, 0, 0, null, null, com.tencent.qqnt.qbasealbum.ktx.b.f(this), 2016, null);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 167)) {
            return (String) iPatchRedirector.redirect((short) 167, (Object) this);
        }
        return "LocalMediaInfo{_id=" + this._id + ", path='" + this.path + "', fileSize=" + this.fileSize + ", addedDate=" + this.addedDate + ", modifiedDate=" + this.modifiedDate + ", orientation=" + getOrientation() + ", mDuration=" + com.tencent.qqnt.qbasealbum.ktx.b.f(this) + ", mChecked=" + getMChecked() + ", isSegment=" + isSegment() + ", selectStatus=" + getSelectStatus() + ", rotation=" + getRotation() + ", thumbWidth=" + getThumbWidth() + ", thumbHeight=" + getThumbHeight() + ", index=" + getIndex() + ", position=" + getPosition() + ", mMimeType='" + getMMimeType() + "', mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", mediaBitrate=" + getMediaBitrate() + ", isSystemMeidaStore=" + this.isSystemMeidaStore + ", isRegionThumbUseNewDecoder=" + isRegionThumbUseNewDecoder() + ", panoramaPhotoType=" + getPanoramaPhotoType() + ", mediaType=" + this.mMediaType + ", isVideoReady=" + isVideoReady() + ", videoInfo=" + getMaterialID() + ", materialName=" + getMaterialName() + ", filterID=" + getFilterID() + ", scheme=" + getScheme() + ", showCircleTakeSame=" + getShowCircleTakeSame() + ", missionID=" + getMissionID() + ", thumbnailProgress=" + getThumbnailProgress() + ", mediaOriginWidth=" + getMediaOriginWidth() + ", mediaOriginHeight=" + getMediaOriginHeight() + ", mediaOriginSize=" + getMediaOriginSize() + ", mediaOriginBitrate=" + getMediaOriginBitrate() + ", mOriginPath=" + this.mOriginPath + ", mKuolieId=" + getMKuolieId() + ", mKuolieCenterX=" + getMKuolieCenterX() + ", mKuolieCenterY=" + getMKuolieCenterY() + ", mKuolieRotate=" + getMKuolieRotate() + ", mKuolieWidthScale=" + getMKuolieWidthScale() + ", mKuolieHeightScale=" + getMKuolieHeightScale() + ", picPathBeforeEdit=" + this.picPathBeforeEdit + ", videoMimeType=" + getVideoMimeType() + ", isHDRVideo=" + isHDRVideo() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            iPatchRedirector.redirect((short) 170, (Object) this, (Object) dest, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this._id);
        dest.writeString(this.path);
        dest.writeLong(this.fileSize);
        dest.writeLong(this.addedDate);
        dest.writeLong(this.modifiedDate);
        dest.writeInt(getOrientation());
        dest.writeInt(getRotation());
        dest.writeLong(com.tencent.qqnt.qbasealbum.ktx.b.f(this));
        dest.writeByte(getMChecked() ? (byte) 1 : (byte) 0);
        dest.writeInt(getSelectStatus());
        dest.writeInt(getThumbWidth());
        dest.writeInt(getThumbHeight());
        dest.writeString(getThumbnailPath());
        dest.writeInt(getIndex());
        dest.writeInt(getPosition());
        dest.writeString(getMMimeType());
        dest.writeInt(this.mMediaType);
        dest.writeInt(this.mediaWidth);
        dest.writeInt(this.mediaHeight);
        dest.writeLong(getMediaBitrate());
        dest.writeInt(getMediaOriginWidth());
        dest.writeInt(getMediaOriginHeight());
        dest.writeLong(getMediaOriginSize());
        dest.writeLong(getMediaOriginBitrate());
        dest.writeByte(this.isSystemMeidaStore ? (byte) 1 : (byte) 0);
        dest.writeByte(isRegionThumbUseNewDecoder() ? (byte) 1 : (byte) 0);
        dest.writeInt(getLongitude());
        dest.writeInt(getLatitude());
        dest.writeInt(getPanoramaPhotoType());
        dest.writeLong(getMCloudPhotoOwnerUin());
        dest.writeString(getMCloudPhotoOwnerAlbumId());
        dest.writeString(getMCloudPhotoId());
        dest.writeByte(isVideoReady() ? (byte) 1 : (byte) 0);
        dest.writeString(getMaterialID());
        dest.writeString(getMaterialName());
        dest.writeString(getFilterID());
        dest.writeString(getScheme());
        dest.writeInt(getShowCircleTakeSame());
        dest.writeString(getMissionID());
        dest.writeList(getMTransferPosList());
        dest.writeList(getAiTextLabel());
        dest.writeFloat(getThumbnailProgress());
        dest.writeList(this.mOriginPath);
        dest.writeString(getMKuolieId());
        dest.writeFloat(getMKuolieCenterX());
        dest.writeFloat(getMKuolieCenterY());
        dest.writeFloat(getMKuolieRotate());
        dest.writeFloat(getMKuolieWidthScale());
        dest.writeFloat(getMKuolieHeightScale());
        dest.writeList(getMHashTagList());
        dest.writeByte(isRwa() ? (byte) 1 : (byte) 0);
        dest.writeString(this.picPathBeforeEdit);
        dest.writeString(getVideoMimeType());
        dest.writeByte(isHDRVideo() ? (byte) 1 : (byte) 0);
        dest.writeByte(isSegment() ? (byte) 1 : (byte) 0);
        dest.writeByte(isVideoShareToQZone() ? (byte) 1 : (byte) 0);
        dest.writeInt(this.extAlbumId);
        dest.writeInt(getExtIndexInSelectedMedia());
        dest.writeByte(getExtIsEdit() ? (byte) 1 : (byte) 0);
    }

    public LocalMediaInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.extData = z16 ? null : new d();
        this.innerData = f361274h ? null : new c();
        this.is0BFile = InitDataUtil.f361625a.a() ? Boolean.FALSE : null;
        this.innerMimeType = -1;
        this.isSystemMeidaStore = true;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull LocalMediaInfo other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            return ((Integer) iPatchRedirector.redirect((short) 168, (Object) this, (Object) other)).intValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        long j3 = other.modifiedDate;
        long j16 = this.modifiedDate;
        if (j3 > j16) {
            return 1;
        }
        return j3 == j16 ? 0 : -1;
    }

    public /* synthetic */ LocalMediaInfo(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
