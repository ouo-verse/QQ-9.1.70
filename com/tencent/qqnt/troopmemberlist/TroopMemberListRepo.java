package com.tencent.qqnt.troopmemberlist;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberInfoListId;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupTableIdType;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u008b\u0002\u0010\u001c\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00022\u009a\u0001\u0010\u0019\u001a\u0095\u0001\u0012#\u0012!\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012f\u0012d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\f2B\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\fH\u0002J@\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0002JL\u0010*\u001a\u0004\u0018\u00010%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010)\u001a\u00020(H\u0002J>\u0010-\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0002JH\u00100\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0002JH\u00101\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0002JX\u00104\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0002J\u0018\u00108\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\t2\u0006\u00107\u001a\u000206H\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\tH\u0002J&\u0010;\u001a\u00020\u00042\u0006\u00105\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020%0\bH\u0002J \u0010<\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001aH\u0002J0\u0010=\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010!\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0002JN\u0010>\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0002J \u0010@\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u00107\u001a\u00020?H\u0002J<\u0010E\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\"\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020B0Aj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020B`CH\u0002J&\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J@\u0010J\u001a\u0012\u0012\u0004\u0012\u00020%0\rj\b\u0012\u0004\u0012\u00020%`\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010G2\u0006\u0010\u001d\u001a\u00020\t2\u0014\b\u0002\u0010I\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001a0\u0002H\u0002J\u001e\u0010K\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020%0\bH\u0002J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020LH\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010O\u001a\u00020#H\u0002J\u0006\u0010Q\u001a\u00020\u0004J;\u0010X\u001a\u00020\u00042\u0006\u0010R\u001a\u00020#2\u001a\u0010T\u001a\u0016\u0012\u0004\u0012\u00020S\u0018\u00010\rj\n\u0012\u0004\u0012\u00020S\u0018\u0001`\u000e2\u0006\u0010U\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\bV\u0010WJ0\u0010Y\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\tH\u0016J8\u0010Y\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0016J0\u0010Z\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\tH\u0016JN\u0010]\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\t2:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00040\fj\u0002`\\H\u0016J^\u0010]\u001a\u00020\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0\b2F\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00040\fj\u0002``H\u0016JN\u0010a\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\t2:\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00040\fj\u0002`\\H\u0016J^\u0010a\u001a\u00020\u00042\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\t0\b2F\u0010\u0006\u001aB\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u00040\fj\u0002`dH\u0016J6\u0010-\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016J6\u0010e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016J@\u00100\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0016J:\u0010f\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0016J0\u0010g\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\tH\u0016J:\u0010h\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0016J@\u00101\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010/H\u0016J6\u0010i\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010j\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010k\u001a\u00020\u0013H\u0016J\u0012\u0010l\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010m\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tH\u0016JQ\u0010q\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\t2+\u0010\u0006\u001a'\u0012\u0015\u0012\u0013\u0018\u00010n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(o\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`pH\u0016J[\u0010q\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010r\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2+\u0010\u0006\u001a'\u0012\u0015\u0012\u0013\u0018\u00010n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(o\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`pH\u0016JF\u00104\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016JF\u0010s\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016JF\u0010>\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010,H\u0016R\u0014\u0010t\u001a\u00020#8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010x\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bx\u0010wR\u0014\u0010y\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\by\u0010wR\u0014\u0010z\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bz\u0010uR\u0014\u0010{\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b{\u0010wR#\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020,0|8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001RS\u0010\u0082\u0001\u001a>\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060\rj\b\u0012\u0004\u0012\u000206`\u000e0Aj\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060\rj\b\u0012\u0004\u0012\u000206`\u000e`C8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001RS\u0010\u0084\u0001\u001a>\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0\rj\b\u0012\u0004\u0012\u00020?`\u000e0Aj\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0\rj\b\u0012\u0004\u0012\u00020?`\u000e`C8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R.\u0010\u0086\u0001\u001a\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/TroopMemberListRepo;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberListRepoApi;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/api/s;", "", "Lcom/tencent/qqnt/troopmemberlist/TroopMemberDelayTask;", "callback", "runWithGroupService", "", "", "inputList", "converter", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "needFetchList", "Lkotlin/Function3;", "", "errCode", "errMsg", "", "result", "onRsp", "fetcher", "", "isSuccess", "fetchUinOrUid", "troopUin", "memberUin", "Landroidx/lifecycle/LifecycleOwner;", "owner", "withExt", "from", "", "timeoutMs", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "getTroopMemberSyncInner", "uniqueFrom", "Lcom/tencent/qqnt/report/k;", "report", "getTroopMemberSyncWithTimeout", "forceNet", "Lcom/tencent/qqnt/troopmemberlist/f;", "fetchTroopMemberList", "uin", "Lcom/tencent/qqnt/troopmemberlist/g;", "fetchTroopMemberInfo", "fetchTroopMemberInfoWithExtInfo", SquareJSConst.Params.PARAMS_UIN_LIST, "ignoreHitCache", "fetchTroopMemberUinListInfo", "taskKey", "Lcom/tencent/qqnt/troopmemberlist/d;", "task", "hasSameFetchTaskRunning", "hasWaitNotifyTask", "res", "notifySameTask", "getFetchTroopMemberTaskKey", "useCache", "fetchTroopMemberUinListInfoWithExtInfo", "Lcom/tencent/qqnt/troopmemberlist/c;", "hasSameFetchDBTaskRunning", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "Lkotlin/collections/HashMap;", "map", "notifySameDBTask", "getUidListFromUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberListResult;", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "predicate", "getMemberListData", "onHandlerMemberListResp", "Ljava/lang/Runnable;", "runnable", "runInSubThread", "time", "timeCost", "initAfterNTInit", "troopUinLong", "Lcom/tencent/qqnt/troopmemberlist/merge/b;", "mergedTaskList", "mergeMills", "mergeFetchTroopMemberInfo$qqtroop_impl_release", "(JLjava/util/ArrayList;I)V", "mergeFetchTroopMemberInfo", "getTroopMemberInfoSync", "getTroopMemberWithExtInfoSync", "memberUid", "Lcom/tencent/qqnt/troopmemberlist/FetchSingleTroopMemberUinCallback;", "fetchTroopMemberUin", "memberUidList", "uid2UinMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUinCallback;", "fetchTroopMemberUid", "memberUinList", "uin2UidMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUidCallback;", "fetchTroopMemberListWithExtInfo", "getTroopMemberFromCacheOrFetchAsync", "getTroopMemberFromCache", "getTroopMemberWithExtFromCacheOrFetchAsync", "fetchGagTroopMemberInfo", "updateMemberDBVersionAfterNetRsp", "getTroopMemberInfoDBVersion", "isTroopMemberListExpired", "isTroopMemberInfoDBInited", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "nickInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNameCallback;", "fetchTroopMemberName", "lifecycleOwner", "preLoadTroopMemberUinListInfo", "DEFAULT_TIMEOUT", "J", "TAG", "Ljava/lang/String;", TroopMemberListRepo.KEY_MEMBER_LIST_SEQ, "ILLEGAL_UIN", "ILLEGAL_TROOP_UIN", "MEMBER_LIST_CONFIG_ID", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "memberListCallbackStore$delegate", "Lkotlin/Lazy;", "getMemberListCallbackStore", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "memberListCallbackStore", "fetchMemberInfoNTTaskMap", "Ljava/util/HashMap;", "fetchMemberInfoDBTaskMap", "", "waitingTask", "Ljava/util/List;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberListRepo implements ITroopMemberListRepoApi {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_TIMEOUT = 2000;
    public static final long ILLEGAL_TROOP_UIN = 0;

    @NotNull
    public static final String ILLEGAL_UIN = "0";

    @NotNull
    public static final TroopMemberListRepo INSTANCE;

    @NotNull
    private static final String KEY_MEMBER_LIST_SEQ = "KEY_MEMBER_LIST_SEQ";

    @NotNull
    private static final String MEMBER_LIST_CONFIG_ID = "103037";

    @NotNull
    private static final String TAG = "TroopMemberListRepo";

    @NotNull
    private static final HashMap<String, ArrayList<c>> fetchMemberInfoDBTaskMap;

    @NotNull
    private static final HashMap<String, ArrayList<d>> fetchMemberInfoNTTaskMap;

    /* renamed from: memberListCallbackStore$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy memberListCallbackStore;

    @NotNull
    private static final List<Function1<com.tencent.qqnt.kernel.api.s, Unit>> waitingTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002B\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ%\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberListRepo$a", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "", "uid2UinMap", "", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUinCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements Function2<Boolean, Map<String, ? extends String>, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f362750d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f362751e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super Boolean, ? super String, Unit> function2, String str) {
            this.f362750d = function2;
            this.f362751e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) str);
            }
        }

        public void a(boolean isSuccess, @NotNull Map<String, String> uid2UinMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uid2UinMap);
                return;
            }
            Intrinsics.checkNotNullParameter(uid2UinMap, "uid2UinMap");
            Function2<Boolean, String, Unit> function2 = this.f362750d;
            Boolean valueOf = Boolean.valueOf(isSuccess);
            String str = uid2UinMap.get(this.f362751e);
            if (str == null) {
                str = "";
            }
            function2.invoke(valueOf, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
            a(bool.booleanValue(), map);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002B\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ%\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberListRepo$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "", "uid2UinMap", "", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUinCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Function2<Boolean, Map<String, ? extends String>, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f362752d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f362753e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super String, Unit> function2, String str) {
            this.f362752d = function2;
            this.f362753e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) str);
            }
        }

        public void a(boolean isSuccess, @NotNull Map<String, String> uid2UinMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uid2UinMap);
                return;
            }
            Intrinsics.checkNotNullParameter(uid2UinMap, "uid2UinMap");
            Function2<Boolean, String, Unit> function2 = this.f362752d;
            Boolean valueOf = Boolean.valueOf(isSuccess);
            String str = uid2UinMap.get(this.f362753e);
            if (str == null) {
                str = "";
            }
            function2.invoke(valueOf, str);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
            a(bool.booleanValue(), map);
            return Unit.INSTANCE;
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        INSTANCE = new TroopMemberListRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopMemberListRepo$memberListCallbackStore$2.INSTANCE);
        memberListCallbackStore = lazy;
        fetchMemberInfoNTTaskMap = new HashMap<>();
        fetchMemberInfoDBTaskMap = new HashMap<>();
        waitingTask = new ArrayList();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.ad
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListRepo._init_$lambda$0();
            }
        }, 16, null, false);
    }

    TroopMemberListRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
        com.tencent.mobileqq.troop.api.config.af.a();
        com.tencent.mobileqq.troop.api.config.ae.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchGagTroopMemberInfo$lambda$31(f fVar, boolean z16, List troopMemberList) {
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (z16) {
            ArrayList arrayList = new ArrayList();
            Iterator it = troopMemberList.iterator();
            while (true) {
                boolean z17 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                long serverTime = NetConnInfoCenter.getServerTime();
                long j3 = ((TroopMemberInfo) next).gagTimeStamp;
                if (j3 <= 0 || j3 <= serverTime) {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(next);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "fetchGagTroopMemberInfo: gagList=" + arrayList);
            }
            if (fVar != null) {
                fVar.a(true, arrayList);
                return;
            }
            return;
        }
        if (fVar != null) {
            fVar.a(false, new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberInfo$lambda$23(g gVar, String str, String str2, boolean z16, List troopMemberList) {
        Object obj;
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        Iterator it = troopMemberList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((TroopMemberInfo) obj).memberuin, str2)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
        if (troopMemberInfo == null) {
            if (gVar != null) {
                gVar.a(w.f362959a.b(str, str2));
            }
        } else {
            ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
            if (a16 != null) {
                a16.putMemberInfo(str, troopMemberInfo, false);
            }
            if (gVar != null) {
                gVar.a(troopMemberInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberInfoWithExtInfo$lambda$29(String uniqueFrom, String str, g gVar, String str2, boolean z16, List troopMemberList) {
        Object obj;
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        Iterator it = troopMemberList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((TroopMemberInfo) obj).memberuin, str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
        if (troopMemberInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "[fetchTroopMemberInfoWithExtInfo]: info empty from:" + uniqueFrom + ", uin:" + str);
            }
            if (gVar != null) {
                gVar.a(w.f362959a.b(str2, str));
                return;
            }
            return;
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            a16.putMemberInfo(str2, troopMemberInfo, true);
        }
        if (gVar != null) {
            gVar.a(troopMemberInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberListWithExtInfo$lambda$14(long j3, String str, boolean z16, String uniqueFrom, com.tencent.qqnt.report.l report, f fVar, com.tencent.qqnt.troopmemberlist.datasync.c data) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(data, "data");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[fetchTroopMemberListWithExtInfo] finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3) + "}");
        }
        report.b();
        for (TroopMemberInfo troopMemberInfo : data.j()) {
            troopMemberInfo.nickInfo.initPinyin(troopMemberInfo.extInfo);
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            ITroopMemberCacheService.b.a(a16, str, data.j(), true, false, 8, null);
        }
        fVar.a(data.k(), data.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberListWithExtInfo$lambda$16(long j3, String str, boolean z16, String uniqueFrom, com.tencent.qqnt.troopmemberlist.datasync.c syncData, com.tencent.qqnt.report.l report, boolean z17, List troopMemberList) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(syncData, "$syncData");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[fetchTroopMemberListWithExtInfo] fetchTroopMemberList finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3));
        }
        synchronized (syncData) {
            com.tencent.qqnt.report.a.k(report, Integer.valueOf(troopMemberList.size()), null, null, 6, null);
            syncData.n(z17);
            syncData.m(troopMemberList);
            syncData.g();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberListWithExtInfo$lambda$20(long j3, String str, boolean z16, String uniqueFrom, com.tencent.qqnt.troopmemberlist.datasync.c syncData, com.tencent.qqnt.report.l report, List extInfoList) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(syncData, "$syncData");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(extInfoList, "extInfoList");
        HashMap<String, TroopMemberInfoExt> hashMap = new HashMap<>();
        Iterator it = extInfoList.iterator();
        while (it.hasNext()) {
            TroopMemberInfoExt troopMemberInfoExt = (TroopMemberInfoExt) it.next();
            String str2 = troopMemberInfoExt.memberUin;
            if (str2 != null) {
                hashMap.put(str2, troopMemberInfoExt);
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[fetchTroopMemberListWithExtInfo] fetchTroopMemberExtInfoList finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3));
        }
        synchronized (syncData) {
            report.h(hashMap.size());
            syncData.l(hashMap);
            syncData.g();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberName$lambda$33(final Function1 function1, TroopMemberInfo troopMemberInfo) {
        final TroopMemberNickInfo troopMemberNickInfo;
        if (troopMemberInfo != null) {
            troopMemberNickInfo = troopMemberInfo.nickInfo;
        } else {
            troopMemberNickInfo = null;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.ai
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListRepo.fetchTroopMemberName$lambda$33$lambda$32(Function1.this, troopMemberNickInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberName$lambda$33$lambda$32(Function1 function1, TroopMemberNickInfo troopMemberNickInfo) {
        if (function1 != null) {
            function1.invoke(troopMemberNickInfo);
        }
    }

    static /* synthetic */ void fetchTroopMemberUinListInfo$default(TroopMemberListRepo troopMemberListRepo, String str, List list, boolean z16, LifecycleOwner lifecycleOwner, String str2, String str3, boolean z17, f fVar, int i3, Object obj) {
        boolean z18;
        if ((i3 & 64) != 0) {
            z18 = false;
        } else {
            z18 = z17;
        }
        troopMemberListRepo.fetchTroopMemberUinListInfo(str, list, z16, lifecycleOwner, str2, str3, z18, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberUinListInfoWithExtInfo$lambda$41(com.tencent.qqnt.report.j report, long j3, String str, boolean z16, String uniqueFrom, f fVar, com.tencent.qqnt.troopmemberlist.datasync.c data) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(data, "data");
        report.b();
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 2, "[fetchTroopMemberUinListInfoWithExtInfo] finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3));
        }
        for (TroopMemberInfo troopMemberInfo : data.j()) {
            troopMemberInfo.nickInfo.initPinyin(troopMemberInfo.extInfo);
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            a16.putMemberList(str, data.j(), true, true);
        }
        if (fVar != null) {
            fVar.a(data.k(), data.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberUinListInfoWithExtInfo$lambda$43(long j3, String str, boolean z16, String uniqueFrom, com.tencent.qqnt.troopmemberlist.datasync.c syncData, com.tencent.qqnt.report.j report, boolean z17, List troopMemberList) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(syncData, "$syncData");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[fetchTroopMemberUinListInfoWithExtInfo] fetchTroopMemberUinListInfo finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3));
        }
        synchronized (syncData) {
            com.tencent.qqnt.report.a.k(report, Integer.valueOf(troopMemberList.size()), null, null, 6, null);
            syncData.n(z17);
            syncData.m(troopMemberList);
            syncData.g();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberUinListInfoWithExtInfo$lambda$47(long j3, String str, boolean z16, String uniqueFrom, List list, com.tencent.qqnt.troopmemberlist.datasync.c syncData, com.tencent.qqnt.report.j report, List extInfoList) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(syncData, "$syncData");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(extInfoList, "extInfoList");
        HashMap<String, TroopMemberInfoExt> hashMap = new HashMap<>();
        Iterator it = extInfoList.iterator();
        while (it.hasNext()) {
            TroopMemberInfoExt troopMemberInfoExt = (TroopMemberInfoExt) it.next();
            String str2 = troopMemberInfoExt.memberUin;
            if (str2 != null) {
                hashMap.put(str2, troopMemberInfoExt);
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[fetchTroopMemberUinListInfoWithExtInfo] fetchTroopMemberExtInfo finish, troopUin:" + str + ", forceNet:" + z16 + ", from:" + uniqueFrom + ", timeCost:" + INSTANCE.timeCost(j3));
        }
        if (list.size() == 1) {
            INSTANCE.notifySameDBTask(str, (String) list.get(0), hashMap);
            return;
        }
        synchronized (syncData) {
            report.h(hashMap.size());
            syncData.l(hashMap);
            syncData.g();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void fetchUinOrUid(final List<String> inputList, Function1<? super String, String> converter, Function2<? super ArrayList<String>, ? super Function3<? super Integer, ? super String, ? super Map<String, String>, Unit>, Unit> fetcher, final Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        boolean z16;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : inputList) {
            String invoke = converter.invoke(str);
            if (invoke.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(str, invoke);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            callback.invoke(Boolean.TRUE, linkedHashMap);
        } else {
            fetcher.invoke(arrayList, new Function3<Integer, String, Map<String, ? extends String>, Unit>(linkedHashMap, inputList, callback) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$fetchUinOrUid$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, Map<String, String>, Unit> $callback;
                final /* synthetic */ Map<String, String> $input2ResultMap;
                final /* synthetic */ List<String> $inputList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                    this.$input2ResultMap = linkedHashMap;
                    this.$inputList = inputList;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, linkedHashMap, inputList, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, Map<String, ? extends String> map) {
                    invoke(num.intValue(), str2, (Map<String, String>) map);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg, @Nullable Map<String, String> map) {
                    Map<String, String> emptyMap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), errMsg, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    if (map != null && map.size() + this.$input2ResultMap.size() == this.$inputList.size()) {
                        this.$input2ResultMap.putAll(map);
                        this.$callback.invoke(Boolean.TRUE, this.$input2ResultMap);
                        return;
                    }
                    QLog.e("TroopMemberListRepo", 1, "fetchUinOrUid: errCode=" + i3 + ", errMsg=" + errMsg + ", result=" + map);
                    Function2<Boolean, Map<String, String>, Unit> function2 = this.$callback;
                    Boolean bool = Boolean.FALSE;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    function2.invoke(bool, emptyMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFetchTroopMemberTaskKey(String troopUin, String memberUin, boolean forceNet) {
        return troopUin + "-" + memberUin + "-" + forceNet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<f> getMemberListCallbackStore() {
        return (TroopLifecycleCallback) memberListCallbackStore.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<TroopMemberInfo> getMemberListData(GroupMemberListResult result, String troopUin, Function1<? super MemberInfo, Boolean> predicate) {
        Integer num;
        ArrayList<GroupMemberInfoListId> arrayList;
        ArrayList<GroupMemberInfoListId> arrayList2;
        MemberInfo info;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<TroopMemberInfo> arrayList3 = new ArrayList<>();
        if (result != null && (arrayList2 = result.ids) != null) {
            for (GroupMemberInfoListId groupMemberInfoListId : arrayList2) {
                HashMap<String, MemberInfo> hashMap = result.infos;
                if (hashMap != null && (info = hashMap.get(groupMemberInfoListId.uid)) != null) {
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    if (predicate.invoke(info).booleanValue()) {
                        arrayList3.add(w.f362959a.a(info, troopUin));
                    }
                }
            }
        }
        if (QLog.isDebugVersion()) {
            if (result != null && (arrayList = result.ids) != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            QLog.d(TAG, 4, "[getMemberListData] size:" + num + ", timeCost:" + timeCost(currentTimeMillis) + ", result:" + result);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArrayList getMemberListData$default(TroopMemberListRepo troopMemberListRepo, GroupMemberListResult groupMemberListResult, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = TroopMemberListRepo$getMemberListData$1.INSTANCE;
        }
        return troopMemberListRepo.getMemberListData(groupMemberListResult, str, function1);
    }

    private final TroopMemberInfo getTroopMemberSyncInner(String troopUin, String memberUin, LifecycleOwner owner, boolean withExt, String from, long timeoutMs) {
        boolean z16;
        TroopMemberInfo memberInfo;
        String o16 = com.tencent.qqnt.e.o(from + "-sync", new Object());
        boolean z17 = false;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        TroopMemberInfo troopMemberInfo = null;
        if (!z16) {
            if (memberUin == null || memberUin.length() == 0) {
                z17 = true;
            }
            if (!z17 && !Intrinsics.areEqual(memberUin, "0")) {
                com.tencent.qqnt.report.k kVar = new com.tencent.qqnt.report.k(from, withExt);
                ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
                if (a16 != null) {
                    if (withExt) {
                        memberInfo = a16.getMemberInfoWithExtInfo(troopUin, memberUin);
                    } else {
                        memberInfo = a16.getMemberInfo(troopUin, memberUin);
                    }
                    troopMemberInfo = memberInfo;
                }
                if (troopMemberInfo != null) {
                    kVar.p();
                    kVar.b();
                    com.tencent.qqnt.report.i.f361953d.a(true);
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 4, "[getTroopMemberSyncInner] useCache, from:" + o16);
                    }
                    return troopMemberInfo;
                }
                return getTroopMemberSyncWithTimeout(troopUin, memberUin, owner, withExt, from, o16, timeoutMs, kVar);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TroopMemberInfo getTroopMemberSyncWithTimeout(String troopUin, String memberUin, LifecycleOwner owner, boolean withExt, String from, String uniqueFrom, long timeoutMs, com.tencent.qqnt.report.k report) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new TroopMemberListRepo$getTroopMemberSyncWithTimeout$1(objectRef, timeoutMs, uniqueFrom, withExt, troopUin, memberUin, owner, from, report, null), 1, null);
        return (TroopMemberInfo) objectRef.element;
    }

    private final ArrayList<String> getUidListFromUin(List<String> uinList) {
        Long longOrNull;
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : uinList) {
            if (!Intrinsics.areEqual(str, "0")) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                if (longOrNull == null) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                } else {
                    String uidFromUin = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUidFromUin(longOrNull.longValue());
                    if (uidFromUin != null) {
                        arrayList.add(uidFromUin);
                    }
                }
            }
        }
        return arrayList;
    }

    private final boolean hasSameFetchDBTaskRunning(String troopUin, String memberUin, c task) {
        ArrayList<c> arrayListOf;
        String fetchTroopMemberTaskKey = getFetchTroopMemberTaskKey(troopUin, memberUin, false);
        HashMap<String, ArrayList<c>> hashMap = fetchMemberInfoDBTaskMap;
        synchronized (hashMap) {
            if (hashMap.get(fetchTroopMemberTaskKey) == null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(task);
                hashMap.put(fetchTroopMemberTaskKey, arrayListOf);
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[hasSameFetchDBTaskRunning] first task, key:" + fetchTroopMemberTaskKey + ", task:" + task);
                }
                return false;
            }
            ArrayList<c> arrayList = hashMap.get(fetchTroopMemberTaskKey);
            if (arrayList != null) {
                arrayList.add(task);
            }
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[hasSameFetchDBTaskRunning] wait before task callback, key:" + fetchTroopMemberTaskKey + ", task:" + task);
            }
            return true;
        }
    }

    private final boolean hasSameFetchTaskRunning(String taskKey, d task) {
        ArrayList<d> arrayListOf;
        HashMap<String, ArrayList<d>> hashMap = fetchMemberInfoNTTaskMap;
        synchronized (hashMap) {
            if (hashMap.get(taskKey) == null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(task);
                hashMap.put(taskKey, arrayListOf);
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[hasSameFetchTaskRunning] first task, taskKey:" + taskKey + ", task:" + task);
                }
                return false;
            }
            ArrayList<d> arrayList = hashMap.get(taskKey);
            if (arrayList != null) {
                arrayList.add(task);
            }
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[hasSameFetchTaskRunning] wait before task callback, taskKey:" + taskKey + ", task:" + task);
            }
            return true;
        }
    }

    private final boolean hasWaitNotifyTask(String taskKey) {
        boolean z16;
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[hasWaitNotifyTask] taskKey:" + taskKey);
        }
        HashMap<String, ArrayList<d>> hashMap = fetchMemberInfoNTTaskMap;
        synchronized (hashMap) {
            if (hashMap.get(taskKey) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAfterNTInit$lambda$4() {
        List<Function1<com.tencent.qqnt.kernel.api.s, Unit>> list = waitingTask;
        synchronized (list) {
            com.tencent.qqnt.kernel.api.s i3 = bg.i(null, 1, null);
            if (i3 != null) {
                Iterator<Function1<com.tencent.qqnt.kernel.api.s, Unit>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().invoke(i3);
                }
            } else {
                QLog.e(TAG, 1, "initAfterNTInit: group service null!");
            }
        }
        com.tencent.qqnt.troopmemberlist.merge.c.f362920a.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mergeFetchTroopMemberInfo$lambda$10(ArrayList arrayList, Integer num, int i3, long j3) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.troopmemberlist.merge.b bVar = (com.tencent.qqnt.troopmemberlist.merge.b) it.next();
            if (bVar.f().size() == 1) {
                TroopMemberListRepo troopMemberListRepo = INSTANCE;
                bVar.i(troopMemberListRepo.hasWaitNotifyTask(troopMemberListRepo.getFetchTroopMemberTaskKey(String.valueOf(bVar.e()), bVar.g().get(0), false)));
                if (bVar.c()) {
                    arrayList2.addAll(bVar.f());
                }
            } else {
                arrayList2.addAll(bVar.f());
            }
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[mergeFetchTroopMemberInfo] mark:" + num + ", task:" + bVar);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            com.tencent.qqnt.troopmemberlist.merge.b bVar2 = (com.tencent.qqnt.troopmemberlist.merge.b) it5.next();
            if (bVar2.c()) {
                bVar2.d().i(arrayList2.size(), i3);
            }
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[mergeFetchTroopMemberInfo] mark:" + num + ", uinListSize:" + arrayList2.size());
        }
        if (arrayList2.isEmpty()) {
            QLog.i(TAG, 1, "[mergeFetchTroopMemberInfo] mark:" + num + ", memberUidList is empty");
            return;
        }
        INSTANCE.runWithGroupService(new TroopMemberListRepo$mergeFetchTroopMemberInfo$1$3(j3, arrayList, arrayList2, num));
    }

    private final void notifySameDBTask(String troopUin, String memberUin, HashMap<String, TroopMemberInfoExt> map) {
        ArrayList<c> remove;
        StringBuilder sb5;
        String fetchTroopMemberTaskKey = getFetchTroopMemberTaskKey(troopUin, memberUin, false);
        HashMap<String, ArrayList<c>> hashMap = fetchMemberInfoDBTaskMap;
        synchronized (hashMap) {
            remove = hashMap.remove(fetchTroopMemberTaskKey);
            Unit unit = Unit.INSTANCE;
        }
        ArrayList<c> arrayList = remove;
        if (arrayList != null) {
            String str = null;
            if (QLog.isDebugVersion()) {
                sb5 = new StringBuilder();
            } else {
                sb5 = null;
            }
            for (c cVar : arrayList) {
                synchronized (cVar.b()) {
                    cVar.a().h(map.size());
                    cVar.b().l(map);
                    cVar.b().g();
                    Unit unit2 = Unit.INSTANCE;
                }
                if (sb5 != null) {
                    sb5.append(cVar + ";");
                }
            }
            if (QLog.isDebugVersion()) {
                if (sb5 != null) {
                    str = sb5.toString();
                }
                QLog.d(TAG, 4, "[notifySameDBTask] key:" + fetchTroopMemberTaskKey + ", task:" + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySameTask(String taskKey, boolean isSuccess, List<? extends TroopMemberInfo> res) {
        ArrayList<d> remove;
        StringBuilder sb5;
        HashMap<String, ArrayList<d>> hashMap = fetchMemberInfoNTTaskMap;
        synchronized (hashMap) {
            remove = hashMap.remove(taskKey);
            Unit unit = Unit.INSTANCE;
        }
        ArrayList<d> arrayList = remove;
        if (arrayList != null) {
            String str = null;
            if (QLog.isDebugVersion()) {
                sb5 = new StringBuilder();
            } else {
                sb5 = null;
            }
            for (d dVar : arrayList) {
                dVar.b().b();
                f f16 = INSTANCE.getMemberListCallbackStore().f(dVar.a());
                if (f16 != null) {
                    f16.a(isSuccess, res);
                }
                if (sb5 != null) {
                    sb5.append(dVar + ";");
                }
            }
            if (QLog.isDebugVersion()) {
                if (sb5 != null) {
                    str = sb5.toString();
                }
                QLog.d(TAG, 4, "[notifySameTask] nt callback, taskKey:" + taskKey + ", task:" + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHandlerMemberListResp(String troopUin, List<? extends TroopMemberInfo> res) {
        String account;
        Object obj;
        com.tencent.mobileqq.troop.api.config.af.d(troopUin);
        com.tencent.mobileqq.troop.api.config.af.b(troopUin, res);
        AppRuntime f16 = bg.f();
        if (f16 != null && (account = f16.getAccount()) != null) {
            Iterator<T> it = res.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((TroopMemberInfo) obj).memberuin, account)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
            if (troopMemberInfo != null) {
                TroopExtDBInfoRepo.INSTANCE.updateMyTroopHonor(troopUin, troopMemberInfo.honorList, troopMemberInfo.mHonorRichFlag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runInSubThread(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runWithGroupService(Function1<? super com.tencent.qqnt.kernel.api.s, Unit> callback) {
        com.tencent.qqnt.kernel.api.s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            callback.invoke(i3);
            return;
        }
        QLog.e(TAG, 1, "runWithGroupService: group service null, delay task");
        List<Function1<com.tencent.qqnt.kernel.api.s, Unit>> list = waitingTask;
        synchronized (list) {
            com.tencent.qqnt.kernel.api.s i16 = bg.i(null, 1, null);
            if (i16 == null) {
                list.add(callback);
            } else {
                callback.invoke(i16);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long timeCost(long time) {
        return System.currentTimeMillis() - time;
    }

    private final boolean useCache(String troopUin, List<String> uinList, boolean withExt, f callback) {
        List<TroopMemberInfo> memberInfo;
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null && (memberInfo = a16.getMemberInfo(troopUin, uinList, withExt)) != null) {
            if (callback != null) {
                callback.a(true, memberInfo);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchGagTroopMemberInfo(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable final f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        fetchTroopMemberList(troopUin, owner, forceNet, from + "-fetchGag", new f() { // from class: com.tencent.qqnt.troopmemberlist.aj
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                TroopMemberListRepo.fetchGagTroopMemberInfo$lambda$31(f.this, z16, list);
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, uin, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberInfo(troopUin, uin, forceNet, owner, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberInfoWithExtInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, uin, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberInfoWithExtInfo(troopUin, uin, forceNet, owner, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberList(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberList(troopUin, owner, forceNet, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberListWithExtInfo(@Nullable final String troopUin, @Nullable LifecycleOwner owner, final boolean forceNet, @NotNull String from, @Nullable final f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, owner, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        final String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin == null || troopUin.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "[fetchTroopMemberListWithExtInfo] troopUin:" + troopUin + ", forceNet:" + forceNet + ", from:" + o16);
            if (callback != null) {
                callback.a(true, new ArrayList());
                return;
            }
            return;
        }
        if (callback == null) {
            fetchTroopMemberList(troopUin, owner, forceNet, o16, null);
            return;
        }
        final com.tencent.qqnt.report.l lVar = new com.tencent.qqnt.report.l(troopUin, from, forceNet, true);
        final com.tencent.qqnt.troopmemberlist.datasync.c cVar = new com.tencent.qqnt.troopmemberlist.datasync.c(2);
        final long currentTimeMillis = System.currentTimeMillis();
        cVar.h(new com.tencent.qqnt.troopmemberlist.datasync.d() { // from class: com.tencent.qqnt.troopmemberlist.af
            @Override // com.tencent.qqnt.troopmemberlist.datasync.d
            public final void a(Object obj) {
                TroopMemberListRepo.fetchTroopMemberListWithExtInfo$lambda$14(currentTimeMillis, troopUin, forceNet, o16, lVar, callback, (com.tencent.qqnt.troopmemberlist.datasync.c) obj);
            }
        });
        com.tencent.qqnt.report.a.o(lVar, null, 1, null);
        fetchTroopMemberList(troopUin, owner, forceNet, o16, new f() { // from class: com.tencent.qqnt.troopmemberlist.ag
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                TroopMemberListRepo.fetchTroopMemberListWithExtInfo$lambda$16(currentTimeMillis, troopUin, forceNet, o16, cVar, lVar, z17, list);
            }
        });
        lVar.m();
        TroopMemberDBExtInfoRepo.INSTANCE.fetchTroopMemberExtInfoList$qqtroop_impl_release(troopUin, o16, new i() { // from class: com.tencent.qqnt.troopmemberlist.ah
            @Override // com.tencent.qqnt.troopmemberlist.i
            public final void a(List list) {
                TroopMemberListRepo.fetchTroopMemberListWithExtInfo$lambda$20(currentTimeMillis, troopUin, forceNet, o16, cVar, lVar, list);
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @NotNull String from, @Nullable Function1<? super TroopMemberNickInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopUin, memberUin, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberName(troopUin, memberUin, null, from, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUid(@Nullable String memberUin, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) memberUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (memberUin == null) {
            return;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(memberUin);
        fetchTroopMemberUid(listOf, new a(callback, memberUin));
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUin(@Nullable String memberUid, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) memberUid, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (memberUid == null) {
            return;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(memberUid);
        fetchTroopMemberUin(listOf, new b(callback, memberUid));
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberUinListInfo(troopUin, uinList, forceNet, owner, from, com.tencent.qqnt.e.o(from, callback), false, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUinListInfoWithExtInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberUinListInfoWithExtInfo(troopUin, uinList, forceNet, owner, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberFromCache(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 15, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopMemberInfo troopMemberInfo = null;
        if (troopUin == null || memberUin == null) {
            return null;
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            troopMemberInfo = a16.getMemberInfo(troopUin, memberUin);
        }
        if (troopMemberInfo != null) {
            com.tencent.qqnt.report.i.f361953d.a(true);
        }
        return troopMemberInfo;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 14, this, troopUin, memberUin, owner, from, callback);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopMemberInfo troopMemberInfo = null;
        if (troopUin == null || memberUin == null) {
            return null;
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            troopMemberInfo = a16.getMemberInfo(troopUin, memberUin);
        }
        TroopMemberInfo troopMemberInfo2 = troopMemberInfo;
        if (troopMemberInfo2 != null) {
            com.tencent.qqnt.report.i.f361953d.a(true);
        }
        if (troopMemberInfo2 == null) {
            fetchTroopMemberInfo(troopUin, memberUin, false, owner, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
        return troopMemberInfo2;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public int getTroopMemberInfoDBVersion() {
        Integer groupDBVersion;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        com.tencent.qqnt.kernel.api.s i3 = bg.i(null, 1, null);
        if (i3 != null && (groupDBVersion = i3.getGroupDBVersion(GroupTableIdType.MEMBERINFO.ordinal())) != null) {
            return groupDBVersion.intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 4, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return getTroopMemberSyncInner(troopUin, memberUin, owner, false, from, 2000L);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberWithExtFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 16, this, troopUin, memberUin, owner, from, callback);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopMemberInfo troopMemberInfo = null;
        if (troopUin == null || memberUin == null) {
            return null;
        }
        ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        if (a16 != null) {
            troopMemberInfo = a16.getMemberInfoWithExtInfo(troopUin, memberUin);
        }
        TroopMemberInfo troopMemberInfo2 = troopMemberInfo;
        if (troopMemberInfo2 != null) {
            com.tencent.qqnt.report.i.f361953d.a(true);
        }
        if (troopMemberInfo2 == null) {
            fetchTroopMemberInfoWithExtInfo(troopUin, memberUin, false, owner, from, com.tencent.qqnt.e.o(from, callback), callback);
        }
        return troopMemberInfo2;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberWithExtInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 6, this, troopUin, memberUin, owner, from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return getTroopMemberSyncInner(troopUin, memberUin, owner, true, from, 2000L);
    }

    public final void initAfterNTInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            runInSubThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.ab
                @Override // java.lang.Runnable
                public final void run() {
                    TroopMemberListRepo.initAfterNTInit$lambda$4();
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public boolean isTroopMemberInfoDBInited(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        int a16 = x.INSTANCE.a(troopUin);
        if (a16 > 0 && a16 >= getTroopMemberInfoDBVersion()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public boolean isTroopMemberListExpired(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) troopUin)).booleanValue();
        }
        if (troopUin == null) {
            return false;
        }
        long j3 = 0;
        long k3 = com.tencent.mobileqq.troop.config.a.f294689a.k(troopUin + KEY_MEMBER_LIST_SEQ, 0L, true);
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null) {
            j3 = troopInfoFromCache.mMemberNumSeq;
        }
        if (j3 <= k3) {
            return false;
        }
        return true;
    }

    public final void mergeFetchTroopMemberInfo$qqtroop_impl_release(final long troopUinLong, @Nullable final ArrayList<com.tencent.qqnt.troopmemberlist.merge.b> mergedTaskList, final int mergeMills) {
        final Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(troopUinLong), mergedTaskList, Integer.valueOf(mergeMills));
            return;
        }
        Integer num2 = null;
        if (mergedTaskList != null) {
            num = Integer.valueOf(mergedTaskList.hashCode());
        } else {
            num = null;
        }
        if (QLog.isDebugVersion()) {
            if (mergedTaskList != null) {
                num2 = Integer.valueOf(mergedTaskList.size());
            }
            QLog.d(TAG, 4, "[mergeFetchTroopMemberInfo] mark:" + num + ", size:" + num2 + ".");
        }
        if (mergedTaskList == null) {
            return;
        }
        runInSubThread(new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.y
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberListRepo.mergeFetchTroopMemberInfo$lambda$10(mergedTaskList, num, mergeMills, troopUinLong);
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void preLoadTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, troopUin, uinList, Boolean.valueOf(forceNet), owner, from, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchTroopMemberUinListInfo(troopUin, uinList, forceNet, owner, from, com.tencent.qqnt.e.o(from, callback), true, callback);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void updateMemberDBVersionAfterNetRsp(@NotNull String troopUin) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        x.INSTANCE.b(troopUin, getTroopMemberInfoDBVersion());
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        String str = troopUin + KEY_MEMBER_LIST_SEQ;
        if (troopInfoFromCache != null) {
            j3 = troopInfoFromCache.mMemberNumSeq;
        } else {
            j3 = 0;
        }
        com.tencent.mobileqq.troop.config.a.x(aVar, str, j3, false, 4, null);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner lifecycleOwner, @NotNull String from, @Nullable final Function1<? super TroopMemberNickInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, memberUin, lifecycleOwner, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        fetchTroopMemberInfo(troopUin, memberUin, false, lifecycleOwner, from + "-fetchName", new g() { // from class: com.tencent.qqnt.troopmemberlist.ae
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopMemberListRepo.fetchTroopMemberName$lambda$33(Function1.this, troopMemberInfo);
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUid(@NotNull List<String> memberUinList, @NotNull final Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) memberUinList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUinList, "memberUinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchUinOrUid(memberUinList, TroopMemberListRepo$fetchTroopMemberUid$2.INSTANCE, TroopMemberListRepo$fetchTroopMemberUid$3.INSTANCE, new Function2<Boolean, Map<String, ? extends String>, Unit>(callback) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$fetchTroopMemberUid$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2<Boolean, Map<String, String>, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
                invoke(bool.booleanValue(), (Map<String, String>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull Map<String, String> result) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), result);
                } else {
                    Intrinsics.checkNotNullParameter(result, "result");
                    this.$callback.invoke(Boolean.valueOf(z16), result);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    public void fetchTroopMemberUin(@NotNull List<String> memberUidList, @NotNull final Function2<? super Boolean, ? super Map<String, String>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) memberUidList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUidList, "memberUidList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchUinOrUid(memberUidList, TroopMemberListRepo$fetchTroopMemberUin$2.INSTANCE, TroopMemberListRepo$fetchTroopMemberUin$3.INSTANCE, new Function2<Boolean, Map<String, ? extends String>, Unit>(callback) { // from class: com.tencent.qqnt.troopmemberlist.TroopMemberListRepo$fetchTroopMemberUin$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2<Boolean, Map<String, String>, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends String> map) {
                invoke(bool.booleanValue(), (Map<String, String>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull Map<String, String> result) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), result);
                } else {
                    Intrinsics.checkNotNullParameter(result, "result");
                    this.$callback.invoke(Boolean.valueOf(z16), result);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi
    @Nullable
    public TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, long timeoutMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 5, this, troopUin, memberUin, owner, from, Long.valueOf(timeoutMs));
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return getTroopMemberSyncInner(troopUin, memberUin, owner, false, from, timeoutMs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchTroopMemberInfo(final String troopUin, final String uin, boolean forceNet, LifecycleOwner owner, String from, String uniqueFrom, final g callback) {
        ArrayList arrayListOf;
        ITroopMemberCacheService a16;
        TroopMemberInfo memberInfo;
        if (!(troopUin == null || troopUin.length() == 0)) {
            if (!(uin == null || uin.length() == 0) && !Intrinsics.areEqual(uin, "0")) {
                if (forceNet || (a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a()) == null || (memberInfo = a16.getMemberInfo(troopUin, uin)) == null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uin);
                    fetchTroopMemberUinListInfo$default(this, troopUin, arrayListOf, forceNet, owner, from, uniqueFrom, false, new f() { // from class: com.tencent.qqnt.troopmemberlist.aa
                        @Override // com.tencent.qqnt.troopmemberlist.f
                        public final void a(boolean z16, List list) {
                            TroopMemberListRepo.fetchTroopMemberInfo$lambda$23(g.this, troopUin, uin, z16, list);
                        }
                    }, 64, null);
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[fetchTroopMemberInfo] useCache, from:" + uniqueFrom);
                }
                com.tencent.qqnt.report.i.f361953d.a(true);
                if (callback != null) {
                    callback.a(memberInfo);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "[fetchTroopMemberInfo] from:" + uniqueFrom + ", skip by illegal data, troopUin:" + troopUin + ". uin:" + uin);
        }
        if (callback != null) {
            callback.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchTroopMemberInfoWithExtInfo(final String troopUin, final String uin, boolean forceNet, LifecycleOwner owner, String from, final String uniqueFrom, final g callback) {
        ArrayList arrayListOf;
        TroopMemberInfo memberInfoWithExtInfo;
        if (!(troopUin == null || troopUin.length() == 0)) {
            if (!(uin == null || uin.length() == 0) && !Intrinsics.areEqual(uin, "0")) {
                ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
                if (a16 == null || (memberInfoWithExtInfo = a16.getMemberInfoWithExtInfo(troopUin, uin)) == null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uin);
                    fetchTroopMemberUinListInfoWithExtInfo(troopUin, arrayListOf, forceNet, owner, from, uniqueFrom, new f() { // from class: com.tencent.qqnt.troopmemberlist.ac
                        @Override // com.tencent.qqnt.troopmemberlist.f
                        public final void a(boolean z16, List list) {
                            TroopMemberListRepo.fetchTroopMemberInfoWithExtInfo$lambda$29(uniqueFrom, uin, callback, troopUin, z16, list);
                        }
                    });
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[fetchTroopMemberInfoWithExtInfo] useCache, from:" + uniqueFrom);
                }
                com.tencent.qqnt.report.i.f361953d.a(true);
                if (callback != null) {
                    callback.a(memberInfoWithExtInfo);
                    return;
                }
                return;
            }
        }
        QLog.e(TAG, 1, "[fetchTroopMemberInfoWithExtInfo] from:" + uniqueFrom + ", skip by illegal data, troopUin:" + troopUin + ". uin:" + uin);
        if (callback != null) {
            callback.a(null);
        }
    }

    private final void fetchTroopMemberList(String troopUin, LifecycleOwner owner, boolean forceNet, String from, String uniqueFrom, f callback) {
        Long longOrNull = troopUin != null ? StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin) : null;
        if (longOrNull == null) {
            QLog.e(TAG, 1, "[fetchTroopMemberList] from:" + uniqueFrom + ", troopUinLong isNull");
            if (callback != null) {
                callback.a(true, new ArrayList());
                return;
            }
            return;
        }
        boolean z16 = forceNet && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(MEMBER_LIST_CONFIG_ID, false);
        com.tencent.qqnt.report.l lVar = new com.tencent.qqnt.report.l(troopUin, from, forceNet, false, 8, null);
        lVar.p(z16);
        runWithGroupService(new TroopMemberListRepo$fetchTroopMemberList$1(lVar, z16, troopUin, from, forceNet, longOrNull, System.currentTimeMillis(), uniqueFrom, getMemberListCallbackStore().h(owner, callback)));
    }

    private final void fetchTroopMemberUinListInfo(String troopUin, List<String> uinList, boolean forceNet, LifecycleOwner owner, String from, String uniqueFrom, boolean ignoreHitCache, f callback) {
        int i3;
        com.tencent.qqnt.report.j jVar;
        String str;
        boolean z16;
        Long longOrNull = troopUin != null ? StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin) : null;
        if (longOrNull != null && longOrNull.longValue() != 0) {
            List<String> list = uinList;
            if (list == null || list.isEmpty()) {
                QLog.e(TAG, 1, "[fetchTroopMemberUinListInfo] from:" + uniqueFrom + ", uinList isNullOrEmpty");
                if (callback != null) {
                    callback.a(true, new ArrayList());
                    return;
                }
                return;
            }
            if (!forceNet && useCache(troopUin, uinList, false, callback)) {
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[fetchTroopMemberUinListInfo] useCache, from:" + uniqueFrom);
                }
                if (ignoreHitCache) {
                    return;
                }
                com.tencent.qqnt.report.i.f361953d.a(true);
                return;
            }
            com.tencent.qqnt.report.j jVar2 = new com.tencent.qqnt.report.j(troopUin, from, uinList.size(), false, forceNet, 8, null);
            if (ignoreHitCache) {
                i3 = 0;
            } else {
                i3 = 0;
                com.tencent.qqnt.report.i.f361953d.a(false);
            }
            ArrayList<String> uidListFromUin = getUidListFromUin(uinList);
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[fetchTroopMemberUinListInfo] troopUin:" + troopUin + ", from:" + uniqueFrom + ", uinList:" + uinList + ", uidList:" + uidListFromUin);
            }
            if (uidListFromUin.isEmpty()) {
                if (QLog.isColorLevel()) {
                    z16 = true;
                    QLog.e(TAG, 1, "[fetchTroopMemberUinListInfo] from:" + uniqueFrom + ", uidList is empty");
                } else {
                    z16 = true;
                }
                if (callback != null) {
                    callback.a(z16, new ArrayList());
                    return;
                }
                return;
            }
            int h16 = getMemberListCallbackStore().h(owner, callback);
            if (uidListFromUin.size() == 1) {
                jVar = jVar2;
                if (hasSameFetchTaskRunning(getFetchTroopMemberTaskKey(troopUin, uinList.get(i3), forceNet), new d(h16, jVar, uniqueFrom))) {
                    jVar.n(Integer.valueOf(uidListFromUin.size()));
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 2, "[fetchTroopMemberUinListInfo] same task is running, from:" + uniqueFrom + ", forceNet:" + forceNet + ", troopUin:" + troopUin + ", memberUin:" + ((Object) uinList.get(i3)));
                        return;
                    }
                    return;
                }
            } else {
                jVar = jVar2;
            }
            if (!forceNet) {
                com.tencent.qqnt.troopmemberlist.merge.c cVar = com.tencent.qqnt.troopmemberlist.merge.c.f362920a;
                if (cVar.h(from)) {
                    str = uniqueFrom;
                    if (cVar.e(new com.tencent.qqnt.troopmemberlist.merge.b(longOrNull.longValue(), uinList, uidListFromUin, from, uniqueFrom, h16, jVar, false, 128, null))) {
                        if (QLog.isDebugVersion()) {
                            QLog.d(TAG, 4, "[fetchTroopMemberUinListInfo]  from:" + str + ", will be merge");
                            return;
                        }
                        return;
                    }
                    runWithGroupService(new TroopMemberListRepo$fetchTroopMemberUinListInfo$1(from, troopUin, forceNet, jVar, uidListFromUin, longOrNull, uniqueFrom, uinList, h16));
                    return;
                }
            }
            str = uniqueFrom;
            runWithGroupService(new TroopMemberListRepo$fetchTroopMemberUinListInfo$1(from, troopUin, forceNet, jVar, uidListFromUin, longOrNull, uniqueFrom, uinList, h16));
            return;
        }
        QLog.e(TAG, 1, "[fetchTroopMemberUinListInfo] from:" + uniqueFrom + ", troopUin:" + troopUin + " is illegal. ");
        if (callback != null) {
            callback.a(true, new ArrayList());
        }
    }

    private final void fetchTroopMemberUinListInfoWithExtInfo(final String troopUin, final List<String> uinList, final boolean forceNet, LifecycleOwner owner, String from, final String uniqueFrom, final f callback) {
        String str;
        final com.tencent.qqnt.report.j jVar;
        if (!(troopUin == null || troopUin.length() == 0)) {
            List<String> list = uinList;
            if (!(list == null || list.isEmpty())) {
                if (!forceNet && useCache(troopUin, uinList, true, callback)) {
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 4, "[fetchTroopMemberUinListInfoWithExtInfo] useCache, from:" + uniqueFrom);
                        return;
                    }
                    return;
                }
                final com.tencent.qqnt.report.j jVar2 = new com.tencent.qqnt.report.j(troopUin, from, uinList.size(), true, forceNet);
                final com.tencent.qqnt.troopmemberlist.datasync.c cVar = new com.tencent.qqnt.troopmemberlist.datasync.c(2);
                final long currentTimeMillis = System.currentTimeMillis();
                cVar.h(new com.tencent.qqnt.troopmemberlist.datasync.d() { // from class: com.tencent.qqnt.troopmemberlist.ak
                    @Override // com.tencent.qqnt.troopmemberlist.datasync.d
                    public final void a(Object obj) {
                        TroopMemberListRepo.fetchTroopMemberUinListInfoWithExtInfo$lambda$41(com.tencent.qqnt.report.j.this, currentTimeMillis, troopUin, forceNet, uniqueFrom, callback, (com.tencent.qqnt.troopmemberlist.datasync.c) obj);
                    }
                });
                jVar2.n(Integer.valueOf(uinList.size()));
                fetchTroopMemberUinListInfo$default(this, troopUin, uinList, forceNet, owner, from, uniqueFrom, false, new f() { // from class: com.tencent.qqnt.troopmemberlist.al
                    @Override // com.tencent.qqnt.troopmemberlist.f
                    public final void a(boolean z16, List list2) {
                        TroopMemberListRepo.fetchTroopMemberUinListInfoWithExtInfo$lambda$43(currentTimeMillis, troopUin, forceNet, uniqueFrom, cVar, jVar2, z16, list2);
                    }
                }, 64, null);
                if (uinList.size() == 1) {
                    str = troopUin;
                    jVar = jVar2;
                    if (hasSameFetchDBTaskRunning(str, uinList.get(0), new c(cVar, jVar2, uniqueFrom))) {
                        jVar.m();
                        if (QLog.isDebugVersion()) {
                            QLog.d(TAG, 4, "[fetchTroopMemberUinListInfoWithExtInfo] has same db task running, from:" + uniqueFrom + ", troopUin:" + str + ", memberUin:" + ((Object) uinList.get(0)));
                            return;
                        }
                        return;
                    }
                } else {
                    str = troopUin;
                    jVar = jVar2;
                }
                jVar.m();
                TroopMemberDBExtInfoRepo.INSTANCE.fetchTroopMemberExtInfo$qqtroop_impl_release(str, uinList, uniqueFrom, new i() { // from class: com.tencent.qqnt.troopmemberlist.z
                    @Override // com.tencent.qqnt.troopmemberlist.i
                    public final void a(List list2) {
                        TroopMemberListRepo.fetchTroopMemberUinListInfoWithExtInfo$lambda$47(currentTimeMillis, troopUin, forceNet, uniqueFrom, uinList, cVar, jVar, list2);
                    }
                });
                return;
            }
        }
        QLog.i(TAG, 1, "[fetchTroopMemberUinListInfoWithExtInfo] troopUin:" + troopUin + ", uinList:" + uinList + ", from:" + uniqueFrom);
        if (callback != null) {
            callback.a(true, new ArrayList());
        }
    }
}
