package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/o;", "Lcom/tencent/freesia/IConfigData;", "", "d", "I", "getPanelCloseTimeoutMillis", "()I", "setPanelCloseTimeoutMillis", "(I)V", "panelCloseTimeoutMillis", "", "e", "Ljava/lang/String;", "getAiModeTitle", "()Ljava/lang/String;", "setAiModeTitle", "(Ljava/lang/String;)V", "aiModeTitle", "f", "a", "setLoadingText", "loadingText", tl.h.F, "getEmptyText", "setEmptyText", "emptyText", "<init>", "()V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o implements IConfigData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int panelCloseTimeoutMillis = 2000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String aiModeTitle = "AI\u641c\u7d22";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String loadingText = "\u6b63\u5728\u5206\u6790\u95ee\u9898";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String emptyText = "\u6682\u65e0\u76f8\u5173\u641c\u7d22\u7ed3\u679c";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/o$a;", "", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/o;", "a", "", "DEFAULT_EMPTY_TEXT", "Ljava/lang/String;", "DEFAULT_LOADING_TEXT", "DEFAULT_TITLE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.o$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final o a() {
            return new o();
        }

        Companion() {
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getLoadingText() {
        return this.loadingText;
    }
}
