package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQStoryCmdHandler {

    /* renamed from: a, reason: collision with root package name */
    public Set<Integer> f93995a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, com.tencent.biz.qqstory.channel.c> f93996b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private AtomicInteger f93997c = new AtomicInteger(100);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class IllegalUinException extends Exception {
        public IllegalUinException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends Job<Object, Object, Object> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqstory.channel.c f93998d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, com.tencent.biz.qqstory.channel.c cVar) {
            super(str);
            this.f93998d = cVar;
        }

        @Override // com.tribe.async.async.Job
        protected Object doInBackground(@NonNull JobContext jobContext, @Nullable Object... objArr) {
            this.f93998d.e().a(880001, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends SimpleJob {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqstory.channel.c f94000d;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a extends Job<Object, Object, Object> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IllegalUinException f94002d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, IllegalUinException illegalUinException) {
                super(str);
                this.f94002d = illegalUinException;
            }

            @Override // com.tribe.async.async.Job
            protected Object doInBackground(@NonNull JobContext jobContext, @Nullable Object... objArr) {
                hd0.c.t("Q.qqstory.net:QQStoryCmdHandler", "uin convert error");
                b.this.f94000d.e().a(880002, this.f94002d.getMessage(), null);
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, com.tencent.biz.qqstory.channel.c cVar) {
            super(str);
            this.f94000d = cVar;
        }

        @Override // com.tribe.async.async.Job
        protected Object doInBackground(@NonNull JobContext jobContext, @Nullable Void[] voidArr) {
            try {
                byte[] d16 = this.f94000d.d();
                Integer valueOf = Integer.valueOf(QQStoryCmdHandler.this.f93997c.getAndIncrement());
                AppInterface a16 = QQStoryContext.a();
                NewIntent newIntent = new NewIntent(a16.getApp(), com.tencent.biz.qqstory.channel.d.class);
                newIntent.putExtra("storySeq", valueOf);
                newIntent.putExtra("cmd", this.f94000d.a());
                newIntent.putExtra("data", d16);
                newIntent.putExtra("start_time", System.currentTimeMillis());
                if (QQStoryCmdHandler.this.f93995a.contains(Integer.valueOf(this.f94000d.b()))) {
                    newIntent.putExtra("timeout", 10000L);
                    newIntent.putExtra("support_retry", true);
                } else {
                    long j3 = this.f94000d.f94016b;
                    if (j3 > 0) {
                        newIntent.putExtra("timeout", j3);
                    }
                }
                QQStoryCmdHandler.this.f93996b.put(valueOf, this.f94000d);
                a16.startServlet(newIntent);
                return null;
            } catch (IllegalUinException e16) {
                Bosses.get().scheduleJobDelayed(new a("Q.qqstory.net:QQStoryCmdHandler", e16), 100);
                return null;
            }
        }

        @Override // com.tribe.async.async.Job
        public int getJobType() {
            return 16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c extends SimpleJob<Void> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f94004d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f94005e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Bundle bundle, byte[] bArr) {
            super(str);
            this.f94004d = bundle;
            this.f94005e = bArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(@NonNull JobContext jobContext, @Nullable Void... voidArr) {
            com.tencent.biz.qqstory.channel.c cVar = (com.tencent.biz.qqstory.channel.c) QQStoryCmdHandler.this.f93996b.remove(Integer.valueOf(this.f94004d.getInt("storySeq")));
            if (cVar != null) {
                QQStoryCmdHandler.this.e(cVar, this.f94005e, this.f94004d);
                return null;
            }
            hd0.c.t("Q.qqstory.net:QQStoryCmdHandler", "can't find request");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends SimpleJob<Void> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqstory.channel.c f94007d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, com.tencent.biz.qqstory.channel.c cVar) {
            super(str);
            this.f94007d = cVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(@NonNull JobContext jobContext, @Nullable Void... voidArr) {
            QQStoryCmdHandler.this.h(this.f94007d);
            return null;
        }
    }

    private void d(com.tencent.biz.qqstory.channel.c cVar, int i3, String str, long j3) {
        id0.a.k("story_net", cVar.a(), 0, i3, str, String.valueOf(j3), id0.a.d(BaseApplication.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.tencent.biz.qqstory.channel.c cVar, byte[] bArr, Bundle bundle) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis() - bundle.getLong("start_time");
        int i16 = bundle.getInt("data_error_code");
        com.tencent.biz.qqstory.channel.a aVar = null;
        if (i16 != 0) {
            String string = bundle.getString("data_error_msg");
            if ((i16 == 2901 || i16 == 1002 || i16 == 1003) && f(cVar)) {
                hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + cVar.a() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", Integer.valueOf(i16), string, Long.valueOf(currentTimeMillis), Integer.valueOf(cVar.f94018d));
                cVar.f94018d = cVar.f94018d + 1;
                Boss boss = Bosses.get();
                d dVar = new d("Q.qqstory.net:QQStoryCmdHandler", cVar);
                if (i16 == 2901) {
                    i3 = 500;
                } else {
                    i3 = 2000;
                }
                boss.scheduleJobDelayed(dVar, i3);
                return;
            }
            cVar.e().a(i16, HardCodeUtil.qqStr(R.string.r4k), null);
            hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + cVar.a() + " channel error:%d, msg:%s, take time:%d", Integer.valueOf(i16), string, Long.valueOf(currentTimeMillis));
            d(cVar, i16, string, currentTimeMillis);
            return;
        }
        if (bArr != null && bArr.length != 0) {
            try {
                aVar = cVar.c(bArr);
            } catch (Exception e16) {
                hd0.c.h("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", e16);
            }
            if (aVar == null) {
                hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", cVar.a());
                d(cVar, 940002, "response is null", currentTimeMillis);
                return;
            }
            if (aVar.f94009a == 0) {
                hd0.c.e("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", cVar.a(), Long.valueOf(currentTimeMillis), Integer.valueOf(bArr.length), aVar);
            } else {
                hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", cVar.a(), Integer.valueOf(aVar.f94009a), aVar.f94010b, Long.valueOf(currentTimeMillis), Integer.valueOf(bArr.length));
                if (aVar.f94009a == 10001) {
                    hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", cVar.a(), cVar);
                }
            }
            cVar.e().a(aVar.f94009a, aVar.f94010b, aVar);
            d(cVar, aVar.f94009a, aVar.f94010b, currentTimeMillis);
            return;
        }
        cVar.e().a(-1, "channel error null data", null);
        hd0.c.v("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + cVar.a() + " channel error null data, take time:%d", Long.valueOf(currentTimeMillis));
        d(cVar, 940002, "rsp data error", currentTimeMillis);
    }

    private boolean f(com.tencent.biz.qqstory.channel.c cVar) {
        if (this.f93995a.contains(Integer.valueOf(cVar.b())) && cVar.f94018d < cVar.f94017c) {
            return true;
        }
        return false;
    }

    public void g(Bundle bundle, byte[] bArr) {
        Bosses.get().postJob(new c("Q.qqstory.net:QQStoryCmdHandler", bundle, bArr));
    }

    public void h(com.tencent.biz.qqstory.channel.c cVar) {
        try {
            if (!e.a(QQStoryContext.h().b())) {
                Bosses.get().scheduleJobDelayed(new a("Q.qqstory.net:QQStoryCmdHandler", cVar), 100);
            } else {
                Bosses.get().postJob(new b("Q.qqstory.net:QQStoryCmdHandler", cVar));
            }
        } catch (RuntimeException e16) {
            hd0.c.g("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + cVar.a() + " error:" + e16.getMessage());
            cVar.e().a(940001, e16.getMessage(), null);
        }
    }
}
