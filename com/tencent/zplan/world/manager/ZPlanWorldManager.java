package com.tencent.zplan.world.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.ue4.UE4;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.luabridge.plugins.FirstFramePlugin;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.ZPlanConstant;
import com.tencent.zplan.utils.e;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.world.model.ZPlanWorld;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import yx4.c;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001yB\t\b\u0002\u00a2\u0006\u0004\bw\u0010xJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J(\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0013J(\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\tJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J(\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J*\u0010&\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J(\u0010(\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010'\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010,\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010+\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u00100\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u00104\u001a\u00020\t2\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\tH\u0002J0\u00106\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002JJ\u0010;\u001a\u00020\t2\u0006\u00107\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010=\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0013H\u0002J\"\u0010?\u001a\u00020>2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010B\u001a\u00020\t2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0002H\u0002J\u0010\u0010E\u001a\u00020\t2\u0006\u0010D\u001a\u00020CH\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010I\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010H\u001a\u00020 H\u0002J\u0010\u0010J\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010L\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010M\u001a\u00020\t2\u0006\u0010D\u001a\u00020CH\u0002J\u0010\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020\fH\u0002J\u0010\u0010P\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010Q\u001a\u00020\tH\u0002J\b\u0010R\u001a\u00020\tH\u0002J\b\u0010S\u001a\u00020\tH\u0002J\b\u0010T\u001a\u00020 H\u0002R\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020C0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020C0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010_R\u0016\u0010h\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010=R\u0014\u0010j\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010WR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010_R\u0014\u0010n\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010=R\u0016\u0010p\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u00106R\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u00106R\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010u\u00a8\u0006z"}, d2 = {"Lcom/tencent/zplan/world/manager/ZPlanWorldManager;", "Lcom/epicgames/ue4/UE4$ParallelWorldListener;", "", "renderHashcode", "scene", "width", "height", "Lcom/tencent/zplan/world/manager/IZPlanWorldListener;", "listener", "", "H", "(IIIILcom/tencent/zplan/world/manager/IZPlanWorldListener;)V", "", ISchemeApi.KEY_SCENE_DATA, "X", "worldID", "Y", "sceneType", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/Surface;", "surface", UserInfo.SEX_FEMALE, "V", "W", "U", "D", "a0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "drawMode", "", "canDrawRenderTarget", "framebuffer", "drawRenderTargetAsFramebuffer", "", "pixels", "drawRenderTargetAsPixels", "bFocused", "onActivated", "onDeactivated", "onInited", "succeeded", "onLoaded", "onKilled", "oldDrawMode", "newDrawMode", "onDrawModeChanged", "onNativeWindowChanged", "oldWorldID", "newWorldID", "onFocusChanged", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "success", "result", "", "time", "L", "callLuaIndex", "Z", "Lorg/json/JSONObject;", "G", "from", "curWorldID", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/lang/Runnable;", "task", HippyTKDListViewAdapter.X, "Lcom/tencent/zplan/world/model/ZPlanWorld;", "J", "tick", "b0", "B", BdhLogUtil.LogTag.Tag_Req, "K", "y", "params", "P", "T", "O", "M", "N", ExifInterface.LATITUDE_SOUTH, "Ljava/util/concurrent/locks/ReentrantLock;", "a", "Ljava/util/concurrent/locks/ReentrantLock;", "worldMapLock", "Lcom/tencent/zplan/world/manager/ZPlanWorldManager$WorldMap;", "b", "Lcom/tencent/zplan/world/manager/ZPlanWorldManager$WorldMap;", "worldMap", "", "c", "Ljava/util/List;", "windowWaitList", "", "d", "Ljava/util/Set;", "destroyHashSet", "e", "getZPlanWorldWaitList", "f", "getZPlanWorlding", "g", "worldPreparedListLock", h.F, "worldPreparedList", "i", "enableKeepWorld", "j", "preloadWorldSceneType", "k", "runningWorldID", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "l", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "worldPlugIn", "<init>", "()V", "WorldMap", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanWorldManager implements UE4.ParallelWorldListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock worldMapLock;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final WorldMap worldMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<Runnable> windowWaitList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Set<Integer> destroyHashSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<Runnable> getZPlanWorldWaitList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean getZPlanWorlding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock worldPreparedListLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final List<Integer> worldPreparedList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableKeepWorld;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int preloadWorldSceneType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int runningWorldID;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final LuaBasePlugin worldPlugIn;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final ZPlanWorldManager f386245m;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0017\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/world/manager/ZPlanWorldManager$WorldMap;", "Ljava/util/HashMap;", "", "Lcom/tencent/zplan/world/model/ZPlanWorld;", "Lkotlin/collections/HashMap;", "c", "sceneKey", "", "containsKey", "value", "put", "get", "remove", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class WorldMap extends HashMap<Integer, ZPlanWorld> {
        private final int c(int i3) {
            if (i3 == 1 || i3 == 2 || i3 == 4) {
                return 1;
            }
            return i3;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Integer) {
                return containsKey(((Number) obj).intValue());
            }
            return false;
        }

        public /* bridge */ boolean containsValue(ZPlanWorld zPlanWorld) {
            return super.containsValue((Object) zPlanWorld);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Integer, ZPlanWorld>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof Integer) {
                return get(((Number) obj).intValue());
            }
            return null;
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ ZPlanWorld getOrDefault(Integer num, ZPlanWorld zPlanWorld) {
            return (ZPlanWorld) super.getOrDefault((Object) num, (Integer) zPlanWorld);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Integer> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put(((Number) obj).intValue(), (ZPlanWorld) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof Integer) {
                return remove(((Number) obj).intValue());
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<ZPlanWorld> values() {
            return getValues();
        }

        public boolean containsKey(int sceneKey) {
            return super.containsKey(Integer.valueOf(c(sceneKey)));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof ZPlanWorld) {
                return containsValue((ZPlanWorld) obj);
            }
            return false;
        }

        @Nullable
        public ZPlanWorld get(int sceneKey) {
            return (ZPlanWorld) super.get(Integer.valueOf(c(sceneKey)));
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof Integer ? getOrDefault((Integer) obj, (ZPlanWorld) obj2) : obj2;
        }

        @Nullable
        public ZPlanWorld put(int sceneKey, @NotNull ZPlanWorld value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (ZPlanWorld) super.put((WorldMap) Integer.valueOf(c(sceneKey)), (Integer) value);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Integer) && (obj2 instanceof ZPlanWorld)) {
                return remove(((Number) obj).intValue(), (ZPlanWorld) obj2);
            }
            return false;
        }

        @Nullable
        public ZPlanWorld remove(int sceneKey) {
            return (ZPlanWorld) super.remove(Integer.valueOf(c(sceneKey)));
        }

        @RequiresApi(24)
        public boolean remove(int sceneKey, @NotNull ZPlanWorld value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return super.remove(Integer.valueOf(c(sceneKey)), value);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$getZPlanWorld$1$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug", "com/tencent/zplan/world/manager/ZPlanWorldManager$$special$$inlined$doOnGetZPlanWorldIdle$lambda$1"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f386300d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f386301e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f386302f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f386303h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f386304i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldListener f386305m;

        b(long j3, int i3, int i16, int i17, int i18, IZPlanWorldListener iZPlanWorldListener) {
            this.f386300d = j3;
            this.f386301e = i3;
            this.f386302f = i16;
            this.f386303h = i17;
            this.f386304i = i18;
            this.f386305m = iZPlanWorldListener;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, @Nullable String result) {
            ZPlanWorldManager.f386245m.L(success, result, this.f386305m, this.f386302f, this.f386303h, this.f386301e, this.f386300d, this.f386304i);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$c", "Lcom/tencent/zplan/world/manager/IZPlanWorldListener;", "Lcom/tencent/zplan/world/model/ZPlanWorld;", "zPlanWorld", "", "onGetZPlanWorld", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements IZPlanWorldListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f386306a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f386307b;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$c$a", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class a implements IZPlanWorldStatusListener {
            a() {
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onEnterSceneResult(boolean success) {
                IZPlanWorldStatusListener.a.a(this, success);
                ZLog.f386189b.k("ZPlanWorldManager", "preloadWorldAndEnterScene, onEnterSceneResult : " + success);
            }

            @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
            public void onFirstFrame(@NotNull FirstFrameResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                IZPlanWorldStatusListener.a.b(this, result);
                ZLog.f386189b.k("ZPlanWorldManager", "preloadWorldAndEnterScene, onFirstFrame : " + result);
            }
        }

        c(int i3, String str) {
            this.f386306a = i3;
            this.f386307b = str;
        }

        @Override // com.tencent.zplan.world.manager.IZPlanWorldListener
        public void onGetZPlanWorld(@Nullable ZPlanWorld zPlanWorld) {
            if (zPlanWorld != null) {
                ZPlanWorldManager.f386245m.C(zPlanWorld.getWorldID(), this.f386306a, this.f386307b, new a());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$d", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "", "event", "Lorg/json/JSONObject;", "params", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements FirstFramePlugin.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386308a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f386309b;

        d(IZPlanWorldStatusListener iZPlanWorldStatusListener, Ref.ObjectRef objectRef) {
            this.f386308a = iZPlanWorldStatusListener;
            this.f386309b = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.zplan.luabridge.plugins.FirstFramePlugin.b
        public void a(@NotNull String event, @NotNull JSONObject params) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(params, "params");
            ZLog.f386189b.k("ZPlanWorldManager", "onHandleEngineFirstFrame, params: " + params + ", listener: " + this.f386308a);
            this.f386308a.onFirstFrame(new FirstFrameResult(params.optInt("ViewType", -1), params.optString("OriginalParams")));
            FirstFramePlugin.a aVar = (FirstFramePlugin.a) this.f386309b.element;
            if (aVar != null) {
                FirstFramePlugin.f385718f.d(aVar);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$e", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "", "getEvents", AdMetricTag.EVENT_NAME, "Lp0/a;", "argument", "handleEvent", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class e extends LuaBasePlugin {
        e() {
        }

        @Override // com.tencent.zplan.luabridge.LuaBasePlugin, p0.d
        @NotNull
        public List<String> getEvents() {
            List<String> listOf;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("L2N_NotifyWorldPrepared");
            return listOf;
        }

        @Override // com.tencent.zplan.luabridge.LuaBasePlugin, p0.d
        @Nullable
        public String handleEvent(@NotNull String eventName, @NotNull p0.a argument) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(argument, "argument");
            if (eventName.hashCode() == 40627695 && eventName.equals("L2N_NotifyWorldPrepared")) {
                ZLog.f386189b.k("ZPlanWorldManager", "handleEvent L2N_NotifyWorldPrepared, " + argument.getF440574c());
                ZPlanWorldManager.f386245m.P(argument.getF440574c());
                return null;
            }
            return null;
        }
    }

    static {
        boolean z16;
        ZPlanWorldManager zPlanWorldManager = new ZPlanWorldManager();
        f386245m = zPlanWorldManager;
        worldMapLock = new ReentrantLock();
        worldMap = new WorldMap();
        windowWaitList = new ArrayList();
        destroyHashSet = new LinkedHashSet();
        getZPlanWorldWaitList = new ArrayList();
        worldPreparedListLock = new ReentrantLock();
        worldPreparedList = new ArrayList();
        zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
        if (dVar != null) {
            z16 = dVar.i();
        } else {
            z16 = false;
        }
        enableKeepWorld = z16;
        preloadWorldSceneType = -1;
        runningWorldID = -1;
        worldPlugIn = new e();
        UE4.ParallelWorld.listener = zPlanWorldManager;
        zPlanWorldManager.Q();
    }

    ZPlanWorldManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(int worldID) {
        if (worldID < 0) {
            return;
        }
        b0(worldID, false);
        if (T(worldID)) {
            ZLog.f386189b.k("ZPlanWorldManager", "destroyZPlanWorld keep world : " + worldID);
            return;
        }
        O();
        ZLog.f386189b.k("ZPlanWorldManager", "destroyZPlanWorld worldID : " + worldID);
        A(worldID);
        K(worldID);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("WorldID", worldID);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "destroyObj.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_DestroyWorld", jSONObject2, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject G(String sceneParams, int worldID, int sceneType) {
        JSONObject jSONObject;
        int andIncrement = ZPlanEngineService.INSTANCE.i().getAndIncrement();
        if (!TextUtils.isEmpty(sceneParams)) {
            jSONObject = new JSONObject(sceneParams);
        } else {
            jSONObject = new JSONObject();
        }
        jSONObject.put("WorldID", worldID);
        jSONObject.put("ViewType", sceneType);
        jSONObject.put("_EnterAvaterIndex_", andIncrement);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I(int scene, int renderHashcode, int width, int height, IZPlanWorldListener listener) {
        ReentrantLock reentrantLock = worldMapLock;
        reentrantLock.lock();
        try {
            ZPlanWorld zPlanWorld = (ZPlanWorld) worldMap.get(Integer.valueOf(scene));
            reentrantLock.unlock();
            if (zPlanWorld == null) {
                return false;
            }
            if (!destroyHashSet.remove(Integer.valueOf(renderHashcode))) {
                zPlanWorld.getRenderHashSet().add(Integer.valueOf(renderHashcode));
            }
            runningWorldID = zPlanWorld.getWorldID();
            if (width > 0 && height > 0 && (zPlanWorld.getWorldWidth() != width || zPlanWorld.getWorldHeight() != height)) {
                Y(zPlanWorld.getWorldID(), width, height);
            }
            listener.onGetZPlanWorld(zPlanWorld);
            getZPlanWorlding = false;
            D();
            ZLog.f386189b.k("ZPlanWorldManager", "getZPlanWorld cacheWorld set getZPlanWorlding false");
            return true;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanWorld J(int worldID) {
        if (worldID < 0) {
            return null;
        }
        ReentrantLock reentrantLock = worldMapLock;
        reentrantLock.lock();
        try {
            for (Map.Entry<Integer, ZPlanWorld> entry : worldMap.entrySet()) {
                entry.getKey().intValue();
                ZPlanWorld value = entry.getValue();
                if (value.getWorldID() == worldID) {
                    ZLog.f386189b.k("ZPlanWorldManager", "getZPlanWorldForCache return : " + value);
                    return value;
                }
            }
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void K(int worldID) {
        ReentrantLock reentrantLock = worldMapLock;
        reentrantLock.lock();
        try {
            Iterator<Map.Entry<Integer, ZPlanWorld>> it = worldMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getWorldID() == worldID) {
                    it.remove();
                    ZLog.f386189b.k("ZPlanWorldManager", "handleClearWorldMap worldID:" + worldID);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(final boolean success, final String result, final IZPlanWorldListener listener, final int width, final int height, final int scene, final long time, final int renderHashcode) {
        Object m476constructorimpl;
        final String str = "handleCreateWorldResult";
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            ZLog zLog = ZLog.f386189b;
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: handleCreateWorldResult");
            zLog.k("ZPlanWorldManager", "createWorld onLuaResult\uff0c success: " + success + ",  result: " + result);
            if (success && !TextUtils.isEmpty(result)) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(new JSONObject(result));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                    ZLog.f386189b.k("ZPlanWorldManager", "createWorld onLuaResult\uff0cresult is not jsonobject");
                    listener.onGetZPlanWorld(null);
                } else {
                    JSONObject jSONObject = new JSONObject();
                    if (Result.m482isFailureimpl(m476constructorimpl)) {
                        m476constructorimpl = jSONObject;
                    }
                    JSONObject jSONObject2 = (JSONObject) m476constructorimpl;
                    if (!jSONObject2.has("WorldID")) {
                        ZLog.f386189b.k("ZPlanWorldManager", "createWorld onLuaResult\uff0cno worldID in result ");
                        listener.onGetZPlanWorld(null);
                    } else {
                        int optInt = jSONObject2.optInt("WorldID");
                        ZPlanWorldManager zPlanWorldManager = f386245m;
                        runningWorldID = optInt;
                        ZPlanWorld zPlanWorld = new ZPlanWorld(optInt, width, height, scene, null, 16, null);
                        ReentrantLock i3 = i(zPlanWorldManager);
                        i3.lock();
                        try {
                            h(zPlanWorldManager).put(scene, zPlanWorld);
                            i3.unlock();
                            if (!j(zPlanWorldManager).contains(Integer.valueOf(optInt))) {
                                ZLog zLog2 = ZLog.f386189b;
                                zLog2.k("ZPlanWorldManager", "createWorld countDownLatch await, " + Thread.currentThread());
                                CountDownLatch countDownLatch = zPlanWorld.getCountDownLatch();
                                if (countDownLatch != null) {
                                    countDownLatch.await();
                                }
                                zLog2.k("ZPlanWorldManager", "createWorld return " + zPlanWorld + ", const " + (System.currentTimeMillis() - time));
                            }
                            ReentrantLock k3 = k(zPlanWorldManager);
                            k3.lock();
                            try {
                                j(zPlanWorldManager).remove(Integer.valueOf(optInt));
                                if (renderHashcode > 0 && !e(zPlanWorldManager).remove(Integer.valueOf(renderHashcode))) {
                                    zPlanWorld.getRenderHashSet().add(Integer.valueOf(renderHashcode));
                                }
                                ZLog zLog3 = ZLog.f386189b;
                                zLog3.k("ZPlanWorldManager", "getZPlanWorld zPlanWorld : " + zPlanWorld);
                                listener.onGetZPlanWorld(zPlanWorld);
                                getZPlanWorlding = false;
                                zLog3.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding false");
                                zPlanWorldManager.D();
                            } finally {
                                k3.unlock();
                            }
                        } catch (Throwable th6) {
                            i3.unlock();
                            throw th6;
                        }
                    }
                }
            } else {
                listener.onGetZPlanWorld(null);
                com.tencent.zplan.utils.e.f386205a.a("[zplan][error]", Integer.valueOf(WeakNetLearner.PROBE_REASON.INVALID_DATA), ZPlanConstant.a.INSTANCE.a().get(Integer.valueOf(WeakNetLearner.PROBE_REASON.INVALID_DATA)));
            }
            ZLog.f386189b.k("ZPlanWorldManager", "doOnWorldThread after task, from: handleCreateWorldResult");
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$handleCreateWorldResult$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Object m476constructorimpl2;
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog4 = ZLog.f386189b;
                zLog4.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                zLog4.k("ZPlanWorldManager", "createWorld onLuaResult\uff0c success: " + success + ",  result: " + result);
                if (success && !TextUtils.isEmpty(result)) {
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        m476constructorimpl2 = Result.m476constructorimpl(new JSONObject(result));
                    } catch (Throwable th7) {
                        Result.Companion companion4 = Result.INSTANCE;
                        m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th7));
                    }
                    if (Result.m479exceptionOrNullimpl(m476constructorimpl2) != null) {
                        ZLog.f386189b.k("ZPlanWorldManager", "createWorld onLuaResult\uff0cresult is not jsonobject");
                        listener.onGetZPlanWorld(null);
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        if (Result.m482isFailureimpl(m476constructorimpl2)) {
                            m476constructorimpl2 = jSONObject3;
                        }
                        JSONObject jSONObject4 = (JSONObject) m476constructorimpl2;
                        if (!jSONObject4.has("WorldID")) {
                            ZLog.f386189b.k("ZPlanWorldManager", "createWorld onLuaResult\uff0cno worldID in result ");
                            listener.onGetZPlanWorld(null);
                        } else {
                            int optInt2 = jSONObject4.optInt("WorldID");
                            ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                            ZPlanWorldManager.runningWorldID = optInt2;
                            ZPlanWorld zPlanWorld2 = new ZPlanWorld(optInt2, width, height, scene, null, 16, null);
                            ReentrantLock i16 = ZPlanWorldManager.i(zPlanWorldManager3);
                            i16.lock();
                            try {
                                ZPlanWorldManager.h(zPlanWorldManager3).put(scene, zPlanWorld2);
                                i16.unlock();
                                if (!ZPlanWorldManager.j(zPlanWorldManager3).contains(Integer.valueOf(optInt2))) {
                                    ZLog zLog5 = ZLog.f386189b;
                                    zLog5.k("ZPlanWorldManager", "createWorld countDownLatch await, " + Thread.currentThread());
                                    CountDownLatch countDownLatch2 = zPlanWorld2.getCountDownLatch();
                                    if (countDownLatch2 != null) {
                                        countDownLatch2.await();
                                    }
                                    zLog5.k("ZPlanWorldManager", "createWorld return " + zPlanWorld2 + ", const " + (System.currentTimeMillis() - time));
                                }
                                ReentrantLock k16 = ZPlanWorldManager.k(zPlanWorldManager3);
                                k16.lock();
                                try {
                                    ZPlanWorldManager.j(zPlanWorldManager3).remove(Integer.valueOf(optInt2));
                                    k16.unlock();
                                    if (renderHashcode > 0 && !ZPlanWorldManager.e(zPlanWorldManager3).remove(Integer.valueOf(renderHashcode))) {
                                        zPlanWorld2.getRenderHashSet().add(Integer.valueOf(renderHashcode));
                                    }
                                    ZLog zLog6 = ZLog.f386189b;
                                    zLog6.k("ZPlanWorldManager", "getZPlanWorld zPlanWorld : " + zPlanWorld2);
                                    listener.onGetZPlanWorld(zPlanWorld2);
                                    ZPlanWorldManager.getZPlanWorlding = false;
                                    zLog6.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding false");
                                    zPlanWorldManager3.D();
                                } catch (Throwable th8) {
                                    k16.unlock();
                                    throw th8;
                                }
                            } catch (Throwable th9) {
                                i16.unlock();
                                throw th9;
                            }
                        }
                    }
                } else {
                    listener.onGetZPlanWorld(null);
                    e.f386205a.a("[zplan][error]", Integer.valueOf(WeakNetLearner.PROBE_REASON.INVALID_DATA), ZPlanConstant.a.INSTANCE.a().get(Integer.valueOf(WeakNetLearner.PROBE_REASON.INVALID_DATA)));
                }
                ZLog.f386189b.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "handleNeedPauseEngine");
        if (UE4.hasEnginePause()) {
            return;
        }
        if (S()) {
            zLog.k("ZPlanWorldManager", "handleNeedPauseEngine, world working, return.");
            return;
        }
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_pause_engine", "pause_engine", null, 4, null);
        zLog.k("ZPlanWorldManager", "handleNeedPauseEngine, pauseEngine");
        UE4.pauseEngine(UE4.getContext());
        zLog.k("ZPlanWorldManager", "handleNeedPauseEngine, pauseEngine end");
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_pause_engine", "pause_engine_end", null, 4, null);
        EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_pause_engine", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        ZLog.f386189b.k("ZPlanWorldManager", "handleNeedPuegeEngine");
        com.tencent.zplan.engine.service.e.f385642b.a(UE4.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        if (!UE4.hasEnginePause()) {
            return;
        }
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_resume_engine", "resume_engine", null, 4, null);
        final Context context = UE4.getContext();
        if (context instanceof Activity) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$handleNeedResumeEngine$1
                @Override // java.lang.Runnable
                public final void run() {
                    ZLog zLog = ZLog.f386189b;
                    zLog.k("ZPlanWorldManager", "handleNeedResumeEngine, resumeEngine");
                    UE4.resumeEngine(context, false);
                    zLog.k("ZPlanWorldManager", "handleNeedResumeEngine, resumeEngine end");
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
        } else {
            ZLog zLog = ZLog.f386189b;
            zLog.k("ZPlanWorldManager", "handleNeedResumeEngine, resumeEngine");
            UE4.resumeEngine(context, false);
            zLog.k("ZPlanWorldManager", "handleNeedResumeEngine, resumeEngine end");
        }
        EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_resume_engine", "resume_engine_end", null, 4, null);
        EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_resume_engine", false, 2, null);
        ZPlanLuaBridge.evaluateWaitList$default(ZPlanLuaBridge.INSTANCE, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(String params) {
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "handleWorldPrepared params : " + params + ", " + Thread.currentThread());
        JSONObject jSONObject = new JSONObject(params);
        if (!jSONObject.has("WorldID")) {
            return;
        }
        int optInt = jSONObject.optInt("WorldID", -1);
        if (optInt < 0) {
            zLog.f("ZPlanWorldManager", "handleWorldPrepared worldID illegal, return");
            return;
        }
        ZPlanWorld J = J(optInt);
        if (J == null) {
            ReentrantLock reentrantLock = worldPreparedListLock;
            reentrantLock.lock();
            try {
                worldPreparedList.add(Integer.valueOf(optInt));
                return;
            } finally {
                reentrantLock.unlock();
            }
        }
        CountDownLatch countDownLatch = J.getCountDownLatch();
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        J.setCountDownLatch(null);
        zLog.k("ZPlanWorldManager", "handleWorldPrepared countDownLatch countDown");
    }

    private final void Q() {
        ZPlanLuaBridge.INSTANCE.registerPlugin(worldPlugIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(int renderHashcode, int worldID) {
        ZPlanWorld J = J(worldID);
        if (J == null) {
            return false;
        }
        J.getRenderHashSet().remove(Integer.valueOf(renderHashcode));
        ZLog.f386189b.k("ZPlanWorldManager", "isWorldUsingAfterRemove zplanWorld:" + J);
        if (J.getRenderHashSet().size() <= 0) {
            return false;
        }
        return true;
    }

    private final boolean S() {
        ReentrantLock reentrantLock = worldMapLock;
        reentrantLock.lock();
        try {
            boolean z16 = false;
            if (!UE4.engineActive) {
                ZLog.f386189b.k("ZPlanWorldManager", "isWorldWorking !engineActive, return.");
                return false;
            }
            for (Map.Entry<Integer, ZPlanWorld> entry : worldMap.entrySet()) {
                entry.getKey().intValue();
                ZPlanWorld value = entry.getValue();
                boolean isTicking = UE4.ParallelWorld.isTicking(value.getWorldID());
                ZLog.f386189b.k("ZPlanWorldManager", "getZPlanWorldState : world : " + value + ", isTicking : " + isTicking);
                if (isTicking) {
                    reentrantLock.unlock();
                    return true;
                }
                z16 = isTicking;
            }
            return z16;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean T(int worldID) {
        if (!enableKeepWorld) {
            return false;
        }
        ReentrantLock reentrantLock = worldMapLock;
        reentrantLock.lock();
        try {
            ZPlanWorld zPlanWorld = (ZPlanWorld) worldMap.get(Integer.valueOf(preloadWorldSceneType));
            if (zPlanWorld == null || zPlanWorld.getWorldID() != worldID) {
                return false;
            }
            ZLog.f386189b.k("ZPlanWorldManager", "destroyZPlanWorld worldID : " + worldID + ", preloadWorldSceneType: " + preloadWorldSceneType + ", preload world, return.");
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, com.tencent.zplan.luabridge.plugins.FirstFramePlugin$a] */
    public final void Z(int worldID, int callLuaIndex, IZPlanWorldStatusListener listener) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        ?? aVar = new FirstFramePlugin.a(callLuaIndex, new d(listener, objectRef), false, 4, null);
        objectRef.element = aVar;
        FirstFramePlugin.f385718f.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int worldID, boolean tick) {
        if (worldID < 0) {
            return;
        }
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "setZPlanWorldticking worldID : " + worldID + ", tick : " + tick);
        if (!UE4.engineActive) {
            zLog.k("ZPlanWorldManager", "setZPlanWorldticking !engineActive, return.");
        } else {
            UE4.ParallelWorld.setTicking(worldID, tick);
        }
    }

    public static final /* synthetic */ Set e(ZPlanWorldManager zPlanWorldManager) {
        return destroyHashSet;
    }

    public static final /* synthetic */ boolean g(ZPlanWorldManager zPlanWorldManager) {
        return getZPlanWorlding;
    }

    public static final /* synthetic */ WorldMap h(ZPlanWorldManager zPlanWorldManager) {
        return worldMap;
    }

    public static final /* synthetic */ ReentrantLock i(ZPlanWorldManager zPlanWorldManager) {
        return worldMapLock;
    }

    public static final /* synthetic */ List j(ZPlanWorldManager zPlanWorldManager) {
        return worldPreparedList;
    }

    public static final /* synthetic */ ReentrantLock k(ZPlanWorldManager zPlanWorldManager) {
        return worldPreparedListLock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Runnable task) {
        List<Runnable> list = getZPlanWorldWaitList;
        synchronized (list) {
            list.add(task);
            ZLog.f386189b.k("ZPlanWorldManager", "addToGetZPlanWorldWaitList, total:" + list.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Runnable task) {
        List<Runnable> list = windowWaitList;
        synchronized (list) {
            list.add(task);
            ZLog.f386189b.k("ZPlanWorldManager", "addToWaitList, total:" + list.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String from, int curWorldID) {
        WorldMap worldMap2 = worldMap;
        if (!worldMap2.isEmpty() && UE4.engineActive) {
            ZLog.f386189b.k("ZPlanWorldManager", "checkNeedPauseOtherWorld : from: " + from + ", curWorldID: " + curWorldID + ", runningWorldID: " + runningWorldID);
            for (Map.Entry<Integer, ZPlanWorld> entry : worldMap2.entrySet()) {
                entry.getKey().intValue();
                ZPlanWorld value = entry.getValue();
                if (value.getWorldID() != curWorldID && value.getWorldID() != runningWorldID && UE4.ParallelWorld.isTicking(value.getWorldID())) {
                    ZLog.f386189b.k("ZPlanWorldManager", "checkNeedPauseOtherWorld : setZPlanWorldTicking false , world : " + value);
                    b0(value.getWorldID(), false);
                }
            }
        }
    }

    public final void A(final int worldID) {
        ZLog zLog = ZLog.f386189b;
        zLog.l("ZPlanWorldManager", "clearWorldTexture worldID:" + worldID + ", ", new StackPrinter("clearWorldTexture"));
        if (worldID < 0) {
            return;
        }
        if (UE4.engineActive) {
            ZPlanWorld J = f386245m.J(worldID);
            zLog.k("ZPlanWorldManager", "clearWorldTexture worldID:" + worldID + ", zPlanWorld: " + J);
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_clear_window", "world_clear_window", null, 4, null);
            if (!UE4.engineActive) {
                zLog.k("ZPlanWorldManager", "clearWorldTexture !engineActive, return.");
                return;
            }
            UE4.ParallelWorld.clearWindow(worldID);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_clear_window", "world_clear_window_end", null, 4, null);
            EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_world_set_window", false, 2, null);
            if (J != null) {
                Surface surface = J.getSurface();
                if (surface != null) {
                    surface.release();
                }
                J.setSurface(null);
                J.setWorldWidth(0);
                J.setWorldHeight(0);
                return;
            }
            return;
        }
        y(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$clearWorldTexture$$inlined$doOnEngineActive$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorld J2 = ZPlanWorldManager.f386245m.J(worldID);
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "clearWorldTexture worldID:" + worldID + ", zPlanWorld: " + J2);
                EngineLifeCycleReporter engineLifeCycleReporter2 = EngineLifeCycleReporter.f385573f;
                EngineLifeCycleReporter.k(engineLifeCycleReporter2, "zplan_world_clear_window", "world_clear_window", null, 4, null);
                if (!UE4.engineActive) {
                    zLog2.k("ZPlanWorldManager", "clearWorldTexture !engineActive, return.");
                    return;
                }
                UE4.ParallelWorld.clearWindow(worldID);
                EngineLifeCycleReporter.k(engineLifeCycleReporter2, "zplan_world_clear_window", "world_clear_window_end", null, 4, null);
                EngineLifeCycleReporter.t(engineLifeCycleReporter2, "zplan_world_set_window", false, 2, null);
                if (J2 != null) {
                    Surface surface2 = J2.getSurface();
                    if (surface2 != null) {
                        surface2.release();
                    }
                    J2.setSurface(null);
                    J2.setWorldWidth(0);
                    J2.setWorldHeight(0);
                }
            }
        });
    }

    public final void C(final int worldID, final int sceneType, @Nullable final String sceneParams, @NotNull final IZPlanWorldStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String str = "enterAvatarScene";
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            ZLog zLog = ZLog.f386189b;
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: enterAvatarScene");
            zLog.k("ZPlanWorldManager", "enterAvatarScene, sceneType : " + sceneType + ", sceneParams : " + sceneParams + ", listener: " + listener);
            if (worldID < 0) {
                listener.onEnterSceneResult(false);
                zLog.f("ZPlanWorldManager", "enterAvatarScene worldID < 0, return");
            } else if (sceneType < 0) {
                listener.onEnterSceneResult(false);
                zLog.f("ZPlanWorldManager", "enterAvatarScene sceneType < 0, return");
            } else {
                zLog.k("ZPlanWorldManager", "enterAvatarScene worldID: " + worldID + ", sceneType : " + sceneType + ", sceneParams : " + sceneParams);
                if (sceneType == 7) {
                    f386245m.z("enterAvatarScene7", worldID);
                }
                ZPlanWorldManager zPlanWorldManager = f386245m;
                JSONObject G = zPlanWorldManager.G(sceneParams, worldID, sceneType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("WorldID", worldID);
                ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "focusObj.toString()");
                a.C10063a.b(zPlanLuaBridge, "N2L_FocusWorld", jSONObject2, null, 4, null);
                String jSONObject3 = G.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "enterObj.toString()");
                zPlanLuaBridge.callLua("N2L_EnterAvatarScene", jSONObject3, new a(jSONObject3, sceneType, sceneParams, listener, worldID));
                int optInt = G.optInt("_EnterAvaterIndex_", -1);
                zLog.k("ZPlanWorldManager", "enterAvatarScene, callLuaIndex: " + optInt);
                zPlanWorldManager.Z(worldID, optInt, listener);
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: enterAvatarScene");
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$enterAvatarScene$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                zLog2.k("ZPlanWorldManager", "enterAvatarScene, sceneType : " + sceneType + ", sceneParams : " + sceneParams + ", listener: " + listener);
                if (worldID < 0) {
                    listener.onEnterSceneResult(false);
                    zLog2.f("ZPlanWorldManager", "enterAvatarScene worldID < 0, return");
                } else if (sceneType < 0) {
                    listener.onEnterSceneResult(false);
                    zLog2.f("ZPlanWorldManager", "enterAvatarScene sceneType < 0, return");
                } else {
                    zLog2.k("ZPlanWorldManager", "enterAvatarScene worldID: " + worldID + ", sceneType : " + sceneType + ", sceneParams : " + sceneParams);
                    if (sceneType == 7) {
                        ZPlanWorldManager.f386245m.z("enterAvatarScene7", worldID);
                    }
                    ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                    JSONObject G2 = zPlanWorldManager3.G(sceneParams, worldID, sceneType);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("WorldID", worldID);
                    ZPlanLuaBridge zPlanLuaBridge2 = ZPlanLuaBridge.INSTANCE;
                    String jSONObject5 = jSONObject4.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject5, "focusObj.toString()");
                    a.C10063a.b(zPlanLuaBridge2, "N2L_FocusWorld", jSONObject5, null, 4, null);
                    String jSONObject6 = G2.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "enterObj.toString()");
                    zPlanLuaBridge2.callLua("N2L_EnterAvatarScene", jSONObject6, new a(jSONObject6, this));
                    int optInt2 = G2.optInt("_EnterAvaterIndex_", -1);
                    zLog2.k("ZPlanWorldManager", "enterAvatarScene, callLuaIndex: " + optInt2);
                    zPlanWorldManager3.Z(worldID, optInt2, listener);
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$enterAvatarScene$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes27.dex */
            public static final class a implements a.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f386252d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ZPlanWorldManager$enterAvatarScene$$inlined$doOnWorldThread$1 f386253e;

                a(String str, ZPlanWorldManager$enterAvatarScene$$inlined$doOnWorldThread$1 zPlanWorldManager$enterAvatarScene$$inlined$doOnWorldThread$1) {
                    this.f386252d = str;
                    this.f386253e = zPlanWorldManager$enterAvatarScene$$inlined$doOnWorldThread$1;
                }

                @Override // com.tencent.zplan.luabridge.a.b
                public void onExecuteLua() {
                    ZLog.f386189b.k("ZPlanWorldManager", "enterAvatarScene onExecuteLua");
                    c cVar = (c) mx4.a.f417748a.a(c.class);
                    if (cVar != null) {
                        cVar.notifyEnterAvatarScene(this.f386252d);
                    }
                    listener.onEnterSceneResult(true);
                }

                @Override // com.tencent.zplan.luabridge.a.b
                public void onLuaResult(boolean success, @Nullable String result) {
                }
            }
        });
    }

    public final void D() {
        if (!getZPlanWorlding) {
            List<Runnable> list = getZPlanWorldWaitList;
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                synchronized (list) {
                    arrayList.addAll(list);
                    list.clear();
                    Unit unit = Unit.INSTANCE;
                }
                int size = arrayList.size();
                ZLog.f386189b.k("ZPlanWorldManager", "evaluateGetZPlanWorldWaitList getZPlanWorldWaitList, total:" + size);
                if (size == 0) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                return;
            }
        }
        ZLog.f386189b.f("ZPlanWorldManager", "evaluateGetZPlanWorldWaitList, getZPlanWorlding " + getZPlanWorlding + ", getZPlanWorldWaitList: " + getZPlanWorldWaitList.size() + ", return.");
    }

    public final void E() {
        if (!UE4.engineActive) {
            ZLog.f386189b.f("ZPlanWorldManager", "evaluateWindowWaitList, engineActive false, return");
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<Runnable> list = windowWaitList;
        synchronized (list) {
            arrayList.addAll(list);
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        ZLog.f386189b.k("ZPlanWorldManager", "evaluateWindowWaitList, total:" + size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void F(final int worldID, final int width, final int height, @Nullable final Surface surface) {
        ZLog zLog = ZLog.f386189b;
        zLog.l("ZPlanWorldManager", "focusZPlanWorld, worldID: " + worldID + ", width: " + width + ", height: " + height + ", surface: " + surface, new StackPrinter("setWorldTexture"));
        final String str = "focusZPlanWorld";
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: focusZPlanWorld");
            zLog.k("ZPlanWorldManager", "focusZPlanWorld worldID : " + worldID + ", width : " + width + ", height : " + height + ", surface : " + surface);
            if (worldID >= 0 && width >= 0 && height >= 0 && surface != null) {
                zLog.k("ZPlanWorldManager", "do focusZPlanWorld worldID : " + worldID);
                ZPlanWorldManager zPlanWorldManager = f386245m;
                ZPlanWorld J = zPlanWorldManager.J(worldID);
                if (J != null) {
                    zPlanWorldManager.b0(worldID, true);
                    if (!Intrinsics.areEqual(surface, J.getSurface())) {
                        zPlanWorldManager.a0(worldID, surface);
                    }
                    if (width != J.getWorldWidth() || height != J.getWorldHeight()) {
                        zPlanWorldManager.Y(worldID, width, height);
                    }
                    J.setSurface(surface);
                    J.setWorldWidth(width);
                    J.setWorldHeight(height);
                }
                zLog.k("ZPlanWorldManager", "focusZPlanWorld zPlanWorld : " + J);
                if (J == null && worldID == 0) {
                    zLog.k("ZPlanWorldManager", "focusZPlanWorld world is 0 set tex and resize");
                    zPlanWorldManager.b0(worldID, true);
                    zPlanWorldManager.a0(worldID, surface);
                    zPlanWorldManager.Y(worldID, width, height);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("WorldID", worldID);
                ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "focusObj.toString()");
                a.C10063a.b(zPlanLuaBridge, "N2L_FocusWorld", jSONObject2, null, 4, null);
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: focusZPlanWorld");
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$focusZPlanWorld$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                zLog2.k("ZPlanWorldManager", "focusZPlanWorld worldID : " + worldID + ", width : " + width + ", height : " + height + ", surface : " + surface);
                if (worldID >= 0 && width >= 0 && height >= 0 && surface != null) {
                    zLog2.k("ZPlanWorldManager", "do focusZPlanWorld worldID : " + worldID);
                    ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                    ZPlanWorld J2 = zPlanWorldManager3.J(worldID);
                    if (J2 != null) {
                        zPlanWorldManager3.b0(worldID, true);
                        if (!Intrinsics.areEqual(surface, J2.getSurface())) {
                            zPlanWorldManager3.a0(worldID, surface);
                        }
                        if (width != J2.getWorldWidth() || height != J2.getWorldHeight()) {
                            zPlanWorldManager3.Y(worldID, width, height);
                        }
                        J2.setSurface(surface);
                        J2.setWorldWidth(width);
                        J2.setWorldHeight(height);
                    }
                    zLog2.k("ZPlanWorldManager", "focusZPlanWorld zPlanWorld : " + J2);
                    if (J2 == null && worldID == 0) {
                        zLog2.k("ZPlanWorldManager", "focusZPlanWorld world is 0 set tex and resize");
                        zPlanWorldManager3.b0(worldID, true);
                        zPlanWorldManager3.a0(worldID, surface);
                        zPlanWorldManager3.Y(worldID, width, height);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("WorldID", worldID);
                    ZPlanLuaBridge zPlanLuaBridge2 = ZPlanLuaBridge.INSTANCE;
                    String jSONObject4 = jSONObject3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "focusObj.toString()");
                    a.C10063a.b(zPlanLuaBridge2, "N2L_FocusWorld", jSONObject4, null, 4, null);
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    public final void H(final int renderHashcode, final int scene, final int width, final int height, @NotNull final IZPlanWorldListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager", "getZPlanWorld renderHashcode:" + renderHashcode);
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: getZPlanWorld");
            ZPlanWorldManager zPlanWorldManager = f386245m;
            zPlanWorldManager.O();
            zLog.k("ZPlanWorldManager", "doOnGetZPlanWorldIdle getZPlanWorlding: " + g(zPlanWorldManager));
            if (g(zPlanWorldManager)) {
                zPlanWorldManager.x(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1

                    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\t"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$getZPlanWorld$1$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug", "com/tencent/zplan/world/manager/ZPlanWorldManager$$special$$inlined$doOnGetZPlanWorldIdle$1$lambda$1"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes27.dex */
                    public static final class a implements a.b {

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ long f386274d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1 f386275e;

                        a(long j3, ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1) {
                            this.f386274d = j3;
                            this.f386275e = zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1;
                        }

                        @Override // com.tencent.zplan.luabridge.a.b
                        public void onExecuteLua() {
                            a.b.C10064a.a(this);
                        }

                        @Override // com.tencent.zplan.luabridge.a.b
                        public void onLuaResult(boolean success, @Nullable String result) {
                            ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
                            ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1 zPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$lambda$1 = this.f386275e;
                            zPlanWorldManager.L(success, result, listener, width, height, scene, this.f386274d, renderHashcode);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding true");
                        ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                        ZPlanWorldManager.getZPlanWorlding = true;
                        zLog2.k("ZPlanWorldManager", "getZPlanWorld scene : " + scene + ", width : " + width + ", height : " + height);
                        if (!zPlanWorldManager2.I(scene, renderHashcode, width, height, listener)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("createWorld scene : ");
                            sb5.append(scene);
                            sb5.append(", width : ");
                            sb5.append(width);
                            sb5.append(", ");
                            sb5.append("height: ");
                            sb5.append(height);
                            sb5.append(", thread: ");
                            sb5.append(Thread.currentThread());
                            sb5.append(", ");
                            sb5.append("threadnbame : ");
                            Thread currentThread = Thread.currentThread();
                            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                            sb5.append(currentThread.getName());
                            zLog2.k("ZPlanWorldManager", sb5.toString());
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("Width", width);
                            jSONObject.put("Height", height);
                            jSONObject.put("DrawMode", 0);
                            zLog2.l("ZPlanWorldManager", "createWorld : ", new StackPrinter("createWorld"));
                            ZPlanLuaBridge.INSTANCE.callLua("N2L_CreateWorld", jSONObject, (a.b) new a(currentTimeMillis, this), true);
                        }
                    }
                });
            } else {
                zLog.k("ZPlanWorldManager", "getZPlanWorld set getZPlanWorlding true");
                getZPlanWorlding = true;
                zLog.k("ZPlanWorldManager", "getZPlanWorld scene : " + scene + ", width : " + width + ", height : " + height);
                if (!zPlanWorldManager.I(scene, renderHashcode, width, height, listener)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("createWorld scene : ");
                    sb5.append(scene);
                    sb5.append(", width : ");
                    sb5.append(width);
                    sb5.append(", ");
                    sb5.append("height: ");
                    sb5.append(height);
                    sb5.append(", thread: ");
                    sb5.append(Thread.currentThread());
                    sb5.append(", ");
                    sb5.append("threadnbame : ");
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    sb5.append(currentThread.getName());
                    zLog.k("ZPlanWorldManager", sb5.toString());
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("Width", width);
                    jSONObject.put("Height", height);
                    jSONObject.put("DrawMode", 0);
                    zLog.l("ZPlanWorldManager", "createWorld : ", new StackPrinter("createWorld"));
                    ZPlanLuaBridge.INSTANCE.callLua("N2L_CreateWorld", jSONObject, (a.b) new b(currentTimeMillis, scene, width, height, renderHashcode, listener), true);
                }
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: getZPlanWorld");
            return;
        }
        aVar.a().post(new ZPlanWorldManager$getZPlanWorld$$inlined$doOnWorldThread$1("getZPlanWorld", scene, width, height, renderHashcode, listener));
    }

    public final void U(final int renderHashcode, final int worldID) {
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager" + ZPlanConstant.f386195f.b(), "onDestroy renderHashcode:" + renderHashcode + ", worldID: " + worldID);
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        boolean areEqual = Intrinsics.areEqual(myLooper, aVar.b());
        final String str = MosaicConstants$JsFunction.FUNC_ON_DESTROY;
        if (areEqual) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            if (worldID < 0) {
                e(f386245m).add(Integer.valueOf(renderHashcode));
                zLog.k("ZPlanWorldManager", "onDestroy worldID < 0, return");
            } else {
                ZPlanWorldManager zPlanWorldManager = f386245m;
                if (zPlanWorldManager.R(renderHashcode, worldID)) {
                    zLog.k("ZPlanWorldManager", "onDestroy isWorldUsing, return");
                    zPlanWorldManager.A(worldID);
                } else {
                    zLog.k("ZPlanWorldManager", "onDestyoy worldID : " + worldID + ", Using : " + ZPlanServiceHelper.I.R());
                    zPlanWorldManager.B(worldID);
                    zPlanWorldManager.N();
                    zPlanWorldManager.M();
                }
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$onDestroy$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                int i3 = worldID;
                if (i3 < 0) {
                    ZPlanWorldManager.e(ZPlanWorldManager.f386245m).add(Integer.valueOf(renderHashcode));
                    zLog2.k("ZPlanWorldManager", "onDestroy worldID < 0, return");
                } else {
                    ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                    if (zPlanWorldManager3.R(renderHashcode, i3)) {
                        zLog2.k("ZPlanWorldManager", "onDestroy isWorldUsing, return");
                        zPlanWorldManager3.A(worldID);
                    } else {
                        zLog2.k("ZPlanWorldManager", "onDestyoy worldID : " + worldID + ", Using : " + ZPlanServiceHelper.I.R());
                        zPlanWorldManager3.B(worldID);
                        zPlanWorldManager3.N();
                        zPlanWorldManager3.M();
                    }
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    public final void V(final int worldID) {
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager" + ZPlanConstant.f386195f.b(), "onPause, worldID: " + worldID);
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        boolean areEqual = Intrinsics.areEqual(myLooper, aVar.b());
        final String str = MiniSDKConst.NOTIFY_EVENT_ONPAUSE;
        if (areEqual) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            if (worldID >= 0 && !UE4.isEnginePause) {
                zLog.k("ZPlanWorldManager", "onPause worldID : " + worldID);
                ZPlanWorldManager zPlanWorldManager = f386245m;
                zPlanWorldManager.b0(worldID, false);
                zPlanWorldManager.M();
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$onPause$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                if (worldID >= 0 && !UE4.isEnginePause) {
                    zLog2.k("ZPlanWorldManager", "onPause worldID : " + worldID);
                    ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                    zPlanWorldManager3.b0(worldID, false);
                    zPlanWorldManager3.M();
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    public final void W(final int worldID) {
        ZPlanWorld J;
        ZLog zLog = ZLog.f386189b;
        zLog.k("ZPlanWorldManager" + ZPlanConstant.f386195f.b(), "onResume, worldID: " + worldID);
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        final String str = "onResume";
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: onResume");
            zLog.k("ZPlanWorldManager", "onResume worldID : " + worldID);
            ZPlanWorldManager zPlanWorldManager = f386245m;
            zPlanWorldManager.O();
            zPlanWorldManager.z("resume", worldID);
            if (worldID >= 0 && (J = zPlanWorldManager.J(worldID)) != null) {
                zPlanWorldManager.b0(worldID, true);
                zPlanWorldManager.F(J.getWorldID(), J.getWorldWidth(), J.getWorldHeight(), J.getSurface());
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: onResume");
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$onResume$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorld J2;
                ZPlanWorldManager zPlanWorldManager2 = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                zLog2.k("ZPlanWorldManager", "onResume worldID : " + worldID);
                ZPlanWorldManager zPlanWorldManager3 = ZPlanWorldManager.f386245m;
                zPlanWorldManager3.O();
                zPlanWorldManager3.z("resume", worldID);
                int i3 = worldID;
                if (i3 >= 0 && (J2 = zPlanWorldManager3.J(i3)) != null) {
                    zPlanWorldManager3.b0(worldID, true);
                    zPlanWorldManager3.F(J2.getWorldID(), J2.getWorldWidth(), J2.getWorldHeight(), J2.getSurface());
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    public final void X(@Nullable String sceneData) {
        ZLog.f386189b.k("ZPlanWorldManager", "preloadWorldAndEnterScene, sceneData : " + sceneData);
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(sceneData);
        int i3 = -1;
        if (b16 != null) {
            i3 = b16.optInt("ViewType", -1);
        }
        int i16 = i3;
        if (i16 < 0) {
            return;
        }
        preloadWorldSceneType = i16;
        H(-1, i16, 1, 1, new c(i16, sceneData));
    }

    public final void Y(final int worldID, final int width, final int height) {
        ZLog zLog = ZLog.f386189b;
        final String str = "resizeZPlanWorld";
        zLog.l("ZPlanWorldManager", "resizeZPlanWorld,", new StackPrinter("resizeZPlanWorld"));
        Looper myLooper = Looper.myLooper();
        ey4.a aVar = ey4.a.f397437d;
        if (Intrinsics.areEqual(myLooper, aVar.b())) {
            zLog.k("ZPlanWorldManager", "doOnWorldThread before task, from: resizeZPlanWorld");
            if (worldID >= 0 && width >= 0 && height >= 0) {
                zLog.k("ZPlanWorldManager", "resizeZPlanWorld worldID : " + worldID + ", width : " + width + ", height : " + height);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Width", width);
                jSONObject.put("Height", height);
                jSONObject.put("WorldID", worldID);
                ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "resizeObj.toString()");
                a.C10063a.b(zPlanLuaBridge, "N2L_ResizeWorld", jSONObject2, null, 4, null);
                ZPlanWorld J = f386245m.J(worldID);
                if (J != null) {
                    J.setWorldWidth(width);
                    J.setWorldHeight(height);
                }
            }
            zLog.k("ZPlanWorldManager", "doOnWorldThread after task, from: resizeZPlanWorld");
            return;
        }
        aVar.a().post(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$resizeZPlanWorld$$inlined$doOnWorldThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanWorldManager zPlanWorldManager = ZPlanWorldManager.f386245m;
                String str2 = str;
                ZLog zLog2 = ZLog.f386189b;
                zLog2.k("ZPlanWorldManager", "doOnWorldThread before task, from: " + str2);
                if (worldID >= 0 && width >= 0 && height >= 0) {
                    zLog2.k("ZPlanWorldManager", "resizeZPlanWorld worldID : " + worldID + ", width : " + width + ", height : " + height);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("Width", width);
                    jSONObject3.put("Height", height);
                    jSONObject3.put("WorldID", worldID);
                    ZPlanLuaBridge zPlanLuaBridge2 = ZPlanLuaBridge.INSTANCE;
                    String jSONObject4 = jSONObject3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "resizeObj.toString()");
                    a.C10063a.b(zPlanLuaBridge2, "N2L_ResizeWorld", jSONObject4, null, 4, null);
                    ZPlanWorld J2 = ZPlanWorldManager.f386245m.J(worldID);
                    if (J2 != null) {
                        J2.setWorldWidth(width);
                        J2.setWorldHeight(height);
                    }
                }
                zLog2.k("ZPlanWorldManager", "doOnWorldThread after task, from: " + str2);
            }
        });
    }

    public final void a0(final int worldID, @Nullable final Surface surface) {
        ZLog zLog = ZLog.f386189b;
        zLog.l("ZPlanWorldManager", "setWorldTexture worldID:" + worldID + ", surface: " + surface, new StackPrinter("setWorldTexture"));
        if (worldID >= 0 && surface != null) {
            if (!UE4.engineActive) {
                y(new Runnable() { // from class: com.tencent.zplan.world.manager.ZPlanWorldManager$setWorldTexture$$inlined$doOnEngineActive$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean isValid = surface.isValid();
                        ZLog zLog2 = ZLog.f386189b;
                        zLog2.k("ZPlanWorldManager", "setWorldTexture worldID:" + worldID + ", surface: " + surface + ", isValid: " + isValid + TokenParser.SP);
                        if (isValid) {
                            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_set_window", "world_set_window", null, 4, null);
                            UE4.ParallelWorld.setWindow(worldID, surface);
                            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_set_window", "world_set_window_end", null, 4, null);
                            EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_world_set_window", false, 2, null);
                        }
                        zLog2.k("ZPlanWorldManager", "setWorldTexture end ");
                    }
                });
                return;
            }
            boolean isValid = surface.isValid();
            zLog.k("ZPlanWorldManager", "setWorldTexture worldID:" + worldID + ", surface: " + surface + ", isValid: " + isValid + TokenParser.SP);
            if (isValid) {
                EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_set_window", "world_set_window", null, 4, null);
                UE4.ParallelWorld.setWindow(worldID, surface);
                EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_world_set_window", "world_set_window_end", null, 4, null);
                EngineLifeCycleReporter.t(engineLifeCycleReporter, "zplan_world_set_window", false, 2, null);
            }
            zLog.k("ZPlanWorldManager", "setWorldTexture end ");
        }
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public boolean canDrawRenderTarget(int worldID, int drawMode) {
        ZLog.f386189b.k("ZPlanWorldManager", "canDrawRenderTarget");
        return true;
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void drawRenderTargetAsFramebuffer(int worldID, int framebuffer, int width, int height) {
        ZLog.f386189b.k("ZPlanWorldManager", "drawRenderTargetAsFramebuffer " + worldID + ", width: " + width + ", height: " + height);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void drawRenderTargetAsPixels(int worldID, @Nullable byte[] pixels, int width, int height) {
        ZLog.f386189b.k("ZPlanWorldManager", "drawRenderTargetAsPixels " + worldID + ", width: " + width + ", height: " + height);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onActivated(int worldID, boolean bFocused, int width, int height) {
        ZLog.f386189b.k("ZPlanWorldManager", "onActivated " + worldID + ", bFocused: " + bFocused + ", width: " + width + ", height: " + height);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onDeactivated(int worldID) {
        ZLog.f386189b.k("ZPlanWorldManager", "onDeactivated " + worldID);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onDrawModeChanged(int worldID, int oldDrawMode, int newDrawMode) {
        ZLog.f386189b.k("ZPlanWorldManager", "onDrawModeChanged " + worldID);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onFocusChanged(int oldWorldID, int newWorldID) {
        ZLog.f386189b.k("ZPlanWorldManager", "onFocusChanged oldWorldID: " + oldWorldID + ", newWorldID:" + newWorldID);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onInited(int worldID) {
        ZLog.f386189b.k("ZPlanWorldManager", "onInited " + worldID);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onKilled(int worldID) {
        ZLog.f386189b.k("ZPlanWorldManager", "onKilled " + worldID);
        K(worldID);
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onLoaded(int worldID, boolean succeeded) {
        ZLog.f386189b.k("ZPlanWorldManager", "onLoaded " + worldID + ", succeeded: succeeded");
    }

    @Override // com.epicgames.ue4.UE4.ParallelWorldListener
    public void onNativeWindowChanged(int worldID) {
        ZLog.f386189b.k("ZPlanWorldManager", "onNativeWindowChanged " + worldID);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/world/manager/ZPlanWorldManager$enterAvatarScene$1$1", "Lcom/tencent/zplan/luabridge/a$b;", "", "onExecuteLua", "", "success", "", "result", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f386295d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f386296e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f386297f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ IZPlanWorldStatusListener f386298h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f386299i;

        a(String str, int i3, String str2, IZPlanWorldStatusListener iZPlanWorldStatusListener, int i16) {
            this.f386295d = str;
            this.f386296e = i3;
            this.f386297f = str2;
            this.f386298h = iZPlanWorldStatusListener;
            this.f386299i = i16;
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            ZLog.f386189b.k("ZPlanWorldManager", "enterAvatarScene onExecuteLua");
            yx4.c cVar = (yx4.c) mx4.a.f417748a.a(yx4.c.class);
            if (cVar != null) {
                cVar.notifyEnterAvatarScene(this.f386295d);
            }
            this.f386298h.onEnterSceneResult(true);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, @Nullable String result) {
        }
    }
}
