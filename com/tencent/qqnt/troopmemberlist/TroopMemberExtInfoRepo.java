package com.tencent.qqnt.troopmemberlist;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickIconInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCacheReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberCommonCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberIllegalInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberCommonInfoFilter;
import com.tencent.qqnt.kernel.nativeinterface.MemberCommonSourceType;
import com.tencent.qqnt.kernel.nativeinterface.MemberExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberIcon;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0082\u0001\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2D\u0010\u0014\u001a@\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013H\u0002J]\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u001a2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u001aH\u0002Jm\u0010\"\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u001a2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u001aH\u0002J\u009b\u0001\u0010,\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2_\u0010\u0014\u001a[\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0012\u0018\u00010&j\u0004\u0018\u0001`+H\u0002J \u00101\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020)H\u0002J \u00104\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0002J\u001c\u00106\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u000105H\u0002Jh\u00108\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00107\u001a\u00020)2\b\u0010\n\u001a\u0004\u0018\u00010\t2D\u0010\u0014\u001a@\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013H\u0016J\u0010\u00109\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016Jl\u0010=\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2@\u0010\u0014\u001a<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`<H\u0016J\\\u0010@\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2@\u0010\u0014\u001a<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`?H\u0016J\u0086\u0001\u0010F\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010A\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\n\u001a\u0004\u0018\u00010\t2J\u0010\u0014\u001aF\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`EH\u0016Jf\u0010I\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2J\u0010\u0014\u001aF\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`HH\u0016J{\u0010J\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2_\u0010\u0014\u001a[\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0012\u0018\u00010&j\u0004\u0018\u0001`+H\u0016J{\u0010K\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2_\u0010\u0014\u001a[\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0012\u0018\u00010&j\u0004\u0018\u0001`+H\u0016JM\u0010N\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2)\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001aj\u0004\u0018\u0001`MH\u0016J\u001e\u0010O\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0016J`\u0010P\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2D\u0010\u0014\u001a@\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013H\u0016J`\u0010Q\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2D\u0010\u0014\u001a@\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013H\u0016Jn\u0010U\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2D\u0010\u0014\u001a@\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020R0\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`TH\u0016J \u0010V\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u00100\u001a\u00020)H\u0016J \u0010W\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0016JZ\u0010Y\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2>\u0010\u0014\u001a:\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u001105\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`XH\u0016J\u0012\u0010Z\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010[\u001a\u0004\u0018\u0001052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\\\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b^\u0010]R\u0014\u0010_\u001a\u00020)8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020-8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bc\u0010]R\u0014\u0010d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bd\u0010]R\u0014\u0010e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\be\u0010]R\u0014\u0010f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bf\u0010]R\u0014\u0010g\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bg\u0010]R\u0014\u0010h\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bh\u0010]R\u0014\u0010i\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bi\u0010]R\u0014\u0010k\u001a\u00020j8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bk\u0010lRa\u0010r\u001aH\u0012D\u0012B\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`E0m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR[\u0010u\u001aB\u0012>\u0012<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`\u00130m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010o\u001a\u0004\bt\u0010qRa\u0010x\u001aH\u0012D\u0012B\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`H0m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010o\u001a\u0004\bw\u0010qRv\u0010{\u001a]\u0012Y\u0012W\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b('\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00120&j\u0002`+0m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\by\u0010o\u001a\u0004\bz\u0010qR[\u0010~\u001aB\u0012>\u0012<\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020R0\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`T0m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010o\u001a\u0004\b}\u0010qRB\u0010\u0081\u0001\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00120\u001aj\u0002`M0m8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b\u007f\u0010o\u001a\u0005\b\u0080\u0001\u0010qRZ\u0010\u0084\u0001\u001a>\u0012:\u00128\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`?0m8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010o\u001a\u0005\b\u0083\u0001\u0010qRZ\u0010\u0087\u0001\u001a>\u0012:\u00128\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`<0m8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0085\u0001\u0010o\u001a\u0005\b\u0086\u0001\u0010qR\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0016\u0010\u008b\u0001\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010]R\u0016\u0010\u008c\u0001\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010]R\u0016\u0010\u008d\u0001\u001a\u00020)8\u0002X\u0082T\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010`R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R$\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002050\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001f\u0010\u0097\u0001\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0094\u0001\u0010o\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/TroopMemberExtInfoRepo;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtInfoRepoApi;", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberCommonSourceType;", "sourceType", "flag", "memberNum", "filterMethod", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberUinCallback;", "callback", "dealFetchMemberUin", "from", "Lkotlin/Function0;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonReq;", "buildReq", "Lkotlin/Function1;", "failCallback", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", "result", "successCallback", "dealCommonInfoRequest", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "dealExtInfoRequest", "needUinFlag", "needUinFlagExt", "needPrivilege", "Lkotlin/Function3;", "errMsg", "", "", "uin2flagMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberFlagCallback;", "dealCommonMemberFlagRequest", "", "groupCode", "memberUid", "titleId", "innerUpdateTroopMemberSpecialTitle", "", "honorInfo", "innerUpdateTroopMemberHonor", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "saveMemberIllegalInfo", "memberCount", "fetchTroopMemberUin", "fetchNewTroopHeadUinList", "isMember", "memberCommonListResult", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberCommonInfoCallback;", "fetchTroopMemberForBatch", "extInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberExtInfoCallback;", "fetchSelfTroopLevelInfo", "needRemarkFirst", "Landroid/os/Bundle;", "extProcessParam", "uin2NameMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNickNameCallback;", "fetchTroopMemberNickName", "uin2ShuntUpTimeMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGapInfoCallback;", "fetchTroopMemberGapInfo", "fetchTroopAdminFlagEx", "fetchCanTransferTroopMember", "memberUin", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGameInfoCallback;", "fetchTroopMemberGameInfo", "fetchTroopMemberNickIconInfo", "fetchTroopAdmin", "fetchTroopOwner", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "titleInfoList", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberSpecialTitleInfoCallback;", "fetchTroopMemberSpecialTitle", "updateTroopMemberSpecialTitle", "updateTroopMemberHonor", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberIllegalUinCallback;", "fetchTroopMemberIllegalUinList", "preloadMemberIllegalInfoFromLocal", "fetchMemberIllegalInfoFromCache", "TAG", "Ljava/lang/String;", "TROOP_HEAD_CONFIG_ID", "DEFAULT_MAX_TROOP_HEAD_REQUESTING_SIZE", "I", "DEFAULT_TROOP_HEAD_TASK_DELAY", "J", "FLAG_FETCH_ALL_MEMBER", "FLAG_FETCH_TROOP_OWNER", "FLAG_FETCH_ADMIN", "FLAG_FETCH_TARGET_MEMBER", "FLAG_FETCH_TRANSFER_MEMBER", "FLAG_FETCH_SOME_MEMBER", "FLAG_FETCH_GAG_MEMBER", "", "TROOPCARD_MAX_COUNT", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "nickNameCallbackStore$delegate", "Lkotlin/Lazy;", "getNickNameCallbackStore", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "nickNameCallbackStore", "memberUinCallbackStore$delegate", "getMemberUinCallbackStore", "memberUinCallbackStore", "gapMemberCallbackStore$delegate", "getGapMemberCallbackStore", "gapMemberCallbackStore", "adminFlagExCallback$delegate", "getAdminFlagExCallback", "adminFlagExCallback", "specialTitleCallback$delegate", "getSpecialTitleCallback", "specialTitleCallback", "gameInfoCallback$delegate", "getGameInfoCallback", "gameInfoCallback", "levelInfoCallback$delegate", "getLevelInfoCallback", "levelInfoCallback", "memberCommonCallback$delegate", "getMemberCommonCallback", "memberCommonCallback", "Lcom/tencent/qqnt/inner/b;", "troopHeadFrequencyControl", "Lcom/tencent/qqnt/inner/b;", "MMKV_KEY_ILLEGAL_MEMBER_INFO_UINS", "MMKV_KEY_ILLEGAL_MEMBER_INFO_TITLE", "ILLEGAL_MEMBER_INFO_LRU_SIZE", "", "membersCacheLockObj", "Ljava/lang/Object;", "Landroid/util/LruCache;", "illegalMemberInfoCache", "Landroid/util/LruCache;", "filterMode$delegate", "getFilterMode", "()Ljava/lang/String;", "filterMode", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberExtInfoRepo implements ITroopMemberExtInfoRepoApi {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_MAX_TROOP_HEAD_REQUESTING_SIZE = 3;
    private static final long DEFAULT_TROOP_HEAD_TASK_DELAY = 200;

    @NotNull
    private static final String FLAG_FETCH_ADMIN = "2";

    @NotNull
    private static final String FLAG_FETCH_ALL_MEMBER = "0";

    @NotNull
    private static final String FLAG_FETCH_GAG_MEMBER = "6";

    @NotNull
    private static final String FLAG_FETCH_SOME_MEMBER = "5";

    @NotNull
    private static final String FLAG_FETCH_TARGET_MEMBER = "3";

    @NotNull
    private static final String FLAG_FETCH_TRANSFER_MEMBER = "4";

    @NotNull
    private static final String FLAG_FETCH_TROOP_OWNER = "1";
    private static final int ILLEGAL_MEMBER_INFO_LRU_SIZE = 1;

    @NotNull
    public static final TroopMemberExtInfoRepo INSTANCE;

    @NotNull
    private static final String MMKV_KEY_ILLEGAL_MEMBER_INFO_TITLE = "TROOP_ILLEGAL_MEMBER_INFO_TITLE";

    @NotNull
    private static final String MMKV_KEY_ILLEGAL_MEMBER_INFO_UINS = "TROOP_ILLEGAL_MEMBER_INFO_UINS";

    @NotNull
    private static final String TAG = "TroopMemberExtInfoRepo";
    private static final short TROOPCARD_MAX_COUNT = 500;

    @NotNull
    private static final String TROOP_HEAD_CONFIG_ID = "102488";

    /* renamed from: adminFlagExCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy adminFlagExCallback;

    /* renamed from: filterMode$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy filterMode;

    /* renamed from: gameInfoCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy gameInfoCallback;

    /* renamed from: gapMemberCallbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy gapMemberCallbackStore;

    @NotNull
    private static final LruCache<String, GroupMemberIllegalInfoResult> illegalMemberInfoCache;

    /* renamed from: levelInfoCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy levelInfoCallback;

    /* renamed from: memberCommonCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy memberCommonCallback;

    /* renamed from: memberUinCallbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy memberUinCallbackStore;

    @NotNull
    private static final Object membersCacheLockObj;

    /* renamed from: nickNameCallbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy nickNameCallbackStore;

    /* renamed from: specialTitleCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy specialTitleCallback;

    @NotNull
    private static final com.tencent.qqnt.inner.b troopHeadFrequencyControl;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        INSTANCE = new TroopMemberExtInfoRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$nickNameCallbackStore$2.INSTANCE);
        nickNameCallbackStore = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$memberUinCallbackStore$2.INSTANCE);
        memberUinCallbackStore = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$gapMemberCallbackStore$2.INSTANCE);
        gapMemberCallbackStore = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$adminFlagExCallback$2.INSTANCE);
        adminFlagExCallback = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$specialTitleCallback$2.INSTANCE);
        specialTitleCallback = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$gameInfoCallback$2.INSTANCE);
        gameInfoCallback = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$levelInfoCallback$2.INSTANCE);
        levelInfoCallback = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$memberCommonCallback$2.INSTANCE);
        memberCommonCallback = lazy8;
        troopHeadFrequencyControl = new com.tencent.qqnt.inner.b("fetchNewTroopHeadUinList", TROOP_HEAD_CONFIG_ID, 3, DEFAULT_TROOP_HEAD_TASK_DELAY);
        membersCacheLockObj = new Object();
        illegalMemberInfoCache = new LruCache<>(1);
        lazy9 = LazyKt__LazyJVMKt.lazy(TroopMemberExtInfoRepo$filterMode$2.INSTANCE);
        filterMode = lazy9;
    }

    TroopMemberExtInfoRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void dealCommonInfoRequest(final String from, final String troopUin, Function0<GroupMemberCommonReq> buildReq, final Function1<? super String, Unit> failCallback, final Function1<? super GroupMemberCommonListResult, Unit> successCallback) {
        Long longOrNull;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dealCommonInfoRequest start: troopUin: " + troopUin + ", from=" + from);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull == null) {
            QLog.e(TAG, 2, "dealCommonInfoRequest: from=" + from + ", troop code null, troopCode=" + troopUin);
            failCallback.invoke("");
            return;
        }
        GroupMemberCommonReq invoke = buildReq.invoke();
        invoke.groupCode = longOrNull.longValue();
        final com.tencent.qqnt.report.h hVar = new com.tencent.qqnt.report.h(from);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberCommonInfo", troopUin, "TroopMemberExtInfoRepo-dealCommonInfoRequest-" + from, false, false, 24, null);
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.getMemberCommonInfo(invoke, new IGroupMemberCommonCallback() { // from class: com.tencent.qqnt.troopmemberlist.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberCommonCallback
                public final void onResult(int i3, String str, GroupMemberCommonListResult groupMemberCommonListResult) {
                    TroopMemberExtInfoRepo.dealCommonInfoRequest$lambda$1(com.tencent.qqnt.report.h.this, mVar, troopUin, from, successCallback, failCallback, i3, str, groupMemberCommonListResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealCommonInfoRequest$lambda$1(final com.tencent.qqnt.report.h report, com.tencent.qqnt.report.m cmdReport, String troopUin, String from, final Function1 successCallback, final Function1 failCallback, final int i3, final String str, final GroupMemberCommonListResult groupMemberCommonListResult) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        report.j(null, Integer.valueOf(i3), str);
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dealCommonInfoRequest: troopUin: " + troopUin + ", from=" + from + ", errorCode=" + i3 + ", errMsg=" + str + ", groupMemberList=" + groupMemberCommonListResult.memberList.size());
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.u
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberExtInfoRepo.dealCommonInfoRequest$lambda$1$lambda$0(com.tencent.qqnt.report.h.this, i3, successCallback, groupMemberCommonListResult, failCallback, str);
            }
        });
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealCommonInfoRequest$lambda$1$lambda$0(com.tencent.qqnt.report.h report, int i3, Function1 successCallback, GroupMemberCommonListResult groupMemberCommonList, Function1 failCallback, String errMsg) {
        boolean z16;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        report.b();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(groupMemberCommonList, "groupMemberCommonList");
            successCallback.invoke(groupMemberCommonList);
        } else {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            failCallback.invoke(errMsg);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void dealCommonMemberFlagRequest(String troopUin, final String flag, final boolean needUinFlag, final boolean needUinFlagExt, final boolean needPrivilege, LifecycleOwner owner, Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback) {
        final int h16 = getAdminFlagExCallback().h(owner, callback);
        dealCommonInfoRequest("dealCommonMemberFlagRequest[" + flag + "]", troopUin, new Function0<GroupMemberCommonReq>(flag, needUinFlagExt, needUinFlag, needPrivilege) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealCommonMemberFlagRequest$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $flag;
            final /* synthetic */ boolean $needPrivilege;
            final /* synthetic */ boolean $needUinFlag;
            final /* synthetic */ boolean $needUinFlagExt;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$flag = flag;
                this.$needUinFlagExt = needUinFlagExt;
                this.$needUinFlag = needUinFlag;
                this.$needPrivilege = needPrivilege;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, flag, Boolean.valueOf(needUinFlagExt), Boolean.valueOf(needUinFlag), Boolean.valueOf(needPrivilege));
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GroupMemberCommonReq invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (GroupMemberCommonReq) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                GroupMemberCommonReq groupMemberCommonReq = new GroupMemberCommonReq();
                String str = this.$flag;
                boolean z16 = this.$needUinFlagExt;
                boolean z17 = this.$needUinFlag;
                boolean z18 = this.$needPrivilege;
                groupMemberCommonReq.sourceType = MemberCommonSourceType.DEFAULTTYPE.ordinal();
                groupMemberCommonReq.identifyFlag = str;
                MemberCommonInfoFilter memberCommonInfoFilter = new MemberCommonInfoFilter();
                memberCommonInfoFilter.memberUin = 1;
                memberCommonInfoFilter.uinFlagExt = z16 ? 1 : 0;
                memberCommonInfoFilter.uinFlag = z17 ? 1 : 0;
                memberCommonInfoFilter.privilege = z18 ? 1 : 0;
                groupMemberCommonReq.memberCommonFilter = memberCommonInfoFilter;
                return groupMemberCommonReq;
            }
        }, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealCommonMemberFlagRequest$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback adminFlagExCallback2;
                Map emptyMap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                adminFlagExCallback2 = TroopMemberExtInfoRepo.INSTANCE.getAdminFlagExCallback();
                Function3 function3 = (Function3) adminFlagExCallback2.f(this.$callbackId);
                if (function3 != null) {
                    Boolean bool = Boolean.FALSE;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    function3.invoke(bool, it, emptyMap);
                }
            }
        }, new Function1<GroupMemberCommonListResult, Unit>(needUinFlag, h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealCommonMemberFlagRequest$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;
            final /* synthetic */ boolean $needUinFlag;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$needUinFlag = needUinFlag;
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(needUinFlag), Integer.valueOf(h16));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberCommonListResult groupMemberCommonListResult) {
                invoke2(groupMemberCommonListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberCommonListResult groupMemberCommonList) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                LinkedHashMap linkedHashMap;
                TroopLifecycleCallback adminFlagExCallback2;
                int collectionSizeOrDefault2;
                int mapCapacity2;
                int coerceAtLeast2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupMemberCommonList);
                    return;
                }
                Intrinsics.checkNotNullParameter(groupMemberCommonList, "groupMemberCommonList");
                if (this.$needUinFlag) {
                    ArrayList<MemberCommonInfo> arrayList = groupMemberCommonList.memberList;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "groupMemberCommonList.memberList");
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
                    linkedHashMap = new LinkedHashMap(coerceAtLeast2);
                    for (MemberCommonInfo memberCommonInfo : arrayList) {
                        Pair pair = new Pair(String.valueOf(memberCommonInfo.memberUin), Integer.valueOf(memberCommonInfo.uinFlag));
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    }
                } else {
                    ArrayList<MemberCommonInfo> arrayList2 = groupMemberCommonList.memberList;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "groupMemberCommonList.memberList");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                    linkedHashMap = new LinkedHashMap(coerceAtLeast);
                    for (MemberCommonInfo memberCommonInfo2 : arrayList2) {
                        Pair pair2 = new Pair(String.valueOf(memberCommonInfo2.memberUin), Integer.valueOf(memberCommonInfo2.uinFlagExt));
                        linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
                    }
                }
                adminFlagExCallback2 = TroopMemberExtInfoRepo.INSTANCE.getAdminFlagExCallback();
                Function3 function3 = (Function3) adminFlagExCallback2.f(this.$callbackId);
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, "", linkedHashMap);
                }
            }
        });
    }

    private final void dealExtInfoRequest(final String from, final String troopUin, List<String> uinList, Function0<GroupMemberExtReq> buildReq, final Function1<? super String, Unit> failCallback, final Function1<? super GroupMemberExtListResult, Unit> successCallback) {
        Long longOrNull;
        Long longOrNull2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dealExtInfoRequest start: troopUin: " + troopUin + ", from=" + from);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull == null) {
            QLog.e(TAG, 2, "dealExtInfoRequest: from=" + from + ", troop code null, troopCode=" + troopUin);
            failCallback.invoke("");
            return;
        }
        GroupMemberExtReq invoke = buildReq.invoke();
        boolean z16 = false;
        if (uinList != null && (!uinList.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<T> it = uinList.iterator();
            while (it.hasNext()) {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull2 != null) {
                    arrayList.add(Long.valueOf(longOrNull2.longValue()));
                }
            }
            invoke.uinList = arrayList;
        }
        invoke.groupCode = longOrNull.longValue();
        invoke.memberExtFilter.memberLevelInfoUin = 1;
        final com.tencent.qqnt.report.g gVar = new com.tencent.qqnt.report.g(from);
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getMemberExtInfo", troopUin, "TroopMemberExtInfoRepo-dealExtInfoRequest-" + from, false, false, 24, null);
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.getMemberExtInfo(invoke, new IGroupMemberExtCallback() { // from class: com.tencent.qqnt.troopmemberlist.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberExtCallback
                public final void onResult(int i3, String str, GroupMemberExtListResult groupMemberExtListResult) {
                    TroopMemberExtInfoRepo.dealExtInfoRequest$lambda$5(com.tencent.qqnt.report.g.this, mVar, troopUin, from, successCallback, failCallback, i3, str, groupMemberExtListResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealExtInfoRequest$lambda$5(final com.tencent.qqnt.report.g report, com.tencent.qqnt.report.m cmdReport, String troopUin, String from, final Function1 successCallback, final Function1 failCallback, final int i3, final String str, final GroupMemberExtListResult groupMemberExtListResult) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(cmdReport, "$cmdReport");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        report.j(null, Integer.valueOf(i3), str);
        cmdReport.f();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dealExtInfoRequest: troopUin: " + troopUin + ", from=" + from + ", errorCode=" + i3 + ", errMsg=" + str + ", groupMemberList=" + com.tencent.mobileqq.troop.utils.ai.f302012a.b(groupMemberExtListResult));
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.q
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberExtInfoRepo.dealExtInfoRequest$lambda$5$lambda$4(com.tencent.qqnt.report.g.this, i3, successCallback, groupMemberExtListResult, failCallback, str);
            }
        });
        com.tencent.qqnt.report.m.c(cmdReport, Integer.valueOf(i3), null, str, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealExtInfoRequest$lambda$5$lambda$4(com.tencent.qqnt.report.g report, int i3, Function1 successCallback, GroupMemberExtListResult result, Function1 failCallback, String errMsg) {
        boolean z16;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(successCallback, "$successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "$failCallback");
        report.b();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            successCallback.invoke(result);
        } else {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            failCallback.invoke(errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void dealFetchMemberUin(String troopUin, final MemberCommonSourceType sourceType, final String flag, final String memberNum, final String filterMethod, LifecycleOwner owner, Function2<? super Boolean, ? super List<String>, Unit> callback) {
        final int h16 = getMemberUinCallbackStore().h(owner, callback);
        dealCommonInfoRequest("dealFetchMemberUin" + flag, troopUin, new Function0<GroupMemberCommonReq>(flag, memberNum, filterMethod) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealFetchMemberUin$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $filterMethod;
            final /* synthetic */ String $flag;
            final /* synthetic */ String $memberNum;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$flag = flag;
                this.$memberNum = memberNum;
                this.$filterMethod = filterMethod;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MemberCommonSourceType.this, flag, memberNum, filterMethod);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GroupMemberCommonReq invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (GroupMemberCommonReq) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                GroupMemberCommonReq groupMemberCommonReq = new GroupMemberCommonReq();
                MemberCommonSourceType memberCommonSourceType = MemberCommonSourceType.this;
                String str = this.$flag;
                String str2 = this.$memberNum;
                String str3 = this.$filterMethod;
                groupMemberCommonReq.sourceType = memberCommonSourceType.ordinal();
                groupMemberCommonReq.startUin = "0";
                groupMemberCommonReq.identifyFlag = str;
                groupMemberCommonReq.memberNum = str2;
                groupMemberCommonReq.filterMethod = str3;
                MemberCommonInfoFilter memberCommonInfoFilter = new MemberCommonInfoFilter();
                memberCommonInfoFilter.memberUin = 1;
                memberCommonInfoFilter.privilege = 1;
                groupMemberCommonReq.memberCommonFilter = memberCommonInfoFilter;
                return groupMemberCommonReq;
            }
        }, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealFetchMemberUin$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback memberUinCallbackStore2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                memberUinCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getMemberUinCallbackStore();
                Function2 function2 = (Function2) memberUinCallbackStore2.f(this.$callbackId);
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE, new ArrayList());
                }
            }
        }, new Function1<GroupMemberCommonListResult, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$dealFetchMemberUin$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberCommonListResult groupMemberCommonListResult) {
                invoke2(groupMemberCommonListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberCommonListResult groupMemberCommonList) {
                int collectionSizeOrDefault;
                TroopLifecycleCallback memberUinCallbackStore2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupMemberCommonList);
                    return;
                }
                Intrinsics.checkNotNullParameter(groupMemberCommonList, "groupMemberCommonList");
                ArrayList<MemberCommonInfo> arrayList = groupMemberCommonList.memberList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "groupMemberCommonList.memberList");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(String.valueOf(((MemberCommonInfo) it.next()).memberUin));
                }
                memberUinCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getMemberUinCallbackStore();
                Function2 function2 = (Function2) memberUinCallbackStore2.f(this.$callbackId);
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE, arrayList2);
                }
            }
        });
    }

    static /* synthetic */ void dealFetchMemberUin$default(TroopMemberExtInfoRepo troopMemberExtInfoRepo, String str, MemberCommonSourceType memberCommonSourceType, String str2, String str3, String str4, LifecycleOwner lifecycleOwner, Function2 function2, int i3, Object obj) {
        MemberCommonSourceType memberCommonSourceType2;
        if ((i3 & 2) != 0) {
            memberCommonSourceType2 = MemberCommonSourceType.DEFAULTTYPE;
        } else {
            memberCommonSourceType2 = memberCommonSourceType;
        }
        troopMemberExtInfoRepo.dealFetchMemberUin(str, memberCommonSourceType2, str2, str3, str4, lifecycleOwner, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberIllegalUinList$lambda$8(String troopUin, Function2 function2, int i3, String str, GroupMemberIllegalInfoResult illegalInfo) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        boolean z16 = true;
        QLog.d(TAG, 1, "fetchTroopMemberIllegalUinList <= rsp  troopUin: " + troopUin + ", errorCode=" + i3 + ", errMsg=" + str + ", illegalInfo=" + illegalInfo);
        INSTANCE.saveMemberIllegalInfo(troopUin, illegalInfo);
        if (function2 != null) {
            if (i3 != 0) {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            Intrinsics.checkNotNullExpressionValue(illegalInfo, "illegalInfo");
            function2.invoke(valueOf, illegalInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function3<Boolean, String, Map<String, Integer>, Unit>> getAdminFlagExCallback() {
        return (TroopLifecycleCallback) adminFlagExCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFilterMode() {
        return (String) filterMode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function1<Boolean, Unit>> getGameInfoCallback() {
        return (TroopLifecycleCallback) gameInfoCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, Map<String, Long>, Unit>> getGapMemberCallbackStore() {
        return (TroopLifecycleCallback) gapMemberCallbackStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, GroupMemberExtListResult, Unit>> getLevelInfoCallback() {
        return (TroopLifecycleCallback) levelInfoCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, GroupMemberCommonListResult, Unit>> getMemberCommonCallback() {
        return (TroopLifecycleCallback) memberCommonCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, List<String>, Unit>> getMemberUinCallbackStore() {
        return (TroopLifecycleCallback) memberUinCallbackStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, Map<String, String>, Unit>> getNickNameCallbackStore() {
        return (TroopLifecycleCallback) nickNameCallbackStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, List<TroopMemberSpecialTitleInfo>, Unit>> getSpecialTitleCallback() {
        return (TroopLifecycleCallback) specialTitleCallback.getValue();
    }

    private final void innerUpdateTroopMemberHonor(long groupCode, String memberUid, byte[] honorInfo) {
        GroupMemberCacheReq groupMemberCacheReq = new GroupMemberCacheReq();
        groupMemberCacheReq.groupCode = groupCode;
        groupMemberCacheReq.uid = memberUid;
        groupMemberCacheReq.memberCacheFilter.honorInfo = 1;
        groupMemberCacheReq.memberCache.honorInfo = honorInfo;
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.updateMemberInfoByMqq(groupMemberCacheReq);
        }
    }

    private final void innerUpdateTroopMemberSpecialTitle(long groupCode, String memberUid, int titleId) {
        GroupMemberCacheReq groupMemberCacheReq = new GroupMemberCacheReq();
        groupMemberCacheReq.groupCode = groupCode;
        groupMemberCacheReq.uid = memberUid;
        groupMemberCacheReq.memberCacheFilter.titleId = 1;
        groupMemberCacheReq.memberCache.titleId = titleId;
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.updateMemberInfoByMqq(groupMemberCacheReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadMemberIllegalInfoFromLocal$lambda$11(String str) {
        List split$default;
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String n3 = com.tencent.mobileqq.troop.config.a.n(aVar, "TROOP_ILLEGAL_MEMBER_INFO_UINS_" + str, "", false, 4, null);
        split$default = StringsKt__StringsKt.split$default((CharSequence) com.tencent.mobileqq.troop.config.a.n(aVar, "TROOP_ILLEGAL_MEMBER_INFO_TITLE_" + str, "", false, 4, null), new String[]{","}, false, 0, 6, (Object) null);
        if (!TextUtils.isEmpty(n3) && !split$default.isEmpty()) {
            synchronized (membersCacheLockObj) {
                LruCache<String, GroupMemberIllegalInfoResult> lruCache = illegalMemberInfoCache;
                GroupMemberIllegalInfoResult groupMemberIllegalInfoResult = new GroupMemberIllegalInfoResult();
                groupMemberIllegalInfoResult.subGroupTitle = n3;
                Iterator it = split$default.iterator();
                while (it.hasNext()) {
                    try {
                        groupMemberIllegalInfoResult.uinList.add(Long.valueOf(Long.parseLong((String) it.next())));
                    } catch (NumberFormatException e16) {
                        QLog.e(TAG, 1, "[preloadMemberIllegalInfoFromLocal] exception", e16);
                    }
                }
                Unit unit = Unit.INSTANCE;
                lruCache.put(str, groupMemberIllegalInfoResult);
            }
        }
    }

    private final void saveMemberIllegalInfo(final String troopUin, final GroupMemberIllegalInfoResult result) {
        synchronized (membersCacheLockObj) {
            if (result == null) {
                illegalMemberInfoCache.remove(troopUin);
            } else {
                illegalMemberInfoCache.put(troopUin, result);
            }
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.s
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberExtInfoRepo.saveMemberIllegalInfo$lambda$14(troopUin, result);
            }
        });
    }

    static /* synthetic */ void saveMemberIllegalInfo$default(TroopMemberExtInfoRepo troopMemberExtInfoRepo, String str, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            groupMemberIllegalInfoResult = null;
        }
        troopMemberExtInfoRepo.saveMemberIllegalInfo(str, groupMemberIllegalInfoResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r4 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void saveMemberIllegalInfo$lambda$14(String troopUin, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
        ArrayList<Long> arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        String str = "TROOP_ILLEGAL_MEMBER_INFO_UINS_" + troopUin;
        new ObjectOutputStream(new ByteArrayOutputStream());
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        if (com.tencent.mobileqq.troop.config.a.b(aVar, str, false, 2, null)) {
            if (groupMemberIllegalInfoResult != null) {
                arrayList = groupMemberIllegalInfoResult.getUinList();
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                ArrayList<Long> uinList = groupMemberIllegalInfoResult.getUinList();
                if (uinList != null && !uinList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
            }
            com.tencent.mobileqq.troop.config.a.p(aVar, str, false, 2, null);
            return;
        }
        com.tencent.mobileqq.troop.config.a.z(aVar, str, String.valueOf(groupMemberIllegalInfoResult), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTroopMemberHonor$lambda$7(long j3, byte[] honorInfo, String memberUid) {
        Intrinsics.checkNotNullParameter(honorInfo, "$honorInfo");
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(memberUid, "memberUid");
        troopMemberExtInfoRepo.innerUpdateTroopMemberHonor(j3, memberUid, honorInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTroopMemberSpecialTitle$lambda$6(long j3, int i3, String memberUid) {
        TroopMemberExtInfoRepo troopMemberExtInfoRepo = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(memberUid, "memberUid");
        troopMemberExtInfoRepo.innerUpdateTroopMemberSpecialTitle(j3, memberUid, i3);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchCanTransferTroopMember(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            dealCommonMemberFlagRequest(troopUin, "4", true, false, false, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    @Nullable
    public GroupMemberIllegalInfoResult fetchMemberIllegalInfoFromCache(@NotNull String troopUin) {
        GroupMemberIllegalInfoResult groupMemberIllegalInfoResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (GroupMemberIllegalInfoResult) iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        synchronized (membersCacheLockObj) {
            groupMemberIllegalInfoResult = illegalMemberInfoCache.get(troopUin);
        }
        return groupMemberIllegalInfoResult;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchNewTroopHeadUinList(@NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            troopHeadFrequencyControl.d(troopUin, new Function0<Unit>(troopUin) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchNewTroopHeadUinList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String filterMode2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopMemberExtInfoRepo troopMemberExtInfoRepo = TroopMemberExtInfoRepo.INSTANCE;
                    String str = this.$troopUin;
                    MemberCommonSourceType memberCommonSourceType = MemberCommonSourceType.NEWGROUPTYPE;
                    filterMode2 = troopMemberExtInfoRepo.getFilterMode();
                    troopMemberExtInfoRepo.dealFetchMemberUin(str, memberCommonSourceType, "5", "9", filterMode2, null, new Function2<Boolean, List<? extends String>, Unit>(this.$troopUin) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchNewTroopHeadUinList$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String $troopUin;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$troopUin = r4;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) r4);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                            invoke(bool.booleanValue(), (List<String>) list);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, @NotNull List<String> uinList) {
                            com.tencent.qqnt.inner.b bVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(uinList, "uinList");
                            AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                            if (a16 != null) {
                                String str2 = this.$troopUin;
                                if (z16) {
                                    IRuntimeService runtimeService = a16.getRuntimeService(ITroopInfoService.class, "");
                                    Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
                                    TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(str2);
                                    if (findTroopInfo == null) {
                                        findTroopInfo = new TroopInfo(str2);
                                    }
                                    com.tencent.mobileqq.troop.api.config.af.c(a16, findTroopInfo, new ArrayList(uinList));
                                } else {
                                    QLog.e("TroopMemberExtInfoRepo", 2, "fetchNewTroopHeadUinList: troopUin=" + str2 + ", failed");
                                }
                                bVar = TroopMemberExtInfoRepo.troopHeadFrequencyControl;
                                bVar.e(str2);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchSelfTroopLevelInfo(@NotNull final String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberExtListResult, Unit> callback) {
        String str;
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime f16 = bg.f();
        if (f16 != null) {
            str = f16.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            if (callback != 0) {
                callback.invoke(Boolean.FALSE, null);
            }
        } else {
            final int h16 = getLevelInfoCallback().h(owner, callback);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            dealExtInfoRequest("fetchSelfTroopLevelInfo", troopUin, arrayListOf, TroopMemberExtInfoRepo$fetchSelfTroopLevelInfo$1.INSTANCE, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchSelfTroopLevelInfo$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $id;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$id = h16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    TroopLifecycleCallback levelInfoCallback2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    levelInfoCallback2 = TroopMemberExtInfoRepo.INSTANCE.getLevelInfoCallback();
                    Function2 function2 = (Function2) levelInfoCallback2.f(this.$id);
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE, null);
                    }
                }
            }, new Function1<GroupMemberExtListResult, Unit>(troopUin, h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchSelfTroopLevelInfo$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $id;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$troopUin = troopUin;
                    this.$id = h16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, h16);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GroupMemberExtListResult groupMemberExtListResult) {
                    invoke2(groupMemberExtListResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GroupMemberExtListResult result) {
                    TroopLifecycleCallback levelInfoCallback2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberExtInfoRepo", 2, "fetchSelfTroopLevelInfo: troopUin=" + this.$troopUin + ", sysFlag=" + result.sysShowFlag + ", userFlag=" + result.userShowFlag + ", userFlagNew=" + result.userShowFlagNew);
                    }
                    levelInfoCallback2 = TroopMemberExtInfoRepo.INSTANCE.getLevelInfoCallback();
                    Function2 function2 = (Function2) levelInfoCallback2.f(this.$id);
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, result);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopAdmin(@NotNull final String troopUin, @Nullable LifecycleOwner owner, @Nullable final Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            dealFetchMemberUin(troopUin, MemberCommonSourceType.PUSHTYPE, "2", "", "", owner, new Function2<Boolean, List<? extends String>, Unit>(troopUin, callback) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopAdmin$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, List<String>, Unit> $callback;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                    this.$troopUin = troopUin;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                    invoke(bool.booleanValue(), (List<String>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull List<String> uinList) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(uinList, "uinList");
                    if (z16 && (!uinList.isEmpty())) {
                        AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                        ITroopInfoService iTroopInfoService = a16 != null ? (ITroopInfoService) a16.getRuntimeService(ITroopInfoService.class, "") : null;
                        TroopInfo findTroopInfo = iTroopInfoService != null ? iTroopInfoService.findTroopInfo(this.$troopUin) : null;
                        if (findTroopInfo != null) {
                            StringBuilder sb5 = new StringBuilder();
                            Iterator<String> it = uinList.iterator();
                            while (it.hasNext()) {
                                sb5.append(it.next());
                                sb5.append("|");
                            }
                            findTroopInfo.Administrator = sb5.toString();
                        }
                    }
                    Function2<Boolean, List<String>, Unit> function2 = this.$callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(z16), uinList);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopAdminFlagEx(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            dealCommonMemberFlagRequest(troopUin, "2", false, true, true, owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberForBatch(@NotNull String troopUin, final boolean isMember, @NotNull final String flag, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberCommonListResult, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, Boolean.valueOf(isMember), flag, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(flag, "flag");
        final int h16 = getMemberCommonCallback().h(owner, callback);
        dealCommonInfoRequest("fetchTroopMemberForBatch" + flag, troopUin, new Function0<GroupMemberCommonReq>(isMember, flag) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberForBatch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $flag;
            final /* synthetic */ boolean $isMember;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$isMember = isMember;
                this.$flag = flag;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(isMember), flag);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GroupMemberCommonReq invoke() {
                int ordinal;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GroupMemberCommonReq) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                GroupMemberCommonReq groupMemberCommonReq = new GroupMemberCommonReq();
                boolean z16 = this.$isMember;
                String str = this.$flag;
                if (z16) {
                    ordinal = MemberCommonSourceType.DEFAULTTYPE.ordinal();
                } else {
                    ordinal = MemberCommonSourceType.PUSHTYPE.ordinal();
                }
                groupMemberCommonReq.sourceType = ordinal;
                groupMemberCommonReq.memberNum = "24";
                groupMemberCommonReq.filterMethod = "2";
                groupMemberCommonReq.startUin = "0";
                groupMemberCommonReq.identifyFlag = str;
                MemberCommonInfoFilter memberCommonInfoFilter = new MemberCommonInfoFilter();
                memberCommonInfoFilter.memberUin = 1;
                memberCommonInfoFilter.uinFlagExt = 64;
                groupMemberCommonReq.memberCommonFilter = memberCommonInfoFilter;
                return groupMemberCommonReq;
            }
        }, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberForBatch$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback memberCommonCallback2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                memberCommonCallback2 = TroopMemberExtInfoRepo.INSTANCE.getMemberCommonCallback();
                Function2 function2 = (Function2) memberCommonCallback2.f(this.$callbackId);
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE, null);
                }
            }
        }, new Function1<GroupMemberCommonListResult, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberForBatch$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberCommonListResult groupMemberCommonListResult) {
                invoke2(groupMemberCommonListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberCommonListResult groupMemberCommonList) {
                TroopLifecycleCallback memberCommonCallback2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) groupMemberCommonList);
                    return;
                }
                Intrinsics.checkNotNullParameter(groupMemberCommonList, "groupMemberCommonList");
                memberCommonCallback2 = TroopMemberExtInfoRepo.INSTANCE.getMemberCommonCallback();
                Function2 function2 = (Function2) memberCommonCallback2.f(this.$callbackId);
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE, groupMemberCommonList);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberGameInfo(@NotNull final String troopUin, @NotNull String memberUin, @Nullable LifecycleOwner owner, @Nullable Function1<? super Boolean, Unit> callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, memberUin, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        final int h16 = getGameInfoCallback().h(owner, callback);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(memberUin);
        dealExtInfoRequest("fetchTroopMemberGameInfo", troopUin, listOf, TroopMemberExtInfoRepo$fetchTroopMemberGameInfo$1.INSTANCE, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberGameInfo$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback gameInfoCallback2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                gameInfoCallback2 = TroopMemberExtInfoRepo.INSTANCE.getGameInfoCallback();
                Function1 function1 = (Function1) gameInfoCallback2.f(this.$callbackId);
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        }, new Function1<GroupMemberExtListResult, Unit>(troopUin, h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberGameInfo$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopUin = troopUin;
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberExtListResult groupMemberExtListResult) {
                invoke2(groupMemberExtListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberExtListResult result) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                TroopLifecycleCallback gameInfoCallback2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                ArrayList<MemberExtInfo> arrayList = result.memberLevelInfo;
                Intrinsics.checkNotNullExpressionValue(arrayList, "result.memberLevelInfo");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = new Pair(String.valueOf(((MemberExtInfo) it.next()).uin), Long.valueOf(r0.cmdUinFlagExt3Grocery));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateTroopMemberFlagEx3(this.$troopUin, linkedHashMap, "TroopMemberExtInfoRepo");
                gameInfoCallback2 = TroopMemberExtInfoRepo.INSTANCE.getGameInfoCallback();
                Function1 function1 = (Function1) gameInfoCallback2.f(this.$callbackId);
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberGapInfo(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, Long>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        final int h16 = getGapMemberCallbackStore().h(owner, callback);
        dealCommonInfoRequest("fetchTroopMemberGapInfo", troopUin, TroopMemberExtInfoRepo$fetchTroopMemberGapInfo$1.INSTANCE, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberGapInfo$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback gapMemberCallbackStore2;
                Map emptyMap;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                gapMemberCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getGapMemberCallbackStore();
                Function2 function2 = (Function2) gapMemberCallbackStore2.f(this.$callbackId);
                if (function2 != null) {
                    Boolean bool = Boolean.FALSE;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    function2.invoke(bool, emptyMap);
                }
            }
        }, new Function1<GroupMemberCommonListResult, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberGapInfo$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberCommonListResult groupMemberCommonListResult) {
                invoke2(groupMemberCommonListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberCommonListResult groupMemberCommonList) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                TroopLifecycleCallback gapMemberCallbackStore2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) groupMemberCommonList);
                    return;
                }
                Intrinsics.checkNotNullParameter(groupMemberCommonList, "groupMemberCommonList");
                ArrayList<MemberCommonInfo> arrayList = groupMemberCommonList.memberList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "groupMemberCommonList.memberList");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = new Pair(String.valueOf(((MemberCommonInfo) it.next()).memberUin), Long.valueOf(r0.shutUpTime));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                gapMemberCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getGapMemberCallbackStore();
                Function2 function2 = (Function2) gapMemberCallbackStore2.f(this.$callbackId);
                if (function2 != null) {
                    function2.invoke(Boolean.TRUE, linkedHashMap);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberIllegalUinList(@NotNull final String troopUin, @Nullable LifecycleOwner owner, @Nullable final Function2<? super Boolean, ? super GroupMemberIllegalInfoResult, Unit> callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QLog.d(TAG, 1, "fetchTroopMemberIllegalUinList => req  troopUin=" + troopUin);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
            if (b16 != null) {
                b16.getIllegalMemberList(longValue, new IGroupMemberIllegalInfoCallback() { // from class: com.tencent.qqnt.troopmemberlist.p
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberIllegalInfoCallback
                    public final void onResult(int i3, String str, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
                        TroopMemberExtInfoRepo.fetchTroopMemberIllegalUinList$lambda$8(troopUin, callback, i3, str, groupMemberIllegalInfoResult);
                    }
                });
            }
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberNickIconInfo(@NotNull final String troopUin, @NotNull final List<String> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin, (Object) uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        dealExtInfoRequest("fetchTroopMemberNickIconInfo", troopUin, uinList, TroopMemberExtInfoRepo$fetchTroopMemberNickIconInfo$1.INSTANCE, TroopMemberExtInfoRepo$fetchTroopMemberNickIconInfo$2.INSTANCE, new Function1<GroupMemberExtListResult, Unit>(troopUin, uinList) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberNickIconInfo$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $troopUin;
            final /* synthetic */ List<String> $uinList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopUin = troopUin;
                this.$uinList = uinList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) uinList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberExtListResult groupMemberExtListResult) {
                invoke2(groupMemberExtListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberExtListResult result) {
                ITroopInfoService iTroopInfoService;
                TroopInfo findTroopInfo;
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                int collectionSizeOrDefault2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                if (a16 == null || (iTroopInfoService = (ITroopInfoService) a16.getRuntimeService(ITroopInfoService.class, "")) == null || (findTroopInfo = iTroopInfoService.findTroopInfo(this.$troopUin)) == null) {
                    return;
                }
                boolean isEmpty = this.$uinList.isEmpty();
                long j3 = findTroopInfo.extDBInfo.oldMemberNickIconSeq;
                if (j3 < result.memberInfoSeq || j3 <= 0) {
                    ArrayList<MemberExtInfo> arrayList = result.memberLevelInfo;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "result.memberLevelInfo");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                    for (MemberExtInfo memberExtInfo : arrayList) {
                        ArrayList<MemberIcon> arrayList2 = memberExtInfo.memberIconList;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "memberExtInfo.memberIconList");
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                        for (MemberIcon memberIcon : arrayList2) {
                            arrayList3.add(new TroopMemberNickIconInfo(memberIcon.resId, memberIcon.expireTime, memberIcon.bizId));
                        }
                        Pair pair = new Pair(String.valueOf(memberExtInfo.uin), com.tencent.mobileqq.troop.troopapps.g.h(new ArrayList(arrayList3)));
                        linkedHashMap.put(pair.getFirst(), pair.getSecond());
                    }
                    ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateTroopMemberNickIconInfo(this.$troopUin, linkedHashMap, "fetchTroopMemberNickIconInfo");
                }
                TroopExtDBInfo troopExtDBInfo = findTroopInfo.extDBInfo;
                boolean z16 = troopExtDBInfo.oldMemberNickIconSeq != findTroopInfo.mMemberNickIconSeq;
                if (isEmpty || !z16) {
                    long j16 = result.memberInfoSeq;
                    String str = this.$troopUin;
                    troopExtDBInfo.oldMemberNickIconSeq = j16;
                    ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateOldMemberNickIconSeq(str, j16, "TroopMemberExtInfoRepo");
                    findTroopInfo.mMemberNickIconSeq = result.memberInfoSeq;
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberNickName(@NotNull final String troopUin, @NotNull List<String> uinList, final boolean needRemarkFirst, @Nullable final Bundle extProcessParam, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        Map emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, uinList, Boolean.valueOf(needRemarkFirst), extProcessParam, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (uinList.size() > 500) {
            QLog.e(TAG, 2, "fetchTroopMemberNickName: over size, troopCode=" + troopUin);
            if (callback != 0) {
                Boolean bool = Boolean.FALSE;
                emptyMap = MapsKt__MapsKt.emptyMap();
                callback.invoke(bool, emptyMap);
                return;
            }
            return;
        }
        final int h16 = getNickNameCallbackStore().h(owner, callback);
        dealExtInfoRequest("fetchTroopMemberNickName", troopUin, uinList, TroopMemberExtInfoRepo$fetchTroopMemberNickName$1.INSTANCE, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberNickName$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback nickNameCallbackStore2;
                Map emptyMap2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                nickNameCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getNickNameCallbackStore();
                Function2 function2 = (Function2) nickNameCallbackStore2.f(this.$callbackId);
                if (function2 != null) {
                    Boolean bool2 = Boolean.FALSE;
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                    function2.invoke(bool2, emptyMap2);
                }
            }
        }, new Function1<GroupMemberExtListResult, Unit>(extProcessParam, troopUin, needRemarkFirst, h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberNickName$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;
            final /* synthetic */ Bundle $extProcessParam;
            final /* synthetic */ boolean $needRemarkFirst;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$extProcessParam = extProcessParam;
                this.$troopUin = troopUin;
                this.$needRemarkFirst = needRemarkFirst;
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, extProcessParam, troopUin, Boolean.valueOf(needRemarkFirst), Integer.valueOf(h16));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberExtListResult groupMemberExtListResult) {
                invoke2(groupMemberExtListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberExtListResult result) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                LinkedHashMap linkedHashMap;
                TroopLifecycleCallback nickNameCallbackStore2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                if (a16 != null) {
                    Bundle bundle = this.$extProcessParam;
                    String str = this.$troopUin;
                    boolean z16 = this.$needRemarkFirst;
                    int i3 = this.$callbackId;
                    if (bundle != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putAll(bundle);
                        bundle2.putString("troopUin", str);
                        bundle2.putBoolean("needRemark", z16);
                        linkedHashMap = new LinkedHashMap();
                        com.tencent.mobileqq.troop.api.config.ae.b(a16, bundle2, linkedHashMap, result.memberLevelInfo);
                    } else {
                        ArrayList<MemberExtInfo> arrayList = result.memberLevelInfo;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "result.memberLevelInfo");
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                        linkedHashMap = new LinkedHashMap(coerceAtLeast);
                        for (MemberExtInfo memberExtInfo : arrayList) {
                            Pair pair = new Pair(String.valueOf(memberExtInfo.uin), memberExtInfo.nickName);
                            linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        }
                    }
                    nickNameCallbackStore2 = TroopMemberExtInfoRepo.INSTANCE.getNickNameCallbackStore();
                    Function2 function2 = (Function2) nickNameCallbackStore2.f(i3);
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, linkedHashMap);
                    }
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberSpecialTitle(@NotNull final String troopUin, @NotNull List<String> uinList, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<TroopMemberSpecialTitleInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, uinList, owner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        final int h16 = getSpecialTitleCallback().h(owner, callback);
        dealExtInfoRequest("fetchTroopMemberNickName", troopUin, uinList, TroopMemberExtInfoRepo$fetchTroopMemberSpecialTitle$1.INSTANCE, new Function1<String, Unit>(h16) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberSpecialTitle$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                TroopLifecycleCallback specialTitleCallback2;
                List emptyList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                specialTitleCallback2 = TroopMemberExtInfoRepo.INSTANCE.getSpecialTitleCallback();
                Function2 function2 = (Function2) specialTitleCallback2.f(this.$callbackId);
                if (function2 != null) {
                    Boolean bool = Boolean.FALSE;
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    function2.invoke(bool, emptyList);
                }
            }
        }, new Function1<GroupMemberExtListResult, Unit>(h16, troopUin) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopMemberSpecialTitle$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $callbackId;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callbackId = h16;
                this.$troopUin = troopUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, h16, (Object) troopUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupMemberExtListResult groupMemberExtListResult) {
                invoke2(groupMemberExtListResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupMemberExtListResult result) {
                TroopLifecycleCallback specialTitleCallback2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                if (com.tencent.qqnt.f.f356721a.a() != null) {
                    int i3 = this.$callbackId;
                    String str = this.$troopUin;
                    ArrayList<MemberExtInfo> arrayList = result.memberLevelInfo;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "result.memberLevelInfo");
                    ArrayList arrayList2 = new ArrayList();
                    for (MemberExtInfo memberExtInfo : arrayList) {
                        String valueOf = String.valueOf(memberExtInfo.uin);
                        String str2 = memberExtInfo.nickName;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.nickName");
                        String str3 = memberExtInfo.specialTitle;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.specialTitle");
                        TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = new TroopMemberSpecialTitleInfo(str, valueOf, str2, str3, (int) memberExtInfo.specialTitleExpireTime);
                        if (troopMemberSpecialTitleInfo.isExpired()) {
                            troopMemberSpecialTitleInfo = null;
                        }
                        if (troopMemberSpecialTitleInfo != null) {
                            arrayList2.add(troopMemberSpecialTitleInfo);
                        }
                    }
                    specialTitleCallback2 = TroopMemberExtInfoRepo.INSTANCE.getSpecialTitleCallback();
                    Function2 function2 = (Function2) specialTitleCallback2.f(i3);
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, arrayList2);
                    }
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopMemberUin(@NotNull String troopUin, int memberCount, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, Integer.valueOf(memberCount), owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            dealFetchMemberUin(troopUin, MemberCommonSourceType.DEFAULTTYPE, "5", String.valueOf(memberCount), "0", owner, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void fetchTroopOwner(@NotNull final String troopUin, @Nullable LifecycleOwner owner, @Nullable final Function2<? super Boolean, ? super List<String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, owner, callback);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            dealFetchMemberUin(troopUin, MemberCommonSourceType.PUSHTYPE, "1", "", "", owner, new Function2<Boolean, List<? extends String>, Unit>(troopUin, callback) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberExtInfoRepo$fetchTroopOwner$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, List<String>, Unit> $callback;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                    this.$troopUin = troopUin;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends String> list) {
                    invoke(bool.booleanValue(), (List<String>) list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
                
                    if ((r0.length() > 0) == true) goto L19;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16, @NotNull List<String> uinList) {
                    Object firstOrNull;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    boolean z17 = true;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), uinList);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(uinList, "uinList");
                    if (z16) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) uinList);
                        String str = (String) firstOrNull;
                        if (str != null) {
                        }
                        z17 = false;
                        if (z17) {
                            AppInterface a16 = com.tencent.qqnt.f.f356721a.a();
                            ITroopInfoService iTroopInfoService = a16 != null ? (ITroopInfoService) a16.getRuntimeService(ITroopInfoService.class, "") : null;
                            TroopInfo findTroopInfo = iTroopInfoService != null ? iTroopInfoService.findTroopInfo(this.$troopUin) : null;
                            if (findTroopInfo != null) {
                                findTroopInfo.troopowneruin = str;
                            }
                        }
                    }
                    Function2<Boolean, List<String>, Unit> function2 = this.$callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(z16), uinList);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void preloadMemberIllegalInfoFromLocal(@Nullable final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) troopUin);
        } else {
            if (TextUtils.isEmpty(troopUin)) {
                return;
            }
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.v
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberExtInfoRepo.preloadMemberIllegalInfoFromLocal$lambda$11(troopUin);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void updateTroopMemberHonor(@NotNull String troopUin, @NotNull String memberUin, @NotNull final byte[] honorInfo) {
        Long longOrNull;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, memberUin, honorInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(honorInfo, "honorInfo");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            final long longValue = longOrNull.longValue();
            AppRuntime f16 = bg.f();
            String str2 = null;
            if (f16 != null) {
                str = f16.getCurrentUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, memberUin)) {
                AppRuntime f17 = bg.f();
                if (f17 != null) {
                    str2 = f17.getCurrentUid();
                }
                if (str2 == null) {
                    return;
                }
                innerUpdateTroopMemberHonor(longValue, str2, honorInfo);
                return;
            }
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(memberUin, false, true, new IRelationNTUinAndUidApi.d() { // from class: com.tencent.qqnt.troopmemberlist.t
                @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.d
                public final void a(String str3) {
                    TroopMemberExtInfoRepo.updateTroopMemberHonor$lambda$7(longValue, honorInfo, str3);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi
    public void updateTroopMemberSpecialTitle(@NotNull String troopUin, @NotNull String memberUin, final int titleId) {
        Long longOrNull;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, memberUin, Integer.valueOf(titleId));
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            final long longValue = longOrNull.longValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateTroopMemberSpecialTitle: troopUin=" + troopUin + ", memberUin=" + memberUin + ", titleId=" + titleId);
            }
            AppRuntime f16 = bg.f();
            String str2 = null;
            if (f16 != null) {
                str = f16.getCurrentUin();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, memberUin)) {
                AppRuntime f17 = bg.f();
                if (f17 != null) {
                    str2 = f17.getCurrentUid();
                }
                if (str2 == null) {
                    return;
                }
                innerUpdateTroopMemberSpecialTitle(longValue, str2, titleId);
                return;
            }
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(memberUin, false, true, new IRelationNTUinAndUidApi.d() { // from class: com.tencent.qqnt.troopmemberlist.r
                @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.d
                public final void a(String str3) {
                    TroopMemberExtInfoRepo.updateTroopMemberSpecialTitle$lambda$6(longValue, titleId, str3);
                }
            });
        }
    }
}
