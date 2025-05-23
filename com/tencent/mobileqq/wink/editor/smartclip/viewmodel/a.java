package com.tencent.mobileqq.wink.editor.smartclip.viewmodel;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.TemplateFixedClipConfig;
import e93.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0015j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u0012\u0010#\"\u0004\b$\u0010%R&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "", "isUsingTemplate", "", "j", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "data", "i", "", "mid", "d", "e", "a", "f", "b", "Z", "manualTurnOnSmartClip", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "musicStuckPointInfoCache", "isUserOpCloseSmartClip", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", h.F, "(Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;)V", "templateMusicInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "g", "(Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;)V", "templateFixedClipConfig", "", "Ljava/util/Map;", "backupData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f321532a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean manualTurnOnSmartClip = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckPointInfoCache = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isUserOpCloseSmartClip;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MusicInfo templateMusicInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TemplateFixedClipConfig templateFixedClipConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Map<String, ? extends Object> backupData;

    a() {
    }

    @JvmStatic
    public static final void j(@NotNull List<? extends LocalMediaInfo> mediaInfoList, boolean isUsingTemplate) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        boolean z16 = true;
        if (isUsingTemplate) {
            manualTurnOnSmartClip = true;
            return;
        }
        int i3 = 0;
        int i16 = 0;
        boolean z17 = true;
        boolean z18 = true;
        for (LocalMediaInfo localMediaInfo : mediaInfoList) {
            if (i.I(localMediaInfo)) {
                i3++;
                z17 = false;
            }
            if (i.G(localMediaInfo)) {
                i16++;
                z18 = false;
            }
        }
        if (!z17 && !z18) {
            manualTurnOnSmartClip = true;
            return;
        }
        if (z17) {
            if (i16 <= 1) {
                z16 = false;
            }
            manualTurnOnSmartClip = z16;
        } else {
            if (i3 <= 3) {
                z16 = false;
            }
            manualTurnOnSmartClip = z16;
        }
    }

    public final void a() {
        Map<String, ? extends Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("manualTurnOnSmartClip", Boolean.valueOf(manualTurnOnSmartClip)), TuplesKt.to("musicStuckPointInfoCache", musicStuckPointInfoCache), TuplesKt.to("isUserOpCloseSmartClip", Boolean.valueOf(isUserOpCloseSmartClip)), TuplesKt.to("templateMusicInfo", templateMusicInfo), TuplesKt.to("templateFixedClipConfig", templateFixedClipConfig));
        backupData = mutableMapOf;
    }

    @Nullable
    public final TemplateFixedClipConfig b() {
        return templateFixedClipConfig;
    }

    @Nullable
    public final MusicInfo c() {
        return templateMusicInfo;
    }

    @Nullable
    public final QQCircleSmartMatchMusic$MusicStuckPointInfo d(@Nullable String mid) {
        if (mid == null) {
            return null;
        }
        return musicStuckPointInfoCache.get(mid);
    }

    public final void e() {
        manualTurnOnSmartClip = true;
        isUserOpCloseSmartClip = false;
        templateMusicInfo = null;
        templateFixedClipConfig = null;
    }

    public final void f() {
        Map<String, ? extends Object> map = backupData;
        if (map != null) {
            Object obj = map.get("manualTurnOnSmartClip");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            manualTurnOnSmartClip = ((Boolean) obj).booleanValue();
            Object obj2 = map.get("musicStuckPointInfoCache");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, qqcircle.QQCircleSmartMatchMusic.MusicStuckPointInfo>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, qqcircle.QQCircleSmartMatchMusic.MusicStuckPointInfo> }");
            musicStuckPointInfoCache = (HashMap) obj2;
            Object obj3 = map.get("isUserOpCloseSmartClip");
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            isUserOpCloseSmartClip = ((Boolean) obj3).booleanValue();
            templateMusicInfo = (MusicInfo) map.get("templateMusicInfo");
            templateFixedClipConfig = (TemplateFixedClipConfig) map.get("templateFixedClipConfig");
        }
    }

    public final void g(@Nullable TemplateFixedClipConfig templateFixedClipConfig2) {
        templateFixedClipConfig = templateFixedClipConfig2;
    }

    public final void h(@Nullable MusicInfo musicInfo) {
        templateMusicInfo = musicInfo;
    }

    public final void i(@NotNull List<QQCircleSmartMatchMusic$MusicStuckPointInfo> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        for (QQCircleSmartMatchMusic$MusicStuckPointInfo qQCircleSmartMatchMusic$MusicStuckPointInfo : data) {
            HashMap<String, QQCircleSmartMatchMusic$MusicStuckPointInfo> hashMap = musicStuckPointInfoCache;
            String str = qQCircleSmartMatchMusic$MusicStuckPointInfo.mid.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.mid.get()");
            hashMap.put(str, qQCircleSmartMatchMusic$MusicStuckPointInfo);
        }
    }
}
