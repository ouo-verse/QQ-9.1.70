package ev1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.c;
import com.tencent.mobileqq.troop.avatar.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lev1/b;", "Lcom/tencent/mobileqq/troop/avatar/b;", "Lcom/tencent/common/app/AppInterface;", "app", "", "", "c", "", "e", "Ljava/net/HttpURLConnection;", "con", "Lcom/tencent/mobileqq/troop/avatar/TroopUploadingThread$b;", "state", "Lcom/tencent/mobileqq/troop/avatar/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Lev1/a;", "Lev1/a;", "task", "d", "Ljava/lang/String;", "host", "cookie", "<init>", "(Lev1/a;Ljava/lang/String;Ljava/lang/String;)V", "f", "a", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends com.tencent.mobileqq.troop.avatar.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a task;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String cookie;

    public b(@NotNull a task, @NotNull String host, @NotNull String cookie) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        this.task = task;
        this.host = host;
        this.cookie = cookie;
        c cVar = new c();
        cVar.d(host);
        cVar.c(cookie);
        this.f294540b = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac A[RETURN] */
    @Override // com.tencent.mobileqq.troop.avatar.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(@NotNull HttpURLConnection con, @NotNull TroopUploadingThread.b state, @NotNull g item) {
        boolean z16;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Intrinsics.checkNotNullParameter(con, "con");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(item, "item");
        if (con.getResponseCode() == 200) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            InputStream inputStream = con.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "con.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader2 = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                bufferedReader2 = bufferedReader;
            }
        } else if (!z16) {
            InputStream errorStream = con.getErrorStream();
            Intrinsics.checkNotNullExpressionValue(errorStream, "con.errorStream");
            Reader inputStreamReader2 = new InputStreamReader(errorStream, Charsets.UTF_8);
            if (inputStreamReader2 instanceof BufferedReader) {
                bufferedReader2 = (BufferedReader) inputStreamReader2;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader2, 8192);
                bufferedReader2 = bufferedReader;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        try {
            try {
                this.task.getTaskState().f230934d = TextStreamsKt.readText(bufferedReader2);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    bufferedReader2.close();
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    th = th5;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th));
                    con.disconnect();
                    if (z16) {
                    }
                }
            } catch (Throwable th6) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    bufferedReader2.close();
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th7) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th7));
                }
                con.disconnect();
                throw th6;
            }
        } catch (IOException unused) {
            Logger.f235387a.d().d("UrlActionAdapter", 1, "getResult read content fails");
            try {
                Result.Companion companion5 = Result.INSTANCE;
                bufferedReader2.close();
                Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th8) {
                th = th8;
                Result.Companion companion22 = Result.INSTANCE;
                Result.m476constructorimpl(ResultKt.createFailure(th));
                con.disconnect();
                if (z16) {
                }
            }
        }
        con.disconnect();
        if (z16) {
            return 0;
        }
        return con.getResponseCode();
    }

    @Override // com.tencent.mobileqq.troop.avatar.b
    @NotNull
    public List<String> c(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        throw new IllegalStateException("never reach here".toString());
    }

    @Override // com.tencent.mobileqq.troop.avatar.b
    public void e(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        throw new IllegalStateException("never reach here".toString());
    }
}
