package com.tencent.mobileqq.zplan.emoticon.panel.repository;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import t74.r;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J<\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u0014H\u0016J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002R0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u001ej\b\u0012\u0004\u0012\u00020\u0006`\u001f0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/AbsRepository;", "", "url", "", "k", "Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory$a;", "listener", "", "g", DomainData.DOMAIN_NAME, "", "code", "bgPath", "fgPath", "l", "Lcom/tencent/mobileqq/zplan/model/e;", "info", "uin", h.F, "Lkotlin/Function3;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "from", "errCode", "errMsg", "o", "selfUin", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "sListenerMap", "Ljava/lang/Object;", "d", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticon2DFactory extends AbsRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final ZPlanEmoticon2DFactory f333159b = new ZPlanEmoticon2DFactory();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, HashSet<a>> sListenerMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Object lock = new Object();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/repository/ZPlanEmoticon2DFactory$a;", "", "", "bgResDir", "fgResDir", "", "b", "", "errCode", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(int errCode, String errMsg);

        void b(String bgResDir, String fgResDir);
    }

    ZPlanEmoticon2DFactory() {
    }

    private final synchronized void g(String url, a listener) {
        if (listener == null) {
            return;
        }
        synchronized (lock) {
            ConcurrentHashMap<String, HashSet<a>> concurrentHashMap = sListenerMap;
            HashSet<a> hashSet = concurrentHashMap.get(url);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                concurrentHashMap.put(url, hashSet);
            }
            if (!hashSet.contains(listener)) {
                hashSet.add(listener);
                QLog.i("ZPlanEmoticon2DFactory", 1, "add listener, " + listener + ", size=" + hashSet.size() + ", url=" + url);
            } else {
                QLog.i("ZPlanEmoticon2DFactory", 1, "add listener, already added, " + listener + ", size=" + hashSet.size() + ", url=" + url);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZPlanActionInfo info, String selfUin, int i3) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        String f16 = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.f(info, selfUin);
        ZPlanEmoticon2DFactory zPlanEmoticon2DFactory = f333159b;
        File file = new File(zPlanEmoticon2DFactory.a(f16, info.getId()));
        if (file.exists()) {
            FileUtils.deleteDirectory(file.getAbsolutePath());
        }
        QLog.w("ZPlanEmoticon2DFactory", 1, "handleEncodeResult code=" + i3 + ", path=" + file.getAbsolutePath());
        zPlanEmoticon2DFactory.o("encode", i3, "");
    }

    private final boolean k(String url) {
        boolean containsKey;
        synchronized (lock) {
            containsKey = sListenerMap.containsKey(url);
        }
        return containsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String url, int code, String bgPath, String fgPath) {
        HashSet<a> hashSet;
        synchronized (lock) {
            hashSet = sListenerMap.get(url);
            HashSet<a> hashSet2 = hashSet;
            QLog.i("ZPlanEmoticon2DFactory", 1, "notifyListener, size=" + (hashSet2 != null ? Integer.valueOf(hashSet2.size()) : null) + ", url=" + url);
            f333159b.n(url);
            Unit unit = Unit.INSTANCE;
        }
        HashSet<a> hashSet3 = hashSet;
        if (hashSet3 != null) {
            for (a aVar : hashSet3) {
                if (code == 0) {
                    aVar.b(bgPath, fgPath);
                } else {
                    aVar.a(code, "load path failed");
                }
            }
        }
    }

    private final synchronized void n(String url) {
        synchronized (lock) {
            ConcurrentHashMap<String, HashSet<a>> concurrentHashMap = sListenerMap;
            if (concurrentHashMap.containsKey(url)) {
                concurrentHashMap.remove(url);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void h(ZPlanActionInfo info, String uin, a listener) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(uin, "uin");
        com.tencent.mobileqq.zplan.emoticon.panel.util.a aVar = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a;
        if (!aVar.h(info, uin)) {
            QLog.i("ZPlanEmoticon2DFactory", 1, "emo2DInfo is null, no need resource, info=" + info);
            if (listener != null) {
                listener.b("", "");
                return;
            }
            return;
        }
        String f16 = aVar.f(info, uin);
        synchronized (lock) {
            ZPlanEmoticon2DFactory zPlanEmoticon2DFactory = f333159b;
            Intrinsics.checkNotNull(f16);
            if (zPlanEmoticon2DFactory.k(f16)) {
                zPlanEmoticon2DFactory.g(f16, listener);
                QLog.i("ZPlanEmoticon2DFactory", 1, "emo2DInfo is loading, info=" + info);
                return;
            }
            zPlanEmoticon2DFactory.g(f16, listener);
            Unit unit = Unit.INSTANCE;
            m(info, uin, new ZPlanEmoticon2DFactory$getEmoRes$2(f16));
        }
    }

    public final void i(final int code, final ZPlanActionInfo info, final String selfUin) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        if (code == -18009 || code == -18001) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEmoticon2DFactory.j(ZPlanActionInfo.this, selfUin, code);
                }
            }, 64, null, false);
        }
    }

    public void m(final ZPlanActionInfo info, final String uin, final Function3<? super Integer, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.emoticon.panel.repository.a.f333162b.e(info, uin, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory$query$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                invoke(num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str, String str2) {
                if (i3 == 0) {
                    callback.invoke(Integer.valueOf(i3), str, str2);
                    ZPlanEmoticon2DFactory.f333159b.o("local", 0, "");
                    return;
                }
                Emoticon2DRemoteRepository emoticon2DRemoteRepository = Emoticon2DRemoteRepository.f333153b;
                ZPlanActionInfo zPlanActionInfo = info;
                String str3 = uin;
                final Function3<Integer, String, String, Unit> function3 = callback;
                emoticon2DRemoteRepository.i(zPlanActionInfo, str3, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.repository.ZPlanEmoticon2DFactory$query$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str4, String str5) {
                        invoke(num.intValue(), str4, str5);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i16, String str4, String str5) {
                        function3.invoke(Integer.valueOf(i16), str4, str5);
                        ZPlanEmoticon2DFactory.f333159b.o("network", i16, str4);
                    }
                });
            }
        });
    }

    public final void o(String from, int errCode, String errMsg) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(from, "from");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("from", from), TuplesKt.to("code", String.valueOf(errCode)), TuplesKt.to("msg", String.valueOf(errMsg)));
        r.e(null, "zplan_emoticon_2D_load_resource", mapOf, 1, null);
    }
}
