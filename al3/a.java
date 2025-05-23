package al3;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.polling.PollingManager;
import com.tencent.mobileqq.zplan.push.i;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.UpdateFrom;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import dv4.j;
import dv4.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mv4.f;
import mv4.g;
import mv4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lal3/a;", "", "", "a", "b", "Lcom/tencent/mobileqq/zplan/push/i;", "Lcom/tencent/mobileqq/zplan/push/i;", "getObserver", "()Lcom/tencent/mobileqq/zplan/push/i;", "observer", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final i observer = new b();

    public final void a() {
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.F2(this.observer);
        }
    }

    public final void b() {
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.G2(this.observer);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"al3/a$b", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends i {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"al3/a$b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: al3.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public static final class C0047a implements e<List<? extends TXVideoInfo>> {
            C0047a() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(List<TXVideoInfo> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                for (TXVideoInfo tXVideoInfo : result) {
                    ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).B0(UpdateFrom.HEART_WITH_PUSH, tXVideoInfo.getPlayInfo().getComponentId(), tXVideoInfo.getMediaInfo());
                }
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("HeartBeatTask", 1, "heart from heart :: failed , error == " + error + " , message == " + message);
            }
        }

        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            r rVar;
            j jVar;
            Intrinsics.checkNotNullParameter(buf, "buf");
            mv4.e c16 = mv4.e.c(buf);
            QLog.d("LiveStreamPushManager", 1, "ZPlanOIDBPushObserver :: push " + c16.f417675a);
            int i3 = c16.f417675a;
            if (i3 == 7) {
                l lVar = c16.f417676b;
                f fVar = lVar != null ? lVar.f417691g : null;
                QLog.d("LiveStreamPushManager", 1, "ZPlanOIDBPushObserver :: get push data => " + (fVar != null ? fVar.f417677a : null));
                if (fVar == null || (jVar = fVar.f417677a) == null) {
                    return;
                }
                VideoMediaInfo a16 = VideoMediaInfo.INSTANCE.a(jVar);
                zk3.a aVar = (zk3.a) vb3.a.f441346a.a(zk3.a.class);
                UpdateFrom updateFrom = UpdateFrom.PUSH;
                dv4.a aVar2 = jVar.f395036b;
                String str = aVar2 != null ? aVar2.f395014a : null;
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.homeUserInfo?.tvId ?: \"\"");
                }
                aVar.B0(updateFrom, str, a16);
                PollingManager.c(PollingManager.INSTANCE.a(), new com.tencent.mobileqq.zplan.polling.task.b(((zk3.a) r1.a(zk3.a.class)).a0().getInterval() * 1000), false, 2, null);
                return;
            }
            if (i3 == 11) {
                l lVar2 = c16.f417676b;
                g gVar = lVar2 != null ? lVar2.f417695k : null;
                QLog.d("LiveStreamPushManager", 1, "ZPlanOIDBPushObserver :: get push data => " + (gVar != null ? gVar.f417679a : null));
                if (gVar == null || (rVar = gVar.f417679a) == null) {
                    return;
                }
                String str2 = rVar.f395056d.f395014a;
                Intrinsics.checkNotNullExpressionValue(str2, "it.homeUserInfo.tvId");
                String str3 = rVar.f395053a;
                Intrinsics.checkNotNullExpressionValue(str3, "it.openid");
                String str4 = rVar.f395054b;
                Intrinsics.checkNotNullExpressionValue(str4, "it.ownerOpenid");
                TXVideoInfo e16 = ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().e(new VideoPlayInfo(str2, str3, str4));
                if (e16 == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(e16);
                bl3.a.f28625a.h(arrayList, new C0047a());
            }
        }

        b() {
            super(337);
        }
    }
}
