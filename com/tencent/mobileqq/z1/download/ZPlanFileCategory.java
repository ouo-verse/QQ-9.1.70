package com.tencent.mobileqq.z1.download;

import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/z1/download/ZPlanFileCategory;", "", "value", "", "desc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "()I", "DRESS", ComponentFactory.ComponentType.PAG, "IMAGE", "SAME_STYLE_PAK", "MP3_RES", "EMOTICON", "VIDEO", "FILAMENT", "RES_HUB", "LuaDownload", "Mod", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum ZPlanFileCategory {
    DRESS(1, "Dress"),
    PAG(10, "Pag"),
    IMAGE(11, "Image"),
    SAME_STYLE_PAK(13, "SameStylePak"),
    MP3_RES(14, "Mp3"),
    EMOTICON(15, "Emoticon"),
    VIDEO(16, ComponentFactory.ComponentType.VIDEO),
    FILAMENT(17, "Filament"),
    RES_HUB(18, "ResHub"),
    LuaDownload(99, "L2N_Download"),
    Mod(100, "ZPlanMod");


    @NotNull
    private final String desc;
    private final int value;

    ZPlanFileCategory(int i3, String str) {
        this.value = i3;
        this.desc = str;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    /* synthetic */ ZPlanFileCategory(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }
}
