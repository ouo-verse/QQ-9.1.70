package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes2.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.PrivateCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivateCommand[] newArray(int i3) {
            return new PrivateCommand[i3];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int i3, long j3) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int i16 = i3 - 4;
        byte[] bArr = new byte[i16];
        parsableByteArray.readBytes(bArr, 0, i16);
        return new PrivateCommand(readUnsignedInt, bArr, j3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeInt(this.commandBytes.length);
        parcel.writeByteArray(this.commandBytes);
    }

    PrivateCommand(long j3, byte[] bArr, long j16) {
        this.ptsAdjustment = j16;
        this.identifier = j3;
        this.commandBytes = bArr;
    }

    PrivateCommand(Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.commandBytes = bArr;
        parcel.readByteArray(bArr);
    }
}
