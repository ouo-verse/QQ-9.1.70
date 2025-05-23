package com.tencent.mobileqq.aio.msg.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsStatusEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0004\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msg/service/p;", "T", "Lcom/tencent/aio/msgservice/h;", "", "e", "Z", "d", "()Z", "isSuccess", "", "f", "I", "c", "()I", "result", "", "g", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "errMsg", "", tl.h.F, "Ljava/util/List;", "a", "()Ljava/util/List;", "dataList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "status", "<init>", "(ZILjava/lang/String;Ljava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class p<T> extends com.tencent.aio.msgservice.h<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String errMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<T> dataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GetMsgsStatusEnum status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(boolean z16, int i3, @Nullable String str, @NotNull List<? extends T> dataList, @Nullable GetMsgsStatusEnum getMsgsStatusEnum) {
        super(z16, i3, str, dataList);
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, dataList, getMsgsStatusEnum);
            return;
        }
        this.isSuccess = z16;
        this.result = i3;
        this.errMsg = str;
        this.dataList = dataList;
        this.status = getMsgsStatusEnum;
    }

    @Override // com.tencent.aio.msgservice.h
    @NotNull
    public List<T> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dataList;
    }

    @Override // com.tencent.aio.msgservice.h
    @Nullable
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.errMsg;
    }

    @Override // com.tencent.aio.msgservice.h
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.result;
    }

    @Override // com.tencent.aio.msgservice.h
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    @Nullable
    public GetMsgsStatusEnum e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (GetMsgsStatusEnum) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.status;
    }
}
