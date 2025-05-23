package b33;

import com.tencent.state.square.record.CloudRecordResult;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\t"}, d2 = {"Lcu4/c;", "Lcom/tencent/state/square/record/CloudRecordResult;", "a", "", "type", "Lcom/tencent/zplan/meme/action/MODE;", "b", "mode", "c", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27844a;

        static {
            int[] iArr = new int[MODE.values().length];
            try {
                iArr[MODE.FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MODE.MP4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27844a = iArr;
        }
    }

    public static final CloudRecordResult a(cu4.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        RecordIdentifier recordIdentifier = new RecordIdentifier(new UserIdentifier(currentAccountUin, null, 2, null), null, 0, null, false, 30, null);
        UserIdentifier sender = recordIdentifier.getSender();
        String dressKey = cVar.f391874e;
        Intrinsics.checkNotNullExpressionValue(dressKey, "dressKey");
        sender.forceDressKey(dressKey);
        int i3 = cVar.f391872c;
        int i16 = cVar.f391873d;
        String url = cVar.f391875f;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        String md5 = cVar.f391877h;
        Intrinsics.checkNotNullExpressionValue(md5, "md5");
        String frameUrl = cVar.f391878i;
        Intrinsics.checkNotNullExpressionValue(frameUrl, "frameUrl");
        String frameMd5 = cVar.f391879j;
        Intrinsics.checkNotNullExpressionValue(frameMd5, "frameMd5");
        hs4.b bVar = cVar.f391876g;
        return new CloudRecordResult(i3, i16, recordIdentifier, url, md5, frameUrl, frameMd5, bVar.f406127a, bVar.f406128b);
    }

    public static final int c(MODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i3 = a.f27844a[mode.ordinal()];
        if (i3 != 1) {
            return i3 != 2 ? 0 : 2;
        }
        return 1;
    }

    public static final MODE b(int i3) {
        if (i3 == 1) {
            return MODE.FRAME;
        }
        if (i3 != 2) {
            return null;
        }
        return MODE.MP4;
    }
}
