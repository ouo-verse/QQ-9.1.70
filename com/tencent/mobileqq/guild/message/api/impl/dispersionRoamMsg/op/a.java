package com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.f;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final AppRuntime f230176a;

    /* renamed from: b, reason: collision with root package name */
    protected final AbstractC7847a f230177b;

    /* renamed from: c, reason: collision with root package name */
    protected final String f230178c;

    /* renamed from: d, reason: collision with root package name */
    protected final String f230179d;

    /* renamed from: e, reason: collision with root package name */
    protected tt1.a f230180e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC7847a {
        public abstract void a(b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f230181a;

        /* renamed from: b, reason: collision with root package name */
        private String f230182b;

        public int a() {
            return this.f230181a;
        }

        public String b() {
            return this.f230182b;
        }

        public void c(int i3) {
            this.f230181a = i3;
        }

        public void d(String str) {
            this.f230182b = str;
        }
    }

    public a(AppRuntime appRuntime, tt1.a aVar, AbstractC7847a abstractC7847a) {
        this.f230176a = appRuntime;
        this.f230180e = aVar;
        this.f230178c = aVar.i();
        this.f230179d = this.f230180e.h();
        this.f230177b = abstractC7847a;
    }

    protected abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public f b() {
        return ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230176a).F(10014)).y(10014);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.f230180e.k().size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(MessageRecord messageRecord) {
        this.f230180e.k().put(Long.valueOf(messageRecord.shmsgseq), messageRecord);
    }

    public int e() {
        return a();
    }
}
