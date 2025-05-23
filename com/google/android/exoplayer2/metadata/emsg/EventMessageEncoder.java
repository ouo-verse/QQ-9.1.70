package com.google.android.exoplayer2.metadata.emsg;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.byteArrayOutputStream = byteArrayOutputStream;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream, long j3) throws IOException {
        dataOutputStream.writeByte(((int) (j3 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j3 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j3 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j3) & 255);
    }

    @Nullable
    public byte[] encode(EventMessage eventMessage, long j3) {
        boolean z16;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            writeNullTerminatedString(this.dataOutputStream, str);
            writeUnsignedInt(this.dataOutputStream, j3);
            writeUnsignedInt(this.dataOutputStream, Util.scaleLargeTimestamp(eventMessage.presentationTimeUs, j3, 1000000L));
            writeUnsignedInt(this.dataOutputStream, Util.scaleLargeTimestamp(eventMessage.durationMs, j3, 1000L));
            writeUnsignedInt(this.dataOutputStream, eventMessage.f32944id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e16) {
            throw new RuntimeException(e16);
        }
    }
}
