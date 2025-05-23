package com.tencent.mobileqq.nearbypro.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.PlatformInfor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/e;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartResume", "", "action", "", "args", "handleBroadcastMessage", "", PlatformInfor.SIMPLE_MODE, "C9", "B9", "onPartPause", "onPartStop", "onPartDestroy", "key", "", "default", "A9", "d", "Lcom/tencent/mobileqq/nearbypro/part/a;", "z9", "()Lcom/tencent/mobileqq/nearbypro/part/a;", "D9", "(Lcom/tencent/mobileqq/nearbypro/part/a;)V", "e", "Z", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class e extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected a host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean concise;

    public final long A9(@NotNull String key, long r36) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(key, "key");
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (arguments = hostFragment.getArguments()) != null) {
            return arguments.getLong(key, r36);
        }
        return 0L;
    }

    /* renamed from: B9, reason: from getter */
    public final boolean getConcise() {
        return this.concise;
    }

    protected final void D9(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.host = aVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "update_map_concise_action")) {
            ga2.a c16 = j.c();
            String logTag = getLogTag();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) args;
            c16.e(logTag, "update_map_concise_action:" + bool);
            if ((args instanceof Boolean) && !Intrinsics.areEqual(Boolean.valueOf(this.concise), args)) {
                this.concise = bool.booleanValue();
                C9(bool.booleanValue());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        ga2.a c16 = j.c();
        String logTag = getLogTag();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "lifecycle-> onPartDestroy");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        ga2.a c16 = j.c();
        String logTag = getLogTag();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "lifecycle-> onPartPause");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        ga2.a c16 = j.c();
        String logTag = getLogTag();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "lifecycle-> onPartResume");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStart(activity);
        ga2.a c16 = j.c();
        String logTag = getLogTag();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "lifecycle-> onPartStart");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStop(activity);
        ga2.a c16 = j.c();
        String logTag = getLogTag();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.c(logTag, "lifecycle-> onPartStop");
    }

    public final void x9(@NotNull a host) {
        Intrinsics.checkNotNullParameter(host, "host");
        D9(host);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final a z9() {
        a aVar = this.host;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("host");
        return null;
    }

    public void C9(boolean concise) {
    }
}
