package h34;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\u0006\u0010\u0007\u001a\u00020\u0005\"\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "", "c", "g", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "b", "a", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;)Z", "isInlineSearchCommand", "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;)Z", "isInlineSearchEnabled", "robot-business-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    @NotNull
    public static final CommonBotFeatureInfo a() {
        CommonBotFeatureInfo commonBotFeatureInfo = new CommonBotFeatureInfo();
        commonBotFeatureInfo.f359162id = 1;
        commonBotFeatureInfo.name = "/\u641c\u7d22";
        commonBotFeatureInfo.desc = "\u8f93\u5165\u5173\u952e\u8bcd\u53ef\u641c\u7d22\u76f8\u5173\u5185\u5bb9";
        commonBotFeatureInfo.status = 0;
        commonBotFeatureInfo.type = 0;
        return commonBotFeatureInfo;
    }

    public static final boolean b(@NotNull CommonBotFeatureInfo commonBotFeatureInfo) {
        Intrinsics.checkNotNullParameter(commonBotFeatureInfo, "<this>");
        if (commonBotFeatureInfo.status == 0) {
            return true;
        }
        return false;
    }

    public static final boolean c(@NotNull CommonBotInfo commonBotInfo) {
        Intrinsics.checkNotNullParameter(commonBotInfo, "<this>");
        if ((commonBotInfo.mark & 1024) > 0) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull CommonBotFeatureInfo commonBotFeatureInfo) {
        CharSequence trim;
        Intrinsics.checkNotNullParameter(commonBotFeatureInfo, "<this>");
        if (commonBotFeatureInfo.type == 0) {
            String name = commonBotFeatureInfo.name;
            Intrinsics.checkNotNullExpressionValue(name, "name");
            trim = StringsKt__StringsKt.trim((CharSequence) name);
            if (Intrinsics.areEqual("/\u641c\u7d22", trim.toString())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(@NotNull CommonBotInfo commonBotInfo) {
        Intrinsics.checkNotNullParameter(commonBotInfo, "<this>");
        if (commonBotInfo.inlineSearch == 1) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull CommonBotInfo commonBotInfo) {
        Intrinsics.checkNotNullParameter(commonBotInfo, "<this>");
        if ((commonBotInfo.mark & 32768) > 0) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull CommonBotInfo commonBotInfo) {
        Intrinsics.checkNotNullParameter(commonBotInfo, "<this>");
        if ((commonBotInfo.mark & 8) > 0) {
            return true;
        }
        return false;
    }
}
