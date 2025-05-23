package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkABTestReportAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkABTestReportAPI;", "", "reportAllOfWinkPublishExperiment", "reportPlusMenuExperiment", "reportWinkEditorExperiment", "reportEnterQCircleExperiment", "", "", "abtest1505ExperimentReportList", "Ljava/util/List;", "abtest571ExperimentReportList", "abtest1505WinkEditorFragmentReportList", "abtest1505EnterQCircleReportList", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkABTestReportAPIImpl implements IQQWinkABTestReportAPI {

    @NotNull
    private static final String EXP_XSJ_PUBLISHER_MUSIC_PANEL = "exp_xsj_fabuqiyinyuemianbandiedai";

    @NotNull
    private static final String EXP_XSJ_UPLOAD_SHOT_ADD_MUSIC = "exp_xsj_upload_shoot_single_content_add_music";

    @NotNull
    private final List<String> abtest1505EnterQCircleReportList;

    @NotNull
    private final List<String> abtest1505ExperimentReportList;

    @NotNull
    private final List<String> abtest1505WinkEditorFragmentReportList;

    @NotNull
    private final List<String> abtest571ExperimentReportList;

    public QQWinkABTestReportAPIImpl() {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        List<String> listOf4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{EXP_XSJ_UPLOAD_SHOT_ADD_MUSIC, EXP_XSJ_PUBLISHER_MUSIC_PANEL, "xsp_xsj_dangshipinyoubgmbuzidongpeiyue", "exp_profile_page_layout_update_new", "exp_xsj_publish_add_yours", "exp_xsj_optimize_auto_music_2"});
        this.abtest1505ExperimentReportList = listOf;
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(w83.b.f445025a.v());
        this.abtest571ExperimentReportList = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf("exp_xsj_fabuqi_bianjiyegongnengchongxinpaixu");
        this.abtest1505WinkEditorFragmentReportList = listOf3;
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"exp_xsj_fabuqi_caogaotanchuangyouhua", "exp_xsj_publish_story_new_one", "xsp_xsj_fabuqi_sucaijuheyezhichishoucanghefenxiang", "xsp_xsj_fabuqi_feedyinyuefengmianchangzhu"});
        this.abtest1505EnterQCircleReportList = listOf4;
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI
    public void reportAllOfWinkPublishExperiment() {
        Iterator<String> it = this.abtest1505ExperimentReportList.iterator();
        while (it.hasNext()) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure(it.next());
        }
        Iterator<T> it5 = this.abtest571ExperimentReportList.iterator();
        while (it5.hasNext()) {
            ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport((String) it5.next());
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI
    public void reportEnterQCircleExperiment() {
        Iterator<T> it = this.abtest1505EnterQCircleReportList.iterator();
        while (it.hasNext()) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure((String) it.next());
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI
    public void reportWinkEditorExperiment() {
        Iterator<T> it = this.abtest1505WinkEditorFragmentReportList.iterator();
        while (it.hasNext()) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure((String) it.next());
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI
    public void reportPlusMenuExperiment() {
    }
}
