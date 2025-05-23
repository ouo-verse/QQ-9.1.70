package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() { // from class: com.google.android.exoplayer2.metadata.emsg.EventMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int i3) {
            return new EventMessage[i3];
        }
    };
    public final long durationMs;
    private int hashCode;

    /* renamed from: id, reason: collision with root package name */
    public final long f32944id;
    public final byte[] messageData;
    public final long presentationTimeUs;
    public final String schemeIdUri;
    public final String value;

    public EventMessage(String str, String str2, long j3, long j16, byte[] bArr, long j17) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j3;
        this.f32944id = j16;
        this.messageData = bArr;
        this.presentationTimeUs = j17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.presentationTimeUs == eventMessage.presentationTimeUs && this.durationMs == eventMessage.durationMs && this.f32944id == eventMessage.f32944id && Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) && Util.areEqual(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = (527 + i3) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            long j3 = this.presentationTimeUs;
            int i18 = (((i17 + i16) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j16 = this.durationMs;
            int i19 = (i18 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
            long j17 = this.f32944id;
            this.hashCode = ((i19 + ((int) (j17 ^ (j17 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.presentationTimeUs);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.f32944id);
        parcel.writeByteArray(this.messageData);
    }

    EventMessage(Parcel parcel) {
        this.schemeIdUri = parcel.readString();
        this.value = parcel.readString();
        this.presentationTimeUs = parcel.readLong();
        this.durationMs = parcel.readLong();
        this.f32944id = parcel.readLong();
        this.messageData = parcel.createByteArray();
    }
}
