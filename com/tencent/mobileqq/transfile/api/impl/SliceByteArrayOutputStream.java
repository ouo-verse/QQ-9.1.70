package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\nH\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/transfile/api/impl/SliceByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "sliceSize", "", "bytesProcessor", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bytes", "", "(ILkotlin/jvm/functions/Function1;)V", "getBytesProcessor", "()Lkotlin/jvm/functions/Function1;", "setBytesProcessor", "(Lkotlin/jvm/functions/Function1;)V", "getSliceSize", "()I", "setSliceSize", "(I)V", "slice", k.f247492f, "b", DebugKt.DEBUG_PROPERTY_VALUE_OFF, c.E, "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class SliceByteArrayOutputStream extends ByteArrayOutputStream {
    static IPatchRedirector $redirector_;

    @Nullable
    private Function1<? super byte[], Unit> bytesProcessor;
    private int sliceSize;

    public SliceByteArrayOutputStream(int i3, @Nullable Function1<? super byte[], Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) function1);
        } else {
            this.sliceSize = i3;
            this.bytesProcessor = function1;
        }
    }

    private final void slice() {
        Function1<? super byte[], Unit> function1 = this.bytesProcessor;
        if (function1 != null && size() >= this.sliceSize) {
            byte[] byteArray = toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
            function1.invoke(byteArray);
            reset();
        }
    }

    @Nullable
    public final Function1<byte[], Unit> getBytesProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function1) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bytesProcessor;
    }

    public final int getSliceSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.sliceSize;
    }

    public final void setBytesProcessor(@Nullable Function1<? super byte[], Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function1);
        } else {
            this.bytesProcessor = function1;
        }
    }

    public final void setSliceSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.sliceSize = i3;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(@NotNull byte[] b16, int off, int len) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, b16, Integer.valueOf(off), Integer.valueOf(len));
            return;
        }
        Intrinsics.checkNotNullParameter(b16, "b");
        super.write(b16, off, len);
        slice();
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, b16);
        } else {
            super.write(b16);
            slice();
        }
    }
}
