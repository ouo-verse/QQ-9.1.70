package com.tencent.timi.game.liveroom.impl.room.fansqqgroup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.o;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/fansqqgroup/a;", "", "Landroid/content/Context;", "context", "", "url", "", "roomId", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f377629a = new a();

    a() {
    }

    public final void a(@NotNull Context context, @NotNull String url, long roomId) {
        int i3;
        boolean contains$default;
        boolean contains$default2;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (o.a()) {
            return;
        }
        if (context instanceof Activity) {
            i3 = ((Activity) context).getWindow().getDecorView().getHeight();
        } else {
            i3 = x.f(BaseApplication.getContext()).f185861b;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("height_web_dialog", c.e(i3 * 0.6f));
        bundle.putBoolean("transparent_web_bg", false);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) AudienceReportConst.ROOM_ID, false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (contains$default2) {
                str = url + "&room_id=" + roomId;
            } else {
                str = url + "?room_id=" + roomId;
            }
        } else {
            str = url + roomId;
        }
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(context, str, bundle);
    }
}
