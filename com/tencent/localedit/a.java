package com.tencent.localedit;

import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\b\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0001\u0010\r\"#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0006\u0010\r\"\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lkotlin/text/Regex;", "a", "Lkotlin/text/Regex;", "getDOCUMENT_DATA_VERSION_REGEX", "()Lkotlin/text/Regex;", "DOCUMENT_DATA_VERSION_REGEX", "b", "c", "LOCAL_EDIT_ROUTE_REGEX", "", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "DOCS_NAME_TO_TYPE", "d", "DOCS_TYPE_TO_NAME", "", "e", "Ljava/util/List;", "()Ljava/util/List;", "SUPPORT_DOMAIN", "docx_local_edit_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Regex f119888a = new Regex("^(\\d+\\.\\d+)(\\.\\d+)*$");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Regex f119889b = new Regex("^(?:(?:https|http)://)docs.qq.com/(doc|sheet|slide|form/edit|form/fill|form/page|pdf|flowchart|mind|aio|mall|document)/local_edit(?:\\?.*)*");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, Integer> f119890c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, String> f119891d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<String> f119892e;

    static {
        List<String> listOf;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(FileReaderHelper.DOC_EXT, 0);
        concurrentHashMap.put("sheet", 1);
        concurrentHashMap.put(WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, 4);
        concurrentHashMap.put(FileReaderHelper.PDF_EXT, 6);
        f119890c = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        concurrentHashMap2.put(0, FileReaderHelper.DOC_EXT);
        concurrentHashMap2.put(1, "sheet");
        concurrentHashMap2.put(4, WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE);
        concurrentHashMap2.put(6, FileReaderHelper.PDF_EXT);
        f119891d = concurrentHashMap2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{ITeamWorkHandler.DOCS_DOMAIN, "doc.weixin.qq.com"});
        f119892e = listOf;
    }

    @NotNull
    public static final Map<String, Integer> a() {
        return f119890c;
    }

    @NotNull
    public static final Map<Integer, String> b() {
        return f119891d;
    }

    @NotNull
    public static final Regex c() {
        return f119889b;
    }

    @NotNull
    public static final List<String> d() {
        return f119892e;
    }
}
