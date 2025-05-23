package com.tencent.mobileqq.zootopia.download;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0015H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\bH&J\b\u0010\u001b\u001a\u00020\bH&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H&J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!H&J\b\u0010#\u001a\u00020\rH&J\b\u0010$\u001a\u00020\rH&J\b\u0010%\u001a\u00020\rH&J\b\u0010&\u001a\u00020\rH&J\u001c\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0(\u0018\u00010'H&J\b\u0010*\u001a\u00020\rH&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/x;", "", "", "d", "startDownload", "pause", "delete", "f", "", "getDownloadStatus", "getFailCode", "", "getFailInfo", "", "c", "canPause", "getTaskId", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", HippyQQPagView.FunctionName.GET_PROGRESS, "", "getReceivedLength", "getTotalLength", "Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadResult;", "j", "getRealTimeSpeed", "getAverageSpeed", "Lcom/tencent/mobileqq/zootopia/download/y;", "listener", tl.h.F, "singleProgress", "k", "Lkotlin/Pair;", "getIndex", DomainData.DOMAIN_NAME, "e", "g", "i", "", "", "getHttpRspHeaderMap", "l", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface x {
    String b();

    boolean c();

    boolean canPause();

    void d();

    void delete();

    boolean e();

    void f();

    boolean g();

    int getAverageSpeed();

    int getDownloadStatus();

    int getFailCode();

    String getFailInfo();

    Map<String, List<String>> getHttpRspHeaderMap();

    Pair<Integer, Integer> getIndex();

    float getProgress();

    int getRealTimeSpeed();

    long getReceivedLength();

    String getTaskId();

    long getTotalLength();

    void h(y listener);

    boolean i();

    ZPlanFileDownloadResult j();

    float k(float singleProgress);

    boolean l();

    String m();

    boolean n();

    void pause();

    void startDownload();
}
