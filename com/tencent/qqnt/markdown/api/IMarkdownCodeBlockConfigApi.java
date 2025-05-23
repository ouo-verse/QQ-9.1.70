package com.tencent.qqnt.markdown.api;

import android.content.Context;
import com.tencent.android.androidbypass.codeblock.config.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/markdown/api/IMarkdownCodeBlockConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isEnableCodeBlockHighlight", "", "getCodeBlockMaxLineCountInAIO", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "code", "", "openViewAllCodeBlockPage", "Lcom/tencent/android/androidbypass/codeblock/config/c;", "buildCodeBlockConfigForAIO", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IMarkdownCodeBlockConfigApi extends QRouteApi {
    @NotNull
    c buildCodeBlockConfigForAIO(@NotNull Context context);

    int getCodeBlockMaxLineCountInAIO();

    boolean isEnableCodeBlockHighlight();

    void openViewAllCodeBlockPage(@NotNull Context context, @NotNull String language, @NotNull String code);
}
