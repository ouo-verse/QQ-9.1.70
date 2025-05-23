package com.tencent.kuikly.core;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0013JL\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0012\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "", "delegate", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "getDelegate", "()Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "setDelegate", "(Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;)V", "callKotlinMethod", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "triggerRegisterPages", "Delegate", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IKuiklyCoreEntry {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "", "callNative", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface Delegate {
        Object callNative(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);
    }

    void callKotlinMethod(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5);

    Delegate getDelegate();

    void setDelegate(Delegate delegate);

    void triggerRegisterPages();
}
