package com.tencent.hippy.qq.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.core.os.HandlerCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.api.IHippyDomNodeManager;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.obj.HippyDomConfigBean;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 M2\u00020\u0001:\u0001MB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002JN\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010\u001f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010!\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0012H\u0002J@\u0010#\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010 \u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J0\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`,2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020-0(j\b\u0012\u0004\u0012\u00020-`,H\u0002J\"\u0010.\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J \u00103\u001a\u0012\u0012\u0004\u0012\u00020-0(j\b\u0012\u0004\u0012\u00020-`,2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J4\u00104\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020-0(j\b\u0012\u0004\u0012\u00020-`,2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u00105\u001a\u000206H\u0002J\"\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u0002062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\"\u0010:\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u000202H\u0002J\u0012\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010?\u001a\u00020\bH\u0016J&\u0010@\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010A\u001a\u00020\b2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020-0(j\b\u0012\u0004\u0012\u00020-`,2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J2\u0010B\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0004H\u0016JD\u0010F\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016JJ\u0010G\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010 \u001a\u00020\u00042\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020-0(j\b\u0012\u0004\u0012\u00020-`,H\u0016J@\u0010H\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010 \u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020-0(H\u0002J\u0018\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020K2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010L\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl;", "Lcom/tencent/hippy/qq/api/IHippyDomNodeManager;", "()V", "account", "", "app", "Lmqq/app/AppRuntime;", "addSnapshotBgColor", "", "snapShotRootView", "Lcom/tencent/mtt/hippy/HippyRootView;", "addSnapshotRootViewIfNeed", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mtt/hippy/HippyEngine;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "bundleName", HippyQQConstants.KEY_BUNDLE_VERSION, "", OpenHippyInfo.EXTRA_KEY_PRE_RENDER_TAG, "loadParams", "Lcom/tencent/mtt/hippy/HippyEngine$ModuleLoadParams;", "loadListener", "Lcom/tencent/hippy/qq/api/IHippyDomNodeManager$SnapshotLoadListener;", "checkDataValid", "", "recordData", "Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion$DomRecordData;", "checkSwitch", "colorLogI", "msg", "deleteDomNodeCache", HippyQQConstants.KEY_RENDER_TAG, "deleteOldBundleOrOverTimeCache", "curVersion", "fillDomRecordData", "renderVersion", "renderData", "Lorg/json/JSONObject;", "recordList", "Ljava/util/ArrayList;", "Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion$DomNodeRecordExt;", "getBundleDirPath", "getDomNodeRecordExtList", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mtt/hippy/dom/node/DomNodeRecord;", "getDomRecordDirPath", "getHippyDomConfigBean", "Lcom/tencent/hippy/qq/obj/HippyDomConfigBean;", "getRecordFile", "Ljava/io/File;", "getRecordListFromData", "getSnapshotRootView", "getTimeStamp", "", "listenOnChildAdd", "it", "startTime", "notifyFailedAndDelete", "errorMsg", "recordFile", "onCreate", "appRuntime", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "removeSnapshotRootViewIfNeed", "reportSaveNodeRecord", "reportSnapshotShow", "costTime", "success", "errMsg", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "saveInstanceState", "updateDomNodeRecordFile", "userLogE", "e", "", "userLogI", "Companion", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyDomNodeManagerImpl implements IHippyDomNodeManager {

    @NotNull
    public static final String DOM_DATA_NAME = "domData.json";

    @NotNull
    public static final String FILE_TYPE = "dom";
    public static final long REMOVE_DELAY_TIME = 3000;

    @NotNull
    public static final String TAG = "HippyDomNodeManagerImpl";

    @NotNull
    private static final String baseDir;

    @Nullable
    private String account;

    @Nullable
    private AppRuntime app;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Object lock = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion;", "", "()V", "DOM_DATA_NAME", "", "FILE_TYPE", "REMOVE_DELAY_TIME", "", "TAG", "baseDir", "getBaseDir", "()Ljava/lang/String;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "clearDomCache", "", "DomNodeRecordExt", "DomRecordData", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {

        /* compiled from: P */
        @Keep
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion$DomNodeRecordExt;", "Lcom/tencent/mtt/hippy/dom/node/DomNodeRecord;", "Ljava/io/Serializable;", "()V", "propsObj", "", "getPropsObj", "()Ljava/lang/String;", "setPropsObj", "(Ljava/lang/String;)V", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes7.dex */
        public static final class DomNodeRecordExt extends DomNodeRecord implements Serializable {

            @Nullable
            private String propsObj;

            @Nullable
            public final String getPropsObj() {
                return this.propsObj;
            }

            public final void setPropsObj(@Nullable String str) {
                this.propsObj = str;
            }
        }

        /* compiled from: P */
        @Keep
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion$DomRecordData;", "Ljava/io/Serializable;", "()V", "bundleName", "", "getBundleName", "()Ljava/lang/String;", "setBundleName", "(Ljava/lang/String;)V", HippyQQConstants.KEY_BUNDLE_VERSION, "", "getBundleVersion", "()I", "setBundleVersion", "(I)V", "domNodeRecordList", "Ljava/util/ArrayList;", "Lcom/tencent/hippy/qq/api/impl/HippyDomNodeManagerImpl$Companion$DomNodeRecordExt;", "Lkotlin/collections/ArrayList;", "getDomNodeRecordList", "()Ljava/util/ArrayList;", "setDomNodeRecordList", "(Ljava/util/ArrayList;)V", "renderData", "Lorg/json/JSONObject;", "getRenderData", "()Lorg/json/JSONObject;", "setRenderData", "(Lorg/json/JSONObject;)V", HippyQQConstants.KEY_RENDER_TAG, "getRenderTag", "setRenderTag", "renderVersion", "getRenderVersion", "setRenderVersion", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes7.dex */
        public static final class DomRecordData implements Serializable {

            @Nullable
            private String bundleName;
            private int bundleVersion;

            @NotNull
            private ArrayList<DomNodeRecordExt> domNodeRecordList = new ArrayList<>();

            @Nullable
            private JSONObject renderData;

            @Nullable
            private String renderTag;
            private int renderVersion;

            @Nullable
            public final String getBundleName() {
                return this.bundleName;
            }

            public final int getBundleVersion() {
                return this.bundleVersion;
            }

            @NotNull
            public final ArrayList<DomNodeRecordExt> getDomNodeRecordList() {
                return this.domNodeRecordList;
            }

            @Nullable
            public final JSONObject getRenderData() {
                return this.renderData;
            }

            @Nullable
            public final String getRenderTag() {
                return this.renderTag;
            }

            public final int getRenderVersion() {
                return this.renderVersion;
            }

            public final void setBundleName(@Nullable String str) {
                this.bundleName = str;
            }

            public final void setBundleVersion(int i3) {
                this.bundleVersion = i3;
            }

            public final void setDomNodeRecordList(@NotNull ArrayList<DomNodeRecordExt> arrayList) {
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                this.domNodeRecordList = arrayList;
            }

            public final void setRenderData(@Nullable JSONObject jSONObject) {
                this.renderData = jSONObject;
            }

            public final void setRenderTag(@Nullable String str) {
                this.renderTag = str;
            }

            public final void setRenderVersion(int i3) {
                this.renderVersion = i3;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearDomCache() {
            FileUtils.deleteFile(HippyQQFileUtil.getHippyFileByType(HippyDomNodeManagerImpl.FILE_TYPE));
        }

        @NotNull
        public final String getBaseDir() {
            return HippyDomNodeManagerImpl.baseDir;
        }

        @NotNull
        public final Object getLock() {
            return HippyDomNodeManagerImpl.lock;
        }

        Companion() {
        }
    }

    static {
        String absolutePath = HippyQQFileUtil.getHippyFileByType(FILE_TYPE).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getHippyFileByType(FILE_TYPE).absolutePath");
        baseDir = absolutePath;
    }

    private final void addSnapshotBgColor(HippyRootView snapShotRootView) {
        if (snapShotRootView != null) {
            snapShotRootView.setBackgroundColor(Color.parseColor("#fafaba"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSnapshotRootViewIfNeed$lambda$4$lambda$3(HippyDomNodeManagerImpl this$0, String str, HippyEngine hippyEngine, ViewGroup viewGroup, HippyRootView hippyRootView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.userLogI("[addSnapShotRootViewIfNeed] runOverTime remove,bundleName:" + str);
        this$0.removeSnapshotRootViewIfNeed(hippyEngine, viewGroup, hippyRootView);
    }

    private final boolean checkDataValid(Companion.DomRecordData recordData) {
        ArrayList<Companion.DomNodeRecordExt> arrayList;
        boolean z16;
        if (recordData != null) {
            arrayList = recordData.getDomNodeRecordList();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        QLog.i(TAG, 1, "[checkDataValid] recordList is empty");
        return false;
    }

    private final void colorLogI(String msg2) {
        QLog.i(TAG, 2, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteDomNodeCache$lambda$7(HippyDomNodeManagerImpl this$0, String str, int i3, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (lock) {
            Intrinsics.checkNotNull(str);
            this$0.userLogI("[deleteDomNodeCache] " + str + "/" + str2 + ",result:" + FileUtils.deleteFile(this$0.getDomRecordDirPath(str, i3, str2)));
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void deleteOldBundleOrOverTimeCache(String bundleName, int curVersion) {
        if (TextUtils.isEmpty(bundleName)) {
            return;
        }
        Intrinsics.checkNotNull(bundleName);
        File[] listFiles = new File(getBundleDirPath(bundleName)).listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i3 = 0;
            while (i3 < length) {
                File file = listFiles[i3];
                if (!Intrinsics.areEqual(String.valueOf(curVersion), file.getName())) {
                    FileUtils.deleteFile(file);
                    userLogI("[deleteOldBundleCache] " + bundleName + "/" + file.getName() + ",cuVersion:" + curVersion);
                } else {
                    int domNodeCacheDuration = getHippyDomConfigBean().getDomNodeCacheDuration();
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 != null) {
                        Intrinsics.checkNotNullExpressionValue(listFiles2, "listFiles()");
                        int length2 = listFiles2.length;
                        int i16 = 0;
                        while (i16 < length2) {
                            File file2 = listFiles2[i16];
                            long lastModified = file2.lastModified();
                            File[] fileArr = listFiles;
                            int i17 = length;
                            if (Math.abs(System.currentTimeMillis() - lastModified) > domNodeCacheDuration * 1000) {
                                FileUtils.deleteFile(file2);
                                userLogI("[deleteOldBundleCache] overTime:lastModified:" + lastModified + " " + file2.getAbsolutePath());
                            }
                            i16++;
                            listFiles = fileArr;
                            length = i17;
                        }
                    }
                }
                i3++;
                listFiles = listFiles;
                length = length;
            }
        }
    }

    private final Companion.DomRecordData fillDomRecordData(int bundleVersion, String bundleName, int renderVersion, JSONObject renderData, String renderTag, ArrayList<Companion.DomNodeRecordExt> recordList) {
        Companion.DomRecordData domRecordData = new Companion.DomRecordData();
        domRecordData.setBundleVersion(bundleVersion);
        domRecordData.setBundleName(bundleName);
        domRecordData.setRenderVersion(renderVersion);
        domRecordData.setRenderData(renderData);
        domRecordData.setRenderTag(renderTag);
        domRecordData.getDomNodeRecordList().clear();
        domRecordData.getDomNodeRecordList().addAll(recordList);
        return domRecordData;
    }

    private final String getBundleDirPath(String bundleName) {
        String str;
        String str2 = baseDir;
        AppRuntime appRuntime = this.app;
        if (appRuntime != null) {
            str = appRuntime.getAccount();
        } else {
            str = null;
        }
        return str2 + "/" + str + "/" + bundleName + "/";
    }

    private final ArrayList<Companion.DomNodeRecordExt> getDomNodeRecordExtList(ArrayList<DomNodeRecord> recordList) {
        JSONObject jSONObject;
        ArrayList<Companion.DomNodeRecordExt> arrayList = new ArrayList<>();
        Iterator<DomNodeRecord> it = recordList.iterator();
        while (it.hasNext()) {
            DomNodeRecord next = it.next();
            Companion.DomNodeRecordExt domNodeRecordExt = new Companion.DomNodeRecordExt();
            domNodeRecordExt.rootId = next.rootId;
            domNodeRecordExt.f337371id = next.f337371id;
            domNodeRecordExt.pid = next.pid;
            domNodeRecordExt.index = next.index;
            domNodeRecordExt.className = next.className;
            domNodeRecordExt.tagName = next.tagName;
            domNodeRecordExt.tagName = next.tagName;
            HippyMap hippyMap = next.props;
            if (hippyMap != null) {
                jSONObject = hippyMap.toJSONObject();
            } else {
                jSONObject = null;
            }
            domNodeRecordExt.setPropsObj(String.valueOf(jSONObject));
            arrayList.add(domNodeRecordExt);
        }
        return arrayList;
    }

    private final String getDomRecordDirPath(String bundleName, int bundleVersion, String renderTag) {
        String str = getBundleDirPath(bundleName) + bundleVersion + "/";
        if (!TextUtils.isEmpty(renderTag)) {
            return str + renderTag + "/";
        }
        return str;
    }

    private final HippyDomConfigBean getHippyDomConfigBean() {
        return (HippyDomConfigBean) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.HIPPY_DOM_CACHE, new HippyDomConfigBean());
    }

    private final File getRecordFile(String bundleName, int bundleVersion, String preRenderTag) {
        return new File(getDomRecordDirPath(bundleName, bundleVersion, preRenderTag), DOM_DATA_NAME);
    }

    private final ArrayList<DomNodeRecord> getRecordListFromData(Companion.DomRecordData recordData) {
        ArrayList<DomNodeRecord> arrayList = new ArrayList<>();
        Iterator<Companion.DomNodeRecordExt> it = recordData.getDomNodeRecordList().iterator();
        while (it.hasNext()) {
            Companion.DomNodeRecordExt next = it.next();
            DomNodeRecord domNodeRecord = new DomNodeRecord();
            domNodeRecord.rootId = next.rootId;
            domNodeRecord.f337371id = next.f337371id;
            domNodeRecord.pid = next.pid;
            domNodeRecord.index = next.index;
            domNodeRecord.className = next.className;
            domNodeRecord.tagName = next.tagName;
            if (next.getPropsObj() != null) {
                HippyMap hippyMap = new HippyMap();
                domNodeRecord.props = hippyMap;
                hippyMap.pushJSONObject(new JSONObject(String.valueOf(next.getPropsObj())));
            }
            arrayList.add(domNodeRecord);
        }
        return arrayList;
    }

    private final HippyRootView getSnapshotRootView(HippyEngine engine, ArrayList<DomNodeRecord> recordList, HippyEngine.ModuleLoadParams loadParams) {
        Integer num;
        HippyRootView restoreInstanceState = engine.restoreInstanceState(recordList, loadParams, false);
        if (restoreInstanceState != null) {
            num = Integer.valueOf(restoreInstanceState.hashCode());
        } else {
            num = null;
        }
        colorLogI("[restoreInstanceState] snapShotRootView:" + num);
        return restoreInstanceState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getTimeStamp() {
        return System.currentTimeMillis();
    }

    private final void listenOnChildAdd(HippyRootView it, final long startTime, final IHippyDomNodeManager.SnapshotLoadListener loadListener) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        it.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.tencent.hippy.qq.api.impl.HippyDomNodeManagerImpl$listenOnChildAdd$1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(@Nullable View parent, @Nullable View child) {
                long timeStamp;
                EventCollector.getInstance().onChildViewAdded(parent, child);
                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                if (!booleanRef2.element) {
                    booleanRef2.element = true;
                    IHippyDomNodeManager.SnapshotLoadListener snapshotLoadListener = loadListener;
                    if (snapshotLoadListener != null) {
                        snapshotLoadListener.onLoadComplete();
                    }
                    timeStamp = this.getTimeStamp();
                    long j3 = timeStamp - startTime;
                    this.userLogI("onChildViewAdded: cost:" + j3);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(@Nullable View parent, @Nullable View child) {
                EventCollector.getInstance().onChildViewRemoved(parent, child);
            }
        });
    }

    private final void notifyFailedAndDelete(IHippyDomNodeManager.SnapshotLoadListener loadListener, String errorMsg, File recordFile) {
        if (loadListener != null) {
            loadListener.onLoadFailed(errorMsg);
        }
        FileUtils.deleteFile(recordFile);
    }

    private final void reportSaveNodeRecord(ArrayList<DomNodeRecord> recordList, String bundleName, int bundleVersion) {
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("node_count", String.valueOf(recordList.size()));
        HippyReporter hippyReporter = HippyReporter.getInstance();
        if (!recordList.isEmpty()) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        hippyReporter.reportToDengTa(bundleName, bundleVersion, HippyReporter.EventCode.HIPPY_PRERENDER, i3, hashMap);
    }

    private final void updateDomNodeRecordFile(final int bundleVersion, final String bundleName, final int renderVersion, final JSONObject renderData, final String renderTag, final ArrayList<DomNodeRecord> recordList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                HippyDomNodeManagerImpl.updateDomNodeRecordFile$lambda$9(HippyDomNodeManagerImpl.this, bundleName, bundleVersion, renderVersion, renderData, renderTag, recordList);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDomNodeRecordFile$lambda$9(HippyDomNodeManagerImpl this$0, String bundleName, int i3, int i16, JSONObject jSONObject, String renderTag, ArrayList recordList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bundleName, "$bundleName");
        Intrinsics.checkNotNullParameter(renderTag, "$renderTag");
        Intrinsics.checkNotNullParameter(recordList, "$recordList");
        synchronized (lock) {
            this$0.deleteOldBundleOrOverTimeCache(bundleName, i3);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                String json = new Gson().toJson(this$0.fillDomRecordData(i3, bundleName, i16, jSONObject, renderTag, this$0.getDomNodeRecordExtList(recordList)), new TypeToken<Companion.DomRecordData>() { // from class: com.tencent.hippy.qq.api.impl.HippyDomNodeManagerImpl$updateDomNodeRecordFile$1$1$domRecordJson$1
                }.getType());
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(\n         \u2026ype\n                    )");
                File recordFile = this$0.getRecordFile(bundleName, i3, renderTag);
                if (recordFile.exists()) {
                    this$0.colorLogI("[updateDomNodeRecordFile] file already exists:" + recordFile.getAbsolutePath() + "}");
                } else {
                    boolean writeFile = FileUtils.writeFile(recordFile.getAbsolutePath(), json);
                    this$0.colorLogI("[updateDomNodeRecordFile] bundleName:" + bundleName + ",domListJsonIsEmpty:" + TextUtils.isEmpty(json) + ",filePath:" + recordFile.getAbsolutePath() + ",cost:" + (this$0.getTimeStamp() - currentTimeMillis) + ",result:" + writeFile);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void userLogE(Throwable e16, String msg2) {
        QLog.e(TAG, 1, e16, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void userLogI(String msg2) {
        QLog.i(TAG, 1, msg2);
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    @Nullable
    public HippyRootView addSnapshotRootViewIfNeed(@Nullable final HippyEngine engine, @Nullable final ViewGroup container, @Nullable final String bundleName, int bundleVersion, @Nullable String preRenderTag, @Nullable HippyEngine.ModuleLoadParams loadParams, @Nullable IHippyDomNodeManager.SnapshotLoadListener loadListener) {
        Integer num;
        long timeStamp = getTimeStamp();
        final HippyRootView restoreInstanceState = restoreInstanceState(engine, bundleName, bundleVersion, preRenderTag, loadParams, loadListener);
        if (restoreInstanceState != null) {
            listenOnChildAdd(restoreInstanceState, timeStamp, loadListener);
            if (container != null) {
                container.addView(restoreInstanceState);
            }
            HandlerCompat.postDelayed(ThreadManagerV2.getUIHandlerV2(), new Runnable() { // from class: com.tencent.hippy.qq.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    HippyDomNodeManagerImpl.addSnapshotRootViewIfNeed$lambda$4$lambda$3(HippyDomNodeManagerImpl.this, bundleName, engine, container, restoreInstanceState);
                }
            }, restoreInstanceState, 3000L);
        }
        if (restoreInstanceState != null) {
            num = Integer.valueOf(restoreInstanceState.hashCode());
        } else {
            num = null;
        }
        colorLogI("[addSnapShotRootViewIfNeed] snapShotRootView:" + num);
        return restoreInstanceState;
    }

    public final boolean checkSwitch() {
        if (getHippyDomConfigBean().getPreNodeSnapshotSwitch() == 1 && !HippyUtils.isPadOrFoldDevice()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    public void deleteDomNodeCache(@Nullable final String bundleName, final int bundleVersion, @Nullable final String renderTag) {
        if (TextUtils.isEmpty(bundleName)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                HippyDomNodeManagerImpl.deleteDomNodeCache$lambda$7(HippyDomNodeManagerImpl.this, bundleName, bundleVersion, renderTag);
            }
        }, 64, null, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        String str;
        this.app = appRuntime;
        if (appRuntime != null) {
            str = appRuntime.getAccount();
        } else {
            str = null;
        }
        this.account = str;
        colorLogI("[onCreate] " + this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        colorLogI("[onDestroy] " + this);
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    public void removeSnapshotRootViewIfNeed(@Nullable HippyEngine engine, @Nullable ViewGroup container, @Nullable HippyRootView snapShotRootView) {
        HippyEngine.EngineState engineState;
        Integer num = null;
        if (snapShotRootView != null) {
            if (snapShotRootView.getContext() instanceof Activity) {
                Context context = snapShotRootView.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (((Activity) context).isFinishing()) {
                    return;
                }
            }
            ThreadManagerV2.getUIHandlerV2().removeCallbacksAndMessages(snapShotRootView);
            if (container != null) {
                try {
                    container.removeView(snapShotRootView);
                } catch (Exception e16) {
                    userLogE(e16, "[removeSnapshotRootViewIfNeed]");
                }
            }
            if (engine != null) {
                engineState = engine.getEngineState();
            } else {
                engineState = null;
            }
            if (engineState != HippyEngine.EngineState.DESTROYED && engine != null) {
                engine.destroyInstanceState(snapShotRootView);
            }
        }
        if (snapShotRootView != null) {
            num = Integer.valueOf(snapShotRootView.hashCode());
        }
        userLogI("[removeSnapShotRootViewIfNeed] snapShotRootView:" + num);
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    public void reportSnapshotShow(@Nullable String bundleName, int bundleVersion, long costTime, boolean success, @NotNull String errMsg) {
        int i3;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("render_cost", String.valueOf(costTime));
        hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, errMsg);
        HippyReporter hippyReporter = HippyReporter.getInstance();
        if (success) {
            i3 = 0;
        } else {
            i3 = -1;
        }
        hippyReporter.reportToDengTa(bundleName, bundleVersion, HippyReporter.EventCode.HIPPY_PRERENDER_SHOW, i3, hashMap);
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    @Nullable
    public HippyRootView restoreInstanceState(@Nullable HippyEngine engine, @Nullable String bundleName, int bundleVersion, @Nullable String preRenderTag, @Nullable HippyEngine.ModuleLoadParams loadParams, @Nullable IHippyDomNodeManager.SnapshotLoadListener loadListener) {
        if (!checkSwitch()) {
            userLogI("[restoreInstanceState] switch is close");
            return null;
        }
        userLogI("[restoreInstanceState] " + bundleName + "/" + bundleVersion + "/" + preRenderTag);
        if (engine != null && bundleName != null && loadParams != null) {
            File recordFile = getRecordFile(bundleName, bundleVersion, preRenderTag);
            if (recordFile.exists()) {
                try {
                    long timeStamp = getTimeStamp();
                    String readFileContent = FileUtils.readFileContent(recordFile);
                    long timeStamp2 = getTimeStamp();
                    colorLogI("[restoreInstanceState] read file cost:" + (timeStamp2 - timeStamp));
                    Companion.DomRecordData domRecordData = (Companion.DomRecordData) new Gson().fromJson(readFileContent, new TypeToken<Companion.DomRecordData>() { // from class: com.tencent.hippy.qq.api.impl.HippyDomNodeManagerImpl$restoreInstanceState$recordData$1
                    }.getType());
                    colorLogI("[restoreInstanceState] from json cost:" + (getTimeStamp() - timeStamp2));
                    if (!checkDataValid(domRecordData)) {
                        notifyFailedAndDelete(loadListener, "recordData is invalid", recordFile);
                        return null;
                    }
                    Intrinsics.checkNotNull(domRecordData);
                    return getSnapshotRootView(engine, getRecordListFromData(domRecordData), loadParams);
                } catch (Exception e16) {
                    userLogE(e16, "[restoreInstanceState] error,delete file " + bundleName + " " + bundleVersion + " " + preRenderTag);
                    notifyFailedAndDelete(loadListener, e16.toString(), recordFile);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.api.IHippyDomNodeManager
    public void saveInstanceState(int bundleVersion, @NotNull String bundleName, int renderVersion, @Nullable JSONObject renderData, @NotNull String renderTag, @NotNull ArrayList<DomNodeRecord> recordList) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(renderTag, "renderTag");
        Intrinsics.checkNotNullParameter(recordList, "recordList");
        if (!checkSwitch()) {
            userLogI("[saveInstanceState] switch is close");
            return;
        }
        userLogI("[saveInstanceState]:" + bundleName + "/" + bundleVersion + "/" + renderTag + ",recordList:" + recordList.size());
        updateDomNodeRecordFile(bundleVersion, bundleName, renderVersion, renderData, renderTag, recordList);
        reportSaveNodeRecord(recordList, bundleName, bundleVersion);
    }
}
