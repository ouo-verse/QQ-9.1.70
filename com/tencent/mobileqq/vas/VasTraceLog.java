package com.tencent.mobileqq.vas;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTraceLog;", "", "()V", "isHit", "", "GiftRepo", "Theme", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasTraceLog {

    @NotNull
    public static final VasTraceLog INSTANCE = new VasTraceLog();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTraceLog$GiftRepo;", "", "()V", "GIFT_TEST", "Lcom/tencent/mobileqq/vas/VasTraceLogProxy;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class GiftRepo {

        @NotNull
        public static final GiftRepo INSTANCE = new GiftRepo();

        @JvmField
        @NotNull
        public static final VasTraceLogProxy GIFT_TEST = new VasTraceLogProxy("get_scene_item", null, 2, null);

        GiftRepo() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTraceLog$Theme;", "", "()V", "THEME_SWITCH", "Lcom/tencent/mobileqq/vas/VasTraceLogProxy;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Theme {

        @NotNull
        public static final Theme INSTANCE = new Theme();

        @JvmField
        @NotNull
        public static final VasTraceLogProxy THEME_SWITCH = new VasTraceLogProxy("theme_switch", null, 2, null);

        Theme() {
        }
    }

    VasTraceLog() {
    }

    @JvmStatic
    public static final boolean isHit() {
        return VasTraceLogProxy.INSTANCE.isHit();
    }
}
