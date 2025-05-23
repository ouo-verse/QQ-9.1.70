package com.tencent.mobileqq.zplan.easteregg.repository;

import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.d;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/a;", "", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "Lhh3/a;", "listener", "", "c", "f", "e", "d", "Lcom/tencent/mobileqq/zplan/easteregg/repository/LocalRepository;", "a", "Lcom/tencent/mobileqq/zplan/easteregg/repository/LocalRepository;", "localRepository", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository;", "b", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository;", "remoteRepository", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository;", "recordRepository", "<init>", "(Lcom/tencent/mobileqq/zplan/easteregg/repository/LocalRepository;Lcom/tencent/mobileqq/zplan/easteregg/repository/RemoteRepository;Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LocalRepository localRepository;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RemoteRepository remoteRepository;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RecordRepository recordRepository;

    public a(LocalRepository localRepository, RemoteRepository remoteRepository, RecordRepository recordRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        Intrinsics.checkNotNullParameter(remoteRepository, "remoteRepository");
        Intrinsics.checkNotNullParameter(recordRepository, "recordRepository");
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.recordRepository = recordRepository;
    }

    private final void c(d param, hh3.a listener) {
        this.localRepository.c(param, new C9171a(listener, param, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(d param, hh3.a listener) {
        this.recordRepository.t(param, new b(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(d param, hh3.a listener) {
        this.remoteRepository.k(param, new c(listener, this, param));
    }

    public void d(d param, hh3.a listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        c(param, listener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/a$a", "Lhh3/a;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "resultData", "", "b", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.easteregg.repository.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9171a implements hh3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hh3.a f333066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f333067b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f333068c;

        C9171a(hh3.a aVar, d dVar, a aVar2) {
            this.f333066a = aVar;
            this.f333067b = dVar;
            this.f333068c = aVar2;
        }

        @Override // hh3.a
        public void a(PortraitSource source, String errMsg) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f333066a.a(PortraitSource.LOCAL, errMsg);
        }

        @Override // hh3.a
        public void b(ResultData resultData) {
            Pair<String, Long> b16;
            if ((resultData != null ? resultData.getCode() : null) == ResultCode.SUCCESS) {
                this.f333066a.b(resultData);
                return;
            }
            d dVar = this.f333067b;
            if (resultData != null && (b16 = resultData.b()) != null) {
                dVar = d.INSTANCE.a(this.f333067b, b16);
            }
            this.f333068c.f(dVar, this.f333066a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/a$b", "Lhh3/a;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "resultData", "", "b", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements hh3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hh3.a f333069a;

        b(hh3.a aVar) {
            this.f333069a = aVar;
        }

        @Override // hh3.a
        public void a(PortraitSource source, String errMsg) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f333069a.a(PortraitSource.RECORD, errMsg);
        }

        @Override // hh3.a
        public void b(ResultData resultData) {
            if ((resultData != null ? resultData.getCode() : null) == ResultCode.SUCCESS) {
                this.f333069a.b(resultData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/a$c", "Lhh3/a;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "resultData", "", "b", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements hh3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hh3.a f333070a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f333071b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f333072c;

        c(hh3.a aVar, a aVar2, d dVar) {
            this.f333070a = aVar;
            this.f333071b = aVar2;
            this.f333072c = dVar;
        }

        @Override // hh3.a
        public void a(PortraitSource source, String errMsg) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f333070a.a(PortraitSource.REMOTE, errMsg);
        }

        @Override // hh3.a
        public void b(ResultData resultData) {
            if ((resultData != null ? resultData.getCode() : null) != ResultCode.SUCCESS) {
                this.f333071b.e(this.f333072c, this.f333070a);
            } else {
                this.f333070a.b(resultData);
            }
        }
    }
}
