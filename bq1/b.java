package bq1;

import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "", "c", "", "inviteCode", "", "a", "Lbq1/a;", "b", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    public static final void a(@NotNull JumpGuildParam jumpGuildParam, @NotNull String inviteCode) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "<this>");
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        JumpGuildParam.JoinInfoParam joinInfoParam = jumpGuildParam.getJoinInfoParam();
        joinInfoParam.setJoinSignature(jumpGuildParam.guildId + "\uff5c^\uff5c" + jumpGuildParam.getChannelId() + "\uff5c^\uff5c" + jumpGuildParam.businessType + "\uff5c^\uff5c" + inviteCode);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("update joinSignature to ");
        sb5.append(joinInfoParam.getJoinSignature());
        QLog.d("JumpGuildParamExt", 1, sb5.toString());
    }

    @NotNull
    public static final JoinInfoParamData b(@NotNull JumpGuildParam jumpGuildParam) {
        List split$default;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(jumpGuildParam, "<this>");
        if (c(jumpGuildParam)) {
            String joinSignature = jumpGuildParam.getJoinSignature();
            Intrinsics.checkNotNullExpressionValue(joinSignature, "joinSignature");
            split$default = StringsKt__StringsKt.split$default((CharSequence) joinSignature, new String[]{"\uff5c^\uff5c"}, false, 0, 6, (Object) null);
            int i3 = 0;
            String str = (String) split$default.get(0);
            String str2 = (String) split$default.get(1);
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(2));
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            return new JoinInfoParamData(str, str2, i3, (String) split$default.get(3));
        }
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r0, new java.lang.String[]{"\uff5c^\uff5c"}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(@NotNull JumpGuildParam jumpGuildParam) {
        List split$default;
        Intrinsics.checkNotNullParameter(jumpGuildParam, "<this>");
        String joinSignature = jumpGuildParam.getJoinInfoParam().getJoinSignature();
        if (joinSignature == null || split$default == null || split$default.size() != 4) {
            return false;
        }
        return true;
    }
}
