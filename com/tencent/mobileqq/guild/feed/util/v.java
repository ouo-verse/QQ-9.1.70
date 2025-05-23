package com.tencent.mobileqq.guild.feed.util;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.event.GuildFeedClickResetEvent;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class v implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static volatile v f223927d;

    v() {
        bl.c().d(this);
    }

    public static v a() {
        if (f223927d == null) {
            synchronized (v.class) {
                if (f223927d == null) {
                    f223927d = new v();
                }
            }
        }
        return f223927d;
    }

    public boolean b(@NonNull View view) {
        return ((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view);
    }

    public boolean c(@NonNull String str, long j3) {
        return ((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(str, j3);
    }

    public void d(@NonNull String str) {
        e(str, false);
    }

    public void e(@NonNull String str, boolean z16) {
        if (z16) {
            bl.c().b(new GuildFeedClickResetEvent(str), z16);
        } else {
            ((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).resetFastClick(str);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedClickResetEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedClickResetEvent) {
            d(((GuildFeedClickResetEvent) simpleBaseEvent).getTag());
        }
    }
}
