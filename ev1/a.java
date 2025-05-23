package ev1;

import android.os.SystemClock;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.f;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lev1/a;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/troop/TroopClipPic;", "Lkotlin/collections/ArrayList;", "j", "", "i", h.F, "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$d;", "k", "Ljava/util/Observer;", "g", "l", "b", "a", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$e;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$e;", "uploadParam", "Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$d;", "taskState", "Lev1/b;", "c", "Lev1/b;", "urlActionAdapter", "Lcom/tencent/mobileqq/troop/avatar/f;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/mobileqq/troop/avatar/f;", "innerTask", "e", "Ljava/util/Observer;", "innerTaskObserver", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "innerState", "<init>", "(Lcom/tencent/mobileqq/guild/nt/misc/api/IUploadApi$e;)V", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements IUploadApi.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IUploadApi.e uploadParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IUploadApi.d taskState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ev1.b urlActionAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final f innerTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer innerTaskObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger innerState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ev1/a$b", "Ljava/util/Observer;", "Ljava/util/Observable;", "o", "", "state", "", "update", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Observer {
        b() {
        }

        @Override // java.util.Observer
        public void update(@NotNull Observable o16, @Nullable Object state) {
            Intrinsics.checkNotNullParameter(o16, "o");
            if (state instanceof TroopUploadingThread.b) {
                TroopUploadingThread.b bVar = (TroopUploadingThread.b) state;
                int i3 = bVar.f294520a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            a.this.taskState.f230931a = 2;
                            a.this.taskState.f230932b = bVar.f294521b;
                            IUploadApi.b bVar2 = a.this.uploadParam.f230940f;
                            a aVar = a.this;
                            bVar2.a(aVar, aVar.taskState);
                            a.this.innerTask.deleteObserver(a.this.innerTaskObserver);
                            return;
                        }
                        return;
                    }
                    a.this.taskState.f230931a = 1;
                    a.this.taskState.f230933c = 100;
                    a.this.taskState.f230932b = 0;
                    IUploadApi.b bVar3 = a.this.uploadParam.f230940f;
                    a aVar2 = a.this;
                    bVar3.a(aVar2, aVar2.taskState);
                    a.this.innerTask.deleteObserver(a.this.innerTaskObserver);
                    return;
                }
                a.this.taskState.f230931a = 0;
                a.this.taskState.f230933c = bVar.f294521b;
                IUploadApi.b bVar4 = a.this.uploadParam.f230940f;
                a aVar3 = a.this;
                bVar4.a(aVar3, aVar3.taskState);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public a(@NotNull IUploadApi.e uploadParam) {
        Intrinsics.checkNotNullParameter(uploadParam, "uploadParam");
        this.uploadParam = uploadParam;
        this.taskState = k();
        f fVar = (f) com.tencent.mobileqq.troop.avatar.h.a(f.class);
        this.innerTask = fVar;
        Observer g16 = g();
        this.innerTaskObserver = g16;
        this.innerState = new AtomicInteger(0);
        String str = uploadParam.f230935a;
        Intrinsics.checkNotNullExpressionValue(str, "uploadParam.host");
        this.urlActionAdapter = new ev1.b(this, str, h());
        fVar.addObserver(g16);
        m();
    }

    private final Observer g() {
        return new b();
    }

    private final String h() {
        StringBuilder sb5 = new StringBuilder();
        for (IUploadApi.a aVar : this.uploadParam.f230939e) {
            String encodeUrl = URLUtil.encodeUrl(aVar.f230929a);
            String encodeUrl2 = URLUtil.encodeUrl(aVar.f230930b);
            sb5.append(TokenParser.SP + encodeUrl + '=');
            StringBuilder sb6 = new StringBuilder();
            sb6.append(encodeUrl2);
            sb6.append(';');
            sb5.append(sb6.toString());
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    private final String i() {
        IUploadApi.e eVar = this.uploadParam;
        String url = eVar.f230936b;
        Map<String, String> map = eVar.f230938d;
        Intrinsics.checkNotNullExpressionValue(map, "uploadParam.queryStrings");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            url = URLUtil.addParameter(url, entry.getKey(), entry.getValue());
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    private final ArrayList<TroopClipPic> j() {
        ArrayList<TroopClipPic> arrayListOf;
        TroopClipPic troopClipPic = new TroopClipPic();
        troopClipPic.f203184id = this.uploadParam.f230937c;
        troopClipPic.f203185ts = SystemClock.uptimeMillis();
        troopClipPic.type = 104;
        troopClipPic.clipInfo = "";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopClipPic);
        return arrayListOf;
    }

    private final IUploadApi.d k() {
        IUploadApi.d dVar = new IUploadApi.d();
        dVar.f230931a = 0;
        dVar.f230933c = 0;
        dVar.f230934d = "";
        dVar.f230932b = -1;
        return dVar;
    }

    private final void m() {
        for (Map.Entry<String, String> entry : this.uploadParam.f230938d.entrySet()) {
            if (entry.getValue() == null) {
                s.e("Guild.comm.UploadTaskImpl", "query string value is null, key: " + entry.getKey(), new IllegalArgumentException());
                entry.setValue("");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.c
    @NotNull
    /* renamed from: a, reason: from getter */
    public IUploadApi.d getTaskState() {
        return this.taskState;
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.c
    public void b() {
        if (this.innerState.compareAndSet(1, 2)) {
            this.innerTask.c(this.uploadParam.f230937c);
        }
    }

    public final void l() {
        List<String> listOf;
        if (this.innerState.compareAndSet(0, 1)) {
            f fVar = this.innerTask;
            ArrayList<TroopClipPic> j3 = j();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(i());
            fVar.d(TroopUploadingThread.class, j3, null, listOf, this.urlActionAdapter);
        }
    }
}
