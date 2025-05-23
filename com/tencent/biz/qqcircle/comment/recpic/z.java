package com.tencent.biz.qqcircle.comment.recpic;

import android.app.Activity;
import android.os.Process;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.comment.recpic.sorter.SortConfig;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import u20.PermissionFeedGuideConfig;
import u20.PermissionInputBarConfig;
import u20.PermissionPanelGuideConfig;
import u20.QFSFeedCateConfig;
import u20.QFSFeedDescCateConfig;
import u20.QFSInputConfig;
import u20.QFSKMeansConfig;
import u20.QFSPipelineConfig;
import u20.QFSSafeStrategyConfig;
import u20.QFSScanConfig;
import u20.QFSTextConfig;
import u20.RecFeedGuideConfig;
import u20.RecPanelGuideConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bg\u0010hJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001dJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010#\u001a\u00020\"J\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020&J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001fJ\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020,J*\u00103\u001a\u00020\b2\u0006\u0010/\u001a\u00020.2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004002\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000600J\u0010\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000104J\u0016\u00109\u001a\u00020\b2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020*J\u0006\u0010:\u001a\u00020,J\u000e\u0010;\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010<\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010?\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010=J\u0006\u0010@\u001a\u00020\nR\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010BR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020 0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020H0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010FR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010KR\u0016\u0010N\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010MR\u0016\u0010P\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010RR\u0016\u0010U\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010TR\u0016\u0010W\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010VR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020(008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010XR\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010ZR\u0016\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\\R\u0016\u0010_\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010^R\u0016\u0010b\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010aR\u0016\u0010d\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010cR\u0016\u0010f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/z;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "rate", "", "scene", "", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "Lorg/json/JSONObject;", "jsonObj", "E", "y", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", "v", "Lu20/d;", "k", "Lu20/a;", DomainData.DOMAIN_NAME, "Lu20/c;", "p", "Lu20/b;", "o", "Lu20/m;", "r", "", "Lcom/tencent/biz/qqcircle/comment/recpic/ab;", "j", "Lu20/g;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lu20/k;", "w", "Lu20/f;", "l", "Lu20/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "", "t", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "result", "", "unsafeSimilarity", "unsafeIds", "f", "", "feature", "g", "startOffset", "scanStartTime", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "d", "e", "Lt20/a;", "scanListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "i", "b", "Z", "isConfigParsing", "isConfigParsed", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "feedCategoryConfigList", "Lu20/i;", "safeStrategyConfigList", "Lu20/e;", "Lu20/e;", "feedDescConfig", "Lu20/g;", "kMeansConfig", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", "sortConfig", "Lu20/j;", "Lu20/j;", "scanConfig", "Lu20/k;", "textConfig", "Lu20/f;", "inputConfig", "Ljava/util/List;", "pipelineConfig", "Lu20/a;", "permissionFeedGuide", "Lu20/c;", "permissionPanelGuideConfig", "Lu20/b;", "permissionInputBarConfig", "Lu20/l;", "Lu20/l;", "recFeedGuideConfig", "Lu20/m;", "recPanelGuideConfig", "Lu20/d;", "feedPicExposeConfig", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class z {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isConfigParsing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isConfigParsed;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<QFSPipelineConfig> pipelineConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static PermissionFeedGuideConfig permissionFeedGuide;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static PermissionPanelGuideConfig permissionPanelGuideConfig;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static PermissionInputBarConfig permissionInputBarConfig;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static RecFeedGuideConfig recFeedGuideConfig;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static RecPanelGuideConfig recPanelGuideConfig;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSFeedCateConfig feedPicExposeConfig;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z f83900a = new z();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<QFSFeedCategoryConfig> feedCategoryConfigList = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<QFSSafeStrategyConfig> safeStrategyConfigList = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSFeedDescCateConfig feedDescConfig = new QFSFeedDescCateConfig(0.0f, null, 3, null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSKMeansConfig kMeansConfig = new QFSKMeansConfig(0, 0, 0.0d, null, 15, null);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SortConfig sortConfig = new SortConfig(null, 0.0f, 0.0f, 0, null, 0, 0, 0, 0, 0, 1023, null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSScanConfig scanConfig = QFSScanConfig.INSTANCE.a(new JSONObject());

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSTextConfig textConfig = QFSTextConfig.INSTANCE.a(new JSONObject());

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QFSInputConfig inputConfig = new QFSInputConfig(0, 0, 3, null);

    static {
        List<QFSPipelineConfig> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QFSPipelineConfig(1, 0.0f, 2, null), new QFSPipelineConfig(100, 0.0f, 2, null), new QFSPipelineConfig(101, 0.0f, 2, null), new QFSPipelineConfig(102, 0.0f, 2, null));
        pipelineConfig = mutableListOf;
        permissionFeedGuide = new PermissionFeedGuideConfig(0L, 0, 0L, 0, 15, null);
        permissionPanelGuideConfig = new PermissionPanelGuideConfig(0, 0L, 3, null);
        permissionInputBarConfig = new PermissionInputBarConfig(0, 1, null);
        recFeedGuideConfig = new RecFeedGuideConfig(0L, 0L, 0, 0, 15, null);
        recPanelGuideConfig = new RecPanelGuideConfig(0, 0, 3, null);
        feedPicExposeConfig = new QFSFeedCateConfig(0, 1, null);
    }

    z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(final t20.a aVar) {
        QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseJsonToConfig] parse config. ");
        final long currentTimeMillis = System.currentTimeMillis();
        z zVar = f83900a;
        zVar.y();
        zVar.z();
        zVar.F();
        zVar.D();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.y
            @Override // java.lang.Runnable
            public final void run() {
                z.C(currentTimeMillis, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(long j3, t20.a aVar) {
        isConfigParsing = false;
        isConfigParsed = true;
        QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseJsonToConfig] finish parse config, cost: " + (System.currentTimeMillis() - j3));
        QFSCommentRecPicClusterHelper.f83716a.O(aVar);
    }

    private final void D() {
        File file;
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_input_recom_config");
        if (TextUtils.isEmpty(resourcePath)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseOtherConfig] resourcePath is empty. ");
            return;
        }
        if (resourcePath != null) {
            try {
                file = new File(resourcePath);
            } catch (Exception e16) {
                QLog.e("QFSCommentRecPicConfigHelper", 1, e16, new Object[0]);
                return;
            }
        } else {
            file = null;
        }
        String readFileToString = FileUtils.readFileToString(file);
        if (TextUtils.isEmpty(readFileToString)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseOtherConfig] file is empty. ");
            return;
        }
        JSONObject jSONObject = new JSONObject(readFileToString);
        QFSTextConfig.Companion companion = QFSTextConfig.INSTANCE;
        JSONObject optJSONObject = jSONObject.optJSONObject("desc_config");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        textConfig = companion.a(optJSONObject);
        SortConfig.Companion companion2 = SortConfig.INSTANCE;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("sort_config");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        sortConfig = companion2.a(optJSONObject2);
        QFSKMeansConfig.Companion companion3 = QFSKMeansConfig.INSTANCE;
        JSONObject optJSONObject3 = jSONObject.optJSONObject("image_cluster_config");
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        kMeansConfig = companion3.b(optJSONObject3);
        PermissionFeedGuideConfig.Companion companion4 = PermissionFeedGuideConfig.INSTANCE;
        JSONObject optJSONObject4 = jSONObject.optJSONObject("permission_feed_guide");
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        permissionFeedGuide = companion4.a(optJSONObject4);
        PermissionPanelGuideConfig.Companion companion5 = PermissionPanelGuideConfig.INSTANCE;
        JSONObject optJSONObject5 = jSONObject.optJSONObject("permission_panel_guide");
        if (optJSONObject5 == null) {
            optJSONObject5 = new JSONObject();
        }
        permissionPanelGuideConfig = companion5.a(optJSONObject5);
        PermissionInputBarConfig.Companion companion6 = PermissionInputBarConfig.INSTANCE;
        JSONObject optJSONObject6 = jSONObject.optJSONObject("permission_inputbar_guide");
        if (optJSONObject6 == null) {
            optJSONObject6 = new JSONObject();
        }
        permissionInputBarConfig = companion6.a(optJSONObject6);
        RecFeedGuideConfig.Companion companion7 = RecFeedGuideConfig.INSTANCE;
        JSONObject optJSONObject7 = jSONObject.optJSONObject("rec_feed_guide");
        if (optJSONObject7 == null) {
            optJSONObject7 = new JSONObject();
        }
        recFeedGuideConfig = companion7.a(optJSONObject7);
        RecPanelGuideConfig.Companion companion8 = RecPanelGuideConfig.INSTANCE;
        JSONObject optJSONObject8 = jSONObject.optJSONObject("rec_panel_guide");
        if (optJSONObject8 == null) {
            optJSONObject8 = new JSONObject();
        }
        recPanelGuideConfig = companion8.a(optJSONObject8);
        QFSScanConfig.Companion companion9 = QFSScanConfig.INSTANCE;
        JSONObject optJSONObject9 = jSONObject.optJSONObject("scan_config");
        if (optJSONObject9 == null) {
            optJSONObject9 = new JSONObject();
        }
        scanConfig = companion9.a(optJSONObject9);
        QFSInputConfig.Companion companion10 = QFSInputConfig.INSTANCE;
        JSONObject optJSONObject10 = jSONObject.optJSONObject("input_trigger_config");
        if (optJSONObject10 == null) {
            optJSONObject10 = new JSONObject();
        }
        inputConfig = companion10.a(optJSONObject10);
        QFSFeedCateConfig.Companion companion11 = QFSFeedCateConfig.INSTANCE;
        JSONObject optJSONObject11 = jSONObject.optJSONObject("feed_cate_config");
        if (optJSONObject11 == null) {
            optJSONObject11 = new JSONObject();
        }
        feedPicExposeConfig = companion11.a(optJSONObject11);
        E(jSONObject);
    }

    private final void E(JSONObject jsonObj) {
        JSONObject optJSONObject = jsonObj.optJSONObject("pipeline_strategy_config");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (optJSONObject.length() != 0) {
            List<QFSPipelineConfig> list = pipelineConfig;
            list.clear();
            list.add(new QFSPipelineConfig(1, (float) optJSONObject.optDouble("1")));
            list.add(new QFSPipelineConfig(100, (float) optJSONObject.optDouble("100")));
            list.add(new QFSPipelineConfig(101, (float) optJSONObject.optDouble("101")));
            list.add(new QFSPipelineConfig(102, (float) optJSONObject.optDouble("102")));
        }
    }

    private final void F() {
        File file;
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_recom_image_safe_strategy_config");
        if (TextUtils.isEmpty(resourcePath)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseSafeStrategyConfig] resourcePath is empty. ");
            return;
        }
        if (resourcePath != null) {
            try {
                file = new File(resourcePath);
            } catch (Exception e16) {
                QLog.e("QFSCommentRecPicConfigHelper", 1, e16, new Object[0]);
                return;
            }
        } else {
            file = null;
        }
        String readFileToString = FileUtils.readFileToString(file);
        if (TextUtils.isEmpty(readFileToString)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseSafeStrategyConfig] file is empty. ");
        } else {
            safeStrategyConfigList.addAll(QFSSafeStrategyConfig.INSTANCE.a(new JSONArray(readFileToString)));
        }
    }

    private final boolean c(Activity activity, double rate, String scene) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        if (QFSCommentRecPicClusterHelper.f83716a.M() || !aa.f83750a.E(activity)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - uq3.k.a().f("stop_scan_timestamp", 0L);
        float g16 = CpuUtil.f258160a.g(Process.myPid());
        QLog.d("QFSCommentRecPicConfigHelper", 1, "[canRestartScan] cpuUsage: " + g16 + ", interval: " + currentTimeMillis + ", rate: " + rate);
        if (g16 < rate) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (currentTimeMillis > scanConfig.getCoolDownTime() * 1000) {
            z17 = true;
        } else {
            z17 = false;
        }
        ak akVar = ak.f83788a;
        if (z16 && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z17) {
            i3 = 1;
        } else if (!z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        akVar.m(new RestartScanResult(z18, i3, scene));
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    private final void y() {
        File file;
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_recom_multi_prompt_feed_category_config");
        if (TextUtils.isEmpty(resourcePath)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseFeedCategoryConfig] resourcePath is empty. ");
            return;
        }
        if (resourcePath != null) {
            try {
                file = new File(resourcePath);
            } catch (Exception e16) {
                QLog.e("QFSCommentRecPicConfigHelper", 1, e16, new Object[0]);
                return;
            }
        } else {
            file = null;
        }
        String readFileToString = FileUtils.readFileToString(file);
        if (TextUtils.isEmpty(readFileToString)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseFeedCategoryConfig] file is empty. ");
        } else {
            feedCategoryConfigList.addAll(QFSFeedCategoryConfig.INSTANCE.c(new JSONArray(readFileToString)));
        }
    }

    private final void z() {
        File file;
        String resourcePath = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getResourcePath("qqcircle_recom_feed_desc_guide_config");
        if (TextUtils.isEmpty(resourcePath)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseFeedDescConfig] resourcePath is empty. ");
            return;
        }
        if (resourcePath != null) {
            try {
                file = new File(resourcePath);
            } catch (Exception e16) {
                QLog.e("QFSCommentRecPicConfigHelper", 1, e16, new Object[0]);
                return;
            }
        } else {
            file = null;
        }
        String readFileToString = FileUtils.readFileToString(file);
        if (TextUtils.isEmpty(readFileToString)) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseFeedDescConfig] file is empty. ");
        } else {
            feedDescConfig = QFSFeedDescCateConfig.INSTANCE.b(new JSONObject(readFileToString));
        }
    }

    public final void A(@Nullable final t20.a scanListener) {
        if (isConfigParsing) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseJsonToConfig] config is parsing...");
        } else if (isConfigParsed) {
            QLog.d("QFSCommentRecPicConfigHelper", 1, "[parseJsonToConfig] config is already parsed. ");
            QFSCommentRecPicClusterHelper.f83716a.O(scanListener);
        } else {
            isConfigParsing = true;
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.x
                @Override // java.lang.Runnable
                public final void run() {
                    z.B(t20.a.this);
                }
            });
        }
    }

    public final boolean d(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return c(activity, scanConfig.getCmtScanCpuRate(), "cmt");
    }

    public final boolean e(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return c(activity, scanConfig.getFeedScanCpuRate(), "feed");
    }

    public final boolean f(@NotNull MediaScanForwardResult result, @NotNull List<Double> unsafeSimilarity, @NotNull List<String> unsafeIds) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(unsafeSimilarity, "unsafeSimilarity");
        Intrinsics.checkNotNullParameter(unsafeIds, "unsafeIds");
        if (!com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_REC_PIC_FILTER_UNSAFE_PIC, 1)) {
            return true;
        }
        CopyOnWriteArrayList<QFSSafeStrategyConfig> copyOnWriteArrayList = safeStrategyConfigList;
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        Iterator<QFSSafeStrategyConfig> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            QFSSafeStrategyConfig next = it.next();
            float A = QFSCommentRecPicClusterHelper.f83716a.A(next.getFeature(), result.getImageFeature());
            if (A > next.getThreshold()) {
                QLog.d("QFSCommentRecPicConfigHelper", 1, "[checkImageSafety] image is unSafe");
                unsafeSimilarity.add(Double.valueOf(A));
                unsafeIds.add(next.getStrategyId());
                return false;
            }
        }
        return true;
    }

    public final boolean g(@Nullable float[] feature) {
        if (!com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_REC_PIC_FILTER_UNSAFE_PIC, 1)) {
            return true;
        }
        CopyOnWriteArrayList<QFSSafeStrategyConfig> copyOnWriteArrayList = safeStrategyConfigList;
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        Iterator<QFSSafeStrategyConfig> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            QFSSafeStrategyConfig next = it.next();
            if (QFSCommentRecPicClusterHelper.f83716a.A(next.getFeature(), feature) > next.getThreshold()) {
                QLog.d("QFSCommentRecPicConfigHelper", 1, "[checkImageSafety] image is unSafe");
                return false;
            }
        }
        return true;
    }

    public final boolean h(int startOffset, long scanStartTime) {
        boolean z16;
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        int size = qFSCommentRecPicClusterHelper.I().size() - startOffset;
        long currentTimeMillis = System.currentTimeMillis() - scanStartTime;
        if (size <= scanConfig.getMaxCountOneCycle() && currentTimeMillis <= scanConfig.getTimeoutOneCycle() * 1000) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (size % 100 == 1) {
            QLog.d("QFSCommentRecPicConfigHelper", 4, "[checkScanLimit] startOffset: " + startOffset + ", total size: " + qFSCommentRecPicClusterHelper.I().size() + " scanSize: " + size + ", scanTime: " + currentTimeMillis + ", result: " + z16);
        }
        return z16;
    }

    public final void i() {
        isConfigParsing = false;
        isConfigParsed = false;
        feedCategoryConfigList.clear();
        safeStrategyConfigList.clear();
    }

    @NotNull
    public final List<QFSFeedCategoryConfig> j() {
        return feedCategoryConfigList;
    }

    @NotNull
    public final QFSFeedCateConfig k() {
        return feedPicExposeConfig;
    }

    @NotNull
    public final QFSInputConfig l() {
        return inputConfig;
    }

    @NotNull
    public final QFSKMeansConfig m() {
        return kMeansConfig;
    }

    @NotNull
    public final PermissionFeedGuideConfig n() {
        return permissionFeedGuide;
    }

    @NotNull
    public final PermissionInputBarConfig o() {
        return permissionInputBarConfig;
    }

    @NotNull
    public final PermissionPanelGuideConfig p() {
        return permissionPanelGuideConfig;
    }

    @NotNull
    public final List<QFSPipelineConfig> q() {
        return pipelineConfig;
    }

    @NotNull
    public final RecPanelGuideConfig r() {
        return recPanelGuideConfig;
    }

    public final int s() {
        return scanConfig.getMaxCount();
    }

    public final int t() {
        return permissionFeedGuide.getFeedPos();
    }

    public final long u() {
        return permissionFeedGuide.getVideoProcess() * 1000;
    }

    @NotNull
    public final SortConfig v() {
        return sortConfig;
    }

    @NotNull
    public final QFSTextConfig w() {
        return textConfig;
    }

    public final boolean x() {
        return isConfigParsed;
    }
}
