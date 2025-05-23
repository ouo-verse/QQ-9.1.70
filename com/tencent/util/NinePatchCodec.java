package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes27.dex */
public class NinePatchCodec {
    static IPatchRedirector $redirector_ = null;
    private static final int NP_CHUNK_TYPE = 1852855395;
    private static final int NP_COLOR = -16777216;

    /* loaded from: classes27.dex */
    public static class NinePatch {
        static IPatchRedirector $redirector_;
        public int[] colors;
        private byte numColors;
        private byte numXDivs;
        private byte numYDivs;
        public int padBottom;
        public int padLeft;
        public int padRight;
        public int padTop;
        private byte wasDeserialized;
        public int[] xDivs;
        public int[] yDivs;

        public NinePatch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void decode(DataInput dataInput) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataInput);
                return;
            }
            this.wasDeserialized = dataInput.readByte();
            this.numXDivs = dataInput.readByte();
            this.numYDivs = dataInput.readByte();
            this.numColors = dataInput.readByte();
            dataInput.skipBytes(8);
            this.padLeft = dataInput.readInt();
            this.padRight = dataInput.readInt();
            this.padTop = dataInput.readInt();
            this.padBottom = dataInput.readInt();
            dataInput.skipBytes(4);
            this.xDivs = new int[this.numXDivs];
            for (int i3 = 0; i3 < this.numXDivs; i3++) {
                this.xDivs[i3] = dataInput.readInt();
            }
            this.yDivs = new int[this.numYDivs];
            for (int i16 = 0; i16 < this.numYDivs; i16++) {
                this.yDivs[i16] = dataInput.readInt();
            }
            this.colors = new int[this.numColors];
            for (int i17 = 0; i17 < this.numColors; i17++) {
                this.colors[i17] = dataInput.readInt();
            }
        }

        public void encode(DataOutput dataOutput) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataOutput);
                return;
            }
            dataOutput.writeByte(this.wasDeserialized);
            dataOutput.writeByte(this.numXDivs);
            dataOutput.writeByte(this.numYDivs);
            dataOutput.writeByte(this.numColors);
            dataOutput.writeInt(0);
            dataOutput.writeInt(0);
            dataOutput.writeInt(this.padLeft);
            dataOutput.writeInt(this.padRight);
            dataOutput.writeInt(this.padTop);
            dataOutput.writeInt(this.padBottom);
            dataOutput.writeInt(0);
            for (int i3 = 0; i3 < this.numXDivs; i3++) {
                dataOutput.writeInt(this.xDivs[i3]);
            }
            for (int i16 = 0; i16 < this.numYDivs; i16++) {
                dataOutput.writeInt(this.yDivs[i16]);
            }
            for (int i17 = 0; i17 < this.numColors; i17++) {
                dataOutput.writeInt(this.colors[i17]);
            }
        }
    }

    public NinePatchCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NinePatch decodeNinePatch(InputStream inputStream) throws IOException {
        return getNinePatch(new DataInputStream(inputStream));
    }

    public static void find9patchChunk(DataInput dataInput) throws IOException {
        int i3;
        dataInput.skipBytes(8);
        while (true) {
            try {
                i3 = dataInput.readInt();
            } catch (IOException unused) {
                i3 = 0;
            }
            if (dataInput.readInt() == NP_CHUNK_TYPE) {
                return;
            } else {
                dataInput.skipBytes(i3 + 4);
            }
        }
    }

    public static NinePatch getNinePatch(DataInput dataInput) throws IOException {
        find9patchChunk(dataInput);
        NinePatch ninePatch = new NinePatch();
        ninePatch.decode(dataInput);
        return ninePatch;
    }
}
