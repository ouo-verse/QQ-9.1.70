package com.tencent.mobileqq.guild.message.registerproxy;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicLong f230762c = new AtomicLong(1);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<f> f230763a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final AppInterface f230764b;

    public a(AppInterface appInterface) {
        this.f230764b = appInterface;
        QLog.i("GuildChannelMsgProcesser", 1, "GuildChannelMsgProcesser cpuNumber:" + Runtime.getRuntime().availableProcessors());
    }

    public void a(f fVar) {
        synchronized (this.f230763a) {
            if (!this.f230763a.contains(fVar)) {
                this.f230763a.add(fVar);
            }
        }
    }

    public void b(f fVar) {
        synchronized (this.f230763a) {
            this.f230763a.remove(fVar);
        }
    }
}
