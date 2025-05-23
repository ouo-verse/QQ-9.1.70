package com.tencent.mobileqq.zplan.aio;

import com.tencent.mobileqq.zplan.aio.IZPlanAioMatcher;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/ZPlanAioMatcher;", "Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher;", "", "initMatchers", "initC2CSet", "initGroupSet", "", "aioType", "type", "Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher$a;", QZoneImageUtils.KEY_MATCH, "", "judgeSupported", "isSupported", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "GROUP_MATCHERS", "Ljava/util/HashMap;", "C2C_MATCHERS", "ALL_MATCHERS", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAioMatcher implements IZPlanAioMatcher {
    private static final HashMap<Integer, IZPlanAioMatcher.a> ALL_MATCHERS;
    private static final HashMap<Integer, IZPlanAioMatcher.a> C2C_MATCHERS;
    private static final HashMap<Integer, IZPlanAioMatcher.a> GROUP_MATCHERS;
    public static final ZPlanAioMatcher INSTANCE;
    private static final String TAG = "[cmshow]CmShowAioMatcher";

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/aio/ZPlanAioMatcher$a", "Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher$a;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements IZPlanAioMatcher.a {
        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/aio/ZPlanAioMatcher$b", "Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher$a;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IZPlanAioMatcher.a {
        b() {
        }
    }

    static {
        ZPlanAioMatcher zPlanAioMatcher = new ZPlanAioMatcher();
        INSTANCE = zPlanAioMatcher;
        GROUP_MATCHERS = new HashMap<>();
        C2C_MATCHERS = new HashMap<>();
        ALL_MATCHERS = new HashMap<>();
        zPlanAioMatcher.initMatchers();
    }

    ZPlanAioMatcher() {
    }

    private final void initC2CSet() {
        C2C_MATCHERS.put(0, new a());
    }

    private final void initGroupSet() {
        GROUP_MATCHERS.put(1, new b());
    }

    private final void initMatchers() {
        initC2CSet();
        initGroupSet();
        for (Map.Entry<Integer, IZPlanAioMatcher.a> entry : C2C_MATCHERS.entrySet()) {
            int intValue = entry.getKey().intValue();
            IZPlanAioMatcher.a value = entry.getValue();
            ALL_MATCHERS.put(Integer.valueOf(intValue), value);
        }
        for (Map.Entry<Integer, IZPlanAioMatcher.a> entry2 : GROUP_MATCHERS.entrySet()) {
            int intValue2 = entry2.getKey().intValue();
            IZPlanAioMatcher.a value2 = entry2.getValue();
            ALL_MATCHERS.put(Integer.valueOf(intValue2), value2);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAioMatcher
    public boolean isSupported(int aioType) {
        return judgeSupported$default(this, aioType, 0, 2, null);
    }

    public final boolean judgeSupported(int i3) {
        return judgeSupported$default(this, i3, 0, 2, null);
    }

    public final IZPlanAioMatcher.a match(int i3) {
        return match$default(this, i3, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.zplan.aio.IZPlanAioMatcher
    public boolean isSupported(int aioType, int type) {
        return judgeSupported(aioType, type);
    }

    public final boolean judgeSupported(int aioType, int type) {
        if (type == 0) {
            return ALL_MATCHERS.containsKey(Integer.valueOf(aioType));
        }
        if (type == 1) {
            return C2C_MATCHERS.containsKey(Integer.valueOf(aioType));
        }
        if (type != 2) {
            return false;
        }
        return GROUP_MATCHERS.containsKey(Integer.valueOf(aioType));
    }

    public final IZPlanAioMatcher.a match(int aioType, int type) {
        if (type == 0) {
            return ALL_MATCHERS.get(Integer.valueOf(aioType));
        }
        if (type == 1) {
            return C2C_MATCHERS.get(Integer.valueOf(aioType));
        }
        if (type != 2) {
            return null;
        }
        return GROUP_MATCHERS.get(Integer.valueOf(aioType));
    }

    public static /* synthetic */ boolean judgeSupported$default(ZPlanAioMatcher zPlanAioMatcher, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        return zPlanAioMatcher.judgeSupported(i3, i16);
    }

    public static /* synthetic */ IZPlanAioMatcher.a match$default(ZPlanAioMatcher zPlanAioMatcher, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        return zPlanAioMatcher.match(i3, i16);
    }
}
