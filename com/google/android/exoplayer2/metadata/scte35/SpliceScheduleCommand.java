package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i3) {
            return new SpliceScheduleCommand[i3];
        }
    };
    public final List<Event> events;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        /* JADX INFO: Access modifiers changed from: private */
        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }

        ComponentSplice(int i3, long j3) {
            this.componentTag = i3;
            this.utcSpliceTime = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i3 = 0; i3 < readUnsignedByte; i3++) {
            arrayList.add(Event.parseFromSection(parsableByteArray));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i16 = 0; i16 < size; i16++) {
            this.events.get(i16).writeToParcel(parcel);
        }
    }

    SpliceScheduleCommand(List<Event> list) {
        this.events = Collections.unmodifiableList(list);
    }

    SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        Event(long j3, boolean z16, boolean z17, boolean z18, List<ComponentSplice> list, long j16, boolean z19, long j17, int i3, int i16, int i17) {
            this.spliceEventId = j3;
            this.spliceEventCancelIndicator = z16;
            this.outOfNetworkIndicator = z17;
            this.programSpliceFlag = z18;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j16;
            this.autoReturn = z19;
            this.breakDurationUs = j17;
            this.uniqueProgramId = i3;
            this.availNum = i16;
            this.availsExpected = i17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            boolean z16;
            ArrayList arrayList;
            boolean z17;
            long j3;
            boolean z18;
            long j16;
            int i3;
            int i16;
            int i17;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            long j17;
            boolean z29;
            long j18;
            boolean z36;
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z16) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if ((readUnsignedByte & 128) != 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if ((readUnsignedByte & 64) != 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if ((readUnsignedByte & 32) != 0) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (z27) {
                    j17 = parsableByteArray.readUnsignedInt();
                } else {
                    j17 = -9223372036854775807L;
                }
                if (!z27) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    for (int i18 = 0; i18 < readUnsignedByte2; i18++) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z28) {
                    long readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if ((128 & readUnsignedByte3) != 0) {
                        z36 = true;
                    } else {
                        z36 = false;
                    }
                    j18 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z29 = z36;
                } else {
                    z29 = false;
                    j18 = -9223372036854775807L;
                }
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                z19 = z27;
                i17 = parsableByteArray.readUnsignedByte();
                j16 = j18;
                arrayList = arrayList2;
                long j19 = j17;
                i3 = readUnsignedShort;
                i16 = readUnsignedByte4;
                j3 = j19;
                boolean z37 = z26;
                z18 = z29;
                z17 = z37;
            } else {
                arrayList = arrayList2;
                z17 = false;
                j3 = -9223372036854775807L;
                z18 = false;
                j16 = -9223372036854775807L;
                i3 = 0;
                i16 = 0;
                i17 = 0;
                z19 = false;
            }
            return new Event(readUnsignedInt, z16, z17, z19, arrayList, j3, z18, j16, i3, i16, i17);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.componentSpliceList.get(i3).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
