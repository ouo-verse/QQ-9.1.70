package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.List;
import kn2.d;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/api/IGroupSearchHistoryManager;", "Lmqq/app/api/IRuntimeService;", "Lkn2/d;", "listener", "", "register", "unregister", "", "", "getGroupSearchHistory", "keyword", "add", "delete", QCircleLpReportDc05507.KEY_CLEAR, "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface IGroupSearchHistoryManager extends IRuntimeService {
    void add(@NotNull String keyword);

    void clear();

    void delete(@NotNull String keyword);

    @NotNull
    List<String> getGroupSearchHistory();

    void register(@NotNull d listener);

    void unregister(@NotNull d listener);
}
