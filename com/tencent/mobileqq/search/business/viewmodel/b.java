package com.tencent.mobileqq.search.business.viewmodel;

import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qqnt.kernel.nativeinterface.UfsTabItemGroup;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jd\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/business/viewmodel/b;", "", "", "keyword", "", "isFirstReq", PreDownloadConstants.RPORT_KEY_REQ_TIME, "", "cookie", "isEnd", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsTabItemGroup;", "tabList", "Lcom/tencent/mobileqq/search/model/x;", "result", "", "subId", "showModelForEntrance", "Lwp2/b;", "sortInfoConfig", "", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {
    void a(@NotNull String keyword, boolean isFirstReq, @NotNull String reqTime, @NotNull byte[] cookie, boolean isEnd, @NotNull List<UfsTabItemGroup> tabList, @NotNull List<? extends x> result, int subId, boolean showModelForEntrance, @NotNull wp2.b sortInfoConfig);
}
