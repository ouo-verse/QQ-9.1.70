package lo0;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JY\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Llo0/c;", "", "", "eventId", "Landroid/view/View;", "view", "id", "", "type", "uin", "remainCount", "identityGroupId", "", "a", "(Ljava/lang/String;Landroid/view/View;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f415071a = new c();

    c() {
    }

    @JvmStatic
    public static final void a(@Nullable String eventId, @Nullable View view, @Nullable String id5, int type, @Nullable String uin, @Nullable Integer remainCount, @Nullable String identityGroupId) {
        Map mutableMapOf;
        VideoReport.setElementId(view, id5);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_at_type", Integer.valueOf(type)));
        if (uin != null) {
            mutableMapOf.put("sgrp_at_touin", uin);
        }
        if (remainCount != null) {
            mutableMapOf.put("sgrp_surplus_num", Integer.valueOf(remainCount.intValue()));
        }
        if (identityGroupId != null) {
            mutableMapOf.put("sgrp_identity_group_id", identityGroupId);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(eventId, view, mutableMapOf);
    }
}
