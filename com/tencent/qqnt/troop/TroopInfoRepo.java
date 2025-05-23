package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.kernel.nativeinterface.BatchQueryCachedGroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupPrivilegeFlagRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupPrivilegeFlagCallback;
import com.tencent.qqnt.troop.TroopInfoRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001uB\t\b\u0002\u00a2\u0006\u0004\bs\u0010tJt\u0010\u0015\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J`\u0010\u0018\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\u0002J\u00b7\u0002\u0010'\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u00112{\u0010\"\u001aw\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001c\u0012X\u0012V\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00100\u001d\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\t26\u0010$\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(#\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00100\t2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0016H\u0002J\u0014\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u00a2\u0001\u0010-\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020)2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072n\u0010\u0012\u001aj\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010+j\u0004\u0018\u0001`,H\u0002Jd\u0010.\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u0010/\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u00100\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u00101\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u00102\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jl\u00104\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u00020\n2>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jl\u00106\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00105\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016J\\\u00107\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u00108\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u00109\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016J\u0081\u0001\u0010>\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010:\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072S\u0010\u0012\u001aO\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dj\u0004\u0018\u0001`=H\u0016Jy\u0010?\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072S\u0010\u0012\u001aO\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dj\u0004\u0018\u0001`=H\u0016J\u0014\u0010@\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u008e\u0001\u0010B\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072h\u0010\u0012\u001ad\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010+j\u0004\u0018\u0001`AH\u0016J\u008e\u0001\u0010C\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072h\u0010\u0012\u001ad\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010+j\u0004\u0018\u0001`AH\u0016J\u009a\u0001\u0010D\u001a\u00020\u00102\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020)2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072n\u0010\u0012\u001aj\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010+j\u0004\u0018\u0001`,H\u0016Jd\u0010E\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jl\u0010G\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010F\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u0010H\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u0010I\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u0010J\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jl\u0010K\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010F\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jl\u0010M\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016Jd\u0010N\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072>\u0010\u0012\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0011H\u0016J\u0012\u0010O\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010P\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010T\u001a\u00020\u00102\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u001b0Qj\b\u0012\u0004\u0012\u00020\u001b`RH\u0016J\u001a\u0010W\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010V\u001a\u00020UH\u0016J\u0012\u0010X\u001a\u00020\u00102\b\u0010V\u001a\u0004\u0018\u00010UH\u0016R\u0014\u0010Y\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b[\u0010ZR\u0014\u0010\\\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b`\u0010]R\u0014\u0010a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\ba\u0010]R\u0014\u0010b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bb\u0010]R\u0014\u0010c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bc\u0010]RU\u0010i\u001a<\u00128\u00126\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u0002`\u00110d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0085\u0001\u0010l\u001al\u0012h\u0012f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0)\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100+j\u0002`,0d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010f\u001a\u0004\bk\u0010hRj\u0010o\u001aQ\u0012M\u0012K\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u00100\u001dj\u0002`=0d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010f\u001a\u0004\bn\u0010hR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010r\u00a8\u0006v"}, d2 = {"Lcom/tencent/qqnt/troop/TroopInfoRepo;", "Lcom/tencent/qqnt/troop/ITroopInfoRepoApi;", "", "troopUin", "", "serviceType", "from", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "callback", "Lcom/tencent/qqnt/troop/filter/a;", "filter", "innerFetchTroopBasicInfo", "Lkotlin/Function0;", "task", "fetchBasicInfoWithFrequencyControl", "T", "log", "", "groupCode", "Lkotlin/Function3;", "errCode", "errMsg", "result", "onRsp", "doFetch", "troopInfo", "doUpdate", "Lcom/tencent/qqnt/report/m;", "createReport", "commonFetchSubInfo", "innerGetTroopInfoFromCache", "", "troopUinList", "Lkotlin/Function4;", "Lcom/tencent/qqnt/troop/FetchTroopPrivilegeListCallback;", "fetchTroopPrivilegeFlag", "fetchTroopBasicInfo", "fetchLowCreditTroopBasicInfo", "fetchTroopBasicInfoWithExt", "fetchTroopInfoForAIO", "fetchTroopInfoForMaskChanged", "needPrivilege", "fetchTroopInfoForJoinTroop", "isFromMsg0x26", "fetchTroopClassType", "fetchTroopTags", "fetchTroopCredit", "fetchTroopClassTypeForGuest", "isMember", "code", "info", "Lcom/tencent/qqnt/troop/FetchTroopDetailInfoCallback;", "fetchTroopInfoForBatch", "fetchTroopInfoForNoAuthMemberLimit", "getTroopInfoFromCache", "Lcom/tencent/qqnt/troop/FetchTroopPrivilegeCallback;", "fetchTroopPayPrivilege", "fetchTroopPhotoPrivilege", "fetchTroopCreateTroopPrivilegeFlag", "fetchTroopSeqAndJoinTime", "isTroopMember", "fetchTroopMaxAdminNum", "fetchTroopMemberNumForJoin", "fetchTroopSpeechLimitFreq", "fetchTroopPayEnterStatus", "fetchTroopJoinType", "forceNet", "fetchTroopInfoExt", "fetchTroopInfoForGameCard", "getTroopNameForPush", "checkTroopHasAvatarFromMMKV", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groupCodeList", "batchFetchTroopBasicInfo", "Lcom/tencent/qqnt/troop/ab;", "observer", "registerTroopInfoChangedObserver", "unregisterTroopInfoChangedObserver", "TAG", "Ljava/lang/String;", "BASIC_INFO_CONFIG_ID", "BASIC_INFO_MAX_REQUEST_SIZE", "I", "BASIC_INFO_REQUEST_DELAY", "J", "SERVICE_TYPE_TROOP_MEMBER", "SERVICE_TYPE_LOW_CREDIT", "SERVICE_TYPE_TROOP_CARD_FOR_GUEST", "SERVICE_TYPE_FOR_GUEST", "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "fetchTroopInfoCallbacks$delegate", "Lkotlin/Lazy;", "getFetchTroopInfoCallbacks", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "fetchTroopInfoCallbacks", "fetchPrivilegeFlagCallback$delegate", "getFetchPrivilegeFlagCallback", "fetchPrivilegeFlagCallback", "fetchDetailInfoCallback$delegate", "getFetchDetailInfoCallback", "fetchDetailInfoCallback", "Lcom/tencent/qqnt/inner/b;", "basicInfoRequestFrequencyControl", "Lcom/tencent/qqnt/inner/b;", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopInfoRepo implements ITroopInfoRepoApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String BASIC_INFO_CONFIG_ID = "102754";
    private static final int BASIC_INFO_MAX_REQUEST_SIZE = 3;
    private static final long BASIC_INFO_REQUEST_DELAY = 10000;

    @NotNull
    public static final TroopInfoRepo INSTANCE;
    private static final int SERVICE_TYPE_FOR_GUEST = 111;
    private static final int SERVICE_TYPE_LOW_CREDIT = 19;
    private static final int SERVICE_TYPE_TROOP_CARD_FOR_GUEST = 110;
    private static final int SERVICE_TYPE_TROOP_MEMBER = 0;

    @NotNull
    private static final String TAG = "TroopInfoRepo";

    @NotNull
    private static final com.tencent.qqnt.inner.b basicInfoRequestFrequencyControl;

    /* renamed from: fetchDetailInfoCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy fetchDetailInfoCallback;

    /* renamed from: fetchPrivilegeFlagCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy fetchPrivilegeFlagCallback;

    /* renamed from: fetchTroopInfoCallbacks$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy fetchTroopInfoCallbacks;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/troop/TroopInfoRepo$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGroupDetailInfoCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "result", "", "onResult", "a", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/qqnt/troop/filter/a;", "b", "Lcom/tencent/qqnt/troop/filter/a;", "getFilter", "()Lcom/tencent/qqnt/troop/filter/a;", "filter", "c", "I", "getCallbackId", "()I", "callbackId", "Lcom/tencent/qqnt/report/m;", "d", "Lcom/tencent/qqnt/report/m;", "getReport", "()Lcom/tencent/qqnt/report/m;", "report", "e", "getLogStr", "logStr", "f", "getFrom", "from", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/troop/filter/a;ILcom/tencent/qqnt/report/m;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements IGroupDetailInfoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String troopUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.troop.filter.a filter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int callbackId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.report.m report;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String logStr;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String from;

        public a(@Nullable String str, @NotNull com.tencent.qqnt.troop.filter.a filter, int i3, @NotNull com.tencent.qqnt.report.m report, @NotNull String logStr, @NotNull String from) {
            Intrinsics.checkNotNullParameter(filter, "filter");
            Intrinsics.checkNotNullParameter(report, "report");
            Intrinsics.checkNotNullParameter(logStr, "logStr");
            Intrinsics.checkNotNullParameter(from, "from");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, filter, Integer.valueOf(i3), report, logStr, from);
                return;
            }
            this.troopUin = str;
            this.filter = filter;
            this.callbackId = i3;
            this.report = report;
            this.logStr = logStr;
            this.from = from;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(final a this$0, final int i3, GroupDetailInfo result, String errMsg) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(result, "$result");
            Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
            final TroopInfo innerGetTroopInfoFromCache = TroopInfoRepo.INSTANCE.innerGetTroopInfoFromCache(this$0.troopUin);
            if (com.tencent.qqnt.e.d(i3)) {
                final TroopInfo b16 = this$0.filter.b(this$0.troopUin, result, innerGetTroopInfoFromCache);
                ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
                if (e16 != null) {
                    e16.onDetailInfoUpdate(b16);
                }
                com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopInfoRepo.a.e(TroopInfoRepo.a.this, b16, i3);
                    }
                });
            } else {
                com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.ar
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopInfoRepo.a.f(TroopInfoRepo.a.this, innerGetTroopInfoFromCache, i3);
                    }
                });
            }
            com.tencent.qqnt.report.m.c(this$0.report, Integer.valueOf(i3), null, errMsg, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(a this$0, TroopInfo troopInfo, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
            TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
            Function2 function2 = (Function2) troopInfoRepo.getFetchTroopInfoCallbacks().f(this$0.callbackId);
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, troopInfo);
            }
            Function3 function3 = (Function3) troopInfoRepo.getFetchDetailInfoCallback().f(this$0.callbackId);
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, Integer.valueOf(i3), troopInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(a this$0, TroopInfo troopInfo, int i3) {
            TroopInfo troopInfo2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
            Function2 function2 = (Function2) troopInfoRepo.getFetchTroopInfoCallbacks().f(this$0.callbackId);
            if (function2 != null) {
                Boolean bool = Boolean.FALSE;
                if (troopInfo == null) {
                    troopInfo2 = new TroopInfo(this$0.troopUin);
                } else {
                    troopInfo2 = troopInfo;
                }
                function2.invoke(bool, troopInfo2);
            }
            Function3 function3 = (Function3) troopInfoRepo.getFetchDetailInfoCallback().f(this$0.callbackId);
            if (function3 != null) {
                Boolean bool2 = Boolean.FALSE;
                Integer valueOf = Integer.valueOf(i3);
                if (troopInfo == null) {
                    troopInfo = new TroopInfo(this$0.troopUin);
                }
                function3.invoke(bool2, valueOf, troopInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback
        public void onResult(final int errCode, @NotNull final String errMsg, @NotNull final GroupDetailInfo result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(errCode), errMsg, result);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(result, "result");
            this.report.f();
            QLog.i(TroopInfoRepo.TAG, 1, "FetchByFilterCallback [" + this.logStr + "] from:" + this.from + ", errCode:" + errCode + ", errMsg:" + errMsg);
            com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.ap
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoRepo.a.d(TroopInfoRepo.a.this, errCode, result, errMsg);
                }
            }, 1, null);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        INSTANCE = new TroopInfoRepo();
        lazy = LazyKt__LazyJVMKt.lazy(TroopInfoRepo$fetchTroopInfoCallbacks$2.INSTANCE);
        fetchTroopInfoCallbacks = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopInfoRepo$fetchPrivilegeFlagCallback$2.INSTANCE);
        fetchPrivilegeFlagCallback = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(TroopInfoRepo$fetchDetailInfoCallback$2.INSTANCE);
        fetchDetailInfoCallback = lazy3;
        basicInfoRequestFrequencyControl = new com.tencent.qqnt.inner.b(TAG, BASIC_INFO_CONFIG_ID, 3, 10000L);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.troop.ak
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo._init_$lambda$0();
            }
        }, 16, null, false);
    }

    TroopInfoRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> void commonFetchSubInfo(String log, String troopUin, String from, LifecycleOwner lifecycleOwner, Function2<? super Boolean, ? super TroopInfo, Unit> callback, Function2<? super Long, ? super Function3<? super Integer, ? super String, ? super T, Unit>, Unit> doFetch, Function2<? super TroopInfo, ? super T, Unit> doUpdate, Function0<com.tencent.qqnt.report.m> createReport) {
        Long l3;
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            doFetch.invoke(l3, new TroopInfoRepo$commonFetchSubInfo$1(createReport.invoke(), troopUin, doUpdate, getFetchTroopInfoCallbacks().h(lifecycleOwner, callback)));
            return;
        }
        QLog.e(TAG, 2, log + ": troop code empty, from=" + from);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    private final void fetchBasicInfoWithFrequencyControl(String troopUin, Function2<? super Boolean, ? super TroopInfo, Unit> callback, Function0<Unit> task) {
        if (callback == null && troopUin != null) {
            basicInfoRequestFrequencyControl.d(troopUin, task);
        } else {
            task.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopCredit$lambda$13(final com.tencent.qqnt.report.m report, final String str, final String uniqueFrom, final int i3, final com.tencent.qqnt.troop.filter.g filter, final int i16, final String str2, final GroupDetailInfo groupDetailInfo) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(filter, "$filter");
        report.f();
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.ai
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo.fetchTroopCredit$lambda$13$lambda$12(str, uniqueFrom, i16, str2, groupDetailInfo, i3, report, filter);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopCredit$lambda$13$lambda$12(final String str, String uniqueFrom, int i3, String str2, GroupDetailInfo groupDetailInfo, int i16, com.tencent.qqnt.report.m report, com.tencent.qqnt.troop.filter.g filter) {
        Intrinsics.checkNotNullParameter(uniqueFrom, "$uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(filter, "$filter");
        QLog.i(TAG, 1, "[fetchTroopCredit] troopUin:" + str + ", from:" + uniqueFrom + ", errCode:" + i3 + ", errMsg:" + str2);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 1, "[fetchTroopCredit] from:" + uniqueFrom + ", result:" + groupDetailInfo);
        }
        TroopInfoRepo troopInfoRepo = INSTANCE;
        final TroopInfo innerGetTroopInfoFromCache = troopInfoRepo.innerGetTroopInfoFromCache(str);
        if (com.tencent.qqnt.e.d(i3) && innerGetTroopInfoFromCache != null) {
            filter.d(innerGetTroopInfoFromCache);
            final Function2<Boolean, TroopInfo, Unit> f16 = troopInfoRepo.getFetchTroopInfoCallbacks().f(i16);
            if (f16 != null) {
                com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopInfoRepo.fetchTroopCredit$lambda$13$lambda$12$lambda$11$lambda$10(Function2.this, innerGetTroopInfoFromCache);
                    }
                });
            }
            com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str2, 2, null);
            return;
        }
        final Function2<Boolean, TroopInfo, Unit> f17 = troopInfoRepo.getFetchTroopInfoCallbacks().f(i16);
        if (f17 != null) {
            com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.ac
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoRepo.fetchTroopCredit$lambda$13$lambda$12$lambda$9$lambda$8(Function2.this, innerGetTroopInfoFromCache, str);
                }
            });
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str2, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopCredit$lambda$13$lambda$12$lambda$11$lambda$10(Function2 it, TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(it, "$it");
        it.invoke(Boolean.TRUE, troopInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopCredit$lambda$13$lambda$12$lambda$9$lambda$8(Function2 it, TroopInfo troopInfo, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Boolean bool = Boolean.FALSE;
        if (troopInfo == null) {
            troopInfo = new TroopInfo(str);
        }
        it.invoke(bool, troopInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopInfoForAIO$lambda$5(final String str, final Function2 function2, final String from, final LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(from, "$from");
        INSTANCE.fetchBasicInfoWithFrequencyControl(str, function2, new Function0<Unit>(str, from, lifecycleOwner, function2) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopInfoForAIO$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
            final /* synthetic */ String $from;
            final /* synthetic */ LifecycleOwner $lifecycleOwner;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$troopUin = str;
                this.$from = from;
                this.$lifecycleOwner = lifecycleOwner;
                this.$callback = function2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, from, lifecycleOwner, function2);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopInfo troopInfoFromCache;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
                troopInfoRepo.innerFetchTroopBasicInfo(this.$troopUin, 0, this.$from, this.$lifecycleOwner, this.$callback, com.tencent.qqnt.troop.filter.d.f362709b);
                TroopListRepo.INSTANCE.fetchTroopLevelInfoForEnterAIO(this.$troopUin);
                String str2 = this.$troopUin;
                if (str2 == null || (troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(str2)) == null || troopInfoFromCache.hadInitExt) {
                    return;
                }
                troopInfoRepo.fetchTroopInfoExt(str2, false, "fetchTroopInfoForAIO", null, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void fetchTroopPrivilegeFlag(List<String> troopUinList, int serviceType, final String from, LifecycleOwner lifecycleOwner, Function4<? super Boolean, ? super Integer, ? super String, ? super List<? extends TroopInfo>, Unit> callback) {
        List listOf;
        Long l3;
        final ArrayList<Long> arrayList = new ArrayList<>();
        for (String str : troopUinList) {
            if (str != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            } else {
                l3 = null;
            }
            if (l3 != null) {
                arrayList.add(l3);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.e(TAG, 2, "fetchTroopLevelInfo: troop code empty, troopUinList=" + troopUinList + ", from=" + from);
            if (callback != 0) {
                Boolean bool = Boolean.FALSE;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new TroopInfo(""));
                callback.invoke(bool, -1, "", listOf);
                return;
            }
            return;
        }
        final int h16 = getFetchPrivilegeFlagCallback().h(lifecycleOwner, callback);
        com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
        final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getAllGroupPrivilegeFlag", "", TAG, false, false, 24, null);
        if (b16 != null) {
            b16.getAllGroupPrivilegeFlag(arrayList, serviceType, new IGroupPrivilegeFlagCallback() { // from class: com.tencent.qqnt.troop.ah
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupPrivilegeFlagCallback
                public final void onResult(int i3, String str2, GroupPrivilegeFlagRsp groupPrivilegeFlagRsp) {
                    TroopInfoRepo.fetchTroopPrivilegeFlag$lambda$16(com.tencent.qqnt.report.m.this, from, arrayList, h16, i3, str2, groupPrivilegeFlagRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopPrivilegeFlag$lambda$16(final com.tencent.qqnt.report.m report, String from, ArrayList groupCodeList, final int i3, final int i16, final String str, GroupPrivilegeFlagRsp groupPrivilegeFlagRsp) {
        long j3;
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(groupCodeList, "$groupCodeList");
        report.f();
        QLog.i(TAG, 1, "[fetchTroopPrivilegeFlag] from:" + from + ", errCode:" + i16 + ", errMsg:" + str + ", result:" + groupPrivilegeFlagRsp);
        final ArrayList arrayList = new ArrayList();
        Iterator it = groupCodeList.iterator();
        while (it.hasNext()) {
            Long l3 = (Long) it.next();
            Integer num = groupPrivilegeFlagRsp.groupInfoMap.get(l3);
            TroopInfo troopInfoFromCache = INSTANCE.getTroopInfoFromCache(String.valueOf(l3.longValue()));
            if (troopInfoFromCache == null) {
                troopInfoFromCache = new TroopInfo(String.valueOf(l3.longValue()));
            }
            if (num != null) {
                j3 = num.intValue();
            } else {
                j3 = 0;
            }
            troopInfoFromCache.troopPrivilegeFlag = j3;
            arrayList.add(troopInfoFromCache);
        }
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.aj
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo.fetchTroopPrivilegeFlag$lambda$16$lambda$15(i3, i16, str, arrayList, report);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopPrivilegeFlag$lambda$16$lambda$15(int i3, int i16, String errMsg, List troopInfoResult, com.tencent.qqnt.report.m report) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopInfoResult, "$troopInfoResult");
        Intrinsics.checkNotNullParameter(report, "$report");
        Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit> f16 = INSTANCE.getFetchPrivilegeFlagCallback().f(i3);
        if (f16 != null) {
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            Integer valueOf2 = Integer.valueOf(i16);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            f16.invoke(valueOf, valueOf2, errMsg, troopInfoResult);
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i16), null, errMsg, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopTags$lambda$7(Function2 function2) {
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function3<Boolean, Integer, TroopInfo, Unit>> getFetchDetailInfoCallback() {
        return (TroopLifecycleCallback) fetchDetailInfoCallback.getValue();
    }

    private final TroopLifecycleCallback<Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>> getFetchPrivilegeFlagCallback() {
        return (TroopLifecycleCallback) fetchPrivilegeFlagCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopLifecycleCallback<Function2<Boolean, TroopInfo, Unit>> getFetchTroopInfoCallbacks() {
        return (TroopLifecycleCallback) fetchTroopInfoCallbacks.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void innerFetchTroopBasicInfo(final String troopUin, int serviceType, final String from, LifecycleOwner lifecycleOwner, Function2<? super Boolean, ? super TroopInfo, Unit> callback, final com.tencent.qqnt.troop.filter.a filter) {
        Long l3;
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        final Long l16 = l3;
        if (l16 != null && l16.longValue() != 0) {
            final int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            com.tencent.qqnt.kernel.api.s b16 = com.tencent.qqnt.f.f356721a.b();
            GroupDetailInfoReq e16 = filter.e(l16.longValue());
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-" + serviceType, troopUin, "TroopInfoRepo-" + from, false, false, 24, null);
            if (b16 != null) {
                b16.getGroupDetailInfoByFilter(e16, serviceType, 0, true, new IGroupDetailInfoCallback() { // from class: com.tencent.qqnt.troop.ae
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback
                    public final void onResult(int i3, String str, GroupDetailInfo groupDetailInfo) {
                        TroopInfoRepo.innerFetchTroopBasicInfo$lambda$4(com.tencent.qqnt.report.m.this, troopUin, from, filter, l16, h16, i3, str, groupDetailInfo);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "fetchTroopLevelInfo: troop code null, troopCode=" + troopUin + ", from=" + from);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerFetchTroopBasicInfo$lambda$4(final com.tencent.qqnt.report.m report, final String str, final String from, final com.tencent.qqnt.troop.filter.a filter, final Long l3, final int i3, final int i16, final String str2, final GroupDetailInfo groupDetailInfo) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(filter, "$filter");
        com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.ad
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo.innerFetchTroopBasicInfo$lambda$4$lambda$3(com.tencent.qqnt.report.m.this, i16, str, from, groupDetailInfo, str2, filter, l3, i3);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerFetchTroopBasicInfo$lambda$4$lambda$3(com.tencent.qqnt.report.m report, int i3, String str, String from, GroupDetailInfo result, String str2, com.tencent.qqnt.troop.filter.a filter, final Long l3, final int i16) {
        Intrinsics.checkNotNullParameter(report, "$report");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(filter, "$filter");
        report.f();
        if (i3 != 0) {
            QLog.e(TAG, 1, "innerFetchTroopBasicInfo: troopUin=" + str + ", from=" + from + ", result=" + com.tencent.mobileqq.troop.utils.ai.f302012a.a(result) + ", errMsg=" + str2);
        } else {
            QLog.d(TAG, 2, "innerFetchTroopBasicInfo: troopUin=" + str + ", from=" + from + ", result=" + com.tencent.mobileqq.troop.utils.ai.f302012a.a(result) + ", errMsg=" + str2);
        }
        final TroopInfo innerGetTroopInfoFromCache = INSTANCE.innerGetTroopInfoFromCache(str);
        if (innerGetTroopInfoFromCache == null) {
            QLog.e(TAG, 1, "fetchTroopBasicInfo: origin troop info null");
        }
        if (i3 == 0) {
            com.tencent.qqnt.inner.compator.troopinfo.b bVar = new com.tencent.qqnt.inner.compator.troopinfo.b();
            bVar.c(innerGetTroopInfoFromCache);
            long longValue = l3.longValue();
            Intrinsics.checkNotNullExpressionValue(result, "result");
            final TroopInfo c16 = filter.c(longValue, result, innerGetTroopInfoFromCache);
            filter.d(c16);
            ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
            if (e16 != null) {
                e16.onDetailInfoUpdate(c16);
            }
            bVar.b(c16);
            com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.an
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoRepo.innerFetchTroopBasicInfo$lambda$4$lambda$3$lambda$1(i16, c16);
                }
            });
        } else {
            com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.ao
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoRepo.innerFetchTroopBasicInfo$lambda$4$lambda$3$lambda$2(i16, innerGetTroopInfoFromCache, l3);
                }
            });
        }
        com.tencent.qqnt.report.m.c(report, Integer.valueOf(i3), null, str2, 2, null);
        basicInfoRequestFrequencyControl.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerFetchTroopBasicInfo$lambda$4$lambda$3$lambda$1(int i3, TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        Function2<Boolean, TroopInfo, Unit> f16 = INSTANCE.getFetchTroopInfoCallbacks().f(i3);
        if (f16 != null) {
            f16.invoke(Boolean.TRUE, troopInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void innerFetchTroopBasicInfo$lambda$4$lambda$3$lambda$2(int i3, TroopInfo troopInfo, Long l3) {
        Function2<Boolean, TroopInfo, Unit> f16 = INSTANCE.getFetchTroopInfoCallbacks().f(i3);
        if (f16 != null) {
            Boolean bool = Boolean.FALSE;
            if (troopInfo == null) {
                troopInfo = new TroopInfo(l3.longValue());
            }
            f16.invoke(bool, troopInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopInfo innerGetTroopInfoFromCache(String troopUin) {
        Long l3;
        Map<Long, TroopInfo> map;
        String str;
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
            if (e16 != null) {
                map = e16.getCacheMap();
            } else {
                map = null;
            }
            if (map == null) {
                QLog.e(TAG, 2, "getTroopInfoFromCache: cache map null, troopCode=" + troopUin);
                return null;
            }
            TroopInfo troopInfo = map.get(l3);
            if (troopInfo != null) {
                str = troopInfo.getTroopUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, troopUin)) {
                return null;
            }
            return map.get(l3);
        }
        QLog.e(TAG, 2, "getTroopInfoFromCache: troop code null, troopCode=" + troopUin);
        return null;
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void batchFetchTroopBasicInfo(@NotNull ArrayList<Long> groupCodeList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) groupCodeList);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCodeList, "groupCodeList");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "batchFetchTroopBasicInfo: groupCodeList.size=" + groupCodeList.size());
        }
        BatchQueryCachedGroupDetailInfoReq batchQueryCachedGroupDetailInfoReq = new BatchQueryCachedGroupDetailInfoReq();
        batchQueryCachedGroupDetailInfoReq.groupCodes = groupCodeList;
        com.tencent.qqnt.f fVar = com.tencent.qqnt.f.f356721a;
        com.tencent.qqnt.kernel.api.s b16 = fVar.b();
        if (b16 != null) {
            b16.batchQueryCachedGroupDetailInfo(batchQueryCachedGroupDetailInfoReq, null);
        }
        com.tencent.qqnt.kernel.api.s b17 = fVar.b();
        if (b17 != null) {
            b17.getGroupExtList(false, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public boolean checkTroopHasAvatarFromMMKV(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) troopUin)).booleanValue();
        }
        return com.tencent.qqnt.troop.inner.a.f362725a.a(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchLowCreditTroopBasicInfo(@Nullable final String troopUin, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchBasicInfoWithFrequencyControl(troopUin, callback, new Function0<Unit>(troopUin, from, lifecycleOwner, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchLowCreditTroopBasicInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
                final /* synthetic */ String $from;
                final /* synthetic */ LifecycleOwner $lifecycleOwner;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    this.$lifecycleOwner = lifecycleOwner;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, from, lifecycleOwner, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoRepo.INSTANCE.innerFetchTroopBasicInfo(this.$troopUin, 19, this.$from, this.$lifecycleOwner, this.$callback, com.tencent.qqnt.troop.filter.b.f362707b);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopBasicInfo(@Nullable final String troopUin, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchBasicInfoWithFrequencyControl(troopUin, callback, new Function0<Unit>(troopUin, from, lifecycleOwner, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopBasicInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
                final /* synthetic */ String $from;
                final /* synthetic */ LifecycleOwner $lifecycleOwner;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    this.$lifecycleOwner = lifecycleOwner;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, from, lifecycleOwner, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoRepo.INSTANCE.innerFetchTroopBasicInfo(this.$troopUin, 0, this.$from, this.$lifecycleOwner, this.$callback, com.tencent.qqnt.troop.filter.b.f362707b);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopBasicInfoWithExt(@Nullable final String troopUin, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchBasicInfoWithFrequencyControl(troopUin, callback, new Function0<Unit>(troopUin, from, lifecycleOwner, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopBasicInfoWithExt$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
                final /* synthetic */ String $from;
                final /* synthetic */ LifecycleOwner $lifecycleOwner;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    this.$lifecycleOwner = lifecycleOwner;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, from, lifecycleOwner, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoRepo.INSTANCE.innerFetchTroopBasicInfo(this.$troopUin, 0, this.$from, this.$lifecycleOwner, this.$callback, com.tencent.qqnt.troop.filter.c.f362708b);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopClassType(@Nullable final String troopUin, final boolean isFromMsg0x26, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, Boolean.valueOf(isFromMsg0x26), from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i(TAG, 1, "[fetchTroopClassType] troopUin:" + troopUin + ", isFromMsg0x26:" + isFromMsg0x26 + ", from:" + from);
        fetchBasicInfoWithFrequencyControl(troopUin, callback, new Function0<Unit>(troopUin, from, lifecycleOwner, isFromMsg0x26, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopClassType$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
            final /* synthetic */ String $from;
            final /* synthetic */ boolean $isFromMsg0x26;
            final /* synthetic */ LifecycleOwner $lifecycleOwner;
            final /* synthetic */ String $troopUin;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/troop/TroopInfoRepo$fetchTroopClassType$1$a", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements Function2<Boolean, TroopInfo, Unit> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f362396d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f362397e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Function2<Boolean, TroopInfo, Unit> f362398f;

                /* JADX WARN: Multi-variable type inference failed */
                a(String str, String str2, Function2<? super Boolean, ? super TroopInfo, Unit> function2) {
                    this.f362396d = str;
                    this.f362397e = str2;
                    this.f362398f = function2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, str2, function2);
                    }
                }

                public void a(boolean isSuccess, @NotNull TroopInfo data) {
                    BusinessHandler businessHandler;
                    TroopInfoHandler troopInfoHandler;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(data, "data");
                    QLog.i("TroopInfoRepo", 1, "[fetchTroopClassType] troopUin:" + this.f362396d + ", from:" + this.f362397e + ", errCode:" + isSuccess + ", data=" + data);
                    Function2<Boolean, TroopInfo, Unit> function2 = this.f362398f;
                    if (function2 != null) {
                        function2.invoke(Boolean.valueOf(isSuccess), data);
                    }
                    AppInterface e16 = com.tencent.mobileqq.troop.utils.bg.e();
                    if (e16 != null && (businessHandler = e16.getBusinessHandler(TroopInfoHandler.class.getName())) != null) {
                        if (businessHandler instanceof TroopInfoHandler) {
                            troopInfoHandler = (TroopInfoHandler) businessHandler;
                        } else {
                            troopInfoHandler = null;
                        }
                        if (troopInfoHandler != null) {
                            int i3 = com.tencent.mobileqq.troop.api.observer.e.TYPE_NOTIFY_UPDATE_TROOP_CLASS_INFO;
                            String str = data.troopuin;
                            Intrinsics.checkNotNullExpressionValue(str, "data.troopuin");
                            troopInfoHandler.notifyUI(i3, true, new Object[]{str});
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                    a(bool.booleanValue(), troopInfo);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$troopUin = troopUin;
                this.$from = from;
                this.$lifecycleOwner = lifecycleOwner;
                this.$isFromMsg0x26 = isFromMsg0x26;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, troopUin, from, lifecycleOwner, Boolean.valueOf(isFromMsg0x26), callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
                String str = this.$troopUin;
                String str2 = this.$from;
                troopInfoRepo.innerFetchTroopBasicInfo(str, 0, str2, this.$lifecycleOwner, new a(str, str2, this.$callback), new com.tencent.qqnt.troop.filter.f(this.$isFromMsg0x26));
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopClassTypeForGuest(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopClassTypeForGuest] troopUin:" + troopUin + ", from:" + o16);
            com.tencent.qqnt.troop.filter.i iVar = new com.tencent.qqnt.troop.filter.i();
            int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            GroupDetailInfoReq e16 = iVar.e(l3.longValue());
            com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-111", troopUin, TAG, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, 111, 0, true, new a(troopUin, iVar, h16, mVar, "fetchTroopClassTypeForGuest", o16));
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "[fetchTroopClassTypeForGuest] troopCode null, troopCode:" + troopUin + ", from:" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopCreateTroopPrivilegeFlag(@NotNull List<String> troopUinList, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable final Function4<? super Boolean, ? super Integer, ? super String, ? super List<? extends TroopInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUinList, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUinList, "troopUinList");
        Intrinsics.checkNotNullParameter(from, "from");
        fetchTroopPrivilegeFlag(troopUinList, 0, from, lifecycleOwner, new Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>(callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopCreateTroopPrivilegeFlag$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, List<? extends TroopInfo> list) {
                invoke(bool.booleanValue(), num.intValue(), str, list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull List<? extends TroopInfo> data) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, data);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(data, "data");
                Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit> function4 = this.$callback;
                if (function4 != null) {
                    function4.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, data);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopCredit(@Nullable final String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        final String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopCredit] troopUin:" + troopUin + ", from:" + o16);
            final com.tencent.qqnt.troop.filter.g gVar = new com.tencent.qqnt.troop.filter.g();
            final int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            GroupDetailInfoReq e16 = gVar.e(l3.longValue());
            final com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-19", troopUin, "TroopInfoRepo-" + from, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, 19, 0, true, new IGroupDetailInfoCallback() { // from class: com.tencent.qqnt.troop.al
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupDetailInfoCallback
                    public final void onResult(int i3, String str, GroupDetailInfo groupDetailInfo) {
                        TroopInfoRepo.fetchTroopCredit$lambda$13(com.tencent.qqnt.report.m.this, troopUin, o16, h16, gVar, i3, str, groupDetailInfo);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "[fetchTroopCredit] troopCode null, troopCode:" + troopUin + ", from:" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoExt(@Nullable final String troopUin, boolean forceNet, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, Boolean.valueOf(forceNet), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopInfoExt", troopUin, from, lifecycleOwner, callback, new TroopInfoRepo$fetchTroopInfoExt$1(forceNet), TroopInfoRepo$fetchTroopInfoExt$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopInfoExt$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupExtInfo", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopInfoExt", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForAIO(@Nullable final String troopUin, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            com.tencent.qqnt.e.h(false, new Runnable() { // from class: com.tencent.qqnt.troop.af
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoRepo.fetchTroopInfoForAIO$lambda$5(troopUin, callback, from, lifecycleOwner);
                }
            }, 1, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForBatch(@Nullable String troopUin, boolean isMember, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function3<? super Boolean, ? super Integer, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, Boolean.valueOf(isMember), from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopInfoForBatch] troopUin:" + troopUin + ", from:" + o16);
            com.tencent.qqnt.troop.filter.e eVar = new com.tencent.qqnt.troop.filter.e(isMember);
            GroupDetailInfoReq e16 = eVar.e(l3.longValue());
            if (!isMember) {
                i3 = 110;
            }
            int i16 = i3;
            int h16 = getFetchDetailInfoCallback().h(lifecycleOwner, callback);
            com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-" + i16, troopUin, TAG, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, i16, 0, true, new a(troopUin, eVar, h16, mVar, "fetchTroopInfoForBatch", o16));
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "[fetchTroopInfoForBatch] troopCode null, troopCode:" + troopUin + ", from:" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, -1, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForGameCard(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopInfoForGameCard] troopUin:" + troopUin);
            com.tencent.qqnt.troop.filter.h hVar = new com.tencent.qqnt.troop.filter.h();
            GroupDetailInfoReq e16 = hVar.e(l3.longValue());
            int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-0", troopUin, "TroopInfoRepo-" + from, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, 0, 0, true, new a(troopUin, hVar, h16, mVar, "fetchTroopInfoForGameCard", from));
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[fetchTroopInfoForGameCard] troop code null, troopCode=" + troopUin + ", from=" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForJoinTroop(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, boolean needPrivilege, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, from, lifecycleOwner, Boolean.valueOf(needPrivilege), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopInfoForJoinTroop] troopUin:" + troopUin + ", needPrivilege:" + needPrivilege + ", from:" + o16);
            com.tencent.qqnt.troop.filter.j jVar = new com.tencent.qqnt.troop.filter.j(needPrivilege);
            GroupDetailInfoReq e16 = jVar.e(l3.longValue());
            int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TroopInfoRepo-");
            sb5.append(from);
            com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-111", troopUin, sb5.toString(), false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, 111, 0, true, new a(troopUin, jVar, h16, mVar, "fetchTroopInfoForJoinTroop", from));
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[fetchTroopInfoForJoinTroop] troop code null, troopCode=" + troopUin + ", from=" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForMaskChanged(@Nullable final String troopUin, @NotNull final String from, @Nullable final LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            fetchBasicInfoWithFrequencyControl(troopUin, callback, new Function0<Unit>(troopUin, from, lifecycleOwner, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopInfoForMaskChanged$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopInfo, Unit> $callback;
                final /* synthetic */ String $from;
                final /* synthetic */ LifecycleOwner $lifecycleOwner;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    this.$lifecycleOwner = lifecycleOwner;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, troopUin, from, lifecycleOwner, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoRepo.INSTANCE.innerFetchTroopBasicInfo(this.$troopUin, 0, this.$from, this.$lifecycleOwner, this.$callback, com.tencent.qqnt.troop.filter.k.f362716b);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopInfoForNoAuthMemberLimit(@Nullable String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function3<? super Boolean, ? super Integer, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        String o16 = com.tencent.qqnt.e.o(from, callback);
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != 0) {
            QLog.i(TAG, 1, "[fetchTroopInfoForNoAuthMemberLimit] troopUin:" + troopUin + ", from:" + o16);
            com.tencent.qqnt.troop.filter.m mVar = new com.tencent.qqnt.troop.filter.m();
            GroupDetailInfoReq e16 = mVar.e(l3.longValue());
            int h16 = getFetchDetailInfoCallback().h(lifecycleOwner, callback);
            com.tencent.qqnt.report.m mVar2 = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-0", troopUin, TAG, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(e16, 0, 0, true, new a(troopUin, mVar, h16, mVar2, "fetchTroopInfoForNoAuthMemberLimit", o16));
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "[fetchTroopInfoForNoAuthMemberLimit] troopCode null, troopCode:" + troopUin + ", from:" + o16);
        if (callback != 0) {
            callback.invoke(Boolean.FALSE, -1, new TroopInfo(""));
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopJoinType(@Nullable final String troopUin, boolean isTroopMember, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopUin, Boolean.valueOf(isTroopMember), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopJoinType", troopUin, from, lifecycleOwner, callback, new TroopInfoRepo$fetchTroopJoinType$1(isTroopMember), TroopInfoRepo$fetchTroopJoinType$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopJoinType$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupInfoForJoinGroup", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopJoinType", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopMaxAdminNum(@Nullable final String troopUin, boolean isTroopMember, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, troopUin, Boolean.valueOf(isTroopMember), from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopMaxAdminNum", troopUin, from, lifecycleOwner, callback, new TroopInfoRepo$fetchTroopMaxAdminNum$1(isTroopMember), TroopInfoRepo$fetchTroopMaxAdminNum$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopMaxAdminNum$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupMemberMaxNum", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopMaxAdminNum", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopMemberNumForJoin(@Nullable final String troopUin, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopMemberNumForJoin", troopUin, from, lifecycleOwner, callback, TroopInfoRepo$fetchTroopMemberNumForJoin$1.INSTANCE, TroopInfoRepo$fetchTroopMemberNumForJoin$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopMemberNumForJoin$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupMemberMaxNum", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopMemberNumForJoin", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPayEnterStatus(@Nullable final String troopUin, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopPayEnterStatus", troopUin, from, lifecycleOwner, callback, TroopInfoRepo$fetchTroopPayEnterStatus$1.INSTANCE, TroopInfoRepo$fetchTroopPayEnterStatus$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopPayEnterStatus$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupPayToJoinStatus", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopPayEnterStatus", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPayPrivilege(@Nullable final String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable final Function4<? super Boolean, ? super Integer, ? super String, ? super TroopInfo, Unit> callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(troopUin);
        fetchTroopPrivilegeFlag(listOf, 111, from, lifecycleOwner, new Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>(troopUin, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopPayPrivilege$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function4<Boolean, Integer, String, TroopInfo, Unit> $callback;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
                this.$troopUin = troopUin;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, List<? extends TroopInfo> list) {
                invoke(bool.booleanValue(), num.intValue(), str, list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull List<? extends TroopInfo> data) {
                Object firstOrNull;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, data);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(data, "data");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data);
                TroopInfo troopInfo = (TroopInfo) firstOrNull;
                if (troopInfo == null) {
                    troopInfo = new TroopInfo(this.$troopUin);
                }
                Function4<Boolean, Integer, String, TroopInfo, Unit> function4 = this.$callback;
                if (function4 != null) {
                    function4.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, troopInfo);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopPhotoPrivilege(@Nullable final String troopUin, @NotNull String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable final Function4<? super Boolean, ? super Integer, ? super String, ? super TroopInfo, Unit> callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, from, lifecycleOwner, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(troopUin);
        fetchTroopPrivilegeFlag(listOf, 0, from, lifecycleOwner, new Function4<Boolean, Integer, String, List<? extends TroopInfo>, Unit>(troopUin, callback) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopPhotoPrivilege$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function4<Boolean, Integer, String, TroopInfo, Unit> $callback;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
                this.$troopUin = troopUin;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, List<? extends TroopInfo> list) {
                invoke(bool.booleanValue(), num.intValue(), str, list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull List<? extends TroopInfo> data) {
                Object firstOrNull;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, data);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(data, "data");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data);
                TroopInfo troopInfo = (TroopInfo) firstOrNull;
                if (troopInfo == null) {
                    troopInfo = new TroopInfo(this.$troopUin);
                }
                Function4<Boolean, Integer, String, TroopInfo, Unit> function4 = this.$callback;
                if (function4 != null) {
                    function4.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, troopInfo);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopSeqAndJoinTime(@Nullable final String troopUin, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopSeqAndJoinTime", troopUin, from, lifecycleOwner, callback, TroopInfoRepo$fetchTroopSeqAndJoinTime$1.INSTANCE, TroopInfoRepo$fetchTroopSeqAndJoinTime$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopSeqAndJoinTime$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupSeqAndJoinTimeForGrayTips", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopSeqAndJoinTime", false, false, 24, null);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopSpeechLimitFreq(@Nullable final String troopUin, @NotNull final String from, @Nullable LifecycleOwner lifecycleOwner, @Nullable Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, troopUin, from, lifecycleOwner, callback);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            commonFetchSubInfo("fetchTroopSpeechLimitFreq", troopUin, from, lifecycleOwner, callback, TroopInfoRepo$fetchTroopSpeechLimitFreq$1.INSTANCE, TroopInfoRepo$fetchTroopSpeechLimitFreq$2.INSTANCE, new Function0<com.tencent.qqnt.report.m>(troopUin, from) { // from class: com.tencent.qqnt.troop.TroopInfoRepo$fetchTroopSpeechLimitFreq$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $from;
                final /* synthetic */ String $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$from = from;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) from);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.qqnt.report.m invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.qqnt.report.m) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return new com.tencent.qqnt.report.m("getGroupMsgLimitFreq", this.$troopUin, "TroopInfoRepo-" + this.$from + "-fetchTroopSpeechLimitFreq", false, false, 24, null);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void fetchTroopTags(@Nullable String troopUin, @Nullable LifecycleOwner lifecycleOwner, @Nullable final Function2<? super Boolean, ? super TroopInfo, Unit> callback) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, lifecycleOwner, callback);
            return;
        }
        if (troopUin != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        } else {
            l3 = null;
        }
        Long l16 = l3;
        if (l16 != null && l16.longValue() != 0) {
            com.tencent.qqnt.troop.filter.l lVar = new com.tencent.qqnt.troop.filter.l();
            int h16 = getFetchTroopInfoCallbacks().h(lifecycleOwner, callback);
            com.tencent.qqnt.report.m mVar = new com.tencent.qqnt.report.m("getGroupDetailInfoByFilter-110", troopUin, TAG, false, false, 24, null);
            com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.e.c();
            if (c16 != null) {
                c16.getGroupDetailInfoByFilter(lVar.e(l16.longValue()), 110, 0, true, new a(troopUin, lVar, h16, mVar, "fetchTroopTags", ""));
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "fetchTroopTags, troopUin is invalid, " + troopUin);
        com.tencent.mobileqq.troop.utils.bg.k(new Runnable() { // from class: com.tencent.qqnt.troop.am
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoRepo.fetchTroopTags$lambda$7(Function2.this);
            }
        });
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    @Nullable
    public TroopInfo getTroopInfoFromCache(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 14, (Object) this, (Object) troopUin);
        }
        return innerGetTroopInfoFromCache(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    @NotNull
    public String getTroopNameForPush(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) troopUin);
        }
        return com.tencent.qqnt.troop.inner.c.f362727a.d(troopUin);
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void registerTroopInfoChangedObserver(@Nullable LifecycleOwner lifecycleOwner, @NotNull ab observer) {
        f dispatcher;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) lifecycleOwner, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
        if (e16 != null && (dispatcher = e16.getDispatcher()) != null) {
            dispatcher.a(lifecycleOwner, observer);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopInfoRepoApi
    public void unregisterTroopInfoChangedObserver(@Nullable ab observer) {
        ITroopInfoInnerService e16;
        f dispatcher;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) observer);
        } else if (observer != null && (e16 = com.tencent.qqnt.f.f356721a.e()) != null && (dispatcher = e16.getDispatcher()) != null) {
            dispatcher.b(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
    }
}
