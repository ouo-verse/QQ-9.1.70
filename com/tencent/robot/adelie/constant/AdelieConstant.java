package com.tencent.robot.adelie.constant;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/constant/AdelieConstant;", "", "", "", "", "b", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ErrorCodeMsg", "<init>", "()V", "ImageSource", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieConstant {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieConstant f365917a = new AdelieConstant();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Long, String> ErrorCodeMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/adelie/constant/AdelieConstant$ImageSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "MAGIC_ICON_FILLED", "ALBUM_UPLOADED", "AI_GENERATED", "NO_CHANGE", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public enum ImageSource {
        MAGIC_ICON_FILLED(1),
        ALBUM_UPLOADED(2),
        AI_GENERATED(3),
        NO_CHANGE(4);

        private final int value;

        ImageSource(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    static {
        Map<Long, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1001L, "\u8bf7\u4e0a\u4f20\u4eba\u50cf\u7167\u7247"), TuplesKt.to(Long.valueOf(Constant.FROM_ID_UNINSTALL_PLUGIN), "\u8bf7\u4e0a\u4f20\u6b63\u8138\u7167\u7247"), TuplesKt.to(1006L, "\u65e0\u6cd5\u8bc6\u522b\u4eba\u8138\uff0c\u8bf7\u66f4\u6362\u56fe\u7247"), TuplesKt.to(1007L, "\u65e0\u6cd5\u8bc6\u522b\u4eba\u8138\uff0c\u8bf7\u66f4\u6362\u56fe\u7247"), TuplesKt.to(1091L, "\u65e0\u6cd5\u8bc6\u522b\u4eba\u8138\uff0c\u8bf7\u66f4\u6362\u56fe\u7247"), TuplesKt.to(-2100L, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9\u98ce\u683c"), TuplesKt.to(2114L, "\u8be5\u56fe\u7247\u65e0\u6cd5\u751f\u6210\uff0c\u8bf7\u66f4\u6362"), TuplesKt.to(2121L, "\u8be5\u6587\u672c\u65e0\u6cd5\u751f\u6210\uff0c\u8bf7\u66f4\u6362"), TuplesKt.to(2123L, "\u8be5\u6587\u672c\u65e0\u6cd5\u751f\u6210\uff0c\u8bf7\u66f4\u6362"), TuplesKt.to(7001L, "\u8be5\u6587\u672c\u65e0\u6cd5\u751f\u6210\uff0c\u8bf7\u66f4\u6362"), TuplesKt.to(-2110L, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(2111L, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(21L, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(102L, "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(2124L, "\u8bf7\u66f4\u6362\u8f93\u5165\u540e\u91cd\u8bd5"));
        ErrorCodeMsg = mapOf;
    }

    AdelieConstant() {
    }

    @NotNull
    public final Map<Long, String> a() {
        return ErrorCodeMsg;
    }
}
