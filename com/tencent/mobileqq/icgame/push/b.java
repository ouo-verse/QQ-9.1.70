package com.tencent.mobileqq.icgame.push;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/push/b;", "", "", "Lbz0/c;", "infoArray", "", "a", "([Lbz0/c;)V", "Lez0/c;", "rsp", "b", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuffer;", "stringBuffer", "<init>", "()V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f237409c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f237410d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private StringBuffer stringBuffer = new StringBuffer();

    static {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(33, 200, 167, 235, 55, 234, 263);
        f237409c = mutableListOf;
        f237410d = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).isSwitchOn(ICGameQMCCConfigKeysKt.KEY_ICGAME_PUSH_MSG_LOG_SWITCH, true);
    }

    private final void a(bz0.c[] infoArray) {
        if (infoArray.length > 20) {
            return;
        }
        for (bz0.c cVar : infoArray) {
            if (f237409c.contains(Integer.valueOf(cVar.f29441b))) {
                StringBuffer stringBuffer = this.stringBuffer;
                stringBuffer.append(cVar.f29445f + "-" + cVar.f29441b + "-" + cVar.f29440a + "-" + cVar.f29446g);
                stringBuffer.append(" ");
            }
        }
        if (TextUtils.isEmpty(this.stringBuffer)) {
            return;
        }
        rt0.a.INSTANCE.j("ICGamePush|ICGameLiveRoomPushMsgPrinter", String.valueOf(this.stringBuffer));
        StringBuffer stringBuffer2 = this.stringBuffer;
        stringBuffer2.delete(0, stringBuffer2.length());
    }

    public final void b(@Nullable ez0.c rsp) {
        bz0.c[] cVarArr;
        bz0.c[] cVarArr2;
        if (!f237410d) {
            return;
        }
        if (rsp != null && (cVarArr2 = rsp.f397458c) != null) {
            a(cVarArr2);
        }
        if (rsp != null && (cVarArr = rsp.f397457b) != null) {
            a(cVarArr);
        }
    }
}
