package com.tencent.qcircle.weishi.module.publisher;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0015j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qcircle/weishi/module/publisher/LightTemplateManager;", "", "()V", "COVER_OFFSET", "", "FONT_PROGRESS", "", "LIGHTSDK_BASE_FILE_PROGRESS", "MUSIC_PROGRESS", "PERCENT_10", "", "PERCENT_30", "RED_PACKET_KEY", "TAG", "TEMPLATE_JSON", "TEMPLATE_PROGRESS", "downloadFontComplete", "", "downloadMusicComplete", "fetchMusicInfoComplete", "progressCache", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class LightTemplateManager {
    private static final long COVER_OFFSET = 700;
    private static final String FONT_PROGRESS = "font_progress";
    private static final String LIGHTSDK_BASE_FILE_PROGRESS = "lightsdk_progress";
    private static final String MUSIC_PROGRESS = "music_progress";
    private static final float PERCENT_10 = 0.1f;
    private static final float PERCENT_30 = 0.3f;

    @NotNull
    public static final String RED_PACKET_KEY = "hongbao";
    private static final String TAG = "LightTemplateManager";
    private static final String TEMPLATE_JSON = "template.json";
    private static final String TEMPLATE_PROGRESS = "template__progress";
    private static boolean downloadFontComplete;
    private static boolean downloadMusicComplete;
    private static boolean fetchMusicInfoComplete;
    public static final LightTemplateManager INSTANCE = new LightTemplateManager();
    private static HashMap<String, Float> progressCache = new HashMap<>();

    LightTemplateManager() {
    }
}
