package ox4;

import android.util.Log;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.encode.EncodeConfig;
import com.tencent.zplan.encode.EncodeResult;
import com.tencent.zplan.encode.IEncoder;
import com.tencent.zplan.encode.h;
import com.tencent.zplan.encode.utils.c;
import com.tencent.zplan.encode.utils.d;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001d\u00a8\u0006!"}, d2 = {"Lox4/b;", "Lcom/tencent/zplan/encode/IEncoder;", "Lcom/tencent/zplan/encode/a;", DownloadInfo.spKey_Config, "", "a", "", "mode", "index", "", "pixels", "sourceWidth", "sourceHeight", "c", "totalFrame", "Lcom/tencent/zplan/encode/EncodeResult;", "e", "", "b", "", "getTypeName", "", "d", "(I)Ljava/lang/Long;", "I", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "resultLatch", "Lcom/tencent/zplan/encode/EncodeResult;", "encodeResult", "<init>", "()V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes33.dex */
public final class b implements IEncoder {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CountDownLatch resultLatch = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EncodeResult encodeResult = EncodeResult.UN_KNOW;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lox4/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: ox4.b$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, int i3, int i16) {
        EncodeResult encodeResult;
        Intrinsics.checkParameterIsNotNull(this$0, "this$0");
        if (i16 == 0) {
            encodeResult = EncodeResult.SUCCESS;
        } else {
            encodeResult = EncodeResult.ERROR;
        }
        this$0.encodeResult = encodeResult;
        this$0.resultLatch.countDown();
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public boolean a(EncodeConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        com.tencent.zplan.encode.utils.b.f385478a.a(config.getSavaPath());
        h.b bVar = new h.b();
        bVar.f385461p = config.getSavaPath();
        bVar.f385462q = config.getTempPath();
        bVar.f385447b = config.getHeight();
        bVar.f385446a = config.getWidth();
        bVar.f385448c = config.getEncodeConfig().f385470h;
        bVar.f385452g = config.getEncodeConfig().f385464b;
        bVar.f385460o = false;
        bVar.f385449d = config.getEncodeConfig().getBitRate();
        bVar.f385450e = config.getEncodeConfig().getBitRateMode();
        bVar.f385456k = config.getEncodeConfig().f385477o;
        bVar.f385455j = 1;
        bVar.f385453h = new d.i(3, 0, 1, 2);
        Integer cacheLimit = config.getCacheLimit();
        if (cacheLimit != null) {
            bVar.f385454i = cacheLimit.intValue();
        }
        this.taskId = h.d().i(bVar, new c() { // from class: ox4.a
            @Override // com.tencent.zplan.encode.utils.c
            public final void a(int i3, int i16) {
                b.g(b.this, i3, i16);
            }
        });
        return true;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public boolean c(int mode, int index, byte[] pixels, int sourceWidth, int sourceHeight) {
        Intrinsics.checkParameterIsNotNull(pixels, "pixels");
        int i3 = this.taskId;
        if (i3 <= 0) {
            Log.e("HardwareEncoder", Intrinsics.stringPlus("inputFrameToHardwareEncoder but taskId:", Integer.valueOf(i3)));
            return false;
        }
        h.d().h(this.taskId, pixels, pixels.length, index);
        return true;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public EncodeResult e(@IEncoder.EncodeMode int mode, int totalFrame) {
        int i3 = this.taskId;
        if (i3 < 0) {
            Log.e("HardwareEncoder", Intrinsics.stringPlus("inputFrameToHardwareEncoderEnd but taskId:", Integer.valueOf(i3)));
            return this.encodeResult;
        }
        h.d().g(this.taskId);
        this.resultLatch.await();
        return this.encodeResult;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public String getTypeName() {
        return "HardwareEncoder";
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public void b(int mode) {
        this.taskId = 0;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public Long d(int mode) {
        return 0L;
    }
}
